package com.DGI.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.GDI.beans.Inscrit;
import com.GDI.beans.Utilisateur;
import com.GDI.dao.DAOException;
import com.GDI.dao.UtilisateurDao;

public class InscriptionForms 
{
	public static final String CHAMP_MATRICULE = "matricule";
	public static final String CHAMP_PASS = "password";
	public static final String CHAMP_CONF = "cpassword";
    private String resultat;
    private Utilisateur utilisateur;
    private Map<String, String> erreurs = new HashMap<String, String>();
    private UtilisateurDao      utilisateurDao;
    private static final String ALGO_CHIFFREMENT = "SHA-256";

    public InscriptionForms( UtilisateurDao utilisateurDao ) 
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
	   	String matricule = getValeurChamp( request, CHAMP_MATRICULE );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    String confirmation = getValeurChamp( request, CHAMP_CONF );
	   
	    Inscrit utilisateur = new Inscrit();
	    try 
	    {
	        traiterMatricule( matricule, utilisateur );
	        traiterMotsDePasse( motDePasse, confirmation, utilisateur );
	       
	        if ( erreurs.isEmpty() ) 
	        {
	            utilisateurDao.creer( utilisateur );
	            resultat = "Succès de l'inscription.";
	        } else 
	        {
	            resultat = "Échec de l'inscription.";
	        }
	    } catch ( DAOException e )
	    {
	        resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
	        e.printStackTrace();
	    }

	    return utilisateur;
   }
   
   /*
    * Appel à la validation de l'adresse email reçue et initialisation de la
    * propriété email du bean
    */
   private void traiterMatricule( String matricule, Inscrit utilisateur ) 
   {
       try 
       {
           validationMatricule( matricule );
       } catch ( FormValidationException e ) 
       {
           setErreur( CHAMP_MATRICULE, e.getMessage() );
       }
       utilisateur.setMatricule( matricule );
   }

   /*
    * Appel à la validation des mots de passe reçus, chiffrement du mot de
    * passe et initialisation de la propriété motDePasse du bean
    */
   private void traiterMotsDePasse( String motDePasse, String confirmation, Inscrit utilisateur ) 
   {
       try 
       {
           validationMotsDePasse( motDePasse, confirmation );
       } catch ( FormValidationException e ) 
       {
           setErreur( CHAMP_PASS, e.getMessage() );
           setErreur( CHAMP_CONF, null );
       }

       /*
        * Utilisation de la bibliothèque Jasypt pour chiffrer le mot de passe
        * efficacement.
        * 
        * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
        * aléatoire et un grand nombre d'itérations de la fonction de hashage.
        * 
        * La String retournée est de longueur 56 et contient le hash en Base64.
        */
       ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
       passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
       passwordEncryptor.setPlainDigest( false );
       String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );

       utilisateur.setMotDePasse( motDePasseChiffre );
   }
   
   
   private void validationMatricule( String matricule ) throws FormValidationException
   {
   	if(matricule==null || matricule.trim().length()==0)
   	{
   		throw new FormValidationException( "Merci de saisir un matricule valide." );
   	}else if ( utilisateurDao.trouverUtilisateur( matricule ) == null ) 
   	{
        throw new FormValidationException( "echec matricule non trouve ." );
    }else if ( utilisateurDao.trouver( matricule ) != null ) 
   	{
        throw new FormValidationException( "vous etes deja inscrit." );
    }
   	utilisateur=utilisateurDao.trouverUtilisateur( matricule );
   }
   private void validationMotsDePasse( String motDePasse, String confirmation ) throws FormValidationException
   {
   	if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) 
   	{
           if (!motDePasse.equals(confirmation)) 
           {
               throw new FormValidationException("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
           } else if (motDePasse.trim().length() < 3) 
           {
               throw new FormValidationException("Les mots de passe doivent contenir au moins 3 caractères.");
           }
       } else 
       {
           throw new FormValidationException("Merci de saisir et confirmer votre mot de passe.");
       }
   }
   
   /*
    * Ajoute un message correspondant au champ spécifié à la map des erreurs.
    */
   private void setErreur( String champ, String message ) 
   {
       erreurs.put( champ, message );
   }

   /*
    * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
    * sinon.
    */
   private static String getValeurChamp( HttpServletRequest request, String nomChamp ) 
   {
       String valeur = request.getParameter( nomChamp );
       if ( valeur == null || valeur.trim().length() == 0 ) 
       {
           return null;
       } else 
       {
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
