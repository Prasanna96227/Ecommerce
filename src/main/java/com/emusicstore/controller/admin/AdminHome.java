package com.emusicstore.controller.admin;

import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        List<Product> product = productService.getProductByType("admin");
        model.addAttribute("product",product);

        return "productInventory";
    }

    @RequestMapping("/shop")
    public String shop(Model model){

        return "ShopManager";
    }

    @RequestMapping("/shop/productInventory")
    public String shopproduct(Model model) {List<Product> product = productService.getProductByType("shop");
        model.addAttribute("product",product);

        return "productInventory";
    }

    @RequestMapping("/admin/customer")
    public String customerManagement(Model model) {

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }
}
