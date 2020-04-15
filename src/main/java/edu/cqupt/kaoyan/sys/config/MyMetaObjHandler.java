package edu.cqupt.kaoyan.sys.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author Aaron
 * @description
 * @date 2020/4/15 10:58 AM
 */

public class MyMetaObjHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createTime")) {
            this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateTime")) {
            this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
        }
    }
}
