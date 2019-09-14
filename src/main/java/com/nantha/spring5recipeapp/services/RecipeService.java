package com.nantha.spring5recipeapp.services;

import com.nantha.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
    public Recipe findById(Long l);
}
