package com.stegnopin.service;

import com.stegnopin.models.Accounts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chandramouliswaran on 2/14/2018.
 */

public interface AccountsService {
    @GET(value="com.stegnopinweb.accounts")
    Call<List<Accounts>> findAll();

    @POST(value="com.stegnopinweb.accounts/create")
    Call<Void> create(@Body  Accounts accounts);

    @POST(value="com.stegnopinweb.accounts/update")
    Call<Accounts> update(@Body  Accounts accounts);
}
