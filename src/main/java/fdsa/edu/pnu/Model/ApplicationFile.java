package fdsa.edu.pnu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ApplicationFile")
public class ApplicationFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String filename;
    private String fileDescription;

    private byte[] apllicationFile;

    @JsonIgnoreProperties(value = {"applicationFiles"}, allowSetters = true)
    @ManyToOne(targetEntity = Postulant.class)
    @JoinColumns({@JoinColumn(name = "PostulantID", referencedColumnName = "ID")})
    private Postulant postulant;

    public ApplicationFile() {
    }

    public ApplicationFile(String filename, String fileDescription) {
        this.filename = filename;
        this.fileDescription = fileDescription;
    }

    public ApplicationFile(String filename, String fileDescription, byte[] apllicationFile) {
        this.filename = filename;
        this.fileDescription = fileDescription;
        this.apllicationFile = apllicationFile;
    }

    public Integer getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public byte[] getFile() {
        return apllicationFile;
    }

    public void setFile(byte[] apllicationFile) {
        this.apllicationFile = apllicationFile;
    }

}
