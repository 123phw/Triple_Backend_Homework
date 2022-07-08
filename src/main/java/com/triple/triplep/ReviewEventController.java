package com.triple.triplep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/events")
public class ReviewEventController {

    @Autowired
    private ReviewEventService reviewEventService;

    @GetMapping("/{userId}")
    public String getUserPoint(@PathVariable("userId")UUID userId){
        return reviewEventService.getUserPoint(userId);
    }


    @PostMapping("")
    public void postReviewEvent(@RequestBody ReviewEventDto reviewEventDto){
        reviewEventService.postReviewEvent(reviewEventDto);
    }
}
