package com.emusicstore.dao;

import com.emusicstore.model.ShopManagers;

import java.util.List;

public interface SalesDao {

    void addSales (ShopManagers sales);

    ShopManagers getSalesById (int salesId);

    List<ShopManagers> getAllSales();

    ShopManagers getSalesByUsername (String managername);
}
