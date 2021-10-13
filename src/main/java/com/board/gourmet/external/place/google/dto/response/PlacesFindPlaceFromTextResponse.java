package com.board.gourmet.external.place.google.dto.response;

import com.board.gourmet.external.place.google.dto.Place;
import com.board.gourmet.external.place.google.dto.PlacesSearchStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PlacesFindPlaceFromTextResponse {
    List<Place> candidates;
    PlacesSearchStatus status;
}
