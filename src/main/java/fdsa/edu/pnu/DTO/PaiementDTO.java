package fdsa.edu.pnu.DTO;

public class PaiementDTO {

    private int id;
    private fdsa.edu.pnu.Model.AnneeAcademique anneeAcademique;
    private fdsa.edu.pnu.Model.Session session;
    private fdsa.edu.pnu.Model.Etudiant etudiant;
    private fdsa.edu.pnu.Model.TypePaiement typePaiement;
    private String numeroPaiement;
    private java.math.BigDecimal montant;
    private java.sql.Timestamp datePaiement;
    private String remarque;
    private final java.util.Set requetes = new java.util.HashSet();
}
