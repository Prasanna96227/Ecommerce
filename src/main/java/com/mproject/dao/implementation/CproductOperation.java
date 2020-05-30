package com.mproject.dao.implementation;

import com.mproject.dao.CproductOperations;
import com.mproject.dao.ConsumerOperations;
import com.mproject.model.ConsumerCart;
import com.mproject.model.ConsumerItem;
import com.mproject.model.Consumer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CproductOperation implements CproductOperations {

    //getting SessionFactory object from applicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;

    // getting ConsumerOperations implementation class object(ConsumerOperation)
    @Autowired
    ConsumerOperations consumerOperations;

    // adding user cart item into the database
    public boolean am(ConsumerItem consumerItem) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        session.saveOrUpdate(consumerItem);// adding user cart item into the database
        session.flush();//synchronize changes with the database
        return true;//returns true
    }

    //deleting user cart item from the database
    public void rm (ConsumerItem consumerItem) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        session.delete(consumerItem);//deleting user cart item from the database
        session.flush();//synchronize changes with the database
    }

    //adding user details to the database who bought either admin items or shop manager items
    public void rems(ConsumerCart consumerCart) {
        List<ConsumerItem> consumerItems = consumerCart.getCi();// getting list of items from the cart
        Session session = sessionFactory.getCurrentSession();//creating session object
        int i=0;// defining an int variable and initialising it by 1
        String a="admin";// defining a string variable and initialising it by admin
        int s=consumerCart.getConsumer().getConsumerId();//getting user id
        for (ConsumerItem item : consumerItems) {//iterates through list of cart items

            if(!(item.getItem().getTypeofperson().equals(a))  ){//if type of person is not equal to admin then it enters the loop
               Consumer c=consumerOperations.gI(s, item);//calls the method
            }
            if((item.getItem().getTypeofperson().equals(a))  ){//if type of person is equal to admin then it enters the loop
               Consumer c=consumerOperations.gI(s, item);//calls the method
            }
        }
        session.flush();//synchronize changes with the database
    }

    //delete cart
    public void rtems(ConsumerCart consumerCart) {
        List<ConsumerItem> consumerItems = consumerCart.getCi();//getting list of cart items by using user cart
        Session session = sessionFactory.getCurrentSession();//creating session object
        for (ConsumerItem consumerItem : consumerItems) { //iterates through the list of cart items
            session.delete(consumerItem);//deleting user cart item from the database
        }
        session.flush();//synchronize changes with the database
    }

    //getting user cart item using item id
    public ConsumerItem guctId (int i) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from ConsumerItem where itemsId = ?");// getting user cart item by using item id from the database
        query.setInteger(0, i);//setting value for the item id
        session.flush();//synchronize changes with the database

        return (ConsumerItem) query.uniqueResult();//returns one user cart item if matches with the query or else return null
    }
}
