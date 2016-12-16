package com.hunt.controller;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hunt.util.Result;
import com.hunt.util.SystemConstant;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: ouyangan
 * @Date : 2016/10/23
 */
@Controller
@RequestMapping("oauth")
public class OauthController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(OauthController.class);

    //https://github.com/login/oauth/authorize?client_id=f4b35940357e82596645&state=111111&redirect_uri=http://127.0.0.1:8080/oauth/github
    @RequestMapping(value = "github", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result github(HttpServletRequest request) throws IOException {
        log.debug(request.getParameter("code"));
        String code = request.getParameter("code");
        if (StringUtils.hasText(code)) {
            String access_token_url = "https://github.com/login/oauth/access_token?client_id=" + SystemConstant.github_client_id + "&client_secret=" + SystemConstant.github_client_secret + "&code=" + code + "&redirect_uri=" + SystemConstant.github_oauth_url;
            CloseableHttpClient client = HttpClients.createDefault();
            RequestConfig config = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .build();
            HttpGet getAccessToken = new HttpGet(access_token_url);
            getAccessToken.setConfig(config);
            String access_token_info = EntityUtils.toString(client.execute(getAccessToken).getEntity());
            log.debug("access_token_response:{}", access_token_info);
            String access_token = access_token_info.subSequence(access_token_info.indexOf("=") + 1, access_token_info.indexOf("&")).toString();
            log.debug("acccess_token:{}", access_token);
            String user_info_url = "https://api.github.com/user?access_token=" + access_token;
            HttpGet getUserInfo = new HttpGet(user_info_url);
            getUserInfo.setConfig(config);
            String user_info = EntityUtils.toString(client.execute(getUserInfo).getEntity());
            log.debug("user_info:{}", user_info);
            client.close();
            SecurityUtils.getSubject().login(new UsernamePasswordToken("admin", "111111"));
        }
        return Result.success();
    }
}
