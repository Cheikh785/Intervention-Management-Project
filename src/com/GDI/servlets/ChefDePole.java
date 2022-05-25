package com.GDI.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GDI.beans.Utilisateur;
import com.GDI.dao.ChefDePoleDao;
import com.GDI.dao.DAOFactory;
import com.GDI.gestionpole.ListeIntervention;
import com.GDI.gestionpole.ListeMateriaux;
import com.GDI.gestionpole.ListeUtilisateurs;



@WebServlet("/ChefDePole")
public class ChefDePole extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE = "/WEB-INF/chef-de-pole.jsp";
	public static final String ATT_LISTE="listeIntervention";
	public static final String ATT_LISTEU="listeUtilisateur";
	public static final String ATT_USER="user";
	public static final String ATT_MATERIEL="listeMateriel";
	private ChefDePoleDao cdpd;

    public ChefDePole() {
        super();
    }

    
    public void init() throws ServletException 
    {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.cdpd = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getChefDePoleDao();
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Utilisateur user=new Utilisateur();
		user.setFonction(request.getParameter("name"));
		ListeIntervention liste=cdpd.listerIntervention(user.getFonction().split(" ")[1]);
		request.setAttribute( ATT_LISTE, liste.getListeIntervention() );
		request.setAttribute( ATT_USER, user );
		
		ListeUtilisateurs listeU=cdpd.listerUtilisateur();
		request.setAttribute( ATT_LISTEU, listeU.getListeUtilisateur());
		
		ListeMateriaux listeM=cdpd.listerMateriaux(user.getFonction().split(" ")[1]);
		request.setAttribute( ATT_MATERIEL, listeM.getListeMateriel());
		
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

}
