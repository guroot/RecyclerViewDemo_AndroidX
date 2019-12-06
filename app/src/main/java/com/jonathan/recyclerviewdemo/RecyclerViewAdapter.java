package com.jonathan.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public ArrayList<String> contenu = new ArrayList<String>();
    public Context context;


    public RecyclerViewAdapter(Context context, ArrayList<String> contenu) {
        this.contenu = contenu;
        this.context = context;
    }

    @NonNull
    @Override
    /**
     * Retourne un ViewHolder contenant la vue ( et donc un layout )
     * pour chacune des cellules
     */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cellule_recyclerview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.texte.setText(contenu.get(position));
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,contenu.get(position),Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    /**
     * Détermine la grosseur qu'aura le RecyclerView.
     * Il est important de faire le lien avec le contenu.
     */
    public int getItemCount() {
        return contenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView texte;
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texte = (TextView) itemView.findViewById(R.id.textView);
            relativeLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
