/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ControllerImpl;

import fdsa.edu.pnu.Model.Message;
import fdsa.edu.pnu.ServiceImpl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Richard
 */
@RestController
public class MessageController {


    @Autowired
    public MessageService messageService;

    /**
     * Afficher tous les Message
     *
     * @return
     */
    @GetMapping(value = "/messages")
    public List<Message> getAllMessage() {
        return (List<Message>) messageService.getMessage();
    }


    /**
     * Creer un nouveau Message
     *
     * @param message
     * @return
     */
    @PostMapping("/nouveauMessage")
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    /**
     * Selectionner par ID
     *
     * @param id
     * @return
     */

    @RequestMapping("/Message/(id)")
    public Message getMessage(@PathVariable("id") int id) {
        Optional<Message> message = messageService.getMessage(id);
        if (message.isPresent()) {
            return message.get();
        } else {
            return null;
        }
    }

    /**
     * Supprimer un Message
     *
     * @param id
     */

    @DeleteMapping("/supprimerMessage")
    public void deleteMessage(@PathVariable("id") final int id) {
        messageService.deleteMessage(id);
    }

}
