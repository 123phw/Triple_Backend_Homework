package com.triple.triplep.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.triple.triplep.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

import static com.triple.triplep.QEventEntity.eventEntity;

public class EventRepositoryImpl implements EventRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public EventRepositoryImpl(EntityManager entityManager){
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public EventEntity findByPlaceAndUser(UUID placeId, UUID userId){
        return queryFactory.selectFrom(eventEntity)
                .where(eqPlaceId(placeId), eqUserId(userId))
                .fetchOne();
    }
/*
    @Override
    public EventEntity findFirstReview(UUID placeId){

        return queryFactory.selectFrom(eventEntity)
                .where(eqPlaceId(placeId))
                .orderBy(eventEntity.registration.asc())
                .fetchFirst();
    }*/

    @Override
    public int totalPointByUserId(UUID userId){
        return queryFactory
                .select(eventEntity.point.sum())
                .from(eventEntity)
                .where(eqUserId(userId))
                .fetchOne();
    }

    private BooleanExpression eqPlaceId(UUID placeId){
        if(placeId == null){
            return null;
        }
        return eventEntity.placeId.eq(placeId);
    }

    private BooleanExpression eqUserId(UUID userId){
        if(userId == null){
            return null;
        }
        return eventEntity.userId.eq(userId);
    }
}
