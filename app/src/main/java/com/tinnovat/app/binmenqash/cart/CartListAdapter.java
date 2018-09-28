package com.tinnovat.app.binmenqash.cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tinnovat.app.binmenqash.R;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {

    private Context mContext;
    String test;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mIncrease;
        TextView mDecrease;
        TextView mQuantity;

        TextView mText5;

        public MyViewHolder(View view) {
            super(view);
            mIncrease = view.findViewById(R.id.increase);
            mDecrease = view.findViewById(R.id.decrease);
            mQuantity = view.findViewById(R.id.quantity);
        }
    }


    CartListAdapter(String notifications) {
        this.test = notifications;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_product_list_row, parent, false);
        mContext = parent.getContext();



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.mIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count =Integer.parseInt(holder.mQuantity.getText().toString())+1;
                if (count >= 0)
                holder.mQuantity.setText(""+count);
            }
        });

        holder.mDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count =Integer.parseInt(holder.mQuantity.getText().toString())-1;
                if (count >= 0)
                holder.mQuantity.setText(""+count);

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "test", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}