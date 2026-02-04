package com.yann.review_app_backend.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getTestMessage(){
        return "Hello this is a test of the api !";
    }
}
