package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceService {
    @Autowired
    SourceBean sourceBean;

    public  void  send(String action, String message){
        sourceBean.publish(action, message);
    }
}
