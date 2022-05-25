package com.GDI.gestionpole;

import java.util.HashMap;
import java.util.Map;

import com.GDI.beans.Intervention;

public class ListeIntervention 
{
	private  Map<Long,Intervention>listeIntervention=new HashMap<Long,Intervention>();

	public Map<Long,Intervention> getListeIntervention() {
		return listeIntervention;
	}

	public static void setListeIntervention(Map<Long,Intervention> listeIntervention) {
		listeIntervention = listeIntervention;
	}
	
	public void ajouterIntervention(Intervention value)
	{
		listeIntervention.put(value.getId(), value);
	}
	
	public boolean estDans(Intervention intervention)
	{
		if(listeIntervention.containsValue(intervention))
			return true;
		return false;
	}
	
	public void supprimerIntervention(Intervention intervention)
	{
	
	}
}
