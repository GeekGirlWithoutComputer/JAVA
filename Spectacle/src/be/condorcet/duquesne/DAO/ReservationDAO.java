package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.*;

public class ReservationDAO implements DAO<Reservation> {

	protected Connection con_= null;

	public ReservationDAO(Connection con) {
		con_ = con;
	}

	
	/* INSERT INTO "STUDENT03_27"."RESERVATION_" 
	 * ("acompte", "solde", "statut", "commentaire", "
	 * prix", "fk_pers", "fk_planS") VALUES ('150', '500', '
	 * ENREGISTRE', 'null', '500', '26', '42')
*/
	
	/*
INSERT INTO "STUDENT03_27"."RESERVATION_" 
("acompte", "solde", "statut", "commentaire", "prix", "fk_pers", "fk_planS") VALUES 
('250', '500', 'ENREGISTRE', 'aucun', '750', '29', '468')

Validation (commit) effectuée

*/
	@Override
	public boolean create(Reservation obj)
	{
		
        
        return false;

	}
	
	@Override
	public boolean delete(Reservation obj) 
	{
		return false;
	}

	@Override
	public boolean update(Reservation obj) 
	{
		return false;
	}

	
	@Override
	public List<Reservation> findAll(Reservation reservation) 
	{
		List<Reservation> rlist= new ArrayList<Reservation>();
		
		String sql = "select *from reservation_ ";
			//	+ "inner join planningSalle_ \r\n"
			//	+ "on RESERVATION_.\"fk_planS\" = PLANNINGSALLE_.\"id\" ";
		
		try {
			ResultSet rs = this.con_.createStatement()					
					.executeQuery(sql);
							

			
			while (rs.next()) 
			
			{
				//13 champs
				
				
				
				int rIR = Integer.parseInt(rs.getString(1));
				Float acompte = rs.getFloat(2);
				Float solde= rs.getFloat(3);
				String statut= rs.getString(4);
				String comm= rs.getString(5);
				Float px=rs.getFloat(6);
				/*
				
				int fkP=rs.getInt(7);
				int fkPl=rs.getInt(8);
				int idPlan=rs.getInt(9);
				Date dateD = Date.valueOf(rs.getString("10"));
				Date dateF = Date.valueOf(rs.getString("11"));
				 int fkSp= rs.getInt(12);
				 Date dateReserv = Date.valueOf(rs.getString("13"));
				 /*
				  * 
				  * 
				  */
				 /*public PlanningSalle( int id,Date dateFin, Date dateDebut, Date dateReservation,Spectacle spectacle) */
				//PlanningSalle pl = new PlanningSalle(idPlan,dateF,dateD,dateReserv,null);
				Reservation r = new Reservation(rIR,acompte,solde,px,statut,null,null);
				/*public Reservation(float acompte ,float solde , 
			float prix,String statut, PlanningSalle planningSalle , Personne organisateur) {*/
				
				rlist.add(r);
									
				
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//JOptionPane.showMessageDialog( null,"taille list reserv findAll dao avc pk spec  "+rlist.size());
    	
		return rlist;
		
	}

	@Override
	public Reservation find(Reservation obj) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll(Reservation object) 
	{
		// TODO Auto-generated method stub
		return null;
	}


	


	@Override
	public boolean create(Reservation obj, int id)
	
	{
		
		try
        {
                      
        	PreparedStatement state = con_.prepareStatement
        			("INSERT INTO Reservation_(\"acompte\",\"solde\",\"statut\","
        					+ "\"commentaire\",\"prix\""
        					+ ",\"fk_pers\",\"fk_planS\")"
        					
        					
        					+ "VALUES (?,?,?,?,?,?,?)");
        	
        	state.setFloat(1, obj.getAcompte());
            state.setFloat(2, obj.getSolde());
            state.setString(3, obj.getStatut());
            
            state.setString(4, obj.getCommentaire());
      
            state.setFloat(5, obj.getPrix());
            state.setInt(6,id);
            state.setInt(7, 468);
           
            
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
	public int findByLast(Reservation s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
