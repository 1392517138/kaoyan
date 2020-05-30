package edu.cqupt.kaoyan.sys.service;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.XyZy;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-29
 */
public interface IXyZyService extends IService<XyZy> {

    /**
     * 获得学院专业列表
     *
     * @return
     */
    Result getXyZy();


}
