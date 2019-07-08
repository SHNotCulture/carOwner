package com.carOwner.service;

import com.carOwner.entity.TMember;
import com.carOwner.entity.theThirdAPI.CarMember;
import com.carOwner.entity.theThirdAPI.MemberInfo;
import com.carOwner.util.PageBean;

import java.util.List;

public interface MemberService {
    PageBean<TMember> getMemberbyPage(TMember tMember, Integer page, Integer limit);
    List<TMember> getMember(TMember tMember);
    String DeleteMember(Integer id);
    String UpdateMember(TMember tMember);
    String getMemberInfo(String parkId,String carPlate);
    CarMember getCarMember(String parkId, String carPlate);
}
