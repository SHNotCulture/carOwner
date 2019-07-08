package com.carOwner.service.impl;

import com.carOwner.dao.TWechatUserMapper;
import com.carOwner.entity.TWechatUser;
import com.carOwner.entity.TWechatUserCriteria;
import com.carOwner.service.WechatUserService;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatUserServiceImpl implements WechatUserService {

    private  static final Logger logger= LoggerFactory.getLogger(WechatUserServiceImpl.class);
    @Autowired
    private TWechatUserMapper tWechatUserMapper;
    /**
     * 设置查询条件
     * @param tWechatUser
     * @return
     */
    private TWechatUserCriteria setCriteria(TWechatUser tWechatUser){
        TWechatUserCriteria tWechatUserCriteria= new TWechatUserCriteria();
        if(tWechatUser!=null){
            TWechatUserCriteria.Criteria criteria=tWechatUserCriteria.createCriteria();
            if(tWechatUser.getParkId()!=null)
            {
                criteria.andParkIdEqualTo(tWechatUser.getParkId());
            }
            if(tWechatUser.getVirCarPlate()!=null && tWechatUser.getVirCarPlate()!=""){
                criteria.andVirCarPlateEqualTo(tWechatUser.getVirCarPlate());
            }
            if(tWechatUser.getCarPlate()!=null && tWechatUser.getCarPlate()!=""){
                criteria.andCarPlateEqualTo(tWechatUser.getCarPlate());
            }
            if(tWechatUser.getId()!=null)
            {
                criteria.andIdEqualTo(tWechatUser.getId());
            }

        }
        return  tWechatUserCriteria;
    }

    /**
     * 查询微信用户信息
     * @return
     */
    @Override
    public List<TWechatUser> getWechatUser(TWechatUser tWechatUser){
        List<TWechatUser> tWechatUserList=tWechatUserMapper.selectByExample(setCriteria(tWechatUser));
        return tWechatUserList;
    }

    /**
     * 获取数据总量
     * @param tWechatUser
     * @return
     */
    private Integer getCount(TWechatUser tWechatUser){
        Integer total =(int)tWechatUserMapper.countByExample(setCriteria(tWechatUser));
        return total;
    }

    /**
     * 查询微信用户信息(分页)
     * @return
     */
    @Override
    public PageBean<TWechatUser> getWechatUserbyPage(TWechatUser tWechatUser, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TWechatUser> tWechatUserList=getWechatUser(tWechatUser);
        Integer countNums =getCount(tWechatUser);
        PageBean<TWechatUser> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tWechatUserList);
        return pageData;
    }

    /**
     * 删除微信用户信息
     * @param id
     * @return
     */
    @Override
    public String DeleteWechatUser(Integer id){
        tWechatUserMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新微信用户信息
     * @param tWechatUser
     * @return
     */
    @Override
    public String UpdateWechatUser(TWechatUser tWechatUser)
    {
        if(tWechatUser.getId()!=null){
            tWechatUserMapper.updateByPrimaryKeySelective(tWechatUser);
        }
        else
        {
            tWechatUserMapper.insertSelective(tWechatUser);
        }
        return "更新成功";
    }
}
