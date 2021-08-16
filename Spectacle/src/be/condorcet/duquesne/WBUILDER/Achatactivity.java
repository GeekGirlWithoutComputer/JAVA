package be.condorcet.duquesne.WBUILDER;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

import be.condorcet.duquesne.POJO.Artiste;
import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Commande;
import be.condorcet.duquesne.POJO.Commande.livraison;
import be.condorcet.duquesne.POJO.Commande.payement;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Place;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Reservation;

public class Achatactivity extends JFrame 
{
/****************************************************************
 * 				VARIABLES
 * ************************************************************/
	private JPanel contentPane;
	private JPanel panel;
/******************************************************************************************
 * 
 * 
 * POUR INSERER DANS LES TABLES CDES ET PLACES ON A BESOIN DE /
 * 			fk cde
 * 			fk representation
 * 			fk config pr chopper id cat
 * 			fk personne 
 * 
 * *****************************************************************************************/	
	private Personne personne;
	private Reservation currentSpectacle;
	private Representation  representation;
	private Achatactivity activity;
	private Commande commande;
	private Configuration configuration;
	private float prix ;
	
	
	
	private ButtonGroup modeLivraison = new ButtonGroup();
	private ButtonGroup modePaiement = new ButtonGroup();
	/***************************************************************************************************
	 * 
	 *  les radios btn pr le paiement et la livraison
	 * 
	 * *************************************************************************************************/
	private JRadioButton rdbtnSurPl,
	rdbtnPrior, 
	rdbtnSecur, 
	rdbtnVisa,
	rdbtnPayP,
	rdbtnSepa,
	rdbtnPayC,
	rdbtnBc;
	
	
	private JLabel lblPrix;
	private JLabel lblPrixValue;
	private JLabel lblNewLabel_1;
	private boolean click = false;
	private JButton btnRetou;
	
	int nbrBronze, nbrArgent, nbrOr , nbrDiamant , nbrBase;
	private JButton cde;

	public Achatactivity(Representation representation,
			Personne personne, 
			Commande commande , 
			Configuration configuration)
	{
		activity=this;
		this.representation = representation;
		this.personne = personne;
		this.commande = commande;
		this.configuration = configuration;
		this.commande=commande;
		commande= new Commande();// a modif 
		prix = commande.getTotal();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel= new JPanel() 
		{
			public void paintComponent(Graphics g) 
			{
				Image img = Toolkit.getDefaultToolkit()
						.getImage(MainActivity.class
								.getResource("/be/condorcet/duquesne/IMG/s.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(10, 60, 431, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		JButton btnAcheter = new JButton("Acheter");
		btnAcheter.setBackground(Color.DARK_GRAY);
		btnAcheter.setForeground(Color.WHITE);
		btnAcheter.setBounds(0, 225, 228, 48);
		btnAcheter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				payer();
			}
		});
		panel.add(btnAcheter);
		
		
		
		rdbtnSurPl = new JRadioButton("Sur place");
		rdbtnSurPl.setBackground(Color.LIGHT_GRAY);
		rdbtnSurPl.setBounds(24, 54, 121, 21);
		panel.add(rdbtnSurPl);

		rdbtnPrior = new JRadioButton("Envoir avec imbre prior");
		rdbtnPrior.setBackground(Color.LIGHT_GRAY);
		rdbtnPrior.setBounds(24, 86, 179, 21);
		panel.add(rdbtnPrior);

		rdbtnSecur = new JRadioButton("Envoie s\u00E9curis\u00E9 ( + \u20AC10 ) ");
		rdbtnSecur.setBackground(Color.LIGHT_GRAY);
		rdbtnSecur.setBounds(24, 117, 179, 21);
		rdbtnSecur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				activity.click = !click;
				if(click) 
				{
					
					prix=prix+ 10;
					lblPrixValue.setText(Float.toString(prix));
				}
				else 
				{
				
					lblPrixValue.setText(Float.toString(prix));
				}
				
			}
		});
		panel.add(rdbtnSecur);

		rdbtnVisa = new JRadioButton("VISA");
		rdbtnVisa.setBackground(Color.LIGHT_GRAY);
		rdbtnVisa.setBounds(266, 54, 103, 21);
		panel.add(rdbtnVisa);

		rdbtnPayP = new JRadioButton("PAYPALL");
		rdbtnPayP.setBackground(Color.LIGHT_GRAY);
		rdbtnPayP.setBounds(266, 86, 103, 21);
		panel.add(rdbtnPayP);

		rdbtnSepa = new JRadioButton("SEPA");
		
		rdbtnSepa.setBackground(Color.LIGHT_GRAY);
		rdbtnSepa.setBounds(266, 117, 103, 21);
		panel.add(rdbtnSepa);
		rdbtnPayC = new JRadioButton("PAYCONIQ");
		rdbtnPayC.setBackground(Color.LIGHT_GRAY);
		rdbtnPayC.setBounds(266, 141, 109, 23);
		panel.add(rdbtnPayC);
		
		rdbtnBc = new JRadioButton("BANCONTACT");
		rdbtnBc.setBackground(Color.LIGHT_GRAY);
		rdbtnBc.setBounds(266, 167, 109, 23);
		panel.add(rdbtnBc);

		JLabel lblNewLabel = new JLabel("MODE LIVRAISON : ");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 30, 187, 18);
		panel.add(lblNewLabel);

		JLabel lblModeDePaiment = new JLabel("MODE PAIEMENT :");
		lblModeDePaiment.setForeground(Color.YELLOW);
		lblModeDePaiment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModeDePaiment.setBounds(266, 30, 155, 18);
		panel.add(lblModeDePaiment);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		/*
		cde = new JButton("cde");
		cde.setBounds(10, 11, 89, 23);
		cde.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				payer() ;
				JOptionPane.showMessageDialog(null, "id cde "+activity.commande.getId());
				if (activity.commande.getId()!=0)
		{
			Place p= new Place();
			p.create(activity.commande.getId());
			JOptionPane.showMessageDialog(null, "place cree");
		}
				
				
			}
		});
		
		
		panel_1.add(cde);*/
		/******************************************************************************************************
		 * 
		 * 			pour n autoriser qu un seul choix de rdio btn on doit les mettre dans des rzdio froupe
		 * 
		 * *****************************************************************************************************/

		modeLivraison.add(rdbtnPrior);
		modeLivraison.add(rdbtnSurPl);
		modeLivraison.add(rdbtnSecur);
		modePaiement.add(rdbtnSepa);
		modePaiement.add(rdbtnPayP);
		modePaiement.add(rdbtnVisa);
		modePaiement.add(rdbtnPayC);
		modePaiement.add(rdbtnBc);
		
		
		lblPrix = new JLabel("Prix : ");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrix.setBounds(58, 162, 45, 21);
		panel.add(lblPrix);
		
		lblPrixValue = new JLabel("");
		lblPrixValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixValue.setBounds(125, 163, 90, 21);
		panel.add(lblPrixValue);
		lblPrixValue.setText("0.0 \u20AC");
		
		lblNewLabel_1 = new JLabel("( +5 \u20AC de frais de gestion de dossier)");
		lblNewLabel_1.setBounds(10, 187, 193, 27);
		panel.add(lblNewLabel_1);
/******************************************************************************************************
 * 
 * 			TEST ID PERSONNE BIEN RECUP JUSTE TEST DEBUG
 * 
 * 
 * ******************************************************************************************************/		
	/*	JButton idP = new JButton("id perso");
		idP.setBounds(190, 242, 89, 23);
		panel.add(idP);
		
		idP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null,"id p   "+personne.getId());
				
				
			}
		});  */
				
				btnRetou = new JButton("Quitter");
				btnRetou.setBounds(221, 225, 210, 48);
				panel.add(btnRetou);
				btnRetou.setBackground(Color.DARK_GRAY);
				btnRetou.setForeground(Color.WHITE);
				btnRetou.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						// ça ferme la frame 
						activity.dispose();
					}
				});
		
		
		
		
	}

	public void payer() 
	{
		// 5 euros de frais de dossier recu en param des couts des billets
		this.commande.augmenterCout(5);
		/*en fct de ce qui sera choisi on attribue la valeur de paiement et
		 * de livraison a la cde*/
		if (rdbtnPrior.isSelected()) 
		{
			this.commande.setModeDeLivraison(livraison.TIMBRE_PRIOR);
		} 
		else if (rdbtnSurPl.isSelected()) 
		{
			this.commande.setModeDeLivraison(livraison.SUR_PLACE);
		} 
		else 
		{
			this.commande.setModeDeLivraison(livraison.ENVOI_SECURISE);
		}

		if (rdbtnSepa.isSelected()) 
		{
			this.commande.setModeDePayement(payement.SEPA);
		} 
		else if (rdbtnPayP.isSelected()) 
		{
			this.commande.setModeDePayement(payement.PAYPAL);
		} 
		else if (rdbtnPayC.isSelected()) 
		{
			this.commande.setModeDePayement(payement.PAYCONIQ);
		} 
		else 
		{
			this.commande.setModeDePayement(payement.VISA);
		}
		
		/*j attribue la fkpersonne a la commande */
		
		boolean oki =
				this.commande.create(personne.getId());
		
		if(oki) 
		{
			//JOptionPane.showMessageDialog(null, "oki pr la cde cree!");
			createPlaces();
			decomptePlace() ; // prob 
			
			FinalActivityPlace page = new FinalActivityPlace();
			page.setVisible(true);
			activity.dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "prob non géré car trop compliqué a ce stade !");
		}
	}
	public void createPlaces() 
	{
		 nbrBase = 0;
		 nbrOr = 0;
		 nbrArgent = 0;
		 nbrDiamant = 0;
		 nbrBronze = 0;

		for(Place place : this.commande.getPlaces()) 
		{
			switch(place.getType_categorie()) 
			{
				
				case BRONZE : 
						nbrBronze++;
					break;
				case ARGENT : 
						nbrArgent++;
					break;
				case OR : 
						nbrOr++;
					break;
				case DIAMANT : 
						nbrDiamant++;
					break;
			}// insert place ( id,prix,fkcde,fkrepre,typepalce)
			place.create(commande.getId());
		}
		
	}
	public void decomptePlace() 
	{
		List<Categorie> categories =configuration.getCategories();
		
		for(Categorie categorie : categories) 
		{
			//categorie.
			//setConfiguration(configuration);
			switch(categorie.getType())
			{
		
			case "BRONZE" : 
				for(int i = 0 ; i < nbrBronze ; i ++) 
					{
						categorie.catDown();
					}
				break;
			case "ARGENT" : 
				for(int i = 0 ; i < nbrArgent ; i ++)
					{
						categorie.catDown();
					}
				break;
			case "OR" : 
				for(int i = 0 ; i < nbrOr ; i ++) 
					{
						categorie.catDown();
					}
				break;
			case "DIAMANT" : 
				for(int i = 0 ; i < nbrDiamant ; i ++) 
					{
						categorie.catDown();
					}
				break;
		}
		
		}
		
		
	}
}
