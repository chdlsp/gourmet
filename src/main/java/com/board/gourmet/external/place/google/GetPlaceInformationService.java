package com.board.gourmet.external.place.google;

import com.board.gourmet.external.place.google.dto.response.PlacesFindPlaceFromTextResponse;
import com.board.gourmet.place.dto.FindPlaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GetPlaceInformationService {

    private final GooglePlacesClient googlePlacesClient;

    public GetPlaceInformationService(GooglePlacesClient googlePlacesClient) {
        this.googlePlacesClient = googlePlacesClient;
    }

    public List<FindPlaceResponse> findPlaceFromTextResponse(String inputText) {
        final ResponseEntity<PlacesFindPlaceFromTextResponse> placeFromTextResponse = googlePlacesClient.findPlaceFromTextResponse(inputText);

        List<FindPlaceResponse> findPlaceResponseList = new ArrayList<>();
        if (placeFromTextResponse.getStatusCode().equals(HttpStatus.OK)) {
            Objects.requireNonNull(placeFromTextResponse.getBody())
                    .getCandidates()
                    .forEach(place -> {
                        final FindPlaceResponse findPlaceResponse = FindPlaceResponse.toFindPlaceResponse(place);
                        findPlaceResponseList.add(findPlaceResponse);
                    });
        }

        return findPlaceResponseList;
    }
}
