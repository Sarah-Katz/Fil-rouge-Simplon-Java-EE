package accesDonnees.DAO.ProduitDAO;

import java.util.List;

import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public interface IProduitDAO {
	public ProduitDO create(final String nom, final String desc, final String categorie, final int ref,
			final double prix);
	public List<ProduitDO> findAll();
	public ProduitDO findById(final int id);
	public List<ProduitDO> findByRef(final int ref);
	public List<ProduitDO> findByName(final String nom);
	public void delete(final int id);
	public ProduitDO updateNom(final int id, final String nouveau_nom);
	public ProduitDO updateDesc(final int id, final String nouveau_desc);
	public ProduitDO updatecate(final int id, final String nouveau_cate);
	public ProduitDO updateref(final int id, final int nouveau_ref);
	public ProduitDO updateprix(final int id, final double nouveau_prix);

}
