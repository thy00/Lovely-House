package cn.thyonline.house.biz.mapper;

import cn.thyonline.house.common.pojo.HouseMsg;
import cn.thyonline.house.common.pojo.HouseMsgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseMsgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int countByExample(HouseMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int deleteByExample(HouseMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int insert(HouseMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int insertSelective(HouseMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    List<HouseMsg> selectByExample(HouseMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    HouseMsg selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") HouseMsg record, @Param("example") HouseMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByExample(@Param("record") HouseMsg record, @Param("example") HouseMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByPrimaryKeySelective(HouseMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByPrimaryKey(HouseMsg record);
}