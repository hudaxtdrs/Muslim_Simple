package muslim_simpleby.huda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CardView jadwalsolat;
    private CardView proodukhalal;
    private CardView alquran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jadwalsolat = (CardView) findViewById(R.id.jadwal_sholat);
        jadwalsolat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iJadwalsolat = new Intent(MainActivity.this, jadwalsholatActivity.class);
                startActivity(iJadwalsolat);
            }
        });
        proodukhalal = (CardView) findViewById(R.id.produk_halal);
        proodukhalal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iProdukhalal = new Intent(MainActivity.this, produkhalal.class);
                startActivity(iProdukhalal);
            }
        });
        alquran = (CardView) findViewById(R.id.qurann);
        alquran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AyatAlquran.class);
                startActivity(i);
            }
        });

    }
}
