/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Discussion;
import fdsa.edu.pnu.ServiceImpl.DiscussionService;
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
 * @author EstherA
 */
@RestController
public class DiscussionController {
    @Autowired
public DiscussionService discussionService;
     /**
     * Afficher tous les Discussion
     *
     * @return
     */
    @GetMapping(value = "/discussions")
    public List<Discussion> getAllDiscussion() {
        return (List<Discussion>) discussionService.getDiscussion();
    }

    
    /**
     * Creer nouveau Discussion
     *
     * @param discussion  
     * @return
     */
    @PostMapping("/nouveauDiscussion")
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.saveDiscussion(discussion);
    }

    
    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/Discussion/{id}")
    public Discussion getDiscussion(@PathVariable("id") int id) {
        Optional<Discussion> discussion = discussionService.getDiscussion(id);
        if (discussion.isPresent()) {
            return discussion.get();
        } else {
            return null;
        }
    }
    /**
     * Supprimer une Discussion
     * @param id 
     */
     @DeleteMapping("/supprimerDiscussion/{id}")
	public void deleteEmployee(@PathVariable("id") final int id) {
		discussionService.deleteDiscussion(id);
	}
        
        
        // TO DO modifier une Discussion
      
}
