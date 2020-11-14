package com.example.chatqf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {
    // dah law ha5od data mn makan mo3ayan
    public RecyclerViewAdapter(String data, Context context, int count) {

    }

    public RecyclerViewAdapter() {
    }

    // here we prepare the data to be accessed
    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // access the item
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        // hold the item so i can use it in the future
        RecyclerHolder recyclerHolder= new RecyclerHolder(view);
        return recyclerHolder;
    }

    // here we actually access the data
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.name.setText("Ahmed"+position);
    }

    // get the count of the items in the Recycler view
    @Override
    public int getItemCount() {
        return 10 ;
    }

    // access the recycler view xml
    public class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView name;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);

        }
    }
}

