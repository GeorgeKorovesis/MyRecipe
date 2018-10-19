package com.recipeme.myrecipe.restapi;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.recipeme.myrecipe.db.RecipeDao;
import com.recipeme.myrecipe.db.RecipeDatabase;
import com.recipeme.myrecipe.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static APIService apiService;
    private static RecipeDao mRecipeDao;
    private static MutableLiveData<List<Recipe>> mRecipes;
    private static Repository INSTANCE = null;
    private static Application application;

    public LiveData<List<Recipe>> getAllRecipes() {
        if(mRecipes==null){
            refreshRecipes();
        }
        mRecipes.setValue(mRecipeDao.getAllRecipes());
        return mRecipes;

    }


    public void insert (Recipe recipe) {
        new insertAsyncTask(mRecipeDao).execute(recipe);
    }

    private void refreshRecipes ()
    {
        getRecipes("5a7fee0eeca5570a2714d91aa1a5c6cc","r");
    }


    public static Repository getInstance(Application app) {
        application = app;
        if (INSTANCE == null) {
            INSTANCE = new Repository();
            mRecipes = new MutableLiveData<>();
            apiService = APIClient.getClient().create(APIService.class);
            RecipeDatabase db = RecipeDatabase.getDatabase(application);
            mRecipeDao = db.recipeDao();
        }
        return INSTANCE;
    }


    public void getRecipes(String key, String sort) {
        Call<APIResponse> call = apiService.getRecipes(key, sort);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.isSuccessful()) {
                    List<Recipe> list = response.body().getRecipes();
                    for(Recipe recipe:list) {
                        insert(recipe);
                    }
                    mRecipes.setValue(mRecipeDao.getAllRecipes());
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
            }
        });

    }

    private static class insertAsyncTask extends AsyncTask<Recipe, Void, Void> {

        private RecipeDao mAsyncTaskDao;

        insertAsyncTask(RecipeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Recipe... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}