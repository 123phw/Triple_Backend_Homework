package com.triple.triplep;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.triple.triplep.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Data
public class ReviewEventDto {

    private UUID reviewId;
    private UUID userId;
    private UUID placeId;
    @JsonProperty("attachedPhotoIds")
    private List<String> attachedPhotoIds;
    private String type;
    private String action;
    private String content;

    public ReviewEventDto(EventEntity event){
        this.reviewId = event.getReviewId();
        this.userId = event.getUserId();
        this.placeId = event.getPlaceId();
        this.attachedPhotoIds = event.getAttachedPhotoIds();
        this.type = event.getType();
        this.action = event.getAction();
        this.content = event.getContent();
    }


}
