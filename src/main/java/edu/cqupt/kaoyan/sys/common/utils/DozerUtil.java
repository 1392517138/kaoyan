package edu.cqupt.kaoyan.sys.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/4/16 5:13 PM
 */
@Slf4j
@Component
public class DozerUtil {

    private static Mapper dozerMapper;

    @Autowired
    public void setMapper(Mapper dozerMapper) {
        DozerUtil.dozerMapper = dozerMapper;
    }


    /**
     * 集合对象之间的转换
     *
     * @param source      原集合
     * @param targetClass 目标集合
     * @param <T>         泛型
     * @return List<T>
     */
    public static <T> List<T> mapList(List<?> source, Class<T> targetClass) {
        ArrayList<T> result = null;
        if (source != null) {
            result = new ArrayList<>(source.size());
            if (!source.isEmpty()) {
                for (Object obj : source) {
                    result.add(dozerMapper.map(obj, targetClass));
                }
            }
        }
        return result;
    }
}
