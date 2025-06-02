package com.tsola2002.recommendationservice.controller;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recommendations")
@CrossOrigin(origins = "http://localhost:5173")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @GetMapping("/{bookId}")
    public List<Recommendation> getRecommendationsByBookId(@PathVariable int bookId) {
        return recommendationService.getByBookId(bookId);
    }

    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.save(recommendation);
    }

    @PutMapping("/{bookId}")
    public List<Recommendation> updateRecommendationByBookId(@PathVariable int bookId, @RequestBody Recommendation recommendationDetails) {
        return recommendationService.updateRecommendationByBookId(bookId, recommendationDetails);
    }

    @DeleteMapping("/{bookId}")
    public void deleteRecommendationsByBookId(@PathVariable int bookId) {
        recommendationService.deleteByBookId(bookId);
    }
}
