# 트리플여행자 클럽 마일리지 서비스 - Backend_Homework

### 설명
##### 트리플 사용자들이 장소에 리뷰를 작성할 때 포인트를 부여하고, 전체/개인에 대한 포인트 부여 히스토리와 개인별 누적 포인트를 관리하고자 합니다.
##### 한 사용자는 장소마다 리뷰 1개만 작성할 수 있고, 리뷰 수정 또는 삭제할 수 있습니다.
  ##### 내용 점수
     1자 이상 텍스트 작성 : 1점
     1자 이상 사진 첨부 : 1점
  ##### 보너스 점수
     특정 장소에 첫 리뷰 작성 : 1점
##### 포인트 부여 조건을 확인하여 POST /events로 호출하는 포인트 적립 API 구현 및 포인트 조회 API 구현
     
     
### 참고사항
##### 포인트 증감 시 이력이 남아야 합니다.
##### 사용자마다 현재 시점의 포인트 총점을 조회 및 계산이 가능해야 합니다.
##### 포인트 부여 API 구현에 필요한 SQL 수행 시, 전체 테이블 스캔이 일어나지 않는 인덱스가 필요합니다.
##### 리뷰를 작성했다가 삭제하면 해당 리뷰로 부여한 내용 점수와 보너스 점수는 회수합니다.
##### 사용자 입장에서 본 '첫 리뷰'일 때 보너스 점수를 부여합니다.


### DDL
  ##### Table : event
    create table event
    (
      event_id     bigint generated by default as identity
        primary key,
      action       varchar(50),
      content      varchar(1000),
      place_id     uuid,
      point        integer default 0,
      registration timestamp,
      review_id    uuid,
      type         varchar(50),
      user_id      uuid
    );
  
  ##### Table : event_entity_attached_photo_ids
    create table event_entity_attached_photo_ids
    (
      event_entity_event_id bigint not null
        constraint fkp4u4cja2kycctm560nt99pc2f
            references event,
      attached_photo_ids    varchar(255)
    );
  
  ##### Table : create table event_entity_point_difference
    create table event_entity_point_difference
    (
      event_entity_event_id bigint not null
        constraint fkc6jdq806yfp2r7ky3jntvu4ly
            references event,
      point_difference      integer
    );


### 스키마

### API기획서

### 오류

### 보완해야할 점

### 느낀 점


