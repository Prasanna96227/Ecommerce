package com.mproject.dao;


import com.mproject.model.ConsumerCart;
import com.mproject.model.ConsumerItem;

public interface CproductOperations {

    //methods implemented by its implementation class

    boolean am(ConsumerItem consumerItem);

    void rm(ConsumerItem consumerItem);

    void rtems(ConsumerCart c);

    void rems(ConsumerCart c);

    ConsumerItem guctId (int i);

}
