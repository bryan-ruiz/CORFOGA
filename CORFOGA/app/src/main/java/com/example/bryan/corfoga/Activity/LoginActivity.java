package com.example.bryan.corfoga.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import com.example.bryan.corfoga.Class.User;
import com.example.bryan.corfoga.Database.DataBaseHelper;
import com.example.bryan.corfoga.InternetConection.Conection;
import com.example.bryan.corfoga.R;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    private Cursor fila;
    private String BASEURL ="https://mobilerest.herokuapp.com";
    LinearLayout progressBar;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegionActivity.class);
                startActivity(intent);
            }
        });
    }*/
    /*public boolean isOnline() {
        ConnectivityManager cm =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (LinearLayout) findViewById(R.id.progressBarLayout);

        final Button ingresar = (Button) findViewById(R.id.login);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ingresar.setEnabled(false);

                    final String usuario = ((EditText) findViewById(R.id.nombreUsuario)).getText().toString();
                    final String contraseña = ((EditText) findViewById(R.id.contraseña)).getText().toString();
                    /*if (isOnline()) {
                        progressBar.setVisibility(View.VISIBLE);
                        Retrofit query = new Retrofit.Builder()
                                .baseUrl(BASEURL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        Conection service = query.create(Conection.class);

                        Call<User> result = service.userName(usuario, contraseña);

                        result.enqueue(new Callback<List<User>>() {
                            @Override
                            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                                try {

                                    if (response.body().size() == 0) {
                                        Toast.makeText(getApplicationContext(), "Datos incorrectos",Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        //Toast.makeText(getApplicationContext(), response.body().get(0).getName(),Toast.LENGTH_LONG).show();
                                        DataBaseHelper admin = new DataBaseHelper(LoginActivity.this);
                                        SQLiteDatabase db=admin.getWritableDatabase();
                                        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contraseña+"'",null);
                                        if(fila.moveToFirst()!=true) {
                                            //admin.insertarUsuario(usuario,contraseña,response.body().get(0).getRemember_token());
                                        }
                                        finish();
                                        ((EditText) findViewById(R.id.nombreUsuario)).setText("");
                                        ((EditText) findViewById(R.id.contraseña)).setText("");
                                        Intent ven = new Intent(LoginActivity.this, RegionActivity.class);
                                        startActivity(ven);
                                    }
                                    ingresar.setEnabled(true);
                                    progressBar.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onFailure(Call<List<User>> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error al generar las consultas",Toast.LENGTH_LONG).show();
                                ingresar.setEnabled(true);
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                    } else {
                        //Conexión con DB
                        DataBaseHelper admin=new DataBaseHelper(LoginActivity.this);
                        SQLiteDatabase db=admin.getWritableDatabase();
                        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contraseña+"'",null);
                        //si la consulta devolvio algo
                        Toast.makeText(getApplicationContext(), fila.toString(),Toast.LENGTH_LONG).show();

                        if(fila.moveToFirst()==true) {
                            //datos ingresados son iguales
                            ((EditText) findViewById(R.id.nombreUsuario)).setText("");
                            ((EditText) findViewById(R.id.contraseña)).setText("");
                            Intent ven = new Intent(LoginActivity.this, RegionActivity.class);
                            startActivity(ven);
                        }else{
                            //limpiamos los EditText
                            Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
                        }
                    }*/
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"No se puede acceder al sistema",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}