package com.mproject.controller;

import com.mproject.dao.CartOperations;
import com.mproject.dao.ConsumerOperations;
import com.mproject.dao.CproductOperations;
import com.mproject.dao.ItemOperations;

import com.mproject.model.ConsumerCart;
import com.mproject.model.ConsumerItem;
import com.mproject.model.Consumer;
import com.mproject.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ItemCart {

    // getting ConsumerOperations implementation class object(ConsumerOperation)
    @Autowired
    private ConsumerOperations consumerOperations;

    // getting ItemOperations implementation class object (ItemOperation)
    @Autowired
    private CartOperations cartOperations;

    // getting CproductOperations implementation class object(CproductOperation)
    @Autowired
    private CproductOperations cproductOperations;

    // getting ItemOperations implementation class object (ItemOperation)
    @Autowired
    private ItemOperations itemOperations;

    // redirects to itemorder page
    @RequestMapping("/vieworder/{id}")
    public String getCart(@PathVariable (value = "id") String id, Model model){
        Consumer consumer = consumerOperations.ge (id); //retrieving user by using username
        int i = consumer.getConsumerCart().getCcId(); // retrieving user cart id by using user object
        model.addAttribute("number", i);// adding cart id to the model
        ConsumerCart c=cartOperations.gyId(i);// retrieving user cart information by using id
        model.addAttribute("c",c);// adding user cart to the model
        return "itemorder"; // redirects to itemorder page
    }

    // redirects to itemorder page
    @RequestMapping("/viewo/{id}")
    public String getCar(@PathVariable (value = "id") int id, Model model){

        model.addAttribute("number", id); // adding cart id that we got from url to the model
        ConsumerCart carts=cartOperations.gyId(id);//retrieving user cart object by using id
        model.addAttribute("carts",carts);// adding user cart to the model
        return "itemorder";// redirects to itemorder page
    }

    //getting user cart information
    @RequestMapping("/display/{i}")
    public @ResponseBody ConsumerCart getC (@PathVariable(value = "i") int i) {

        return cartOperations.gyId(i);// retrieving user cart information by using id
    }


    //adding items to the cart
    @RequestMapping(value = "/display/item/{no}/{u}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String ad (@PathVariable(value ="no") int no, @PathVariable(value ="u") String u, Model model) {
        Consumer consumer = consumerOperations.ge(u);// retrieving user by using username
        ConsumerCart consumerCart = consumer.getConsumerCart();// getting user cart
        Item item = itemOperations.gItemById(no); //getting item by using item id
        List<ConsumerItem> consumerItems = consumerCart.getCi();// getting all the items in the cart

        for (int i=0; i<consumerItems.size(); i++) {
            if(item.getItemsId()==consumerItems.get(i).getItem().getItemsId()){// here we are checking whether each item in the cart exits in the item object or not
                ConsumerItem consumerItem = consumerItems.get(i); // getting item from the item list by using index
                consumerItem.setNumber(consumerItem.getNumber()+1);// setting quantity of the item
                consumerItem.setCost(item.getiPrice()*consumerItem.getNumber());// calculating cost based on the quantity
                if (cproductOperations.am(consumerItem)){//saving the user item in the database
                    String s= "products successfully added";
                    model.addAttribute("s",s);// adding products successfully added message to the model
                    return "iteminfo"; // visits iteminfo page
                }
            }
        }

        ConsumerItem consumerItem = new ConsumerItem();//creating consumeritem object for saving all cart items in the database
        consumerItem.setNumber(1);// setting quantity of the item to 1
        consumerItem.setItem(item);// setting item object
        consumerItem.setConsumerCart(consumerCart);//setting user cart
        consumerItem.setCost(item.getiPrice()*consumerItem.getNumber());// setting the cost of the item


        if (cproductOperations.am(consumerItem)){//saving the user item in the database
            String s= "products successfully added";
            model.addAttribute("s",s);// adding products successfully added message to the model
            return "iteminfo";// visits iteminfo page
        }
        return null;// products are not added to the cart displays iteminfo page
    }

    //remove user cart item
    @RequestMapping(value = "/clear/{i}/{id}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String re (@PathVariable(value = "i") int i, @PathVariable(value = "id") int id) {
        ConsumerItem consumerItem = cproductOperations.guctId(i);// getting user cart item by using item id
        cproductOperations.rm(consumerItem); // removing the ordered item
        return  "redirect:/viewo/"+id; // redirects to this url

    }

    //removes user all cart items
    @RequestMapping(value = "/clearall/{i}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String cl(@PathVariable(value = "i") int i, Model model) {
        ConsumerCart consumerCart = cartOperations.gyId(i);// getting user cart by using cart id
        cproductOperations.rtems(consumerCart);// removing the user cart
        return  "redirect:/viewo/"+i;// redirects to this url

    }




}
