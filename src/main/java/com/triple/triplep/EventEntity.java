package com.triple.triplep;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long eventId;
    private UUID reviewId;
    private UUID userID;
    private UUID placeID;
    @Column
    @ElementCollection
    private List<String> attachedPhotoIds;
    @Column(length = 50)
    private String type;
    @Column(length = 50)
    private String action;
    @Column(length = 1000)
    private String content;
    @CreationTimestamp
    private Timestamp registration;
    @Column(columnDefinition = "int default '0'")
    private int point;

    public EventEntity(UUID reviewId, UUID userID, UUID placeID, List<String> attachedPhotoIds, String type, String action, String content){
        this.reviewId = reviewId;
        this.userID = userID;
        this.placeID = placeID;
        this.attachedPhotoIds = attachedPhotoIds;
        this.type = type;
        this.action = action;
        this.content = content;
    }
}
