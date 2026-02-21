package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class OrderManagementService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomerWithOrders() {

        Customer customer = new Customer();
        customer.setCustomerName("Sai");
        customer.setEmail("sai@gmail.com");

        Order order1 = new Order();
        order1.setOrderDate(LocalDate.now());
        order1.setTotalAmount(2000);
        order1.setCustomer(customer);

        OrderItem item1 = new OrderItem();
        item1.setProductName("Laptop");
        item1.setQuantity(1);
        item1.setPrice(2000);
        item1.setOrder(order1);

        order1.setOrderItems(Arrays.asList(item1));

        customer.setOrders(Arrays.asList(order1));

        customerRepository.save(customer);
    }

    public void fetchCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer != null) {
            System.out.println("Customer: " + customer.getCustomerName());

            customer.getOrders().forEach(order -> {
                System.out.println("Order ID: " + order.getOrderId());
                order.getOrderItems().forEach(item ->
                        System.out.println("Item: " + item.getProductName())
                );
            });
        }
    }
}