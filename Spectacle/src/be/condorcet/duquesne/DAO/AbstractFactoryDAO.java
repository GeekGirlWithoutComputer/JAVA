package be.condorcet.duquesne.DAO;

import be.condorcet.duquesne.POJO.*;

import be.condorcet.duquesne.DAO.FactoryDAO;

/*donne une "interface" pour créer des"objets liés ou dépendants sans spécifier leurs classes concrètes.*/

public abstract  class AbstractFactoryDAO 
{
	// Liste des types DAO supportés par l'appli, on peut aussi commencer a '1' 
	
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	// une méthode pour chaque DAO qui peut être réaliser 

	public abstract DAO<Reservation> getReservationDAO();

	public abstract DAO<Categorie> getCategorieDAO();

	public abstract PersonneDAO getPersonneDAO();

	public abstract DAO<PlanningSalle> getPlanningSalleDAO();

	public abstract DAO<Representation> getRepresentationDAO();

	public abstract DAO<Spectacle> getSpectacleDAO();

	public abstract DAO<Configuration> getConfigurationDAO();

	public abstract DAO<Commande> getCommandeDAO();

	public abstract DAO<Place> getPlaceDAO();

	public static AbstractFactoryDAO getFactory(int type) 
	{
		switch (type) 
		{
		case DAO_FACTORY:
			return new FactoryDAO();
		case XML_DAO_FACTORY:
//	        return new XMLDAOFactory(); ici y en pas pas 
		default:
			return null;
		}
	}

	
}
