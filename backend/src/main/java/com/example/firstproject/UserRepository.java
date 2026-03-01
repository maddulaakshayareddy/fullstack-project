package com.example.firstproject;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users,Integer>
{
   Users findByUsername(String n);

//    Users m1()
//    {
//      return new Users();
//    }
}
