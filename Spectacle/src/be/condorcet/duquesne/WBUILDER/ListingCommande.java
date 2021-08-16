package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.Client;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ListingCommande extends JFrame 
{

	private JPanel contentPane;
	private Personne p;
	private List<Commande> allCde = new ArrayList<Commande>();
	
	private Commande laCde= new Commande();
	private  ListingCommande activity;

	private JComboBox<Commande> sp_cm;
	private JTextField textField;
	private JTextField textField_1;
	
	/*liste des commandes du client */
	public ListingCommande(Personne p) 
	{
		this.p=p;
		activity=this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		// creation d un panel pour taper une photo en background 
		JPanel panel_1 = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/cde.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(0, 2, 435, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		sp_cm = new JComboBox<Commande>();
		sp_cm.setBounds(0, 107, 435, 21);
		panel_1.add(sp_cm);
		
		JButton btnR = new JButton("RETOUR");
		btnR.setBounds(263, 208, 161, 23);
		btnR.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				MenuActivity page = new MenuActivity(p);
				page.setVisible(true);
				
				activity.dispose();
				
				
			}
		});
		panel_1.add(btnR);
		
		JLabel lblNewLabel = new JLabel("Mr/MME: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 136, 21);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(206, 0, 189, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 43, 98, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 40, 189, 32);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		
		List();
		createCombobox() ;
	}
	
	
	
	
	public Commande  createCombobox() 
	{
		
		
		
			//allCde=laCde.findAll();
			laCde.getListCdeByClient();
			//JOptionPane.showMessageDialog(null, "taille list getCde de cde ds frame " +laCde.findAll().size() );

			
			sp_cm.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					activity.setId();
				}
			});
			
		
		
		
		if(!allCde.isEmpty()) 
		{
			
			for(Commande comm  : allCde)
				sp_cm.addItem(comm);
        
			
		}

		else 
		{
			JLabel rep = new JLabel("zero commande  !");
	        rep.setHorizontalAlignment(SwingConstants.CENTER);
	        rep.setFont(new Font("Tahoma", Font.BOLD, 20));
			rep.setBounds(30, 360, 610, 45);
			contentPane.add(rep);
		}
		
		
	
		return laCde=(Commande) sp_cm.getSelectedItem();
	}
	
	
	

	
	
	public void setId()
	{
		List();
		laCde= (Commande) sp_cm.getSelectedItem();
		
		textField.setText("nom: "+p.getEmail());
		textField_1.setText("email: "+p.getNom());

		
	}	
	
	
	
		
	
	
	public void List() 
	{
		
		
		allCde=laCde.findAll();
				
			
				
	}
}
