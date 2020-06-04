package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.entity.DTO.WebCoursesDTO;
import edu.cqupt.kaoyan.sys.entity.WebCourses;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-06-04
 */
public interface IWebCoursesService extends IService<WebCourses> {

    /**
     * 得到有几个平台
     *
     * @return
     */
    List<String> getResource();

    /**
     * 根据resource获得category所有类别
     *
     * @param resource
     * @return
     */
    List<String> getCategory(String resource);

    /**
     * 根据resource,category,page(页码)
     *
     * @param resource
     * @param category
     * @param page
     * @return
     */
    WebCoursesDTO getWebCourses(String resource, String category, Integer page);
}
