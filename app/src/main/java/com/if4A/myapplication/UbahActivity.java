package com.if4A.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UbahActivity extends AppCompatActivity {
    private EditText etnama, etnomor, etklub;
    private Button btnUbah;
    MyDataBaseHelper myDB= new MyDataBaseHelper(UbahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        etnama = findViewById(R.id.et_nama);
        etnomor = findViewById(R.id.et_nomor);
        etklub = findViewById(R.id.et_klub);
        btnUbah = findViewById(R.id.btn_ubah);

        Intent varIntent = getIntent();
        String id = varIntent.getStringExtra("varId");
        String nama = varIntent.getStringExtra("varNama");
        String nomor = varIntent.getStringExtra("varNomor");
        String klub = varIntent.getStringExtra("varKlub");

        etnama.setText(nama);
        etnomor.setText(nomor);
        etklub.setText(klub);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama, getNomor, getKlub;

                getNama = etnama.getText().toString();
                getNomor = etnomor.getText().toString();
                getKlub = etklub.getText().toString();

                if(getNama.trim().equals("")){
                    etnama.setError("Nama Player tidak boleh kosong");
                }
                else if (getNomor.trim().equals("")){
                    etnomor.setError("Nomor Punggung Tidak Boleh Kosong");
                }
                else if(getKlub.trim().equals("")){
                    etklub.setError("Klub Tidak Boleh Kosong");
                }
                else{
                    long eks = myDB.ubahPlayer(id, getNama, getNomor, getKlub);
                    if(eks == -1){
                        Toast.makeText(UbahActivity.this, "Gagal Mengubah Data", Toast.LENGTH_SHORT).show();
                        etnama.requestFocus();
                    }
                    else{
                        Toast.makeText(UbahActivity.this, "Berhasil Mengubah Data", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            }
        });

    }
}