package com.triple.triplep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class ReviewEventController {

    @Autowired
    private ReviewEventService reviewEventService;

    @PostMapping("")
    public void postReviewEvent(@RequestBody ReviewEventDto reviewEventDto){
        reviewEventService.
    }
}
