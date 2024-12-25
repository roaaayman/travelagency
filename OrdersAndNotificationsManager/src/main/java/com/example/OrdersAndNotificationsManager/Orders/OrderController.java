package com.example.OrdersAndNotificationsManager.Orders;

import com.example.OrdersAndNotificationsManager.Customers.Customer;
import com.example.OrdersAndNotificationsManager.Customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    // API endpoint to place a simple order
    @PostMapping("/simple")
    public String placeSimpleOrder(@RequestParam String email, @RequestParam List<String> productNames) {
        // Check if the customer exists
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer == null) {
            return "email not available";
        }

        // Create a simple order
        SimpleOrder simpleOrder = new SimpleOrder(customer);
        // simpleOrder.setShippingFee(shippingFee);

        // Place the order

        return orderService.placeOrder(simpleOrder, productNames);
    }


    // API endpoint to place a compound order
    @PostMapping("/compound")
    public List<String> placeCompoundOrder(
            @RequestParam String customerEmail,
            @RequestParam List<String> friendEmails,
            @RequestParam List<String> customerProductNames,
            @RequestParam List<List<String>> friendProductNames
    ) {
        List<String> results = new ArrayList<>();
        // Check if the main customer exists
        Customer mainCustomer = customerService.getCustomerByEmail(customerEmail);
        if (mainCustomer == null) {
            return Collections.singletonList("main customer not available");
        }

        // Create a compound order
        CompoundOrder compoundOrder = new CompoundOrder();

        // Add a simple order for the main customer with the specified product names
        SimpleOrder mainCustomerOrder = new SimpleOrder(mainCustomer);
        compoundOrder.addSimpleOrder(mainCustomerOrder);



        // Add simple orders for friends with their specified product names
        for (int i = 0; i < friendEmails.size(); i++) {
            String friendEmail = friendEmails.get(i);
            List<String> friendProductList = friendProductNames.get(i);

            // Check if the friend customer exists
            Customer friendCustomer = customerService.getCustomerByEmail(friendEmail);
            if (friendCustomer == null) {
                results.add("Friend email not available: " + friendEmail);
                continue;
            }

            // Check if the friend's location matches the main customer's location
            if (!friendCustomer.getLocation().equals(mainCustomer.getLocation())) {
                results.add("Friend " + friendEmail + " has a different location than the customer");
                continue;
            }

            // Create and add a simple order for the friend
            SimpleOrder friendOrder = new SimpleOrder(friendCustomer);
            compoundOrder.addSimpleOrder(friendOrder);

            // Place the specified products in the order for the friend
            String friendResult = orderService.placeOrder(friendOrder, friendProductList);
            results.add("Friend " + friendEmail + ": " + friendResult);
        }

        // Place the compound order for the main customer with the specified product names
        String mainCustomerResult = orderService.placeOrder(mainCustomerOrder, customerProductNames);
        results.add("Main Customer: " + mainCustomerResult);

        // Place the compound order
        String compoundOrderResult = orderService.placeOrder(compoundOrder,customerProductNames);
        results.add("Compound Order: " + compoundOrderResult);

        return results;
    }
}