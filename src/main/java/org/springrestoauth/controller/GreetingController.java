package org.springrestoauth.controller;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springrestoauth.domain.Student;

/**
 * Created by Shaon on 8/19/2015.
 */
@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public String index() {
        return "greeting";
    }

}
