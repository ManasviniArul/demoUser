package com.example.demoUser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Users")
public class User {
    private long id;
    private String firstName;
    /*private String lastName;
    private Date dob;
    private int age;
    private String address;
    private long contact_number;
    private String email;*/


    public User() {

    }

    public User(long id,String firstName) {
        this.id=id;
        this.firstName = firstName;

    }

    @Id
    @Column(name = "id", nullable=false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + "]";
    }
}
