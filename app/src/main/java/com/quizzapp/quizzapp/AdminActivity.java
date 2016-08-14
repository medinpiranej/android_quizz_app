package com.quizzapp.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminActivity extends Activity {

    String emriILoguar;

    DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        if (databaseManager == null) {
            databaseManager = new DatabaseManager(this);
        }

        emriILoguar = getIntent().getExtras().getString("emri");

        ImageView infoBtn = (ImageView) findViewById(R.id.infoBtn);
        Button shtoPyetjeBtn = (Button) findViewById(R.id.shtoPyetjeBtn);

        final EditText pyetja = (EditText) findViewById(R.id.pyetja);
        final EditText pergj1 = (EditText) findViewById(R.id.pergj1);
        final EditText pergj2 = (EditText) findViewById(R.id.pergj2);
        final EditText pergj3 = (EditText) findViewById(R.id.pergj3);
        final EditText pergj4 = (EditText) findViewById(R.id.pergj4);
        final EditText sakte = (EditText) findViewById(R.id.sakte);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        shtoPyetjeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pergjSakte = 0;
                try {
                    pergjSakte = Integer.parseInt(sakte.getText().toString());
                    if(pergjSakte > 4 || pergjSakte < 1){
                        throw new Exception("Pergjigje e pavlefshme");
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    pergjSakte = 0;
                }

                if(pergjSakte != 0) {
                    Pyetje pyetje = new Pyetje();

                    pyetje.setPyetja(pyetja.getText().toString());
                    pyetje.setPergjige1(pergj1.getText().toString());
                    pyetje.setPergjige2(pergj2.getText().toString());
                    pyetje.setPergjige3(pergj3.getText().toString());
                    pyetje.setPergjige4(pergj4.getText().toString());
                    pyetje.setPergjigjaEsakte(pergjSakte);

                    if(pyetje.getPyetja().length() == 0
                            || pyetje.getPergjige1().length() == 0
                            || pyetje.getPergjige2().length() == 0
                            || pyetje.getPergjige3().length() == 0
                            || pyetje.getPergjige4().length() == 0  ){
                        Toast.makeText(getApplicationContext(), "Kujdes ! duhet te plotesohen te gjitha fushat !", Toast.LENGTH_LONG).show();
                    }
                    else{
                        databaseManager.insert(pyetje);
                        Toast.makeText(getApplicationContext(), "Pyetja u shtua me sukses ...", Toast.LENGTH_LONG).show();
                        pyetja.setText("");
                        pergj1.setText("");
                        pergj2.setText("");
                        pergj3.setText("");
                        pergj4.setText("");
                        sakte.setText("");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "\"Pergjgja e sakte\" eshte e pavlefshme !", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
