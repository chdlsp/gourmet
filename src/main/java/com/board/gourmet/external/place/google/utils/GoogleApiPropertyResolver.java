package com.board.gourmet.external.place.google.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
* Don't use @Getter in Lombok for Resolver.
* Test file can't read the Lombok annotation.
* */
@Component
public class GoogleApiPropertyResolver {
    @Value("${gourmet.api-key.google.place}") private String apiKey;

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_PLACEFROMTEXT = "/findplacefromtext";
    private static final String OUT_JSON = "/json";

    public String getApiKey() { return apiKey; }
    public String getPlacesApiBase() { return PLACES_API_BASE; }
    public String getTypePlaceFromText() { return TYPE_PLACEFROMTEXT; }
    public String getOutJson() { return OUT_JSON; }
}
