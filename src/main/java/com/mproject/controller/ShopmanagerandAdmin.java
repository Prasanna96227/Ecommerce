package com.mproject.controller;

import com.mproject.dao.ConsumerOperations;
import com.mproject.dao.CproductOperations;
import com.mproject.dao.ItemOperations;
import com.mproject.dao.SalesOperations;
import com.mproject.model.Consumer;
import com.mproject.model.Display;
import com.mproject.model.Item;
import com.mproject.model.SManagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ShopmanagerandAdmin {

    //creating path reference
    private Path sp;

    // getting ItemOperations implementation class object (ItemOperation)
    @Autowired
    private ItemOperations itemOperations;

    // getting ConsumerOperations implementation class object(ConsumerOperation)
    @Autowired
    private ConsumerOperations consumerOperations;

    // getting SalesOperations implementation class object(SalesOperation)
    @Autowired
    private SalesOperations salesDao;

    //redirects to apage
    @RequestMapping("/apage")
    public String aPage() {
        return "apage"; //redirects to admin page
    }

    //redirects to itemmodifications page
    @RequestMapping("/itemmodifications")
    public String tory(Model model) {
        List<Item> items1 = itemOperations.gItemByType("admin");// getting admin items from the database
        model.addAttribute("item",items1); // adding items list object to the model

        return "itemmodifications"; //redirects to itemmodifications page
    }

    //redirects to smpage
    @RequestMapping("/shop/{name}")
    public String shop(Model model, @PathVariable("name") String name){
        model.addAttribute("s",name);//adding the shop manager username that we got from url to the model
        return "smpage"; //redirects to smpage
    }

    //redirects to itemmodifications
    @RequestMapping("/shop/itemmodifications/{type}")
    public String roduct(@PathVariable("type") String type, Model model) {
        List<Item> items = itemOperations.gItemByType(type);// getting respective shop manager items from the database
        model.addAttribute("item",items);// adding items list object to the model

        return "itemmodifications";//redirects to itemmodifications
    }

    //redirects to consumerlist
    @RequestMapping("/consumerlist")
    public String cgement(Model model) {

        List<Consumer> consumers = consumerOperations.gomers();// getting users from the database
        model.addAttribute("co", consumers);// adding user list object to the model

        return "consumerlist";//redirects to consumerlist
    }

    //redirects to viewsm
    @RequestMapping("/shoplist")
    public String shopmanger(Model model) {

        List<SManagers> shopManagers = salesDao.getAllSales();// getting shop managers from the database
        model.addAttribute("shopManagers", shopManagers);//adding shop managers list object to the model

        List<Item> items = itemOperations.gItemList();// getting items from database
        model.addAttribute("items", items);// adding items list object to the model

        return "viewsm";//redirects to viewsm
    }

    //redirects to smreg
    @RequestMapping("/smreg")
    public String shopmangr(Model model) {

        List<SManagers> shopManagers = salesDao.getAllSales();// getting shop managers from the database
        model.addAttribute("shopManagers", shopManagers);//adding shop managers list object to the model

        List<Item> items = itemOperations.gItemList();// getting items from database
        model.addAttribute("items", items);// adding items list object to the model

        return "smreg";//redirects to smreg
    }

    //redirects to display
    @RequestMapping("/uapage/{name}")
    public String shopmang(Model model,  @PathVariable("name") String name) {
        List<Display> l=consumerOperations.gname(name);//getting users list by using the type of person(admin or shop manager) from the database

        model.addAttribute("l",l);// adding users list object to the model
        return "display";//redirects to display
    }

    //redirects to display page
    @RequestMapping("/shop/customer/{name}")
    public String shust(Model model, @PathVariable("name") String name){
        List<Display> l=consumerOperations.gname(name);//getting users list by using the type of person(admin or shop manager) from the database

        model.addAttribute("l",l);// adding users list object to the model
        return "display";//redirects to display page
    }

    //adding type of the items to the list from which the admin or shop manager can select while adding the products
    @ModelAttribute("typeofitem")
    public List<String> getType() {
        List<String> typeofitem = new ArrayList<String>();//creating list object
        typeofitem.add("electronics");//adding data to the list
        typeofitem.add("clothes");//adding data to the list
        typeofitem.add("footwear");//adding data to the list
        typeofitem.add("food");//adding data to the list
        return typeofitem;// returning the list
    }


    //creating item object and returning it
    @ModelAttribute("items")
    @RequestMapping(value = "/appendshopitem", method = RequestMethod.GET)
    public Item getTy() {
        Item items = new Item();// creating item object
        return items;//returning item object
    }

    //creating item object and returning it
    @ModelAttribute("item")
    @RequestMapping(value = "/append", method = RequestMethod.GET)
    public Item aduct() {
        Item item = new Item();// creating item object
        return item;//returning item object
    }

    //redirects to /itemmodifications url by adding admin item into the database
    @RequestMapping(value="/append", method = RequestMethod.POST)
    public String addtPost(@Valid @ModelAttribute("item") Item item, HttpServletRequest request) {
        itemOperations.addItem(item);// adding item object into database table
        MultipartFile i = item.getiImage();//getting image from item object
        String d = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(d + "\\WEB-INF\\resources\\pictures\\"+item.getItemsId()+".png");//path with file name and directory list
        if (i != null && !i.isEmpty()) {//checking whether the exists or not
            try {
                i.transferTo(new File(sp.toString()));// converting multipart file to file
            } catch (Exception exception) {
                exception.printStackTrace();//prints classname with line number where the error occured
            }
        }
        return "redirect:/itemmodifications";//redirects to itemmodifications page
    }

    //redirects to /shop/itemmodifications/ url by adding shopmanager item into the database
    @RequestMapping(value="/appendshopitem", method = RequestMethod.POST)
    public String a(@Valid @ModelAttribute("items") Item item,
                                     HttpServletRequest request) {
        itemOperations.addItem(item);// adding item object into database table

        MultipartFile i = item.getiImage();//getting image from item object
        String d = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(d + "\\WEB-INF\\resources\\pictures\\"+item.getItemsId()+".png");//path with file name and directory list


        if (i != null && !i.isEmpty()) {//checking whether the exists or not
            try {
                i.transferTo(new File(sp.toString()));// converting multipart file to file
            } catch (Exception exception) {
                exception.printStackTrace();//prints classname with line number where the error occured
            }
        }
        String a = item.getTypeofperson();// getting the username of the shop manager

        return "redirect:/shop/itemmodifications/"+a; //redirects to /shop/itemmodifications/ url by adding respective shopmanager username to it
    }

    //redirects to update page
    @RequestMapping("/update/{id}")
    public String eoduct(@PathVariable("id") int id, Model model) {

        Item uitem = itemOperations.gItemById(id);//getting the item object by using item id
        model.addAttribute("uitem", uitem);// adding item object to the model
        return "update";//redirects to update page
    }

    //redirects to updateshopitem page
    @RequestMapping("/updateshopitem/{id}")
    public String ep(@PathVariable("id") int id, Model model) {
        Item usitem = itemOperations.gItemById(id);//getting the item object by using item id
        model.addAttribute("usitem", usitem);// adding item object to the model
        return "updateshopitem";//redirects to updateshopitem page
    }

    //redirects to itemsmodifications url by updating admin item into the database
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String edst(@Valid @ModelAttribute("uitem") Item item, HttpServletRequest request) {

        MultipartFile i = item.getiImage();//getting image from item object
        String d = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(d + "\\WEB-INF\\resources\\pictures\\"+item.getItemsId()+".png");//path with file name and directory list

        if (i != null && !i.isEmpty()) {//checking whether the exists or not
            try {
                i.transferTo(new File(sp.toString()));// converting multipart file to file
            } catch (Exception exception) {
                exception.printStackTrace();//prints classname with line number where the error occured
            }
        }

        itemOperations.updateItem(item);//updating admin item object in the database table

        return "redirect:/itemmodifications";//redirects to itemsmodifications url
    }

    //redirects to /shop/itemmodifications/ url by updating shopmanager item into the database
    @RequestMapping(value="/updateshopitem", method = RequestMethod.POST)
    public String eost(@Valid @ModelAttribute("usitem") Item item,
                                  HttpServletRequest request) {
        MultipartFile i = item.getiImage();//getting image from item object
        String d = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(d + "\\WEB-INF\\resources\\pictures\\"+item.getItemsId()+".png");//path with file name and directory list

        if (i != null && !i.isEmpty()) {//checking whether the exists or not
            try {
                i.transferTo(new File(sp.toString()));// converting multipart file to file
            } catch (Exception exception) {
                exception.printStackTrace();//prints classname with line number where the error occured
            }
        }

        itemOperations.updateItem(item);//updating item object in the database table
        String a = item.getTypeofperson();//getting shop manager username from item object
        return "redirect:/shop/itemmodifications/"+a;//redirects to /shop/itemmodifications/ url by adding respective shopmanager username to it
    }

    //redirects to itemmodification url by deleting admin product
    @RequestMapping("/removeitem/{id}")
    public String delete(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(rootDirectory + "\\WEB-INF\\resources\\pictures\\" + id + ".png");//path with file name and directory list

        Item item = itemOperations.gItemById(id);//getting the item object by using item id
        itemOperations.removeItem(item);// removing item object from the database

        return "redirect:/itemmodifications"; //redirects to itemmodification url
    }

    //redirects to /shop/itemmodification url by deleting respective shopmanager item
    @RequestMapping("/removeshopitem/{id}")
    public String deleteshop(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");//getting the path
        sp = Paths.get(rootDirectory + "\\WEB-INF\\resources\\pictures\\" + id + ".png");//path with file name and directory list


        Item item = itemOperations.gItemById(id);//getting the item object by using item id
        String a = item.getTypeofperson();//getting respective shopmanager username from item object
        itemOperations.removeItem(item);// removing item object from the database

        return "redirect:/shop/itemmodifications/"+a;//redirects to itemmodification url by adding respective shopmanager username to it
    }
}
