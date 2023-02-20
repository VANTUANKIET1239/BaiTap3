package com.example.baitapformmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegistrationDetailsActivity extends AppCompatActivity {
    private TextView textView_TrinhDo, textView_HoTen, textView_SDT, textView_GioiTinh, textView_Tuoi, textView_TheThao, textView_TheLoaiAmNhac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_details);

        textView_HoTen = findViewById(R.id.textView_HoTen);
        textView_SDT = findViewById(R.id.textView_SDT);
        textView_TrinhDo = findViewById(R.id.textView_TrinhDo);
        textView_GioiTinh = findViewById(R.id.textView_GioiTinh);
        textView_Tuoi = findViewById(R.id.textView_Tuoi);
        textView_TheThao = findViewById(R.id.textView_TheThao);
        textView_TheLoaiAmNhac = findViewById(R.id.textView_TheLoaiAmNhac);

        // Get the registered information from the Intent
        Intent intent = getIntent();
        String hoTen = intent.getStringExtra("HoTen");
        String sdt = intent.getStringExtra("SDT");
        String gioiTinh = intent.getStringExtra("GioiTinh");
        String trinhdo = intent.getStringExtra("TD");
        int tuoi = intent.getIntExtra("Tuoi", 0);
        boolean theThao = intent.getBooleanExtra("TheThao", false);
        String theLoaiAmNhac = intent.getStringExtra("TheLoaiAmNhac");

        // Set the text for each UI component to display the registered information
        textView_HoTen.setText("Họ và tên: " + hoTen);
        textView_SDT.setText("Số điện thoại: " + sdt);
        textView_GioiTinh.setText("Giới tính: " + gioiTinh);
        textView_GioiTinh.setText("Trình độ: " + trinhdo);
        textView_Tuoi.setText("Tuổi: " + tuoi);
        textView_TheThao.setText("Thể thao: " + (theThao ? "Có" : "Không"));
        textView_TheLoaiAmNhac.setText("Thể loại âm nhạc: " + theLoaiAmNhac);
    }
}