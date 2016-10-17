package com.himangi.twowaybindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.himangi.twowaybindingdemo.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        final Data data=new Data(this);
        data.photo1LocalURL.set(getResources().getDrawable(R.drawable.baby1));
        data.photo2LocalURL.set(
                "https://www.simplifiedcoding.net/wp-content/uploads/2015/10/advertise.png");
        binding.setState(data);

        Picasso.with(this).load("http://images.all-free-download" +
                ".com/images/graphiclarge/baby_elf_201045.jpg").into(binding.img2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.fieldsEnabled.set(true);
            }
        },5000);
    }
}
