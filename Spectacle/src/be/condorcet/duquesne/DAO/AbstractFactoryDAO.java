package be.condorcet.duquesne.DAO;

import be.condorcet.duquesne.POJO.*;

import be.condorcet.duquesne.DAO.FactoryDAO;

/*donne une "interface" pour cr�er des"objets li�s ou d�pendants sans sp�cifier leurs classes concr�tes.*/

public abstract  class AbstractFactoryDAO 
{
	// Liste des types DAO support�s par l'appli, on peut aussi commencer a '1' 
	
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	// une m�thode pour chaque DAO qui peut �tre r�aliser 

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
