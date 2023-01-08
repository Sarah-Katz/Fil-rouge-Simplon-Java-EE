package metier.DTO;

import java.util.ArrayList;
import java.util.List;

import accesDonnees.DO.ProduitDO;

/**
 * Classe représentant un fournisseur.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */

public class FournisseurDTO {


		private int idfour;
		private String nom;
		private List<ProduitDO> produits = new ArrayList<>();

		public FournisseurDTO() {
		}

		/**
		 * Constructeur permettant de créer un nouveau fournisseur.
		 *
		 * @param nom le nom du fournisseur
		 */
		public FournisseurDTO(final int id, final String nom,final List<ProduitDO> produits) {
			this.idfour = id;
			this.nom = nom;
			this.produits = produits;
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

		public List<ProduitDO> getProduits() {
			return produits;
		}

		public void setProduits(List<ProduitDO> produits) {
			this.produits = produits;
		}



}
