package com.triple.triplep.repository;

import com.triple.triplep.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, Long>, EventRepositoryCustom {

    public EventEntity findTopByPlaceIdOrderByRegistrationAsc(UUID placeId);
}
