package com.mapadobrote.mapadobrote;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @Nullable
    @Expose
    public int id;

    @Nullable
    @Expose()
    public String name;

    @Nullable
    @Expose
    public String state;

    @Expose()
    @Nullable
    public String address;

    @Expose
    @Nullable
    @SerializedName("working_hours")
    public String workingHours;

    @Expose()
    @Nullable
    public String description;

    @Expose()
    @Nullable
    public String email;

    @Expose()
    @Nullable
    @SerializedName("fb_page")
    public String facebookPage;

    @Expose()
    @Nullable
    @SerializedName("website")
    public String webSite;

    @Expose()
    @Nullable
    public String phone;

    @SerializedName("additional_info")
    @Nullable
    @Expose()
    public String additionalInfo;

    @Expose()
    @Nullable
    @SerializedName("required categories")
    public String categories;

    Location(int id, String name, String state, String address, String workingHours, String description, String email, String facebookPage, String webSite) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.address = address;
        this.workingHours = workingHours;
        this.description = description;
        this.email = email;
        this.facebookPage = facebookPage;
        this.webSite = webSite;
    }
}
