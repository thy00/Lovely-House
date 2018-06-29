package cn.thyonline.house.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class HouseMsg implements Serializable {
    private static final long serialVersionUID = -4192693273806022947L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private String msg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.create_time
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.agent_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private Long agentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.house_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private Long houseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column house_msg.user_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    private String userName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.id
     *
     * @return the value of house_msg.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.id
     *
     * @param id the value for house_msg.id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.msg
     *
     * @return the value of house_msg.msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.msg
     *
     * @param msg the value for house_msg.msg
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.create_time
     *
     * @return the value of house_msg.create_time
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.create_time
     *
     * @param createTime the value for house_msg.create_time
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.agent_id
     *
     * @return the value of house_msg.agent_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public Long getAgentId() {
        return agentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.agent_id
     *
     * @param agentId the value for house_msg.agent_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.house_id
     *
     * @return the value of house_msg.house_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.house_id
     *
     * @param houseId the value for house_msg.house_id
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house_msg.user_name
     *
     * @return the value of house_msg.user_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house_msg.user_name
     *
     * @param userName the value for house_msg.user_name
     *
     * @mbggenerated Fri Jun 29 12:17:58 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}