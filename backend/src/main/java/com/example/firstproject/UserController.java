package com.example.firstproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController 
{
   @Autowired
   UserRepository ur;

   @PostMapping("/register")
   // String m(String uname,String email,String psw,Model x)
   String m(@RequestBody Users nu) throws InterruptedException
   {
     String nuname=nu.getUsername();
     Users eu=this.ur.findByUsername(nuname);
     if(eu==null)
     {
        this.ur.save(nu);
        return "registratione done";
     }
     return "invalid username";



      






   //   String uname= nu.getUsername();
   //   Users eu=this.ur.findByUsername(uname);
   //   if(eu==null)
   //   {
         //  Users nu=new Users();
         // nu.setUsername(uname);
         // nu.setEmail(email);
         // nu.setPassword(psw);
     
       //  this.ur.save(nu);
         
      //    System.out.println(uname);
      // System.out.println(email);
      // System.out.println(psw);
      // x.addAttribute("username",uname);
      // x.addAttribute("usermail",email);
      // x.addAttribute("userpsw",psw);


      // return "admin";   
      //return "registration done";
   
     //return "username already exists";
        
   }
   
   @GetMapping("/log")
   String m3()
   {
      return "login";
   }

   @PostMapping("/login")
   String m4(@RequestBody Users u) throws InterruptedException
   {
     String uname= u.getUsername();
     Users eu=this.ur.findByUsername(uname);
     if(eu != null && eu.getPassword().equals(u.getPassword()))
     {
        //Thread.sleep(10000);
        return "Login successful"; 
        //return eu;                                                                 
     }
    return "invalid credentials";
    //return eu;
   }

   @PostMapping("/update")
   String m5(@RequestBody UpdatePasswordRequest u)
   {
     String uname= u.getUsername();
     Users eu=this.ur.findByUsername(uname);
     if(eu != null && eu.getPassword().equals(u.getOldPassword()))
     {
        eu.setPassword(u.getNewPassword());
        this.ur.save(eu);
        return "updated successfully";
     }
     return "invalid credentials";
   }

    @PostMapping("/delete")
   String m6(@RequestBody Users u)
   {
     String uname= u.getUsername();
     Users eu=this.ur.findByUsername(uname);
     if(eu != null && eu.getUsername().equals(u.getUsername()))
     {
        this.ur.delete(eu);
        return "deleted";
     }
     return "invalid credentials";
   }

   //@GetMapping("/vdetails")
   @GetMapping("/view")
   Users m7(@RequestParam String data)
   {
         Users u=this.ur.findByUsername(data);
         return u;
   }


   @GetMapping("/viewAll")
   List<Users> m8()
   {
         List<Users> all=this.ur.findAll();
         return all;
   }
   @GetMapping("/h")
   String m1()
   {
      return "home";
   }

   @GetMapping("/a")
   String m2()
   {
    return "admin"; 
   }
}
