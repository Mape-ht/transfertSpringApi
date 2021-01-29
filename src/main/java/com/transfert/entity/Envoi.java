package com.transfert.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Envoi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float montant;
	private String date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emetteur_id", nullable = false)
	private Emetteur emetteur;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recepteur_id", nullable = false)
	private Recepteur recepteur;
	
	
	public Envoi() {
		}
	
	public Envoi(float montant, String date, Emetteur emetteur, Recepteur recepteur) {
		
		this.montant = montant;
		this.date = date;
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Emetteur getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Emetteur emetteur) {
		this.emetteur = emetteur;
	}
	public Recepteur getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(Recepteur recepteur) {
		this.recepteur = recepteur;
	}
	
	
	
	
	
	
}
