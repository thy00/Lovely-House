package cn.thyonline.house.biz.mapper;

import cn.thyonline.house.common.pojo.Agency;
import cn.thyonline.house.common.pojo.AgencyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AgencyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int countByExample(AgencyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int deleteByExample(AgencyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int insert(Agency record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int insertSelective(Agency record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    List<Agency> selectByExample(AgencyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    Agency selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") Agency record, @Param("example") AgencyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByExample(@Param("record") Agency record, @Param("example") AgencyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByPrimaryKeySelective(Agency record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agency
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    int updateByPrimaryKey(Agency record);
}