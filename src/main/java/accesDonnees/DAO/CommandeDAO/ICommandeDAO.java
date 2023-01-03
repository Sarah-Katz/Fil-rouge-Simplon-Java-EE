package accesDonnees.DAO.CommandeDAO;

import java.sql.Date;
import java.util.List;

import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;


public interface ICommandeDAO {
	public CommandeDO create(final Date date, final List<ProduitDO> listeprod, final double prix);

	public List<CommandeDO> findAll();

	public CommandeDO updateDate(final Date ancien_date, final Date nouveau_date);

	public CommandeDO updateProduit(final List<ProduitDO> ancien_produit, final List<ProduitDO> nouveau_produit);

	public CommandeDO updatePrix(final double ancien_prix, final double nouveau_prix);
	
	public void delete(final int id);
}