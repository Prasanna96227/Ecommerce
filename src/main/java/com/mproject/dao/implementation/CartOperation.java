package com.mproject.dao.implementation;

import com.mproject.dao.CartOperations;

import com.mproject.model.ConsumerCart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CartOperation implements CartOperations {

    //getting SessionFactory object from applicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;

    //returns user cart
    public ConsumerCart gyId (int id) {
        Session session = sessionFactory.getCurrentSession();//creating session object

        return (ConsumerCart) session.get(ConsumerCart.class, id);// getting user cart by using cart id and returning cart
    }



 }
