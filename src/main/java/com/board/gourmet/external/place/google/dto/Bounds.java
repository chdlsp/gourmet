package com.board.gourmet.external.place.google.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Bounds {
    private LatLngLiteral northeast;
    private LatLngLiteral southwest;
}
