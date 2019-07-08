package com.carOwner.service.impl;

import com.carOwner.dao.CustomizeMapper;
import com.carOwner.dao.TCarStatusMapper;
import com.carOwner.entity.TCar;
import com.carOwner.entity.TCarStatus;
import com.carOwner.entity.TCarStatusCriteria;
import com.carOwner.entity.TMember;
import com.carOwner.entity.theThirdAPI.CarStatus;
import com.carOwner.service.CarService;
import com.carOwner.service.CarStatusService;
import com.carOwner.service.MemberService;
import com.carOwner.util.DateUtil;
import com.carOwner.util.JsonUtil;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carOwner.util.DateUtil.sdfDateTimeFormat_II;

@Service
public class CarStatusServiceImpl implements CarStatusService {

    private  static final Logger logger= LoggerFactory.getLogger(CarStatusServiceImpl.class);
    @Autowired
    private TCarStatusMapper tCarStatusMapper;
    @Autowired
    private CustomizeMapper customizeMapper;
    @Autowired
    private CarStatusService carStatusService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CarService carService;
    /**
     * 设置查询条件
     * @param tCarStatus
     * @return
     */
    private TCarStatusCriteria setCriteria(TCarStatus tCarStatus){
        TCarStatusCriteria tCarStatusCriteria= new TCarStatusCriteria();
        if(tCarStatus!=null){
            TCarStatusCriteria.Criteria criteria=tCarStatusCriteria.createCriteria();
            if(tCarStatus.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tCarStatus.getParkId());
            }
            if(tCarStatus.getCarPlate()!=null && tCarStatus.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tCarStatus.getCarPlate());
            }
            if(tCarStatus.getId()!=null)
            {
                criteria.andIdEqualTo(tCarStatus.getId());
            }

        }
        return  tCarStatusCriteria;
    }

    /**
     * 查询车辆实时状态
     * @return
     */
    @Override
    public List<TCarStatus> getCarStatus(TCarStatus tCarStatus){
        List<TCarStatus> tCarStatusList=tCarStatusMapper.selectByExample(setCriteria(tCarStatus));
        return tCarStatusList;
    }

    /**
     * 获取数据总量
     * @param tCarStatus
     * @return
     */
    private Integer getCount(TCarStatus tCarStatus){
        Integer total =(int)tCarStatusMapper.countByExample(setCriteria(tCarStatus));
        return total;
    }

    /**
     * 查询车辆实时状态(分页)
     * @return
     */
    @Override
    public PageBean<TCarStatus> getCarStatusbyPage(TCarStatus tCarStatus, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TCarStatus> tAdvanceOrderList=getCarStatus(tCarStatus);
        Integer countNums =getCount(tCarStatus);
        PageBean<TCarStatus> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tAdvanceOrderList);
        return pageData;
    }

    /**
     * 删除车辆实时状态
     * @param id
     * @return
     */
    @Override
    public String DeleteCarStatus(Integer id){
        tCarStatusMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新车辆实时状态
     * @param tCarStatus
     * @return
     */
    @Override
    public String UpdateCarStatus(TCarStatus tCarStatus)
    {
        if(tCarStatus.getId()!=null){
            tCarStatusMapper.updateByPrimaryKeySelective(tCarStatus);
        }
        else
        {
            tCarStatusMapper.insertSelective(tCarStatus);
        }
        return "更新成功";
    }

    /**
     * 第三方接口更新车辆实时状态
     * @param tCarStatus
     * @return
     */
    @Override
    public String ThirdApiUpdateCarStatus(TCarStatus tCarStatus) {
        List<TCarStatus> tcarStatusList = carStatusService.getCarStatus(tCarStatus);
        if (tcarStatusList.size()>0){
            customizeMapper.UpdateCarStatus(tCarStatus);
        }else{
            tCarStatus.setCreateTime(DateUtil.getCurDateTime());
            customizeMapper.InsertCarStatus(tCarStatus);
        }

        return "更新成功";
    }

    /**
     * 第三方接口更新车辆实时状态 t_car，t_member表没有对应记录时创建记录
     */
    @Override
    public void createCarAndMemberInfo(String carPlate,Integer parkId) {
        TMember tMember = new TMember();
        tMember.setUserName("CZ"+DateUtil.getCurrenDateANY(sdfDateTimeFormat_II));
        tMember.setPassWord("123");
        tMember.setSex(1);
        tMember.setName("未命名");
        tMember.setBanance(0.0);
        tMember.setCreateTime(DateUtil.getCurDateTime());
        tMember.setUpdateTime(DateUtil.getCurDateTime());
        memberService.UpdateMember(tMember);
        TCar tNewCar = new TCar();
        tNewCar.setMemberId(memberService.getMember(tMember).get(0).getId());
        tNewCar.setCarPlate(carPlate);
        tNewCar.setParkId(parkId);
        tNewCar.setCreateTime(DateUtil.getCurDateTime());
        tNewCar.setUpdateTime(DateUtil.getCurDateTime());
        carService.UpdateCar(tNewCar);
    }
}
