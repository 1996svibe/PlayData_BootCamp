package com.playdata.todos.dto;

public class TodoJoinUser {
    private Integer id;
    private String content;
    private String createAt;
    private boolean checked;
    private String name;
    private Integer uid;
    //전체 생성자, getter


    @Override
    public String toString() {
        return super.toString();
    }

    public TodoJoinUser(String name, Integer uid, Integer id, String content, String createAt, Boolean checked){
        this.name = name;
        this.uid = uid;
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.checked = checked;
        }

    public String getName() {
        return name;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public boolean isChecked() {
        return checked;
    }
}
