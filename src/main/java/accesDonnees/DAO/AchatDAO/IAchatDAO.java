package accesDonnees.DAO.AchatDAO;

import java.sql.Date;
import java.util.List;

import accesDonnees.DO.AchatDO; 
import accesDonnees.DO.ProduitDO;

public interface IAchatDAO {
	public AchatDO create(final Date dateachat, final List<ProduitDO> listeprod);

	public List<AchatDO> findAll();

	public List<AchatDO> findByRef(final int ref);

	public AchatDO updateDateachat(final int id, final Date dateachat);

	public AchatDO updateListeprod(final int id, final List<ProduitDO> listeprod);

	public AchatDO updateactive(final int id, final boolean active);

	public void delete(final int id);
}
