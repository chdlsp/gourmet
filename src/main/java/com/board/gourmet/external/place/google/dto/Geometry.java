package com.board.gourmet.external.place.google.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Geometry {
    private LatLngLiteral location;
    private Bounds viewport;
}
