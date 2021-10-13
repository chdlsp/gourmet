package com.board.gourmet.external.place.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class Place implements Serializable {
    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents;
    @JsonProperty("adr_address")
    private String adrAddress;
    @JsonProperty("business_status")
    private String businessStatus;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("formatted_phone_number")
    private String formattedPhoneNumber;
    private Geometry geometry;
    private String name;
    @JsonProperty("permanently_closed")
    private String permanentlyClosed;
    private String photos;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("price_level")
    private Integer priceLevel;
    private Float rating;
    private String reference;
    private List<PlaceReview> reviews;
    private List<String> types;
    private String url;
    private String website;
}
