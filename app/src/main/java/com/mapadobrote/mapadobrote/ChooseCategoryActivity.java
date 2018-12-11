package com.mapadobrote.mapadobrote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ChooseCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> charityTypes = new ArrayList<>();
        charityTypes.add("Odeća i obuća za decu");
        charityTypes.add("Odeća i obuća za odrasle");
        charityTypes.add("odeća i obuća za bebe");
        charityTypes.add("Oprema za bebe");
        charityTypes.add("Hrana");
        charityTypes.add("Sredstva za ličnu higijenu");
        charityTypes.add("Posteljina");
        charityTypes.add("Igračke");
        charityTypes.add("Knjige");
        charityTypes.add("Školski pribor");
        charityTypes.add("Hrana za pse i mačke");
        charityTypes.add("Nameštaj");
        charityTypes.add("Tehnika");
        charityTypes.add("Čep za hendikep");

        RecyclerView recyclerView = findViewById(R.id.rvCharityItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, charityTypes);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
