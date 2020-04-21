package edu.cqupt.kaoyan.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.cqupt.kaoyan.sys.common.utils.UploadUtils;
import edu.cqupt.kaoyan.sys.entity.CheckShare;
import edu.cqupt.kaoyan.sys.entity.Share;
import edu.cqupt.kaoyan.sys.mapper.ShareMapper;

import edu.cqupt.kaoyan.sys.service.ICheckShareService;
import edu.cqupt.kaoyan.sys.service.IShareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2020-04-19
 */
@Service
@Slf4j
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements IShareService {

    @Autowired
    ICheckShareService iCheckShareService;

    @Override
    public void uploadShare(MultipartFile file, String courseId, Long stuId) {
        String fileOriginName = file.getOriginalFilename();
        //获取文件后缀名称
        String shareType = fileOriginName.substring(file.getOriginalFilename().lastIndexOf(".")).replace(".", "");
        String shareName = fileOriginName.replace("." + shareType, "");
        String shareStream = UploadUtils.uploadImage(file);
        Share share = new Share(shareType, shareStream, courseId, stuId, shareName);
        log.info(share.toString());
        //上传share表
        save(share);
        //上传check表
        CheckShare checkShare = new CheckShare(share.getShareId());
        iCheckShareService.save(checkShare);
    }
}
