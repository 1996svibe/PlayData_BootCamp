package com.example.demo.todo.repository;

import com.example.demo.todo.domain.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Page<Todo> findAllByContentAndIsDone(String content,boolean isDone, Pageable pageable);

    Page<Todo> findAllByContent(String content, Pageable pageable);

    Page<Todo> findAllByTitleAndIsDone(String title, boolean isDone, Pageable pageable);

    Page<Todo> findAllByTitleContaining(String title, Pageable pageable);

}


