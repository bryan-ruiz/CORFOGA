package com.example.bryan.corfoga.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bryan.corfoga.Class.Animal;
import com.example.bryan.corfoga.Class.Farm;
import com.example.bryan.corfoga.Class.Global;
import com.example.bryan.corfoga.Class.Inspection;
import com.example.bryan.corfoga.Class.Region;
import com.example.bryan.corfoga.Class.User;
import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.InternetConection.Conection;
import com.example.bryan.corfoga.InternetConection.Ip;
import com.example.bryan.corfoga.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegionActivity extends AppCompatActivity {
    private Button todas, pacificoCentral, central, huetarAtlantica, brunca, huetarNorte, chorotega;
    private Intent intent;
    private ArrayList<Farm> farmsList;
    private Global global;
    private Boolean isDatabaseEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regions);
        global = Global.getInstance();
        farmsList = global.getFarmsList();
        isDatabaseEmpty = false;
        todas = findViewById(R.id.todas);
        pacificoCentral = findViewById(R.id.pacificoCentral);
        central = findViewById(R.id.central);
        huetarAtlantica = findViewById(R.id.huetarAtlantica);
        brunca = findViewById(R.id.brunca);
        huetarNorte = findViewById(R.id.huetarNorte);
        chorotega = findViewById(R.id.chorotega);
        intent = new Intent(getBaseContext(), FarmActivity.class);
        createRegions();
        setInformationToBegin();
        if (isDatabaseEmpty) {
            checkButtonsState();
        }

        todas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(0);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "all");
                    startActivity(intent);
                }

            }
        });
        pacificoCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(3);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "pacificoCentral");
                    startActivity(intent);
                }

            }
        });
        central.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(1);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "central");
                    startActivity(intent);
                }

            }
        });
        huetarAtlantica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(5);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "huetarAtlantica");
                    startActivity(intent);
                }
            }
        });
        brunca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(4);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "brunca");
                    startActivity(intent);
                }
            }
        });
        huetarNorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(6);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "huetarNorte");
                    startActivity(intent);
                }
            }
        });
        chorotega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataBase(2);
                if (Global.getInstance().getFarmsList().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"¡No hay fincas disponibles!",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("selectedRegion", "chorotega");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.importar:
                DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext());
                dataBaseHelper.deleteDB(getApplicationContext());
                importInformationFromWebServer();
                changeButtonsState(true);
                Toast.makeText(getApplicationContext(),"¡Aplicación sincronizada correctamente!",Toast.LENGTH_LONG).show();
                return true;
            case R.id.exportar:
                Toast.makeText(getApplicationContext(),"¡EXPORTAR!",Toast.LENGTH_LONG).show();
                Retrofit query = new Retrofit.Builder()
                        .baseUrl(Ip.getIpAddress())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Conection conection = query.create(Conection.class);
                for (Inspection inspection: Global.getInstance().getExportListOfInspections(getApplication())) {
                    Call<String> result;
                    result = conection.addInspection(inspection);
                    result.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(getApplicationContext(), response.body(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    private void setInformationToBegin() {
        try {

            for (Region region : Global.getInstance().getRegionsList()) {
                if (!region.getFarmListDB(getApplicationContext()).isEmpty()) {
                    isDatabaseEmpty = false;
                }
            }
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"¡Base de datos vacía!",Toast.LENGTH_LONG).show();
            isDatabaseEmpty = true;
        }
    }

    private void createRegions() {
        Global.getInstance().resetRegionList();
        String[] regionsName = {
                "Pacífico Central",
                "Central",
                "Huetar Atlántica",
                "Brunca",
                "Huetar Norte",
                "Chorotega"
        };
        int position = 1;
        while (position <= regionsName.length) {
            Region region = new Region(position, regionsName[position-1]);
            Global.getInstance().addRegion(region);
            position ++;
        }
    }

    private void importInformationFromWebServer() {
        Retrofit query = new Retrofit.Builder()
                .baseUrl(Ip.getIpAddress())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Conection conection = query.create(Conection.class);
        Call<List<Farm>> result;
        for (final Region region: Global.getInstance().getRegionsList()) {
            result = conection.getFarmsFromRegion(region.getId());
            result.enqueue(new Callback<List<Farm>>() {
                @Override
                public void onResponse(Call<List<Farm>> call, Response<List<Farm>> response) {
                    if (!response.body().isEmpty()) {
                        for (final Farm farm: response.body()) {
                            region.addFarmDB(getApplicationContext(), farm);
                            getAnimalsFromFarm(farm);

                        }
                    }

                }

                @Override
                public void onFailure(Call<List<Farm>> call, Throwable t) {

                }
            });
        }
    }

    private void getAnimalsFromFarm(final Farm farm) {
        Retrofit query = new Retrofit.Builder()
                .baseUrl(Ip.getIpAddress())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Conection conection = query.create(Conection.class);
        Call<List<Animal>> result;
        result = conection.getAnimalsFromFarm(farm.getAsocebuID());
        result.enqueue(new Callback<List<Animal>>() {
            @Override
            public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {
                if (!response.body().isEmpty()) {
                    for (final Animal animal: response.body()) {
                        farm.addAnimalDB(getApplicationContext(), animal);
                        getInspectionsFromAnimal(animal);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Animal>> call, Throwable t) {

            }
        });
    }
    private void getInspectionsFromAnimal(final Animal animal) {
        Retrofit query = new Retrofit.Builder()
                .baseUrl(Ip.getIpAddress())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Conection conection = query.create(Conection.class);
        Call<List<Inspection>> result;
        result = conection.getInspectionsFromAnimal("2018", animal.getId());
        result.enqueue(new Callback<List<Inspection>>() {
            @Override
            public void onResponse(Call<List<Inspection>> call, Response<List<Inspection>> response) {
                if (!response.body().isEmpty()) {
                    for (final Inspection inspection: response.body()) {
                        animal.addInspectionDB(getApplicationContext(), inspection);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Inspection>> call, Throwable t) {

            }
        });
    }
    private void checkDataBase(int id) {
        Log.d("checkdb", "DBDBDBDBDBDB--------|11111111111111111111111111111111");
        if (id == 0) {
            Global.getInstance().getAllFarms(getApplication());
        }
        else {
            for (Region region : Global.getInstance().getRegionsList()) {
                if (region.getId() == id) {
                    Global.getInstance().setFarmsList(region.getFarmListDB(getApplicationContext()));
                }
            }
        }

    }

    private void checkButtonsState() {
        boolean state = false;
        if (checkFarmListNotNull()) {
            state = true;
            changeButtonsState(state);
        }
        else {
            Toast.makeText(getApplicationContext(),"Nota: asegurese de tener siempre la aplicación sincronizada.",Toast.LENGTH_LONG).show();
        }
        changeButtonsState(state);
    }

    private Boolean checkFarmListNotNull() {
        if (farmsList.isEmpty()) {
            return false;
        }
        return true;
    }

    private void changeButtonsState(boolean state) {
        todas.setEnabled(state);
        pacificoCentral.setEnabled(state);
        central.setEnabled(state);
        huetarAtlantica.setEnabled(state);
        brunca.setEnabled(state);
        huetarNorte.setEnabled(state);
        chorotega.setEnabled(state);
    }
}
