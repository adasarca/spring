/*
 * Created by Ada.Sarca
 * Date: 9/9/2019
 */
package com.example.spring.rest;

import com.example.spring.model.exception.DatabaseException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured({"ROLE_REST_USER"})
@RequestMapping("/rest")
public class ProtectedRestController {

    @RequestMapping("/test")
    public String test() {
        return "Test";
    }

    @RequestMapping("/test/exception")
    public String testException() throws DatabaseException {
        throw new DatabaseException("Fallimento");
    }
}
