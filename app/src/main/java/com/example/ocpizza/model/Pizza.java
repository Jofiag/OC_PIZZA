package com.example.ocpizza.model;

public class Pizza {
    private String name;
    private Recipe recipe;

    public Pizza() {
    }

    public Pizza(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
