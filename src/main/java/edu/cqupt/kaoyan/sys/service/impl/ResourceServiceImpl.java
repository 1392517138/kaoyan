package edu.cqupt.kaoyan.sys.service.impl;

import edu.cqupt.kaoyan.sys.entity.Resource;
import edu.cqupt.kaoyan.sys.mapper.ResourceMapper;
import edu.cqupt.kaoyan.sys.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-20
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
