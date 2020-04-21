package edu.cqupt.kaoyan.sys;

import edu.cqupt.kaoyan.sys.service.IStudentsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Aaron
 * @description
 * @date 2020/4/12 9:53 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheTest {
    @Autowired
    IStudentsService iStudentsService;
    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void test01() {
//        new Random();
//        String[] contex = {
//                "死瓜皮，叫你猖獗", "你长的违章", "每次都在我兄弟看颜色的时候盗号",
//                "卢本伟牛逼!!!"};
//        String phone = "18543147924";
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//        log.warn("开始了，现在的时间是： " + new Date());
//        int length = contex.length;
//        for (int i = 0; i < 40; i++) {
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    MessageUtils.fuckYang(phone, contex[(int) (Math.random() * length]););
//                }
//            });
//        }
//        log.warn("结束，现在的时间是： " + new Date());

    }
}
