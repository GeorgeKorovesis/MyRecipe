package com.recipeme.myrecipe.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.recipeme.myrecipe.model.Recipe;
import com.recipeme.myrecipe.restapi.Repository;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

    private Repository mRepository;

    private LiveData<List<Recipe>> mRecipes;

    public RecipeViewModel(Application application) {
        super(application);

        mRepository = Repository.getInstance(application);
        mRecipes = mRepository.getAllRecipes();
    }


    public LiveData<List<Recipe>> getAllRecipes() {
        return mRecipes;
    }

    public void insert(Recipe recipe) {
        mRepository.insert(recipe);
    }
}
