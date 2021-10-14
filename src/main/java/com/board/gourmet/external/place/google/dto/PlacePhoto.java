package com.board.gourmet.external.place.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PlacePhoto {
    private Integer height;
    @JsonProperty("html_attributions")
    private List<String> htmlAttributions;
    @JsonProperty("photo_reference")
    private String photoReference;
    private Integer width;
}
