# ToDo List Application

## 기능
- 목록에 아이템 추가
- 목록 중 특정 아이템 조회
- 전체 목록 조회
- 목록 중 특정 아이템 수정
- 목록 중 특정 아이템 삭제
- 전체 목록 삭제

## API 스펙
| **Method** | **Endpoint** | **기능**                 | **Request**                                          | **Response**                                                                                                                                                                                                                                                                                                                                   |
|------------|--------------|------------------------|------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| POST       | /            | ToDo 아이템 추가            | <pre>{<br/> "title": "조건문 공부하기"<br/>}</pre>          | <pre>{<br/> "id": 17,<br/> "title": "조건문 공부하기",<br/> "order": 0,<br/> "completed": false,<br/> "url": "http<hi>://localhost:8080/17"<br/>} </pre>                                                                                                                                                                                              |
| GET        | /{:id}       | ToDo 아이템 조회            | -                                                    |                                                                                                                                                                                                                                                                                                                                                |     
| GET        | /            | 전체 ToDo 리스트 조회         | -                                                    | <pre>[<br/> {<br/>  "id": 1,<br/>  "title": "조건문 공부하기",<br/>  "order": 0,<br/>  "completed": false,<br/>  "url": "http<hi>://localhost:8080/1"<br/> },<br/><br/> {<br/>  "id": 2,<br/>  "title": "반복문 공부하기",<br/>  "order": 0,<br/>  "completed": false,<br/>  "url": "http<hi>://localhost:8080/2"<br/> },<br/><br/> ...<br/>]                |
| PATCH      | /{:id}       | ToDo 아이템 수정            | <pre>{<br/> "title": "반복문 공부하기"<br/>}</pre>          | <pre>{<br/> "id": 1,<br/> "title": "반복문 공부하기",<br/> "order": 0,<br/> "completed": false,<br/> "url": "http<hi>://localhost:8080/1"<br/>}</pre>                                                                                                                                                                                                 |
| DELETE     | /{:id}       | ToDo 아이템 삭제            |                                                      | 200                                                                                                                                                                                                                                                                                                                                            |
| DELETE     | /            | 전체 ToDo List 삭제        |                                                      | 200                                                                                                                                                                                                                                                                                                                                            |