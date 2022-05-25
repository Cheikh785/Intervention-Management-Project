package com.GDI.gestionpole;

import java.util.HashMap;
import java.util.Map;

import com.GDI.beans.Utilisateur;

public class ListeUtilisateurs 
{
	private static Map<String,Utilisateur>listeUtilisateur=new HashMap<String,Utilisateur>();

	public  Map<String,Utilisateur> getListeUtilisateur() 
	{
		return listeUtilisateur;
	}

	public  void setListeUtilisateur(Map<String,Utilisateur> listeUtilisateur) 
	{
		ListeUtilisateurs.listeUtilisateur = listeUtilisateur;
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur)
	{
		if(!listeUtilisateur.containsValue(utilisateur))
			listeUtilisateur.put(utilisateur.getMatricule(), utilisateur);
	}

}
