package be.condorcet.duquesne.POJO;
import be.condorcet.duquesne.DAO.AbstractFactoryDAO;
import be.condorcet.duquesne.DAO.PersonneDAO;

public class Organisateur extends Personne 
{
private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	
	protected final PersonneDAO pDAO = dao.getPersonneDAO();
	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	public final static String statut = "ORGANISATEUR";
	private String nominationEntreprise;
	private String numEntreprise;
	

	/***********************************************************************************************************************
	 * 
	 * 
	 *  les ctr 
	 * 
	 * 
	 * **********************************************************************************************************************/
	public Organisateur() {}
		
	
	public Organisateur(int id, String s, String mdp, String statut) {
		super(id, s, mdp, statut);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(Integer id, String statut, String mdp, String speudo, String adresse, String prenom, String nom,
			String telephone, String email, int age) {
		super(id, statut, mdp, speudo, adresse, prenom, nom, telephone, email, age);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String pseudo, String mdp, String nom, String prenom, 
			String adresse, int age,String nomination) 
	{
		super(pseudo, mdp, nom, prenom, adresse, age);
		this.nominationEntreprise=nomination;
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String pseudo, String mdp, String statut) {
		super(pseudo, mdp, statut);
		// TODO Auto-generated constructor stub
	}
	
	public Organisateur(String s, String mdp, String t, String a, String e, String n, String p,String no,String nomm)
	{
		super(s, mdp, t, a, e, n, p);
		this.numEntreprise=no;
		this.nominationEntreprise=nomm;
		
	}
	
	/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * 
	 * Getter setter
	 * 
	 * 
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	
	public String getNominationEntreprise() 
	{
		return nominationEntreprise;
	}
	public void setNominationEntreprise(String nominationEntreprise) 
	{
		this.nominationEntreprise = nominationEntreprise;
	}
	public Spectacle getSpect() 
	{
		return spect;
	}
	public void setSpect(Spectacle spect) {
		this.spect = spect;
	}
	public String getNumEntreprise() {
		return numEntreprise;
	}
	public void setNumEntreprise(String numEntreprise) {
		this.numEntreprise = numEntreprise;
	}
	private Spectacle spect;
	
	
	/**********************************************************************************************************************
	 * 
	 *  inscription de l org 
	 * 
	 * 
	 *****************************************************************************************************************/
	@Override
	public boolean register() 
	{
		return pDAO.create(((Organisateur) this));
	}


	@Override
	public String toString() 
	{
		return "No: " +id + "  " + this.nom + " " + this.prenom ;
	}
	
	
	
	
}
