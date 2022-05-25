package com.GDI.dao;

import java.util.Map;

import com.GDI.beans.Intervention;

public interface InterventionDao 
{
    void creer( Intervention intervention ) throws DAOException;
    Intervention trouver( String matricule ) throws DAOException;
   
}
