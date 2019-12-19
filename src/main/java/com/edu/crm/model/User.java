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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Orders> orderList;

    private String lastName;
    private int age;

    public List<Orders> getUserList() {
        return orderList;
    }
    public void setUserList(List<Orders> userList) {
        this.orderList = userList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
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
