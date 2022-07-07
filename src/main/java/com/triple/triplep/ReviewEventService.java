package com.triple.triplep;

import com.triple.triplep.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewEventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void postReviewEvent(ReviewEventDto reviewEventDto){
        EventEntity event = eventRepository.findByPlaceAndUser(reviewEventDto.getPlaceID(), reviewEventDto.getUserID());
        int point=0;
        if(event != null){//DB에 동일 공원에 같은 사용자 리뷰가있다면 업데이트
            event.updateEvent(reviewEventDto);
        }
        else { //존재하지않는 리뷰라면 새로 등록
            event = new EventEntity(
                    reviewEventDto.getReviewId(),
                    reviewEventDto.getUserID(),
                    reviewEventDto.getPlaceID(),
                    reviewEventDto.getAttachedPhotoIds(),
                    reviewEventDto.getType(),
                    reviewEventDto.getAction(),
                    reviewEventDto.getContent());

            eventRepository.save(event);
        }
        if (checkContent(reviewEventDto.getContent())){ //리뷰내용이 1자이상이상이면
            point++;
        }
        if(checkPhoto(reviewEventDto.getAttachedPhotoIds())){
            point++;
        }
        EventEntity firstReview = eventRepository.findFirstReview(reviewEventDto.getPlaceID());
        if(checkFirstReview(reviewEventDto.getUserID(), firstReview.getUserId())){
            point++;
        }
        event.updatePoint(point); //포인트 업데이트
    }


    //리뷰길이가 1이상이면 true반환, 아니면 false반환
    private boolean checkContent(String content){
        int contentLength = content.length();
        if (contentLength>=1){
            return true;
        }
        else return false;
    }

    private boolean checkPhoto(List<String> attachedPhotoIds){
        int photoCount = attachedPhotoIds.size();
        if(photoCount>=1){
            return true;
        }
        else return false;
    }

    private boolean checkFirstReview(UUID userId, UUID firstUserId) {
        if (userId == firstUserId) {
            return true;
        } else return false;
    }
}
