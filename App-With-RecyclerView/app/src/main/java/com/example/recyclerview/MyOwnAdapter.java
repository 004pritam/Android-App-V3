package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {
    String data1[];
    String data2[];
    Context ctx;
    public MyOwnAdapter(Context ct, String s1[], String s2[]) {
        ctx=ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View rowView= layoutInflater.inflate(R.layout.row,parent,false);
        return new MyOwnHolder(rowView); // see below class ctor
    }
    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
    }
    @Override
    public int getItemCount() {
        return data1.length;
    }


    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public MyOwnHolder(@NonNull View itemView) { // here view of row is passed
            super(itemView);
            // just attaching view to t1, t2
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
        }
    }
}
