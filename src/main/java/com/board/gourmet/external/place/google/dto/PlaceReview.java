package com.board.gourmet.external.place.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaceReview {
    @JsonProperty("author_name")
    private String authorName;
    private Float rating;
    @JsonProperty("relative_time_description")
    private String relativeTimeDescription;
    private Long time;
    private String text;
}
