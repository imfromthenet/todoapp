package at.apidesign.todoapp.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosService {

    private final Persistence persistence;

    public TodosService(Persistence persistence) {
        this.persistence = persistence;
    }

    public List<Todo> getAll() {
        return persistence.getAll();
    }

    public Todo add(Todo todo) {
        return persistence.add(todo.format());
    }
}
