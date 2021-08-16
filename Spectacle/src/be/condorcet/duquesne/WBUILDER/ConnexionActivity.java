package be.condorcet.duquesne.WBUILDER;
import be.condorcet.duquesne.POJO.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;



import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
public class ConnexionActivity extends JFrame 
{

	/*********************************************************************************
	 * 
	 * nle clic sur le btn permet l acces a la page de connexion
	 * 
	 ************************************************************************************/
	private JPanel contentPane;

	
	public ConnexionActivity()
	
	{
		
		
		
		ConnexionActivity activity = this;
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
		
		// creation d un panel pour taper une photo en background 
		JPanel panel_1 = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/t.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(0, 2, 434, 331);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		
		panel_1.setBounds(22, 10, 662, 371);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		/***********************************************************************************************************
		 * 
		 * 
		 * pour se connecter il faudra choisir son statut 
		 * si la personne se trompe mais quelle rentre qd meme des infos presentes ds la db ca ne marchera pas 
		 * car on verif sur le speud, le mdp et le statut 
		 * 
		 * 
		 * 
		 * **********************************************************************************************************/
		
		JButton btnClient = new JButton("CLIENT");
		btnClient.setForeground(UIManager.getColor("CheckBox.focus"));
		btnClient.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnClient.setBackground(Color.DARK_GRAY);
		btnClient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginByStatus page = new LoginByStatus(Client.statut);
				page.setVisible(true);
				activity.dispose();
			}
		});
		btnClient.setBounds(10, 168, 110, 57);
		panel_1.add(btnClient);
		
		JButton btnOrga = new JButton("ORGANISATEUR");
		btnOrga.setForeground(UIManager.getColor("CheckBox.focus"));
		btnOrga.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnOrga.setBackground(Color.DARK_GRAY);
		btnOrga.setBounds(118, 168, 195, 57);
		panel_1.add(btnOrga);
		btnOrga.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				LoginByStatus page = new LoginByStatus(Organisateur.statut);
				page.setVisible(true);
				
				activity.dispose();
				
			}
		});
		JButton btnArtiste = new JButton("ARTISTE");
		btnArtiste.setForeground(UIManager.getColor("CheckBox.focus"));
		btnArtiste.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnArtiste.setBackground(Color.DARK_GRAY);
		btnArtiste.setBounds(313, 168, 135, 57);
		panel_1.add(btnArtiste);
		btnArtiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LoginByStatus page = new LoginByStatus(Artiste.statut);
				page.setVisible(true);
				
				
				activity.dispose();
			}
		});
		
		JButton btnRetour = new JButton("RETOUR MENU PRINCIPAL");
		btnRetour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnRetour.setBounds(141, 319, 485, 48);
		btnRetour.setBackground(Color.RED);
		btnRetour.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartActivity page = new StartActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		panel_1.add(btnRetour);
		
		panel_1.setBounds(10, 11, 694, 390);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Connexion en tant que :");
		lblNewLabel.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(31, 17, 598, 72);
		panel_1.add(lblNewLabel);
		
		JButton btnsaitPas = new JButton("Vous ne savez pas?");
		btnsaitPas.setForeground(UIManager.getColor("CheckBox.focus"));
		btnsaitPas.setBounds(230, 251, 218, 57);
		btnsaitPas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnsaitPas.setBackground(Color.DARK_GRAY);
		panel_1.add(btnsaitPas);
		btnsaitPas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				InscriptionInfo page = new InscriptionInfo();
				page.setVisible(true);
				activity.dispose();
			}
		});

		
		JButton btnManager = new JButton("MANAGER");
		btnManager.setBackground(Color.DARK_GRAY);
		btnManager.setForeground(UIManager.getColor("CheckBox.focus"));
		btnManager.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnManager.setBounds(445, 168, 136, 57);
		panel_1.add(btnManager);
		btnManager.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				LoginByStatus page = new LoginByStatus(Manager.statut);
				page.setVisible(true);
				activity.dispose();
			}
		});

		
		
		

		
		}
	}