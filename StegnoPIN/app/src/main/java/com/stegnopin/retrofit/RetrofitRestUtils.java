package com.stegnopin.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stegnopin.Globals;
import com.stegnopin.models.Accounts;
import com.stegnopin.models.Stegnopins;
import com.stegnopin.models.Transactions;
import com.stegnopin.models.Userinfo;
import com.stegnopin.models.Users;
import com.stegnopin.service.AccountsService;
import com.stegnopin.service.StegnopinsService;
import com.stegnopin.service.TransactionsService;
import com.stegnopin.service.UserinfoService;
import com.stegnopin.service.UsersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chandramouliswaran on 2/14/2018.
 */

public class RetrofitRestUtils {

    public static Call<List<Users>> getAllUsers() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UsersService.class).findAll();
    }

    public static Call<Void> registerUser(Users users) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UsersService.class).create(users);
    }

    public static Call<List<Userinfo>> getAllUserInfos() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UserinfoService.class).findAll();
    }

    public static Call<Void> addUserInfo(Userinfo userinfo) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UserinfoService.class).create(userinfo);
    }

    public static Call<Void> updateUserInfo(Userinfo userinfo) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(UserinfoService.class).update(userinfo);
    }

    public static Call<List<Stegnopins>> getAllStegnopins() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(StegnopinsService.class).findAll();
    }

    public static Call<Void> addStegnopin(Stegnopins stegnopins) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(StegnopinsService.class).create(stegnopins);
    }

    public static Call<Void> updateStegnopin(Stegnopins stegnopins) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(StegnopinsService.class).update(stegnopins);
    }

    public static Call<List<Accounts>> getAllAccounts() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(AccountsService.class).findAll();
    }

    public static Call<Void> addAccount(Accounts accounts) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(AccountsService.class).create(accounts);
    }

    public static Call<Accounts> updateAccount(Accounts accounts) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(AccountsService.class).update(accounts);
    }

    public static Call<List<Transactions>> getAllTransactions() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(TransactionsService.class).findAll();
    }

    public static Call<Void> createTransaction(Transactions transactions) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ Globals.serverIP+":34270/StegnoPINWeb/webresources/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(TransactionsService.class).create(transactions);
    }

}
