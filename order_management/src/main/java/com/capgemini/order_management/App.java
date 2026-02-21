package com.capgemini.order_management;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Customer customer1 = new Customer("Suresh", "suresh@email.com");
			
			Order order1 = new Order(LocalDate.now(), 2000, customer1);
			Order order2 = new Order(LocalDate.now(), 1000, customer1);
			Order order3 = new Order(LocalDate.now(), 2200, customer1);
			
			OrderItem orderitem1 = new OrderItem("Laptop", 1, 2000, order1);
			OrderItem orderitem2 = new OrderItem("Mobile", 1, 2000, order1);
			OrderItem orderitem3 = new OrderItem("Table", 1, 2000, order2);
			OrderItem orderitem4 = new OrderItem("Desk", 1, 2000, order3);
			OrderItem orderitem5 = new OrderItem("Camera", 1, 2000, order3);
			
			order1.setOrderItems(Arrays.asList(orderitem1, orderitem2));
			order2.setOrderItems(Arrays.asList(orderitem3));
			order3.setOrderItems(Arrays.asList(orderitem4, orderitem5));
			
			customer1.setOrders(Arrays.asList(order1, order2, order3));
			
			em.persist(customer1);
			
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
