package com.hunt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ouyangan
 * @Date 2016/11/1/19:49
 * @Description
 */
@Controller
@RequestMapping("error")
public class ErrorController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(ErrorController.class);

    /**
     * 未授权
     *
     * @return
     */
    @RequestMapping(value = "unAuthorization", method = RequestMethod.GET)
    public String unAuthorization() {
        return "system/unAuthorization";
    }

    /**
     * 404
     *
     * @return
     */
    @RequestMapping(value = "notFound", method = RequestMethod.GET)
    public String notFound() {
        return "system/404";
    }

    /**
     * 内部错误
     *
     * @return
     */
    @RequestMapping(value = "internalError", method = RequestMethod.GET)
    public String internalError() {
        return "system/500";
    }


}
