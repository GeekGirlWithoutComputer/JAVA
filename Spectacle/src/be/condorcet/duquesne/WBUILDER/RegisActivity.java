package be.condorcet.duquesne.WBUILDER;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;



import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RegisActivity extends JFrame
{

	
	private JPanel contentPane;

	public RegisActivity() 
	{
		RegisActivity activity = this;
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/R.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(30, 11, 662, 371);
		contentPane.add(panel_1);
		

		JButton btnClient = new JButton("CLIENT");
		btnClient.setBounds(303, 178, 134, 35);
		btnClient.setForeground(new Color(255, 255, 0));
		btnClient.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnClient.setBackground(Color.DARK_GRAY);
		btnClient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				RegisByStatus page = new RegisByStatus(Client.statut);
				page.setVisible(true);
				
				activity.dispose();
				
				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnClient);

		JButton btOrga = new JButton("ORGANISATEUR");
		btOrga.setBounds(124, 178, 190, 35);
		btOrga.setForeground(new Color(255, 255, 0));
		btOrga.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btOrga.setBackground(Color.DARK_GRAY);
		panel_1.add(btOrga);
		btOrga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegisByStatus page = new RegisByStatus(Organisateur.statut);
				page.setVisible(true);
				
				activity.dispose();
			}
		});
		JButton btnArtiste = new JButton("ARTISTE");
		btnArtiste.setBounds(0, 178, 134, 35);
		btnArtiste.setForeground(new Color(255, 255, 0));
		btnArtiste.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnArtiste.setBackground(Color.DARK_GRAY);
		panel_1.add(btnArtiste);
		btnArtiste.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisByStatus page = new RegisByStatus(Artiste.statut);
				page.setVisible(true);
				
				activity.dispose();
			}
		});
		
		JButton btnManager = new JButton("MANAGER");
		btnManager.setForeground(new Color(255, 255, 0));
		btnManager.setBackground(Color.DARK_GRAY);
		btnManager.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnManager.setBounds(435, 178, 156, 35);
		panel_1.add(btnManager);
		
		btnManager.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisByStatus page = new RegisByStatus(Manager.statut);
				page.setVisible(true);
				
				activity.dispose();
			}
		});
		//retour premiere page on peut aussi envisager de fre retour sur strt activity
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 20));
		btnRetour.setBounds(434, 286, 179, 61);
		btnRetour.setBackground(Color.RED);
		btnRetour.setForeground(Color.BLACK);
		btnRetour.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainActivity page = new MainActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		panel_1.add(btnRetour);
		
		JButton btnBheu = new JButton("VOUS NE SAVEZ PAS?");
		btnBheu.setForeground(new Color(255, 215, 0));
		btnBheu.setBackground(Color.DARK_GRAY);
		btnBheu.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnBheu.setBounds(0, 238, 241, 34);
		panel_1.add(btnBheu);
		btnBheu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				InscriptionInfo page = new InscriptionInfo();
				page.setVisible(true);
				activity.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Inscription en tant que : ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana Pro Cond Black", Font.BOLD, 28));
		lblNewLabel.setBounds(67, 40, 447, 68);
		panel_1.add(lblNewLabel);
		
		


	}
}