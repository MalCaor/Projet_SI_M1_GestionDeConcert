package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.Billet;

public class DAO_JPA_Billet extends DAO<Billet>{
	EntityManager emf;
	public DAO_JPA_Billet() throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory("concert").createEntityManager();
	}

	@Override
	public Billet find(int id) throws DAOException {
		Billet billet = emf.find(Billet.class, id);
		return billet;
	}

	@Override
	public void create(Billet data) throws DAOException {
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
	public void update(Billet data) throws DAOException {
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
	public void delete(Billet data) throws DAOException {
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
