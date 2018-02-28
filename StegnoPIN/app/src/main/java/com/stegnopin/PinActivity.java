package com.stegnopin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stegnopin.models.Stegnopins;
import com.stegnopin.retrofit.RetrofitRestUtils;

import org.w3c.dom.Text;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PinActivity extends AppCompatActivity {

    private int pinCount = 0;

    private String lastPin="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        final TextView textViewPinType = (TextView) findViewById(R.id.textViewPinType);
        final Button buttonCreateOTP = (Button) findViewById(R.id.buttonCreateOTP);

        buttonCreateOTP.setVisibility(View.INVISIBLE);

        if(Globals.lastKeypadType.equals("input")) {
            textViewPinType.setText("INITIAL INPUT");
            buttonCreateOTP.setVisibility(View.VISIBLE);
        } else if(Globals.lastKeypadType.equals("challenge")) {
            textViewPinType.setText("CHALLENGE");
            buttonCreateOTP.setVisibility(View.VISIBLE);
            buttonCreateOTP.setText("UPDATE RESPONSE");
        } else if(Globals.lastKeypadType.equals("response")) {
            textViewPinType.setText("RESPONSE");
            buttonCreateOTP.setVisibility(View.VISIBLE);
            buttonCreateOTP.setText("CREATE PIN");
        } else if(Globals.lastKeypadType.equals("login")) {
            textViewPinType.setText("LOGIN");
            buttonCreateOTP.setVisibility(View.VISIBLE);
            buttonCreateOTP.setText("LOGIN");
        }

        final int[] pinIds =
                new int[] { R.id.p1, R.id.p2, R.id.p3, R.id.p4, R.id.p5, R.id.p6, R.id.p7, R.id.p8, R.id.p9, R.id.pStar, R.id.p0, R.id.pHash };
        final int[] pinChallengeValues =
                new int[] { 5, 7, 6, 9, 1, 4, 2, 3, 0, -1, 8, -2 };

        final List<TextView> pinNumbers = new ArrayList<TextView>();
        final List<Boolean> checks = new ArrayList<Boolean>();

        for(int i=0;i<pinIds.length;i++) {
            int id = pinIds[i];

            final TextView textViewNumber = (TextView) findViewById(id);
            pinNumbers.add(textViewNumber);
            checks.add(Boolean.FALSE);

        }

        if(Globals.lastKeypadType.equals("challenge")) {
            for (int i = 0; i < pinIds.length; i++) {
                int id = pinIds[i];

                final TextView textViewNumber = (TextView) findViewById(id);

                if (pinChallengeValues[i] >= 0) {
                    textViewNumber.setText("" + pinChallengeValues[i]);
                } else if (pinChallengeValues[i] == -1) {
                    textViewNumber.setText("*");
                } else if (pinChallengeValues[i] == -2) {
                    textViewNumber.setText("#");
                }

            }
        }

        if(!Globals.lastPin.equals("") && Globals.lastKeypadType.equals("challenge")) {
            String otpPin = "";
            char[] pin = Globals.lastPin.toCharArray();

            for(char c : pin) {
                if(c!='*' && c!='#') {
                    int n = Integer.parseInt(""+c);
                    if(n==0) {
                        otpPin += ("" + pinChallengeValues[pinChallengeValues.length-2]);

                        TextView textViewNumber = (TextView) findViewById(R.id.p0);

                        textViewNumber.setShadowLayer(
                                    15f, // radius
                                    4.0f, // dx
                                    4.0f, // dy
                                    Color.GREEN
                            );
                    } else {
                        otpPin += ("" + pinChallengeValues[n - 1]);

                        TextView textViewNumber = (TextView) findViewById(pinIds[n-1]);

                        textViewNumber.setShadowLayer(
                                15f, // radius
                                4.0f, // dx
                                4.0f, // dy
                                Color.GREEN
                        );
                    }
                } else {
                    if(c=='*') {
                        otpPin += "*";
                        TextView textViewNumber = (TextView) findViewById(R.id.pStar);

                        textViewNumber.setShadowLayer(
                                15f, // radius
                                4.0f, // dx
                                4.0f, // dy
                                Color.GREEN
                        );
                    } else if(c=='#') {
                        otpPin += "#";
                        TextView textViewNumber = (TextView) findViewById(R.id.pHash);

                        textViewNumber.setShadowLayer(
                                15f, // radius
                                4.0f, // dx
                                4.0f, // dy
                                Color.GREEN
                        );
                    }
                }
            }

            Globals.lastOtpPin = otpPin;
            System.out.println("OTP - "+otpPin);
        }

        buttonCreateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonCreateOTP.getText().equals("CREATE OTP")) {
                    Globals.lastKeypadType = "challenge";
                    Globals.lastPin = lastPin;
                    PinActivity.super.recreate();
                } else if(buttonCreateOTP.getText().equals("UPDATE RESPONSE")) {
                    finish();
                } else if(buttonCreateOTP.getText().equals("CREATE PIN")) {

                    try {
                        if(lastPin.equals(Globals.lastOtpPin)) {
                            final List<Stegnopins> stegnopins = RetrofitRestUtils.getAllStegnopins().execute().body();

                            Stegnopins stegnopins1 = null;

                            if (stegnopins != null && stegnopins.size() > 0) {
                                for (Stegnopins pin : stegnopins) {
                                    if (pin.getUserid().longValue() == Globals.lastLoggedInUser.getUserid().longValue()) {
                                        stegnopins1 = pin;
                                        break;
                                    }
                                }
                            }

                            if (stegnopins1 != null) {
                                stegnopins1.setUserid(BigInteger.valueOf(Globals.lastLoggedInUser.getUserid()));
                                stegnopins1.setPin(Globals.lastPin);
                                stegnopins1.setOtp(Globals.lastOtpPin);

                                RetrofitRestUtils.updateStegnopin(stegnopins1).execute();

                                finish();
                            } else {
                                stegnopins1 = new Stegnopins();

                                stegnopins1.setUserid(BigInteger.valueOf(Globals.lastLoggedInUser.getUserid()));
                                stegnopins1.setPin(Globals.lastPin);
                                stegnopins1.setOtp(Globals.lastOtpPin);

                                RetrofitRestUtils.addStegnopin(stegnopins1).execute();

                                finish();
                            }

                            Toast.makeText(PinActivity.this,"OTP/PIN Updated!",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(PinActivity.this,"OTP/PIN Mismatch!",Toast.LENGTH_LONG).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        final View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView number = (TextView) view;

                if(pinCount<4) {
                    final String num = number.getText().toString();

                    if(num.equals("*") || num.equals("#")) {
                        if(num.equals("*")) {
                            if(checks.get(checks.size()-2).booleanValue()) {
                                checks.set(checks.size()-2, Boolean.FALSE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.BLACK
                                );

                                lastPin = lastPin.replace("*","");

                                if (pinCount != 0) {
                                    pinCount--;
                                    return;
                                }
                            } else {
                                checks.set(checks.size()-2,Boolean.TRUE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.RED
                                );

                                lastPin = lastPin.concat("*");
                            }
                        } else if(num.equals("#")) {
                            if(checks.get(checks.size()-1).booleanValue()) {
                                checks.set(checks.size()-1, Boolean.FALSE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.BLACK
                                );

                                lastPin = lastPin.replace("#","");

                                if (pinCount != 0) {
                                    pinCount--;
                                    return;
                                }
                            } else {
                                checks.set(checks.size()-1,Boolean.TRUE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.RED
                                );

                                lastPin = lastPin.concat("#");
                            }
                        }
                    } else {
                        int pinnumber = Integer.parseInt(num);
                        //int pinId = pinIds[pinnumber];

                        if(checks.get(pinnumber).booleanValue()) {
                            checks.set(pinnumber,Boolean.FALSE);

                            number.setShadowLayer(
                                    15f, // radius
                                    4.0f, // dx
                                    4.0f, // dy
                                    Color.BLACK
                            );

                            lastPin = lastPin.replace(""+pinnumber,"");

                            if(pinCount!=0) {
                                pinCount--;
                                return;
                            }
                        } else {
                           checks.set(pinnumber,Boolean.TRUE);

                           number.setShadowLayer(
                                    15f, // radius
                                    4.0f, // dx
                                    4.0f, // dy
                                    Color.RED
                            );

                            lastPin = lastPin.concat(""+pinnumber);
                        }
                    }

                } else {
                    final String num = number.getText().toString();

                    if(num.equals("*") || num.equals("#")) {
                        if(num.equals("*")) {
                            if(checks.get(checks.size()-2).booleanValue()) {
                                checks.set(checks.size()-2, Boolean.FALSE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.BLACK
                                );

                                lastPin = lastPin.replace("*","");

                                if (pinCount != 0) {
                                    pinCount--;
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if(num.equals("#")) {
                            if(checks.get(checks.size()-1).booleanValue()) {
                                checks.set(checks.size()-1, Boolean.FALSE);

                                number.setShadowLayer(
                                        15f, // radius
                                        4.0f, // dx
                                        4.0f, // dy
                                        Color.BLACK
                                );

                                lastPin = lastPin.replace("#","");

                                if (pinCount != 0) {
                                    pinCount--;
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        int pinnumber = Integer.parseInt(num);
                        //int pinId = pinIds[pinnumber];

                        if(checks.get(pinnumber).booleanValue()) {
                            checks.set(pinnumber,Boolean.FALSE);

                            number.setShadowLayer(
                                    15f, // radius
                                    4.0f, // dx
                                    4.0f, // dy
                                    Color.BLACK
                            );

                            lastPin = lastPin.replace(""+pinnumber,"");

                            if(pinCount!=0) {
                                pinCount--;
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }

                System.out.println("Last Pin - "+lastPin);

                pinCount++;

                if(pinCount==4) {
                    buttonCreateOTP.setVisibility(View.VISIBLE);
                } else {
                    buttonCreateOTP.setVisibility(View.INVISIBLE);
                }
            }
        };

        for(TextView pinNumber : pinNumbers) {
            pinNumber.setOnClickListener(clickListener);
        }


    }
}
