package com.udemy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showMyPage() {
        return "helloworld-form";
    }

    // Not used anymore
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest requst, Model model) {
        String name = requst.getParameter("studentName");
        model.addAttribute("message", "YO! " + name.toUpperCase());
        return "helloworld";
    }

}
