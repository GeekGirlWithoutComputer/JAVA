package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;


public class RepresentationDAO implements DAO<Representation> 

{
	protected Connection connect = null;
	private Statement stmt=null;
	
	public RepresentationDAO(Connection conn) 
	{
		connect = conn;
	}
/*
INSERT INTO "STUDENT03_27"."REPRESENTATION_" ("date", "heureDebut", "heureFin", "commentaire", "fk_spect") 
VALUES ('2022-08-25', '19', '24', 'kk nnn', '9')



*/
	@Override
	public boolean create(Representation r) 
	{
		
		try 
		{
			
			PreparedStatement state = connect.prepareStatement
        			("INSERT INTO Representation_(\"date\",\"heureDebut\",\"heureFin\",\"commentaire\",\"fk_spect\")"
        					

        					+ "VALUES (?,?,?,?,?)");
        		state.setString(1, r.getDateRepresentation());
	            state.setFloat(2, r.getHeureDebut());
	            state.setFloat(3,r.getHeureFin());
	            state.setString(4, r.getCommentaire());
	            state.setInt(5,r.getSpectacle().getId());
	           
	            
	            
	          //  JOptionPane.showMessageDialog(null, "d.lastRecord() !"+d.lastRecord());
	            //JOptionPane.showMessageDialog(null, "r.getSpectacle().getId() !"+r.getSpectacle().getId());
	            		// bidouille vu que rien ne marche 
	            		//r.getSpectacle().getId());// null 
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
	public boolean delete(Representation obj) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(Representation obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Representation> findAll(Representation representation) 
	{
		List<Representation> rlist= new ArrayList<Representation>();
	
		String sql = "Select * From representation_ inner join Spectacle_"
				+ " on spectacle_.\"id\"=representation_.\"fk_spect\"";
		
		try {
			ResultSet rs = this.connect.createStatement()					
					.executeQuery(sql);
							

			
			while (rs.next()) 
			
			{
				//le spectacle 
				Spectacle s = new Spectacle(
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						
						rs.getInt(12)
						);
			
				
				
				int rId = Integer.parseInt(rs.getString(1));
				String date  =rs.getString(2);
				int heureDebut = (int) Float.parseFloat(rs.getString(3));
				int heureFin = (int) Float.parseFloat(rs.getString(4));
				
				
				
				Representation r= new Representation(rId,heureDebut,heureFin, date,s);
				// ajout de la repre a la liste
				rlist.add(r);
									
				
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//JOptionPane.showMessageDialog( null,"taille list represendao findAll avc pk spec  "+rlist.size());
    	
		return rlist;
	}
	/*****************************************************************************************************************
	 * 
	 * 			AFIN DE TESTER LA RECUP DE TOUT SANS SOUCI
	 * ***************************************************************************************************************/
	@Override
	public List getAll(Representation object) 
	{

		List<Representation> liste= new ArrayList<Representation>();
			Statement stm = null;
			ResultSet rs = null;
			try
			{
				String sql = "Select * From representation_ ";
	
				rs=this.connect.createStatement().executeQuery(sql);
				while(rs.next())
				{
					String comm = rs.getString(5);
					String  date =rs.getString(2);
					
					int idR = Integer.parseInt(rs.getString(1));
					float heureDebut =  Float.parseFloat(rs.getString(3));
					float heureFin =Float.parseFloat(rs.getString(4));
					
					liste.add(
							new Representation(idR,date,heureDebut,heureFin)
						);
					
				
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			//JOptionPane.showMessageDialog( null,"liste ds reprDAO "+liste.size());
			return liste;
	}

	@Override
	public Representation findById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean create(Representation obj, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int findByLast(Representation s) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
