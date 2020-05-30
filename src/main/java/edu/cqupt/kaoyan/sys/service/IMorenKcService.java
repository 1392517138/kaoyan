package edu.cqupt.kaoyan.sys.service;

import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.MorenKc;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
public interface IMorenKcService extends IService<MorenKc> {

    /**
     * 根据kcbh获取教学资源
     *
     * @param kcbh
     * @param type
     * @return
     */
    Result getResource(String kcbh, String type);

    /**
     * 根据课程编号查看课程信息
     *
     * @param kcbh
     * @return
     */
    Result getKcByKcbh(String kcbh);

    /**
     * 根据开课学院名称获得课程
     *
     * @param xymc
     * @return
     */
    List<MorenKc> getKcByXymc(String xymc);

    /**
     * 通过课程名称搜索
     *
     * @param kcmc
     * @return
     */
    List<MorenKc> searchByKcmc(String kcmc);

    /**
     * 通过专业号搜索合适的课程
     *
     * @param zyh
     * @return
     */
    Result searchByZyh(String zyh);

    /**
     * 获得一些乱七吧糟的学院
     *
     * @return
     */
    Result getUnknowXy();
}
