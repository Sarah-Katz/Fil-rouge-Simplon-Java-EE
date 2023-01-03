package metier.DTO;

/**
 * Classe représentant un fournisseur.
 *
 * @author Sarah Katz and Thomas Baudrin
 *
 */

public class FournisseurDTO {
	
	
		private int idfour;
		private String nom;

		public FournisseurDTO() {
		}

		/**
		 * Constructeur permettant de créer un nouveau fournisseur.
		 *
		 * @param nom le nom du fournisseur
		 */
		public FournisseurDTO(final int id, final String nom) {
			this.idfour = id;
			this.nom = nom;
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

}
