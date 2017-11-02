package com.example.martinakyjakova.lekce05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity {

    private EditText jmeno ;
    private EditText prijmeni;
    private EditText vek;
    private Button pridat;
    private ListView list;

    private MainAdapter adapter;
    private ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pridat = (Button) findViewById(R.id.main_button);
        jmeno = (EditText)findViewById(R.id.main_jmeno);
        prijmeni = (EditText) findViewById(R.id.main_prijmeni);
        vek = (EditText) findViewById(R.id.main_vek);
        list = (ListView) findViewById(R.id.main_list);

        pridat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButton(view);
            }
        });

        arrayList = new ArrayList();
        arrayList.add ("Radim");
        arrayList.add("Jana");
        arrayList.add("Lana");
        arrayList.add("Hana");
        arrayList.add("Jana");

     /*   adapter = new ArrayAdapter(
                this,
                R.layout.list_item_main,
                arrayList
        );*/

        adapter = new MainAdapter(this);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void onButton (View view){
        if ((jmeno.length() == 0) || (prijmeni.length() == 0) || (vek.length() == 0)){
            Toast.makeText(this, "Vypln vsetko!", Toast.LENGTH_SHORT).show();
        } else {

        adapter.add(jmeno.getText().toString(),prijmeni.getText().toString(),vek.getText().toString());
        adapter.notifyDataSetChanged();
        jmeno.setText("");
        prijmeni.setText("");
        vek.setText("");
        }

    }
}
