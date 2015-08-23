package org.springrestoauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shaon on 8/14/2015.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
