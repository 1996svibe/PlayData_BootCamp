package com.example.demo.todos.domain.response;

import com.example.demo.config.domain.dto.MemberDto;
import com.example.demo.config.domain.dto.TodoDto;
import com.example.demo.todos.domain.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponse extends TodoDto {
    private MemberDto memberDto;
    public TodoResponse(Todo todo){
        super(todo);
        memberDto = new MemberDto(todo.getMember());
    }
}
