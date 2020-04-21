package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.common.exception.CommonException;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.DTO.LoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.PwdModDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.RegisterDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.StudentsDTO;
import edu.cqupt.kaoyan.sys.entity.Students;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-07
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IStudentsService extends IService<Students> {

    /**
     * 用户登陆
     *
     * @param loginDTO
     */
    Result login(LoginDTO loginDTO);

    /**
     * 根据邮箱获取用户信息
     *
     * @param stuEmail
     * @return
     */
    Students getByStuEmail(String stuEmail);

    /**
     * 更新用户基本信息
     *
     * @param studentsDTO
     */
    void updateStudents(StudentsDTO studentsDTO, Long stuId);

    /**
     * 修改用户头像
     *
     * @param multipartFile
     * @param stuId
     */
    void modHead(MultipartFile multipartFile, Long stuId);

    /**
     * 修改密码
     *
     * @param pwdModDTO
     * @param stuId
     */
    void modPwd(PwdModDTO pwdModDTO, Long stuId) throws CommonException;

    /**
     * 注册
     *
     * @param registerDTO
     */
    void register(RegisterDTO registerDTO) throws CommonException;

    /**
     * 发送验证码
     *
     * @param stuEmail
     */
    String sendMessage(String stuEmail, String type) throws CommonException;


    /**
     * 得到用户信息
     *
     * @param stuId
     * @return
     */
    Students getStudents(Long stuId);
}
