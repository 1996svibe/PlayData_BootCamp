package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.domain.dto.TodoJoinUser;
import com.naver.user.domain.request.InsertRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<TodoJoinUser> findAll() {
        return todoDao.findAll();
    }

    public int insert(Integer uid, String content){
        // Dao에서 가져옴
       return todoDao.insert(uid, content);
    }
}
