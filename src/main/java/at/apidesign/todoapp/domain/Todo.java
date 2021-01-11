package at.apidesign.todoapp.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.UUID;
@Value
@AllArgsConstructor
public class Todo {

    @With(AccessLevel.PRIVATE)
    String id;
    String title;
    @With(AccessLevel.PRIVATE)
    Boolean urgent;

    protected Todo format() {
        Todo todoWithId = this.withId(UUID.randomUUID().toString());
        return todoWithId.withUrgent(isUrgent(todoWithId));
    }

    private Boolean isUrgent(Todo todo) {
//        simplify to return todo.getUrgent() != null && todo.getUrgent();
        if (todo.getUrgent() == null) {
            return false;
        }
        return todo.getUrgent();
    }

}
