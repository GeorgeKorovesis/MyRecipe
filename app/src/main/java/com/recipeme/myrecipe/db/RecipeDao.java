package com.recipeme.myrecipe.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.recipeme.myrecipe.model.Recipe;
import com.recipeme.myrecipe.restapi.APIResponse;

import java.util.List;


@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipes")
    List<Recipe> getAllRecipes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Recipe... recipe);

    @Delete
    void delete(Recipe recipe);

    @Query("DELETE FROM recipes")
    void deleteAll();
}

