package com.naver.user.controller;

import com.naver.user.domain.dto.Update;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.UpdateRequest;
import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService){

        this.todoService = todoService;
    }

    @GetMapping("/main")
    public ModelAndView showMain(
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todos/main");
//        if (keyword != null && !keyword.equals("")){
//            List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
//            modelAndView.addObject("todolist", byKeyword);
//        }else {
//            modelAndView.addObject("todolist", todoService.findAll());
//        }
        List<TodoJoinUser> byKeyword = todoService.findByKeyword(keyword);
        modelAndView.addObject("todolist", byKeyword);
        // todolist 가져다 주기
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
    @GetMapping("/todo/update")
    public ModelAndView showUpdatePage(
            @RequestParam("todoid") String id,
            ModelAndView mav
        ){
        mav.addObject("todoid", id);
        mav.setViewName("/todos/todoupdate");

        return mav;
    }

    @PostMapping("/todo/update")
    public ModelAndView updateData(
            @ModelAttribute UpdateRequest request,
            ModelAndView mav,
            HttpSession session
    ) {
        int uid = (int) session.getAttribute("id");
        Update dto = request.toDto(uid);
//        Update update = new Update(request.getId(), uid, request.getContent());

        todoService.update(dto);
        mav.setViewName("redirect:/main");
        return mav;
    }
}
