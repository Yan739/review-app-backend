package com.yann.review_app_backend.entity;

import jakarta.persistence.*;

import javax.naming.ldap.PagedResultsControl;

@Entity
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texte;

    private TypeSentiment type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Sentiment() {
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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
