package concertDAO;

import donnees.TAdminadm;
import donnees.TArtisteart;
import donnees.TBilletbil;
import donnees.TConcertcon;
import donnees.TGestionnaireGst;
import donnees.TGroupeGrp;
import donnees.TSallesal;
import donnees.TSoireesor;

public class Concert_JPA_DAOFactory extends ConcertDAOFactory{


    private DAO_JPA_Admin daoAdmin = null;
    
    private DAO_JPA_Artiste daoArtiste = null;

    private DAO_JPA_Billet daoBillet = null;
    
    private DAO_JPA_Concert daoConcert= null;
    
    private DAO_JPA_Groupe daoGroupe = null;
    
    private DAO_JPA_Salle daoSalle = null;

    private DAO_JPA_Soiree daoSoiree = null;
    
    private DAO_JPA_Gestionnaire daoGestionnaire = null;
    

	@Override
	public DAO<TSoireesor> getDAOSoiree() throws DAOException {
		  if (daoSoiree == null) daoSoiree = new DAO_JPA_Soiree("concert");
	        return daoSoiree;
	}

	@Override
	public DAO<TConcertcon> getDAOConcert() throws DAOException {
		if (daoConcert == null) daoConcert = new DAO_JPA_Concert("concert");
        return daoConcert;
	}

	@Override
	public DAO<TSallesal> getDAOSalle() throws DAOException {
		if (daoSalle == null) daoSalle = new DAO_JPA_Salle("concert");
        return daoSalle;
	}

	@Override
	public DAO<TAdminadm> getDAOAdmin() throws DAOException {
		if (daoAdmin == null) daoAdmin = new DAO_JPA_Admin("concert");
        return daoAdmin;
	}

	@Override
	public DAO<TArtisteart> getDAOArtiste() throws DAOException {
		if (daoArtiste == null) daoArtiste = new DAO_JPA_Artiste("concert");
        return daoArtiste;
	}

	@Override
	public DAO<TBilletbil> getDAOBillet() throws DAOException {
		if (daoBillet == null) daoBillet = new DAO_JPA_Billet("concert");
        return daoBillet;
	}

	@Override
	public DAO<TGroupeGrp> getDAOGroupe() throws DAOException {
		if (daoGroupe == null) daoGroupe = new DAO_JPA_Groupe("concert");
        return daoGroupe;
	}

	@Override
	public DAO<TGestionnaireGst> getDAOGestionnaire() throws DAOException {
		if (daoGestionnaire == null) daoGestionnaire = new DAO_JPA_Gestionnaire("concert");
        return daoGestionnaire;
	}
}
