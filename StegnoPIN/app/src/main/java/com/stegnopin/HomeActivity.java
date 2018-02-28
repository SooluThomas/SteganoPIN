package com.stegnopin;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stegnopin.models.Userinfo;
import com.stegnopin.retrofit.RetrofitRestUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button buttonUpdateUserInfo = (Button) findViewById(R.id.buttonUpdateUserInfo);
        final Button buttonBankingService = (Button) findViewById(R.id.buttonBankingService);

        buttonUpdateUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(HomeActivity.this);

                dialog.setContentView(R.layout.userinfo_layout);


                final EditText editTextName = (EditText) dialog.findViewById(R.id.editTextName);
                final EditText editTextPrimaryNumber = (EditText) dialog.findViewById(R.id.editTextPrimaryNumber);
                final EditText editTextSecondaryNumber = (EditText) dialog.findViewById(R.id.editTextSecondaryNumber);



                final Button buttonUpdateUserInfo = (Button) dialog.findViewById(R.id.buttonUpdateUserInfo);

                try {
                    final List<Userinfo> userinfos = RetrofitRestUtils.getAllUserInfos().execute().body();

                    Userinfo userinfo1 = null;

                    if(userinfos!=null && userinfos.size()>0) {
                        for (Userinfo userinfo : userinfos) {
                            if (userinfo.getUserid().longValue() == Globals.lastLoggedInUser.getUserid().longValue()) {
                                userinfo1 = userinfo;
                            }
                        }

                        if (userinfo1 != null) {
                            editTextName.setText(userinfo1.getName());
                            editTextPrimaryNumber.setText(userinfo1.getPrimarynumber());
                            editTextSecondaryNumber.setText(userinfo1.getSecondarynumber());
                        }
                    }

                    final Userinfo userinfo2 = userinfo1;

                    buttonUpdateUserInfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(userinfo2!=null) {
                                userinfo2.setName(editTextName.getText().toString());
                                userinfo2.setPrimarynumber(editTextPrimaryNumber.getText().toString());
                                userinfo2.setSecondarynumber(editTextSecondaryNumber.getText().toString());

                                try {
                                    RetrofitRestUtils.updateUserInfo(userinfo2).execute();

                                    Toast.makeText(HomeActivity.this,"User Information Updated!",Toast.LENGTH_LONG).show();

                                    dialog.dismiss();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                final Userinfo userinfo3 = new Userinfo();

                                userinfo3.setUserid(BigInteger.valueOf(Globals.lastLoggedInUser.getUserid()));
                                userinfo3.setName(editTextName.getText().toString());
                                userinfo3.setPrimarynumber(editTextPrimaryNumber.getText().toString());
                                userinfo3.setSecondarynumber(editTextSecondaryNumber.getText().toString());

                                try {
                                    RetrofitRestUtils.addUserInfo(userinfo3).execute();

                                    Toast.makeText(HomeActivity.this,"User Information Updated!",Toast.LENGTH_LONG).show();

                                    dialog.dismiss();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

                dialog.show();
            }
        });

        buttonBankingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,StegnoPINActivity.class));
            }
        });

    }
}
