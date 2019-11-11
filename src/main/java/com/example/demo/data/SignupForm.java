package com.example.demo.data;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//データの受け取り条件
@Data
public class SignupForm {
    @NotBlank
    @Email
    private String userId;

    @NotBlank
    @Length(min = 4,max = 16)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String password;

    @NotBlank
    private String username;

    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

    @Min(value=20)
    @Max(value=100)
    private int age;

    @AssertTrue
    private boolean sex;

}