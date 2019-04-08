package com.example.phone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Phone> phones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        DataAdapter adapter = new DataAdapter(this,phones);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.virabxadrasana));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.trikonasana));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.virabxadrasana));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.shavasana));
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.bhekasana));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.trikonasana));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.virabxadrasana));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.shavasana));
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.gomukxasana));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.trikonasana));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.virabxadrasana));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.bxudzhangasana));
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.bhekasana));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.trikonasana));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.virabxadrasana));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.shavasana));
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.bxudzhangasana));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.trikonasana));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.virabxadrasana));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.bxudzhangasana));



    }
}
