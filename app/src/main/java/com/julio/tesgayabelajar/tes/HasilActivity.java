package com.julio.tesgayabelajar.tes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.julio.tesgayabelajar.R;
import com.julio.tesgayabelajar.gayabelajar.AudiotoriScrollingActivity;
import com.julio.tesgayabelajar.gayabelajar.KinestetikScrollingActivity;
import com.julio.tesgayabelajar.gayabelajar.VisualScrollingActivity;

public class HasilActivity extends AppCompatActivity {

    Intent intent, iShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        TextView tvHasil = findViewById(R.id.hasil),
                 tvTextHasil = findViewById(R.id.textHasil),
                 tvKetHasil = findViewById(R.id.ketHasil);
        Button bLanjut = findViewById(R.id.lanjut);
        ImageButton bShare = findViewById(R.id.bShare);
        ImageView ivHasil = findViewById(R.id.gambarHasil);

        String hasil = getIntent().getStringExtra("hasil");
        String sHasil = null;

        if (hasil.charAt(0) == '1') tvTextHasil.setText("Gaya Belajar Anda adalah");
        else if (hasil.charAt(0) == '2') tvTextHasil.setText("Gaya Belajar Anak Anda adalah");

        if (hasil.charAt(1) == '1') {
            tvHasil.setText("VISUAL");
            ivHasil.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_visual));
            tvKetHasil.setText("SEE IT");
            intent = new Intent(this, VisualScrollingActivity.class);
            sHasil = "Visual";
        } else if (hasil.charAt(1) == '2') {
            tvHasil.setText("AUDIOTORI");
            ivHasil.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_audiotori));
            tvKetHasil.setText("HEAR IT, SAY IT");
            intent = new Intent(this, AudiotoriScrollingActivity.class);
            sHasil = "Audiotori";
        } else if (hasil.charAt(1) == '3') {
            tvHasil.setText("KINESTETIK");
            ivHasil.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_kinestetik));
            tvKetHasil.setText("DO IT");
            intent = new Intent(this, KinestetikScrollingActivity.class);
            sHasil = "Kinestetik";
        }

        iShare = new Intent(android.content.Intent.ACTION_SEND);
        iShare.putExtra(Intent.EXTRA_TEXT, "Gaya belajar saya adalah " + sHasil);
        iShare.setType("text/plain");

        bLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iShare);
            }
        });
    }
}
