package com.naver.user.controller;

import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService){

        this.todoService = todoService;
    }

    @GetMapping("/main")
    public ModelAndView showMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");
        // todolist 가져다 주기
        modelAndView.addObject("todolist", todoService.findAll());

        return modelAndView;
    }
    @PostMapping("/main")
    public ModelAndView inputData(
        @RequestParam("content") String content,
        ModelAndView mav,
        HttpSession session
    ){
        Integer id = (Integer) session.getAttribute("id");
        // TODO: Insert -> 서비스에 만들거임

        if (id != null && todoService.insert(id,content)!=0 )
        mav.setViewName("redirect:/main");

        else {
//            mav.setViewName("redirect:/main?err=not insert");
            mav.setViewName("redirect:/main");
            mav.addObject("err", "not_insert");
        }
        return mav;
    }
}
