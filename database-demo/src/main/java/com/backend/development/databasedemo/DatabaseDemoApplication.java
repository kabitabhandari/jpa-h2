package com.backend.development.databasedemo;

import com.backend.development.databasedemo.bean.Person;
import com.backend.development.databasedemo.jpa.PersonJpaDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaDAO dao;

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);

	}

	// code in command line runner is launced up as soon as application context is ready
	@Override
	public void run(String... args) throws Exception {

		Person createdPerson = dao.savePerson(new Person("kabita", new Date(),"kathmandu"));

		logger.info ("Saved User is: {} ", createdPerson);

		logger.info ("Find User by Id: {} ",dao.findById(10001));

		logger.info ("Here are the list of all users: {} ",dao.findAllPersons().toString());

		dao.delete(10003);

		logger.info ("Insert a Person Object {} ",dao.insert(new Person("Joseph", new Date(), "kathmandu")));

		logger.info ("Updating a Person Object {} ",dao.update(new Person("JosephH", new Date(),"kathmandu")));
}
}
