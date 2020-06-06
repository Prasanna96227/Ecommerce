package com.mproject.controller;

import com.mproject.dao.*;
import com.mproject.model.Consumer;
import com.mproject.model.ConsumerCart;
import com.mproject.model.Item;
import com.mproject.model.SManagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class ItemOrder {

    // getting CartOperations implementation class object(CartOperation)
    @Autowired
    private CartOperations cartOperations;

    // getting ItemOperations implementation class object (ItemOperation)
    @Autowired
    private ItemOperations itemOperations;

    // getting ConsumerOperations implementation class object(ConsumerOperation)
    @Autowired
    private ConsumerOperations consumerOperations;

    // getting CproductOperations implementation class object(CproductOperation)
    @Autowired
    CproductOperations cproductOperations;

    // getting SalesOperations implementation class object(SalesOperation)
    @Autowired
    SalesOperations salesOperations;


    // redirecting to url
    @RequestMapping("/buy/{addId}")
    public String er(@PathVariable("addId") int id) {

        return "redirect:/buyitem/"+id;// redirecting to url by adding cart id to it
    }

    //redirects to respective page by using cart information
    @RequestMapping("/buyitem/{no}")
    public String cr(@PathVariable("no") int no, Model model)  {

        ConsumerCart c=cartOperations.gyId(no);// getting user cart by using cart id
        if(c==null||c.getCi().size()==0) {//checking whether the cart is empty or not
            return "wrong";//visits wrong page if cart does not have items
        }
        Consumer consumer=c.getConsumer(); // getting user object by using usercart
        model.addAttribute("s",consumer);//adding user object to the model
        model.addAttribute("no",no);// adding cart id to the model

        return "coninfo";// redirects to coninfo page if cart is not null

    }

    // redirects to cpayment page
    @RequestMapping("/payment/{no}")
    public String pa(@PathVariable("no") int no, Model model){
        model.addAttribute("no", no);//adding cart id to the model

        return "cpayment";// redirects to cpayment page
    }

    //redirects to orderplaced page
    @RequestMapping("/orderplaced/{no}")
    public String or(@PathVariable("no") int no, Model model){
        ConsumerCart cart=cartOperations.gyId(no); // getting user cart by using cart id
        cproductOperations.rems(cart);//adding items to the display object for having a record of the items that user bought either from admin or shop managers
        cproductOperations.rtems(cart);// removing cart items
        return "orderplaced"; //redirects to orderplaced page
    }

    //redirects to allitems page
    @RequestMapping("/displayallitems")
    public String ts(Model model) {
        List<Item> items = itemOperations.gItemList();// getting items from database
        model.addAttribute("items", items);// adding items list object to the model
        List<Consumer> consumers=consumerOperations.gomers();// getting users from the database
        model.addAttribute("consumers", consumers);// adding user list object to the model

        List<SManagers> sales=salesOperations.getAllSales();// getting shop managers from the database
        model.addAttribute("sales", sales);//adding shop managers list object to the model

        return "allitems";//redirects to allitems page
    }

    //redirects to allitems page
    @RequestMapping("/iteminformation/displayallitems")
    public String rods(Model model) {
        List<Item> items = itemOperations.gItemList();// getting items from database
        model.addAttribute("items", items);// adding items list object to the model
        List<SManagers> sales=salesOperations.getAllSales();// getting shop managers from the database
        model.addAttribute("sales", sales);//adding shop managers list object to the model

        return "allitems";//redirects to allitems page
    }

    //redirects to iteminfo page
    @RequestMapping("/iteminformation/{i}")
    public String duct(@PathVariable("i") int i, Model model) throws IOException {
        Item item=itemOperations.gItemById(i);// getting item by using item id that we got from the url
        model.addAttribute("item", item);// adding item object to the model
        List<Consumer> consumers=consumerOperations.gomers();// getting users from the database
        model.addAttribute("consumers", consumers);// adding user list object to the model
        List<SManagers> sales=salesOperations.getAllSales();// getting shop managers from the database
        model.addAttribute("sales", sales);//adding shop managers list object to the model

        return "iteminfo";//redirects to iteminfo page
    }



}
