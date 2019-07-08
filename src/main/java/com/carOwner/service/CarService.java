package com.carOwner.service;

import com.carOwner.entity.TCar;
import com.carOwner.util.PageBean;

import java.util.List;

public interface CarService {
    PageBean<TCar> getCarbyPage(TCar tCar, Integer page, Integer limit);
    List<TCar> getCar(TCar tCar);
    String DeleteCar(Integer id);
    String UpdateCar(TCar tCar);
    //String getCarInfo(String parkId,String carPlate);
}
