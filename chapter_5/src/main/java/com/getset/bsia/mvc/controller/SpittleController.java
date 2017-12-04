package com.getset.bsia.mvc.controller;

import com.getset.bsia.mvc.dao.SpittleRepository;
import com.getset.bsia.mvc.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles1", method = RequestMethod.GET)
    public String getSpittles1(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(value = "/spittles2", method = RequestMethod.GET)
    public String getSpittles2(Map model) {
        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public List<Spittle> getSpittles3() {
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }

    @RequestMapping(value = "/spittles4", method = RequestMethod.GET)
    public String getSpittles4(@RequestParam("max") long max, @RequestParam("count") int count, Model model) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    @RequestMapping(value = "/spittle/{id}", method = RequestMethod.GET)
    public String getSpittles5(@PathVariable("id") long id, Model model) {
        model.addAttribute("spittle", spittleRepository.findSpittle(id));
        return "spittle";
    }
}
