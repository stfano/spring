package com.example.advanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/todo")
@Slf4j
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String selectAll(Model model) // View에 데이터를 보내기 위해 model를 생성
    {
        log.info("[TodoController][selectAll] 안니영~ ");
        // Service에서 조회한 데이터들을 model에 추가한다. 
        model.addAttribute("todoList", todoService.selectAll());
        
        // View의 이름으로 반환 
        return "todo";
    }

    @PostMapping("/save")
    public String insertDto(@ModelAttribute TodoDto dto) // TodoDto 객체에 넘겨받은 데이터를 
    {                                                    // 담아서 사용하기 위함
        log.info("[TodoController][insertDto] 안니영~ ");
        todoService.insertDto(dto);
        return "redirect:/todo/";
    }

    @GetMapping("/finished/{id}")
    public String updateDto(@PathVariable Long id)
    {
        log.info("[TodoController][updateDto] 안니영~ ");
        todoService.updateDto(id);

        return "redirect:/todo/";
    }

    @GetMapping("/delete/{id}")
    public String deleteDto(@PathVariable Long id)
    {
        log.info("[TodoController][deleteDto] 안니영~ ");
        todoService.deleteDto(id);

        return "redirect:/todo/";
    }
}
