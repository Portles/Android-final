package com.h5190001.nizamet_ozkan_final.Services;

import com.h5190001.nizamet_ozkan_final.Models.ListItems;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("Datas.json")
    Observable<List<ListItems>> GetListItems();
}
