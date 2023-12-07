package com.example.basic.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class TodoListDto {
    
    @NotBlank
    @Size(min = 1, max = 4)
    private String id;

    @NotNull
    @Size(min = 1, max = 10)
    private String title;

    private Boolean status;
}
