package com.example.quiz_del_poder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ResultatActivity extends AppCompatActivity {
    static int getBonneRep;
    static int getMauvaiseRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat_layout);

        final AppCompatButton Partager=findViewById(R.id.partagerRes);

        final AppCompatButton recommencerQuiz = findViewById(R.id.recommencerQuiz) ;
        final AppCompatButton retourAcceuilQuiz = findViewById(R.id.retourAcceuilQuiz) ;
        final TextView bilanBonneReponse = findViewById(R.id.bilanBonneReponse);
        final TextView bilanMauvaiseReponse = findViewById(R.id.bilanMauvaiseReponse);

        getBonneRep = getIntent().getIntExtra("Reponse correcte", 0) ;
        getMauvaiseRep = getIntent().getIntExtra("Reponse incorrecte", 0) ;


        bilanBonneReponse.setText((String.valueOf(getBonneRep)) + (" bonne réponse"));
        bilanMauvaiseReponse.setText((String.valueOf(getMauvaiseRep)) + (" mauvaise réponse."));

        recommencerQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultatActivity.this, QuizActivity.class));
                finish();
            }
        });

        retourAcceuilQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultatActivity.this, MainActivity.class));
                finish();
            }
        });
        Partager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultatActivity.this, PartageActivity.class));
            }
        });
    }
}