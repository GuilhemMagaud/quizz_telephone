package com.example.quiz_del_poder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends BaseAdapter {
    private QuestionListe Qliste;
    private Context context;
    private LayoutInflater lInflater;
    private int questionActuelle;
    private List<QuestionBuilder> listeQuestions = QuestionListe.getQuestions();

    public QuestionAdapter(Context context, QuestionListe Qliste, int questionActuelle){
        this.context = context;
        this.Qliste = Qliste;
        this.lInflater = LayoutInflater.from(context);
        this.questionActuelle = questionActuelle;
    }

    @Override
    public int getCount() {return 1;}

    @Override
    public Object getItem(int i) {return Qliste.getQuestions();}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if (convertView == null) {
            layoutItem = (LinearLayout) lInflater.inflate(R.layout.question_layout,parent, false);
        }
        else {
            layoutItem = (LinearLayout) convertView;
        }
        ImageView img_quizz = (ImageView)layoutItem.findViewById(R.id.imageView);
        TextView question_txt = (TextView)layoutItem.findViewById(R.id.question);
        img_quizz.setImageResource(listeQuestions.get(questionActuelle).getImage());
        question_txt.setText( listeQuestions.get(questionActuelle).getQuestion());
        return layoutItem;
    }

    public int getQuestionActuelle(){ return questionActuelle;}

    public void setQuestionActuelle(int qActuellle){this.questionActuelle = qActuellle;}
}
