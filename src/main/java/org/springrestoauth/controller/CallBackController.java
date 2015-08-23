package org.springrestoauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shaon on 8/23/2015.
 */
@Controller
public class CallBackController {

    @RequestMapping("/callback")
    public String index(@RequestParam("code") String code) {
        return "This is the dummy callback" + code;
    }
}
