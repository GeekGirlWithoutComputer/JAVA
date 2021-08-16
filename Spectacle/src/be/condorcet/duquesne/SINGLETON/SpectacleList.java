package be.condorcet.duquesne.SINGLETON;
import java.util.HashSet;
import java.util.Set;

import be.condorcet.duquesne.POJO.Spectacle;

public class SpectacleList 
{
	private static SpectacleList  instance = new SpectacleList ();
	/*set  permet de ne pas avoir de doublons */
	private static Set<Spectacle> spectacleList = null;
	private Spectacle s;
	
	
	private SpectacleList ()
	{
		spectacleList= new HashSet<>();// pr obt la liste
	}
	
	public static SpectacleList  getInstance()
	{
		return instance; 
	}
	
	public Set<Spectacle> getList()
	{
		if(spectacleList == null)
		{
			 instance = new SpectacleList ();
		}
		return spectacleList;
	}
	
	
	

   
    

     public static Set<Spectacle> getSpectacleList() 
     {
		return spectacleList;
	}

	public static void setSpectacleList(Set<Spectacle> spectacleList) 
	{
		SpectacleList.spectacleList = spectacleList;
	}



 /* comme j utilise set je verifie que le spectacle est pas deja present */

     public void Add(Spectacle s)
     {
    	 if (!this.spectacleList.contains(s)) 
    	 {
    		 spectacleList.add(s);
 		}
    	 

     }
     public void Remove(Spectacle s)
     {
    	 spectacleList.remove(s);

     }
     public void Affiche()
     {
         for(Spectacle s :  spectacleList)
         {
        	 System.out.println(s);
         }
     }
	
	
	
	
	
	
	
	
	
	
	
}
