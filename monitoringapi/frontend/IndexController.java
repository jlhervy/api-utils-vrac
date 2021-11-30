package com.example.monitoringapi.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/w")
    public String index() {
        return "index";
    }

}
