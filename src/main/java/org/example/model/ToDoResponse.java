package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    // 후에 편리한 코드 작성을 위해, Entity 클래스를 파라미터로 받는 Response 객체 생성자 추가
    public ToDoResponse(ToDoEntity toDoEntity) {
        this.id = toDoEntity.getId();
        this.title = toDoEntity.getTitle();
        this.order = toDoEntity.getOrder();
        this.completed = toDoEntity.getCompleted();

        // 나중에 리팩토링이 필요한 부분
        this.url = "http://localhost:8080/" + this.id;
    }
}
