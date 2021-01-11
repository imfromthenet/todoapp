package at.apidesign.todoapp.domain;

import java.util.List;

public interface Persistence {
    List<Todo> getAll();

    void deleteAll();

    Todo add(Todo todo);
}
