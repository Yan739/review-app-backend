package com.yann.review_app_backend.service;

import com.yann.review_app_backend.entity.Client;
import com.yann.review_app_backend.repository.ClientRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String save(Client client) {
        Client saved =  clientRepository.save(client);
        return "Client " + saved.getId() + " created";
    }

    public List<Client> getAll() {
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

    public Client getById(Long id) {
        return clientRepository.findClientById(id);
    }

    public String update(Long id, @NonNull Client client) {
        Client found = clientRepository.findClientById(id);

        found.setEmail(client.getEmail());

        clientRepository.save(found);
        return "Client " + id + " updated";
    }

    public String delete(Long id) {
        clientRepository.deleteById(id);
        return "Client " + id + " deleted";
    }

}
