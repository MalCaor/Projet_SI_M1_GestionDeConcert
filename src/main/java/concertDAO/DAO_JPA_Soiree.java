package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import donnees.TSoireesor;

public class DAO_JPA_Soiree extends DAO<TSoireesor> {
    EntityManager emf;
    public DAO_JPA_Soiree(String entity) throws DAOException {
        super();
        emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
    }

    @Override
    public TSoireesor find(int id) throws DAOException {
    	TSoireesor soiree = emf.find(TSoireesor.class, id);
        return soiree;
    }

    @Override
    public void create(TSoireesor data) throws DAOException {
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
    public void update(TSoireesor data) throws DAOException {
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
    public void delete(TSoireesor data) throws DAOException {
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