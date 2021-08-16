package be.condorcet.duquesne.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;


public class PlaceDAO implements DAO<Place> 
{
	protected Connection con_ = null;

	public PlaceDAO(Connection con) 
	{
		con_ = con;
	}
/*INSERT INTO "STUDENT03_27"."PLACE_"
 *  ("prix", "fk_commande", "fk_representation", "type_place") VALUES ('500', '181', '101', 'OR')
*/
/*INSERT INTO "STUDENT03_27"."PLACE_" 
 * ("prix", "fk_commande", "fk_representation", "type_place") VALUES ('452', '181', '101', 'DIAMANT')
*/

	
	
   /**************************************************************************************************************
    * 
    * 			MEME PROB QUE PR LES COMMNANDES ON A BESOIN DE LA FK CDE MAIS ON NE SAIT PAS LUI FOURNIR
    * 
    * ************************************************************************************************************/
	@Override
	public boolean create(Place Place) 
	{
		Commande cde= new Commande();
		try 
		{
			this.con_
			.createStatement()
			.executeUpdate("INSERT INTO Place_ VALUES("
				
					+ Place.getPrix()
					+ "','"
					+ cde.getId()
					+ "','"
					+ Place.getRepresentation().getId()
					+ "','"
					+ Place.getType_categorie()
					+ "')"
				);
			return true;
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Place obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(Place obj) {
		// TODO Auto-generated method stub
		return null;
	}
//public Place(float prix, Representation representation, Commande commande,
	//TypesCat type_categorie) 
	/*select * from place_ p 
inner join representation_ r
on p."fk_representation" = r."id" 
inner join 
commande_ c on c."id"=p."fk_commande";*/
	
	
	@Override
	public List<?> findAll(Place obj) 
	{
		List<Place> liste = new ArrayList<Place>();

		Statement stm = null;
		ResultSet rs = null;
		
		try
		{
			String sql = "Select * From Place_ inner join representation_"
			+ " on place_.\"fk_representation\"=representation_.\"id\" inner join  commande_ on place_.\"fk_commande\""
			+ "=commande_.\"id\"";
			
			
					
		
			rs=this.con_.createStatement().executeQuery(sql);
			while(rs.next())
			{
				// 17 champs 
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return liste;
	}
	// ttes les places sans jointures a titre de test si besoin
	@Override
	public List getAll(Place object) 
	{
		List<Place> liste = new ArrayList<Place>();
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			String sql = "Select * From spectacle_ ";
			//rs = stm.executeQuery(sql);
			rs=this.con_
					.createStatement()
					.executeQuery(sql);
			while(rs.next())
			{
			
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return liste;
	}

	@Override
	public Place findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	/*INSERT INTO "STUDENT03_27"."PLACE_" 
	 * ("prix", "fk_commande", "fk_representation", "type_place") VALUES ('452', '181', '101', 'DIAMANT')
	*/

	@Override
	public boolean create(Place p, int id)
	{

		try 
		{
			PreparedStatement state = con_.prepareStatement
        			("INSERT INTO Place_(\"prix\",\"fk_commande\",\"fk_representation\",\"type_place\")"
        					

        					+ "VALUES (?,?,?,?)");
        		state.setFloat(1, p.getPrix());
	            state.setInt(2, id);// fk cde
	            state.setInt(3,101);//p.getRepresentation().getId());//fk repre
	            state.setString(4,"DIAMANT");// p.getType_categorie().toString());
	           
	            state.execute();

			
		}

		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}



	@Override
	public int findByLast(Place s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
