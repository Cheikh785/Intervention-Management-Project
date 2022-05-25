package com.GDI.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GDI.dao.ChefDePoleDao;
import com.GDI.dao.DAOFactory;
import com.GDI.gestionpole.ListeIntervention;
import com.GDI.gestionpole.ListeUtilisateurs;


@WebServlet("/InterventionPeuUrgent")
public class InterventionPeuUrgent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/intervention-peu-urgent.jsp";
	public void init() throws ServletException 
    {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.cdpd = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getChefDePoleDao();
    } 

    public InterventionPeuUrgent() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_LISTE="listeIntervention";
	public static final String ATT_LISTEU="listeUtilisateur";
	private ChefDePoleDao cdpd;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ListeIntervention liste=cdpd.listerIntervention("Peu-Urgent");
		request.setAttribute( ATT_LISTE, liste.getListeIntervention() );
		ListeUtilisateurs listeU=cdpd.listerUtilisateur();
		request.setAttribute( ATT_LISTEU, listeU.getListeUtilisateur());
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}
}
