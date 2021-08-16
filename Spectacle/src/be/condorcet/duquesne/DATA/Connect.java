package be.condorcet.duquesne.DATA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Connect
{
private static Connection instance = null;
	
	private Connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@//193.190.64.10:1522/XEPDB1";
			instance = DriverManager.getConnection(url,"STUDENT03_27","changeme");
		}
		catch(ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		}
		catch (SQLException ex) 
		{
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) 
		{
            JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
        }
	}
	
	public static Connection getInstance()
	{
		if(instance == null)
		{
			new Connect();
		}
		return instance;
	}
}
