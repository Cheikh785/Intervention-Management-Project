package com.DGI.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.GDI.beans.Inscrit;
import com.GDI.beans.Utilisateur;
import com.GDI.dao.UtilisateurDao;

public class ConnexionForm 
{
	public static final String CHAMP_MATRICULE = "matricule";
	public static final String CHAMP_PASS = "password";
    private String resultat;
    private Utilisateur utilisateur;
    private UtilisateurDao      utilisateurDao;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private static final String ALGO_CHIFFREMENT = "SHA-256";
    public static final String VUE1 = "/WEB-INF/formulaireDemandeIntervention.jsp";
    public static final String VUE2 = "/WEB-INF/chef-de-pole.jsp";
    public static final String VUE3 = "/WEB-INF/accueil.jsp";
    
    public ConnexionForm( UtilisateurDao utilisateurDao ) 
    {
        this.utilisateurDao = utilisateurDao;
    }

    public String getResultat()
    {
    	return resultat;
    }
    
    public Map<String, String> getErreurs() 
    {
        return erreurs;
    }
    
   public Inscrit inscrireUtilisateur(HttpServletRequest request)
   {
	   Inscrit ins=new Inscrit();
       /* Récupération des champs du formulaire. */
       String matricule = request.getParameter( CHAMP_MATRICULE );
       String motDePasse = request.getParameter( CHAMP_PASS );
       
       /* Validation du champ email. */
       try 
       {
           validation( matricule,motDePasse );
       } catch ( Exception e ) 
       {
           setErreur( CHAMP_MATRICULE, e.getMessage() );
       }
       ins.setMatricule(matricule);
       ins.setMotDePasse(motDePasse);

       /* Initialisation du résultat global de la validation. */
       if ( erreurs.isEmpty() ) 
       {
           resultat = "Succès de la connexion.";
       } else 
       {
           resultat = "Échec de la connexion.";
       }
       return ins;
   }
   
   
   private void validation( String matricule,String motDePasse ) throws Exception
   {
	   Inscrit ins=utilisateurDao.trouver( matricule );
	   if (  ins== null ) 
	   {
	        throw new FormValidationException( "vous n'etes pas inscrit." );
	   }
	   
	   ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
       passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
       passwordEncryptor.setPlainDigest( false );
       if(!passwordEncryptor.checkPassword(motDePasse, ins.getMotDePasse()))
       {
	        throw new FormValidationException( "mot de passe incorrect." );
       }
       setUtilisateur(utilisateurDao.trouverUtilisateur( matricule ));
       if(utilisateur.getMatricule().equals("1Prince"))
       {
    	   utilisateur.setVue(VUE3);
       }
       else 
    	   if(utilisateur.getMatricule().charAt(0)=='1')
    		   utilisateur.setVue(VUE2);
    	   else
    		   utilisateur.setVue(VUE1);
   }
   
   /*
    * Ajoute un message correspondant au champ spécifié à la map des erreurs.
    */
   private void setErreur( String champ, String message ) {
       erreurs.put( champ, message );
   }

   /*
    * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
    * sinon.
    */
   private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
       String valeur = request.getParameter( nomChamp );
       if ( valeur == null || valeur.trim().length() == 0 ) {
           return null;
       } else {
           return valeur.trim();
       }
   }

public Utilisateur getUtilisateur() {
	return utilisateur;
}

public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
   

}
