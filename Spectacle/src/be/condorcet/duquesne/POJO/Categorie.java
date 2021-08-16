package be.condorcet.duquesne.POJO;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.DAO.*;

import be.condorcet.duquesne.POJO.Configuration.Ticket;


public class Categorie 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Categorie> cDAO = dao.getCategorieDAO();
	
	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	private String commentaire;
	private TypesCat type ;
	private int prix = 0;
	private int id = 0;
	
	private int nbrePlaceLibre;
	private int nbrPlaceMaximum;
	/*********************************************************************************************************
	 * 
	 * 
	 *   enum des differents types de categories qui seront liés aux differentes configurations
	 * 
	 * @author Debora
	 *
	 ************************************************************************************************************/
	public enum TypesCat 
	{
		OR,
		ARGENT,
		DIAMANT,
		BRONZE, 
		NEANT    // pr chipoter avc la conf debout qui a pas de cat
	};
	
	
	
	/***************************************************************************************************************
	 * 
	 * 
	 * 		les differents ctr
	 * 
	 * 
	 * 
	 * *************************************************************************************************************/
	public Categorie() {}
	
	// ctr avec ts les attributs
	public Categorie(String commentaire, TypesCat type, int prix, int id,
			int nbrePlaceLibre, int nbrPlaceMaximum) 
	{
		super();
		this.commentaire = commentaire;
		this.type = type;
		this.prix = prix;
		this.id = id;
		
		this.nbrePlaceLibre = nbrePlaceLibre;
		this.nbrPlaceMaximum = nbrPlaceMaximum;
	}
	// a l appel de ce ctr le nbre de place serz calculer
	public Categorie(TypesCat type, int prix, 
			Ticket place) 
	{
		
		
		this.type = type;
		this.prix = prix;
		
		
		this.calculPlace(type, place);
	}
	


	
	
	public Categorie(int id,String comm,TypesCat type, int prix,int n1,
			int n2) 
	{
		
		this.id=id;
		this.type = type;
		this.prix = prix;
		this.commentaire=comm;
		this.nbrePlaceLibre=n1;
		this.nbrPlaceMaximum=n2;
	
	}
	
	public Categorie(int id, int prix)
		
	{
		
		this.prix = prix;
		
		this.id=id;
	}


	public Categorie(TypesCat type,int prix , Ticket place , Configuration conf)
	{
		Configuration cf= new Configuration();
		this.prix = prix;
		this.type = type;
	    cf=conf;
		this.calculPlace(type, place);
	}

	
	/*******************************************************************************************************
	 * 
	 * 
	 *  les getter et setter 
	 * 
	 * 
	 * ******************************************************************************************************/
	public String getCommentaire() 
	{
		return this.commentaire;
	}

	

	public int getId() 
	{
		return this.id;
	}
	public void setCommentaire(String commentaire)
	{
		this.commentaire = commentaire;
	}

// pr recup l enum avec value of je dois taper en string
	public String getType() 
	{
		if(this.type.toString()==" ")
		{
			return " prob";
		}
		return this.type.toString();
	}


	public void setType(TypesCat type) 
	{
		this.type = type;
	}


	public int getPrix()
	{
		return prix;
	}


	public void setPrix(int prix)
	{
		this.prix = prix;
	}


	


	public void setId(int id) 
	{
		this.id = id;
	}


	


	public int getNbrePlaceLibre() 
	{
		return nbrePlaceLibre;
	}


	public void setNbrePlaceLibre(int nbrePlaceLibre)
	{
		this.nbrePlaceLibre = nbrePlaceLibre;
	}


	public int getNbrPlaceMaximum() 
	{
		return nbrPlaceMaximum;
	}


	public void setNbrPlaceMaximum(int nbrPlaceMaximum) 
	{
		this.nbrPlaceMaximum = nbrPlaceMaximum;
	}
	
	
	
	// afffichage l objetc 
	@Override
	public String toString() 
	{
		return " CAT:   " +   type + "   " + prix + "euros " ;
				//+ ", nbrePlaceLibre=" + nbrePlaceLibre + ", nbrPlaceMaximum=" + nbrPlaceMaximum + "]";
	}


	/*********************************************************************************************************
	 * 
	 * 
	 * 
	 * 
	 * ***********************************************************************************************************/
	public void calculPlace(TypesCat type, Ticket place) 
	{
		
		if(place == null) 
			{
				return ; //retourne à la méthode qui a appeler calcul..();
			}
		// init du nbre de place
		int nbre= 0;
		switch (place) 
		{
			case DEBOUT:
			nbre = 8000;
			break;
			case CIRQUE_ASSIS:
			if(type==null) 
			{
				return;//retourne à la méthode qui a appeler calcul..();
			}
			switch (type) 
			{
			case DIAMANT:
				nbre = 1000;
				break;
			case OR:
				nbre = 2000;
				break;
			case ARGENT:
				nbre = 1500;
				break;
			case BRONZE:
				nbre = 1500;
				break;
			}
			break;
		case CONCERT_ASSIS:
			if(type==null) 
			{
				return;//retourne à la méthode qui a appeler calcul..();
			}
			switch (type) 
			{
				case OR:
				nbre = 500;
				break;
				case ARGENT:
				nbre = 1500;
				break;
				case BRONZE:
				nbre= 3000;
				break;
			}
			break;
		

		}
		this.nbrePlaceLibre = nbre;
		// le nbre de place max est le nbre de place dispo c est logique donc elle sert a quoi??
		this.nbrPlaceMaximum = nbre;
	}
	
	
	/***********************************************************************************************************
	 * 
	 * 
	 *   creation de a categorie 
	 * 
	 * @return
	 ************************************************************************************************************/
	public boolean create(int id ) 
	{
		boolean cat = cDAO.create(this,id);
		return cat;
	}
	/******************************************************************************************************************
	 * 
	 * 
	 *   les place dominue en fct de achats 
	 * 
	 * *********************************************************************************************************************/
	public boolean catDown()
	{
		boolean majNbrePlce = cDAO.update(this);
		// ca retire un a chque plce prise 
		return majNbrePlce;
	}
	/*********************************************************************************************************************
	 * 
	 * 		liste des categories
	 * 
	 * ********************************************************************************************************************/
	 
	 
	public List<Categorie> findAll()
	{
		return (List<Categorie>) cDAO.findAll(this);
				
	}
	/*************************************************************************************************************
	 * 
	 * 
	 *    testing and debbug
	 * 
	 * 
	 *****************************************************************************************************************/
	public void display()
	{
		List<Categorie> list = this.findAll();
		 for(Categorie res : list) 
		 {
			 System.out.println(res);
			//JOptionPane.showMessageDialog(null," "+res);
		 }
	}

}
