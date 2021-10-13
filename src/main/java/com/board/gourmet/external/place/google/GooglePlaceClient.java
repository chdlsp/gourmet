package com.board.gourmet.external.place.google;

import com.board.gourmet.external.place.google.dto.response.PlacesFindPlaceFromTextResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class GooglePlaceClient {

    @Value("${gourmet.api-key.google.place}")
    private String apiKey;
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_PLACEFROMTEXT = "/findplacefromtext";
    private static final String OUT_JSON = "/json";

    PlacesFindPlaceFromTextResponse findPlaceFromTextResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/spring-rest/foos";
        return restTemplate.getForEntity(fooResourceUrl + "/1", PlacesFindPlaceFromTextResponse.class).getBody();
    }

}
