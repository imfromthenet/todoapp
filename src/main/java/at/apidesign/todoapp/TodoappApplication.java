package at.apidesign.todoapp;

import at.apidesign.todoapp.communication.TodosEndpoint;
import at.apidesign.todoapp.domain.TodosService;
import at.apidesign.todoapp.peristence.TodoStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
        new TodosEndpoint(new TodosService(new TodoStorage()));
    }

}