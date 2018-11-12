package com.codeorange.mvcapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicationController implements WebMvcConfigurer {

    private PersonService personService;

    @Autowired
    ApplicationController(PersonService personService){
        this.personService = personService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
    }

    @GetMapping("/form")
    public String doGetForm(Person person) {

        return "form";
    }

    @PostMapping("/form")
    public String doPostForm(@ModelAttribute("person") Person p, BindingResult br, Model m, RedirectAttributes ra) {

        personService.addPerson(p);

        ra.addFlashAttribute("person", p);

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String doGetSuccess(@ModelAttribute("person") Person person, Model model) {
        person.setName("Something Random: " + person.getName());

        return "success";
    }
}
