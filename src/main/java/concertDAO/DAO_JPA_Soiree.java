package concertDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import donnees.TSoireesor;

public class DAO_JPA_Soiree extends DAO<TSoireesor> {
    EntityManager emf;
    public DAO_JPA_Soiree(String entity) throws DAOException {
        super();
        emf=Persistence.createEntityManagerFactory(entity).createEntityManager();
    }

    @Override
    public TSoireesor find(int id) throws DAOException {
    	//TSoireesor soiree = emf.find(TSoireesor.class, id);
    	Query q = emf.createQuery("SELECT t FROM TSoireesor t WHERE t.sorId = :sorId");
    
    	q.setParameter("sorId",id);
    	List<TSoireesor> soirees=q.getResultList();
    	if(soirees.get(0).gettConcertconSet().size()==0) {
    		System.out.println("fuckezffz");
    	}else {
    		System.out.println("fuuuuuuuuuu");
    	}
    	return soirees.get(0) ;
    }
    

    public List<TSoireesor> findAll() throws DAOException {
    	Query q = emf.createNamedQuery("TSoireesor.findAll");
    	List<TSoireesor> soirees = q.getResultList();
        return soirees;
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