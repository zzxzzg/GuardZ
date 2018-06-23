package com.guardz.cleanvision.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewStub;

import com.guardz.cleanvision.R;
import com.guardz.cleanvision.presentation.Contracts;
import com.guardz.cleanvision.presentation.IComponentGroup;
import com.guardz.cleanvision.presentation.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements Contracts.IMainView,IComponentGroup{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("sss","test");
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this);
        ViewStub stub1=  findViewById(R.id.component1);
        ViewStub stub2=  findViewById(R.id.component2);

        Component1 component1 = new Component1(stub1,this);
        component1.inflate();

        Component2 component2 = new Component2(stub2,this);
        component2.inflate();
    }

    @Override
    public void receiveProxy(Proxy proxy) {

    }
}
