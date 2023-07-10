package com.example.praclistviewedison.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.praclistviewedison.Modelos.Infor;
import com.example.praclistviewedison.R;

import java.util.ArrayList;

public class AdaptadorInfo extends ArrayAdapter<Infor> {
    public AdaptadorInfo(Context context, ArrayList<Infor> datos) {
        super(context, R.layout.lyiteminformacion, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyiteminformacion, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNom());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getImagen())
                .into(imageView);


        return(item);


    }
}