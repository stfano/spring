package com.example.basic.model;

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
public class BasicDto {
    
    private String name;
    private String email;
    
    

    
// 첫번 째 방법
        // public BasicDto() {}; // 기본 생성함수 ! (
        // // 일반 생성함수 ! 
        // public BasicDto(String name, String email)
        // {
        //     this.name = name;
        //     this.email = email;
        // }
        // public String getName()
        // {
        //     return this.name;
        // }
        // public void setName(String name)
        // {
        //     this.name = name;
        // }
        // public String getEmail()
        // {
        //     return this.email;
        // }
        // public void setEmail(String email)
        // {
        //     this.email = email;
        // }

// 두번째 방법
    // 오른쪽 클린 source action >> 
    // public BasicDto(String name, String email) {
    //     this.name = name;
    //     this.email = email;
    // }
    // public String getName() {
    //     return name;
    // }
    // public String getEmail() {
    //     return email;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // public BasicDto() {
    // }
    // @Override
    // public String toString() {
    //     return "BasicDto [name=" + name + ", email=" + email + "]";
    // }
}
