package com.carOwner.service;

import com.carOwner.entity.TPaymentOrder;
import com.carOwner.util.PageBean;

import java.util.List;

public interface PaymentOrderService {
    PageBean<TPaymentOrder> getPaymentOrderbyPage(TPaymentOrder tPaymentOrder, Integer page, Integer limit);
    List<TPaymentOrder> getPaymentOrder(TPaymentOrder tPaymentOrder);
    String DeletePaymentOrder(Integer id);
    String UpdatePaymentOrder(TPaymentOrder tPaymentOrder);
}
