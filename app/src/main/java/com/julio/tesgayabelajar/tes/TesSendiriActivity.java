package com.julio.tesgayabelajar.tes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.julio.tesgayabelajar.R;

public class TesSendiriActivity extends AppCompatActivity {

    TextView iSoal, tvSoal;
    Button jaw1, jaw2, jaw3, bPrev, bNext;
    EditText edListener;
    String[] soal = {"Kamu lebih gampang mengingat sesuatu kalau kamu menuliskannya",
                     "Bagian kosong buku catatan suka kamu gambari atau tulisi saat guru menerangkan",
                     "Kamu tidak bisa belajar kalau ada keributan atau musik terdengar olehmu",
                     "Kamu lebih senang jika sesuatu berwarna",
                     "Sewaktu ulangan, kamu membayangkan buku catatan kamu dalam pikiran",
                     "Catatan-catatan kamu berantakan sekali, tidak teratur",
                     "Kamu tidak begitu mahir mengartikan bahasa tubuh seseorang",
                     "Lebih baik kamu disuruh mendengarkan guru menerangkan daripada disuruh membaca buku sendiri",
                     "Kamu sangat mudah mengingat sesuatu yang dikatakan oleh orang",
                     "Kamu paling tidak suka jika mendapat tugas menulis essay atau laporan, lebih baik ditanya secara lisan",
                     "Kamu senang berolah raga dan cukup mahir pada beberapa cabang olah raga",
                     "Agar kamu dapat mengerti pelajaran, kamu suka menulis ulang atau mengetik catatan pelajaran kamu",
                     "Waktu yang kamu butuhkan untuk mengerjakan tugas cukup lama, karena kamu harus berjalan ke sana kemari, beristirahat sebentar, atau mengerjakan hal lain, untuk mendapatkan ide lebih lanjut",
                     "Biasanya kamu langsung mengerjakan sesuatu tanpa harus melihat instruksinya terlebih dahulu",
                     "Kamu melihat sesuatu yang sudah jadi, kemudian kamu suka membuatnya sendiri",};
    int noSoal = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_sendiri);

        iSoal = findViewById(R.id.iSoal);
        tvSoal = findViewById(R.id.soal);
        jaw1 = findViewById(R.id.jaw1);
        jaw2 = findViewById(R.id.jaw2);
        jaw3 = findViewById(R.id.jaw3);
        bPrev = findViewById(R.id.bPrev);
        bNext = findViewById(R.id.bNext);
        edListener = findViewById(R.id.edListener);
        edListener.setVisibility(View.GONE);
        edListener.setText(String.valueOf(noSoal));

        iSoal.setText("Soal " + noSoal);
        tvSoal.setText(soal[noSoal-1]);

        edListener.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                iSoal.setText("Soal " + noSoal);
                tvSoal.setText(soal[noSoal-1]);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noSoal < 15) {
                    noSoal++;
                    edListener.setText(String.valueOf(noSoal));
                    //iSoal.setText("Soal " + noSoal);
                    //tvSoal.setText(soal[noSoal - 1]);
                }
            }
        });

        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noSoal > 1) {
                    noSoal--;
                    edListener.setText(String.valueOf(noSoal));
                    //iSoal.setText("Soal " + noSoal);
                    //tvSoal.setText(soal[noSoal - 1]);
                }
            }
        });
    }
}
