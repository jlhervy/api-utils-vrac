package com.example.monitoringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifeCheckController {

    private final LifeCheckRepository repository;

    LifeCheckController(LifeCheckRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/lifecheck")
    long all() {
        return repository.findAll().stream().count();
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
