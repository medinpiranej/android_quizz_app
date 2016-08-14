package com.quizzapp.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class QuizzActivity extends Activity {

    int PiketEFituara = 0;
    DatabaseManager databaseManager;
    Pyetje pyetjaEZgjedhur;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(this);
        }

        ImageView infoBtn = (ImageView) findViewById(R.id.infoBtn);
        Button konfirmoBtn = (Button) findViewById(R.id.konfirmoBtn);

        final TextView piket = (TextView) findViewById(R.id.piket);
        
        final TextView pyetja = (TextView) findViewById(R.id.pyetja);
        
        final RadioButton pergj1 = (RadioButton) findViewById(R.id.pergj1);
        final RadioButton pergj2 = (RadioButton) findViewById(R.id.pergj2);
        final RadioButton pergj3 = (RadioButton) findViewById(R.id.pergj3);
        final RadioButton pergj4 = (RadioButton) findViewById(R.id.pergj4);
        final RadioGroup sakte = (RadioGroup) findViewById(R.id.sakte);


        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });

        final List <Pyetje> pyetjet = databaseManager.getPyetje();
        
        if(pyetjet != null){
            if(pyetjet.size() > 0){
                konfirmoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pyetjaEZgjedhur.getPergjigjaEsakte()){
                            case 1:
                                if(pergj1.isChecked()){
                                    PiketEFituara = PiketEFituara + 10;
                                    piket.setText("Piket : " + PiketEFituara);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Pergjige e pasakte !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case 2:
                                if(pergj2.isChecked()){
                                    PiketEFituara = PiketEFituara + 10;
                                    piket.setText("Piket : " + PiketEFituara);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Pergjige e pasakte !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case 3:
                                if(pergj3.isChecked()){
                                    PiketEFituara = PiketEFituara + 10;
                                    piket.setText("Piket : " + PiketEFituara);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Pergjige e pasakte !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case 4:
                                if(pergj4.isChecked()){
                                    PiketEFituara = PiketEFituara + 10;
                                    piket.setText("Piket : " + PiketEFituara);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Pergjige e pasakte !", Toast.LENGTH_LONG).show();
                                }
                                break;
                        }
                        
                        Random random = new Random();
                        int rand = random.nextInt(pyetjet.size());

                        if(rand < pyetjet.size() && rand >= 0){
                            pyetjaEZgjedhur = pyetjet.get(rand);

                            pyetja.setText(pyetjaEZgjedhur.getPyetja());
                            pergj1.setText(pyetjaEZgjedhur.getPergjige1());
                            pergj2.setText(pyetjaEZgjedhur.getPergjige2());
                            pergj3.setText(pyetjaEZgjedhur.getPergjige3());
                            pergj4.setText(pyetjaEZgjedhur.getPergjige4());

                            pergj1.setSelected(false);
                            pergj2.setSelected(false);
                            pergj3.setSelected(false);
                            pergj4.setSelected(false);

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Ndodhi nje gabim ne perzgjedhjen e nje pyetje random ... rand : " + rand, Toast.LENGTH_LONG).show();
                        }
                    }
                });

                Random random = new Random();
                int rand = random.nextInt(pyetjet.size());
                
                if(rand < pyetjet.size() && rand >= 0){
                    pyetjaEZgjedhur = pyetjet.get(rand);

                    pyetja.setText(pyetjaEZgjedhur.getPyetja());
                    pergj1.setText(pyetjaEZgjedhur.getPergjige1());
                    pergj2.setText(pyetjaEZgjedhur.getPergjige2());
                    pergj3.setText(pyetjaEZgjedhur.getPergjige3());
                    pergj4.setText(pyetjaEZgjedhur.getPergjige4());

                    pergj1.setSelected(false);
                    pergj2.setSelected(false);
                    pergj3.setSelected(false);
                    pergj4.setSelected(false);
                }
                else{   
                    Toast.makeText(getApplicationContext(), "Ndodhi nje gabim ne perzgjedhjen e nje pyetje random ... rand : " + rand, Toast.LENGTH_LONG).show();
                }
            }
            else{ 
                Toast.makeText(getApplicationContext(), "Nuk ka pyetje te rregjistruara ... Shto nje pyetje ne fillim", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Nuk ka pyetje te rregjistruara ... Shto nje pyetje ne fillim", Toast.LENGTH_LONG).show();
        }
        
    }
}
