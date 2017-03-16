package com.guardz.processor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PizzaStore store = new PizzaStore();
        Log.d("sss",store.order("CalzonePizza").getPrice());
        Log.d("sss",store.order("Tiramisu").getPrice());
        Log.d("sss",store.order("MargheritaPizza").getPrice());
    }
}
