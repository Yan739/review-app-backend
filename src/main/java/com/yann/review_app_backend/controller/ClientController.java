package com.yann.review_app_backend.controller;

import com.yann.review_app_backend.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String createClient(@RequestBody Client client) {
        return "Client created";
    }

}
