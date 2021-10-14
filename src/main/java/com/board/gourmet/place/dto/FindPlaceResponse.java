package com.board.gourmet.place.dto;

import com.board.gourmet.external.place.google.dto.Place;
import com.board.gourmet.external.place.google.dto.response.PlacesFindPlaceFromTextResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindPlaceResponse {
    private String addressName;
    private Float lat;
    private Float lng;

    public static FindPlaceResponse toFindPlaceResponse(Place place) {
        return FindPlaceResponse.builder()
                .addressName(place.getFormattedAddress())
                .lat(place.getGeometry().getLocation().getLat())
                .lng(place.getGeometry().getLocation().getLng())
                .build();
    }
}
