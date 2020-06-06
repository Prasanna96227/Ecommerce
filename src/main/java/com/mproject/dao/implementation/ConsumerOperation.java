package com.mproject.dao.implementation;

import com.mproject.dao.ConsumerOperations;
import com.mproject.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ConsumerOperation implements ConsumerOperations {

    //getting SessionFactory object from applicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;
    // Display object for storing the customers details who bought either admin or shopmanagers products
    Display d;

    //adding user, usercart into database
    public void amer(Consumer consumer) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        e(consumer);//calling method
        ConsumerCart c = new ConsumerCart();//creating user cart
        c.setConsumer(consumer);//setting user to the cart
        consumer.setConsumerCart(c);//setting cart to the user
        session.saveOrUpdate(consumer);//adding user to the database
        session.saveOrUpdate(c);// adding cart to the database
        session.flush();//synchronize changes with the database
    }

    //adding enduser into database
    public void e(Consumer c1){
        Session session = sessionFactory.getCurrentSession();//creating session object
        enduser enduser = new enduser();//creating enduser object for validating user during login
        enduser.setUname(c1.getUname()); //setting username of the customer to enduser
        enduser.setPword(c1.getPword());//setting password of the customer to enduser
        enduser.setCustId(c1.getConsumerId());//setting userid of the customer to enduser
        enduser.setRole("ROLE_U");//setting role
        enduser.setActive(true);// setting user as active
        session.saveOrUpdate(enduser);//adding enduser to the database
        session.flush();//synchronize changes with the database
    }

    //returning user
    public Consumer gerById (int customerId) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Consumer c= (Consumer) session.get(Consumer.class, customerId);//getting user by using userid
        session.flush();//synchronize changes with the database
        return c;//returning user
    }

    //returning user
    public Consumer gI (int customerId, ConsumerItem item) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        int i=0;// defining a variable and initialising it by 1
        Consumer c= (Consumer) session.get(Consumer.class, customerId);//getting user object by using user id
        String s = item.getItem().getTypeofperson();// getting the type of the person(admin or shop manager)
        List<Display> dd = gname(s);//getting display list by using the type of person
        for (Display display : dd) {// iterates through the list
            if (c.getConsumerId() == display.getCustid() ) { //checking whether the current userid is equal to display user id
                i = i + 1;//incrementing i by 1
            }
        }
        if (i==0){//if the user id does not exists in display then add the user details to the display
            d=new Display();// creating display object
            d.setCustid(c.getConsumerId());//setting user id to the display user id
            d.setFname(c.getcFirstName());//setting user first name to the display first name
            d.setLname(c.getcLastName());//setting user last name to the display last name
            d.setUname(c.getUname());//setting username to the display username
            d.setcEmail(c.getcEmail());//setting user email to the display user email
            d.setcPhone(c.getcPhone());//setting user phone to the display phone
            d.setType(item.getItem().getTypeofperson());//setting type of person to the display type of person
            session.saveOrUpdate(d);//adding display to the database
        }
        session.flush();//synchronize changes with the database
        return c;//returning user
    }

    //returning users list
    public List<Consumer> gomers() {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Consumer");//getting users from the database
        List<Consumer> customerList = query.list();//converting the result query to list query
        session.flush();//synchronize changes with the database
        return customerList;//returning userlist
    }

    //returning shopmanager list
    public List<Display> getAllDisplay() {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Display");//getting shop managers from the database
        List<Display> l = query.list();//converting the query to list query
        session.flush();//synchronize changes with the database
        return l;//returning shopmanager list
    }

    //returning user object by using username
    public Consumer ge (String username) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Consumer where uname = ?");// getting user by using username from the database

        query.setString(0, username);//setting value for the username
        Consumer c=(Consumer) query.uniqueResult();//returns one user object if it matches with the query or else return null
        session.flush();//synchronize changes with the database
        return c;// returns user object
    }

    //returning display list object by using type of person(admin or shopmanager)
    public List<Display> gname (String username) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Display where type = ?");// getting display by using type of person from the database
        query.setString(0, username);//setting value for the type of person
        List<Display> displays = query.list();//converting the result query to list query
        session.flush();//synchronize changes with the database

        return displays;//returning display list
    }


}
