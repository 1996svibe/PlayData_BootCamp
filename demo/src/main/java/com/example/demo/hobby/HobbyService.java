package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HobbyService {
    public List<Hobby> findAll() {
        return Store.hobbies;
    }
}
