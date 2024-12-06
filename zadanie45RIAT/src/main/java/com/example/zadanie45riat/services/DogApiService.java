package com.example.zadanie45riat.services;

import com.example.zadanie45riat.models.DogApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogApiService {

    private final RestTemplate restTemplate;

    public DogApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getRandomDogImages(int count) {
        String url = "https://dog.ceo/api/breeds/image/random/" + count;

        try {
            ResponseEntity<DogApiResponse> response = restTemplate.getForEntity(url, DogApiResponse.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().getMessage(); // Возвращаем список картинок
            } else {
                throw new RuntimeException("Некорректный ответ от API");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при запросе Dog API: " + e.getMessage());
            throw new RuntimeException("Ошибка при запросе к Dog API", e);
        }
    }
}
