package GroupeDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.TGroupeGrp;


public class DAO_JPA_Groupe extends DAO<TGroupeGrp>{
	EntityManager emf;
	public DAO_JPA_Groupe(String entity) throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
	}

	@Override
	public 	TGroupeGrp find(int id) throws DAOException {
		TGroupeGrp Groupe = emf.find(TGroupeGrp.class, id);
		return Groupe;
	}

	@Override
	public void create(TGroupeGrp data) throws DAOException {
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
	public void update(TGroupeGrp data) throws DAOException {
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
	public void delete(TGroupeGrp data) throws DAOException {
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