package org.cg.controller;

import org.cg.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cp/customer")
public class CustomerCPController {
    static List<Customer> customers = new ArrayList<Customer>();
    static long customerId = 1l;

    static {
        Customer customer1 = new Customer(customerId++,"thanh hoan","th12@gmail.com","12343","hue", BigDecimal.valueOf(1234));
        Customer customer2 = new Customer(customerId++,"thanh hoan","th12@gmail.com","12343","hue", BigDecimal.valueOf(1234));
        Customer customer3 = new Customer(customerId++,"thanh hoan","th12@gmail.com","12343","hue", BigDecimal.valueOf(1234));
        Customer customer4 = new Customer(customerId++,"thanh hoan","th12@gmail.com","12343","hue", BigDecimal.valueOf(1234));
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }

    @GetMapping("/list")
    public String showListPage(Model model){
        model.addAttribute("customers",customers);
        return ("cp/customer/list");
    }

    @GetMapping("/create")
    public String showCreatePage(ModelMap modelMap){
        modelMap.addAttribute("customer",new Customer());
        return ("cp/customer/create");
    }
    @PostMapping("/create")
    public String doCreateCustomer(ModelMap modelMap, @ModelAttribute Customer customer){
        customer.setId(customerId++);
        customers.add(customer);
        modelMap.addAttribute("customer",new Customer());
        return ("cp/customer/create");
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(ModelMap modelMap, @PathVariable long id){
        for(Customer customer : customers) {
            if(customer.getId()==id) {
                modelMap.addAttribute("customer",customer);
            }
        }
        return ("cp/customer/edit");
    }
    @PostMapping("/edit/{id}")
    public String doEditCustomer(ModelMap modelMap,@ModelAttribute Customer customer ){
        for(Customer customer1 : customers) {
            if(customer1.getId() == customer.getId()) {
               customer1.setFullName(customer.getFullName());
               customer1.setEmail(customer.getEmail());
               customer1.setPhone(customer.getPhone());
               customer1.setAddress(customer.getAddress());
               customer1.setBalance(customer.getBalance());
            }
        }
        modelMap.addAttribute("customer",customer);
        modelMap.addAttribute("customers", customers);
        return ("cp/customer/list");
    }

    @GetMapping("/delete/{id}")
    public String showDeletePage(ModelMap modelMap, @PathVariable long id){
        for(Customer customer : customers) {
            if(customer.getId() == id) {
                modelMap.addAttribute("customer",customer);
            }
        }
        return ("cp/customer/delete");
    }

    @PostMapping("/delete/{id}")
    public String doDeleteCustomer(ModelMap modelMap, @PathVariable long id){
            for (Customer customer : customers) {
                if (customer.getId()== id) {
                    customers.remove(customer);
                    break;
                }
            }
        modelMap.addAttribute("customers",customers);
        return ("cp/customer/list");
    }


    @GetMapping("/view/{id}")
    public String showViewPage(ModelMap modelMap, @PathVariable long id){
        for(Customer customer : customers) {
            if(customer.getId()==id) {
                modelMap.addAttribute("customer",customer);
            }
        }
        return ("cp/customer/view");
    }

}
