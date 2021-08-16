package be.condorcet.duquesne.POJO;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;

public class Manager extends Personne
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	
	public final static String statut = "MANAGER";
	private int id;
	

	/***********************************************************************************************************************
	 * 
	 * 
	 *  les ctr 
	 * 
	 * 
	 * **********************************************************************************************************************/
	
	public Manager() {}
		



	public Manager(int id, String s, String mdp, String statut)
	{
		super(id, s, mdp, statut);
	
	}




	



	public Manager(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email) 
	{
		
	}




	public Manager(String pseudo, String mdp, String nom, String prenom, String adresse, int age) 
	{
		super(pseudo, mdp, nom, prenom, adresse, age);
		
	}




	public Manager(String s, String mdp, String t, String a, String e, String n, String p, int age) 
	{
		super(s, mdp, t, a, e, n, p, age);
		// TODO Auto-generated constructor stub
	}




	public Manager(String s, String mdp, String t, String a, String e, String n, String p) 
	{
		super(s, mdp, t, a, e, n, p);
		
	}




	public Manager(String pseudo, String mdp, String statut) 
	{
		super(pseudo, mdp, statut);
		
	}


	/**********************************************************************************************************
	 * 
	 *  inscription du manager 
	 * 
	 * 
	 * ************************************************************************************************************/
	

	@Override
	public boolean register() 
	{
		return pDAO.create(((Manager) this));
	}



	// affichage de l object 
	@Override
	public String toString() 
	{
		return "No :" +id +this.nom + "  " + this.prenom;
	}
	
	
	
}
