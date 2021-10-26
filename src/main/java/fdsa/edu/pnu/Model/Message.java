/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package fdsa.edu.pnu.Model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
@Entity
@Data
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Message")
public class Message implements Serializable {
	public Message() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PNU_MESSAGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PNU_MESSAGE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= Etudiant.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EtudiantPersonneID", referencedColumnName="PersonneID", nullable=false) }, foreignKey=@ForeignKey(name="EtudiantMessage"))	
	private Etudiant etudiant;
	
	@OneToOne(targetEntity= Message.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="MessageID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="EtudiantMessageReaction"))	
	private Message message;
	
	@ManyToOne(targetEntity= Discussion.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="DiscussionID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="MessageDiscussion"))	
	private Discussion discussion;
	
	@Column(name="Contenu", nullable=true, length=255)	
	private String contenu;
	
	@Column(name="Attachement", nullable=true, length=255)	
	private String attachement;
	
	@OneToOne(mappedBy="message", targetEntity= Message.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private Message messages;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setContenu(String value) {
		this.contenu = value;
	}
	
	public String getContenu() {
		return contenu;
	}
	
	public void setAttachement(String value) {
		this.attachement = value;
	}
	
	public String getAttachement() {
		return attachement;
	}
	
	
	
	public void setDiscussion(Discussion value) {
		this.discussion = value;
	}
	
	public Discussion getDiscussion() {
		return discussion;
	}
	
	public void setMessage(Message value) {
		this.message = value;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public void setMessages(Message value) {
		this.messages = value;
	}
	
	public Message getMessages() {
		return messages;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
