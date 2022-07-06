package com.triple.triplep;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ReviewEventDto {

    private UUID reviewId;
    private UUID userID;
    private UUID placeID;
    private List<String> attachedPhotoIds;
    private String type;
    private String action;
    private String content;

    public ReviewEventDto(EventEntity event){
        this.reviewId = reviewId;
        this.userID = userID;
        this.placeID = placeID;
        this.attachedPhotoIds = attachedPhotoIds;
        this.type = type;
        this.action = action;
        this.content = content;
    }


}
