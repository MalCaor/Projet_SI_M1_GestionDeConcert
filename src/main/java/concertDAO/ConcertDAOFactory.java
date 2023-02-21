package concertDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


import donnees.TAdminadm;
import donnees.TArtisteart;
import donnees.TBilletbil;
import donnees.TConcertcon;
import donnees.TGestionnaireGst;
import donnees.TGroupeGrp;
import donnees.TSallesal;
import donnees.TSoireesor;

/**
 * Fabrique abstraite de DAO pour le sch�ma concert
 * @author Eric
 */
public abstract class ConcertDAOFactory {
    

    public abstract DAO<TSoireesor> getDAOSoiree() throws DAOException;

    public abstract DAO<TConcertcon> getDAOConcert() throws DAOException;
    
    public abstract DAO<TSallesal> getDAOSalle() throws DAOException;
    
    public abstract DAO<TAdminadm> getDAOAdmin() throws DAOException;
    
    public abstract DAO<TArtisteart> getDAOArtiste() throws DAOException;
    
    public abstract DAO<TBilletbil> getDAOBillet() throws DAOException;
    
    public abstract DAO<TGroupeGrp> getDAOGroupe() throws DAOException;
    
    public abstract DAO<TGestionnaireGst> getDAOGestionnaire() throws DAOException;
    
    public static EntityManager getEntiteManager() {
		return Persistence.createEntityManagerFactory("concert").createEntityManager();
    }
}
