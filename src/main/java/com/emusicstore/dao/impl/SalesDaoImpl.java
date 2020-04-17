package com.emusicstore.dao.impl;

import com.emusicstore.dao.SalesDao;
import com.emusicstore.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addSales(ShopManagers sales) {
        Session session = sessionFactory.getCurrentSession();

        sales.getBillingAddress().setSales(sales);
        sales.getShippingAddress().setSales(sales);

        session.saveOrUpdate(sales);
        session.saveOrUpdate(sales.getBillingAddress());
        session.saveOrUpdate(sales.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(sales.getManagername());
        newUser.setPassword(sales.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(sales.getShopId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(sales.getManagername());
        newAuthority.setAuthority("ROLE_SALES");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        session.flush();
    }

    public ShopManagers getSalesById (int salesId){
        Session session = sessionFactory.getCurrentSession();
        return (ShopManagers) session.get(ShopManagers.class, salesId);
    }

    public List<ShopManagers> getAllSales(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ShopManagers");
        List<ShopManagers> allsales = query.list();

        return allsales;
    }

    public ShopManagers getSalesByUsername (String managername){
        Session session = sessionFactory.getCurrentSession();
        Query row = session.createQuery("from Sales where managername = ?");
        row.setString(0, managername);
        return (ShopManagers) row.uniqueResult();
    }

}
