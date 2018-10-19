package com.recipeme.myrecipe.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.recipeme.myrecipe.model.Recipe;

@Database(entities = {Recipe.class}, version = 2)
public abstract class RecipeDatabase extends RoomDatabase {

    private static volatile RecipeDatabase INSTANCE;

    public abstract RecipeDao recipeDao();

    public static RecipeDatabase getDatabase(final Context context) {
        synchronized (RecipeDatabase.class) { //ensure that there is only one thread in the block
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), RecipeDatabase.class, "recipeDB")
                                .fallbackToDestructiveMigration()
                                .allowMainThreadQueries()
                                .build();
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}