package com.wfa.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value="hello")
    @ResponseBody
    public String sayHelloTeam(@RequestParam("name") String aName)
    {
        return "Hello " + aName;
    }
}
