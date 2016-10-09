package com.hunt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ouyangan
 * @Date : 2016/10/9
 */
@Controller
@RequestMapping("organization")
public class OrganizationController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @RequestMapping(value = "organization", method = RequestMethod.GET)
    public String toOrganization() {

        return "system/organization";
    }
}
