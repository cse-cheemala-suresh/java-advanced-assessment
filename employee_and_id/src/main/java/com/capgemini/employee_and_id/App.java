package com.capgemini.employee_and_id;

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
			
			//CREATE
			Employee e1 = new Employee("Suresh", "suresh@gmail.com");
			
			IDCard id1 = new IDCard("EMP1231", "12-02-2026", e1);
			
			em.persist(id1);
			
			//READ
			Employee findEmp = em.find(Employee.class, e1.getId());
			System.out.println("Employee Details");
			System.out.println("ID : " + findEmp.getId());
			System.out.println("Name : " + findEmp.getName());
			System.out.println("Email : " + findEmp.getEmail());
			
			System.out.println();
			
			IDCard findID = em.find(IDCard.class, id1.getId());
			System.out.println("ID Card Details Details");
			System.out.println("ID : " + findID.getId());
			System.out.println("Name : " + findID.getCardNumber());
			System.out.println("Email : " + findID.getIssueDate());

			
			em.getTransaction().commit();
			System.out.println("Employee and ID card Created Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
