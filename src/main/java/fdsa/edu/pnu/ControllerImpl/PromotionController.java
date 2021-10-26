/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Promotion;
import fdsa.edu.pnu.ServiceImpl.PromotionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jephthé Gédéon
 */

@RestController
public class PromotionController {
    
     @Autowired 
    public PromotionService promotionService;
    
    /**
     * Afficher toutes les Promotions
     *
     * @return
     */
    @GetMapping(value = "/promotions")
    public List<Promotion> getAllPromotion() {
        return (List<Promotion>) promotionService.getPromotion();
    }
    
    
    /**
     * Creer une nouvelle Promotion
     *
     *
     * @param promotion
     * @return
     */
    @PostMapping("/nouveauPromotion")
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.savePromotion(promotion);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/Promotion/(id)")
    public Promotion getPromotion(@PathVariable("id") int id) {
        Optional<Promotion> promotion = promotionService.getPromotion(id);
        if ( promotion.isPresent() ) {
            return promotion.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer une Promotion
     * @param id 
     */
    
    @DeleteMapping("/supprimerPromotion")
    public void deletePromotion(@PathVariable("id") final int id) {
        promotionService.deletePromotion(id);
    }
    
}

