package com.guardz.cleanvision.presentation.view;

import android.view.ViewStub;

import com.guardz.cleanvision.R;
import com.guardz.cleanvision.presentation.BaseComponent;
import com.guardz.cleanvision.presentation.Contracts;
import com.guardz.cleanvision.presentation.IComponentGroup;

/**
 * Created by yxwang on 2018/4/13.
 */

public class Component2 extends BaseComponent implements Contracts.Component2View{
    public Component2(ViewStub stub,IComponentGroup group) {
        super(stub,group);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.component_2;
    }
}
