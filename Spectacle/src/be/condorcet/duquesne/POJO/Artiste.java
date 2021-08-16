package be.condorcet.duquesne.POJO;

import java.util.List;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;
// classe enfant qui herite de la classe personne
public class Artiste extends Personne
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	
	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	private String nomArtistique;
	public final static String statut = "ARTISTE";
	
	
	
	
	/************************************************************************************************************************
	 * 
	 * 
	 * j ai suivi l uml mais moi j aurai dit qu un artiste a un ou plus spectacle
	 * et un spectacle a aussi un ou pls artiste 
	 * l uml a ete fait par bozo le clown ?
	 * 
	 * 
	 * 
	 * 
	 * ***********************************************************************************************************************/
	
	
	
	/***********************************************************************************************************************
	 * 
	 * 
	 * les differents ctr
	 * 
	 * *********************************************************************************************************************/
	public Artiste() {}
	
	
	
	


	public Artiste(int id, String statut, String mdp, String speudo, String adresse, 
			String prenom, String nom,
			String telephone, String email, int age,String nomArtiste) {
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email, age);
		this.nomArtistique=nomArtiste;
	}


	public  Artiste(String pseudo, String mdp, String nom, String prenom, 
			String adresse, int age,String nomArtistique) 
	{
		super(pseudo, mdp, nom, prenom, adresse, age);
		this.nomArtistique=nomArtistique;
		
	}

	public  Artiste(String s, String mdp, String t, String a, String e, String n, String p,String nomA)
	{
		super(s, mdp, t, a, e, n, p);
		this.nomArtistique=nomA;
		
		
		
	}
	/*******************************************************************************************************
	 * 
	 * 
	 *  les getter et setter 
	 * 
	 * 
	 * ******************************************************************************************************/
	public String getNomArtistique() 
	{
		return nomArtistique;
	}
	public void setNomArtistique(String nomArtistique) 
	{
		this.nomArtistique = nomArtistique;
	}
	
	
	// affiche l obejt 
	@Override
	public String toString() 
	{
		return "    "  + nomArtistique + " ";
	}
	
	/**********************************************************************************************************
	 * 
	 * 		fct d inscpription pr l artiste 
	 * 
	 * 
	 * *********************************************************************************************************/
	@Override
	public boolean register() 
	{
		return pDAO.create(((Artiste) this));
	}



	/****************************************************************************************************************
	 * 
	 * 
	 * listing des artistes 
	 * 
	 * 
	 * *************************************************************************************************************/

	public static List<Artiste> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public boolean create() 
	{
		return true;//this.pDAO.createArtisteSpectacle(this);
	}
	

	
	
	
	
}
