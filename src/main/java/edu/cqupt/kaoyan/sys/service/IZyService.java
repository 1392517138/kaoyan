package edu.cqupt.kaoyan.sys.service;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.Zy;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
public interface IZyService extends IService<Zy> {

    /**
     * 获得专业
     *
     * @return
     */
    Result getZy();
}
