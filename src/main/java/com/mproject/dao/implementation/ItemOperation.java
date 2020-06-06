package com.mproject.dao.implementation;

import com.mproject.dao.ItemOperations;
import com.mproject.model.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ItemOperation implements ItemOperations {

    //getting SessionFactory object from applicationContext.xml
    @Autowired
    private SessionFactory sessionFactory;

    //getting item from the database by using item id
    public Item gItemById (int p) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Item i = (Item) session.get(Item.class, p);//getting item from the database by using item id
        session.flush();//synchronize changes with the database

        return i;//returning the item object
    }

    //getting list of items from the database by using type of person(admin or shop manager)
    public List<Item> gItemByType (String type) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Item where typeofperson = ?" );//getting list of items from the database by using type of person(admin or shop manager)
        query.setString(0, type);//setting value for the type of person
        List<Item> items = query.list();//converting the result query to list query
        session.flush();//synchronize changes with the database

        return items;// returning items list
    }

    // getting items from the database
    public List<Item> gItemList() {
        Session session = sessionFactory.getCurrentSession();//creating session object
        Query query = session.createQuery("from Item");// getting items from the database
        List<Item> items = query.list();//converting the result query to list query
        session.flush();//synchronize changes with the database

        return items;// returning items list
    }

    //adding item object into database
    public void addItem (Item item) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        session.saveOrUpdate(item);//adding item object into database
        session.flush();//synchronize changes with the database
    }

    //updating item object into database
    public void updateItem (Item item) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        session.saveOrUpdate(item);//updating item object into database
        session.flush();//synchronize changes with the database
    }

    //removing item object from the database
    public void removeItem (Item item) {
        Session session = sessionFactory.getCurrentSession();//creating session object
        session.delete(item);//removing item object from the database
        session.flush();//synchronize changes with the database
    }
}
