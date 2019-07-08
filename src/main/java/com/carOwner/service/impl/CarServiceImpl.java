package com.carOwner.service.impl;

import com.carOwner.dao.CustomizeMapper;
import com.carOwner.dao.TCarMapper;
import com.carOwner.entity.TCar;
import com.carOwner.entity.TCarCriteria;
import com.carOwner.service.CarService;
import com.carOwner.util.JsonUtil;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private  static final Logger logger= LoggerFactory.getLogger(CarServiceImpl.class);
    @Autowired
    private TCarMapper tCarMapper;
    @Autowired
    private CustomizeMapper customizeMapper;

    /**
     * 设置查询条件
     * @param tCar
     * @return
     */
    private TCarCriteria setCriteria(TCar tCar){
        TCarCriteria tCarCriteria= new TCarCriteria();
        if(tCar!=null){
            TCarCriteria.Criteria criteria=tCarCriteria.createCriteria();
            if(tCar.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tCar.getParkId());
            }
            if(tCar.getCarPlate()!=null && tCar.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tCar.getCarPlate());
            }
            if(tCar.getId()!=null)
            {
                criteria.andIdEqualTo(tCar.getId());
            }

        }
        return  tCarCriteria;
    }

    /**
     * 查询车辆信息
     * @return
     */
    @Override
    public  List<TCar> getCar(TCar tCar){
        List<TCar> tCarList=tCarMapper.selectByExample(setCriteria(tCar));
        return tCarList;
    }

    /**
     * 获取数据总量
     * @param tCar
     * @return
     */
    private Integer getCount(TCar tCar){
        Integer total =(int)tCarMapper.countByExample(setCriteria(tCar));
        return total;
    }

    /**
     * 查询车辆信息(分页)
     * @return
     */
    @Override
    public PageBean<TCar> getCarbyPage(TCar tCar, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCar> tCarList=getCar(tCar);
        Integer countNums =getCount(tCar);
        PageBean<TCar> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tCarList);
        return pageData;
    }

    /**
     * 删除车辆信息
     * @param id
     * @return
     */
    @Override
    public String DeleteCar(Integer id){
        tCarMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新车辆信息
     * @param tCar
     * @return
     */
    @Override
    public String UpdateCar(TCar tCar)
    {
        if(tCar.getId()!=null){
            tCarMapper.updateByPrimaryKeySelective(tCar);
        }
        else
        {
            tCarMapper.insertSelective(tCar);
        }
        return "更新成功";
    }

    /**
     * 第三方接口查询车辆信息
     */
/*    @Override
    public String getCarInfo(String parkId, String carPlate) {

        return JsonUtil.beanToJson(customizeMapper.getCarInfo(parkId, carPlate));

    }*/
}
