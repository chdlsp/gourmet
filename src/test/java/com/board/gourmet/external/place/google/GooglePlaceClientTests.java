package com.board.gourmet.external.place.google;

import com.board.gourmet.external.place.google.dto.PlacesSearchStatus;
import com.board.gourmet.external.place.google.dto.response.PlacesFindPlaceFromTextResponse;
import com.board.gourmet.external.place.google.utils.GoogleApiPropertyResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Google Client Tests")
class GooglePlaceClientTests {

    @Autowired private GoogleApiPropertyResolver googleApiPropertyResolver;

    @Test
    void findPlaceFromTextResponse() {
        String apiKey = googleApiPropertyResolver.getApiKey();
        String resourceUrl = googleApiPropertyResolver.getPlacesApiBase()
                + googleApiPropertyResolver.getTypePlaceFromText()
                + googleApiPropertyResolver.getOutJson();

        String fields = "formatted_address,name,rating,place_id,opening_hours,photo,price_level,reference,geometry";

        UriComponents uri =
                UriComponentsBuilder
                        .fromUri(URI.create(resourceUrl))
                        .queryParam("input", "곰비임비")
                        .queryParam("inputtype", "textquery")
                        .queryParam("fields", fields)
                        .queryParam("key", apiKey)
                        .build();

        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<PlacesFindPlaceFromTextResponse> response =
                restTemplate
                        .getForEntity(uri.toUri(), PlacesFindPlaceFromTextResponse.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(Objects.requireNonNull(response.getBody()).getStatus(), equalTo(PlacesSearchStatus.OK));

    }

}