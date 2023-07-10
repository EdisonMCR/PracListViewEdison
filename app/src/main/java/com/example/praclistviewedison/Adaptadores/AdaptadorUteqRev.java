package com.example.praclistviewedison.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.praclistviewedison.Modelos.UteqRevista;
import com.example.praclistviewedison.R;

import java.util.ArrayList;

public class AdaptadorUteqRev extends ArrayAdapter<UteqRevista> {
    public AdaptadorUteqRev(Context context, ArrayList<UteqRevista> datos) {
        super(context, R.layout.lyitemuteqrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemuteqrevista, null);
        TextView lblnames = (TextView)item.findViewById(R.id.lblNombre);
        lblnames.setText(getItem(position).getNom());
        TextView lbldoi = (TextView)item.findViewById(R.id.lbdoi);
        lbldoi.setText(getItem(position).getDoi());
        TextView lblfecha = (TextView)item.findViewById(R.id.lblpublicacion);
        lblfecha.setText(getItem(position).getFecha());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getImagen())
                .into(imageView);
        return(item);
    }
}