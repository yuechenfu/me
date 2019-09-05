package com.pib.property.controller;

import com.alibaba.fastjson.JSONObject;
import com.pib.property.entity.Account;
import com.pib.property.service.AccountService;
import com.pib.util.JsonUtil;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.request.*;
import me.zhyd.oauth.utils.AuthStateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/2/19 9:28
 * @since 1.8
 */
@RestController
@RequestMapping("/oauth")
public class RestAuthController {
	@Autowired
    private AccountService accountService;
 

    @RequestMapping("/render/{source}")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        System.out.println("进入render：" + source);
        AuthRequest authRequest = getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        System.out.println(authorizeUrl);
        response.sendRedirect(authorizeUrl);
    }

    /**
     * oauth平台中配置的授权回调地址，以本项目为例，在创建github授权应用时的回调地址应为：http://127.0.0.1:8443/oauth/callback/github
     */
    @RequestMapping("/callback/{source}")
    public ModelAndView callback(@PathVariable("source") String source, AuthCallback callback,HttpServletRequest request)throws Exception {
    	ModelAndView mode = new ModelAndView();
    	HttpSession session = request.getSession();
        System.out.println("进入callback：" + source + " callback params：" + JSONObject.toJSONString(callback));
        AuthRequest authRequest = getAuthRequest(source);
        AuthResponse response = authRequest.login(callback);
        Account e = JsonUtil.getUserByGoogleAccount(JSONObject.toJSONString(response));
        if (accountService.countByUsername(e) == 0) accountService.save(e);
        mode.setViewName("pages/index");
        session.setAttribute("loginAccount",e);
        return  new ModelAndView("redirect:/");
    }

    @RequestMapping("/revoke/{source}/{token}")
    public Object revokeAuth(@PathVariable("source") String source, @PathVariable("token") String token) throws IOException {
        AuthRequest authRequest = getAuthRequest(source);
        return authRequest.revoke(AuthToken.builder().accessToken(token).build());
    }

    /**
     * 根据具体的授权来源，获取授权请求工具类
     *
     * @param source
     * @return
     */
    private AuthRequest getAuthRequest(String source) {
        AuthRequest authRequest = null;
        switch (source) {
            case "dingtalk":
                authRequest = new AuthDingTalkRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/dingtalk")
                        .build());
                break;
            case "baidu":
                authRequest = new AuthBaiduRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/baidu")
                        .build());
                break;
            case "github":
                authRequest = new AuthGithubRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/github")
                        .build());
                break;
            case "gitee":
                authRequest = new AuthGiteeRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/gitee")
                        .build());
                break;
            case "weibo":
                authRequest = new AuthWeiboRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/weibo")
                        .build());
                break;
            case "coding":
                authRequest = new AuthCodingRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/tencentCloud")
                        .build());
                break;
            case "tencentCloud":
                authRequest = new AuthTencentCloudRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/tencentCloud")
                        .build());
                break;
            case "oschina":
                authRequest = new AuthOschinaRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/oschina")
                        .build());
                break;
            case "alipay":
                // 支付宝在创建回调地址时，不允许使用localhost或者127.0.0.1，所以这儿的回调地址使用的局域网内的ip
                authRequest = new AuthAlipayRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .alipayPublicKey("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/alipay")
                        .build());
                break;
            case "qq":
                authRequest = new AuthQqRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/qq")
                        .build());
                break;
            case "wechat":
                authRequest = new AuthWeChatRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/wechat")
                        .build());
                break;
            case "taobao":
                authRequest = new AuthTaobaoRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/taobao")
                        .build());
                break;
            case "google":
                authRequest = new AuthGoogleRequest(AuthConfig.builder()
                        .clientId("513879893620-orme06n0s63i796odh859bimc2bf7oj4.apps.googleusercontent.com")
                        .clientSecret("etvLIhbcwyZqIgYTRWkCVtIA")
                        .redirectUri("http://127.0.0.1:8080/oauth/callback/google")
                        .build());
                break;
            case "facebook":
                authRequest = new AuthFacebookRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8080/oauth/callback/facebook")
                        .build());
                break;
            case "douyin":
                authRequest = new AuthDouyinRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/douyin")
                        .build());
                break;
            case "linkedin":
                authRequest = new AuthLinkedinRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/linkedin")
                        .build());
                break;
            case "microsoft":
                authRequest = new AuthMicrosoftRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/microsoft")
                        .build());
                break;
            case "mi":
                authRequest = new AuthMiRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/mi")
                        .build());
                break;
            case "toutiao":
                authRequest = new AuthToutiaoRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/toutiao")
                        .build());
                break;
            case "teambition":
                authRequest = new AuthTeambitionRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/teambition")
                        .build());
                break;
            case "pinterest":
                authRequest = new AuthPinterestRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/pinterest")
                        .build());
                break;
            case "renren":
                authRequest = new AuthRenrenRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/teambition")
                        .build());
                break;
            case "stackoverflow":
                authRequest = new AuthStackOverflowRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/login_success")
                        .stackOverflowKey("")
                        .build());
                break;
            case "huawei":
                authRequest = new AuthHuaweiRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/huawei")
                        .build());
                break;
            case "wechatEnterprise":
                authRequest = new AuthHuaweiRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/wechatEnterprise")
                        .agentId("")
                        .build());
            case "kujiale":
                authRequest = new AuthKujialeRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/kujiale")
                        .build());
                break;
            case "gitlab":
                authRequest = new AuthGitlabRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://localhost:8443/oauth/callback/gitlab")
                        .build());
                break;
            default:
                break;
        }
        if (null == authRequest) {
            throw new AuthException("未获取到有效的Auth配置");
        }
        return authRequest;
    }
}