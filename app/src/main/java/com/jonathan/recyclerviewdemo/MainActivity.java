package com.jonathan.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* contenu du RecyclerView */
        ArrayList content = new ArrayList<String>();

        for(int i=0;i < 5; i++) {
            content.add("Ligne " + String.valueOf(i));
        }

        RecyclerView rv = findViewById(R.id.RecyclerView);
        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(this, content);
        rv.setAdapter(rvAdapter);

        /* Obligatoire selon la documentation.. À vérifier sa réelle utilitée */
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
