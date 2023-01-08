package accesDonnees.DAO.CommandeDAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;


public class CommandeDAOimpl implements ICommandeDAO {

	@Override
	public CommandeDO create(final Date date, final List<ProduitDO> listeprod) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		CommandeDO commande = new CommandeDO(date, listeprod);
		em.persist(commande);
		em.getTransaction().commit();
		return commande;
	}

	@Override
	public List<CommandeDO> findAll() {
		EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<CommandeDO> list = em.createQuery("SELECT c FROM CommandeDO c").getResultList();
		return list;
	}

	@Override
	public CommandeDO findById(final int id) {
        final EntityManager em = Util.JPA.getEntityManager();
        CommandeDO comm = (CommandeDO) em.createQuery("SELECT c FROM CommandeDO c WHERE c.idcomm = :id")
                .setParameter("id", id).getSingleResult();
        return comm;
    }

	@Override
	public CommandeDO updateDate(final int id, final Date nouveau_date) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.idcomm =:id");
		query.setParameter("id", id);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setDate(nouveau_date);
		em.getTransaction().commit();
		return commande;
	}

	@Override
	public CommandeDO updateProduit(final int id, final List<ProduitDO> nouveau_produit) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.idcomm = :id");
		query.setParameter("id", id);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setListeprod(nouveau_produit);
		em.getTransaction().commit();
		return commande;
	}

	public CommandeDO updateActive(final int id, final boolean active) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.idcomm = :id");
		query.setParameter("id", id);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setActive(active);
		em.getTransaction().commit();
		return commande;
	}

	@Override
	public void delete(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		CommandeDO commande = (CommandeDO) em.createQuery("SELECT c FROM CommandeDO c WHERE c.id = '" + id + "'")
				.getSingleResult();
		em.remove(commande);
		em.getTransaction().commit();
	}

}
