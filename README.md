# 트리플여행자 클럽 마일리지 서비스 - Backend_Homework

## 설명
##### 트리플 사용자들이 장소에 리뷰를 작성할 때 포인트를 부여하고, 전체/개인에 대한 포인트 부여 히스토리와 개인별 누적 포인트를 관리하고자 합니다.
##### 한 사용자는 장소마다 리뷰 1개만 작성할 수 있고, 리뷰 수정 또는 삭제할 수 있습니다.
  ##### 내용 점수
   #####1자 이상 텍스트 작성 : 1점
   #####1자 이상 사진 첨부 : 1점
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
|**기능**|**Method**|**End Point**|**Request Body**|**Response Body**|**StatusCode & exception**|
|---|---|---|---|---|---|
|리뷰 이벤트 생성 및 포인트 적립|POST|/event|{<br/>"type": "REVIEW",<br/>"action": "ADD",<br/>"reviewId": "240a0658-dc5f-4878-9381-ebb7b2667772",<br/>"content": "좋아요!",<br/>"attachedPhotoIds": [e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332”],<br/>"userId": "3ede0ef2-92b7-4817-a5f3-0c575361f745",    <br/>"placeId":"2e4baf1c-5acb-4efb-a1af-eddada31b00f"  }||OK(200): 저장 성공<br/>Not Found(404): 해당하는 리소스가 없는 경우|
|포인트 정보|GET|/{userId}|||OK(200): 성공<br/>Unauthorized(401) : 헤더에 token이 없을 경우<br/>Not Found(404):  token의 UID에 해당하는 리소스가 없는 경우|


### 오류
<img width="406" alt="image" src="https://user-images.githubusercontent.com/81297436/178132309-2d1d8fd7-7f20-4acd-af51-f2a4c0638315.png">
발생 오류 : Could not autowire. No beans of 'JPAQueryFactory' type found.
해결 : 패키지 내에서 @Configuration을 사용하여 인식을 시켜주려했지만 해당방법으로 해결이 되지 않아 아래와 같이 코드를 변경하였습니다.
      
    private final JPAQueryFactory queryFactory;

    public EventRepositoryImpl(EntityManager entityManager){
        this.queryFactory = new JPAQueryFactory(entityManager);
    }
    
발생 오류 : Database에 데이터 삽입 테스트 코드 작성시, 직접 작성한 UUID값은 String타입으로 인식이되었습니다.
해결 : 아래 코드와 같이 .fromString 메서드를 이용하여 String타입의 데이터를 UUID타입으로 변환하여 저장한 후 데이터 삽입하였습니다.
        
    String placeString = "2e4baf1c-5acb-4efb-a1af-eddada31b00f";
    UUID placeUUID = UUID.fromString(placeString);
  
발생 오류 : The dependencies of some of the beans in the application context form a cycle - 양방향 의존관계 오류
<br/>해결 : ReviewEventService와 EventRepositoryImpl에 동시에 @Autowire을 이용해 EventRepository를 선언했기때문에 발생된 오류라고 생각해 EventRepositoryImpl에 선언된 EventRepository를 제거하였습니다.

### 보완해야할 점

##### 포인트 변경에 따른 회원 등급 변화 기능
##### 사용자 포인트 총 점 조회 시, 등급 상승을 위한 최소 필요 포인트도 명시하면 좋을 것 같음
##### Delete method를 구현하지 못함

### 구조
```bash
tripeP
├── src
│    ├── main
│    │    ├── java/com/triple/triplep
│    │    │    ├── repository         
│    │    │    │    ├── EventRepository
│    │    │    │    ├── EventRepositoryCustom
│    │    │    │    └── EventRepositoryImpl
│    │    │    ├── EventEntity
│    │    │    ├── ReviewEventController
│    │    │    ├── ReviewEventDto
│    │    │    └── ReviewEventService
│    │    └── resources
│    │         └── application.properties
│    └── test/java/com/triple/triplep
│         └── TriplePApplicationTests
└── build.gradle
```
