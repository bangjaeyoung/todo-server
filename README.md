# ToDo List Application

## 기능
- ToDo 정보 추가
- 전체 ToDo 정보 조회
- 특정 ToDo 정보 조회
- 특정 ToDo 정보 수정
- 전체 ToDo 정보 삭제
- 특정 ToDo 정보 삭제

## API 스펙
| **Method** | **Endpoint** | **기능**             | **Request**                                                                                  | **Response**                                                                                                                                                                                                                                        |
|------------|--------------|--------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| POST       | /            | ToDo 정보 추가         | <pre>{<br/> "title": "공부하기",<br/> "todo_order": 1,<br/> "completed": false<br/>}</pre>       | <pre>{<br/> "id": 1,<br/> "title": "공부하기",<br/> "todo_order": 1,<br/> "completed": false<br/>} </pre>                                                                                                                                               |
| GET        | /            | 전체 ToDo 정보 조회      | -                                                                                            | <pre>[<br/> {<br/>  "id": 1,<br/>  "title": "공부하기",<br/>  "todo_order": 1,<br/>  "completed": false<br/> },<br/> {<br/>  "id": 2,<br/>  "title": "운동하기",<br/>  "todo_order": 2,<br/>  "completed": false<br/> },<br/>  <br/>  ...<br/>]             |     
| GET        | /{:id}       | 특정 ToDo 정보 조회      | -                                                                                            | <pre>{<br/> "id": 1,<br/> "title": "공부하기",<br/> "todo_order": 1,<br/> "completed": false<br/>} </pre>                                                                                                                                               |
| PATCH      | /{:id}       | 특정 ToDo 정보 수정      | <pre>{<br/> "title": "공부하기",<br/> "todo_order": 1,<br/> "completed": true<br/>}</pre>        | <pre>{<br/> "id": 1,<br/> "title": "운동하기",<br/> "todo_order": 1,<br/> "completed": false<br/>} </pre>                                                                                                                                               |
| DELETE     | /            | 전체 ToDo 정보 삭제      | -                                                                                            | -                                                                                                                                                                                                                                                   |
| DELETE     | /{:id}       | 특정 ToDo 정보 삭제      | -                                                                                            | -                                                                                                                                                                                                                                                   |
