package com.mapadobrote.mapadobrote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocationAPIService {
    @GET("hskk2mu0kb7ygg1w/convertcsv.json?t=5m33f5c6")
    Call<List<Location>> listLocations();
}