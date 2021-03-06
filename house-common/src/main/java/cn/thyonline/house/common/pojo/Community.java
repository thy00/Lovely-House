package cn.thyonline.house.common.pojo;

import java.io.Serializable;

public class Community implements Serializable {
    private static final long serialVersionUID = -8227145590371063975L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community.city_code
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community.name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community.city_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private String cityName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community.id
     *
     * @return the value of community.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community.id
     *
     * @param id the value for community.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community.city_code
     *
     * @return the value of community.city_code
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community.city_code
     *
     * @param cityCode the value for community.city_code
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community.name
     *
     * @return the value of community.name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community.name
     *
     * @param name the value for community.name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community.city_name
     *
     * @return the value of community.city_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community.city_name
     *
     * @param cityName the value for community.city_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }
}