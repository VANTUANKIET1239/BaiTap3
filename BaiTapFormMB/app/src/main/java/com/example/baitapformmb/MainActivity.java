package com.example.baitapformmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText editText_HoTen, editText_SDT;
    private Spinner spinner_TrinhDo;
    private Spinner spinner_GioiTinh;
    private SeekBar seekBar_Tuoi;
    private CheckBox checkBox_TheThao;
    private RadioButton radioButton_Rock, radioButton_Pop;
    private Button button_Cancel, button_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all UI components by their IDs
        editText_HoTen = findViewById(R.id.editText_HoTen);
        editText_SDT = findViewById(R.id.editText_SDT);
        spinner_GioiTinh = findViewById(R.id.spinner_GioiTinh);
        seekBar_Tuoi = findViewById(R.id.seekBar_Tuoi);
        spinner_TrinhDo = findViewById(R.id.spinner_TrinhDo);
        checkBox_TheThao = findViewById(R.id.checkBox_TheThao);
        radioButton_Rock = findViewById(R.id.radioButton_Rock);
        radioButton_Pop = findViewById(R.id.radioButton_Pop);
        button_Cancel = findViewById(R.id.button_Cancel);
        button_Register = findViewById(R.id.button_Register);


        // Set the OnClickListener for the "Register" button
        button_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get all the registered information from the UI components
                String hoTen = editText_HoTen.getText().toString();
                String sdt = editText_SDT.getText().toString();
                String gioiTinh = spinner_GioiTinh.getSelectedItem().toString();
                String trinhdo = spinner_TrinhDo.getSelectedItem().toString();
                int tuoi = seekBar_Tuoi.getProgress();
                boolean theThao = checkBox_TheThao.isChecked();
                String theLoaiAmNhac = radioButton_Rock.isChecked() ? "Rock" : "Pop";

                // Create an Intent to pass the registered information to the next activity
                Intent intent = new Intent(MainActivity.this, RegistrationDetailsActivity.class);
                intent.putExtra("HoTen", hoTen);
                intent.putExtra("SDT", sdt);
                intent.putExtra("TD", trinhdo);
                intent.putExtra("GioiTinh", gioiTinh);
                intent.putExtra("Tuoi", tuoi);
                intent.putExtra("TheThao", theThao);
                intent.putExtra("TheLoaiAmNhac", theLoaiAmNhac);

                // Start the next activity
                startActivity(intent);
            }
        });

        // Set the OnClickListener for the "Cancel" button
        button_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear all the UI components
                editText_HoTen.setText("");
                editText_SDT.setText("");
                spinner_GioiTinh.setSelection(0);
                spinner_TrinhDo.setSelection(0);
                seekBar_Tuoi.setProgress(0);
                checkBox_TheThao.setChecked(false);
                radioButton_Rock.setChecked(true);
            }
        });
    }
}