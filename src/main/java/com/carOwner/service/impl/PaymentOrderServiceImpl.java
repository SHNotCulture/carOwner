package com.carOwner.service.impl;

import com.carOwner.dao.TPaymentOrderMapper;
import com.carOwner.entity.TPaymentOrder;
import com.carOwner.entity.TPaymentOrderCriteria;
import com.carOwner.service.PaymentOrderService;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    private  static final Logger logger= LoggerFactory.getLogger(PaymentOrderServiceImpl.class);
    @Autowired
    private TPaymentOrderMapper tPaymentOrderMapper;
    /**
     * 设置查询条件
     * @param tPaymentOrder
     * @return
     */
    private TPaymentOrderCriteria setCriteria(TPaymentOrder tPaymentOrder){
        TPaymentOrderCriteria tPaymentOrderCriteria= new TPaymentOrderCriteria();
        if(tPaymentOrder!=null){
            TPaymentOrderCriteria.Criteria criteria=tPaymentOrderCriteria.createCriteria();
            if(tPaymentOrder.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tPaymentOrder.getParkId());
            }
            if(tPaymentOrder.getDealId()!=null)
            {
                criteria.andDealIdEqualTo(tPaymentOrder.getDealId());
            }
            if(tPaymentOrder.getCarPlate()!=null && tPaymentOrder.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tPaymentOrder.getCarPlate());
            }
            if(tPaymentOrder.getId()!=null)
            {
                criteria.andIdEqualTo(tPaymentOrder.getId());
            }

        }
        return  tPaymentOrderCriteria;
    }

    /**
     * 查询已支付订单
     * @return
     */
    @Override
    public List<TPaymentOrder> getPaymentOrder(TPaymentOrder tPaymentOrder){
        List<TPaymentOrder> tPaymentOrderList=tPaymentOrderMapper.selectByExample(setCriteria(tPaymentOrder));
        return tPaymentOrderList;
    }

    /**
     * 获取数据总量
     * @param tPaymentOrder
     * @return
     */
    private Integer getCount(TPaymentOrder tPaymentOrder){
        Integer total =(int)tPaymentOrderMapper.countByExample(setCriteria(tPaymentOrder));
        return total;
    }

    /**
     * 查询已支付订单(分页)
     * @return
     */
    @Override
    public PageBean<TPaymentOrder> getPaymentOrderbyPage(TPaymentOrder tPaymentOrder, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TPaymentOrder> tPaymentOrderList=getPaymentOrder(tPaymentOrder);
        Integer countNums =getCount(tPaymentOrder);
        PageBean<TPaymentOrder> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tPaymentOrderList);
        return pageData;
    }

    /**
     * 删除已支付订单
     * @param id
     * @return
     */
    @Override
    public String DeletePaymentOrder(Integer id){
        tPaymentOrderMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新已支付订单
     * @param tPaymentOrder
     * @return
     */
    @Override
    public String UpdatePaymentOrder(TPaymentOrder tPaymentOrder)
    {
        if(tPaymentOrder.getId()!=null){
            tPaymentOrderMapper.updateByPrimaryKeySelective(tPaymentOrder);
        }
        else
        {
            tPaymentOrderMapper.insertSelective(tPaymentOrder);
        }
        return "更新成功";
    }
}
