package com.example.demo.hobby;





import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    private final HobbyService service;
    @PostMapping
    public void save(@RequestBody HobbyRequest request){
        service.save(request);
    }

}
