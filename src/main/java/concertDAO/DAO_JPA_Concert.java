package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.Concert;


public class DAO_JPA_Concert extends DAO<Concert>{
	EntityManager emf;
	public DAO_JPA_Concert(String entity) throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
	}

	@Override
	public 	Concert find(int id) throws DAOException {
		Concert concert = emf.find(Concert.class, id);
		return concert;
	}

	@Override
	public void create(Concert data) throws DAOException {
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
	public void update(Concert data) throws DAOException {
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
	public void delete(Concert data) throws DAOException {
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
