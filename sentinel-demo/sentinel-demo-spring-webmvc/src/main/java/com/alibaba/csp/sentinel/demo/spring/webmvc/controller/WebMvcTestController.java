/*
 * Copyright 1999-2019 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.demo.spring.webmvc.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Test controller
 * @author kaizi2009
 */
@Controller
public class WebMvcTestController {

    @GetMapping("/hello")
    @ResponseBody
    public String apiHello() {
        doBusiness();
        return "Hello!";
    }

    @GetMapping("/err")
    @ResponseBody
    public String apiError() {
        doBusiness();
        return "Oops...";
    }

    @GetMapping("/foo/{id}")
    @ResponseBody
    public String apiFoo(@PathVariable("id") Long id, HttpServletRequest request) {
        doBusiness();
        System.out.println("request.getRemoteAddr()"+request.getRemoteAddr());
        System.out.println("request.getRemoteHost()"+request.getRemoteHost());
        System.out.println("request.getRemoteUser()"+request.getRemoteUser());
        System.out.println("request.getRemotePort()"+request.getRemotePort());
        System.out.println("request.getServerName()"+request.getServerName());
        System.out.println("request.getServerName()"+request.getLocalAddr());
        System.out.println("request.getServerName()"+request.getLocalName());
        System.out.println("request.getServerName()"+request.getPathInfo());
        System.out.println("request.getServerName()"+request.getLocalAddr());
       
        return "Hello " + id + "S-user:" + request.getRemoteAddr();
    }
    @GetMapping("/foo/{id}/api")
    @ResponseBody
    public String apiFoo1(@PathVariable("id") Long id, HttpServletRequest request) {
        doBusiness();
        System.out.println("request.getRemoteAddr()"+request.getRemoteAddr());
        System.out.println("request.getRemoteHost()"+request.getRemoteHost());
        System.out.println("request.getRemoteUser()"+request.getRemoteUser());
        System.out.println("request.getRemotePort()"+request.getRemotePort());
        System.out.println("request.getServerName()"+request.getServerName());
        System.out.println("request.getServerName()"+request.getLocalAddr());
        System.out.println("request.getServerName()"+request.getLocalName());
        System.out.println("request.getServerName()"+request.getPathInfo());
        System.out.println("request.getServerName()"+request.getLocalAddr());

        return "Hello " + id + "S-user:" + request.getRemoteAddr();
    }

    @GetMapping("/exclude/{id}")
    @ResponseBody
    public String apiExclude(@PathVariable("id") Long id) {
        doBusiness();
        return "Exclude " + id;
    }
    
    @GetMapping("/forward")
    public ModelAndView apiForward() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        return mav;
    }

    private void doBusiness() {
        Random random = new Random(1);
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
