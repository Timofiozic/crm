package com.edu.crm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column (name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Orders> orderList;

    private String lastName;
    private int age;

    private List<Orders> getUserList() {
        return orderList;
    }
    private void setUserList(List<Orders> userList) {
        this.orderList = userList;
    }

    public User(){}
    public User(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
        orderList = new ArrayList<>();
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

    public void addOrder(Orders order){
        order.setUser(this);
        orderList.add(order);
    }


}
