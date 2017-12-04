package com.getset.bsia.mvc.controllers;

import com.getset.bsia.mvc.dao.SpitterRepository;
import com.getset.bsia.mvc.entity.Spitter;
import com.getset.bsia.mvc.utils.SpitterNotFoundExcepiton;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
    public String registerSpitter(@RequestPart("profilePic") MultipartFile picture, @Valid Spitter spitter, Errors errors, Model model, RedirectAttributes redirectAttributes) throws IOException {
        System.out.println("registerSpitter: " + spitter);
        if (errors.hasErrors()) {
            System.out.println(errors);
            return "registerSpitter";
        }
        picture.transferTo(new File("/tmp/spitter/pics/" + picture.getOriginalFilename()));

        spitterRepository.save(spitter);

        redirectAttributes.addFlashAttribute("spitter", spitter);
//        model.addAttribute("username", spitter.getUsername());
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getOneSpitter(@PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute("spitter", spitterRepository.findOne(username));
        }
        return "profile";
    }

//    @ExceptionHandler(SpitterNotFoundExcepiton.class)
//    public String handleSpitterNotFoundException() {
//        return "spitter/error";
//    }
}
