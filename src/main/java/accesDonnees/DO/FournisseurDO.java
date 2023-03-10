package accesDonnees.DO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Util.IntegerListConverter;

/**
 * Classe représentant un fournisseur.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "fournisseur")
public class FournisseurDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfour")
	private int idfour;
	@Column(name = "nomfour")
	private String nom;
	@Convert(converter = IntegerListConverter.class)
	@Column(name = "reflist")
	private List<Integer> reflist = new ArrayList<>();

	public FournisseurDO() {
	}

	/**
	 * Constructeur permettant de créer un nouveau fournisseur.
	 *
	 * @param nom      le nom du fournisseur
	 * @param produits la liste des produits vendus par le fournisseur
	 */
	public FournisseurDO(final String nom, final List<Integer> reflist) {
		this.nom = nom;
		this.reflist = reflist;
	}

	public int getIdfour() {
		return idfour;
	}

	public void setIdfour(int idfour) {
		this.idfour = idfour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Integer> getReflist() {
		return reflist;
	}

	public void setReflist(List<Integer> reflist) {
		this.reflist = reflist;
	}

}