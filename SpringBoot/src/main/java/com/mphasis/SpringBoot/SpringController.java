package com.mphasis.SpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SpringController {

   @GetMapping("/welcome")
   public Student handler(){
       return new Student(22,"Sairam","India");

    }
}
