package com.yann.review_app_backend.controller;

import com.yann.review_app_backend.entity.Client;
import com.yann.review_app_backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String createClient(@RequestBody Client client) {
        this.service.save(client);
        return "Client created";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getAll() {
        return this.service.getAll();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteClient(@PathVariable Long id) {
        this.service.delete(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public String updateClient(@PathVariable Long id, @RequestBody Client client) {
        this.service.update(id, client);
        return "Client with id " + id + " updated";
    }

}
