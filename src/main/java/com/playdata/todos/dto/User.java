package com.playdata.todos.dto;
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String createAt;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public User(String password) {
        this.password = password;
    }

    public User(Integer id) {
        this.id = id;
    }

}
