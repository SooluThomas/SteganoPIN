package com.example.page.mylock;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class key_adapter extends RecyclerView.Adapter<key_adapter.viewhold>
{

    Context c;
    ArrayList<Integer> data;
    LayoutInflater li;


    public key_adapter(Context c, ArrayList<Integer> data) {

        this.c=c;
        this.data=data;
        li=LayoutInflater.from(c);
    }


    @Override
    public viewhold onCreateViewHolder(ViewGroup parent, int viewType) {
        View li_v=li.inflate(R.layout.cust_view,parent,false);
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
            holder.tv.setText("" + data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewhold extends RecyclerView.ViewHolder
    {
        TextView tv;
        CardView cardView;
        public viewhold(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.txt);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }
}