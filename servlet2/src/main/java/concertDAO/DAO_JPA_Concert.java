package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import donnees.TConcertcon;


public class DAO_JPA_Concert extends DAO<TConcertcon>{
	EntityManager emf;
	public DAO_JPA_Concert(String entity) throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
	}

	@Override
	public 	TConcertcon find(int id) throws DAOException {
		TConcertcon concert = emf.find(TConcertcon.class, id);
		return concert;
	}

	@Override
	public void create(TConcertcon data) throws DAOException {
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
	public void update(TConcertcon data) throws DAOException {
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
	public void delete(TConcertcon data) throws DAOException {
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
