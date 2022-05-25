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
import com.GDI.gestionpole.ListeMateriaux;
import com.GDI.gestionpole.ListeUtilisateurs;


@WebServlet("/GestionStock")
public class GestionStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/gestion-stock.jsp";
       
	public void init() throws ServletException 
    {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.cdpd = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getChefDePoleDao();
    }
	
    public GestionStock() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}
	
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_MATERIEL="listeMateriel";
	private ChefDePoleDao cdpd;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		ListeMateriaux listeM=cdpd.listerMateriaux("Electricite");
		request.setAttribute( ATT_MATERIEL, listeM.getListeMateriel());
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}
}
