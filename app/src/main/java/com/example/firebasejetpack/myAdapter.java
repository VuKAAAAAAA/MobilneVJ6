package com.example.firebasejetpack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter extends FirebaseRecyclerAdapter<Predavanje, myAdapter.viewHolder> {

   public Context context;

    public myAdapter(@NonNull FirebaseRecyclerOptions<Predavanje> objects) {
        super(objects);
    }

    class viewHolder extends RecyclerView.ViewHolder {
        TextView predavanje;
        TextView godina;
        TextView nastavnik;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            predavanje = (TextView) itemView.findViewById(R.id.textView11);
            godina = (TextView) itemView.findViewById(R.id.textView22);
            nastavnik = (TextView) itemView.findViewById(R.id.textView33);
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull final viewHolder holder, final int position, @NonNull Predavanje model) {

        holder.predavanje.setText(model.getIme());
        holder.nastavnik.setText(model.getPredavac());
        holder.godina.setText(String.valueOf(model.getGodina()));

        final String positionOfItem = getRef(position).getKey();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_id = positionOfItem;

                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id",user_id);
            
                context.startActivity(intent);

            }
        });

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        context = parent.getContext();
        return new viewHolder(view);
    }

}
