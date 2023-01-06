package accesDonnees.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@Column(name = "incomm")
	private boolean incomm;
	@ManyToOne
	private FournisseurDO fournisseur;

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
	public ProduitDO(String nom, String desc, String cate, int ref, double prix, FournisseurDO fournisseur) {
		this.nom = nom;
		this.description = desc;
		this.categorie = cate;
		this.ref = ref;
		this.prix = prix;
		this.fournisseur = fournisseur;
		this.incomm = false;
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

	public boolean isIncomm() {
		return incomm;
	}

	public void setIncomm(boolean incomm) {
		this.incomm = incomm;
	}

	public FournisseurDO getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurDO fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(idprod).append("|");
		sb.append(nom).append("|");
		sb.append(description).append("|");
		sb.append(categorie).append("|");
		sb.append(ref).append("|");
		sb.append(prix).append("|");
		sb.append(incomm);
//		sb.append(fournisseur.toString());
		return sb.toString();
	}
	
	public static ProduitDO fromString(String str) {
	    // Split the string into tokens
	    String[] tokens = str.split("\\|");
	    // Extract the values of the fields from the tokens
	    int idprod = Integer.parseInt(tokens[0]);
	    String nom = tokens[1];
	    String description = tokens[2];
	    String categorie = tokens[3];
	    int ref = Integer.parseInt(tokens[4]);
	    double prix = Double.parseDouble(tokens[5]);
	    boolean incomm = Boolean.parseBoolean(tokens[6]);
//	    FournisseurDO fournisseur = FournisseurDO.fromString(tokens[7]);
	    // Create and return a new ProduitDO object
	    return new ProduitDO(nom, description, categorie, ref, prix, null);
	}

}
