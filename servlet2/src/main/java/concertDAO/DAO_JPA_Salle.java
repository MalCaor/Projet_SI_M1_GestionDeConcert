package concertDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import donnees.TSallesal;
import donnees.TSoireesor;

public class DAO_JPA_Salle extends DAO<TSallesal> {
    EntityManager emf;
    public DAO_JPA_Salle(String entity) throws DAOException {
        super();
        emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
    }

    @Override
    public TSallesal find(int id) throws DAOException {
    	TSallesal salle = emf.find(TSallesal.class, id);
        return salle;
    }
    
    public List<TSallesal> findAll() throws DAOException {
    	Query q = emf.createNamedQuery("TSallesal.findAll");
    	List<TSallesal> salles = q.getResultList();
        return salles;
    }

    public TSallesal findAgenda(int id) throws DAOException {
    	Query q = emf.createNamedQuery("TSallesal.findAgendaSalle");
    	q.setParameter("salId",id);
    	List<TSallesal> salle = q.getResultList();
        return salle.get(0);
    }

    @Override
    public void create(TSallesal data) throws DAOException {
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
    public void update(TSallesal data) throws DAOException {
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
    public void delete(TSallesal data) throws DAOException {
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