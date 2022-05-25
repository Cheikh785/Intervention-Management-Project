package com.GDI.dao;

import com.GDI.gestionpole.ListeIntervention;
import com.GDI.gestionpole.ListeMateriaux;
import com.GDI.gestionpole.ListeUtilisateurs;

public interface ChefDePoleDao 
{
	ListeIntervention listerIntervention(String s)throws DAOException;
	ListeUtilisateurs listerUtilisateur()throws DAOException;
	ListeMateriaux listerMateriaux(String s)throws DAOException;
}
