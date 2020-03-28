package edu.cqupt.kaoyan.service;

import edu.cqupt.kaoyan.entity.User;

import javax.servlet.http.HttpSession;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-03-26 18:48:57
 */
public interface UserService {

    User selectByIdCard(String useridcard);


    /**
     * 修改数据
     */

    String modName(String JSESSIONID, String username);
    String modPwd(String JSESSIONID, String password);
    String modRole(String JSESSIONID, Integer roleid);
    String modFrom(String JSESSIONID, Integer majorid, Integer collegeid);

    /**
     * 登陆
     */
    String login(String useridcard, String password, HttpSession session);

    /**
     * 注册
     * @param email
     * @return
     */
    String sendCode(String email);
    String register(String useridcard, String password, String email, String checkCode);
}