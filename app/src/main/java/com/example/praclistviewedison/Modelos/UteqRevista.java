package com.example.praclistviewedison.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UteqRevista {
    private String nom;
    private String imagen;
    private String doi;
    private String fecha;


    public UteqRevista(JSONObject a) throws JSONException {
        nom = a.getString("title").toString();
        imagen = a.getString("cover").toString();
        fecha = a.getString("date_published").toString();
        doi = a.getString("doi").toString();
    }

    public static ArrayList<UteqRevista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<UteqRevista> revista = new ArrayList<>();
        for (int i = 0; i < datos.length() && i < 20; i++) {
            revista.add(new UteqRevista(datos.getJSONObject(i)));
        }
        return revista;
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

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

