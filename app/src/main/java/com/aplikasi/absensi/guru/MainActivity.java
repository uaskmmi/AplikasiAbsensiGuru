package com.aplikasi.absensi.guru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aplikasi.absensi.guru.ViewpagerAdapter.ViewpagerLoginAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView tv_login, tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager   =   findViewById(R.id.viewpager);
        tv_login    =   findViewById(R.id.tv_login);
        tv_register =   findViewById(R.id.tv_register);

        viewPager.setAdapter(new ViewpagerLoginAdapter(getSupportFragmentManager(), MainActivity.this, 2));

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    tv_login.setTextColor(0xFFE91E63);
                    tv_register.setTextColor(0xFFFFFFFF);
                }
                if (position == 1){
                    tv_register.setTextColor(0xFFE91E63);
                    tv_login.setTextColor(0xFFFFFFFF);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}