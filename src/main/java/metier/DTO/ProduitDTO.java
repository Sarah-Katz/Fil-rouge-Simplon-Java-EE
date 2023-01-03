package metier.DTO;

/**
 * Classe représentant un produit.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */
public class ProduitDTO {
	private int idprod;
	private String nom;
	private String description;
	private String categorie;
	private int ref;
	private double prix;

	public ProduitDTO() {
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
	public ProduitDTO(int id, String nom, String desc, String cate, int ref, double prix) {
		this.idprod = id;
		this.nom = nom;
		this.description = desc;
		this.categorie = cate;
		this.ref = ref;
		this.prix = prix;
	}

}
