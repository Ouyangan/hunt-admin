package com.hunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.Result;

/**
 * @Author ouyangan
 * @Date 2016/10/17/16:21
 * @Description
 */
@Controller
@RequestMapping("job")
public class JobController extends BaseController {
    @RequestMapping(value = "toJob", method = RequestMethod.GET)
    public String toJob() {
        return "system/job";
    }

    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Result insert(@RequestParam long roleId,
                         @RequestParam long organizationId,
                         @RequestParam) {
        return Result.success();
    }


}
