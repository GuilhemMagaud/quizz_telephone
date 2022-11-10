package com.example.quiz_del_poder;


public class QuestionBuilder {

    private String question, choix1, choix2, choix3, reponse ;
    private String choixUtilisateur;
    private String explication;
    private int image;

    public QuestionBuilder(String question, String choix1, String choix2, String choix3, String reponse, String choixUtilisateur, String explication) {
        this.question = question;
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.choix3 = choix3;
        this.reponse = reponse;
        this.choixUtilisateur = choixUtilisateur;
        this.explication = explication;
    }

    public QuestionBuilder(String question, int image, String choix1, String choix2, String choix3, String reponse, String choixUtilisateur, String explication) {
        this.question = question;
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.choix3 = choix3;
        this.reponse = reponse;
        this.choixUtilisateur = choixUtilisateur;
        this.explication = explication;
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoix1() {
        return choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public String getChoix3() {
        return choix3;
    }

    public String getReponse() {
        return reponse;
    }

    public String getChoixUtilisateur() {
        return choixUtilisateur;
    }

    public String getExplication(){return explication;}

    public int getImage() {return image;}

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoix1(String choix1) {
        this.choix1 = choix1;
    }

    public void setChoix2(String choix2) {
        this.choix2 = choix2;
    }

    public void setChoix3(String choix3) {
        this.choix3 = choix3;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setChoixUtilisateur(String choixUtilisateur) {
        this.choixUtilisateur = choixUtilisateur;
    }
}
