package com.carOwner.dao.sqlProvider;


import com.carOwner.entity.TCarStatus;
import org.apache.ibatis.jdbc.SQL;

public class CustomizeSqlProvider {

    public String getMemberInfo (String parkId,String carPlate){
        String sql="SELECT b.member_id as id, a.name as name, a.age as age, a.sex as sex, b.car_id as carId, b.car_plate as carPlate, b.park_id as parkId, b.in_time as inTime, b.out_time as outTime, b.status as status"
        +" FROM t_member a " +"inner join t_car_status b " +"on a.id = b.member_id  AND b.park_id ="+parkId+" AND b.car_plate ='"+carPlate+"'";
        return sql.toString();
    }
    public String getCarInfo (String parkId,String carPlate){
        String sql="SELECT a.id as id, a.member_id as memberId, a.car_plate as carPlate, a.car_plate_color as carPlateColor, a.car_color as carColor, a.park_id as parkId, a.create_time as createTime, a.update_time as updateTime"
                +" FROM t_car a  WHERE a.park_id ="+parkId+" AND a.car_plate ='"+carPlate+"'";
        return sql.toString();
    }

    public String UpdateCarStatus(TCarStatus tCarStatus){
        String sql="update t_car_status set in_time ='"+tCarStatus.getInTime()+"',out_time ='"+tCarStatus.getOutTime()+"',status ="+tCarStatus.getStatus()+",update_time='"+tCarStatus.getUpdateTime()+"'  where car_plate='"+tCarStatus.getCarPlate()+"' and park_id="+tCarStatus.getParkId();
        return sql.toString();
    }

    public String InsertCarStatus(TCarStatus tCarStatus){
        String sql="insert into t_car_status (member_id,member_name,car_id,car_plate,park_id,order_id,in_time,out_time,status,create_time,update_time) VALUES ("+tCarStatus.getMemberId()+",'"+tCarStatus.getMemberName()+"',"+tCarStatus.getCarId()+",'"+tCarStatus.getCarPlate()+"',"+tCarStatus.getParkId()+",'"+tCarStatus.getOrderId()+"','"+tCarStatus.getInTime()+"','"+tCarStatus.getOutTime()+"',"+tCarStatus.getStatus()+",'"+tCarStatus.getCreateTime()+"','"+tCarStatus.getUpdateTime()+"')";
        return sql.toString();
    }

    public String getCarMember(String parkId,String carPlate){
        String sql="SELECT b.member_id as id, a.name as name, a.age as age, a.sex as sex, b.id as carId, b.car_plate as carPlate, b.park_id as parkId  FROM t_member a inner join t_car b on a.id = b.member_id  AND b.park_id ="+parkId+" AND b.car_plate ='"+carPlate+"'";
        return sql.toString();
    }

}
