package be.condorcet.duquesne.POJO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;
import be.condorcet.duquesne.POJO.*;

public class Client extends Personne
{

	private int id;
	
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	
	public final static String statut = "CLIENT";
	private List<Commande> cdeDesUsers= new ArrayList<Commande>();
	private Commande cde ;

	

	/***************************************************************************************************************
	 * 
	 * 
	 * 		les differents ctr
	 * 
	 * 
	 * 
	 * *************************************************************************************************************/

	public Client(int id, String nom, Commande c) 
	{
		super(id, nom);
		this.cde=c;
		
	}

	public Client(Integer id, String statut, String mdp, String speudo, String adresse, 
			String prenom, String nom,String telephone, String email) 
	{
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email);
		
	}

	public Client(String s, String mdp, String t, String a, String e, String n, String p, int age) 
	{
		super(s, mdp, t, a, e, n, p, age);
		
	}
// pr find 
	public Client(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email, int age) 
	{
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email, age);
	
	}

	/*********************************************************************************************
	 * 
	 * 		utilisié pour le findAll des personne avec leurs commandes
	 * 
	 * ********************************************************************************************/
	public Client(int id,String nom, String prenom, String email,String statut) 
	{
		super(id,nom,prenom,email,statut);
	
		
	}

	public Client(String pseudo, String mdp, String statut) {
		super(pseudo, mdp, statut);
		// TODO Auto-generated constructor stub
	}
	
	public Client() {}

	/***************************************************************************************************************
	 * 
	 * 
	 * 		les getter setter 
	 * 
	 * 
	 * 
	 * *************************************************************************************************************/
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	
	
		
	public List<Commande> getCdeDesUsers() {
		return cdeDesUsers;
	}

	public void setCdeDesUsers(List<Commande> cdeDesUsers) {
		this.cdeDesUsers = cdeDesUsers;
	}

	public Commande getCde() {
		return cde;
	}

	public void setCde(Commande cde) {
		this.cde = cde;
	}
	/****************************************************************************************************************
	 * 
	 * 	inscription du client 
	 * 
	 * 
	 ******************************************************************************************************************/
	
	@Override
	public boolean register() 
	{
		return pDAO.create(((Client) this));
	}
	// affiche l objet 
	@Override
	public String toString()
	{
		return "iNO =" + id + " " + getPrenom() + " " 
				+ getPrenom() + ", getNom()=" + getNom() + "  " ;
	}
	
	
	@Override
	public Personne FindAll()
	{
		return (Client) this.pDAO.findAll(this);
	}

	
	
	
	
}
