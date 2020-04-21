package edu.cqupt.kaoyan.sys;


import edu.cqupt.kaoyan.sys.entity.AdminCheck;
import edu.cqupt.kaoyan.sys.service.IAdminCheckService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author piwenjing
 * @description
 * @date 2020/3/26 6:53 PM
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class KaoyanApplicationTests {

    @Autowired
    IAdminCheckService iAdminCheckService;

    @Test
    public void test() {
        List<AdminCheck> adminChecks = iAdminCheckService.getBaseMapper().selectList(null);
        adminChecks.forEach(System.out::println);
    }


}
