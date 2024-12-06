package com.example.zadanie45riat.models;


import lombok.Data;

import java.util.List;

@Data
public class DogApiResponse {
    private String status;
    private List<String> message;
}

