package com.mapadobrote.mapadobrote;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private final Context context;
    private List<ChooseCategory> myCharityData;
    private LayoutInflater myInflater;
    private View.OnClickListener myClickListener;


    MyRecyclerViewAdapter(Context context, List<ChooseCategory> categoryType) {
        this.myInflater = LayoutInflater.from(context);
        this.context = context;
        this.myCharityData = categoryType;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChooseCategory charitycategory = myCharityData.get(position);
        holder.myTextView.setText(charitycategory.category);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapsActivity.class);
                context.startActivity(intent);
            }
        });
        holder.categoryImage.setImageResource(charitycategory.imageUrl);
    }

    @Override
    public int getItemCount() {
        if (myCharityData != null) {
            return myCharityData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageView categoryImage;


        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvCharityItem);
            categoryImage = itemView.findViewById(R.id.ivCharityCategory);
        }

    }


}
