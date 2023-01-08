package accesDonnees.DAO.FournisseurDAO;

import java.util.List;

import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public interface IFournisseurDAO {
	public FournisseurDO create(final String nom, final List<ProduitDO> produits);
	public List<FournisseurDO> findAll();
	public FournisseurDO updateNom(final int id, final String nouveau_nom);
	public FournisseurDO updateProduits(final int id, final List<ProduitDO> produits);
	public void delete(final int id);
}
