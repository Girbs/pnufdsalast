/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.DTO.ConcoursDTO;
import fdsa.edu.pnu.Exception.EntityNotFoundException;
import fdsa.edu.pnu.Exception.ErrorCodes;
import fdsa.edu.pnu.Model.Concours;
import fdsa.edu.pnu.Repository.ConcoursDAO;
import fdsa.edu.pnu.Service.IConcoursService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author EstherA
 */
@Data
@Service
public class ConcoursService implements IConcoursService {

    @Autowired
    private ConcoursDAO concoursDAO;

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
    public ConcoursDTO findById(Integer id) {
        if (id == null) {
            // log.error("Article ID is null");
            return null;
        }

        return concoursDAO.findById(id).map(ConcoursDTO::fromEntity).orElseThrow(()
                -> new EntityNotFoundException(
                        "Aucun postulant avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    /**
     * Enregistrer Etudiant
     *
     * @param dto
     * @return
     */
    @Override
    public Concours save(Concours dto) {
      return concoursDAO.save(dto);
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

}
