package com.backend.development.databasedemo.jpa;

import com.backend.development.databasedemo.bean.Person;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//this class talks to the database
@Repository
@Transactional
public class PersonJpaDAO {
    //connect to database
    @PersistenceContext
    EntityManager entityManager;



    //select * from person
    public List<Person> findAllPersons() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    //select a person from his id
    public Person findById( int id){
        Person person = entityManager.find(Person.class, id);
        return person;
    }


    public Person savePerson(Person person ){
     entityManager.persist(person);
        return person;
    }


    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void delete(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
