package com.recipeme.myrecipe.util;

import android.arch.persistence.room.TypeConverter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RecipeIngredientsConverters {

        @TypeConverter
        public ArrayList<String> fromString(String value) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public String fromArrayList(ArrayList<String> list) {
            Gson gson = new Gson();
            return gson.toJson(list);
        }
    }