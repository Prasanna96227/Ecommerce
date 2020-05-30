package com.mproject.dao.implementation;

import com.mproject.dao.SalesOperations;
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
public class SalesOperation implements SalesOperations {

    //getting SessionFactory object from applicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;

    //adding shopmanager and enduser into database
    public void addSales(SManagers sales) {
        Session session = sessionFactory.getCurrentSession();//creating session object

        session.saveOrUpdate(sales);//adding shopmanager to the database

        enduser enduser = new enduser();//creating enduser object for validating shopmanager during login
        enduser.setUname(sales.getUname());//setting username of the shopmanager to enduser
        enduser.setPword(sales.getPword());//setting password of the shopmanager to enduser
        enduser.setActive(true);// setting shopmanager as active
        enduser.setCustId(sales.getShopId());//setting userid of the shopmanager to enduser
        enduser.setRole("ROLE_S");//setting role
        session.saveOrUpdate(enduser);//adding enduser to the database
        session.flush();//synchronize changes with the database
    }

    //returning shopmanager
    public SManagers getSalesById (int salesId){
        Session session = sessionFactory.getCurrentSession();//creating session object
        return (SManagers) session.get(SManagers.class, salesId);//getting shopmanager by using id and returning it
    }

    //returning shopmanagers list
    public List<SManagers> getAllSales(){
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from SManagers");//getting shopmanagers from the database

        List<SManagers> allsales = query.list();//converting the result query to list query

        return allsales;//returning shopmanagers list
    }

    //returning shopmanager object by using username
    public SManagers getSalesByUsername (String username){
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query row = session.createQuery("from SManagers where uname = ?");// getting shopmanager by using username from the database
        row.setString(0, username);//setting value for the username
        return (SManagers) row.uniqueResult();//returns one shopmanager object if it matches with the query or else return null
    }

}
