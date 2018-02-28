package com.stegnopin.service;

import com.stegnopin.models.Stegnopins;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chandramouliswaran on 2/14/2018.
 */

public interface StegnopinsService {

    @GET(value="com.stegnopinweb.stegnopins")
    Call<List<Stegnopins>> findAll();

    @POST(value="com.stegnopinweb.stegnopins/create")
    Call<Void> create(@Body Stegnopins stegnopins);

    @POST(value="com.stegnopinweb.stegnopins/update")
    Call<Void> update(@Body Stegnopins stegnopins);

}
