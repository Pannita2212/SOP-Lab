package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;


@SpringBootApplication
@EnableBinding(Sink.class)
public class SinkApp {
    public static void main(String[] args) {
        SpringApplication.run(SinkApp.class, args);
    }
    @StreamListener(Sink.INPUT)
    public void  loggerSink(String orgChange){
        System.out.println("Received an event :" + orgChange);
    }
}
