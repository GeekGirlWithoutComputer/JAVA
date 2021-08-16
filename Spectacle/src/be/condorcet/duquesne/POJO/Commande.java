package be.condorcet.duquesne.POJO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.*;

public class Commande 
{
	
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Commande> commandeDAO = dao.getCommandeDAO();
	
	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	private List<Place> places = new ArrayList<Place>();
	private int id;
	private payement modeDePayement;
	private livraison modeDeLivraison;
	private float total;
	private String precisionCde;
	private List<Commande> cdeL= new ArrayList<Commande>();
	/********************************************************************************************************************************
	 * 
	 * 
	 * JE SUIS AU COURANT DE LA REGLE DES DOUBLES LIENS 
	 * J AI PAS EU LE CHOIX VAR BCP DE BUGS DUR DES CONNERIES
	 * C EST LE SEUL DANS LE PROJET 
	 * 
	 * 
	 *******************************************************************************************************************************/
	private Personne p= new Personne();;
	
	Place placeCdee;
	
	
	/******************************************************************************************************
	 * 
	 * enum des differents moyens de paiement
	 * 
	 * @author Debora
	 *
	 *******************************************************************************************************/
	public static enum payement 
	{ 
		VISA,
		PAYPAL,
		SEPA ,
		PAYCONIQ
	}
	/******************************************************************************************************
	 * 
	 * enum des differents moyens d envoie des place
	 * 
	 * @author Debora
	 *
	 *******************************************************************************************************/
	public static enum livraison 
	{ 
		SUR_PLACE,
		TIMBRE_PRIOR,
		ENVOI_SECURISE    // 10 e 
	}
	
	
	
	
	
	
	
	/*sepa  // 7j ca   option  ne  reste 
	proposée que jusqu’à 20 jours calendrier avant la date du spectacle choisi 
	pour éviter tout retard avec la poste */
	
	/******************************************************************************************
	 * 
	 * SELON LE SCHEMA UML LA COMMANDE EST EN RAPPORT AVEC UNE OU DES PLACES 
	 * C EST PAS DANS CDE QU ON TAPE PERSONNE OU QUE SAIS JE 
	 * **************************************************************************************/
	
	 /* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * 
	 * Getter setter
	 * 
	 * 
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	public Personne getP() 
	{
		
		return p;
	}
	public void setP(Personne p) 
	{
		this.p = p;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setPlaces(List<Place> places) 
	{
		this.places = places;
	}
	public List<Place> getPlaces() 
	{
		return this.places;
	}
	
	public String getPrecisionCde() 
	{
		if(this.precisionCde==null || this.precisionCde==" ")
		{
			return "aucune precision pr cette cde ";
		}
		else
		return precisionCde;
	}
	public void setPrecisionCde(String precisionCde) 
	{
		this.precisionCde = precisionCde;
	}
	public Place getPlaceCdee() 
	{
		return placeCdee;
	}
	public void setPlaceCdee(Place placeCdee) 
	{
		this.placeCdee = placeCdee;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public void setTotal(float total) 
	{
		this.total = total;
	}
	public String getModeDePayement() 
	{
		
		if(this.modeDePayement == modeDePayement.PAYPAL) 
		{
			return "PAYPAL";
		}
			
		else if(this.modeDePayement == modeDePayement.VISA)
		{
			return "VISA";	
		}
			
		else if(this.modeDePayement== modeDePayement.PAYCONIQ)
		{
			return "PAYCONIQ";
		}
		else
		{
			return "SEPA";
		}
			
	}
	public void setModeDePayement(payement modeDePayement) 
	{
		this.modeDePayement = modeDePayement;
	}
	public String getModeDeLivraison() 
	{
		if(this.modeDeLivraison == modeDeLivraison.ENVOI_SECURISE) 
		{
			return "ENVOI_SECURISE";
		}
			
		else if(this.modeDeLivraison == modeDeLivraison.TIMBRE_PRIOR)
		{
			return "TIMBRE_PRIOR";		
		}
			
		else
		{
			return "SUR_PLACE";
		}
			
	}
	public void setModeDeLivraison(livraison modeDeLivraison) 
	{
		this.modeDeLivraison = modeDeLivraison;
	}
	public float getTotal() 
	{
		return total;
	}
	public void setCout(float total) 
	{
		this.total=total;
	}
	
	
	/***********************************************************************************************************************
	 * 
	 * 
	 *  les ctr 
	 * 
	 * 
	 * **********************************************************************************************************************
	 * @param places
	 * @param id
	 * @param modeDePayement
	 * @param modeDeLivraison
	 * @param total
	 * @param precisionCde
	 * @param placeCdee
	 */
	public Commande(List<Place> places, int id, 
			payement modeDePayement, livraison modeDeLivraison, float total,
			String precisionCde, Place placeCdee) 
	{
		
		this.places = places;
		this.id = id;
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total = total;
		this.precisionCde = precisionCde;
		this.placeCdee = placeCdee;
	}
	/*              CTR SANS ARG                                  */
	public Commande() {}
	
	
	public Commande(int id,payement modeDePayement,
			String precis, 
			livraison modeDeLivraison, 
			float total,Personne  c
			) 
	{
		this.id=id;
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total=total;
		this.p=c;
		
	}
	public Commande(int id,payement modeDePayement,
			String precis, 
			livraison modeDeLivraison, 
			float total
			) 
	{
		this.id=id;
		this.modeDePayement = modeDePayement;
		this.modeDeLivraison = modeDeLivraison;
		this.total=total;
		
		
	}
	
	/****************************************************************************************************
	 * 
	 * augmentation en fct des frais supplementaire
	 * 
	 * ***************************************************************************************************/
	
	
	
	
	public void augmenterCout(float coutSupplementaire) 
	{
		this.total =total+ coutSupplementaire;
	}
	
	/*POUR AFFICHER LES OBJETCS CETTE METHODES DOIT ETRE DANS TTE LES CLASSES */
	@Override
	public String toString() 
	{
		return "N° "+this.id + "  [ " + this.modeDeLivraison + "   ]"+  "  [   "  +this.modeDePayement + " ]   " ;
			//	+"  "+  this.getPrecisionCde();
	}
	
	
	/*******************************************************************************************************
	 * 
	 *                   CRUD
	 * 
	 * 
	 * ****************************************************************************************************/

	
	public List<Commande> findAll()
	{
		return (List<Commande>) this.commandeDAO.findAll(this);
	}
	
	
	
	public List<Commande> getdAll()
	{
		return (List<Commande>) this.commandeDAO.getAll(this);
	}
	/*****************************************************************************************************
	 * 
	 * SI ON RESPECTE LE DIAGRAMME DE CLASSE ON NE POSSEDE PAS DE LIEN PERSONNE DS COMMANDE CPDT LA COMMANDE
	 * EST FAITE PAR QQUN IL FAUT DONC DANS LE INSERT LUI ATTRIBUER L ID DE LA PERSONNE ET C EST LA QUE C EST LA MERDE 
	 * DU SIECLE 
	 * JE SUIS A LA 98 TENTATIVE 
	 * JE VAIS ESSAIER DE DONNER A LA CDE LA FK_PERS AVEC UN SELECT DANS PERSONNE ET AV UNE COMPARAISON
	 * IMPOSSIBLE DE CHEZ IMPSSIBLE FAUT TAPER DES DOUBLES LIENS 
	 * 
	 * *******************************************************************************************************
	 * @param id
	 * @return
	 */
	
        	
   
	
	public boolean create(int id) 
	{
		return this.commandeDAO.create(this,id);
				//this.commandeDAO.create(this); ca marche pas avec des milliers de test pas d id pas de cde 
	}
	

	
	/**************************************************************************************************************
	 * 
	 * 
	 * 		debbug pour voir ce que ca choppe reellement 
	 * 
	 * 
	 * 
	 * ***************************************************************************************************************/
	
	

	public void getListCdeByClient()
	{
	
		
		List<Commande> list =this.findAll();
				
	
		//JOptionPane.showMessageDialog(null, "taille list getcde ds commande"+this.findAll().size());
		
		
		for(Commande cde : list)
		{
			//id personne oki 
			if(cde.getP().getId()== this.id)
			{
				this.cdeL.add(cde);
			}
			
			//JOptionPane.showMessageDialog(null, "id cde  "+cde.getId());
				
		}
		//JOptionPane.showMessageDialog(null, "taille list de la cde apres verif "+cdeL.size());
		
	}
	public List<Commande> getCdeL() 
	{
		return cdeL;
	}
	public void setCdeL(List<Commande> cdeL) 
	{
		this.cdeL = cdeL;
	}
	
	
	
	
}
