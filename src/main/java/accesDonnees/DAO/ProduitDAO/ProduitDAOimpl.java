package accesDonnees.DAO.ProduitDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import accesDonnees.DO.ProduitDO;

public class ProduitDAOimpl implements IProduitDAO {

	public ProduitDO create(final String nom, final String desc, final String categorie, final int ref,
			final double prix) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		ProduitDO produit = new ProduitDO(nom, desc, categorie, ref, prix);
		em.persist(produit);
		em.getTransaction().commit();
		return produit;
	}

	public List<ProduitDO> findAll() {
		EntityManager em = Util.JPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<ProduitDO> list = (List<ProduitDO>) em.createQuery("SELECT p FROM ProduitDO p").getResultList();
		return list;
	}

	public List<ProduitDO> findByName(final String nom) {
		EntityManager em = Util.JPA.getEntityManager();
		Query query = em.createQuery("SELECT p FROM ProduitDO p where p.nom LIKE :nom");
		query.setParameter("nom", "%"+nom+"%");
		@SuppressWarnings("unchecked")
		List<ProduitDO> list = query.getResultList();
		return list;
	}
	
	public void delete(final int id) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		ProduitDO produit = (ProduitDO) em.createQuery("SELECT p FROM ProduitDO p WHERE p.id = '" + id + "'")
				.getSingleResult();
		em.remove(produit);
		em.getTransaction().commit();
	}

	public ProduitDO updateNom(final String ancien_nom, final String nouveau_nom) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.nom =:nom");
		query.setParameter("nom", ancien_nom);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setNom(nouveau_nom);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateDesc(final String ancien_desc, final String nouveau_desc) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.description =:description");
		query.setParameter("description", ancien_desc);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setDescription(nouveau_desc);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updatecate(final String ancien_cate, final String nouveau_cate) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.categorie =:categorie");
		query.setParameter("categorie", ancien_cate);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setCategorie(nouveau_cate);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateref(final int ancien_ref, final int nouveau_ref) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.ref =:ref");
		query.setParameter("ref", ancien_ref);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setRef(nouveau_ref);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

	public ProduitDO updateprix(final double ancien_prix, final double nouveau_prix) {
		EntityManager em = Util.JPA.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p from ProduitDO p where p.prix =:prix");
		query.setParameter("prix", ancien_prix);
		ProduitDO produit = (ProduitDO) query.getSingleResult();
		produit.setPrix(nouveau_prix);
		em.merge(produit);
		em.getTransaction().commit();
		return produit;
	}

}
