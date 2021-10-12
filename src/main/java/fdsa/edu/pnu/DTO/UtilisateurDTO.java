/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.DTO;

import fdsa.edu.pnu.Model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

/**
 * @author Ing.Girbson BIJOU
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTO {

    private static ModelMapper mapper = new ModelMapper();

    private Integer personneid;
    private String password;
    private boolean status;
    private String username;
    // private Collection<GroupeDTO> groupeCollection;
    // private Collection<RoleDTO> roleCollection;
    //private Postulant postulant;
    //private Personne personne;
    // private Professeur professeur;
    //private Collection<MessageDTO> messageCollection;
    // private Personnel personnel;


    public static UtilisateurDTO fromEntity(Utilisateur utilisateur) {

        UtilisateurDTO utDTO = mapper.map(utilisateur, UtilisateurDTO.class);
        return utDTO;

//         if (utilisateur == null) {
//      return null;
//      // TODO throw an exception
//    }
//
//    return UtilisateurDTO.builder()
//       // .personneid(utilisateur.getPersonneid())
//        .password(utilisateur.getPassword())
//       // .status(utilisateur.getStatus())
//        .username(utilisateur.getUsername())
//        .build();
    }

    public static Utilisateur toEntity(UtilisateurDTO utilisateurDto) {

        Utilisateur utilisateur = mapper.map(utilisateurDto, Utilisateur.class);

//    if (utlisateurDto == null) {
//      return null;
//      // TODO throw an exception
//    }
//
//    Utilisateur utilisateur = new Utilisateur();
//    //utilisateur.setPersonneid(utlisateurDto.getPersonneid());
//    utilisateur.setPassword(utlisateurDto.getPassword());
//    //utilisateur.setStatus(utlisateurDto.getStatus())
//    utilisateur.setUsername(utlisateurDto.getUsername());

        return utilisateur;
    }
}
