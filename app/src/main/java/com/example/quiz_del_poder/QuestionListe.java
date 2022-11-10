package com.example.quiz_del_poder;

import java.util.ArrayList;
import java.util.List;

public class QuestionListe {

    private static List<QuestionBuilder> quizQuestions() {

        final List<QuestionBuilder> quizListQuestions = new ArrayList<>();

        final QuestionBuilder question10 = new QuestionBuilder("En combien d’ordres est divisé la société médiéval ?", "3", "4", "5", "3", "", "explication : La société médiévale est décomposée en 3 catégories qui sont bellatores (ce qui signifie ce qui se batte, regroupant : noble, seigneur et chevalier), oratoires (ce sont les personnes qui prient regroupant tous les hommes religieux), et les laboratore (toutes les personnes qui travaillent regroupant tous les paysans qui constituent 80 à 90 % de la population).");
        final QuestionBuilder question2 = new QuestionBuilder("Quelle est la durée de la guerre de 100 ans ?", "96 ans", "100 ans", "116 ans", "116 ans", "", "explication : La guerre de 100 ans opposant français anglais à durer 116 ans de 1337 – 1453 se soldant par la victoire de la France.");
        final QuestionBuilder question3 = new QuestionBuilder("En combien de périodes est décomposé le Moyen-Âge ?", "1", "3", "5", "3", "", "explication : Le moyen Âge est décomposé en 3 périodes, le haut Moyen Âge qui a duré 6 siècles, le moyen Âge central qui se situe entre le 11e et le 13e siècles qui se soldera par la guerre de 100 ans et le moyen Âge tardif qui a eu lieu du 14e au 15e siècle.");
        final QuestionBuilder question4 = new QuestionBuilder("Qui est Saint-Louis ?", "Clovis", "Louis IX", "Louis XI", "Louis IX", "","explication : Louis IX est le fameux Saint-Louis, il gagna ce surnom car il est considéré comme un saint grâce à c’est acte notamment parce qu’il voulait prouver les valeurs du christianisme, qui consiste à ce qu’un homme pouvait à la fois incarner le pouvoir politique et le pouvoir spirituel.");
        final QuestionBuilder question5 = new QuestionBuilder("De quelle main les chevaliers tienne leur épée ?", "Droite", "Gauche", "Les deux", "Droite", "","explication : Les chevalier tienne leur épée la mains droit même s’ils sont gaucher car la mains droite représente la mains de Dieu.");
        final QuestionBuilder question6 = new QuestionBuilder("A qui appartiens l’équipement des Templiers ?", "À l’ordre", "Au seigneur", "Au templier", "À l’ordre", "", "explication : L’équipement appartient à l’ordre des templiers qui le leur fourni, le seul équipement pouvant appartenir au templier est leur dague.");
        final QuestionBuilder question7 = new QuestionBuilder("Combien il y eu de dynasties en France pendant le Moyen-Âge ?", "4", "5", "8", "4", "", "explication : Il y a eu 4 grandes dynasties en France pendant le moyen Âge qui on était : la dynastie mérovingienne, la dynastie carolingienne, la dynastie capétienne et la dynastie valoise.");
        final QuestionBuilder question8 = new QuestionBuilder("À quoi servait les oubliettes ?", "Pour se cacher", "Emprisonner des ennemis", "Stocké de la nourriture", "Stocké de la nourriture", "","explication : Au moyen Âge les oubliettes servaient probablement à stocker de la nourriture pour pouvoir résister au siège.");
        final QuestionBuilder question9 = new QuestionBuilder("Dans quelle but a était construit le château de Versailles ?", "Pour une résidence du roi", "Pour se protéger", "Pour faire des jardins", "Pour une résidence du roi", "","explication : Le château de Versailles sert de résidence pour le roi, elle permettait au roi d’avoir un pied à terre pour faire des parties de chasse.");
        //final QuestionBuilder question10 = new QuestionBuilder("Combien de type de couleur sont utiliser en héraldique (pour les blason) ?", "3", "6", "12", "3", "", "explication : les 3 types de couleur utiliser en héraldique sont métaux (jaune et blanc), émaux (rouge, bleu, noire, vert, violet, orange), fourrure (vair,contre-vair,hermine,contre hermine).");
        final QuestionBuilder question1 = new QuestionBuilder("Comment s’appelle cette pièce d’armure ?", R.drawable.gaurgerin, "La bassine", "Le gorgerin", "Le plastron", "Le gorgerin", "", "Explication : Le gorgerin est une pièce d’armure utile pour les chevaliers leur permettant de protéger leur gorge et la clavicule.");

        quizListQuestions.add(question1);
        quizListQuestions.add(question2);
        quizListQuestions.add(question3);
        quizListQuestions.add(question4);
        quizListQuestions.add(question5);
        quizListQuestions.add(question6);
        quizListQuestions.add(question7);
        quizListQuestions.add(question8);
        quizListQuestions.add(question9);
        quizListQuestions.add(question10);

        return quizListQuestions;

    }


    public static List<QuestionBuilder> getQuestions() {
        return quizQuestions();
    }
}
