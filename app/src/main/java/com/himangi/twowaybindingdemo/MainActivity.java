package com.himangi.twowaybindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.himangi.twowaybindingdemo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        final Data data=new Data(this);
        data.photoLocalURL.set(getResources().getDrawable(R.drawable.baby1));
        binding.setState(data);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.fieldsEnabled.set(true);
            }
        },5000);
    }
}
