package com.example.javaoop;

import android.util.Log;

public class Puma extends Cat {

    public Puma() {
        this.name = "Jonny";
        this.age = 3;
        this.man = false;
    }

    public void talk(){
    Log.i("talk", "R-r-r! I'm Puma. My name is " + name + "," +
            " and I'm " + age + " years old end is man " + man);

}
}
