package be.condorcet.duquesne.POJO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.DAO.*;


public class Spectacle 
{
	private final AbstractFactoryDAO dao = AbstractFactoryDAO
			.getFactory(AbstractFactoryDAO
			.DAO_FACTORY);
	private final DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
	

	/******************************************************************************************
	 * 
	 * attributs
	 * 
	 * **************************************************************************************/
	private int id;
	private String libel;
	private int nombrePlaceParClient;
	private String description;
	private String genre;
	private String urlImg;
	// attr referent 
	private Representation rep = new Representation();// dfr eln autre 
	private Configuration config = new Configuration();
	
	
	// prendre les representations corr au spectacle
	List<Representation> reList = new LinkedList<>();
	List<Configuration>cfgList = new LinkedList<>();
	List<Spectacle> re = new LinkedList<>();
	

	/******************************************************************************************
	 * 
	 * les ctr 
	 * 
	 * **************************************************************************************/
	

	public Spectacle() {}
	
	public Spectacle(int id) 
	{
		this.id=id;
	};

	public Spectacle(String libel, int nombrePlaceParClient,String genre) 
	{
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
	}
	public Spectacle(String libel, int nombrePlaceParClient) 
	{
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
	}
	// ctr utilisé
	public Spectacle(String libel,String genre,String urlImg,
			String description,int nombrePlaceParClient) 
	{
		
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		
	}
	public Spectacle(int id,String libel,String genre,String urlImg,
			String description,int nombrePlaceParClient) 
	{
		this.id=id;
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		
	}
	public Spectacle(int id,String libel,String genre,String urlImg,
			String description,int nombrePlaceParClient,Representation rep ) 
	{
		this.id=id;
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		this.rep=rep;
		
	}
	/***************************************************************************************************************************************
	 * 
	 * SCHEMa UML DONNE DONNE DOUBLE LIEN ENTRE SPECTACLE ET REPRESENTATION DONC ON PEUT FAIRE SOIT ICI SOIT DE L AUTRE COTE 
	 * J AI TEST DES DEUX MANIERES SOIT ON CHOPE LES SPECTACLES ET ON SUITE LE CHEMIN SOIT ON CHOPE LA REPREENTATION QUI POSSEDE
	 * UN SPECTACLE ET ON SUIT LE CHEMIN DES TABLES 
	 * 
	 * 
	 * 
	 * ***************************************************************************************************************************************/
	public Spectacle(int id,String libel,String genre,String urlImg,
			String description,int nombrePlaceParClient,Representation rep,Configuration config) 
	{
		this.id=id;
		this.libel = libel;
		this.nombrePlaceParClient = nombrePlaceParClient;
		this.genre=genre;
		this.urlImg=urlImg;
		this.description=description ;
		this.rep=rep;
		this.config=config;
		
	}

	public Spectacle(int id, String libel)
	{
		this.id=id;
		this.libel = libel;
		
	}
	/******************************************************************************************
	 * 
	 * les setter getter
	 * 
	 * **************************************************************************************/
	
	
	public Configuration getConfig() 
	{
		return config;
	}
	

	
	public Representation getRep() 
	{
		
		return this.rep;
	}

	public void setRep(Representation rep) 
	{
		this.rep = rep;
	}

	public String getDescription() 
	{
		if(this.description==null || this.genre==" ")
		{
			return "aucune description pour ce spectacle ";
		}
		else
			return this.description;
	}
	
	
	public List<Representation> getReList() 
	{
		return reList;
	}
	public void setReList(List<Representation> reList) 
	{
		this.reList = reList;
	}
	public Configuration getConfiguration() 
	{
		return config;
	}

	public void setConfiguration(Configuration configuration) 
	{
		this.config = configuration;
	}

	public int getId() 
	{
		return this.id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getLibel()
	{
		return this.libel;
	}

	public void setLibel(String libel) 
	{
		this.libel = libel;
	}

	public int getNombrePlaceParClient() 
	{
		return this.nombrePlaceParClient;
	}

	public void setNombrePlaceParClient(int nombrePlaceParClient) 
	{
		this.nombrePlaceParClient = nombrePlaceParClient;
	}

	public String getGenre() 
	{
		if(this.genre==null || this.genre==" ")
		{
			return "non indiqué";
		}
		else
		return genre;
	}

	public void setGenre(String genre) 
	{
		this.genre = genre;
	}

	public String getUrlImg()
	{
		return urlImg;
	}

	public void setUrlImg(String urlImg) 
	{
		this.urlImg = urlImg;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public List<Representation> getRepresentationList()
	{
		return reList;
	}
	
	public List<Configuration> getConfigList()
	{
		return cfgList;
	}
	
	public void setConfig(Configuration config)
	{
		this.config = config;
	}
	public List<Configuration> getCfgList() 
	{
		return cfgList;
	}
	public void setCfgList(List<Configuration> cfgList) 
	{
		this.cfgList = cfgList;
	}
	// affich=gage de l objet 
	@Override
	public String toString() 
	{
	
		return libel + "   " ;
		
	}
	
	/********************************************************************************************************************
	 * 
	 * 
	 * 
	 *   creation d un  spectacle 
	 * 
	 * 
	 * 
	 * @return
	************************************************************************************************************************ */

	public boolean create() 
	{
		return this.spectacleDAO.create(this);

	}

	/***********************************************************************************************************************
	 * 
	 *  liste spectzcle ans jonture a titre de test debbug
	 * 
	 * 
	 * *********************************************************************************************************************/
	public List<Spectacle> findAll_ ()
	{
		return (List<Spectacle>) spectacleDAO.getAll(this);
				
	}
	
	
	
	

	/*************************************************************************************************************************
	 * 
	 * 
	 *   liste des spectacle avec ttes les jointures 
	 * 
	 * 
	 * *************************************************************************************************************************/
	public List<Spectacle> findAll()
	{
		return (List<Spectacle>) spectacleDAO.findAll(this);
				
	}
	
	
	
	
	/***********************************************************************************************
	 * 
	 * 
	 * liste des representations en fct du spectacle 
	 * 
	 * *********************************************************************************************/
	public void getListRepresentationBySpectacle()
	{
		rep = new Representation();
		// ca renvoie ttes les repre
		List<Representation> list = rep.findAll();
	
      //  JOptionPane.showMessageDialog( null,"taille liste repre ds spect .fd all"  +rep.findAll().size());
      
	      for(Representation res : list) 
	      {
	    	  {
	          	if(res.getSpectacle().getId()==this.id)
	          		this.reList.add(res);
	          }
	       // JOptionPane.showMessageDialog(null,"res.getSpectacle().getId()  "+res.getSpectacle().getId() + " id spect = "+ this.id);
	      }
		
        
        	//JOptionPane.showMessageDialog(null,"relist de getlistby  "+reList);
        	//JOptionPane.showMessageDialog( null,"res.getspect.getid "+res.getSpectacle().getId());
        	//JOptionPane.showMessageDialog( null,"res.getSpectacle().getId() == this.id "+(res.getSpectacle().getId() == this.id));
        	
    }
        
	
	
 /*****************************************************************************************************************************
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 				TEST debbuging 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * **********************************************************************************************************************/
	public String getListSpTest()
	{
		config= new Configuration();
		rep= new Representation();
		// ca renvoie ttes les repre
        List<Configuration> listC = config.findAll();
        List< Representation> listR = rep.findAll();
        List< Spectacle> listS= this.findAll();
      
      //  JOptionPane.showMessageDialog( null,"taille liste repre ds spect .fd all"  +rep.findAll().size());
      
        for(Configuration cf : listC) 
        {
        	if(this.id==this.config.getId() )
        	{
        			this.cfgList.add(cf);// modif avc cat
        		
        	}
        	//JOptionPane.showMessageDialog(null,"id conf   "+this.getConfiguration().getId() + " id spect "+ this.id);
        		
        }
        
        
        
        for(Representation cf : listR) 
        {
        	if(this.id==this.config.getId() )
        	{
        			this.reList.add(cf);// modif avc cat
        		
        	}
        	//JOptionPane.showMessageDialog(null,"id conf   "+this.getConfiguration().getId() + " id spect "+ this.id);
        		
        }
        
        
        for(int i=0;i<listS.size();i++) 
		{
        	//JOptionPane.showMessageDialog(null,"id spect" +listS.get(i).getId() );
        	/*
			if(listS.get(i).getId()==(listR.get(i).getId()))
			{
				return "id spec" + listS.get(i).getId() + "id repr "+listR.get(i).getId();
			}
			if(listS.get(i).getId()==(listC.get(i).getId()))
			{
				return "id spec" + listS.get(i).getId() + "id config "+listC.get(i).getId();
			}
			*/
			//JOptionPane.showMessageDialog(null,"spec "+listS.get(i).getId());
			//JOptionPane.showMessageDialog(null,"rep "+listR.get(i).getId());
			//JOptionPane.showMessageDialog(null,"cfg "+listC.get(i).getId());
			
		}
        
        JOptionPane.showMessageDialog(null,"id spect" +listS.get(1).getId() );
        JOptionPane.showMessageDialog(null,"spect" + this.getId() + 
        		"rep date " +rep.getDateRepresentation() + "config type + " 
        		+ config.getType());
		 return "id spect"+ this.re + "id represen" + rep.getId()+" " 
		 + "id config " + " " + this.getConfig().getType()   ;
		

        	//JOptionPane.showMessageDialog( null,"res.getspect.getid "+res.getSpectacle().getId());
        	//JOptionPane.showMessageDialog( null,"res.getSpectacle().getId() == this.id "+(res.getSpectacle().getId() == this.id));
        	
        }
	
	
	
	
	
	public Spectacle check() 
	{
		return this.spectacleDAO.find(this);
	}
	
	/* retrouve la derniere ligne inseree car pour ajouter une representation on a pas le choix */
	
	public int lastRecord() 
	{
		return this.spectacleDAO.findByLast(this);
		
	}
	
	
	/*************************************************************************
	 * 
	 * 
	 *  a titre des test debbug
	 * 
	 * *******************************************************************/
	
	public void display()
	{
		 List<Representation> list = rep.findAll();
		 for(Representation res : list) 
		 {
			 System.out.println(res);
			// JOptionPane.showMessageDialog(null," "+res);
		 }
	}
	
}
		


