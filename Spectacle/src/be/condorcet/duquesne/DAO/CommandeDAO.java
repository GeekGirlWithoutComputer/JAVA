package be.condorcet.duquesne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Client;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import be.condorcet.duquesne.POJO.Commande.livraison;
import be.condorcet.duquesne.POJO.Commande.payement;

public class CommandeDAO  implements DAO<Commande> 
{
	protected Connection connect = null;
	private Statement stmt=null;
	/*ctr qui instancie la connect */
	public  CommandeDAO(Connection conn) 
	{
		connect = conn;
	}
	
	@Override
	public boolean delete(Commande obj) 
	{
		
		return false;
	}

	@Override
	public boolean update(Commande obj) 
	{
		
		return false;
	}

	@Override
	public Commande find(Commande obj) 
	{
		
		return null;
	}
/*select * from commande_ inner join personne_ 
 * on commande_."fk_pers" = personne_."id" inner join place_ on Commande_."id"=place_."fk_commande";;*/
	
	/*la personne commande de places 3 tables jointes pas complet a refaire */
	
	
	
	
	@Override
	
	public List<Commande> findAll(Commande c) 
	{
		
		List<Commande> cdes = new ArrayList<Commande>();
		
		
		String sql = "SELECT  * FROM Commande_ inner join personne_ "
				+ "on personne_.\"id\" = commande_.\"fk_pers\""
				+ " WHERE commande_.\"fk_pers\"='"
				+13+ "'";
				
				
		

		try 
		{
			
			//JOptionPane.showMessageDialog(null, "id de la personne ds dao cde   "+c.getP().getId()); ca renvoie bien 
			
			ResultSet rs = this.connect.createStatement().executeQuery(sql);
		
			while (rs.next()) 
			{
				int id =rs.getInt(1);
				payement paie= payement.valueOf(rs.getString(2));
				String preci= rs.getString(3);
				livraison mL= livraison.valueOf(rs.getString(4));
				Float t= rs.getFloat(5);
				int fkp=rs.getInt(6);
				
				//public Personne(int id,nom)
				int idP = rs.getInt(7);
				String nom=rs.getString(14);
				
				
				Commande cde = new Commande(id,paie,preci,mL,t);
				Client cc = new Client(idP,nom,cde);
				//JOptionPane.showMessageDialog(null, "id personne de  staic get user de person  "+Personne.getUser(idP));	
				
			
				
				
				
				
				cdes.add(new Commande(id,paie,preci,mL,t,cc));
						
						
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cdes;

	}
	/*getAll simple oki */
	@Override
	public List getAll(Commande c) 
	{

		
		List<Commande> cdes = new ArrayList<Commande>();
		

		try 
		{
			String sql = "select * from commande_ inner join personne_ on commande_.\"fk_pers\""
					
					 ;
					
			
			
					//+ "// = personne_.\"id\" ";
					//+ "WHERE commande_.\"fk_pers\"='"+c.getP().getId()+ "'";
				
			
			
			ResultSet rs = this.connect.createStatement().executeQuery(sql);
		
			while (rs.next()) 
			{
				int id = rs.getInt(1);
				payement paie= payement.valueOf(rs.getString(2));
				String preci= rs.getString(3);
				livraison mL= livraison.valueOf(rs.getString(4));
				Float t= rs.getFloat(5);
				int fkp=rs.getInt(6);
				
				//public Personne(int id,nom)
				int idP = rs.getInt(7);
				String nom=rs.getString(14);
				Client p = new Client(idP,nom,null);
				
					
				
				cdes.add(new Commande(id,paie,preci,mL,t,p));
				
				//JOptionPane.showMessageDialog(null, "id personne "+c.getP().getId());	
				//JOptionPane.showMessageDialog(null, "id cde "+c.getId());		
						
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(null, "taille list getcde de DAO  get all  "+cdes.size());
		
		return null;
				//cdes;
		
	}

	@Override
	public Commande findById(int id) throws SQLException 
	{
		
			return null;
		
	}

/*IMPOSSIBLE DE CREER UN COMMANDE SANS L ID DE LA PERSONNE
 * LES AUTRES ONT FAIT DES DOUBLES LIENS 
 * PAS D ID PAS DE CDE 
 * PAS DE LIEN PAS D ID
 * J AI TOUT ESSAYE IMPOSSIBLE DE CHEZ IMPOSSIBLE 
 * 
	
	/*INSERT INTO "STUDENT03_27"."COMMANDE_" 
	 * ("modePaiement", "precisionCde", "modeLivraison", "total", "fk_pers") VALUES ('SEPA', 'neant', 'SUR_PLACE', '525', '30')
*/
	
	@Override
	public boolean create(Commande obj) 
	{
		Personne p = new Personne();
		
		/*
		ResultSet result = this.connect
				.createStatement()
				.executeQuery("SELECT * FROM Personne_ WHERE \"id\" = "
						+ "'" + "qque chose qui exisre pas ds cde er qui rend impossible la req de merde " +"'" );
		*/
		
		PreparedStatement prepare = null;
		String sql = "INSERT INTO Commande_ VALUES("
				+ obj.getModeDePayement()+ "','" + obj.getModeDeLivraison()+ "','"
				+ obj.getPrecisionCde() + "','" +
				+ obj.getTotal()+ "','" +p.getId()+ "','"
				+ "')";
		try
        {
			prepare = connect.prepareStatement(sql);
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }   
        return true;
		
	
	}
/*
	/*INSERT INTO "STUDENT03_27"."COMMANDE_" 
	 * ("modePaiement", "precisionCde", "modeLivraison", "total", "fk_pers") VALUES ('SEPA', 'neant', 'SUR_PLACE', '525', '30')*/
	@Override
	public boolean create(Commande c,int id)
	{
		
		try 
		{
			PreparedStatement state = connect.prepareStatement
        			("INSERT INTO Commande_(\"modePaiement\",\"precisionCde\",\"modeLivraison\",\"total\",\"fk_pers\")"
        					

        					+ "VALUES (?,?,?,?,?)");
        		state.setString(1, c.getModeDePayement());
	            state.setString(2, c.getPrecisionCde());
	            state.setString(3,c.getModeDeLivraison());
	            state.setFloat(4, c.getTotal());
	            state.setInt(5, id);
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
	public int findByLast(Commande s) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	
	


}
