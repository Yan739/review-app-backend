package com.yann.review_app_backend.repository;

import com.yann.review_app_backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);

    boolean existsByEmail(String email);
}
