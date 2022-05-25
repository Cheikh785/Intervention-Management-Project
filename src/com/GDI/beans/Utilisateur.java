package com.GDI.beans;

public class Utilisateur 
{
	private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
    private String telephone;
    private String vue;

    public void setMatricule(String matricule) 
    {
    	this.matricule = matricule;
    }
    public String getMatricule() 
    {
    	return matricule;
    }

    public void setNom(String nom) 
    {
    	this.nom = nom;
    }
    public String getNom() 
    {
    	return nom;
    }
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getFonction() 
	{
		return fonction;
	}
	public void setFonction(String fonction) 
	{
		this.fonction = fonction;
	}
	public String getPrenom() 
	{
		return prenom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
	public String getVue() {
		return vue;
	}
	public void setVue(String vue) {
		this.vue = vue;
	}
}
