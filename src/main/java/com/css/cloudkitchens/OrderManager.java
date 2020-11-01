package com.css.cloudkitchens;

import com.css.cloudkitchens.orders.Order;
import com.css.cloudkitchens.orders.OrderList;
import com.css.cloudkitchens.orders.impl.OrderLoader;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager {

    @Autowired
    private OrderLoader orderLoader;

    @Autowired
    private OrderConfigration orderConfigration;

    public void dispatchOrder() {
        OrderList orderList = orderLoader.load();
        if (orderList != null) {
            List<Order> list = orderList.getOrderList();
            RateLimiter ratelimiter = RateLimiter.create(orderConfigration.getOrderProcessRate());
            if (list != null) {
                for (Order order : list) {
                    ratelimiter.acquire();
                    // TODO dispatch order to shelf.

                }
            }
        }
    }

}
