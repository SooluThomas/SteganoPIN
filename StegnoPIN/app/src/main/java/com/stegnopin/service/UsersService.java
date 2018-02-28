package com.stegnopin.service;

import com.stegnopin.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chandramouliswaran on 2/14/2018.
 */

public interface UsersService {
    @GET(value="com.stegnopinweb.users")
    Call<List<Users>> findAll();

    @POST(value="com.stegnopinweb.users/create")
    Call<Void> create(@Body Users users);

}
