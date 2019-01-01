package com.julio.tesgayabelajar.tes;

import android.content.Intent;
import android.os.Build;
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
                     "Kamu melihat sesuatu yang sudah jadi, kemudian kamu suka membuatnya sendiri"};
    int noSoal = 1;
    int[] jaw = new int[15];

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
        bPrev.setVisibility(View.INVISIBLE);
        bNext.setText("selanjutnya");

        edListener.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (1 <= noSoal && noSoal <= 15) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        jaw1.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                        jaw2.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                        jaw3.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                        jaw1.setTextColor(getResources().getColor(R.color.colorAccent));
                        jaw2.setTextColor(getResources().getColor(R.color.colorAccent));
                        jaw3.setTextColor(getResources().getColor(R.color.colorAccent));

                        if (jaw[noSoal-1] == 1) {
                            jaw1.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                            jaw1.setTextColor(getResources().getColor(R.color.colorPutih));
                        } else if (jaw[noSoal-1] == 2) {
                            jaw2.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                            jaw2.setTextColor(getResources().getColor(R.color.colorPutih));
                        } else if (jaw[noSoal-1] == 3) {
                            jaw3.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                            jaw3.setTextColor(getResources().getColor(R.color.colorPutih));
                        }
                    }

                    if (noSoal == 1 && bPrev.getVisibility() == View.VISIBLE){
                        bPrev.setVisibility(View.INVISIBLE);
                    } else {
                        bPrev.setVisibility(View.VISIBLE);
                    }

                    if (noSoal == 15 && bNext.getText().equals("selanjutnya")) {
                        bNext.setText("selesai");
                    } else {
                        bNext.setText("selanjutnya");
                    }

                    iSoal.setText("Soal " + noSoal);
                    tvSoal.setText(soal[noSoal - 1]);
                }
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
                } else if (noSoal == 15) {
                    int vi = 0, au = 0, ki = 0;
                    for (int i = 0; i < 15; i++) {
                        if (i < 5) vi += jaw[i];
                        else if (i < 10) au += jaw[i];
                        else ki += jaw[i];
                    }

                    Intent intent = new Intent(TesSendiriActivity.this, HasilActivity.class);
                    if (vi > au && vi > ki) intent.putExtra("hasil", "11");
                    else if (au > vi && au > ki) intent.putExtra("hasil", "12");
                    else if (ki > vi && ki > au) intent.putExtra("hasil", "13");
                    else if (vi == au && vi != ki) intent.putExtra("hasil", "11");
                    else if (au == ki && au != vi) intent.putExtra("hasil", "12");
                    else if (ki == vi && ki != au) intent.putExtra("hasil", "13");
                    else if (vi == au && vi == ki) intent.putExtra("hasil", "11");
                    startActivity(intent);
                    finish();
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

        jaw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    jaw1.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                    jaw2.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw3.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw1.setTextColor(getResources().getColor(R.color.colorPutih));
                    jaw2.setTextColor(getResources().getColor(R.color.colorAccent));
                    jaw3.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                jaw[noSoal-1] = 1;
            }
        });

        jaw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    jaw1.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw2.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                    jaw3.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw1.setTextColor(getResources().getColor(R.color.colorAccent));
                    jaw2.setTextColor(getResources().getColor(R.color.colorPutih));
                    jaw3.setTextColor(getResources().getColor(R.color.colorAccent));
                }
                jaw[noSoal-1] = 2;
            }
        });

        jaw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    jaw1.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw2.setBackgroundTintList(getResources().getColorStateList(R.color.colortransparent));
                    jaw3.setBackgroundTintList(getResources().getColorStateList(R.color.colorjaw));
                    jaw1.setTextColor(getResources().getColor(R.color.colorAccent));
                    jaw2.setTextColor(getResources().getColor(R.color.colorAccent));
                    jaw3.setTextColor(getResources().getColor(R.color.colorPutih));
                }
                jaw[noSoal-1] = 3;
            }
        });
    }
}
