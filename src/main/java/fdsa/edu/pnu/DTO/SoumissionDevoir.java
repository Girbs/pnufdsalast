package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Model.Evaluation;

public class SoumissionDevoir {

    private String commentaire;
    private String lienFichier;
    private CoursEtudiant coursEtudiant;
    private Evaluation evaluation;

    public String getLienFichier() {
        return lienFichier;
    }

    public void setLienFichier(String lienFichier) {
        this.lienFichier = lienFichier;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    public CoursEtudiant getCoursEtudiant() {
        return coursEtudiant;
    }

    public void setCoursEtudiant(CoursEtudiant coursEtudiant) {
        this.coursEtudiant = coursEtudiant;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

}


