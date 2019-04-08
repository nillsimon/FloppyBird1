package com.example.javaoop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String puma;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cat cat1 = new Cat();
        Log.i("numberOfLegs", "cat1 number of legs: " + Cat.whatsCatsLike());

        Lion lion = new Lion();
        lion.talk();
    }
}
