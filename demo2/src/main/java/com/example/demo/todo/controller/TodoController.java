package com.example.demo.todo.controller;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.service.MemberService;
import com.example.demo.todo.domain.entity.Todo;
import com.example.demo.todo.domain.request.TodoRequest;
import com.example.demo.todo.domain.response.TodoResponse;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;
    private final MemberService memberService;

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteTodoById(@PathVariable("id") Long id) {
//        Todo todo = service.findTodoById(id);
//        if (todo == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TODOS_NOT_FOUND");
//        }
//
//        service.deleteTodoById(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted successfully.");
//    }

    @GetMapping
    public Page<TodoResponse> getAll(
            @RequestParam(name = "content",
                    required = false,
                    defaultValue = "") String content,
            @RequestParam(name = "size " ,
                    required = false,
                    defaultValue = "20") Integer size,
            @RequestParam(name = "page" ,
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(name = "isDone" ,
                    required = false)
                    Boolean isDone
            ){
        PageRequest request = PageRequest.of(page, size);
        Page<Todo> todos;
        if(isDone != null){
            todos = todoService.findAllByContentAndIsDone(content, isDone, request);
        }else {
            todos = todoService.findAllByContent(content, request);
        }
        return todos.map(TodoResponse::new);
    }
    @GetMapping("/title")
    public Page<TodoResponse> getTitle(
            @RequestParam(name = "title",
            required = false,
            defaultValue = "") String title,
            @RequestParam(name = "size " ,
                    required = false,
                    defaultValue = "20") Integer size,
            @RequestParam(name = "page" ,
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(name = "isDone" ,
                    required = false)
            Boolean isDone
    ){
        PageRequest request = PageRequest.of(page, size);
        Page<Todo> todos;
        if(isDone != null){
            todos = todoService.findAllByTitleAndIsDone(title, isDone, request);
        }else {
            todos = todoService.findAllByTitleContaining(title, request);
        }
        return todos.map(TodoResponse::new);
    }

    @PostMapping
    public ResponseEntity<Long> createTodo(
            @RequestBody TodoRequest request
    ){
        Long memberId= request.memberId();
        if(!memberService.isMemberLoggedIn(Member)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

