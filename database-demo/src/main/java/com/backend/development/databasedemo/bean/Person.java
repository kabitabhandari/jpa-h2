package com.backend.development.databasedemo.bean;


import com.sun.javafx.beans.IDProperty;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date birth_date;
    private String location;


    public Person(){

    }

    public Person(String name, Date birth_date, String location) {
        this.name = name;
        this.birth_date = birth_date;
        this.location = location;
    }

}
