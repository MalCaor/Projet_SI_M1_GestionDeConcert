package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import donnees.Gestionnaire;

public class DAO_JPA_Gestionnaire extends DAO<Gestionnaire> {
    EntityManager emf;
	public DAO_JPA_Gestionnaire() throws DAOException {
		super();
		emf=Persistence.createEntityManagerFactory("gestionnaire").createEntityManager();
	}


    @Override
    public Gestionnaire find(int id) throws DAOException {
        Gestionnaire gestionnaire = emf.find(Gestionnaire.class, id);
        return gestionnaire;
    }

    @Override
    public void create(Gestionnaire data) throws DAOException {
        EntityTransaction trans=null;
        try {
            trans = emf.getTransaction();
            trans.begin();
            emf.persist(data);
            trans.commit();
        } catch (Exception e) {
            if(trans!=null)trans.rollback();
        }
    }

    @Override
    public void update(Gestionnaire data) throws DAOException {
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
    public void delete(Gestionnaire data) throws DAOException {
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
