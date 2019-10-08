package com.example.searchablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    List<ViewModel> models;
    private LayoutInflater mInflater;

    ListAdapter(Context context, List<ViewModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.models = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewModel model = models.get(position);
        holder.nameTextView.setText(model.name);
        holder.familyTextView.setText(model.family);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return models.size();
    }

    ViewModel getItem(int id) {
        return models.get(id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView nameTextView;
        TextView familyTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.Name);
            familyTextView=itemView.findViewById(R.id.Family);

        }


    }

}
