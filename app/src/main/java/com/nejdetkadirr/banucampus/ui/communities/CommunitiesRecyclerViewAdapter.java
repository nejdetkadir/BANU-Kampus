package com.nejdetkadirr.banucampus.ui.communities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nejdetkadirr.banucampus.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommunitiesRecyclerViewAdapter extends RecyclerView.Adapter<CommunitiesRecyclerViewAdapter.RowHolder> {
    ArrayList<Community> communities = new ArrayList<>();

    public CommunitiesRecyclerViewAdapter(ArrayList<Community> communities) {
        this.communities = communities;
    }

    @NonNull
    @Override
    public CommunitiesRecyclerViewAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_recyclerview_communities,parent,false);
        return new CommunitiesRecyclerViewAdapter.RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunitiesRecyclerViewAdapter.RowHolder holder, int position) {
        //Picasso.get().load(communities.get(position).getImage()).into(holder.image);
        holder.name.setText(communities.get(position).getName());
        holder.manager.setText(communities.get(position).getManager());
        holder.advisor.setText(communities.get(position).getAdvisor());
    }

    @Override
    public int getItemCount() {
        return communities.size();
    }

    class RowHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView manager;
        TextView advisor;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.row_recyclerview_coomunities_image);
            name = itemView.findViewById(R.id.row_recyclerview_coomunities_name);
            manager = itemView.findViewById(R.id.row_recyclerview_coomunities_manager);
            advisor = itemView.findViewById(R.id.row_recyclerview_coomunities_advisor);
        }
    }
}
