package com.GDI.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DGI.forms.ConnexionForm;
import com.GDI.beans.Inscrit;
import com.GDI.dao.DAOFactory;
import com.GDI.dao.UtilisateurDao;

public class Connexion extends HttpServlet 
{
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_INSCRIT = "utilisateur";
	public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/connexion.jsp";
    private UtilisateurDao     utilisateurDao;
    
    public void init() throws ServletException 
    {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm(utilisateurDao);
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Inscrit ins = form.inscrireUtilisateur( request );
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_INSCRIT, ins );
        request.setAttribute( ATT_USER, form.getUtilisateur() );
        if(!form.getErreurs().isEmpty())
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        else
        {
        	this.getServletContext().getRequestDispatcher(form.getUtilisateur().getVue()  ).forward( request, response );
        }
        	
    }	
}
