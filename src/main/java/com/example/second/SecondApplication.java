package com.example.second;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SecondApplication {

	@Autowired
	public static InfoRepository infoRepository;

	public static void main(String[] args) {

		try {
			Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Dev","root", "tonystark3*");
			System.out.println("Hello");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		Info info1 = new Info();
		info1.setFirstName("1");
		info1.setMiddleName("2");
		info1.setLastName("3");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		entityManager.getTransaction().begin();
		entityManager.persist(info1);
		entityManager.getTransaction().commit();


		Info info = infoRepository.findById(1L);

		System.out.println(info.getFirstName());

	}

}
