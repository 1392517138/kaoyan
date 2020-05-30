package edu.cqupt.kaoyan.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cqupt.kaoyan.sys.entity.XyZy;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author Aaron
 * @since 2020-05-29
 */
public interface XyZyMapper extends BaseMapper<XyZy> {

    @Select("select distinct xymc from xy_zy where zyh=#{zyh}")
    String getXybyZyh(String zyh);
}
