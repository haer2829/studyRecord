package com.haer.nginx.nginxdemo;

public class Service1Impl implements Service1{

    @Override
    public String action1(String name) {
        return "i am "+name;
    }
}
