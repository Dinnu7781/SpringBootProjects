package net.jaswanth.SpringBootRestAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/getHelloWorld")
    public String helloWorld(){
        return "Hello Jaswanth!!!!!!....";
    }
}
