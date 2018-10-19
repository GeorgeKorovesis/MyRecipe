package com.recipeme.myrecipe;

import android.app.IntentService;
import android.arch.lifecycle.LiveData;
import android.content.Intent;

import com.recipeme.myrecipe.restapi.APIResponse;
import com.recipeme.myrecipe.restapi.Repository;

public class FetchRecipesIntentService extends IntentService {

    final static String SERVICE_INFO = "Fetch Recipes IntentService";
    public FetchRecipesIntentService() {
        super(SERVICE_INFO);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //TODO hit remote API for standard recipes
        Repository.getInstance(getApplication()).getRecipes("5a7fee0eeca5570a2714d91aa1a5c6cc","r");
        System.out.println("dasdsadada");
        //store data.....//

//        fetchRemoteAPIRecipes();
        //TODO hit firebase for custom recipes
//        fetchCustomRemoteRecipes();
    }
}
