package com.yann.review_app_backend.service;

import com.yann.review_app_backend.entity.Client;
import com.yann.review_app_backend.exception.ClientNotFoundException;
import com.yann.review_app_backend.exception.DuplicateEmailException;
import com.yann.review_app_backend.repository.ClientRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client save(@NonNull Client client) {

        if (client.getId() == null && repository.existsByEmail(client.getEmail())) {
            throw new DuplicateEmailException(client.getEmail());
        }
        return repository.save(client);
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Client update(Long id, @NonNull Client client) {
        Client existing = getById(id);


        if (!existing.getEmail().equals(client.getEmail()) &&
                repository.existsByEmail(client.getEmail())) {
            throw new DuplicateEmailException(client.getEmail());
        }

        existing.setEmail(client.getEmail());
        return repository.save(existing);
    }

    public Client findByEmail(String email) {
        return repository.findByEmail(email);
    }
}