package com.mapadobrote.mapadobrote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> myCharityData;
    private LayoutInflater myInflater;
    private View.OnClickListener myClickListener;


    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.myInflater = LayoutInflater.from(context);
        this.myCharityData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String charitycategory = myCharityData.get(position);
        holder.myTextView.setText(charitycategory);
    }

    @Override
    public int getItemCount() {
        if (myCharityData != null) {
            return myCharityData.size();
        } else {
            return 0;
        }
    }

    public void setClickListener(View.OnClickListener itemClickListener) {
        this.myClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;


        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvCharityItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) myClickListener.onClick(view);
        }
    }


}
