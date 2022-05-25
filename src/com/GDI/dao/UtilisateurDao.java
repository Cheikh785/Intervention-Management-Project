package com.GDI.dao;

import java.util.Map;

import com.GDI.beans.Inscrit;
import com.GDI.beans.Utilisateur;

public interface UtilisateurDao 
{

    void creer( Inscrit utilisateur ) throws DAOException;

    Inscrit trouver( String matricule ) throws DAOException;
    Utilisateur trouverUtilisateur( String matricule ) throws DAOException;
    
}