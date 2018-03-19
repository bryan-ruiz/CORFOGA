package com.example.bryan.corfoga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegionsActivity extends AppCompatActivity {
    private Button todas, pacificoCentral, central, huetarAtlantica, brunca, huetarNorte, chorotega;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regions);
        todas = findViewById(R.id.todas);
        pacificoCentral = findViewById(R.id.pacificoCentral);
        central = findViewById(R.id.central);
        huetarAtlantica = findViewById(R.id.huetarAtlantica);
        brunca = findViewById(R.id.brunca);
        huetarNorte = findViewById(R.id.huetarNorte);
        chorotega = findViewById(R.id.chorotega);
        intent = new Intent(getBaseContext(), FarmActivity.class);

        todas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "all");
                startActivity(intent);
            }
        });
        pacificoCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "pacificoCentral");
                startActivity(intent);
            }
        });
        central.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "central");
                startActivity(intent);
            }
        });
        huetarAtlantica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "huetarAtlantica");
                startActivity(intent);
            }
        });
        brunca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "brunca");
                startActivity(intent);
            }
        });
        huetarNorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "huetarNorte");
                startActivity(intent);
            }
        });
        chorotega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("selectedRegion", "chorotega");
                startActivity(intent);
            }
        });
    }
}
