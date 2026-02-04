package com.yann.review_app_backend.service;

import com.yann.review_app_backend.entity.Sentiment;
import com.yann.review_app_backend.repository.SentimentRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SentimentService {
    private final SentimentRepository sentimentRepository;

    public SentimentService(SentimentRepository sentimentRepository) {
        this.sentimentRepository = sentimentRepository;
    }

    public void createSentiment(Sentiment sentiment) {
        sentimentRepository.save(sentiment);
    }

    public Sentiment getSentimentById(Long id) {
        return sentimentRepository.findById(id).orElse(null);
    }

    public void updateSentiment(Long id, Sentiment sentiment) {
        Sentiment existingSentiment = sentimentRepository.findById(id).orElse(null);
        if (existingSentiment != null) {
            existingSentiment.setTexte(sentiment.getTexte());
            existingSentiment.setType(sentiment.getType());
            existingSentiment.setClient(sentiment.getClient());
            sentimentRepository.save(existingSentiment);
        }
    }

    public void deleteSentiment(Long id) {
        sentimentRepository.deleteById(id);
    }

    public List<Sentiment> getAllSentiments() {
        return sentimentRepository.findAll();
    }

    public void deleteAllSentiments() {
        sentimentRepository.deleteAll();
    }

    public long countSentiments() {
        return sentimentRepository.count();
    }

    public void deleteSentimentById(Long id) {
        sentimentRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return sentimentRepository.existsById(id);
    }

}
