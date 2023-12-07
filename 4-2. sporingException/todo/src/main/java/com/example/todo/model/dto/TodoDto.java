package com.example.todo.model.dto;


import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    
    private Long id;
    @NotBlank
    @Size(min = 2, max = 10)
    private String name;
    private Boolean status;
    @Min(value = 0)
    @Max(value = 100)
    private int progressPersentage; // 진행률이 100% 이면 , status 값이 true
    @Future
    private Date dueDate; // 마감일이 지나면, status & progrssPersentage 수정불가
}
