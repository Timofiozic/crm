package com.edu.crm.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;
//    @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
//    private List<Order> orderList;
    public User(){}
    public User(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
    public long getId() {
        return id;
    }
    public void setId(long PersonID) {
        this.id = PersonID;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
