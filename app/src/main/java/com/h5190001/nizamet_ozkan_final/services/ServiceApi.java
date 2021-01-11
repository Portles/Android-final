package com.h5190001.nizamet_ozkan_final.services;

import com.h5190001.nizamet_ozkan_final.models.ListItems;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("GameforgeGames.json")
    Observable<List<ListItems>> GetListItems();
}
