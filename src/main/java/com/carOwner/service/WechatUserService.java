package com.carOwner.service;

import com.carOwner.entity.TWechatUser;
import com.carOwner.util.PageBean;

import java.util.List;

public interface WechatUserService {
    PageBean<TWechatUser> getWechatUserbyPage(TWechatUser tWechatUser, Integer page, Integer limit);
    List<TWechatUser> getWechatUser(TWechatUser tWechatUser);
    String DeleteWechatUser(Integer id);
    String UpdateWechatUser(TWechatUser tWechatUser);
}
