package be.condorcet.duquesne.DAO;

import java.sql.Connection;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.PlanningSalle;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Reservation;
import be.condorcet.duquesne.POJO.Spectacle;
public class FactoryDAO  extends AbstractFactoryDAO

{
	protected static final Connection conn = be.condorcet.duquesne.DATA.Connect.getInstance();
		

	
	@Override
	public PersonneDAO getPersonneDAO() 
	{
		return new PersonneDAO(conn);
	}
	@Override
	public DAO<Reservation> getReservationDAO()
	{
		return new ReservationDAO(conn);
	}
	@Override
	public DAO<Categorie> getCategorieDAO()
	{
		
		return new CategorieDAO (conn);
		
	}
	@Override
	public DAO<PlanningSalle> getPlanningSalleDAO() 
	{
		return new PlanningSalleDAO(conn);
		}
	@Override
	public DAO<Representation> getRepresentationDAO() 
	{
		return new RepresentationDAO(conn);
		
	}
	@Override
	public DAO<Spectacle> getSpectacleDAO() 
	{
		return new SpectacleDAO(conn);
	}
	@Override
	public DAO<Configuration> getConfigurationDAO() 
	{
		return new ConfigurationDAO(conn);
	}
	@Override
	public DAO<Commande> getCommandeDAO() 
	{
		return new CommandeDAO(conn);
	}
	@Override
	public DAO<Place> getPlaceDAO() 
	{
		
		return new PlaceDAO(conn);
	}


}
