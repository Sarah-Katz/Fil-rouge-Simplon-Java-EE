package accesDonnees.DAO.PanierDAO;

import java.util.List;

import accesDonnees.DO.ClientDO;
import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.PanierDO;

public interface IPanierDAO {
	public PanierDO create(final CommandeDO commande);

	public List<PanierDO> findAll();
	
	public List<PanierDO> findByCommande(final CommandeDO commande);

	public PanierDO updateCommande(final int id, final CommandeDO commande);

	public void delete(final int id);
}
