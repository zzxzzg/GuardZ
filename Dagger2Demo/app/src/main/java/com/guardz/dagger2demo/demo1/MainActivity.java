package com.guardz.dagger2demo.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.guardz.dagger2demo.R;
import com.guardz.dagger2demo.demo2.Customer;
import com.guardz.dagger2demo.demo3.Person;
import com.guardz.dagger2demo.demo6.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //@Inject
    OSHelp mOSHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityComponent component=DaggerActivityComponent.builder().appComponent(((MyApplication)getApplication()).getAppComponent()).build();
        component.inject(this);

        mOSHelp=component.getOSHelp();
        Log.d("sss",mOSHelp.getDeviceBrand());

        Customer customer=new Customer();
        Person person=new Person();

        User user=new User();


    }
}
