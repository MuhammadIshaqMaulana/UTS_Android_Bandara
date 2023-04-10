package com.example.uts_bandara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etKota, etAlamat;
    private Button btnTambah;
    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etKota = findViewById(R.id.et_kota);
        etAlamat = findViewById(R.id.et_alamat);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, kota, alamat;

                nama = etNama.getText().toString();
                kota = etKota.getText().toString();
                alamat = etAlamat.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Bandara Tidak boleh kosong");
                }
                else if(kota.trim().equals("")){
                    etKota.setError("Kota Bandara Tidak boleh kosong");
                }
                else if(alamat.trim().equals("")){
                    etAlamat.setError("Alamat Bandara Tidak boleh kosong");
                }
                else {
                    long eks = myDB.tambahDataBandara(nama, kota, alamat);
                    if(eks == -1){
                        Toast.makeText(TambahActivity.this, "Gagal Menambah Data Bandara", Toast.LENGTH_SHORT).show();
                                etNama.requestFocus();
                    }
                    else {
                        Toast.makeText(TambahActivity.this,
                                "Sukses Menambah Data Bandara", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}