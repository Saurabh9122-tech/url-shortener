package com.example.url_shortener.service;

import com.example.url_shortener.model.UrlMapping;
import com.example.url_shortener.repository.UrlRepository;
import com.example.url_shortener.util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public UrlMapping shortenUrl(String originalUrl) {
        String code;
        // Generate a random 6-character short code and ensure uniqueness in database
        do {
            code = Base62Encoder.generateRandomCode(6);
        } while (repository.existsByShortCode(code));

        UrlMapping mapping = UrlMapping.builder()
                .originalUrl(originalUrl)
                .shortCode(code)
                .clickCount(0L)
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(mapping);
    }

    public UrlMapping getAndIncrementClick(String shortCode) {
        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found: " + shortCode));
        mapping.setClickCount(mapping.getClickCount() + 1);
        return repository.save(mapping);
    }

    public List<UrlMapping> getAllUrls() {
        return repository.findAll();
    }
}