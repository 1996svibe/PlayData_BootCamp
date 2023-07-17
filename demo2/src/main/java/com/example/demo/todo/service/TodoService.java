package com.example.demo.todo.service;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.service.MemberService;
import com.example.demo.todo.domain.entity.Todo;

import com.example.demo.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;
    private final MemberService service;

    public boolean deleteTodoById(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Todo> findAllByContentAndIsDone(String content, boolean isDone, Pageable pageable){
        return todoRepository.findAllByContentAndIsDone(content, isDone, pageable);
    }
    public Page<Todo> findAllByContent(String content, Pageable pageable){
        return todoRepository.findAllByContent(content, pageable);
    }
    public Page<Todo> findAllByTitleAndIsDone(String title, boolean isDone, Pageable pageable){
        return todoRepository.findAllByTitleAndIsDone(title, isDone, pageable);
    }

    public Page<Todo> findAllByTitleContaining(String title, Pageable pageable){
        return todoRepository.findAllByTitleContaining(title, pageable);
    }

    //투두 아이디 찾기
//    public Todo findTodoById(Long id){
//        return todoRepository.findById(id).orElse(null);
//    }
//    //멤버 아이디 찾기
//    public Member findMemberById(Long id){
//        return service.findMemberById(id);
//    }
//
    public boolean checkTodoByMember(Todo todo, Member member){
       if(service.isMemberLoggedIn(member)){
           todo.setDone(true);
           todoRepository.save(todo);
            return true;
        }
        return false;
    }

//   public void likeTodoByMember(Todo todo, Member member){
//        todo.addLikeCount();
//        todoRepository.save(todo);
//    }
}
