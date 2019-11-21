package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SourceBean {
    private Source source;

    @Autowired
    public SourceBean(Source source){
        this.source = source;
    }

    public void publish(String action, String message){
        source.output().send(MessageBuilder.withPayload(message).build());
    }
}
