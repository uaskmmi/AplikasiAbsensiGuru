package com.aplikasi.absensi.guru.ViewpagerAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.aplikasi.absensi.guru.FragmentLogin.LoginFragment;
import com.aplikasi.absensi.guru.FragmentLogin.RegisterFragment;

public class ViewpagerLoginAdapter extends FragmentStatePagerAdapter {

    Context context;
    int itemCount;

    public ViewpagerLoginAdapter(@NonNull FragmentManager fm, Context context, int itemCount) {
        super(fm);
        this.context = context;
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new LoginFragment();
        }
        if (position == 1){
            return new RegisterFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return itemCount;
    }
}
