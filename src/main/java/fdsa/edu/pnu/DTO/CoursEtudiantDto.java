package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Cours;

import java.util.List;

public class CoursEtudiantDto {


    private Integer id;
    private double note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getCote() {
        return cote;
    }

    public void setCote(String cote) {
        this.cote = cote;
    }

    public double getNumbrePoint() {
        return numbrePoint;
    }

    public void setNumbrePoint(double numbrePoint) {
        this.numbrePoint = numbrePoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Etudiant getEtudiant() {
//        return etudiant;
//    }
//
//    public void setEtudiant(Etudiant etudiant) {
//        this.etudiant = etudiant;
//    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<HistoriqueEvaluationDto> getHistoriqueEvaluationDto() {
        return historiqueEvaluationDto;
    }

    public void setHistoriqueEvaluationDto(List<HistoriqueEvaluationDto> historiqueEvaluationDto) {
        this.historiqueEvaluationDto = historiqueEvaluationDto;
    }

    private String mention;
    private String cote;
    private double numbrePoint;
    private String type;
   // private Etudiant etudiant;
    private Cours cours;
    private List<HistoriqueEvaluationDto> historiqueEvaluationDto;
}
