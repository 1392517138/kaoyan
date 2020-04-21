package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.exception.CommonException;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.common.system.result.ResultCode;
import edu.cqupt.kaoyan.sys.common.utils.DozerUtil;
import edu.cqupt.kaoyan.sys.common.utils.JwtUtils;
import edu.cqupt.kaoyan.sys.common.utils.ShortMessageUtil;
import edu.cqupt.kaoyan.sys.common.utils.UploadUtils;
import edu.cqupt.kaoyan.sys.entity.DTO.LoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.PwdModDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.RegisterDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.StudentsDTO;
import edu.cqupt.kaoyan.sys.entity.Students;
import edu.cqupt.kaoyan.sys.mapper.StudentsMapper;
import edu.cqupt.kaoyan.sys.service.IStudentsService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-07
 */
@Service
@Slf4j
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {
    @Autowired
    private Mapper dozerMapper;
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private ShortMessageUtil shortMessageUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JwtUtils jwtUtils;
    /**
     * 用来保存短信
     */
    private static ConcurrentHashMap<String, String> shortMessageMap = new ConcurrentHashMap<>();

    @Override
    public Result login(LoginDTO loginDTO) {
        String email = loginDTO.getStuEmail();
        String password = loginDTO.getStuPwd();
        Students students = this.getByStuEmail(email);
        //如果失败
        if (students == null || !students.getStuPwd().equals(password)) {
            return new Result(ResultCode.EMAILORPASSWORDERROR);
        } else {
            String token = jwtUtils.createJwt(students.getStuId());
            redisTemplate.opsForValue().set(students.getStuId().toString(), students, 24, TimeUnit.HOURS);
            return new Result(ResultCode.SUCCESS, token);
        }
    }

    @Override
    public Students getByStuEmail(String stuEmail) {
        Students one = getOne(Wrappers.<Students>lambdaQuery().eq(Students::getStuEmail, stuEmail), false);
        return one;
    }

    @Override
    public void updateStudents(StudentsDTO studentsDTO, Long stuId) {
        Students students = dozerMapper.map(studentsDTO, Students.class);
        students.setStuId(stuId);
        updateById(students);
        redisTemplate.opsForValue().getAndSet(stuId.toString(), students);
    }

    @Override
    public void modHead(MultipartFile multipartFile, Long stuId) {
        String stuHead = UploadUtils.uploadImage(multipartFile);
        Students students = getById(stuId);
        students.setStuHead(stuHead);
        updateById(students);
        redisTemplate.opsForValue().getAndSet(stuId.toString(), students);
    }

    @Override
    public void modPwd(PwdModDTO pwdModDTO, Long stuId) throws CommonException {
        Students students = getById(stuId);
        if (!pwdModDTO.getShortMessage().equals(shortMessageMap.get(students.getStuEmail()))) {
            throw new CommonException(ResultCode.SHORTMESSAGECODEERROR);
        }
        students.setStuPwd(pwdModDTO.getStuPwd());
        updateById(students);
        redisTemplate.opsForValue().getAndSet(stuId.toString(), students);
    }

    @Override
    public void register(RegisterDTO registerDTO) throws CommonException {
        String shortMessage = registerDTO.getShortMessage();
        String stuEmail = registerDTO.getStuEmail();
        if (!shortMessage.equals(shortMessageMap.get(stuEmail))) {
            throw new CommonException(ResultCode.SHORTMESSAGECODEERROR);
        }
        Students students = dozerMapper.map(registerDTO, Students.class);
        //保存
        save(students);
        //移除
        shortMessageMap.remove(stuEmail);
    }

    @Override
    public String sendMessage(String stuEmail, String type) throws CommonException {
        if ("register".equals(type)) {
            if (getByStuEmail(stuEmail) != null) {
                throw new CommonException(ResultCode.ALLREADYREGISTER);
            }
        }
        String code = "";
        try {
            code = shortMessageUtil.sendMail(new String[]{stuEmail});
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException(ResultCode.EMAILINPUTERROR);
        }
        //添加进map
        shortMessageMap.put(stuEmail, code);
        return code;
    }

    @Override
    public Students getStudents(Long stuId) {
        return (Students) redisTemplate.opsForValue().get(stuId.toString());
    }

}
