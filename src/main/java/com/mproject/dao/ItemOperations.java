package com.mproject.dao;

import com.mproject.model.Item;

import java.util.List;

public interface ItemOperations {

    //methods implemented by its implementation class

    List<Item> gItemList();

    Item gItemById(int p);

    List<Item> gItemByType(String type);

    void addItem(Item item);

    void updateItem(Item item);

    void removeItem(Item item);
}
