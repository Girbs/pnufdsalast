/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Stage;
import fdsa.edu.pnu.ServiceImpl.StageService;
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
public class StageController {
    
     @Autowired 
    public StageService stageService;
    
    /**
     * Afficher tous les Stages
     *
     * @return
     */
    @GetMapping(value = "/Stage")
    public List<Stage> getAllStage() {
        return (List<Stage>) stageService.getStage();
    }
    
    
    /**
     * Creer un nouveau Stage
     *
     *
     * @param stage
     * @return
     */
    @PostMapping("/nouveauStage")
    public Stage createStage(@RequestBody Stage stage) {
        return stageService.saveStage(stage);
    }
    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    
    @RequestMapping("/Stage/{id}")
    public Stage getStage(@PathVariable("id") int id) {
        Optional<Stage> stage = stageService.getStage(id);
        if ( stage.isPresent() ) {
            return stage.get();
        }else {
            return null;
        }
    }
    
    /**
     * Supprimer un Stage
     * @param id 
     */
    
    @DeleteMapping("/supprimerStage")
    public void deleteStage(@PathVariable("id") final int id) {
        stageService.deleteStage(id);
    }
    
}
