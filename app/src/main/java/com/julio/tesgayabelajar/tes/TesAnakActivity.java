package com.julio.tesgayabelajar.tes;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.julio.tesgayabelajar.R;

public class TesAnakActivity extends AppCompatActivity {

    TextView iSoal, tvSoal;
    Button jaw1, jaw2, jaw3, bPrev, bNext;
    EditText edListener;
    String[] soal = {"Jika hendak menghadapi ulangan, maka anak Anda",
            "Jika mendengar musik atau lagu yang ia sukai, biasanya ia akan",
            "Jika menghadapi banyak tugas, maka anak Anda akan",
            "Apa bacaan favorit anak Anda",
            "Mainan elektronik kesayangannya rusak. Maka ia akan",
            "Jika mengajaknya kesebuah tempat permainan baru, maka ia akan",
            "Kegiatan ekstra kurikuler apa yang ia sukai?",
            "Apa reaksinya saat ia merasa bahagia?",
            "Jika Anda bertanya suasana kelas di hari pertama ia masuk sekolah, kira-kira apa yang akan ia jawab?",
            "Jika mendapat tugas untuk bercerita tentang pengalaman liburannya, maka ia akan",
            "Hal apakah yang paling dapat mengganggu konsentrasi anak Anda?"};
    String[] sJaw = {"Membaca catatan yang telah ia buat, membuka kembali text book serta memperhatikan diagram atau gambar yang berkaitan dengan materi yang diujikan",
            "Meminta Anda untuk memberinya pertanyaan tentang materi yang dipelajari",
            "Membuat ringkasan berupa diagram atau gambar (misalnya mind-mapping)",
            "Menghayati lagu yang ia dengar (seperti memejamkan mata, melamun dsb)",
            "Bergumam mengikuti lagu",
            "Bergoyang mengikuti irama lagu",
            "Membuat daftar tugas dan menentukan prioritas mana yang ia akan kerjakan terlebih dahulu",
            "Membicarakannya dengan Anda atau temannya apa yang sebaiknya ia lakukan",
            "Membuat daftar tugas dan kemudian menuliskan cara-cara ia akan menyelesaikan tugas-tugas tersebut",
            "Komik atau buku cerita dengan banyak gambar",
            "Buku-buku misteri dengan banyak percakapan di dalamnya",
            "Buku apa saja yang menarik hatinya. Terutama jika isi buku itu adalah jawaban dari pertanyaan-pertanyaan yang ia cari (misal buku tentang bagaimana memenangkan sebuah game online)",
            "Membaca buku petunjuk untuk memperbaiki",
            "Mendatangi teman-temannya (atau Anda) untuk meminta tolong memperbaiki bersama-sama",
            "Membongkarnya dan berusaha memperbaiki sendiri",
            "Melihat-lihat sekeliling terlebih dahulu, mengamati petunjuk permainan, dan barulah ia memilih salah satu permainan",
            "Bertanya kepada petugas penjaga dan memintanya memberi saran permainan mana yang paling asik untuk dimainkan pertama kali",
            "Langsung mencoba permainan yang dianggapnya paling menarik",
            "Menggambar, membuat prakarya, dsb",
            "Musik",
            "Olahraga",
            "Santai dan hanya tersenyum lebar",
            "Berteriak kegirangan",
            "Melompat-lompat senang",
            "Menggambarkan apa saja yang ada dikelas, berapa orang yang ada didalamnya, namun ia tak mampu menyebutkan nama meski seseorang baru yang duduk disebelahnya",
            "Ia dapat menggambarkan suasana dengan baik, namun ceritanya lebih terfokus kepada siapa saja teman barunya dan seperti apakah ia",
            "Hanya bercerita keadaan dan perasaan dirinya saja",
            "Menuliskannya dengan lengkap dan detil",
            "Menawar atau berkata \"Langsung cerita saja, ya, Bu.\"",
            "Fokus ceritanya lebih kepada apa yang ia lakukan selama liburan",
            "Gambar atau apa saja yang melintas di depannya",
            "Aneka suara",
            "Perasaan seperti lapar, haus, cemas dsb"};
    int noSoal = 1;
    int[] jaw = new int[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_anak);

        iSoal = findViewById(R.id.iSoalb);
        tvSoal = findViewById(R.id.soalb);
        jaw1 = findViewById(R.id.jaw1b);
        jaw2 = findViewById(R.id.jaw2b);
        jaw3 = findViewById(R.id.jaw3b);
        bPrev = findViewById(R.id.bPrevb);
        bNext = findViewById(R.id.bNextb);
        edListener = findViewById(R.id.edListenerb);
        edListener.setVisibility(View.GONE);
        edListener.setText(String.valueOf(noSoal));

        iSoal.setText("Soal " + noSoal);
        tvSoal.setText(soal[noSoal-1]);
        jaw1.setText(sJaw[0]);
        jaw2.setText(sJaw[1]);
        jaw3.setText(sJaw[2]);
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

                    if (noSoal == 11 && bNext.getText().equals("selanjutnya")) {
                        bNext.setText("selesai");
                    } else {
                        bNext.setText("selanjutnya");
                    }

                    iSoal.setText("Soal " + noSoal);
                    tvSoal.setText(soal[noSoal - 1]);
                    jaw1.setText(sJaw[(3*(noSoal-1)+1)-1]);
                    jaw2.setText(sJaw[(3*(noSoal-1)+2)-1]);
                    jaw3.setText(sJaw[(3*(noSoal-1)+3)-1]);
                }
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noSoal < 11) {
                    noSoal++;
                    edListener.setText(String.valueOf(noSoal));
                    //iSoal.setText("Soal " + noSoal);
                    //tvSoal.setText(soal[noSoal - 1]);
                } else if (noSoal == 11) {

                    Intent intent = new Intent(TesAnakActivity.this, HasilActivity.class);

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
