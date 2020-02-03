package com.mapadobrote.mapadobrote;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChooseCategoryActivity extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ChooseCategory> charityTypes = new ArrayList<ChooseCategory>();
        charityTypes.add(new ChooseCategory("Odeća i obuća za odrasle", R.drawable.ic_t_shirt, 1));
        charityTypes.add(new ChooseCategory("Odeca i obuća za decu", R.drawable.ic_pajamas, 2));
        charityTypes.add(new ChooseCategory("Odeća i obuća za bebe", R.drawable.ic_baby_with_diaper, 3));
        charityTypes.add(new ChooseCategory("Oprema za bebe", R.drawable.ic_baby_carriage, 4));
        charityTypes.add(new ChooseCategory("Hrana", R.drawable.ic_food, 5));
        charityTypes.add(new ChooseCategory("Sredstva za ličnu higijenu", R.drawable.ic_bathtub, 6));
        charityTypes.add(new ChooseCategory("Posteljina", R.drawable.ic_bed, 7));
        charityTypes.add(new ChooseCategory("Igračke", R.drawable.ic_hobbyhorse, 8));
        charityTypes.add(new ChooseCategory("Knjige", R.drawable.ic_books_stack_of_three, 9));
        charityTypes.add(new ChooseCategory("Hrana za pse i mačke", R.drawable.ic_animal_prints, 10));
        charityTypes.add(new ChooseCategory("Čep za hendikep", R.drawable.ic_wheelchair_symbol, 11));

        RecyclerView recyclerView = findViewById(R.id.rvCharityItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, charityTypes);
        recyclerView.setAdapter(adapter);
    }
}