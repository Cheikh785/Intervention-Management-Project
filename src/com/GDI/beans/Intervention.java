package com.GDI.beans;

import java.sql.Timestamp;

public class Intervention 
{
	private Long id;
	private String matricule;
	private String tdp;
	private String cdd;
	private String service;
	private String priorite;
	private Timestamp date;
	private String statut;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public String getCdd() {
		return cdd;
	}
	public void setCdd(String cdd) {
		this.cdd = cdd;
	}
	public String getTdp() {
		return tdp;
	}
	public void setTdp(String tdp) {
		this.tdp = tdp;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
}
