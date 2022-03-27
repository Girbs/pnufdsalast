/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Model.ExampleStudent;
import fdsa.edu.pnu.Repository.*;
import fdsa.edu.pnu.Service.IConcoursService;
import fdsa.edu.pnu.Validators.ConcoursValidateur;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author EstherA
 */
@Data
@Service
public class ConcoursService implements IConcoursService {

    @Autowired
    private ConcoursDAO concoursDAO;

    @Autowired
    private ConcoursValidateur concoursValidateur;

    @Autowired
    private PlannificationConcoursDAO plannificationConcoursDAO;

    @Autowired
    private MatiereDAO matiereDAO;

    @Override
    public List<ConcoursDTO> findAll() {
        return concoursDAO.findAll().stream()
                .map(ConcoursDTO::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * Retrouver un postulant à l'aide de son id
     *
     * @param id
     * @return
     */
    @Override
    public Concours findById(Integer id) {
        if (id == null) {
            // log.error("Article ID is null");
            return null;
        }

        return concoursDAO.findConcoursById(id);
//                .map(ConcoursDTO::fromEntity).orElseThrow(()
//                -> new EntityNotFoundException(
//                "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
//                ErrorCodes.ARTICLE_NOT_FOUND)
//        );
    }


    /**
     * Enregistrer Etudiant
     *
     * @param concours
     * @return
     */
    @Override
    public Concours save(Concours concours) {
//        List<String> errors = ConcoursValidateur.validate(concours);
//        if (!errors.isEmpty()) {
//            MessageUtil log = null;
//            MessageUtil.error("Donnees invalid", (ISourceLocation) concours);
//            throw new InvalidEntityException("Donnees invalid", (Throwable) errors);
//        }
        return concoursDAO.save(concours);
    }


    @Override
    public Concours update(Integer id, Concours concours) {
        Concours c = concoursDAO.findById(id).get();
        // Concours c1 = concoursDAO.save(concours);
        concours.getPlannificationConcourses().forEach(a -> {
            a.setConcours(c);
            a.setMatiere(matiereDAO.findById(a.getMatiere().getId()).get());
            //a.setMatiere(matiereDAO.findById(matiere.getId()).get());
            plannificationConcoursDAO.save(a);
        });
        c.setDescription(concours.getDescription());
        c.setDateDebut(concours.getDateDebut());
        c.setDateFin(concours.getDateFin());
        c.setStatus(concours.getStatus());
        return concoursDAO.save(c);
    }

    /**
     * Methode pour supprimer un postulant à l'aide son Id
     *
     * @param id
     */
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
        concoursDAO.deleteById(id);
    }

    @Override
    public List<Concours> findByAllCustomQuery() {
        return concoursDAO.findByAllCustomQuery();
    }


//    @Override
//    public ConcoursDTO save(ConcoursDTO dto) {
////        List<String> errors = ArticleValidator.validate(dto);
////        if (!errors.isEmpty()) {
////            log.error("Article is not valid {}", dto);
////            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
////        }
//
//        return ConcoursDTO.fromEntity(
//                concoursDAO.save(
//                        ConcoursDTO.toEntity(dto)
//                )
//        );
//    }

    @Override
    public Page<Concours> findAllWithPaginationAndSortingv1(int offset, int pageSize, String sortField, String searchfield, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Page<Concours> concours = concoursDAO.findByAllConcoursDynamiqueSearch(searchfield, PageRequest.of(offset - 1, pageSize, sort));
        return concours;
    }

    @Service
    public class ExampleStudentService {

        @Autowired
        private ExampleStudentRepository exampleStudentRepository;

        @Autowired
        private ExampleAddressRepository exampleAddressRepository;

        public ExampleStudent saveStudent(ExampleStudent exampleStudent) {
            ExampleStudent s1 = exampleStudentRepository.save(exampleStudent);
            exampleStudent.getAddresses().forEach(a -> {
                a.setStudent(s1);
                exampleAddressRepository.save(a);
            });

            return exampleStudentRepository.findById(s1.getStudentId()).get();
        }

        public List<ExampleStudent> getStudent() {
            return (List<ExampleStudent>) exampleStudentRepository.findAll();
        }
    }

}
