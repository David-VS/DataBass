package be.ehb.databass.views.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.databass.R;
import be.ehb.databass.model.Fish;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {

    public class FishViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvColor;

        public FishViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_row_name);
            tvColor = itemView.findViewById(R.id.tv_row_color);
        }
    }

    private ArrayList<Fish> items;

    public FishAdapter() {
        this.items = new ArrayList<Fish>();
    }

    public void addItems(List<Fish> newItems){
        this.items.addAll(newItems);
    }

    @NonNull
    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);
       return new FishViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        Fish currentItem = items.get(position);
        holder.tvName.setText(currentItem.getNaam());
        holder.tvColor.setText(currentItem.getKleur());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
