package com.mproject.dao;

import com.mproject.model.SManagers;

import java.util.List;

public interface SalesOperations {

    //methods implemented by its implementation class

    void addSales (SManagers sales);

    SManagers getSalesById (int salesId);

    List<SManagers> getAllSales();

    SManagers getSalesByUsername (String managername);
}
