/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.PostulantDTO;
import fdsa.edu.pnu.Model.Etudiant;
import fdsa.edu.pnu.Model.LogTracking;
import fdsa.edu.pnu.Model.Postulant;
import fdsa.edu.pnu.Model.Role;
import fdsa.edu.pnu.Repository.*;
import fdsa.edu.pnu.Security.PasswordGenerator;
import fdsa.edu.pnu.Service.IPostulantService;
import fdsa.edu.pnu.mail.EmailController;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ing.Girbson BIJOU
 */

@Service
public class PostulantService implements IPostulantService {

    private static final Logger logger = LoggerFactory.getLogger(PostulantService.class);

    private static final ModelMapper mapper = new ModelMapper();
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
    @Autowired
    private LogTrackingDAO logTrackingDAO;


    /**
     * Lister Tous Les Postulants
     *
     * @return
     */
    @Override
    public List<PostulantDTO> findAll() {
        return postulantDAO.findAll().stream()
                .map(PostulantDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Postulant> findById(Integer id) {
        if (id == null) {
            return null;
        }
        return postulantDAO.findById(id);

    }

    @Override
    public Postulant save(Postulant dto) {
        if (dto.getId() == null) {
            try {
                logger.info("The Confirmation email has bean called successfully");
                logTrackingDAO.save(new LogTracking("The Confirmation email has bean called successfully",
                        "No Exeption Error"));
                mail.confirmerInscription(dto.getEmail(), dto.getNom(), dto.getPrenom());
            } catch (Exception e) {
                logger.error("This is sample info message is :" + e);
                logTrackingDAO.save(new LogTracking("Save Postulant Sevice Impl", e.toString()));
            }
        } else {

            Optional<Postulant> postulant = findById(dto.getId());
            String statusToBeUpdated = dto.getStatutApplication();
            String currentApplicationStatus = postulant.get().getStatutApplication();

            if (!currentApplicationStatus.equals("Accepté") && statusToBeUpdated.equals("Accepté")) {

                try {
                    //  Now save details in DB
                    Etudiant etudiant = new Etudiant();
                    etudiant.setNom(dto.getNom());
                    etudiant.setPrenom(dto.getPrenom());
                    etudiant.setCinNif(dto.getNifCin());
                    etudiant.setSexe(dto.getSexe());
                    etudiant.setStatus(true);
                    etudiant.setTelephone1(dto.getTelephone());
                    etudiant.setCodePostal("");
                    etudiant.setUserName(dto.getEmail());
                    //  String pass = password.randomPassword();

                    String pass = "stud@pass";
                    System.out.println(pass);
                    System.out.println(pass);
                    etudiant.setUserPassword(passwordEncoder.encode(pass));
                    etudiant.setCodeEtudiant("CODE");
                    etudiant.setMatricule("50967");
                    Set<Role> role = new HashSet<>();
                    role.add(roleDAO.findById(1).get());
                    etudiant.setRole(role);
                    etudiantDAO.save(etudiant);
                } catch (Exception e) {
                    logTrackingDAO.save(new LogTracking("The student record was not created on method" +
                            " Postulant.Save(...) the error message is" +
                            "", e.getMessage()));
                }
                try {
                    mail.applicationApprovee(dto.getEmail(), dto.getNom(), dto.getPrenom(), dto.getFilliere());
                } catch (Exception e) {
                    logTrackingDAO.save(new LogTracking("The email is not sent on method Postulant.Save(...)" +
                            " the error message is", e.getMessage()));
                }
            }

        }
        return postulantDAO.save(dto);
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
    public List<Postulant> getApplicationParStatut(String statut_application) {

        List<Postulant> lstPostulant = postulantDAO.findAllByStatutApplicatin(statut_application);
        return lstPostulant;
    }

//    @Override
//    public Page<Postulant> findAllWithPaginationAndSorting(int offset, int pageSize, String field) {
//        Page<Postulant> postulants = postulantDAO.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  postulants;
//    }

//This is the OriginalMethod. It works fine
//    public Page<Postulant> findAllWithPaginationAndSortingv1(int offset, int pageSize, String field, String searchfield) {
//        Page<Postulant> postulants = postulantDAO.findByAllDynameicSearch( searchfield, PageRequest.of(offset-1, pageSize).withSort(Sort.by((field))));
//        return  postulants;
//    }

    //This is the new metho with the dynamic sort
    @Override
    public Page<Postulant> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Page<Postulant> postulants = postulantDAO.findByAllDynameicSearch(searchfield, PageRequest.of(offset - 1, pageSize, sort));
        return postulants;
    }


//    public Page<Postulant> findAllWithFilter(int offset, int pageSize, String field, String prenom) {
//        Page<Postulant> postulants = postulantDAO.findByAllName( prenom,
//                PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  postulants;
//    }


    //@Override
//    public Etudiant update(Integer id, Postulant dto) {
//
//        // first find that student is present in db or not
//        Optional<Postulant> postulant = findById(id);
//
//        String statusToBeUpdated = dto.getStatutApplication();
//        String currentApplicationStatus = postulant.
//
//        // Now save details in DB
//        Etudiant etudiant = new Etudiant();
//        etudiant.setNom(dto.getNom());
//        etudiant.setPrenom(dto.getPrenom());
//        etudiant.setCinNif(dto.getNifCin());
//        etudiant.setSexe(dto.getSexe());
//        etudiant.setStatus(true);
//        etudiant.setTelephone1(dto.getTelephone());
//        etudiant.setCodePostal("");
//        etudiant.setUserName(dto.getEmail());
//        // String pass = password.randomPassword();
//
//        String pass = "stud@pass";
//        System.out.println(pass);
//        System.out.println(pass);
//        etudiant.setUserPassword(passwordEncoder.encode(pass));
//        etudiant.setCodeEtudiant("CODE");
//        etudiant.setMatricule("50967");
//        Set<Role> role = new HashSet<>();
//        role.add(roleDAO.findById(1).get());
//        etudiant.setRole(role);
//        // PostulantDTO.fromEntity(postulantDAO.save(PostulantDTO.toEntity(dto)));
//
//        if (!currentApplicationStatus.equals(statusToBeUpdated) && statusToBeUpdated.equals("Accepté")) {
//            // Please focus on ! operator in above condition and replace your "Accepté" text if needed.
//            mail.applicationApprovee(dto.getEmail(), dto.getNom(), dto.getPrenom(), dto.getFilliere());
//        }
//        //postulantDAO.save(dto);
//        return etudiantDAO.save(etudiant);
//        // If application status is updated then we need to send an email confirmation to applicant.
//        // So we will check for equality of current status that we have in DB and new status that we now want to store in DB.
//
//
//        // return PostulantDTO.fromEntity(postulantDAO.save(PostulantDTO.toEntity(dto)));
//    }

}
