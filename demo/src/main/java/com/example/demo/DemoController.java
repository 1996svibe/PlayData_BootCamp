package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
/* Todo: rest response body
1. 바디를 리턴 하면 화면이 없다(클라이언트 0서버 구조)
2. 무상태(stateless) 클라이언트 전에 요청을 기억하고 있지 않는다.
-> 누가 물어봐도 계속 물어봐도 대답을 해야한다.
3. 대답을 계속 하니까 힘들어서 캐시를 사용한다.
4. 계층화된 시스템 (시스템의 구성요소를 분리하여 독립적 관리: M -> C)
5. 유니폼 인터페이스(80% 사용안함): 서버가 주축이 되어서 다음 페이지를 정해줘야한다.

 */
public class DemoController {
    @GetMapping("/aaa")
    public String test() {
        return "test";
    }
}