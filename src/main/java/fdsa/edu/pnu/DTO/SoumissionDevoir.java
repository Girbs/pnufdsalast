package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.CoursEtudiant;
import fdsa.edu.pnu.Model.Evaluation;

public class SoumissionDevoir {

    private String commentaire;
    private String attachement;
    private CoursEtudiant coursEtudiant;
    private Evaluation evaluation;

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
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
