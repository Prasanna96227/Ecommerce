package com.mproject.dao;

import com.mproject.model.Consumer;
import com.mproject.model.ConsumerItem;
import com.mproject.model.Display;

import java.util.List;

public interface ConsumerOperations {

    //methods implemented by its implementation class

    void amer (Consumer customer);

    Consumer gerById (int customerId);

    Consumer gI (int customerId, ConsumerItem item);

    List<Display> getAllDisplay();

    List<Consumer> gomers();

    Consumer ge (String username);

    List<Display> gname (String username);



}
