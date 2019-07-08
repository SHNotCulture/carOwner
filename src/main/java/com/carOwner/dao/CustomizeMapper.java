package com.carOwner.dao;


import com.carOwner.dao.sqlProvider.CustomizeSqlProvider;
import com.carOwner.entity.TCar;
import com.carOwner.entity.TCarStatus;
import com.carOwner.entity.theThirdAPI.CarMember;
import com.carOwner.entity.theThirdAPI.CarStatus;
import com.carOwner.entity.theThirdAPI.MemberInfo;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface CustomizeMapper {


    /**
     * 第三方根据车牌号查询车主实时状态
     * @return
     */
    @SelectProvider(type= CustomizeSqlProvider.class, method="getMemberInfo")
    MemberInfo getMemberInfo(String parkId,String carPlate);


    /**
     * 第三方根据车牌号查询车辆信息
     * @return
     */
    @SelectProvider(type= CustomizeSqlProvider.class, method="getCarInfo")
    TCar getCarInfo(String parkId, String carPlate);

    /**
     *  第三方根据车牌号更新车主实时状态
     */
    @SelectProvider(type= CustomizeSqlProvider.class, method="UpdateCarStatus")
    String UpdateCarStatus(TCarStatus tCarStatus);

    /**
     *  第三方根据车牌号新增车主实时状态
     */
    @SelectProvider(type= CustomizeSqlProvider.class, method="InsertCarStatus")
    String InsertCarStatus(TCarStatus tCarStatus);

    /**
     *  第三方根据车牌号查询车主信息
     */
    @SelectProvider(type= CustomizeSqlProvider.class, method="getCarMember")
    CarMember getCarMember(String parkId, String carPlate);
}
