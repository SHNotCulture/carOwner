package com.carOwner.service;

import com.carOwner.entity.TAdvanceOrder;
import com.carOwner.util.PageBean;

import java.util.List;

public interface AdvanceOrderService {
    PageBean<TAdvanceOrder> getAdvanceOrderbyPage(TAdvanceOrder tAdvanceOrder, Integer page, Integer limit);
    List<TAdvanceOrder> getAdvanceOrder(TAdvanceOrder tAdvanceOrder);
    String DeleteAdvanceOrder(Integer id);
    String UpdateAdvanceOrder(TAdvanceOrder tAdvanceOrder);
}
