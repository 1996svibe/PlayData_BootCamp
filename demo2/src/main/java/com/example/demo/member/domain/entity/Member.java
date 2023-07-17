package com.example.demo.member.domain.entity;

import com.example.demo.todo.domain.entity.Todo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private Integer age;

    public Member( String email, String password, String name, Integer age ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    @OneToMany(mappedBy = "member")
    private List<Todo> todos;

    private boolean loggedIn;


}
