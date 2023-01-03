package accesDonnees.DAO.AchatDAO;

import java.sql.Date;
import java.util.List;

import accesDonnees.DO.AchatDO;
import accesDonnees.DO.FournisseurDO;
import accesDonnees.DO.ProduitDO;

public interface IAchatDAO {
	public AchatDO create(final Date dateachat, final int quanachat, final double prix, final ProduitDO produit,
			final FournisseurDO fournisseur);
	public List<AchatDO> findAll();
	public List<AchatDO> findByRef(final int ref);
	public AchatDO updateDateachat (final int id, final Date dateachat);
	public AchatDO updateQuanachat (final int id, final int quanachat);
	public AchatDO updatePrix (final int id, final double prix);
	public AchatDO updateProduit (final int id, final ProduitDO produit);
	public AchatDO updateFournisseur (final int id, final FournisseurDO fournisseur);
	public void delete (final int id);
}
