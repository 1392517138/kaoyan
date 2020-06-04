package edu.cqupt.kaoyan.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cqupt.kaoyan.sys.entity.WebCourses;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Aaron
 * @since 2020-06-04
 */
public interface WebCoursesMapper extends BaseMapper<WebCourses> {

    @Select("select distinct resource from web_courses")
    List<String> getRsource();

    @Select("select distinct category from web_courses where resource=#{resource}")
    List<String> getCategory(String resource);
}
