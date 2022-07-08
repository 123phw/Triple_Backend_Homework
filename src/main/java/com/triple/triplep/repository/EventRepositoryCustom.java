package com.triple.triplep.repository;

import com.triple.triplep.EventEntity;

import java.util.List;
import java.util.UUID;

public interface EventRepositoryCustom {

    EventEntity findByPlaceAndUser(UUID placeId, UUID userId);

    public EventEntity findFirstReview(UUID placeId);

    public int totalPointByUserId(UUID userId);


}
