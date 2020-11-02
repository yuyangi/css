package com.css.cloudkitchens;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class OrderConfigration {

    @Value("${app.orderprocess.rate}")
    private int orderProcessRate;

    @Value("${app.orderprocess.address}")
    private String orderAddress;

    public int getOrderProcessRate() {
        return orderProcessRate;
    }

    public void setOrderProcessRate(int orderProcessRate) {
        this.orderProcessRate = orderProcessRate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }
}
