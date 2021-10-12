/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee:
 * License Type: Evaluation
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "Message")
public class Message implements Serializable {
    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "PNU_MESSAGE_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "PNU_MESSAGE_ID_GENERATOR", strategy = "native")
    private int id;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Etudiant.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "EtudiantPersonneID", referencedColumnName = "PersonneID", nullable = false)}, foreignKey = @ForeignKey(name = "EtudiantMessage"))
    private fdsa.edu.pnu.Model.Etudiant etudiant;
    @OneToOne(targetEntity = fdsa.edu.pnu.Model.Message.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "MessageID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "EtudiantMessageReaction"))
    private fdsa.edu.pnu.Model.Message message;
    @ManyToOne(targetEntity = fdsa.edu.pnu.Model.Discussion.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "DiscussionID", referencedColumnName = "ID", nullable = false)}, foreignKey = @ForeignKey(name = "MessageDiscussion"))
    private fdsa.edu.pnu.Model.Discussion discussion;
    @Column(name = "Contenu", nullable = true, length = 255)
    private String contenu;
    @Column(name = "Attachement", nullable = true, length = 255)
    private String attachement;
    @OneToOne(mappedBy = "message", targetEntity = fdsa.edu.pnu.Model.Message.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    private fdsa.edu.pnu.Model.Message messages;

    public Message() {
    }

    public int getId() {
        return id;
    }

    private void setId(int value) {
        this.id = value;
    }

    public int getORMID() {
        return getId();
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String value) {
        this.contenu = value;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String value) {
        this.attachement = value;
    }

    public fdsa.edu.pnu.Model.Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(fdsa.edu.pnu.Model.Discussion value) {
        this.discussion = value;
    }

    public fdsa.edu.pnu.Model.Message getMessage() {
        return message;
    }

    public void setMessage(fdsa.edu.pnu.Model.Message value) {
        this.message = value;
    }

    public fdsa.edu.pnu.Model.Message getMessages() {
        return messages;
    }

    public void setMessages(fdsa.edu.pnu.Model.Message value) {
        this.messages = value;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}
