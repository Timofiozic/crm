package com.edu.crm.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name = "order")
public class Order {

    private String description;
    private int sum;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Calendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Calendar creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    private Calendar creationTimestamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
