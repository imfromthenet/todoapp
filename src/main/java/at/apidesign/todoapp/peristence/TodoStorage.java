package at.apidesign.todoapp.peristence;

import at.apidesign.todoapp.domain.Persistence;
import at.apidesign.todoapp.domain.Todo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class TodoStorage implements Persistence {
    private List<Todo> todos;

    public TodoStorage() {
        this.todos = initializeStartingTodos();
    }

    private List<Todo> initializeStartingTodos() {
        return List.of(
                new Todo(UUID.randomUUID().toString(), "Dummy ToDo 1", true),
                new Todo(UUID.randomUUID().toString(), "Dummy ToDo 2", false));
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }

    @Override
    public void deleteAll() {
        todos = Collections.emptyList();
    }

    @Override
    public Todo add(Todo todo) {
        todos = Stream.concat(Stream.of(todo), todos.stream()).collect(toList());
//        do we need to return the whole to do? is it better to return just id?
        return todo;
    }
}
