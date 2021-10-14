package com.board.gourmet.place;

import com.board.gourmet.external.place.google.GetPlaceInformationService;
import com.board.gourmet.place.dto.FindPlaceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/place")
@RestController
public class GourmetPlaceController {

    private final GetPlaceInformationService getPlaceInformationService;

    public GourmetPlaceController(GetPlaceInformationService getPlaceInformationService) {
        this.getPlaceInformationService = getPlaceInformationService;
    }

    @GetMapping
    public List<FindPlaceResponse> GetPlaceInformationService(@RequestParam String inputText) {
        return getPlaceInformationService.findPlaceFromTextResponse(inputText);
    }

}
