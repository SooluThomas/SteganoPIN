package com.stegnopin;

import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stegnopin.models.Users;
import com.stegnopin.retrofit.RetrofitRestUtils;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        final SharedPreferences preferences = getSharedPreferences("STEGNOPIN",MODE_PRIVATE);
        final String ipAddress = preferences.getString("IPADDRESS","192.168.43.66");

        Globals.serverIP = ipAddress;

        final Button buttonRegister = (Button) findViewById(R.id.buttonRegister);
        final Button buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.register_layout);

                final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
                final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPassword);
                final EditText editTextEmailId = (EditText) dialog.findViewById(R.id.editTextEmailID);

                final Button buttonRegister = (Button) dialog.findViewById(R.id.buttonRegister);

                buttonRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String username = editTextUserName.getText().toString();
                        final String password = editTextPassword.getText().toString();
                        final String emailId = editTextEmailId.getText().toString();

                        try {
                            final List<Users> users = RetrofitRestUtils.getAllUsers().execute().body();

                            if(users!=null && users.size()>0)
                            for(Users user : users) {
                                if(user.getUsername().equals(username)) {
                                    Toast.makeText(MainActivity.this, "User Allready Exists!", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            }

                            Users user = new Users();

                            user.setUsername(username);
                            user.setPassword(password);
                            user.setEmailid(emailId);

                            RetrofitRestUtils.registerUser(user).execute();

                            dialog.dismiss();

                            Toast.makeText(MainActivity.this, "User Registered!", Toast.LENGTH_LONG).show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

                dialog.show();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.login_layout);

                final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserName);
                final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPassword);

                final Button buttonLogin = (Button) dialog.findViewById(R.id.buttonLogin);

                buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String username = editTextUserName.getText().toString();
                        final String password = editTextPassword.getText().toString();

                        try {
                            final List<Users> users = RetrofitRestUtils.getAllUsers().execute().body();

                            if(users!=null && users.size()>0)
                            for(Users user : users) {
                                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                                    Globals.lastLoggedInUser = user;
                                    Toast.makeText(MainActivity.this,"Login Successfull!",Toast.LENGTH_LONG).show();
                                    dialog.dismiss();
                                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                                    return;
                                }
                            }

                            Toast.makeText(MainActivity.this,"Login Unsuccessfull!",Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.itemSettings:
            {
                final SharedPreferences preferences = getSharedPreferences("STEGNOPIN",MODE_PRIVATE);
                final String ipAddress = preferences.getString("IPADDRESS","192.168.43.66");

                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.settings_layout);

                final EditText editTextIPAddress = (EditText) dialog.findViewById(R.id.editTextIPAddress);
                final Button buttonSaveSettings = (Button) dialog.findViewById(R.id.buttonSaveSettings);

                editTextIPAddress.setText(ipAddress);

                buttonSaveSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SharedPreferences.Editor edit = preferences.edit();

                        edit.putString("IPADDRESS",editTextIPAddress.getText().toString());
                        edit.commit();


                        Globals.serverIP = editTextIPAddress.getText().toString();

                        Toast.makeText(MainActivity.this,"Settings Saved!",Toast.LENGTH_LONG).show();

                        dialog.dismiss();
                    }
                });

                dialog.show();

                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
