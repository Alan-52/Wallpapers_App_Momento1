package com.example.wallpaper_app.Listeners;

import com.example.wallpaper_app.Models.SearchApiResponse;

public interface SearchResponseListener {
    void onFetch(SearchApiResponse response, String message);
    void onError(String message);
}
