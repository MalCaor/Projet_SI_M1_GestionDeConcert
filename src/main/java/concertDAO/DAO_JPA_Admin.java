package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.TAdminadm;

public class DAO_JPA_Admin extends DAO<TAdminadm>{
	EntityManager emf;
	public DAO_JPA_Admin(String entity) throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
	}

	@Override
	public TAdminadm find(int id) throws DAOException {
		TAdminadm admin = emf.find(TAdminadm.class, id);
		return admin;
	}

	@Override
	public void create(TAdminadm data) throws DAOException {
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
	public void update(TAdminadm data) throws DAOException {
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
	public void delete(TAdminadm data) throws DAOException {
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
