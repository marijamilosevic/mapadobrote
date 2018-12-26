package com.mapadobrote.mapadobrote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseCategoryActivity extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ChooseCategory> charityTypes = new ArrayList<ChooseCategory>();
        charityTypes.add(new ChooseCategory("Odeca i obuca za decu", null, 1));
        charityTypes.add(new ChooseCategory("Odeća i obuća za odrasle", null, 2));
        charityTypes.add(new ChooseCategory("odeća i obuća za bebe", null, 3));
        charityTypes.add(new ChooseCategory("Oprema za bebe", null, 4));
        charityTypes.add(new ChooseCategory("Hrana", null, 5));
        charityTypes.add(new ChooseCategory("Sredstva za ličnu higijenu", null, 6));
        charityTypes.add(new ChooseCategory("Posteljina", null, 7));
        charityTypes.add(new ChooseCategory("Igračke", null, 8));
        charityTypes.add(new ChooseCategory("Knjige", null, 9));
        charityTypes.add(new ChooseCategory("Školski pribor", null, 10));
        charityTypes.add(new ChooseCategory("Hrana za pse i mačke", null, 11));
        charityTypes.add(new ChooseCategory("Nameštaj", null, 12));
        charityTypes.add(new ChooseCategory("Tehnika", null, 13));
        charityTypes.add(new ChooseCategory("Čep za hendikep", null, 14));

        RecyclerView recyclerView = findViewById(R.id.rvCharityItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, charityTypes);
        recyclerView.setAdapter(adapter);
    }
}