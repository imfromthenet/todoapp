package at.apidesign.todoapp.communication;


import at.apidesign.todoapp.domain.Todo;
import at.apidesign.todoapp.domain.TodosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TodosEndpoint {

    private final TodosService todoService;

    public TodosEndpoint(TodosService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String page(Model model) {
        model.addAttribute("todos", todoService.getAll());
        return "home";
    }

    @GetMapping("/add")
    public String addTodo(Model model) {
//        dedicate creation of empty tood to a method?
        model.addAttribute("todo", new Todo(null, null, null));
        return "addTodo";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Todo todo) {
//        add validation ?
        todoService.add(todo);
        return "redirect:/";
    }

}
