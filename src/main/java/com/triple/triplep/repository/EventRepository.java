package com.triple.triplep.repository;

import com.triple.triplep.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long>, EventRepositoryCustom {


}
