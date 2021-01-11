package it.todoapp.communication;

import at.apidesign.todoapp.TodoappApplication;
import at.apidesign.todoapp.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {TestContext.class, TodoappApplication.class})
class TodosEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void loadsHomepage() {
//        it works but it's brittle and it doesn't test status codes. could be solved with mockMvc
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("<h2>List of all ToDos</h2>");
    }

    @Test
    void loadsPageForAddingToDo() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/add", String.class))
                .contains("<h2>Add new ToDo</h2>");
    }

    @Test
    void addsToDoAndRedirectsToHomepage() {
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/add", new Todo(null, "Eat", true), String.class))
                .contains("<h2>Add new ToDo</h2>");
    }
}