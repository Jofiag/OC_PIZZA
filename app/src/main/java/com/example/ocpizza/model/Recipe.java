package com.example.ocpizza.model;

public class Recipe {
    private String name;
    private String recipeText;

    public Recipe() {
    }

    public Recipe(String name, String recipeText) {
        this.name = name;
        this.recipeText = recipeText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }
}
