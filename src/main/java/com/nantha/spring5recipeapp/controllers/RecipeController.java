package com.nantha.spring5recipeapp.controllers;

import com.nantha.spring5recipeapp.exceptions.NotFoundException;
import com.nantha.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e) {

        log.error("Handling not found exception");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipe/404");
        modelAndView.addObject("exception", e);
        return  modelAndView;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(Exception e) {

        log.error("Handling not found exception");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipe/404");
        modelAndView.addObject("exception", e);
        return  modelAndView;

    }

}
