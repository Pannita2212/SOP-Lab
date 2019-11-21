package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.SourceBean;
import com.example.demo.SourceService;

@RestController
public class SourceController {

    @Autowired
    SourceService sourceService;

    @RequestMapping("/source")
    public  String source(){
        sourceService.send("PUSH", "Test Message");
        return "Hello Source";
    }
}
