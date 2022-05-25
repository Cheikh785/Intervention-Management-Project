package com.GDI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.GDI.dao.DAOUtilitaire.*;

import com.GDI.beans.Inscrit;
import com.GDI.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao 
{
	 private DAOFactory          daoFactory;

	 UtilisateurDaoImpl( DAOFactory daoFactory ) 
	 {
		 this.daoFactory = daoFactory;
	 }

	
	 private static final String SQL_INSERT = "INSERT INTO inscrits (matricule,motDePasse) VALUES (?, ?)";

	 /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
	 @Override
	 public void creer( Inscrit utilisateur ) throws DAOException 
	 {
	     Connection connexion = null;
	     PreparedStatement preparedStatement = null;

	     try 
	     {
	         /* Récupération d'une connexion depuis la Factory */
	         connexion = daoFactory.getConnection();
	         preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, false, utilisateur.getMatricule(), utilisateur.getMotDePasse() );
	         int statut = preparedStatement.executeUpdate();
	         /* Analyse du statut retourné par la requête d'insertion */
	         if ( statut == 0 ) 
	         {
	             throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	         }
	         
	     } catch ( SQLException e ) 
	     {
	         throw new DAOException( e );
	     } finally 
	     {
	         fermeturesSilencieuses(  preparedStatement, connexion );
	     }
	 }
	 
	 
	private static final String SQL_SELECT_PAR_MATRICULE = "SELECT matricule, motDePasse FROM inscrits WHERE matricule = ?";

	/* Implémentation de la méthode définie dans l'interface UtilisateurDao */
	@Override
	public Inscrit trouver( String matricule ) throws DAOException 
	{
		
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Inscrit utilisateur = null;

	    try 
	    {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_MATRICULE, false, matricule );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) 
	        {
	            utilisateur = map( resultSet );
	        }
	    } catch ( SQLException e ) 
	    {
	        throw new DAOException( e );
	    } finally 
	    {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return utilisateur;
	}
	
	
	
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static Inscrit map( ResultSet resultSet ) throws SQLException 
	{
		Inscrit utilisateur = new Inscrit();
	    utilisateur.setMatricule( resultSet.getString( "matricule" ) );
	    utilisateur.setMotDePasse( resultSet.getString( "motDePasse" ) );
	    return utilisateur;
	}
	
	


	private static final String SQL_SELECT_PAR_MATRICULE_BIS = "SELECT * FROM utilisateurs WHERE matricule = ?";


	@Override
	public Utilisateur trouverUtilisateur(String matricule) throws DAOException 
	{
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Utilisateur utilisateur = null;

	    try 
	    {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_MATRICULE_BIS, false, matricule );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) 
	        {
	            utilisateur = mapUtilisateur( resultSet );
	        }
	    } catch ( SQLException e ) 
	    {
	        throw new DAOException( e );
	    } finally 
	    {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return utilisateur;
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

}

