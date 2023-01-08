package accesDonnees.DAO.ClientDAO;

import java.util.List;

import javax.persistence.EntityManager;

import accesDonnees.DO.ClientDO;
import accesDonnees.DO.PanierDO;

public class ClientDAOimpl implements IClientDAO {
	final static EntityManager EM = Util.JPA.getEntityManager();

	public ClientDO create(final String nom, final String prenom, final String adresse, final int tel,
			final String mail, final PanierDO panier) {
		EM.getTransaction().begin();
		final ClientDO client = new ClientDO(nom, prenom, adresse, tel, mail, panier);
		EM.persist(client);
		EM.getTransaction().commit();
		return client;
	}

	public List<ClientDO> findAll() {
		@SuppressWarnings("unchecked")
		List<ClientDO> list = EM.createQuery("SELECT c FROM ClientDO c").getResultList();
		return list;
	}

	public ClientDO findByMail(final String mail) {
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.mail = :mail").setParameter("mail", mail)
				.getSingleResult();
		return client;
	}

	public ClientDO updateNom(final int id, final String nom) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setNom(nom);
		EM.getTransaction().commit();
		return client;
	}

	public ClientDO updatePrenom(final int id, final String prenom) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setPrenom(prenom);
		EM.getTransaction().commit();
		return client;
	}

	public ClientDO updateAdresse(final int id, final String adresse) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setAdresse(adresse);
		EM.getTransaction().commit();
		return client;
	}

	public ClientDO updateTel(final int id, final int tel) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setTel(tel);
		EM.getTransaction().commit();
		return client;
	}

	public ClientDO updateMail(final int id, final String mail) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setMail(mail);
		EM.getTransaction().commit();
		return client;
	}

	public ClientDO updatePanier(final int id, final PanierDO panier) {
		EM.getTransaction().begin();
		ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id").setParameter("id", id)
				.getSingleResult();
		client.setPanier(panier);
		EM.getTransaction().commit();
		return client;
	}

	public void delete(final int id) {
		EM.getTransaction().begin();
		final ClientDO client = (ClientDO) EM.createQuery("SELECT c FROM ClientDO c WHERE c.id = :id")
				.setParameter("id", id).getSingleResult();
		EM.remove(client);
		EM.getTransaction().commit();
	}
}
