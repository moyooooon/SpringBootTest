package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.data.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//ユーザー登録の制御
@Controller
public class SignupController {
    private Map<String,String> radioSex;

    private Map<String,String> initRadioSex(){
        Map<String,String> radio = new LinkedHashMap<>();
        radio.put("女性", "true");
        radio.put("男性", "false");

        return radio;
    }

    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model) {
        radioSex = initRadioSex();
        model.addAttribute("radioSex",radioSex);

        return "login/signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return getSignUp(form,model);
        }
        System.out.println(form);
        return "redirect:/login";
    }
}