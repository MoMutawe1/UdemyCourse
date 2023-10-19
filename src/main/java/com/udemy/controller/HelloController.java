package com.udemy.controller;

import com.udemy.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greetingMessage() {
        return "Hello Udemy!";
    }

    @GetMapping("/callMe")
    public User getUser(){
        return new User("123","Mohammad","mohammad@gmail.com");
    }

    @GetMapping("/{id}/{name}")
    public String pathVariable(@PathVariable String id, @PathVariable String name){
        return "Id value: " + id + " and, Username: " + name;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name,@RequestParam String emailId){
        return "filter by: " + name + " , email: " + emailId;
    }
}
