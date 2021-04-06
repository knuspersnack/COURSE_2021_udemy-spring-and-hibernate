package com.udemy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Not used anymore
    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest requst, Model model) {
        String name = requst.getParameter("studentName");
        model.addAttribute("message", "YO! " + name.toUpperCase());
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message", "Hey My Friend " + name.toUpperCase());
        return "helloworld";
    }

}
