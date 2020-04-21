package com.levin.serviceribbon.controller;

import com.levin.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/cli")
    public String hi(@RequestParam String name) {
        return helloService.cliService( name );
    }
}
