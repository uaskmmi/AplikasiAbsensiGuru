package com.aplikasi.absensi.guru.FragmentLogin;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplikasi.absensi.guru.Interface.GuruInterface;
import com.aplikasi.absensi.guru.Model.GuruModel;
import com.aplikasi.absensi.guru.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RegisterFragment extends Fragment {

    private EditText ET_NIP, ET_NAMA, ET_PASSWORD;
    private Button btn_register;

    public RegisterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view   =   inflater.inflate(R.layout.fragment_register, container, false);

        ET_NIP          =   view.findViewById(R.id.ET_NIP);
        ET_NAMA         =   view.findViewById(R.id.ET_NAMA);
        ET_PASSWORD     =   view.findViewById(R.id.ET_PASSWORD);
        btn_register    =   view.findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.42.205/")//http://localhost/Absensi/guru/insertGuru.php
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GuruInterface guruInterface = retrofit.create(GuruInterface.class);
                Call<GuruModel> call = guruInterface.insertGuru(Integer.parseInt(ET_NIP.getText().toString()), ET_NAMA.getText().toString(), ET_PASSWORD.getText().toString());

                call.enqueue(new Callback<GuruModel>() {
                    @Override
                    public void onResponse(Call<GuruModel> call, Response<GuruModel> response) {
                        Toast.makeText(getContext(), response.toString(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<GuruModel> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        return view;
    }
}