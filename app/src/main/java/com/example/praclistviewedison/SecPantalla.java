package com.example.praclistviewedison;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.praclistviewedison.Adaptadores.AdaptadorUteqRev;
import com.example.praclistviewedison.Modelos.UteqRevista;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class SecPantalla extends AppCompatActivity implements Asynchtask {


    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_pantalla);
        Bundle b  = this.getIntent().getExtras();

        lstOpciones = (ListView)findViewById(R.id.revista);
        View header = getLayoutInflater().inflate(R.layout.lyheaderinfo, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+b.getString("id"),
                datos, SecPantalla.this, SecPantalla.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray jsonArray = new JSONArray(result);
        ArrayList<UteqRevista> revis = UteqRevista.JsonObjectsBuild(jsonArray);
        AdaptadorUteqRev rev = new AdaptadorUteqRev(this, revis);
        lstOpciones.setAdapter(rev);
    }
}