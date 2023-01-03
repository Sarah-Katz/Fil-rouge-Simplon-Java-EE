package accesDonnees.DAO.CommandeDAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.CommandeDO;
import accesDonnees.DO.ProduitDO;


public class CommandeDAOimpl implements ICommandeDAO {

	public CommandeDO create(final Date date, final List<ProduitDO> listeprod, final double prix) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		CommandeDO commande = new CommandeDO(date, listeprod, prix);
		em.persist(commande);
		em.getTransaction().commit();
		return commande;
	}

	public List<CommandeDO> findAll() {
		EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<CommandeDO> list = (List<CommandeDO>) em.createQuery("SELECT c FROM CommandeDO c").getResultList();
		return list;
	}

	public CommandeDO updateDate(final Date ancien_date, final Date nouveau_date) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.date =:date");
		query.setParameter("date", ancien_date);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setDate(nouveau_date);
		em.getTransaction().commit();
		return commande;
	}

	public CommandeDO updateProduit(final List<ProduitDO> ancien_produit, final List<ProduitDO> nouveau_produit) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.commande =:commande");
		query.setParameter("commande", ancien_produit);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setListeprod(nouveau_produit);
		em.getTransaction().commit();
		return commande;
	}

	public CommandeDO updatePrix(final double ancien_prix, final double nouveau_prix) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c from CommandeDO c where c.prix =:prix");
		query.setParameter("prix", ancien_prix);
		CommandeDO commande = (CommandeDO) query.getSingleResult();
		commande.setPrix(nouveau_prix);
		em.getTransaction().commit();
		return commande;
	}

	public void delete(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		CommandeDO commande = (CommandeDO) em.createQuery("SELECT c FROM CommandeDO c WHERE c.id = '" + id + "'")
				.getSingleResult();
		em.remove(commande);
		em.getTransaction().commit();
	}

}
