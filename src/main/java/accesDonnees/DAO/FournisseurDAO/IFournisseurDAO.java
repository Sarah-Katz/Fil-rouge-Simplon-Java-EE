package accesDonnees.DAO.FournisseurDAO;

import java.util.List;

import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public interface IFournisseurDAO {
	public FournisseurDO create(final String nom, final List<ProduitDO> produits);
	public List<FournisseurDO> findAll();
	public FournisseurDO update(final int id, final String nouveau_nom);
	//TODO update liste produit et changer les update en ID
	public void delete(final int id);
}
