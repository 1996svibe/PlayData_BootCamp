package com.example.demo.todo.domain.request;

public record TodoRequest(String title, String content, boolean isDone, Long memberId) {
}
