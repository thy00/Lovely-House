package cn.thyonline.house.biz.mapper;

import cn.thyonline.house.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 10:09
 */
@Mapper
public interface UserMapper {
    public List<User> selectUsers();
}
