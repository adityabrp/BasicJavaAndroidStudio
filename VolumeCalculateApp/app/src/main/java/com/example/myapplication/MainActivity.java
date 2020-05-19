package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private EditText edtLebar;
private EditText edtTinggi;
private EditText edtPanjang;
private Button btnHitung;
private TextView tvHasil;
private static  final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLebar = findViewById(R.id.edt_lebar);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_hitung){
            String inputLebar = edtLebar.getText().toString().trim();
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if(TextUtils.isEmpty(inputPanjang)){
                isEmptyFields = true;
                edtPanjang.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputLebar)){
                isEmptyFields = true;
                edtLebar.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputTinggi)){
                isEmptyFields = true;
                edtTinggi.setError("Field ini tidak boleh kosong");
            }
            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang == null){
                isInvalidDouble = true;
                edtPanjang.setError("Field ini harus diisi angka");
            }
            if (lebar == null){
                isInvalidDouble = true;
                edtLebar.setError("Field ini harus diisi angka");
            }
            if (tinggi == null){
                isInvalidDouble = true;
                edtTinggi.setError("Field ini harus diisi angka");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double volume = panjang * lebar * tinggi;
                tvHasil.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
