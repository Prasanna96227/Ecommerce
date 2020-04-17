package com.emusicstore.controller;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.dao.SalesDao;
import com.emusicstore.dao.impl.SalesDaoImpl;
import com.emusicstore.model.BillingAddress;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ShippingAddress;
import com.emusicstore.model.ShopManagers;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SalesDao s;


    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";

    }
    @RequestMapping("/registers")
    public String registersales(Model model) {

        ShopManagers sales = new ShopManagers();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        sales.setBillingAddress(billingAddress);
        sales.setShippingAddress(shippingAddress);

        model.addAttribute("sales", sales);

        return "sales";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customerList=customerService.getAllCustomers();

        for (int i=0; i< customerList.size(); i++) {
            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "registerCustomer";
            }

            if(customer.getUsername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "registerCustomer";
            }
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";

    }

    @RequestMapping(value = "/registers", method = RequestMethod.POST)
    public String registerSalesPost(@Valid @ModelAttribute("sales") ShopManagers sales, BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            return "sales";
        }

        List<Customer> customerList=customerService.getAllCustomers();

        for (int i=0; i< customerList.size(); i++) {
            if(sales.getManagerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "sales";
            }

            if(sales.getManagername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "sales";
            }
        }

        sales.setEnabled(true);
        s.addSales(sales);

        return "registerCustomerSuccess";

    }

}
