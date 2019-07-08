package com.carOwner.entity.theThirdAPI;

public class CarStatus {
    private String carPlate;
    private Integer parkId;
    private String inTime;
    private String outTime;
    private Integer status;
    private Integer monthlyStatus;

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMonthlyStatus() {
        return monthlyStatus;
    }

    public void setMonthlyStatus(Integer monthlyStatus) {
        this.monthlyStatus = monthlyStatus;
    }
}
