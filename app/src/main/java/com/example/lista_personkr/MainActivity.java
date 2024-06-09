package com.example.lista_personkr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    int sum = 0;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.Total);

        listView=(ListView)findViewById(R.id.ListaP);
        String[] nombres={"Durazno","Fresa","Mango","Manzana","Piña"};
        String[] precios ={"30","40","35","20","55"};
        Integer[]  imagen= {R.drawable.durazno, R.drawable.fresa, R.drawable.mango, R.drawable.manzana, R.drawable.pi_a};
        AdapterList adapter = new AdapterList(this, nombres, precios, imagen);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sum = sum + Integer.parseInt(precios[position]);
                total.setText("Total" +sum);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                sum = sum - Integer.parseInt(precios[position]);
                total.setText("Total: " +sum);
                return true;
            }
        });
    }
}