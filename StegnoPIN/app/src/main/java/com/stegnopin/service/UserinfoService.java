package com.stegnopin.service;

import com.stegnopin.models.Userinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chandramouliswaran on 2/14/2018.
 */

public interface UserinfoService {

    @GET(value="com.stegnopinweb.userinfo")
    Call<List<Userinfo>> findAll();

    @POST(value="com.stegnopinweb.userinfo/create")
    Call<Void> create(@Body Userinfo userinfo);

    @POST(value="com.stegnopinweb.userinfo/update")
    Call<Void> update(@Body Userinfo userinfo);

}
