package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import be.condorcet.duquesne.POJO.PlanningSalle;
import be.condorcet.duquesne.POJO.Spectacle;

public class PlanningSalleDAO  implements DAO<PlanningSalle> 

{
	protected Connection con_ = null;
	private Statement stmt=null;
	
	public PlanningSalleDAO(Connection conn) 
	{
		con_= conn;
	}
/*
INSERT INTO "STUDENT03_27"."PLANNINGSALLE_" 
("dateDebut", "dateFin", "fk_spect", "dateReserv") VALUES ('2023-05-12', '2020-05-19', '7', '2021-06-01')

Validation (commit) effectuée

*/
	@Override
	public boolean create(PlanningSalle p) 
	{
		try 
		{
	           
		        	PreparedStatement state = con_.prepareStatement
		        			("INSERT INTO PLANNINGSALLE_(\"dateDebut\",\"dateFin\",\"fk_spect\",\"dateReserv\")"
		        					
	
		        					+ "VALUES (?,?,?,?)");
		        		state.setString(1, p.getdateDebutReservation().toString());
			            state.setString(2, p.getDateFinReservation().toString());
			            state.setInt(3,p.getSpectacle().getId());
			            state.setString(4, p.getDateReservation().toString());
			            state.execute();
			            return true;
		}

			        catch(SQLException e)
			        {
			            e.printStackTrace();
			        }
			        
			        return false;
	}
	

	@Override
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return null;
	}
/*public PlanningSalle( Date dateFin, Date dateDebut, Date dateReservation,Spectacle spectacle) 
 * 
 * select *from planningSalle_ inner join Spectacle_ on 
planningsalle_."fk_spect"
=spectacle_."id"*/
	@Override
	public List<PlanningSalle> findAll(PlanningSalle p) 
	{
		List<PlanningSalle> liste = new ArrayList<PlanningSalle>();
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			String sql = "Select * From planningSalle_ inner join Spectacle_"
					+ " on planningsalle_.\"fk_spect\"=spectacle_.\"id\"";
			
			rs=this.con_.createStatement().executeQuery(sql);
			while(rs.next())
			{
				int i=rs.getInt(1);
				Date date1= Date.valueOf(rs.getString("dateDebut"));
				Date date2= Date.valueOf(rs.getString("dateFin"));
				int fk= rs.getInt("fk_spect");
				Date date3= Date.valueOf(rs.getString("dateReserv"));
				//donnees spectacle
				int idspectacle=rs.getInt(6);
				String libel= rs.getString(7);
				String genre= rs.getString(8);
				String img= rs.getString(9);
				String description= rs.getString(10);
				int nbrePlace= rs.getInt(11);
				Spectacle s = new Spectacle(libel,genre,img,description,nbrePlace);
				
			
				// on peut bosser avec le nom des champs aussi c est au choix
				liste.add(new PlanningSalle(i,date2,date1,date3,s)
						
						
						
						
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
	public List getAll(PlanningSalle object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanningSalle findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean create(PlanningSalle obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int findByLast(PlanningSalle s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
	

}
