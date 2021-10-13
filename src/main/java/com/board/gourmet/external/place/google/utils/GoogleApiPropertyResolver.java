package com.board.gourmet.external.place.google.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleApiPropertyResolver {
    @Value("${gourmet.api-key.google.place}") private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
