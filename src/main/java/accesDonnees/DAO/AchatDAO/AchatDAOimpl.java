package accesDonnees.DAO.AchatDAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.AchatDO;
import accesDonnees.DO.ProduitDO;

public class AchatDAOimpl implements IAchatDAO {

	@Override
	public AchatDO create(final Date dateachat, final List<ProduitDO> listeprod) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		AchatDO achat = new AchatDO(dateachat, listeprod);
		em.persist(achat);
		em.getTransaction().commit();
		return achat;
	}

	@Override
	public List<AchatDO> findAll() {
		final EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<AchatDO> list = em.createQuery("SELECT a FROM AchatDO a").getResultList();
		return list;
	}

	@Override
	public AchatDO findById(final int id) {
		final EntityManager em = Util.JPA.getEntityManager();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.idachat = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		return achat;
	}

	@Override
	public AchatDO updateDateachat(final int id, final Date dateachat) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.idachat = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setDateachat(dateachat);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}

	@Override
	public AchatDO updateListeprod(final int id, final List<ProduitDO> listeprod) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.idachat = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setListeprod(listeprod);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}

	@Override
	public AchatDO updateactive(final int id, final boolean active) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final Query query = em.createQuery("SELECT a FROM AchatDO a WHERE a.idachat = :id");
		query.setParameter("id", id);
		final AchatDO achat = (AchatDO) query.getSingleResult();
		achat.setActive(active);
		em.merge(achat);
		em.getTransaction().commit();
		return achat;
	}


	@Override
	public void delete(final int id) {
		final EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		final AchatDO produit = (AchatDO) em.createQuery("SELECT a FROM AchatDO a WHERE a.idachat = '" + id + "'")
				.getSingleResult();
		em.remove(produit);
		em.getTransaction().commit();
	}
}
