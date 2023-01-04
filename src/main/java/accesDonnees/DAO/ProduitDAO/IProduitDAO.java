package accesDonnees.DAO.ProduitDAO;

import java.util.List;

import accesDonnees.DO.ProduitDO;

public interface IProduitDAO {
	public ProduitDO create(final String nom, final String desc, final String categorie, final int ref,
			final double prix);
	public List<ProduitDO> findAll();
	public ProduitDO findById(final int id);
	public List<ProduitDO> findByName(final String nom);
	public void delete(final int id);
	public ProduitDO updateNom(final String ancien_nom, final String nouveau_nom);
	public ProduitDO updateDesc(final String ancien_desc, final String nouveau_desc);
	public ProduitDO updatecate(final String ancien_cate, final String nouveau_cate);
	public ProduitDO updateref(final int ancien_ref, final int nouveau_ref);
	public ProduitDO updateprix(final double ancien_prix, final double nouveau_prix);

}
