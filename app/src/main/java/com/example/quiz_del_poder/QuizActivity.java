package com.example.quiz_del_poder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView question;
    private TextView numQuestion;
    private Context context = this;
    private ImageView imageQuestion;

    private Button choix1, choix2, choix3;
    private List<QuestionBuilder> listeQuestions;

    private QuestionListe qListe;

    private int questionActuelle = 0 ;

    private String choixSelectionnerParUtilisateur = "";

    private Animation Avrai;
    private Animation Afaux;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        numQuestion = findViewById(R.id.numQuestion);

        choix1 = (Button) findViewById(R.id.choix1);
        choix2 = (Button) findViewById(R.id.choix2);
        choix3 = (Button) findViewById(R.id.choix3);

        listeQuestions = QuestionListe.getQuestions();

        numQuestion.setText("Question " + (questionActuelle+1));
        //question.setText(listeQuestions.get(0).getQuestion());
        //imageQuestion.setImageResource(listeQuestions.get(0).getImage());
        choix1.setText(listeQuestions.get(0).getChoix1());
        choix2.setText(listeQuestions.get(0).getChoix2());
        choix3.setText(listeQuestions.get(0).getChoix3());

        QuestionAdapter adapter = new QuestionAdapter(this, qListe, 0);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);


        choix1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (choixSelectionnerParUtilisateur.isEmpty()){
                    choixSelectionnerParUtilisateur = choix1.getText().toString();

                    Afaux = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faux);
                    choix1.startAnimation(Afaux);

                    //ce lance apres 200 milisecondes
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //change la couleur de la mauvaise reponse et bonne reponse affichée
                            ChangeColor(choix1, "red");
                            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);

                        }
                    },200);

                    montrerRep();

                    listeQuestions.get(questionActuelle).setChoixUtilisateur(choixSelectionnerParUtilisateur);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Explication");

                builder.setMessage(listeQuestions.get(questionActuelle).getExplication());
                builder.setNeutralButton("Suivant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        passageProchaineQuestion();
                    }
                });
                builder.show();
            }
        });

        choix2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (choixSelectionnerParUtilisateur.isEmpty()){
                    choixSelectionnerParUtilisateur = choix2.getText().toString();

                    Afaux = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faux);
                    choix2.startAnimation(Afaux);
                    //ce lance apres 200 milisecondes
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //change la couleur de la mauvaise reponse et bonne reponse affichée
                            ChangeColor(choix2, "red");
                            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);

                        }
                    },200);

                    montrerRep();

                    listeQuestions.get(questionActuelle).setChoixUtilisateur(choixSelectionnerParUtilisateur);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Explication");

                builder.setMessage(listeQuestions.get(questionActuelle).getExplication());
                builder.setNeutralButton("Suivant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        passageProchaineQuestion();
                    }
                });
                builder.show();
            }
        });

        choix3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (choixSelectionnerParUtilisateur.isEmpty()){
                    choixSelectionnerParUtilisateur = choix3.getText().toString();

                    Afaux = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.faux);
                    choix3.startAnimation(Afaux);

                    //ce lance apres 200 milisecondes
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //change la couleur de la mauvaise reponse et bonne reponse affichée
                            ChangeColor(choix3, "red");
                            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);

                        }
                    },200);

                    montrerRep();

                    listeQuestions.get(questionActuelle).setChoixUtilisateur(choixSelectionnerParUtilisateur);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Explication");

                builder.setMessage(listeQuestions.get(questionActuelle).getExplication());
                builder.setNeutralButton("Suivant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        passageProchaineQuestion();
                    }
                });
                builder.show();

            }
        });
    }
    private int getMauvaiseRep() {
        int estMauvaiseRep = 0 ;

        for (int i=0 ; i<listeQuestions.size() ; i++) {
            final String getChoixUtilisateur = listeQuestions.get(i).getChoixUtilisateur();
            final String getReponse = listeQuestions.get(i).getReponse();

            if (!getChoixUtilisateur.equals(getReponse)) {
                estMauvaiseRep ++ ;
            }
        }
        return estMauvaiseRep ;
    }

    private int getBonneRep() {
        int estRep = 0 ;

        for (int i=0 ; i<listeQuestions.size() ; i++) {
            final String getChoixUtilisateur = listeQuestions.get(i).getChoixUtilisateur();
            final String getReponse = listeQuestions.get(i).getReponse();

            if (getChoixUtilisateur.equals(getReponse)) {
                estRep ++ ;
            }
        }
        return estRep ;
    }


    private void montrerRep() {
        final String getReponse = listeQuestions.get(questionActuelle).getReponse();

        if (choix1.getText().toString().equals(getReponse)){
            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);
            choix1.startAnimation(Avrai);
            //ce lance apres 200 milisecondes
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ChangeColor(choix1, "green");
                }
            },200);
        }
        else if (choix2.getText().toString().equals(getReponse)){
            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);
            choix2.startAnimation(Avrai);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ChangeColor(choix2, "green");
                }
            },200);
        }
        else if (choix3.getText().toString().equals(getReponse)){
            Avrai = AnimationUtils.loadAnimation(QuizActivity.this, R.anim.vrai);
            choix3.startAnimation(Avrai);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ChangeColor(choix3, "green");
                }
            },200);
        }
    }

    public void ChangeColor(Button bt, String to){
        if(to== "red") {
            //change couleur du bouton avec color dans colors.xml
            bt.setBackgroundColor(getResources().getColor(R.color.red));
            //change couleur du texte
            bt.setTextColor(getResources().getColor(R.color.black));

        } else if(to== "green"){
            bt.setBackgroundColor(getResources().getColor(R.color.green));
            bt.setTextColor(getResources().getColor(R.color.black));

        }
    }

    private void passageProchaineQuestion() {
        questionActuelle++;
        if ((questionActuelle+1) == listeQuestions.size()) {

        }
        if (questionActuelle < listeQuestions.size()) {
            choixSelectionnerParUtilisateur = "";

            choix1.setBackgroundColor(getResources().getColor(R.color.base));
            choix1.setTextColor(Color.parseColor("#FFFFFF"));

            choix2.setBackgroundColor(getResources().getColor(R.color.base));
            choix2.setTextColor(Color.parseColor("#FFFFFF"));

            choix3.setBackgroundColor(getResources().getColor(R.color.base));
            choix3.setTextColor(Color.parseColor("#FFFFFF"));

            numQuestion.setText("Question " + (questionActuelle+1));
            choix1.setText(listeQuestions.get(questionActuelle).getChoix1());
            choix2.setText(listeQuestions.get(questionActuelle).getChoix2());
            choix3.setText(listeQuestions.get(questionActuelle).getChoix3());
            QuestionAdapter adapter = new QuestionAdapter(this, qListe, questionActuelle);
            ListView list = (ListView)findViewById(R.id.listView);
            list.setAdapter(adapter);

        }
        else{
            Intent intent = new Intent(QuizActivity.this, ResultatActivity.class);
            intent.putExtra("Reponse correcte", getBonneRep());
            intent.putExtra("Reponse incorrecte", getMauvaiseRep());
            startActivity(intent);

            finish();
        }
    }
}
