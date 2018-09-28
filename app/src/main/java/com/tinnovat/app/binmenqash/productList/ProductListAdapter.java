package com.tinnovat.app.binmenqash.productList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tinnovat.app.binmenqash.R;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private Context mContext;
    String test;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mIncrease;
        TextView mDecrease;
        TextView mQuantity;

        TextView mText5;

        public MyViewHolder(View view) {
            super(view);

        }
    }


    ProductListAdapter(String notifications) {
        this.test = notifications;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);
        mContext = parent.getContext();



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {



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