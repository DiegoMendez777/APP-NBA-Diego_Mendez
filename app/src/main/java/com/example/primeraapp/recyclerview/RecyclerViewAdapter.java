package com.example.primeraapp.recyclerview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primeraapp.MODEL.Contact;
import com.example.primeraapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Contact> array_noms;

    public RecyclerViewAdapter(ArrayList<Contact> arrN){
        array_noms = arrN;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombreequipo.setText(array_noms.get(position).getEquipo());
        holder.date.setText(array_noms.get(position).getFecha());
        holder.description.setText(array_noms.get(position).getDescipcion());
    }

    @Override
    public int getItemCount() {
        return array_noms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombreequipo;
        TextView date;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreequipo = itemView.findViewById(R.id.userName);
            date = itemView.findViewById(R.id.idDate);
            description = itemView.findViewById(R.id.idDescription);
        }
    }
}


