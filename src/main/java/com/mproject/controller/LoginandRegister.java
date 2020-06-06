package com.mproject.controller;

import com.mproject.dao.ConsumerOperations;
import com.mproject.dao.ItemOperations;
import com.mproject.dao.SalesOperations;

import com.mproject.model.Consumer;
import com.mproject.model.Item;
import com.mproject.model.SManagers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class LoginandRegister {

    // getting ItemOperations implementation class object (ItemOperation)
    @Autowired
    private ItemOperations itemOperations;

    // getting ConsumerOperations implementation class object(ConsumerOperation)
    @Autowired
    private ConsumerOperations consumerOperations;

    // getting SalesOperations implementation class object(SalesOperation)
    @Autowired
    private SalesOperations salesOperations;

    //redirects to signup page
    @RequestMapping("/signupuser")
    public String omer(Model model) {

        Consumer customer = new Consumer();//creating user object

        model.addAttribute("customer", customer);//adding user object to the model

        return "signup";//redirects to signup page

    }

    //redirects to signupshop page
    @RequestMapping("/signupsm")
    public String registersales(Model model) {

        SManagers sales = new SManagers();//creating shop manager object

        model.addAttribute("sales", sales); // adding shop manager object to the model

        return "signupshop";//redirects to signupshop page

    }

    //redirects to signupdone page
    @RequestMapping(value = "/signupuser", method = RequestMethod.POST)
    public String erPost(@Valid @ModelAttribute("customer") Consumer consumer) {


        consumerOperations.amer(consumer);// adding user object to the database
        return "signupdone";//redirects to signupdone page

    }

    //redirects signupdone page
    @RequestMapping(value = "/signupsm", method = RequestMethod.POST)
    public String registerSalesPost(@Valid @ModelAttribute("sales") SManagers sales) {

        salesOperations.addSales(sales);// adding shop manager object to the database

        return "signupdone";//redirects to signupdone page

    }

    //redirects to index page
    @RequestMapping("/")
    public String home(Model model)
    {
        List<Item> items = itemOperations.gItemList();// getting items from database
        model.addAttribute("items", items);// adding items list object to the model

        List<Consumer> consumers=consumerOperations.gomers();// getting users from the database
        model.addAttribute("customers", consumers);// adding user list object to the model

        List<SManagers> sales=salesOperations.getAllSales();// getting shop managers from the database
        model.addAttribute("sales", sales);//adding shop managers list object to the model

        return "index";//redirects to index page
    }


   //redirects to signin page
    @RequestMapping(value="/signin")
    public String in() {
        return "signin"; //redirects to signin page
    }

    //redirects to respective page based on the type of the person logged in
    @RequestMapping(value="/signs")
    public String lo(@AuthenticationPrincipal User activeUser) {
     String s=activeUser.getUsername();// getting username from signin page
     if(s.equals("admin")){// if signin page username is equal to admin then it enters the loop
         return "apage";// redirects to apage
     }

        List<Consumer> consumers=consumerOperations.gomers();// getting users from the database

      for(int i=0; i<consumers.size(); i++){ // iterates through all the users
          Consumer c=consumers.get(i);// getting user object from the list based on the index position
          if(s.equals(c.getUname())){// if signin page username is equal to the username that we got from user object then it enters the loop
              return "redirect:/displayallitems";//redirects to this url
          }
      }

        List<SManagers> m=salesOperations.getAllSales();// getting shop managers from the database
        for(int i=0; i<m.size(); i++){// iterates through all the shop managers
            SManagers c=m.get(i);// getting shop manager object from the list based on the index position
            if(s.equals(c.getUname())){// if signin page username is equal to the username that we got from shop manager object then it enters the loop
                return "redirect:/shop/"+s;// redirects to this url
            }
        }

        return "redirect:/s";// if none of the above conditions are satisfied then it redirects to this url
    }

    //redirects to the signin
    @RequestMapping("/s")
    public String si(@RequestParam(value="r", required = false) String r, Model model) {

        model.addAttribute("r", "wrong credentials");// adding error message to the model
        return "signin";// redirects to signin page
    }

    //redirects to signin page
    @RequestMapping("/sign")
    public String sign(@RequestParam(value="signout",
            required = false) String o, Model model) {

        if(o!=null) { //if we will get signout string from the url then it enters the loop
            model.addAttribute("i", "log out successfully");// adding signout message to the model
        }

        return "signin";//redirects to signin page
    }



}
