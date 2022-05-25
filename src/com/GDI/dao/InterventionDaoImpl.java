package com.GDI.dao;

import static com.GDI.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.GDI.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.GDI.beans.Intervention;

public class InterventionDaoImpl implements InterventionDao 
{
	 private DAOFactory          daoFactory;

	 InterventionDaoImpl( DAOFactory daoFactory ) 
	 {
		 this.daoFactory = daoFactory;
	 }
	 
	 private static final String SQL_INSERT = "INSERT INTO demanderIntervention (matricule,tdp,cdd,priorite,service,dateDemande,statut) VALUES (?, ?,?,?,?,NOW(),'a faire')";
	 
	@Override
	public void creer(Intervention intervention) throws DAOException
	{
		 Connection connexion = null;
	     PreparedStatement preparedStatement = null;
	     ResultSet valeursAutoGenerees=null;

	     try 
	     {
	         /* Récupération d'une connexion depuis la Factory */
	         connexion = daoFactory.getConnection();
	         preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, intervention.getMatricule(), intervention.getTdp(),intervention.getCdd(),intervention.getPriorite(),intervention.getService() );
	         int statut = preparedStatement.executeUpdate();
	         /* Analyse du statut retourné par la requête d'insertion */
	         if ( statut == 0 ) 
	         {
	             throw new DAOException( "Échec de la création de la demande, aucune ligne ajoutée dans la table." );
	         }
	         /* Récupération de l'id auto-généré par la requête d'insertion */
	         valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	         if ( valeursAutoGenerees.next() ) 
	         {
	             /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	             intervention.setId( valeursAutoGenerees.getLong( 1 ) );
	         } else 
	         {
	             throw new DAOException( "Échec de la création de la demande en base, aucun ID auto-généré retourné." );
	         }
	         
	     } catch ( SQLException e ) 
	     {
	         throw new DAOException( e );
	     } finally 
	     {
	         fermeturesSilencieuses(  valeursAutoGenerees,preparedStatement, connexion );
	     }
	}

	private static final String SQL_SELECT_PAR_MATRICULE = "SELECT * FROM demanderintervention WHERE matricule = ?";

	@Override
	public Intervention trouver(String matricule) throws DAOException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
