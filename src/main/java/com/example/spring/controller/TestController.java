/**
 * Created by Ada.Sarca
 * Date: 1/9/2019
 */
package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(name = "/test", method = RequestMethod.GET)
    public ModelAndView test(@RequestParam(name = "name", required = false) String name) {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("name", name);
        return mv;
    }
}
