package com.guardz.dagger2.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guardz.dagger2.demo1.test1.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car car = new Car();
        car.inject();
        car.print();

        Car car2 = new Car();
        car2.inject();
        car2.print();

    }
}
