package com.recipeme.myrecipe.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "recipes")
public class Recipe {

    @SerializedName("publisher")
    @Expose
    @ColumnInfo(name = "publisher")
    private String publisher;

    @SerializedName("f2f_url")
    @Expose
    @ColumnInfo(name = "f2fUrl")
    private String f2fUrl;

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("source_url")
    @Expose
    @ColumnInfo(name = "sourceUrl")
    private String sourceUrl;

    @SerializedName("recipe_id")
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "recipeId")
    @NonNull
    private String recipeId;

    @SerializedName("image_url")
    @Expose
    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    @SerializedName("social_rank")
    @Expose
    @ColumnInfo(name = "socialRank")
    private int socialRank;

    @SerializedName("publisher_url")
    @Expose
    @ColumnInfo(name = "publisherUrl")
    private String publisherUrl;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2fUrl() {
        return f2fUrl;
    }

    public void setF2fUrl(String f2fUrl) {
        this.f2fUrl = f2fUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(int socialRank) {
        this.socialRank = socialRank;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        this.publisherUrl = publisherUrl;
    }


}
