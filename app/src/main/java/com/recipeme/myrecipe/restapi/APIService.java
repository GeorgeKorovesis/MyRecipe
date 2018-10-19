package com.recipeme.myrecipe.restapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
        @GET("api/search")
        Call<APIResponse> getRecipes(@Query("key") String key,
                                     @Query("s") String sort);
    }

