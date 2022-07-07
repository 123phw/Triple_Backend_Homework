package com.triple.triplep;

import com.triple.triplep.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(value = SpringRunner.class)
@SpringBootTest
class TriplePApplicationTests {

    @Autowired
    EventRepository eventRepository;

    @Test
    public void save() throws Exception{
       /* List<String> photoIds = Arrays.asList("e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2- 851d-4a50-bb07-9cc15cbdc332");
        String reviewString = "240a0658-dc5f-4878-9381-ebb7b2667772";
        UUID reviewUUID = UUID.fromString(reviewString);
        String userString = "3ede0ef2-92b7-4817-a5f3-0c575361f745";
        UUID userUUID = UUID.fromString(userString);
        String placeString = "2e4baf1c-5acb-4efb-a1af-eddada31b00f";
        UUID placeUUID = UUID.fromString(placeString);

        EventEntity eventEntity = new EventEntity(
                reviewUUID, userUUID, placeUUID, photoIds,
                "REVIEW", "ADD", "좋아요!");
        eventRepository.save(eventEntity);*/
        eventRepository.deleteAll();
    }

    /*@Test
    public void testFind(){
        String userString = "3ede0ef2-92b7-4817-a5f3-0c575361f745";
        UUID userUUID = UUID.fromString(userString);
        String placeString = "2e4baf1c-5acb-4efb-a1af-eddada31b00f";
        UUID placeUUID = UUID.fromString(placeString);
        eventRepository.findByPlaceAndUser(placeUUID, userUUID);
    }*/




}
