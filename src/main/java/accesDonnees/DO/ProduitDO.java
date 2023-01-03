package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Classe représentant un produit.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
@Entity
@Table(name = "produit")
@Data
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
