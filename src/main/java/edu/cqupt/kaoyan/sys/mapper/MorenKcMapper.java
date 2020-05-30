package edu.cqupt.kaoyan.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cqupt.kaoyan.sys.entity.MorenKc;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Aaron
 * @since 2020-05-28
 */
public interface MorenKcMapper extends BaseMapper<MorenKc> {

    /**
     * 获得(dxfa,jxdg,ksdg,zsdtx)的id即resourceId
     */
    @Select("select dxfaid from dxfa where kcbh=#{kcbh}")
    List<String> getDxfaId(String kcbh);

    @Select("select jxdgid from jxdg where kcbh=#{kcbh}")
    List<String> getJxdgId(String kcbh);

    @Select("select ksdgid from ksdg where kcbh=#{kcbh}")
    List<String> getKsdgId(String kcbh);

    @Select("select zsdtxid from zsdtx where kcbh=#{kcbh}")
    List<String> getZsdtxId(String kcbh);


}
