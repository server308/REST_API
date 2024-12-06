package com.example.zadanie45riat.controllers;

import com.example.zadanie45riat.services.DogApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RandomDogController {

    private final DogApiService dogApiService;

    public RandomDogController(DogApiService dogApiService) {
        this.dogApiService = dogApiService;
    }

    @GetMapping("/random-dogs")
    public ResponseEntity<List<String>> getRandomDogImages() {
        try {

            List<String> images = dogApiService.getRandomDogImages(10);
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            System.err.println("Ошибка при запросе Dog API: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }
}
