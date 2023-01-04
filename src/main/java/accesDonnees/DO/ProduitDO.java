package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant un produit.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "produit")
public class ProduitDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprod")
	private int idprod;
	@Column(name = "nomprod")
	private String nom;
	@Column(name = "descprod")
	private String description;
	@Column(name = "cateprod")
	private String categorie;
	@Column(name = "ref")
	private int ref;
	@Column(name = "prix")
	private double prix;

	public ProduitDO() {
	}

	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Constructeur permettant de créer un produit avec tous ses attributs.
	 *
	 * @param nom  le nom du produit
	 * @param desc la description du produit
	 * @param cate la catégorie du produit
	 * @param ref  la référence du produit
	 * @param prix le prix du produit
	 */
	public ProduitDO(String nom, String desc, String cate, int ref, double prix) {
		this.nom = nom;
		this.description = desc;
		this.categorie = cate;
		this.ref = ref;
		this.prix = prix;
	}

}
