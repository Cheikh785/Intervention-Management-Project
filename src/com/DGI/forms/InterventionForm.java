package com.DGI.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.GDI.beans.Inscrit;
import com.GDI.beans.Intervention;
import com.GDI.beans.Utilisateur;
import com.GDI.dao.DAOException;
import com.GDI.dao.InterventionDao;
import com.GDI.dao.UtilisateurDao;

public class InterventionForm 
{
	public static final String CHAMP_MATRICULE="matricule";
	/*public static final String CHAMP_NOM="nom";
	public static final String CHAMP_PRENOM="prenom";
	public static final String CHAMP_FONCTION="fonction";
	public static final String CHAMP_EMAIL="email";
	public static final String CHAMP_TELEPHONE="telephone";*/
	public static final String CHAMP_TDP="tdp";
	public static final String CHAMP_ATDP="autretdp";
	public static final String CHAMP_CDD="cdd";
	public static final String CHAMP_ACDD="autrecdd";
	public static final String CHAMP_SERVICE="service";
	public static final String CHAMP_ASERVICE="autreservice";
	public static final String CHAMP_PRIORITE="priorite";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private InterventionDao      interventionDao;

    public InterventionForm( InterventionDao      interventionDao ) 
    {
        this.interventionDao = interventionDao;
    }

	   
	public Intervention enregistrerDemande(HttpServletRequest request)
	{
		Intervention intervention=new Intervention();
		String atdp = null,acdd=null,aservice=null;
		String matricule = getValeurChamp( request, CHAMP_MATRICULE );
		String tdp = getValeurChamp( request, CHAMP_TDP );
		if(tdp.equals("Autres"))
			atdp = getValeurChamp( request, CHAMP_ATDP );
		else
			intervention.setTdp(tdp);
			
		String cdd = getValeurChamp( request, CHAMP_CDD );
		if(cdd.equals("Autres"))
			acdd= getValeurChamp( request, CHAMP_ACDD );
		else
			intervention.setCdd(cdd);
		String service = getValeurChamp( request, CHAMP_SERVICE );
		if(service.equals("Autres"))
			aservice= getValeurChamp( request, CHAMP_ASERVICE );
		else
			intervention.setService(service);
		String priorite = getValeurChamp( request, CHAMP_PRIORITE );
		intervention.setMatricule(matricule);
		intervention.setPriorite(priorite);
		try 
	    {
			if(tdp.equals("Autres"))
	        traiterAutreTdp( atdp,intervention );
			if(cdd.equals("Autres"))
		        traiterAutreCdd( acdd,intervention );
			if(service.equals("Autres"))
		        traiterAutreService(aservice,intervention );
	        if ( erreurs.isEmpty() ) 
	        {
	        	interventionDao.creer( intervention );
	            setResultat("Succès de la demande d'intervention.");
	        } else 
	        {
	            setResultat("Échec de la demande d'intervention.");
	        }
	    } catch ( DAOException e )
	    {
	        setResultat("Échec de l'envoie de la demande : une erreur imprévue est survenue, merci de réessayer dans quelques instants.");
	        e.printStackTrace();
	    }
		return intervention;

	    
	}
	
	private void traiterAutreTdp( String atdp,Intervention intervention) 
	{
		try 
		{
           validationAutreTdp( atdp );
		} catch ( FormValidationException e ) 
		{
           setErreur( CHAMP_ATDP, e.getMessage() );
		}
		intervention.setTdp(atdp);
	}
	
	private void traiterAutreCdd( String acdd,Intervention intervention) 
	{
		try 
		{
           validationAutreCdd( acdd );
		} catch ( FormValidationException e ) 
		{
           setErreur( CHAMP_ACDD, e.getMessage() );
		}
		   intervention.setCdd(acdd);
	}
	
	private void traiterAutreService( String aservice,Intervention intervention) 
	{
		try 
		{
           validationAutreService( aservice );
		} catch ( FormValidationException e ) 
		{
           setErreur( CHAMP_ASERVICE, e.getMessage() );
		}
		intervention.setService(aservice);
	   
		   
	}
	
	private void setErreur( String champ, String message ) 
	{
	       erreurs.put( champ, message );
	}
	
	public Map<String, String> getErreurs() 
    {
        return erreurs;
    }
	
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
	
	private void validationAutreTdp( String atdp) throws FormValidationException
	{
		if(atdp==null || atdp.length()==0)
		{
			throw new FormValidationException("le champ autre de type de defaillance ne doit pas etre vide.");
		}
	}
	
	private void validationAutreCdd( String acdd) throws FormValidationException
	{
		if(acdd==null || acdd.length()==0)
		{
			throw new FormValidationException("le champ autre de cause de la defaillance ne doit pas etre vide.");
		}
		
	}
	
	private void validationAutreService( String aservice) throws FormValidationException
	{
		if(aservice==null || aservice.length()==0)
		{
			throw new FormValidationException("le champ autre de service ne doit pas etre vide.");
		}
	}


	public String getResultat() 
	{
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	   

}
