package com.levin.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "cliError")
    public String cliService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLI/cli?name=" + name, String.class);
    }

    public String cliError(String name) {
        return "hi," + name + ", sorry, error!";
    }
}