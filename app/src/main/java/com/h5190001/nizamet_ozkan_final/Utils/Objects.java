package com.h5190001.nizamet_ozkan_final.Utils;

import com.google.gson.Gson;
import com.h5190001.nizamet_ozkan_final.Models.ListItems;

public class Objects {
    public static String ListItemToJsonString(ListItems listItems)
    {
        Gson gson = new Gson();
        return   gson.toJson(listItems);
    }

    public static ListItems jsonStringToListItem(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,ListItems.class);
    }
}
