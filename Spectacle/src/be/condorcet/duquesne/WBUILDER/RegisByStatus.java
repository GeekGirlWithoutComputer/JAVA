package be.condorcet.duquesne.WBUILDER;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import be.condorcet.duquesne.POJO.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class RegisByStatus extends JFrame 
{
	
	private JPanel contentPane;
	
	private JTextField pseudo;
	private JTextField mdp;
	private JTextField prenom;
	private JTextField nom;
	private JTextField age;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField numEntreprise;
	private JTextField nomArtistique;// si artiste
	private JTextField nominationEntreprise;// si organisateur 
	private JTextField tufaisquoi;// si manager car je sais pas il fout quoi lui
	private JTextField email;
	
	
	
	
/*
 * LA PAGE RECOIT LE STATUT DE CELUI/CELLE QUI VEUT S INSCRIRE ET EN FONCTION DE CA LA PAGE EST DIFFERENTE
 * IL EST POSSIBLE DE PERDRE SON TEMPS A CREER UNE PAGE D INSCRIPTION PAR TYPE DE PERSONNES MAIS SI ON ARRIVE A 100
 * PERSONNES DIFFERENTES CA VA VITE DEVENIR CHIANT
 * 
 * */
	public RegisByStatus(String statut) 
	{
		RegisByStatus activity = this;
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
		
		panel_1.setBounds(10, 34, 682, 390);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("INSCRIPTION ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, -8, 499, 56);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 25));
		panel_1.add(lblNewLabel_1);

		pseudo = new JTextField();
		pseudo.setBounds(10, 82, 185, 33);
		panel_1.add(pseudo);
		pseudo.setColumns(10);

		mdp = new JTextField();
		mdp.setColumns(10);
		mdp.setBounds(205, 82, 190, 33);
		panel_1.add(mdp);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(10, 152, 185, 33);
		panel_1.add(prenom);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(205, 152, 190, 33);
		panel_1.add(nom);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(425, 82, 214, 33);
		panel_1.add(telephone);
		

		age = new JTextField();
		nomArtistique = new JTextField();
		nominationEntreprise = new JTextField();
		
		tufaisquoi=new JTextField();
		numEntreprise= new JTextField();;
		
		
		
		// ici on voit qui va s inscrire 
		// si  c est un client il aura l age en plus pr faire des stats tranche d ages des spectateurs on va pas demander ça au entreprises c est déplacé meme si justifié
		if(statut ==  Client.statut) 
		{
			JLabel lblAge = new JLabel("Age");
			lblAge.setBounds(457, 194, 59, 13);
			panel_1.add(lblAge);
			age.setColumns(10);
			age.setBounds(457, 217, 72, 33);
			panel_1.add(age);
		}
		// l orga ds sa fiche a son 
		else if(statut == Organisateur.statut) 
		{
			nominationEntreprise.setColumns(10);
			nominationEntreprise.setBounds(10, 279, 308, 33);
			panel_1.add(nominationEntreprise);
			numEntreprise.setColumns(10);
			numEntreprise.setBounds(425, 222, 214, 33);
			panel_1.add(numEntreprise);
			JLabel lblNomEntreprise = new JLabel("Nom de l'entreprise concernée");
			lblNomEntreprise.setBounds(10, 260, 185, 14);
			panel_1.add(lblNomEntreprise);
			JLabel no =  new JLabel("Numéro de l'entreprise concernée");
			no.setBounds(435,195,195,14);
			panel_1.add(no);
			
			
		}
		else if(statut == Artiste.statut)
		{
			
			nomArtistique.setColumns(10);
			nomArtistique.setBounds(10, 279, 308, 33);
			panel_1.add(nomArtistique);
			
			JLabel lblNomDeScene = new JLabel("Nom artistique ");
			lblNomDeScene.setBounds(10, 260, 185, 13);
			panel_1.add(lblNomDeScene);
		}
		
		else if(statut == Manager.statut) 
		{
			tufaisquoi.setColumns(10);
			tufaisquoi.setBounds(10, 279, 308, 33);
			panel_1.add(tufaisquoi);
			
			JLabel ReferenceManager  = new JLabel("Reference manager");
			ReferenceManager.setBounds(10, 260, 185, 14);
			panel_1.add(ReferenceManager);
			
			
			
		}

		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(10, 220, 308, 33);
		panel_1.add(adresse);

		JLabel lblNewLabel = new JLabel("Speudo");
		lblNewLabel.setBounds(10, 59, 185, 13);
		panel_1.add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(205, 58, 185, 13);
		panel_1.add(lblMotDePasse);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 128, 185, 13);
		panel_1.add(lblPrenom);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(215, 126, 185, 13);
		panel_1.add(lblNom);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 196, 185, 13);
		panel_1.add(lblAdresse);
		
		
		JButton btnNewButton = new JButton("INSCRIPTION ");
		btnNewButton.setForeground(UIManager.getColor("CheckBox.focus"));
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Personne personne = new Personne();
				
	/* pour bien yravailler on auto increm sa clé primaire ds les tav=bles sur oracles
  on ajoute pas des id en dur comme les barakis*/
			//public Personne( String s,String mdp,String t,String a ,String e,String n, String p, int age)
					if(statut == Client.statut) 
					{
						personne =  new Client(
							
								mdp.getText(), 
								pseudo.getText(), 
								telephone.getText(), 
								
								adresse.getText(),
								email.getText(),
								nom.getText(),
								prenom.getText(), 
								
								Integer.parseInt(age.getText())
							);
						
					}
					
					else if(statut == Organisateur.statut) 
					{
						personne =  new Organisateur
								(
								
										mdp.getText(), 
										pseudo.getText(), 
										telephone.getText(), 
										
										adresse.getText(),
										email.getText(),
										nom.getText(),
										prenom.getText(), 
										nominationEntreprise.getText(),
										numEntreprise.getText()
										
							);
					}
					else if(statut== Artiste.statut)
					{
						personne =  new Artiste(
								mdp.getText(), 
								pseudo.getText(), 
								telephone.getText(), 
								
								adresse.getText(),
								email.getText(),
								nom.getText(),
								prenom.getText(), 
								nomArtistique.getText()
							);
					}
					// j ai pas comprisil sert a quoi  lui blanchir les fraudes  fiscales ???????
					else if(statut== Manager.statut)
					{
						personne =  new Artiste(
								mdp.getText(), 
								pseudo.getText(), 
								telephone.getText(), 
								
								adresse.getText(),
								email.getText(),
								nom.getText(),
								prenom.getText(), 
								tufaisquoi.getText()
							);
					}
					
					
				

					Personne oki = personne.find();
					
					JOptionPane.showMessageDialog(null, "personne trouv ??"+oki);// ca renvoie true ou false a titre de test
					
					if(oki == null) 
					{
						Boolean oki2= personne.register();
						
						JOptionPane.showMessageDialog(null, "register  ??"+oki2);
						
						if(oki2) 
						{
							JOptionPane.showMessageDialog(null, "Compte crée avec succes !");

							RegisByStatus page = new RegisByStatus(statut);
							
							page.setVisible(true);
							activity.dispose();
						}
						
						else 
						{
							JOptionPane.showMessageDialog(null, "Erreur lors de la création du compte.");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Utilisateur  deja existant.");
					}
					
				
				}
			
		});
		btnNewButton.setBounds(10, 316, 459, 33);
		panel_1.add(btnNewButton);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(463, 316, 193, 33);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(UIManager.getColor("CheckBox.focus"));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisActivity page = new RegisActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		panel_1.add(btnRetour);
		
		JLabel lblGsm = new JLabel("Telephone");
		lblGsm.setBounds(425, 59, 98, 14);
		panel_1.add(lblGsm);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(435, 127, 132, 14);
		panel_1.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(425, 152, 214, 33);
		panel_1.add(email);
		email.setColumns(10);
		
		
	
	}
}
