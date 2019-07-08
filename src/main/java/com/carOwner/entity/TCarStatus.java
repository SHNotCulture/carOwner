package com.carOwner.entity;

public class TCarStatus {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.member_id
     *
     * @mbg.generated
     */
    private Integer memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.member_name
     *
     * @mbg.generated
     */
    private String memberName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.car_id
     *
     * @mbg.generated
     */
    private Integer carId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.car_plate
     *
     * @mbg.generated
     */
    private String carPlate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.park_id
     *
     * @mbg.generated
     */
    private Integer parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.order_id
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.in_time
     *
     * @mbg.generated
     */
    private String inTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.out_time
     *
     * @mbg.generated
     */
    private String outTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_car_status.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.id
     *
     * @return the value of t_car_status.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.id
     *
     * @param id the value for t_car_status.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.member_id
     *
     * @return the value of t_car_status.member_id
     *
     * @mbg.generated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.member_id
     *
     * @param memberId the value for t_car_status.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.member_name
     *
     * @return the value of t_car_status.member_name
     *
     * @mbg.generated
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.member_name
     *
     * @param memberName the value for t_car_status.member_name
     *
     * @mbg.generated
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.car_id
     *
     * @return the value of t_car_status.car_id
     *
     * @mbg.generated
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.car_id
     *
     * @param carId the value for t_car_status.car_id
     *
     * @mbg.generated
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.car_plate
     *
     * @return the value of t_car_status.car_plate
     *
     * @mbg.generated
     */
    public String getCarPlate() {
        return carPlate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.car_plate
     *
     * @param carPlate the value for t_car_status.car_plate
     *
     * @mbg.generated
     */
    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate == null ? null : carPlate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.park_id
     *
     * @return the value of t_car_status.park_id
     *
     * @mbg.generated
     */
    public Integer getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.park_id
     *
     * @param parkId the value for t_car_status.park_id
     *
     * @mbg.generated
     */
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.order_id
     *
     * @return the value of t_car_status.order_id
     *
     * @mbg.generated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.order_id
     *
     * @param orderId the value for t_car_status.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.in_time
     *
     * @return the value of t_car_status.in_time
     *
     * @mbg.generated
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.in_time
     *
     * @param inTime the value for t_car_status.in_time
     *
     * @mbg.generated
     */
    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.out_time
     *
     * @return the value of t_car_status.out_time
     *
     * @mbg.generated
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.out_time
     *
     * @param outTime the value for t_car_status.out_time
     *
     * @mbg.generated
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.status
     *
     * @return the value of t_car_status.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.status
     *
     * @param status the value for t_car_status.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.create_time
     *
     * @return the value of t_car_status.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.create_time
     *
     * @param createTime the value for t_car_status.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_car_status.update_time
     *
     * @return the value of t_car_status.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_car_status.update_time
     *
     * @param updateTime the value for t_car_status.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}