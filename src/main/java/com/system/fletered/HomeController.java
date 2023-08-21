package com.system.fletered;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController {

    @GetMapping({"/", "/home", "/status"})
    public String getStatus(){
        return "Application is running";
    }
    
}
