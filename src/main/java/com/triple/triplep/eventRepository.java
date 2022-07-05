package com.triple.triplep;

import org.springframework.data.jpa.repository.JpaRepository;

public interface eventRepository extends JpaRepository<EventEntity, Long> {
}
