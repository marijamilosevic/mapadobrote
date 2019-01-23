package com.mapadobrote.mapadobrote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocationAPIService {

    @GET("bins/19yl8o")
    Call<List<Location>> listLocations();
}