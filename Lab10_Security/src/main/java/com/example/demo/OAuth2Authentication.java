package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class OAuth2Authentication {
    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> getUser(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(
                user.getUserAuthentication().getAuthorities()
        ));
        return userInfo;
    }

    private Authentication getUserAuthentication() {
        return  new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Authentication.class, args);
    }
}