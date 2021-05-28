package com.autentia.expensesapplication.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author;
    private String description;
    private Date date;
    private float amount;

    public Expense() {}

    public Expense(String author, String description, java.util.Date date, float amount) {
        this.author = author;
        this.description = description;
        this.date = new Date(date.getTime());
        this.amount = amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }
}
