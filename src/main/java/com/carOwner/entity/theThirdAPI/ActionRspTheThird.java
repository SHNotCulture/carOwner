package com.carOwner.entity.theThirdAPI;

public class ActionRspTheThird {
    private String code;//0 访问成功
    private Object result;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActionRspTheThird{" +
                "code='" + code + '\'' +
                ", result=" + result +
                ", remark='" + remark + '\'' +
                '}';
    }
}
