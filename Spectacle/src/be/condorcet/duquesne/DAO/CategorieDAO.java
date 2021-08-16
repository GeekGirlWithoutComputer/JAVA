package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;

public class CategorieDAO implements DAO<Categorie> 
{

	protected Connection connect = null;
	private Statement stmt=null;
	
	public  CategorieDAO(Connection conn) 
	{
		connect = conn;
	}
	
	
	/*INSERT INTO "STUDENT03_27"."CATEGORIE_" 
	 * INSERT INTO "STUDENT03_27"."CATEGORIE_" ("commentaire", "type", "prix", "nbrPlaceDispo", "nbrPlaceMax", "fk_config") VALUES ('aucun', 'BRONZE', '25', '5000', '58', '421')

	 * ("commentaire", "type", "prix", "nbrPlaceDispo", "nbrPlaceMax", "fk_config") VALUES ('neant', 'DEBOUT', '15', '8000', '100', '421')
*/
	@Override
	public boolean create(Categorie c) 
	{
		

		return true;
	}
	@Override
	public boolean delete(Categorie obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Categorie c) 
	{
		try 
		{
			this.connect
			.createStatement()
			.executeUpdate("UPDATE Categorie_ "
					+ "SET nbrPlaceDispo = \"nbrPlaceDispo\" - 1 WHERE Categorie_.\"id\" = ' "+c.getId()
						
						+"'");
			
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		

	}
	@Override
	public Categorie find(Categorie obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Categorie> findAll(Categorie obj) 
	{

		List<Categorie> liste = new ArrayList<Categorie>();
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				String sql = "Select * From categorie_ ";
				//rs = stm.executeQuery(sql);
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
					
					int idCat = Integer.parseInt(rs.getString(1));
					String com = rs.getString(2);
					TypesCat typeC= TypesCat.valueOf(rs.getString(3));
					int prix = (int) Float.parseFloat(rs.getString(4));
					int nbre = (int) Float.parseFloat(rs.getString(5));
					int nbre2 = (int) Float.parseFloat(rs.getString(6));
				// on peut bosser avec le nom des champs aussi c est au choix
					liste.add(new Categorie(idCat,com,typeC,prix,nbre,nbre2
							
							
							)
							
							);		
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return liste;
	}
	@Override
	public List getAll(Categorie object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Categorie findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*INSERT INTO "STUDENT03_27"."CATEGORIE_" ("commentaire", "type", "prix", "nbrPlaceDispo", "nbrPlaceMax", "fk_config") VALUES ('neant', 'DEBOUT', '15', '8000', '100', '421')
*/
	/*******************************************************************************************************
	 * 
	 * 
	 * 	POUR LA CREATION D UNE CATEGORIE ON A BESOIN DE L ID DE LA CONFIG 
	 * LES BARAKIS IRONT TAPER UN ATTRIBUT CONFIGURATION DANS CATEGORIE ET LE TOUR EST JOUE 
	 * JE RESTE DAN DU CRUD DONC ON NE PEUT PAS COMMENCER A CRITIQUER MON DAO
	 * 
	 * *******************************************************************************************************/
	@Override
	public boolean create(Categorie c, int id) 
	{
		try 
		{
			PreparedStatement state = connect.prepareStatement
        			("INSERT INTO Categorie_(\"commentaire\",\"type\",\"prix\","
        					+ "\"nbrPlaceDispo\",\"nbrPlaceMax\", \"fk_config\")"
        					
        					+ "VALUES (?,?,?,?,?,?)");
			
        		state.setString(1, c.getCommentaire());
	            state.setString(2, c.getType());
	            state.setInt(3,c.getPrix());
	            state.setInt(4, c.getNbrePlaceLibre());
	            state.setInt(5, c.getNbrPlaceMaximum());
	            state.setInt(6, id);
	            
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
	public int findByLast(Categorie s) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}


