package com.yann.review_app_backend.controller;

import com.yann.review_app_backend.entity.Client;
import com.yann.review_app_backend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping(value = "client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client created = this.service.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients () {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Client>updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
        Client updated = this.service.update(id, client);
        return ResponseEntity.ok(updated);
    }

}
