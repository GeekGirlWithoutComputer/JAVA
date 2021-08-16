package be.condorcet.duquesne.POJO;


import java.sql.Date;

import java.util.Calendar;
import java.util.List;

import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.*;

public class Reservation {
	private final AbstractFactoryDAO dao =AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Reservation> reservationDAO = dao.getReservationDAO();

	/******************************************************************************************
	 * 
	 * attributs
	 * 
	 * **************************************************************************************/
	private int id ;
	private float acompte;
	private float solde;
	private float prix;
	private String statut = "actif";
	private String commentaire;
	
	private PlanningSalle planningSalle;

	

	/******************************************************************************************
	 * 
	 * les ctr
	 * 
	 * **************************************************************************************/
	
	public Reservation(int id,float acompte ,float solde , 
			float prix,String statut, PlanningSalle planningSalle , Personne organisateur) {
		this.id=id;
		this.acompte = acompte;
		this.solde = solde;
		this.prix = prix;
		this.statut=statut;
	
		this.planningSalle = planningSalle;
	}
	
	public Reservation() {}
	
	
	public Reservation(float i, float j, float k,
			PlanningSalle planningSalle, Personne personne) 
	{
		this.acompte = i;
		this.solde = j;
		this.prix = k;
		
		
		this.planningSalle = planningSalle;
	}

	/******************************************************************************************
	 * 
	 * les ctr 
	 * 
	 * **************************************************************************************/
	public float getAcompte() 
	{
		return acompte;
	}
	public void setAcompte(float acompte) 
	{
		this.acompte = acompte;
	}
	public String getCommentaire() 
	{
		if(this.commentaire==" " || this.commentaire==null) 
		{
			return"aucun commentaire";
		}
		return commentaire;
	}
	public void setCommentaire(String commentaire) 
	{
		
		this.commentaire = commentaire;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public float getSolde() 
	{
		return solde;
	}
	public void setSolde(float solde) 
	{
		this.solde = solde;
	}
	public float getPrix() 
	{
		return prix;
	}
	
	/**********************************************************************
	 * 
	 *  calcul du prix en fct du jour demandé 
	 * 
	 * @param jourReserv
	************************************************************************** */
	public void setPrixByday(Date jourReserv) 
	{
		/*4.500 € si J est vendredi ou samedi 
 			3.000 pour les autres jours.*/
		int j=jourReserv.getDay();
		/*5 e j c est vendredi et 6 e samedi */ 
		if(j== 5 || j== 6) 
		{ 
			this.prix = 4500;
		}
		/* les autres jours */
		else
		{
			this.prix = 3000;
		}
	}
	public String getStatut() 
	{
		return statut;
	}
	public void setStatut(String statut) 
	{
		this.statut = statut;
	}
	
	public PlanningSalle getPlanningSalle() 
	{
		return planningSalle;
	}
	
	public void setPlanningSalle(PlanningSalle planningSalle) 
	{
		this.planningSalle = planningSalle;
	}
	public List<Reservation> findAll() 
	{
		return  (List<Reservation>) reservationDAO.findAll(this);
	}
	
	@Override
	public String toString() 
	{
		return "Reservation [acompte=" + acompte + ", solde=" + solde + ", prix=" + prix + ", statut=" + statut
				+ ", commentaire=" + this.getCommentaire() + "]";
	}
	
	/**************************************************************************************************************
	 * 
	 * creation de la reservation avec id de la personne qui reserve 
	 * 
	 * ***********************************************************************************************************/
	public boolean create(int id ) 
	{		
		return reservationDAO.create(this,id);
	}
	
}
