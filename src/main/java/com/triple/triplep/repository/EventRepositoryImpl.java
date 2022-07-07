package com.triple.triplep.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.triple.triplep.EventEntity;
import com.triple.triplep.ReviewEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.querydsl.jpa.JPQLQuery;

import javax.persistence.EntityManager;

public class EventRepositoryImpl implements EventRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public EventRepositoryImpl(EntityManager entityManager){
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

}
