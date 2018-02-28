package com.stegnopin.service;

import com.stegnopin.models.Transactions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chandramouliswaran on 2/15/2018.
 */

public interface TransactionsService {

    @GET(value="com.stegnopinweb.transactions")
    Call<List<Transactions>> findAll();

    @POST(value="com.stegnopinweb.transactions/create")
    Call<Void> create(@Body Transactions transactions);

}
