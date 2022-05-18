/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fdsa.edu.pnu.mail;

/**
 * @author gbijou
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    SimpleMailMessage message = new SimpleMailMessage();

    @ResponseBody
    public void confirmerInscription(String emailpostulant, String nomPostulant, String prenomPostulant, String codeApplication) {


        message.setTo(emailpostulant);
        message.setSubject("Confirmation d'inscription");
        message.setText("Chèr(e)  " + prenomPostulant + " " + nomPostulant + ", \n\n "
                + "La Faculté Des Sciences Appliquées (FDSA) vous remercie de votre"
                + "interet à ses programmes d'étude tout en vous informant que votre "
                + "demande d'admssion a été bien recue. \n\n" +
                "Votre code d'application est:" + codeApplication + " \n\n" +
                " Dans les jours qui suivent, "
                + "un agent vous contactera pour les suites necessaires. \n\n "
                + "Cordialement\n Bureau d'Admission\n Faculte Des Science Appliquees(FDSA)");

        // Send Message!
        this.emailSender.send(message);
    }

    @ResponseBody
    public void applicationApprovee(String emailpostulant, String nomPostulant, String prenomPostulant, String filliere) {

        message.setTo(emailpostulant);
        message.setSubject("Application Approuvee");
        message.setText("Chèr(e)  " + prenomPostulant + " " + nomPostulant + ", \n\n "
                + "Le departement d'admission de la  (FDSA) a le plaisir de vous informer"
                + "que votre application pour le programme de " + filliere + " a été retenue."
                + "Priere de cliquer sur le lien ci-dessous pour accepter "
                + "l'offre et du coup activer votre compte d'etutiant.Une fois que votre est activé"
                + "vous retrouverez par email, votre num d'utilisateur et password pour acceder aux ressources des etudiants.\n\n "

                + "Cordialement\n Bureau d'Admission\n Faculte Des Science Appliquees(FDSA)");

        // Send Message!
        this.emailSender.send(message);

    }

    @ResponseBody
    public void confirmerCreationProfesseur(String emailProfesseur, String nomProfesseur, String prenomProfesseur, String nomUtilisateur, String motDePasse) {

        message.setTo(emailProfesseur);
        message.setSubject("Bienvenue à la FDSA");
        message.setText("Professeur  " + prenomProfesseur + " " + nomProfesseur + ", \n\n "
                + "La Direction Academique  de la FDSA vous souhaite la plus cordiale bienvenue sur sa platforme."
                + "Priere d'utiliser les informations ci-dessous pour accesder aux ressources de la faculte.\n\n"
                + "Nom d'utilisateur: " + nomUtilisateur + "\n"
                + "Mot de Passe temporaire: " + motDePasse + "\n\n"

                + "Cordialement\n Direction Academique\n Faculte Des Science Appliquees(FDSA)");

        // Send Message!
        this.emailSender.send(message);

    }

    @ResponseBody
    public void confirmerCreationPersonnel(String emailProfesseur, String nomProfesseur, String prenomProfesseur, String nomUtilisateur, String motDePasse) {

        message.setTo(emailProfesseur);
        message.setSubject("Bienvenue à la FDSA");
        message.setText("Professeur  " + prenomProfesseur + " " + nomProfesseur + ", \n\n "
                + "La Faculté Des Sciences Appliquées vous souhaite la plus cordiale bienvenue sur sa platforme."
                + "Priere d'utiliser les informations ci-dessous pour accesder aux ressources de la faculte.\n\n"
                + "Nom d'utilisateur: " + nomUtilisateur + "\n"
                + "Mot de Passe temporaire: " + motDePasse + "\n\n"

                + "Cordialement\n Decanat\n Faculte Des Science Appliquees(FDSA)");

        // Send Message!
        this.emailSender.send(message);

    }

    @ResponseBody
    public void motDePasseOublieConfirmationEmail(String email, String nom, String prenom, String nomUtilisateur, String motDePasse) {

        message.setTo(email);
        message.setSubject("Mot de passe Reinitialisé");
        message.setText("Cher(e) " + prenom + " " + nom + ", \n\n "
                + "Votre mot de pass a éte reinitialisé avec succes."
                + "Priere d'utiliser les informations ci-dessous pour accesder aux ressources de la faculte.\n\n"
                + "Nom d'utilisateur: " + nomUtilisateur + "\n"
                + "Mot de Passe temporaire: " + motDePasse + "\n\n"
                + "Cordialement\nSupport Technique PNU\nFaculte Des Science Appliquees(FDSA)");

        // Send Message!
        this.emailSender.send(message);

    }

    @ResponseBody
    public void notificationResultatExamenPostee(String email, String cours, String typeEvaluation) {

        message.setTo(email);
        message.setSubject("Nouvelle note postée");
        message.setText(
                "La Presente est pour vous informer qu'une nouvelle note vient d'etre postée.\n\n"

                        + "Cours:" + cours + "\n\n"
                        + "Type d'evaluation" + typeEvaluation + "\n\n"


                        + "Cordialement\nDirection Academique\nFaculte Des Science Appliquees(FDSA)");

        this.emailSender.send(message);

    }


}