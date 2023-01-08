package accesDonnees.DAO.CommandeDAO;

import java.sql.Date;
import java.util.List;

import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;


public interface ICommandeDAO {
	public CommandeDO create(final Date date, final List<ProduitDO> listeprod);

	public List<CommandeDO> findAll();
	
	public List<CommandeDO> findById();

	public CommandeDO updateDate(final int id, final Date nouveau_date);

	public CommandeDO updateProduit(final int id, final List<ProduitDO> nouveau_produit);
	
	public void delete(final int id);
}
