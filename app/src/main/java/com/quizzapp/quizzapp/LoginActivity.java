package com.quizzapp.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (databaseManager == null) {
            databaseManager = new DatabaseManager(this);
        }

        ImageView infoBtn = (ImageView) findViewById(R.id.infoBtn);

        final EditText perdoruesi = (EditText) findViewById(R.id.perdoruesi);
        final EditText password = (EditText) findViewById(R.id.password);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emri = perdoruesi.getText().toString();
                String pass = password.getText().toString();

                Perdorues perdorues = databaseManager.getPerdorues(emri,pass);

                if(perdorues == null){
                    Toast.makeText(getApplicationContext(),"Te dhena te pasakta !",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                    intent.putExtra("emri",emri);
                    intent.putExtra("password",pass);
                    startActivity(intent);
                }

            }
        });
    }
}
