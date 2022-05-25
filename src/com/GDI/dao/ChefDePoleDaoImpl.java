package com.GDI.dao;

import static com.GDI.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.GDI.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.GDI.beans.Intervention;
import com.GDI.beans.Materiel;
import com.GDI.beans.Utilisateur;
import com.GDI.gestionpole.ListeIntervention;
import com.GDI.gestionpole.ListeMateriaux;
import com.GDI.gestionpole.ListeUtilisateurs;

public class ChefDePoleDaoImpl implements ChefDePoleDao 
{
	private DAOFactory          daoFactory;

	 ChefDePoleDaoImpl( DAOFactory daoFactory ) 
	 {
		 this.daoFactory = daoFactory;
	 }
	 
	 private  String SQL_SELECT = "SELECT * FROM demanderIntervention where tdp='r' ";
	 
		 	

	@Override
	public ListeIntervention listerIntervention(String s) throws DAOException 
	{
		switch(s)
		{
			case "Electricite":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Electricite'"; break;
			case "Plomberie":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Plomberie'"; break;
			case "Menuiserie":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Menuiserie'"; break;
			case "Climatisation":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Climatisation'"; break;
			case "Maçonnerie":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Maçonnerie'"; break;
			case "Video-projecteur":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE tdp='Video-Projecteur'"; break;
			case "Urgent":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE priorite='Urgent'"; break;
			case "Peu-Urgent":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE priorite='Peu Urgent'"; break;
			case "Pas-Urgent":SQL_SELECT = "SELECT * FROM demanderIntervention WHERE priorite='Pas Urgent'"; break;
		}
		 Connection connexion = null;
	     PreparedStatement preparedStatement = null;
	     ListeIntervention liste=new ListeIntervention();
	     try 
	     {
	         /* Récupération d'une connexion depuis la Factory */
	         connexion = daoFactory.getConnection();
	         preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT, false );
	         ResultSet resultSet = preparedStatement.executeQuery();
	         /* Analyse du statut retourné par la requête d'insertion */
	         while(resultSet.next())
	         {
	        	 if(!liste.estDans(map(resultSet)))
	        		 liste.ajouterIntervention(map(resultSet));
	         }
	     } catch ( SQLException e ) 
	     {
	         throw new DAOException( e );
	     } finally 
	     {
	         fermeturesSilencieuses(  preparedStatement, connexion );
	     }
	     return liste;
	}
	
	private static Intervention map( ResultSet resultSet ) throws SQLException 
	{
		Intervention utilisateur = new Intervention();
	    utilisateur.setMatricule( resultSet.getString( "matricule" ) );
	    utilisateur.setId( resultSet.getLong( "id" ) );
	    utilisateur.setTdp( resultSet.getString( "tdp" ) );
	    utilisateur.setCdd( resultSet.getString( "cdd" ) );
	    utilisateur.setService( resultSet.getString( "service" ) );
	    utilisateur.setPriorite( resultSet.getString( "priorite" ) );
	    utilisateur.setDate( resultSet.getTimestamp("dateDemande") );
	    utilisateur.setStatut( resultSet.getString( "statut" ) );
	    return utilisateur;
	}
	
	private static final String SQL_SELECT1 = "SELECT * FROM utilisateurs ";
	@Override
	public ListeUtilisateurs listerUtilisateur() throws DAOException 
	{
		 Connection connexion = null;
	     PreparedStatement preparedStatement = null;
	     ListeUtilisateurs liste=new ListeUtilisateurs();
	     try 
	     {
	         /* Récupération d'une connexion depuis la Factory */
	         connexion = daoFactory.getConnection();
	         preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT1, false );
	         ResultSet resultSet = preparedStatement.executeQuery();
	         /* Analyse du statut retourné par la requête d'insertion */
	         while(resultSet.next())
	         {
	        	 liste.ajouterUtilisateur(mapUtilisateur(resultSet));
	         }
	     } catch ( SQLException e ) 
	     {
	         throw new DAOException( e );
	     } finally 
	     {
	         fermeturesSilencieuses(  preparedStatement, connexion );
	     }
	     return liste;
	}
	
	private static Utilisateur mapUtilisateur( ResultSet resultSet ) throws SQLException 
	{
		Utilisateur utilisateur = new Utilisateur();
	    utilisateur.setMatricule( resultSet.getString( "matricule" ) );
	    utilisateur.setNom( resultSet.getString( "nom" ) );
	    utilisateur.setPrenom( resultSet.getString( "prenom" ) );
	    utilisateur.setEmail( resultSet.getString( "email" ) );
	    utilisateur.setFonction( resultSet.getString( "fonction" ) );
	    utilisateur.setTelephone( resultSet.getString( "telephone" ) );
	    return utilisateur;
	}
	

	 private  String SQL_SELECTM = "SELECT * FROM demanderIntervention where tdp='r' ";

	@Override
	public ListeMateriaux listerMateriaux(String s) throws DAOException 
	{
		switch(s)
		{
			case "Electricite":SQL_SELECTM = "SELECT * FROM Electricite"; break;
			case "Plomberie":SQL_SELECTM = "SELECT * FROM Plomberie"; break;
			case "Menuiserie":SQL_SELECTM = "SELECT * FROM Menuiserie"; break;
			case "Climatisation":SQL_SELECTM = "SELECT * FROM Climatisation"; break;
			case "Maçonnerie":SQL_SELECTM = "SELECT * FROM Maçonnerie"; break;
			case "Video-projecteur":SQL_SELECT = "SELECT * FROM VideoProjecteur"; break;
			
		}
		 Connection connexion = null;
	     PreparedStatement preparedStatement = null;
	     ListeMateriaux liste=new ListeMateriaux();
	     try 
	     {
	         /* Récupération d'une connexion depuis la Factory */
	         connexion = daoFactory.getConnection();
	         preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECTM, false );
	         ResultSet resultSet = preparedStatement.executeQuery();
	         /* Analyse du statut retourné par la requête d'insertion */
	         while(resultSet.next())
	         {
	        	 
	        	 liste.ajouterMateriel(mapMateriel(resultSet));
	         }
	     } catch ( SQLException e ) 
	     {
	         throw new DAOException( e );
	     } finally 
	     {
	         fermeturesSilencieuses(  preparedStatement, connexion );
	     }
	     return liste;
	}
	
	private static Materiel mapMateriel( ResultSet resultSet ) throws SQLException 
	{
		Materiel utilisateur = new Materiel();
	    utilisateur.setId( resultSet.getLong( "id" ) );
	    utilisateur.setNom( resultSet.getString( "nom" ) );
	    utilisateur.setQuantite( resultSet.getLong( "quantite" ) );
	    return utilisateur;
	}

}
