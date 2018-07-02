package cn.thyonline.house.biz.service.impl;

import cn.thyonline.house.biz.service.FileService;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/30 23:11
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String filePath;

    public List<String> getImgPath(List<MultipartFile> files){
        List<String> paths=Lists.newArrayList();
        files.forEach(file->{
            File localFile=null;
            if (!file.isEmpty()){
                try {
                    localFile=saveToLocal(file,filePath);
                    //得到相对路径
                    String s = localFile.getAbsolutePath();
                    String path = localFile.getAbsolutePath().substring(filePath.length()+2).replaceAll("\\\\","/");
                            paths.add(path);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return paths;
    }

    /**
     * 保存图片到本地
     * @param file
     * @param filePath
     * @return
     */
    private File saveToLocal(MultipartFile file, String filePath) throws IOException {
        File newFile = new File(filePath + "/" + Instant.now().getEpochSecond() + "/" + file.getOriginalFilename());
        //如果文件夹不存在需要创建文件夹
        if (!newFile.exists()){
            //创建文件夹
            newFile.getParentFile().mkdirs();
            //创建临时文件
            newFile.createNewFile();
        }
         Files.write(file.getBytes(),newFile);
        return newFile;
    }
}
