package com.css.cloudkitchens.orders.service;

import com.css.cloudkitchens.orders.OrderList;

import java.io.File;

public interface OrderLoader {

    OrderList loadOrder();

    File loadFile();

}
