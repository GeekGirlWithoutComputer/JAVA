package be.condorcet.duquesne.DAO;

import java.sql.SQLException;
import java.util.List;

import be.condorcet.duquesne.POJO.Spectacle;

// les methodes crud  --> creer, lire , maj, effacer
public interface  DAO<T> 
{
	public  boolean create(T obj);
	/****************************************************************************************************
	 * 
	 * 
	 * 		IMPOSSIBLE DE CREER UNE COMMANDE SANS ID PERSONNE 
	 * 		IMPOSSIBLE DE CREER UNE PLACE SANS ID COMMANDE 
	 * 		ET COMME PAS DE DOUBLE SENS J AI PAS LE CHOIX
	 * 		J AI TESTE MILLES TRUCS ET EN VAIN !!!!!!!!!!!!!!!!!!!!!!!!!
	 * 		ALORS JE CUSTOMISE LE DAO !!!!!!!!!!!!!!!!!!
	 * 
	 * ****************************************************************************************************/
	public  boolean create(T obj,int id );
	//besoin aussi pr la creation d une representation
	public int findByLast(T s);
	
	public  boolean delete(T obj);
	
	
	public  boolean update(T obj);
	
	public  T find(T obj);
	
	public  List<?> findAll(T obj);
	// vu que bcp de jointure pr juste obtenir les spectacles 
	public List getAll(T object) ;
	
	
	public T findById(int id) throws SQLException;// voir avc le throws ca evite try catch

	

}
