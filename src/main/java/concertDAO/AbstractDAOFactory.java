package concertDAO;

/**
 * Fabrique renvoyant une fabrique de DAO en fonction du support de persistance choisi.
 * @author Eric
 */
public class AbstractDAOFactory {

	/**
	 * Renvoie la fabrique concr�te de DAO en fonction du support de persistance.
	 * @param type le support de persistance � utiliser
	 * @return la fabrique de DAO pour ce type de persistance
	 */
    public static ConcertDAOFactory getDAOFactory(PersistenceKind type) {
    	if(type.equals(PersistenceKind.JPA)){
        	 return new Concert_JPA_DAOFactory();
        }else {
            return null;
        }
    }
}
