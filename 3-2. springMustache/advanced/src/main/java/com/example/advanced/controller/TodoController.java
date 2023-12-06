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


@Controller
@RequestMapping("/todo/ver1/")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    // 전체 데이터 조회
    @GetMapping("/all")
    public String selectAll(Model model) // 리턴값은 파읾명이므로 Stirng
    {
        model.addAttribute("todoList", todoService.selectAll());
        
        return "todo";
    }

    // 데이터 삽입
    @PostMapping("/insert")
    public String insertTodo(@ModelAttribute TodoDto dto) 
    {
        todoService.insertTodo(dto.getTodoName());

        return "redirect:/todo/ver1/all";
    }

    // 데이터 수정
    @GetMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id)
    {
        todoService.updateTodo(id);
        return "redirect:/todo/ver1/all";
    }

    // 데이터 삭제
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id)
    {
        todoService.deleteTodo(id);
        return "redirect:/todo/ver1/all";
    }
}
