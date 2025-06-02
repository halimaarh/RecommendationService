package com.tsola2002.recommendationservice.services;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    // Get all recommendations
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    // Get all recommendations for a specific book
    public List<Recommendation> getByBookId(int bookId) {
        return recommendationRepository.findAllByBookId(bookId);
    }

    // Create a new recommendation
    public Recommendation save(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Update all recommendations for a specific book ID
    public List<Recommendation> updateRecommendationByBookId(int bookId, Recommendation recommendationDetails) {
        List<Recommendation> recommendations = recommendationRepository.findAllByBookId(bookId);
        if (recommendations.isEmpty()) {
            throw new RuntimeException("No recommendations found for bookId " + bookId);
        }

        for (Recommendation recommendation : recommendations) {
            recommendation.setAuthor(recommendationDetails.getAuthor());
            recommendation.setRate(recommendationDetails.getRate());
            recommendation.setContent(recommendationDetails.getContent());
        }

        return recommendationRepository.saveAll(recommendations);
    }

    // Delete all recommendations by book ID
    public void deleteByBookId(int bookId) {
        List<Recommendation> recommendations = recommendationRepository.findAllByBookId(bookId);
        recommendationRepository.deleteAll(recommendations);
    }
}
