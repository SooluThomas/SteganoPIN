package com.example.page.mylock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class key_adapter_original extends RecyclerView.Adapter<key_adapter_original.viewhold>
{

    Context c;
    int data[];
    LayoutInflater li;
    Vibrator v;
    int i=0;
    String arr="";
    ArrayList<Integer> data2;

    public key_adapter_original(Context c, int data[],ArrayList<Integer> data2) {

        v= (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        this.c=c;
        this.data=data;
        li=LayoutInflater.from(c);
        this.data2=data2;
    }


    @Override
    public viewhold onCreateViewHolder(ViewGroup parent, int viewType) {
        View li_v=li.inflate(R.layout.cust_keypad,parent,false);
        return new viewhold(li_v);
    }

    @Override
    public void onBindViewHolder(viewhold holder, int position) {

        if(position==9)
        {
            holder.cardView.setVisibility(View.GONE);
            holder.tv.setVisibility(View.GONE);
        }
        else {
            holder.tv.setText("" + data[position]);
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class viewhold extends RecyclerView.ViewHolder
    {
        TextView tv;
        CardView cardView;
        LinearLayout lins;


        public viewhold(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.txt);
            cardView=itemView.findViewById(R.id.card_view);
            lins=itemView.findViewById(R.id.lins);



            lins.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final String pass="1234";
                    v.vibrate(50);
//                    Toast.makeText(c, ""+data[getAdapterPosition()], Toast.LENGTH_SHORT).show();
                    if(i<4)
                    {


                        arr=arr+data2.get(getAdapterPosition());
                        if(i==3)
                        {

                            Toast.makeText(c, ""+arr, Toast.LENGTH_SHORT).show();
                            if(arr.equals(pass))
                            {
                                i=0;
                                arr="";

                                MainActivity.rel[3].setBackgroundResource(R.drawable.filled_round);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Do something after 5s = 5000ms

                                        c.startActivity(new Intent(c,Home.class));
                                    }
                                }, 100);

                                Activity a=(Activity)c;
                                a.finish();
                            }
                            else
                            {
                                MainActivity.rel[3].setBackgroundResource(R.drawable.filled_round);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Do something after 5s = 5000ms
                                        MainActivity.rel[0].setBackgroundResource(R.drawable.layout_round);
                                        MainActivity.rel[1].setBackgroundResource(R.drawable.layout_round);
                                        MainActivity.rel[2].setBackgroundResource(R.drawable.layout_round);
                                        MainActivity.rel[3].setBackgroundResource(R.drawable.layout_round);
                                    }
                                }, 300);



                                i=0;
                                arr="";
                            }

                        }
                        else {
                            i++;
                        }
                    }
                    else
                    {
                        arr="";
                        i=0;
                        arr=arr+data[getAdapterPosition()];
                    }

                    if(i==1)
                    {

                        MainActivity.rel[0].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[1].setBackgroundResource(R.drawable.layout_round);
                        MainActivity.rel[2].setBackgroundResource(R.drawable.layout_round);
                        MainActivity.rel[3].setBackgroundResource(R.drawable.layout_round);

                    }
                    if(i==2)
                    {

                        MainActivity.rel[0].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[1].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[2].setBackgroundResource(R.drawable.layout_round);
                        MainActivity.rel[3].setBackgroundResource(R.drawable.layout_round);

                    }
                    if(i==3)
                    {

                        MainActivity.rel[0].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[1].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[2].setBackgroundResource(R.drawable.filled_round);
                        MainActivity.rel[3].setBackgroundResource(R.drawable.layout_round);

                    }
                    if(i==4)
                    {



                    }

                }
            });


        }
    }
}