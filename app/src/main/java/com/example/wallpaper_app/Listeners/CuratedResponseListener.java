package com.example.wallpaper_app.Listeners;

import com.example.wallpaper_app.Models.CuratedApiResponse;

public interface CuratedResponseListener {
    void onFetch(CuratedApiResponse response, String message);
    void onError(String message);

}
