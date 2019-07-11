package com.example.volleytutorial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    User [] userArray;

    public MyAdapter(Context context, User[] userArray) {
        this.context = context;
        this.userArray = userArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        User user = userArray[i];
        Glide
                .with(context)
                .load(user.getAvatarUrl())
                .into(myViewHolder.userImageView);
        myViewHolder.usernameTextView.setText(user.getLogin());

    }

    @Override
    public int getItemCount() {
        return userArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView userImageView;
        TextView usernameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            userImageView = itemView.findViewById(R.id.userImageView);

        }
    }
}
