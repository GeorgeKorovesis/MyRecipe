package com.recipeme.myrecipe.restapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.recipeme.myrecipe.model.Recipe;

import java.util.List;

public class APIResponse {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}

