package ArtisteDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.TArtisteart;


public class DAO_JPA_Artiste extends DAO<TArtisteart>{
	EntityManager emf;
	public DAO_JPA_Artiste(String entity) throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
	}

	@Override
	public 	TArtisteart find(int id) throws DAOException {
		TArtisteart Artiste = emf.find(TArtisteart.class, id);
		return Artiste;
	}

	@Override
	public void create(TArtisteart data) throws DAOException {
		EntityTransaction trans=null;
		try {
			trans = emf.getTransaction();
			trans.begin();
			emf.persist(data);
			trans.commit();
		}
		catch(Exception e) {
			if(trans!=null)trans.rollback();
		}
	}

	@Override
	public void update(TArtisteart data) throws DAOException {
		EntityTransaction trans=null;
		try {
			trans = emf.getTransaction();
			trans.begin();
			emf.refresh(data);
			trans.commit();
		}
		catch(Exception e) {
			if(trans!=null)trans.rollback();
		}
	}

	@Override
	public void delete(TArtisteart data) throws DAOException {
		EntityTransaction trans=null;
		try {
			trans = emf.getTransaction();
			trans.begin();
			emf.remove(data);
			trans.commit();
		}
		catch(Exception e) {
			if(trans!=null)trans.rollback();
		}
	}
}