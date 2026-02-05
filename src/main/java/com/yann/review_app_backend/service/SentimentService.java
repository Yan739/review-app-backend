package com.yann.review_app_backend.service;

import com.yann.review_app_backend.entity.Sentiment;
import com.yann.review_app_backend.exception.SentimentNotFoundException;
import com.yann.review_app_backend.repository.SentimentRepository;

import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {
    private final SentimentRepository sentimentRepository;

    public SentimentService(SentimentRepository sentimentRepository) {
        this.sentimentRepository = sentimentRepository;
    }

    public Sentiment createSentiment(@NonNull Sentiment sentiment) {
        return sentimentRepository.save(sentiment);
    }

    public Sentiment getSentimentById(Long id) {
        return sentimentRepository.findById(id)
                .orElseThrow(() -> new SentimentNotFoundException(id));
    }

    public Sentiment updateSentiment(Long id, @NonNull Sentiment sentiment) {
        Sentiment existing = sentimentRepository.findById(id).orElse(null);
        if (existing == null) throw new SentimentNotFoundException(id);
        existing.setText(sentiment.getText());
        existing.setType(sentiment.getType());
        existing.setClient(sentiment.getClient());
        return sentimentRepository.save(existing);
    }

    public void deleteSentiment(Long id) {
        sentimentRepository.deleteById(id);
    }

    public Iterable <Sentiment> getAllSentiments() {
        return sentimentRepository.findAll();
    }

    public void deleteAllSentiments() {
        sentimentRepository.deleteAll();
    }

    public long countSentiments() {
        return sentimentRepository.count();
    }

    public void deleteSentimentById(Long id) {
        if (!sentimentRepository.existsById(id)) throw new SentimentNotFoundException(id);
        sentimentRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return sentimentRepository.existsById(id);
    }

}
