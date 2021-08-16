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


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class LoginByStatus extends JFrame 
{

	private JPanel contentPane;
	private JTextField pseudo;
	private JTextField mdp;

	public LoginByStatus(String statut) 
	{
		LoginByStatus activity = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/c.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 2, 682, 390);
		contentPane.add(panel);
		panel.setLayout(null);

		pseudo = new JTextField();
		pseudo.setBounds(178, 100, 325, 35);
		panel.add(pseudo);
		pseudo.setColumns(10);

		JLabel lblNewLabel = new JLabel("	PSEUDO   ");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(178, 77, 139, 13);
		panel.add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("MOT DE PASSE");
		lblMotDePasse.setForeground(new Color(255, 255, 0));
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMotDePasse.setBounds(178, 145, 139, 13);
		panel.add(lblMotDePasse);

		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(178, 168, 325, 35);
		panel.add(mdp);

		JButton btnConnect = new JButton("    CONNEXION    ");
		btnConnect.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				Personne personne = new Personne();
				boolean oki= false;
				int c= personne.check_log(pseudo.getText(), mdp.getText(),statut);
				
				try
				{
					personne.setSpeudo(pseudo.getText());
					personne.setStatut(statut);
					personne.setMdp(mdp.getText());
					oki = personne.login();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
				
				if (oki) 
				{
					Personne find = personne.find();
					find.setStatut(statut);
					MenuActivity menu  = new MenuActivity(find);
					menu.setVisible(true);
					activity.dispose();
				} 
				else 
				{
					// a retravailler niveau pasw et mdp
					if(c!=2)
					{
						JOptionPane.showMessageDialog(null, "log pseudo incorrect ");
						if(c!=3) 
						{
							JOptionPane.showMessageDialog(null, "log mdp incorrect ");
						}
						else if(c!=4)
						{
							JOptionPane.showMessageDialog(null, "log statut  incorrect ");
						}
						
					}
					
					
						
					
					//JOptionPane.showMessageDialog(null, "log incorrects ");
				}

			}
		});
		btnConnect.setForeground(Color.WHITE);
		btnConnect.setBackground(Color.DARK_GRAY);
		btnConnect.setBounds(178, 221, 322, 35);
		panel.add(btnConnect);

		JButton btnRetour = new JButton("RETOUR AU MENU ");
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				StartActivity page = new StartActivity();
				page.setVisible(true);
				activity.dispose(); 
			}
		});
		
		btnRetour.setBounds(368, 314, 281, 41);
		panel.add(btnRetour);
	}
}
