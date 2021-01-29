package com.transfert.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recepteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String telephone;
	@OneToMany(mappedBy = "recepteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Envoi> envois;
	
	public Recepteur() {
		}
	
	public Recepteur(String nom, String prenom, String telephone, List<Envoi> envois) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.envois = envois;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Envoi> getEnvois() {
		return envois;
	}
	public void setEnvois(List<Envoi> envois) {
		this.envois = envois;
	}

}
