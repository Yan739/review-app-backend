package com.yann.review_app_backend.controller;

import com.yann.review_app_backend.entity.Sentiment;
import com.yann.review_app_backend.service.SentimentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private final SentimentService service;

    public SentimentController(SentimentService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Sentiment> create(@Valid @RequestBody Sentiment sentiment){
        Sentiment createdSentiment = service.createSentiment(sentiment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSentiment);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Sentiment>> getAllSentiments() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllSentiments());
    }

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Sentiment> getSentimentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSentimentById(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteSentiment(@PathVariable Long id) {
        service.deleteSentiment(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Sentiment> updateSentiment(@PathVariable Long id, @RequestBody Sentiment sentiment) {
        Sentiment updated = service.updateSentiment(id, sentiment);
        return ResponseEntity.ok(updated);
    }
}
