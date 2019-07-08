package com.carOwner.service;

import com.carOwner.entity.TCarStatus;
import com.carOwner.util.PageBean;

import java.util.List;

public interface CarStatusService {
    PageBean<TCarStatus> getCarStatusbyPage(TCarStatus tCarStatus, Integer page, Integer limit);
    List<TCarStatus> getCarStatus(TCarStatus tCarStatus);
    String DeleteCarStatus(Integer id);
    String UpdateCarStatus(TCarStatus tCarStatus);
    String ThirdApiUpdateCarStatus(TCarStatus tCarStatus);
    void createCarAndMemberInfo(String carPlate,Integer parkId);
}
