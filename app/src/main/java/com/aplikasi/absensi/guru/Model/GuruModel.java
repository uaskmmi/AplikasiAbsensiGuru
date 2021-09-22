package com.aplikasi.absensi.guru.Model;

public class GuruModel {

    private int NIP;
    private String namaGuru;
    private String passwordGuru;

    public GuruModel(int NIP, String namaGuru, String passwordGuru) {
        this.NIP = NIP;
        this.namaGuru = namaGuru;
        this.passwordGuru = passwordGuru;
    }
}
