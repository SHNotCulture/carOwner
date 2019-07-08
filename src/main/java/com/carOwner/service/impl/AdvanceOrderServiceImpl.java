package com.carOwner.service.impl;

import com.carOwner.dao.TAdvanceOrderMapper;
import com.carOwner.entity.TAdvanceOrder;
import com.carOwner.entity.TAdvanceOrderCriteria;
import com.carOwner.service.AdvanceOrderService;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvanceOrderServiceImpl implements AdvanceOrderService {
    private  static final Logger logger= LoggerFactory.getLogger(AdvanceOrderServiceImpl.class);
    @Autowired
    private TAdvanceOrderMapper tAdvanceOrderMapper;
    /**
     * 设置查询条件
     * @param tAdvanceOrder
     * @return
     */
    private TAdvanceOrderCriteria setCriteria(TAdvanceOrder tAdvanceOrder){
        TAdvanceOrderCriteria tAdvanceOrderCriteria= new TAdvanceOrderCriteria();
        if(tAdvanceOrder!=null){
            TAdvanceOrderCriteria.Criteria criteria=tAdvanceOrderCriteria.createCriteria();
            if(tAdvanceOrder.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tAdvanceOrder.getParkId());
            }
            if(tAdvanceOrder.getDealId()!=null)
            {
                criteria.andDealIdEqualTo(tAdvanceOrder.getDealId());
            }
            if(tAdvanceOrder.getCarPlate()!=null && tAdvanceOrder.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tAdvanceOrder.getCarPlate());
            }
            if(tAdvanceOrder.getId()!=null)
            {
                criteria.andIdEqualTo(tAdvanceOrder.getId());
            }

        }
        return  tAdvanceOrderCriteria;
    }

    /**
     * 查询预支付订单
     * @return
     */
    @Override
    public  List<TAdvanceOrder> getAdvanceOrder(TAdvanceOrder tAdvanceOrder){
        List<TAdvanceOrder> tAdvanceOrderList=tAdvanceOrderMapper.selectByExample(setCriteria(tAdvanceOrder));
        return tAdvanceOrderList;
    }

    /**
     * 获取数据总量
     * @param tAdvanceOrder
     * @return
     */
    private Integer getCount(TAdvanceOrder tAdvanceOrder){
        Integer total =(int)tAdvanceOrderMapper.countByExample(setCriteria(tAdvanceOrder));
        return total;
    }

    /**
     * 查询预支付订单(分页)
     * @return
     */
    @Override
    public PageBean<TAdvanceOrder> getAdvanceOrderbyPage(TAdvanceOrder tAdvanceOrder, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TAdvanceOrder> tAdvanceOrderList=getAdvanceOrder(tAdvanceOrder);
        Integer countNums =getCount(tAdvanceOrder);
        PageBean<TAdvanceOrder> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tAdvanceOrderList);
        return pageData;
    }

    /**
     * 删除预支付订单
     * @param id
     * @return
     */
    @Override
    public String DeleteAdvanceOrder(Integer id){
        tAdvanceOrderMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新预支付订单
     * @param tAdvanceOrder
     * @return
     */
    @Override
    public String UpdateAdvanceOrder(TAdvanceOrder tAdvanceOrder)
    {
        if(tAdvanceOrder.getId()!=null){
            tAdvanceOrderMapper.updateByPrimaryKeySelective(tAdvanceOrder);
        }
        else
        {
            tAdvanceOrderMapper.insertSelective(tAdvanceOrder);
        }
        return "更新成功";
    }
}
