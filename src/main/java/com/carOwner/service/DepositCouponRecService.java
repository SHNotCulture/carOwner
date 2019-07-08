package com.carOwner.service;

import com.carOwner.entity.TDepositCouponRec;
import com.carOwner.util.PageBean;

import java.util.List;

public interface DepositCouponRecService {
    PageBean<TDepositCouponRec> getDepositCouponRecbyPage(TDepositCouponRec tDepositCouponRec, Integer page, Integer limit);
    List<TDepositCouponRec> getDepositCouponRec(TDepositCouponRec tDepositCouponRec);
    String DeleteDepositCouponRec(Integer id);
    String UpdateDepositCouponRec(TDepositCouponRec tDepositCouponRec);
}
