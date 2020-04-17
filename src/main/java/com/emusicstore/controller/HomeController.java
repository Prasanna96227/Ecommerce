package com.emusicstore.controller;

import com.emusicstore.dao.SalesDao;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.model.ShopManagers;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
public class HomeController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private SalesDao salesDao;

    @RequestMapping("/")
    public String home(Model model)
    {
        List<Customer> customers=customerService.getAllCustomers();
        model.addAttribute("customers", customers);

        List<ShopManagers> sales=salesDao.getAllSales();
        model.addAttribute("sales", sales);

        return "home";
    }

   // @RequestMapping("/salesregister")
    //public String sales() {        return "salesregister";    }




    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }


}
