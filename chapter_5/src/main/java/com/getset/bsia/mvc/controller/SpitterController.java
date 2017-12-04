package com.getset.bsia.mvc.controller;

import com.getset.bsia.mvc.dao.SpitterRepository;
import com.getset.bsia.mvc.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "registerSpitter";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSpitter(@Valid Spitter spitter, Errors errors) {
        System.out.println("registerSpitter: " + spitter);
        if (errors.hasErrors()) {
            System.out.println(errors);
            return "registerSpitter";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getOneSpitter(@PathVariable String username, Model model) {
        model.addAttribute("spitter", spitterRepository.findOne(username));
        return "profile";
    }
}
