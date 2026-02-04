package com.yann.review_app_backend.controller;

import com.yann.review_app_backend.entity.Sentiment;
import com.yann.review_app_backend.service.SentimentService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Sentiment sentiment){
        service.createSentiment(sentiment);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<Sentiment> getAllSentiments() { return service.getAllSentiments(); }

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Sentiment getSentimentById(@PathVariable Long id) {
        return service.getSentimentById(id);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSentiment(@PathVariable Long id) {
        service.deleteSentiment(id);
    }


    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateSentiment(@PathVariable Long id, @RequestBody Sentiment sentiment) {
        service.updateSentiment(id, sentiment);
    }
}
