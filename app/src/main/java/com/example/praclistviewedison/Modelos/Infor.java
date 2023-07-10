package com.example.praclistviewedison.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Infor {
    private String nom;
    private String imagen;
    private String id;

    //private String abreviacion;
    public Infor(JSONObject a) throws JSONException {
        nom = a.getString("name").toString();
        imagen = a.getString("portada").toString();
        id = a.getString("journal_id").toString();
        //abreviacion = a.getString("abbreviation").toString() ;
    }

    public static ArrayList<Infor> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Infor> informa = new ArrayList<>();
        for (int i = 0; i < datos.length() && i < 20; i++) {
            informa.add(new Infor(datos.getJSONObject(i)));
        }
        return informa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}