package be.condorcet.duquesne.POJO;

import java.sql.Date;

import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.*;

public class Representation
{
	private final AbstractFactoryDAO dao =AbstractFactoryDAO
			.getFactory(AbstractFactoryDAO
			.DAO_FACTORY);
	
	private final DAO<Representation> rDAO = dao.getRepresentationDAO();

	/******************************************************************************************
	 * 
	 * attributs
	 * 
	 * **************************************************************************************/
	private float heureDebut;
	private float heureFin;
	private int id;
	//a voir si c est mieux date ou string a tester 
	private String dateRepresentation;
	private Date d;
	private String commentaire;
	private Spectacle spectacle;
	
	/******************************************************************************************
	 * 
	 * ctr
	 * 
	 * **************************************************************************************/

	public Representation(int id,String  dateRepresentation, float heureDebut2, float heureFin2) 
	{
		this.id = id;
		this.dateRepresentation = dateRepresentation;
		this.heureDebut = heureDebut2;
		this.heureFin = heureFin2;
		
	}
	
	public Representation(){}
			/*utilisé ds la reser de salle*/
	public Representation( float heureDebut, float heureFin, 
			Date d,Spectacle s) 
	{
		
		this.spectacle=s;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.d=d;
		
		
	}
	
	public Representation(int id,float heureDebut, float heureFin, 
			String dateRepresentation, String commentaire) 
	{
		this.id=id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.commentaire = commentaire;
	}
	/* **************************************************************************************
	 * 
	 * 		DOUBLE LIEN MEME STRUCTURE DS SPECTCALE
	 * 			UML DONNE COMME CA 
	 * ****************************************************************************************/
	public Representation(int id,float heureDebut, float heureFin,
			String dateRepresentation, Spectacle s) {
	
		this.id=id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.spectacle=s;
	}
	
	public Representation(String dateRepresentation,float heureDebut, float heureFin
			, Spectacle s)
	{
	
		
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		this.spectacle=s;
	}
	public Representation(int id,float heureDebut, float heureFin,
			String dateRepresentation) 
	{
	
		this.id=id;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	
		this.dateRepresentation = dateRepresentation;
		
	}
	

	public Representation(Date date, float heureDebut2, float heureFin2, Spectacle s) {
		
		this.heureDebut = heureDebut2;
		this.heureFin = heureFin2;
	
		this.d=date;
	
		this.spectacle=s;
	}
	/******************************************************************************************
	 * 
	 * setter getter
	 * 
	 * **************************************************************************************/
	public Spectacle getSpectacle() 
	{
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) 
	{
		this.spectacle = spectacle;
	}

	public float getHeureDebut()
	{
		return heureDebut;
	}

	public void setHeureDebut(float heureDebut)
	{
		this.heureDebut = heureDebut;
	}

	public float getHeureFin()
	{
		return heureFin;
	}

	public void setHeureFin(float heureFin) 
	{
		this.heureFin = heureFin;
	}


	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getDateRepresentation() 
	{
		return dateRepresentation;
	}

	public void setDateRepresentation(String dateRepresentation) 
	{
		this.dateRepresentation = dateRepresentation;
	}

	public Date getD() 
	{
		return d;
	}

	public void setD(Date d) 
	{
		this.d = d;
	}

	public String getCommentaire() 
	{
		return commentaire;
	}

	public void setCommentaire(String commentaire) 
	{
		this.commentaire = commentaire;
	}

	
	// affichage de l objet 
	@Override
	public String toString() 
	{
		return " " //" [ " + id +" ]"
	
	+  " date "+  dateRepresentation  + "  " ;
	//+ "   debit : "
		//	+ "  " +  heureDebut + "   fin :  "
		//+heureFin;
	
		
	}

	/**********************************************************************************************************
	 * 
	 * 
	 *   liste des representations liées avec les spectacles
	 * 
	 * 
	 * ***********************************************************************************************************/
	public List<Representation> findAll ()
	{
		return (List<Representation>) rDAO.findAll(this);
	}
	/***************************************************************************************************************
	 * 
	 * 
	 * liste sns jointure
	 * 
	 * 
	 * @return
	 *****************************************************************************************************************/

	public List<Representation>getAll ()
	{
		return (List<Representation>) rDAO.getAll(this);
	}
	
	/********************************************************************************************************************
	 * 
	 * 
	 *   creation d une repreentation
	 * 
	 * @return
	********************************************************************************************************************** */
	public boolean create() 
	{
		return rDAO.create(this);
	}
	
	
}
