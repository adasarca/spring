/**
 * Created by Ada.Sarca
 * Date: 1/9/2019
 */
package com.example.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeMethod
    public void beforeMethod() {
        this.baseUrl = "http://localhost:" + port;
    }

    @Test
    public void testHello() {
        String url = this.baseUrl + "/hello";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        assertEquals(response.getBody(), "Hello World from Spring Boot!");
    }
}