package it.todoapp.peristence;

import at.apidesign.todoapp.domain.Todo;
import at.apidesign.todoapp.domain.Persistence;
import at.apidesign.todoapp.peristence.TodoStorage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TodoStorageTest {

    @Test
    void createsExampleTodos() {
        Persistence sut = new TodoStorage();
        List<Todo> all = sut.getAll();

        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void deletesAllTodos() {
        Persistence sut = new TodoStorage();
        List<Todo> all = sut.getAll();
        assertThat(all.size()).isEqualTo(2);

        sut.deleteAll();
        assertThat(sut.getAll()).isEmpty();
    }

    @Test
    void adds() {
        Persistence sut = new TodoStorage();
        sut.add(new Todo(null, "add todo", true));
        List<Todo> all = sut.getAll();

        assertThat(all.size()).isEqualTo(3);
    }
}