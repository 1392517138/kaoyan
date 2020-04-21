package edu.cqupt.kaoyan.sys.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.UUID;

/**
 * @author Aaron
 * @description
 * @date 2020/4/14 9:52 AM
 */
@Slf4j
public class UploadUtils {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "http://oss-accelerate.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static String accessKeyId = "LTAI4FuvdDyyX4QxsUtpkeSv";
    private static String accessKeySecret = "xdOZ69pe2jB9yj1IEUwLvZrtjV4r3x";
    private static String bucketName = "smart-house-img";
    private static String SUFFER_URL = "https://smart-house-img.oss-accelerate.aliyuncs.com/";

    public static String uploadImage(MultipartFile file) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String className = (new Throwable()).getStackTrace()[1].toString();
//        log.info(className+"用到的");

        String classfy = "";
        //如果是上传question或reply类，qsrpImage
        if (className.contains("QuestionServiceImpl") || className.contains("ReplyServiceImpl")) {
            classfy = "qsrpImage";
            //如果是用户头像类的
        } else if (className.contains("StudentsServiceImpl")) {
            classfy = "userImage";
        } else if (className.contains("ShareServiceImpl")) {
            classfy = "share";
        }

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //获取文件后缀名称
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = "shujuku/" + classfy + "/" + uuid + ext;
//        System.out.println(filename);
        //文件地址
        String url = null;
        try {
            ossClient.putObject(bucketName, filename, new ByteArrayInputStream(file.getBytes()));
            url = SUFFER_URL + filename;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return url;
    }
}
