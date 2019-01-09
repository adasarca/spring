/**
 * Created by Ada.Sarca
 * Date: 1/9/2019
 */
package com.example.spring.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World from Spring Boot!";
    }
}
