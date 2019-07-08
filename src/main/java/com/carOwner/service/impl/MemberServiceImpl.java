package com.carOwner.service.impl;

import com.carOwner.dao.CustomizeMapper;
import com.carOwner.dao.TMemberMapper;
import com.carOwner.entity.TMember;
import com.carOwner.entity.TMemberCriteria;
import com.carOwner.entity.theThirdAPI.CarMember;
import com.carOwner.entity.theThirdAPI.MemberInfo;
import com.carOwner.service.MemberService;
import com.carOwner.util.JsonUtil;
import com.carOwner.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private  static final Logger logger= LoggerFactory.getLogger(MemberServiceImpl.class);
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private CustomizeMapper customizeMapper;
    /**
     * 设置查询条件
     * @param tMember
     * @return
     */
    private TMemberCriteria setCriteria(TMember tMember){
        TMemberCriteria tMemberCriteria= new TMemberCriteria();
        if(tMember!=null){
            TMemberCriteria.Criteria criteria=tMemberCriteria.createCriteria();
            if(tMember.getUserName()!=null && tMember.getUserName()!=""){
                criteria.andUserNameEqualTo(tMember.getUserName());
            }
            if(tMember.getId()!=null)
            {
                criteria.andIdEqualTo(tMember.getId());
            }

        }
        return  tMemberCriteria;
    }

    /**
     * 查询车主信息
     * @return
     */
    @Override
    public List<TMember> getMember(TMember tMember){
        List<TMember> tMemberList=tMemberMapper.selectByExample(setCriteria(tMember));
        return tMemberList;
    }

    /**
     * 获取数据总量
     * @param tMember
     * @return
     */
    private Integer getCount(TMember tMember){
        Integer total =(int)tMemberMapper.countByExample(setCriteria(tMember));
        return total;
    }

    /**
     * 查询车主信息(分页)
     * @return
     */
    @Override
    public PageBean<TMember> getMemberbyPage(TMember tMember, Integer page, Integer limit){
        PageHelper.startPage(page, limit,"id desc");
        List<TMember> tMemberList=getMember(tMember);
        Integer countNums =getCount(tMember);
        PageBean<TMember> pageData = new PageBean<>(page, limit, countNums);
        pageData.setItems(tMemberList);
        return pageData;
    }

    /**
     * 删除车主信息
     * @param id
     * @return
     */
    @Override
    public String DeleteMember(Integer id){
        tMemberMapper.deleteByPrimaryKey(id);
        return "删除成功";
    }

    /**
     * 更新车主信息
     * @param tMember
     * @return
     */
    @Override
    public String UpdateMember(TMember tMember)
    {
        if(tMember.getId()!=null){
            tMemberMapper.updateByPrimaryKeySelective(tMember);
        }
        else
        {
            tMemberMapper.insertSelective(tMember);
        }
        return "更新成功";
    }

    /**
     * 第三方接口查询车主实时状态
     */
    @Override
    public String getMemberInfo(String parkId, String carPlate) {

            return JsonUtil.beanToJson(customizeMapper.getMemberInfo(parkId, carPlate));

    }

    /**
     * 第三方接口查询车主信息
     */
    @Override
    public CarMember getCarMember(String parkId, String carPlate) {
        return customizeMapper.getCarMember(parkId, carPlate);
    }



}
