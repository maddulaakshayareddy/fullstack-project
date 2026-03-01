package com.example.firstproject;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Users 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int xyz;

    @Column
    String username;

    @Column
    String email;

    @Column
    String password;


    public String getEmail()
    {
        return this.email;
    }
    void setUsername(String n)
    {
        this.username=n;
    }
    void setEmail(String e)
    {
        this.email=e;
    }
    void setPassword(String p)
    {
        this.password=p;
    }

   public  String getUsername()
    {
        return this.username;
    }

   public String getPassword()
    {
        return this.password;
    }
}
