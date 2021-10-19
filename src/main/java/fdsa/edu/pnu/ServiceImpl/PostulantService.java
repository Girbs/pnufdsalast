/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Repository.EtudiantDAO;
import fdsa.edu.pnu.Repository.PersonneDAO;
import fdsa.edu.pnu.Repository.PostulantDAO;
import fdsa.edu.pnu.Repository.RoleDAO;
import fdsa.edu.pnu.Security.PasswordGenerator;
import fdsa.edu.pnu.Service.IPostulantService;
import fdsa.edu.pnu.mail.EmailController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ing.Girbson BIJOU
 */
@Data
@Service
public class PostulantService implements IPostulantService {

    @Autowired
    public EmailController mail;
    @Autowired
    private PostulantDAO postulantDAO;
    @Autowired
    private EtudiantDAO etudiantDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private PersonneDAO personneDAO;
    @Autowired
    private PasswordGenerator password;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Role role = new Role();
//    public  PostulantService(){
//      Role role=  roleDAO.findByRoleName("Etudiant");
//
//        System.out.println(role.getRoleName());
//    }

//    public PostulantService(@Autowired RoleDAO roleDao) {
//        this.roleDAO = roleDao;
//
//        try {
//            role = roleDAO.findByRoleName("Etudiant");
//        }catch (Exception e){
//            System.out.printf(e.getMessage());
//        }
//       // System.out.println(role.getRoleName());
//    }

    @Override
    public List<PostulantDTO> findAll() {
        return postulantDAO.findAll().stream()
                .map(PostulantDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PostulantDTO findById(Integer id) {
        if (id == null) {
            return null;
        }
        return postulantDAO.findById(id).map(PostulantDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public PostulantDTO save(PostulantDTO dto) {

        return PostulantDTO.fromEntity(
                postulantDAO.save(
                        PostulantDTO.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
//    if (id == null) {
//      log.error("Article ID is null");
//      return;
//    }
//    List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
//    if (!ligneCommandeClients.isEmpty()) {
//      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
//    }
//    List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
//    if (!ligneCommandeFournisseurs.isEmpty()) {
//      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
//          ErrorCodes.ARTICLE_ALREADY_IN_USE);
//    }
//    List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
//    if (!ligneVentes.isEmpty()) {
//      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
//          ErrorCodes.ARTICLE_ALREADY_IN_USE);
//    }
        postulantDAO.deleteById(id);
    }

    @Override
    public PostulantDTO update(@PathVariable("id") final Integer id,  PostulantDTO dto) {

        // first find that student is present in db or not
        PostulantDTO postulantDTO = findById(id);

        String statusToBeUpdated = dto.getStatutApplication();
        String currentApplicationStatus = postulantDTO.getStatutApplication();


        // If application status is updated then we need to send an email confirmation to applicant.
        // So we will check for equality of current status that we have in DB and new status that we now want to store in DB.
        if (!currentApplicationStatus.equals(statusToBeUpdated) && statusToBeUpdated.equals("Accepté")) {
            // Please focus on ! operator in above condition and replace your "Accepté" text if needed.
            // Now save details in DB
            Etudiant etudiant = new Etudiant();
            etudiant.setNom(dto.getNom());
            etudiant.setPrenom(dto.getPrenom());
            etudiant.setCinNif(dto.getNifCin());
            etudiant.setSexe(dto.getSexe());
            etudiant.setStatus(true);
            etudiant.setTelephone1(dto.getTelephone());
            etudiant.setCodePostal("");
            etudiant.setUserName(dto.getEmail());
            String pass = password.randomPassword();
            System.out.println(pass);
            etudiant.setUserPassword(passwordEncoder.encode(pass));
            etudiant.setCodeEtudiant("CODE");
            etudiant.setMatricule("50967");
            Set<Role> role = new HashSet<>();
            // role.add(new Role());
           // role.add(roleDAO.findByRoleName("Etudiant"));
            //  role.add(roleDAO.findById(2).get());
            etudiant.setRoles(role);
            etudiantDAO.save(etudiant);

            mail.applicationApprovee(dto.getEmail(), dto.getNom(), dto.getPrenom(), dto.getFilliere());

        }

        return PostulantDTO.fromEntity(postulantDAO.save(PostulantDTO.toEntity(dto)));
    }

}

