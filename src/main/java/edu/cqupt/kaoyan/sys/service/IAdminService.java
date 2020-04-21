package edu.cqupt.kaoyan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.cqupt.kaoyan.sys.common.system.result.Result;
import edu.cqupt.kaoyan.sys.entity.Admin;
import edu.cqupt.kaoyan.sys.entity.DTO.AdminCheckPageDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.AdminLoginDTO;
import edu.cqupt.kaoyan.sys.entity.DTO.CheckDTO;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆
     *
     * @param adminLoginDTO
     * @return
     */
    Result login(AdminLoginDTO adminLoginDTO);

    /**
     * 查看分享的资源列表
     *
     * @return
     */
    AdminCheckPageDTO viewShare(Integer page);

    /**
     * 设置是否通过
     *
     * @param checkDTO
     * @return
     */
    void setCross(CheckDTO checkDTO);
}
