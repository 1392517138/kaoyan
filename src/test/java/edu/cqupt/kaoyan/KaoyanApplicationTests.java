package edu.cqupt.kaoyan;

import edu.cqupt.kaoyan.entity.User;
import edu.cqupt.kaoyan.mapper.UserMapper;
import edu.cqupt.kaoyan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author piwenjing
 * @description
 * @date 2020/3/26 6:53 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class KaoyanApplicationTests {
    @Resource
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @Value("${sendmail.content}")
    private static String content;

    @Test
    public void ValueTest(){
        System.out.println(content);
    }
    @Test
    public void queryTest() throws SQLException {
        User user = userMapper.selectById(1);
        user.setEamil("1392517138@qq.com");
        userMapper.updateById(user);
    }

}
