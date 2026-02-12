package com.yann.review_app_backend.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "text can't be empty")
    @Size(min = 10, max = 500, message = "text must be between 10 and 500 characters")
    private String text;

    @NotNull(message = "type can't be empty")
    @Enumerated(EnumType.STRING)
    private TypeSentiment type;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "client can't be empty")
    private Client client;

    public Sentiment() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
