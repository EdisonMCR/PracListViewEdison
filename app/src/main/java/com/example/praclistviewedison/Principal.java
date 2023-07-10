package com.example.praclistviewedison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.praclistviewedison.Adaptadores.AdaptadorInfo;
import com.example.praclistviewedison.Modelos.Infor;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.WebService;
import WebService.Asynchtask;


public class Principal extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstListaUsuario);
        View header = getLayoutInflater().inflate(R.layout.lyheaderinfo, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, Principal.this, Principal.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Infor> lstContenido = Infor.JsonObjectsBuild(jsonArray);
        AdaptadorInfo informa = new AdaptadorInfo(this, lstContenido);
        lstOpciones.setAdapter(informa);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(Principal.this, SecPantalla.class);
                Bundle b = new Bundle();
                b.putString("id", ((Infor)a.getItemAtPosition(position)).getId());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}