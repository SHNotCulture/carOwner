package com.carOwner.service.impl;

import com.carOwner.dao.TDepositCouponRecMapper;
import com.carOwner.entity.TDepositCouponRec;
import com.carOwner.entity.TDepositCouponRecCriteria;
import com.carOwner.service.DepositCouponRecService;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositCouponRecServiceImpl implements DepositCouponRecService {
    private  static final Logger logger= LoggerFactory.getLogger(AdvanceOrderServiceImpl.class);
    @Autowired
    private TDepositCouponRecMapper tDepositCouponRecMapper;
    /**
     * 设置查询条件
     * @param tDepositCouponRec
     * @return
     */
    private TDepositCouponRecCriteria setCriteria(TDepositCouponRec tDepositCouponRec){
        TDepositCouponRecCriteria tDepositCouponRecCriteria= new TDepositCouponRecCriteria();
        if(tDepositCouponRec!=null){
            TDepositCouponRecCriteria.Criteria criteria=tDepositCouponRecCriteria.createCriteria();
            if(tDepositCouponRec.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tDepositCouponRec.getParkId());
            }
            if(tDepositCouponRec.getMemberName()!=null && tDepositCouponRec.getMemberName()!="")
            {
                criteria.andMemberNameEqualTo(tDepositCouponRec.getMemberName());
            }
            if(tDepositCouponRec.getOrderId()!=null && tDepositCouponRec.getOrderId()!="")
            {
                criteria.andOrderIdEqualTo(tDepositCouponRec.getOrderId());
            }
            if(tDepositCouponRec.getChannelNo()!=null && tDepositCouponRec.getChannelNo()!="")
            {
                criteria.andChannelNoEqualTo(tDepositCouponRec.getChannelNo());
            }
            if(tDepositCouponRec.getCarPlate()!=null && tDepositCouponRec.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tDepositCouponRec.getCarPlate());
            }
            if(tDepositCouponRec.getId()!=null)
            {
                criteria.andIdEqualTo(tDepositCouponRec.getId());
            }

        }
        return  tDepositCouponRecCriteria;
    }

    /**
     * 查询车主卡券信息
     * @return
     */
    @Override
    public List<TDepositCouponRec> getDepositCouponRec(TDepositCouponRec tDepositCouponRec){
        List<TDepositCouponRec> tDepositCouponRecList=tDepositCouponRecMapper.selectByExample(setCriteria(tDepositCouponRec));
        return tDepositCouponRecList;
    }

    /**
     * 获取数据总量
     * @param tDepositCouponRec
     * @return
     */
    private Integer getCount(TDepositCouponRec tDepositCouponRec){
        Integer total =(int)tDepositCouponRecMapper.countByExample(setCriteria(tDepositCouponRec));
        return total;
    }

    /**
     * 查询车主卡券信息(分页)
     * @return
     */
    @Override
    public PageBean<TDepositCouponRec> getDepositCouponRecbyPage(TDepositCouponRec tDepositCouponRec, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TDepositCouponRec> tDepositCouponRecList=getDepositCouponRec(tDepositCouponRec);
        Integer countNums =getCount(tDepositCouponRec);
        PageBean<TDepositCouponRec> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tDepositCouponRecList);
        return pageData;
    }

    /**
     * 删除车主卡券信息
     * @param id
     * @return
     */
    @Override
    public String DeleteDepositCouponRec(Integer id){
        tDepositCouponRecMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新预支付订单
     * @param tDepositCouponRec
     * @return
     */
    @Override
    public String UpdateDepositCouponRec(TDepositCouponRec tDepositCouponRec)
    {
        try{
                if(tDepositCouponRec.getId()!=null){
                System.out.println("准备update");
                tDepositCouponRecMapper.updateByPrimaryKeySelective(tDepositCouponRec);
                System.out.println("update成功");
            }
            else
            {
                System.out.println("准备insert");
                tDepositCouponRecMapper.insertSelective(tDepositCouponRec);
                System.out.println("insert成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "更新成功";   }

}
