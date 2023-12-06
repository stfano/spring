package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.UserDto;

import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 화면을 구현하므로 Controller로 작성
@RequestMapping("/thymeleaf")
public class BasicController {
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                        String name, Model model)
    // key 값이 name인 것을 매핑시키겠다. 만약에 없다면 World 라는 값을 넣어준다. 
    // Model : MVC 에서 Model을 의미함. 즉 . data 
    {
        log.info("[BasicController][greeting] 안니영 ~");
        log.info("name : " + name);

        model.addAttribute("key", name); // key, value 형태로 전달
        return "greeting"; // greeting.html 파일을 만든다. 
                           // 파일 이름이 같은지 봐야함..
    }

    @GetMapping("/utext")
    public String utext(Model model)
    {
        model.addAttribute("tag", "<h2>태그 전달하기</h2>");

        return "utext";
    }

    @GetMapping("/pv/{num}")
    public String pv1(Model model, @PathVariable int num)
    {
        model.addAttribute("num", num);
        return "thymeleaf/pv1";
    }

    @GetMapping("/form")
    public String getForm(Model model, 
                @RequestParam(name = "data1", required = false, defaultValue = "World")
                String data1)
    {
        model.addAttribute("data1", data1);
        return "thymeleaf/form";
    }

    @PostMapping("/form")
    public String postForm(Model model, 
                @RequestParam("data1") String data1)
    {
        model.addAttribute("data1", data1);
        return "thymeleaf/form";
    }

    @GetMapping("/modelAndAView")
    public ModelAndView modelAndView(ModelAndView modelAndView)
    {
        // 데이터 추가 
        modelAndView.addObject("name", "이순신");
        modelAndView.addObject("age", 22);

        // 화면 추가
        modelAndView.setViewName("thymeleaf/modelAndView"); 
        return modelAndView;
    }

    @GetMapping("/multiForm")
    public ModelAndView multifForm(ModelAndView mav)
    {
        mav.addObject("msg", "여러개 input값 전송 후 전송 버튼 클릭!");
        mav.setViewName("thymeleaf/multiForm");
        return mav;
    }

    @PostMapping("/multi")
    public ModelAndView multiSend(ModelAndView mav,
                        @ModelAttribute UserDto dto)
    {
        mav.addObject("msg", "dto를 사용하였습니다. ");
        mav.addObject("userDto", dto);
        mav.setViewName("thymelead/multiSend");
        
        return mav;
    }
}
