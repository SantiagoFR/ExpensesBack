package com.autentia.expensesapplication.entities;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;
    private String fullname;

    public Friend() {}

    public Friend(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = firstname + ' ' + lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return fullname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
