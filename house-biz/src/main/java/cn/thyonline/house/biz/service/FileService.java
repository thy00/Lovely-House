package cn.thyonline.house.biz.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:用户将图片上传
 * @Author: Created by thy
 * @Date: 2018/6/30 23:11
 */
public interface FileService {
    /**
     * 批量上传图片
     * @param files
     * @return
     */
    List<String> getImgPath(List<MultipartFile> files);
}
