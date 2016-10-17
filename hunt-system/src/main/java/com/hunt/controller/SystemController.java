package com.hunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ouyangan
 * @Date : 2016/10/17
 */
@Controller
@RequestMapping("system")
public class SystemController {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex() {
        return "system/index";
    }
}
