package com.board.gourmet.external.place.google;

import com.board.gourmet.external.place.google.dto.response.PlacesFindPlaceFromTextResponse;
import com.board.gourmet.external.place.google.utils.GoogleApiPropertyResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class GooglePlacesClient {

    private GoogleApiPropertyResolver googleApiPropertyResolver;

    public GooglePlacesClient(GoogleApiPropertyResolver googleApiPropertyResolver) {
        this.googleApiPropertyResolver = googleApiPropertyResolver;
    }

    ResponseEntity<PlacesFindPlaceFromTextResponse> findPlaceFromTextResponse(String inputText) {

        String apiKey = googleApiPropertyResolver.getApiKey();
        String resourceUrl = googleApiPropertyResolver.getPlacesApiBase()
                + googleApiPropertyResolver.getTypePlaceFromText()
                + googleApiPropertyResolver.getOutJson();

        String fields = "formatted_address,name,rating,place_id,opening_hours,photo,price_level,reference,geometry";

        UriComponents uri =
                UriComponentsBuilder
                        .fromUri(URI.create(resourceUrl))
                        .queryParam("input", inputText)
                        .queryParam("inputtype", "textquery")
                        .queryParam("fields", fields)
                        .queryParam("key", apiKey)
                        .build();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForEntity(uri.toUri(), PlacesFindPlaceFromTextResponse.class);
    }
}
