package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.Salle;

public class DAO_JPA_Salle extends DAO<Salle> {
    EntityManager emf;
    public DAO_JPA_Salle() throws DAOException {
        super();
        emf=Persistence.createEntityManagerFactory("salle").createEntityManager();
    }

    @Override
    public Salle find(int id) throws DAOException {
        Salle salle = emf.find(Salle.class, id);
        return salle;
    }

    @Override
    public void create(Salle data) throws DAOException {
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
    public void update(Salle data) throws DAOException {
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
    public void delete(Salle data) throws DAOException {
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
