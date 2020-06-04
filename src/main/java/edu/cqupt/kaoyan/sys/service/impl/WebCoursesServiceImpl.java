package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.entity.DTO.WebCoursesDTO;
import edu.cqupt.kaoyan.sys.entity.WebCourses;
import edu.cqupt.kaoyan.sys.mapper.WebCoursesMapper;
import edu.cqupt.kaoyan.sys.service.IWebCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-06-04
 */
@Service
public class WebCoursesServiceImpl extends ServiceImpl<WebCoursesMapper, WebCourses> implements IWebCoursesService {
    @Autowired
    WebCoursesMapper webCoursesMapper;
    @Value("${mybatis-plus.pageInfo.size}")
    private Integer size;

    @Override
    public List<String> getResource() {
        List<String> rsource = webCoursesMapper.getRsource();
        return rsource;
    }

    @Override
    public List<String> getCategory(String resource) {
        List<String> category = webCoursesMapper.getCategory(resource);
        return category;
    }

    @Override
    public WebCoursesDTO getWebCourses(String resource, String category, Integer page) {
        Page<WebCourses> pageInfo = new Page<>(page, size);
        IPage<WebCourses> webCoursesPage = this.baseMapper.selectPage(pageInfo, Wrappers.<WebCourses>lambdaQuery().eq(WebCourses::getResource, resource).eq(WebCourses::getCategory, category));
        return new WebCoursesDTO(webCoursesPage.getRecords(), webCoursesPage.getPages(), webCoursesPage.getSize(), webCoursesPage.getTotal());
    }
}
