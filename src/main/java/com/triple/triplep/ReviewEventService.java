package com.triple.triplep;

import com.triple.triplep.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewEventService {

    @Autowired
    private EventRepository eventRepository;
/*
    @Transactional
    public ReviewEventDto postReviewEvent(ReviewEventDto reviewEventDto){

        if (checkContent(reviewEventDto.getContent())){

        }

    }


    //리뷰길이가 1이상이면 true반환, 아니면 false반환
    private boolean checkContent(String content){
        int contentLength = content.length();
        if (contentLength>=1){
            return true;
        }
        else return false;
    }*/
}
