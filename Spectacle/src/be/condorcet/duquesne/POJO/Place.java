package be.condorcet.duquesne.POJO;



import be.condorcet.duquesne.DAO.*;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;

public class Place 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO.getFactory(AbstractFactoryDAO.DAO_FACTORY);
	private final DAO<Place> placeDAO = dao.getPlaceDAO();
	/***********************************************************************************************************************
	 * 
	 * 
	 *  les attributs 
	 * 
	 * 
	 * **********************************************************************************************************************/
	private int id;
	private float prix;
	private Representation representation;
	
	private TypesCat type_cat;//type de place 
	/***********************************************************************************************************************
	 * 
	 * 
	 *  les ctr
	 * 
	 * 
	 * **********************************************************************************************************************/
	public Place() {}
	public Place(float prix, Representation representation, Commande commande,
			TypesCat type_categorie) 
	{
		
		this.prix = prix;
		this.representation = new Representation();
		commande= new Commande();
		this.type_cat = type_categorie;
	}
	/***********************************************************************************************************************
	 * 
	 * 
	 *  les getter et setter
	 * 
	 * 
	 * **********************************************************************************************************************/
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public float getPrix() 
	{
		return prix;
	}
	public void setPrix(float prix)
	{
		this.prix = prix;
	}
	public Representation getRepresentation() 
	{
		return representation;
	}
	public void setRepresentation(Representation representation) 
	{
		this.representation = representation;
	}
	
	public TypesCat getType_categorie() 
	{
		return type_cat;
	}
	public void setType_categorie(TypesCat type_categorie) 
	{
		this.type_cat= type_categorie;
	}
	
	/************************************************************************************************************************
	 * 
	 * 
	 *  methode de creation d une place qui a besoin de l id commande 
	 * 
	 * 
	 * **********************************************************************************************************************/
	public boolean create(int id) 
	{
		return this.placeDAO.create(this, id);
				
	}
	// affichage de l objet 
	@Override
	public String toString() 
	{
		return "NO " + id + "   "+ " prix=" + prix ; 
		
	}
	
	
}
