package com.example.url_shortener.controller;

import com.example.url_shortener.model.UrlMapping;
import com.example.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    // Endpoint 1: Shorten a long URL
    @PostMapping("/shorten")
    public ResponseEntity<UrlMapping> shorten(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        if (originalUrl == null || originalUrl.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(urlService.shortenUrl(originalUrl));
    }

    // Endpoint 2: Redirect short code to original URL and increment counter
    @GetMapping("/r/{code}")
    public RedirectView redirectToOriginal(@PathVariable String code) {
        UrlMapping mapping = urlService.getAndIncrementClick(code);
        return new RedirectView(mapping.getOriginalUrl());
    }

    // Endpoint 3: Fetch analytics for all URLs
    @GetMapping("/analytics")
    public ResponseEntity<List<UrlMapping>> getAnalytics() {
        return ResponseEntity.ok(urlService.getAllUrls());
    }
}