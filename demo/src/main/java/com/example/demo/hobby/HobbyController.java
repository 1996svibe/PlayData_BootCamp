package com.example.demo.hobby;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hobbies")
public class HobbyController {

    public HobbyController(HobbyService hobbyService){

    }
}
