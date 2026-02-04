package com.yann.review_app_backend.repository;

import com.yann.review_app_backend.entity.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Long> {

}
