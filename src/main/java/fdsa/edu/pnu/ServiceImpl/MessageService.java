/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.pnu.ServiceImpl;

import fdsa.edu.pnu.Model.Message;
import fdsa.edu.pnu.Repository.MessageDAO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Richard
 */

@Data
@Service

public class MessageService {

    @Autowired

    private MessageDAO messageDAO;

    public Optional<Message> getMessage(final int id) {
        return messageDAO.findById(id);
    }

    public Iterable<Message> getMessage() {
        return messageDAO.findAll();
    }

    public void deleteMessage(final int id) {
        messageDAO.deleteById(id);
    }

    public Message saveMessage(Message Message) {
        Message savedMessage = messageDAO.save(Message);
        return savedMessage;
    }

}
