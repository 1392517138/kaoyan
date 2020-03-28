package edu.cqupt.kaoyan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.bcel.internal.generic.I2F;
import edu.cqupt.kaoyan.entity.User;
import edu.cqupt.kaoyan.mapper.UserMapper;
import edu.cqupt.kaoyan.service.UserService;
import edu.cqupt.kaoyan.service.mail.MailService;
import edu.cqupt.kaoyan.utils.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-26 18:48:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private MailService mailService;


    /**
     * 通过学号查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public User selectByIdCard(String useridcard) {
        User user = null;
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<User>();
            wrapper.eq("useridcard", useridcard);
            user = userMapper.selectOne(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * 注册
     *
     * @return 实例对象
     */

    @Override
    public String register(String useridcard, String password, String email, String checkCode) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {
            String nativeCode = stringRedisTemplate.opsForValue().get(email);
            if (checkCode != null && nativeCode != null) {
                if (checkCode.equals(nativeCode)) {
                    User user = new User();
                    //设置用户用户名默认为学号
                    user.setUsername(useridcard);
                    user.setUseridcard(useridcard);
                    user.setPassword(password);
                    user.setEamil(email);
                    this.userMapper.insert(user);
                } else {
                    status = 400;
                }
            } else {
                status = 400;
            }
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }

    /**
     * 修改
     */

    @Override
    public String modName(String JSESSIONID, String username) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {
            String useridcard = stringRedisTemplate.opsForValue().get(JSESSIONID);
            User user = this.selectByIdCard(useridcard);
            user.setUsername(username);
            userMapper.updateById(user);
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }


    @Override
    public String modPwd(String JSESSIONID, String password) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {


        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);

        return returnData.toJSONString();
    }

    @Override
    public String modRole(String JSESSIONID, Integer roleid) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {
            String useridcard = stringRedisTemplate.opsForValue().get(JSESSIONID);
            User user = this.selectByIdCard(useridcard);
            user.setRoleid(roleid);
            userMapper.updateById(user);
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);

        return returnData.toJSONString();
    }

    @Override
    public String modFrom(String JSESSIONID, Integer majorid, Integer collegeid) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {
            String useridcard = stringRedisTemplate.opsForValue().get(JSESSIONID);
            User user = this.selectByIdCard(useridcard);
            user.setMajorid(majorid);
            user.setCollegeid(collegeid);
            userMapper.updateById(user);
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);

        return returnData.toJSONString();
    }

    @Override
    public String login(String useridcard, String password, HttpSession session) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        User user = null;
        String key = session.getId();
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<User>();

            wrapper.eq("useridcard", useridcard)
                    .eq("password", password);
            Integer count = userMapper.selectCount(wrapper);

            if (count > 0) {
                //如果用户名密码正确，将用户id存入redis,登陆1个月有效
                stringRedisTemplate.opsForValue().set(key, useridcard, 30, TimeUnit.DAYS);
                user = this.selectByIdCard(useridcard);
            } else {
                status = 400;
            }
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("JSESSIONID", key);
        returnData.put("status", status);
        returnData.put("user", user);
        return returnData.toJSONString();
    }

    @Override
    public String sendCode(String email) {
        JSONObject returnData = new JSONObject();
        int status = 200;
        try {
            String checkCode = CheckCode.getCheckCode(5);
            //设置验证码5min有效
            stringRedisTemplate.opsForValue().set(email, checkCode, 5, TimeUnit.MINUTES);
            mailService.sendMail(new String[]{email}, "尊敬的客官，您的验证码为: "+checkCode);
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);

        return returnData.toJSONString();
    }


}