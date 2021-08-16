package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import be.condorcet.duquesne.POJO.Artiste;
import be.condorcet.duquesne.POJO.Categorie;
import be.condorcet.duquesne.POJO.Configuration;
import be.condorcet.duquesne.POJO.Configuration.Ticket;
import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.PlanningSalle;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Reservation;
import be.condorcet.duquesne.POJO.Spectacle;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import com.toedter.components.JLocaleChooser;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class ReservationSalle extends JFrame 
{

	private JPanel contentPane;
	private Personne personne;
	private Configuration laConfig;
	private JTextArea descCF;
	private JComboBox cbConfig ;
	/*lors de la loca on a besoin type de place , des artistes et d un spectacle et d une repr*/
	Spectacle spectacle = new Spectacle();
	List<Representation> representationList = new ArrayList<Representation>();
	List<Artiste> artisteList= new ArrayList<Artiste>();
	List<Artiste> artisteSlect = new ArrayList<Artiste>();
	private Ticket place = Ticket.DEBOUT;
	// pr l add spect 
	private JTextField titre;
	private JTextField genre;
	private JTextField descrip;
	private JTextArea desSp;
	private JSpinField HD,HF;// crasse de spinner prb avec les float vive builder de merde 
	
	private JSpinField dia,arg,or,brz,aucun;
	private JPanel panel;
	private JLabel or_, diam,bronze,argent,debout;
	private JLabel labelArtiste;
	private JTextPane descriptionField;
	JButton AddSpectacle;
	private int maxParPersonne;
	private JTextArea description_;
	private JCalendar date,date1,date2;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton addR;
	private JLabel lblNewLabel;
	private JLabel adj;
	private JLabel adj2;

	private JComboBox<Artiste> cbArtiste;
	private JButton choix;
	private ReservationSalle activity;
	private JSpinner prix_;
	private JSpinner  nbreMaxClient;
	private JTextField textField_1;

	
	/*affichage des spevtacles ds la db*/
	private JComboBox<Spectacle> cbS;
	JComboBox <PlanningSalle>cbPl;
	private List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
	private JButton addResc;
	// add 12 08 pr test 
	private PlanningSalle pl;
	List<PlanningSalle> plp= new ArrayList<PlanningSalle>();
	List<Configuration> allConfig= new ArrayList<Configuration>();
	
	private   JSpinner solde_;
	private JSpinner acompte_;
	
	/******************************************************************************************************
	 * 
	 * 
	 * 	la reservation de salle de spectacle se fait par un organisateur
	 * 
	 * ******************************************************************************************************/
	public ReservationSalle(Personne org) 
	{
		
			activity = this;
			this.personne=org;
			this.pl=new PlanningSalle();
			
			List();
			ListP() ;
			
		
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 562, 698);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
/********************************************************************************************************************
 * 
 * 	panel qui contient l image backgd
 * 
 * *****************************************************************************************************************/
			panel = new JPanel() 
			{
				public void paintComponent(Graphics g) {
					Image img = Toolkit.getDefaultToolkit()
							.getImage(MainActivity
							.class.getResource("/be/condorcet/duquesne/IMG/rs2.jpg"));
							g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setBounds(10, 11, 536, 683);
			contentPane.add(panel);
			panel.setLayout(null);

			JButton btnR = new JButton("REVENIR AU MENU ");
			btnR.setBackground(Color.DARK_GRAY);
			btnR.setForeground(Color.YELLOW);
			btnR.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					MenuActivity page = new MenuActivity(personne);
					page.setVisible(true);
					activity.dispose();
				}
			});
			btnR.setBounds(0, 620, 258, 27);
			panel.add(btnR);

			
			// titre pr le spectacle que l org va creer
			titre = new JTextField();
			titre.setBounds(116, 2, 246, 20);
			panel.add(titre);
			titre.setColumns(10);
			// label d affichage 
			JLabel labelTitre = new JLabel("SPECTACLE:");
			labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitre.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));
			labelTitre.setForeground(Color.RED);
			labelTitre.setBounds(0, 2, 104, 20);
			panel.add(labelTitre);

			
			// label affichage prix 
			JLabel labelPrix = new JLabel("Prix");
			labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
			labelPrix.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
			labelPrix.setForeground(Color.BLACK);
			labelPrix.setBounds(10, 546, 90, 27);
			panel.add(labelPrix);

			// label affichage 
			JLabel nbre = new JLabel("Nombre Max par client");
			nbre.setHorizontalAlignment(SwingConstants.CENTER);
			nbre.setBounds(399, 33, 131, 26);
			panel.add(nbre);
			// champ pr entrer le nbre de place max par client
			nbreMaxClient = new JSpinner();
			nbreMaxClient.setBounds(409, 63, 102, 20);
			panel.add(nbreMaxClient);
			// label affichage config
			JLabel lblNewLabel_1 = new JLabel("Type configuration");
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(355, 465, 183, 20);
			panel.add(lblNewLabel_1);
			// champ ou on entre le prix
			prix_ = new JSpinner();
			prix_.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
			prix_.setBounds(0, 571, 104, 20);
			panel.add(prix_);
			
			/* btn qui globalise la totaliyé de la reservation de salle*/
			JButton add = new JButton("AJOUTER");
			add.setForeground(Color.YELLOW);
			add.setBackground(Color.DARK_GRAY);
			add.setBounds(265, 620, 273, 27);
			panel.add(add);
			add.addActionListener(e -> 
			{
				
				reserver() ;
				
			});
			/**************************************************************************************************
			 * 
			 * 		la selection de date den=but de fin se fait sur deux calendriers
			 * 
			 * 
			 * ************************************************************************************************/
			date = new JCalendar();
			date.setBounds(31, 107, 205, 153);
			panel.add(date);
			date2 = new JCalendar();
			date2.setBounds(279, 107, 205, 153);
			panel.add(date2);
			
			JLocaleChooser localeChooser = new JLocaleChooser();
			localeChooser.setBounds(31, 89, 205, 20);
			panel.add(localeChooser);
			// label affichage 
			JLabel lblNewLabel_2 = new JLabel("ARTISTE");
			lblNewLabel_2.setForeground(Color.RED);
			lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(116, 281, 127, 20);
			panel.add(lblNewLabel_2);

			
			/*******************************************************************************************************
			 * 
			 *  combo des differentes configu
			 * 
			 * ******************************************************************************************************/
			
			
			
			
			
			cbConfig = new JComboBox<Configuration>();
					//new JComboBox();
			cbConfig.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));

			cbConfig.setModel(new DefaultComboBoxModel(Ticket.values()));
			
			
			

			cbConfig.setBounds(355, 479, 180, 26);
			panel.add(cbConfig);
			
			
			
			/* creation des places en fct de ce qui est choisi a ameliorer */
			
			
				
				
				
		
			
			cbConfig.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					// je choppe la place select
					place = (Ticket) cbConfig.getSelectedItem();
					//JOptionPane.showMessageDialog(null, "id configselect  "+cbConfig.getSelectedItem()); donne la cat 
					// je formate les chmps je les nettoie
					clear();
					//si c est debout y aura zero categorie
					if (place == Ticket.DEBOUT) 
					{
						aucun.setVisible(true);
						debout.setVisible(true);
					} 
					// si on est ds la config cirque assis
					else if (place == Ticket.CIRQUE_ASSIS) // a les 4
					{
						// visibimité label et chp
						brz.setVisible(true);
						bronze.setVisible(true);
						arg.setVisible(true);
						argent.setVisible(true);
						or.setVisible(true);
						
						or_.setVisible(true);
						
						dia.setVisible(true);
						diam.setVisible(true);
						
						
					} 
					else// a les 3
					{
						brz.setVisible(true);
						bronze.setVisible(true);
						arg.setVisible(true);
						argent.setVisible(true);
						or.setVisible(true);
						
						or_.setVisible(true);
					}
				
					
					
				}
			});
				
			
			/*l org doit en premier ajouté le spectacle u il configure ensuite */
			AddSpectacle = new JButton("Ajouter Spectacle");
			AddSpectacle.setBounds(399, 2, 139, 20);
			panel.add(AddSpectacle);
			
			AddSpectacle.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					addSpectacle() ;
					//JOptionPane.showMessageDialog(null, "spectacle ajouté ");
				}
			});
			
			
			try
			{
				String titre_ = titre.getText();
				 spectacle.setLibel(titre_);
				// Spectacle oki = spectacle.check();
				//JOptionPane.showMessageDialog(null, "id spect selon libel "+spectacle.check());
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			
			JOptionPane.showMessageDialog(null, "oki specta "+spectacle.getId());
			artisteList() ;
			
		
		}
	
	/*  LISTE D  ARTISTES */
	
	private void artisteList() 
	{
		// liste de ts es artistes
		Personne personne= new Personne();/*****/
		artisteList = personne.findAllArtiste();
				
		choix = new JButton("CHOISIR");
		choix.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));
		choix.setForeground(Color.BLACK);
		choix.setBackground(Color.DARK_GRAY);
		choix.setBounds(10, 299, 92, 26);
		choix.addActionListener(new ActionListener() 
		{
			/* l org fera des choix d artistes qui seront ajoutés a la liste des choix d artistes */ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Artiste artiste = (Artiste) cbArtiste.getSelectedItem();
				artisteSlect.add(artiste);
				//pr ne pas les choisir deux fois on les supprme de la selecttion on peut pas etre deux fois au meme endroit en tte logique 
				cbArtiste.removeItem(cbArtiste.getSelectedItem());
			}
		});
		panel.add(choix);
		setIdArtiste(artisteList);
	}

	private void setIdArtiste(List<Artiste> artistes)
	{
		cbArtiste = null;
		cbArtiste = new JComboBox<Artiste>();
		for (Artiste artiste : artistes) 
		{
			cbArtiste.addItem(artiste);
		}
		cbArtiste.setBounds(97, 298, 201, 27);
		panel.add(cbArtiste);
		
		description_ = new JTextArea();
		description_.setBounds(10, 351, 205, 40);
		panel.add(description_);
		
		JLabel lblNewLabel_3 = new JLabel("DESCRIPTION REPRESENTATION");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 334, 224, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENRE : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(0, 28, 63, 27);
		panel.add(lblNewLabel_4);
		
		genre = new JTextField();
		genre.setBounds(62, 30, 139, 20);
		panel.add(genre);
		genre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Description Spectacle");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(204, 28, 148, 19);
		panel.add(lblNewLabel_5);
		
		desSp = new JTextArea();
		desSp.setBounds(204, 43, 194, 36);
		panel.add(desSp);
		
		JLabel lblNewLabel_6 = new JLabel("Heure Debut");
		lblNewLabel_6.setBounds(10, 402, 92, 20);
		panel.add(lblNewLabel_6);
		
		JLabel HeureFin = new JLabel("Heure Fin");
		HeureFin.setBounds(172, 402, 92, 20);
		panel.add(HeureFin);
		
	   
		
		adj = new JLabel("Aujourd'hui: ");
		adj.setBounds(31, 258, 205, 14);
		panel.add(adj);
		adj.setText(date.getDate().toString());
		
		adj2 = new JLabel("Aujourd'hui: ");
		adj2.setBounds(289, 258, 211, 14);
		panel.add(adj2);
		adj2.setText(date2.getDate().toString());
		
		/***********************************************************************************************************************
		 * 
		 * 			PAS DE MEILLEUR SYSTEME POUR LE CHOIX DES DATES
		 * 			ENVISAGER SWITCH DES DATES POUR BIEN DISSOCIER DATE DEBUT ET DATE FIN 
		 * 
		 * ********************************************************************************************************************/
		date.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) 
			{
				adj.setText(date.getDate().toLocaleString());
			}
			
		});
		date2.addPropertyChangeListener(new PropertyChangeListener() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) 
			{
				adj2.setText(date2.getDate().toLocaleString());
			}
		});
		
		
		
		/****************************************************************
		 * 
		 * 		PLACE TYPE DIAMAND
		 * **************************************************************/
		dia = new JSpinField();
				//new JSpinner(); prob avc les int 
		dia.setBounds(10, 515, 90, 20);
		panel.add(dia);

		/****************************************************************
		 * 
		 * 		PLACE TYPE ARGENT
		 * **************************************************************/
		arg = new JSpinField();
		arg.setBounds(107, 515, 102, 20);
		panel.add(arg);

		/****************************************************************
		 * 
		 * 		PLACE TYPE OR
		 * **************************************************************/
		or = new JSpinField();
		or.setBounds(200, 515, 117, 20);
		panel.add(or);
		/****************************************************************
		 * 
		 * 		PLACE TYPE BRONZE
		 * **************************************************************/
		
		brz =new JSpinField();
		brz.setBounds(220, 515, 179, 20);
		panel.add(brz);
		
		
		
		/****************************************************************
		 * 
		 * 		PLACE TYPE DE CONFIG DEBOUT OU Y A PAS DE CAT
		 * 
		 * **************************************************************/
		
		aucun =new JSpinField();
		aucun.setBounds(220, 571, 139, 20);
		panel.add(aucun);
		
		
		/******************************************************************
		 * 
		 * LABEL DES PLACES
		 * 
		 * ***************************************************************/
		 diam = new JLabel("DIAMANT");
		 diam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		 diam.setForeground(Color.BLACK);
		diam.setBounds(21, 491, 63, 14);
		panel.add(diam);
		
		 argent = new JLabel("ARGENT");
		 argent.setForeground(Color.BLACK);
		 argent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		argent.setBounds(116, 491, 46, 14);
		panel.add(argent);
		
		 or_ = new JLabel("OR");
		 or_.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		 or_.setForeground(Color.BLACK);
		or_.setBounds(321, 493, 46, 14);
		panel.add(or_);
		
		bronze = new JLabel("BRONZE");
		bronze.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		bronze.setForeground(Color.BLACK);
		bronze.setBounds(204, 491, 46, 14);
		panel.add(bronze);
		
		debout = new JLabel("DEBOUT");
		debout.setForeground(Color.BLACK);
		debout.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		debout.setBounds(277, 548, 85, 23);
		panel.add(debout);
		
		
		
		
		/**********************************************************************
		 * 
		 * CHAMPS HEURE DEBUT HEURE FIN 
		 * *********************************************************************/
		HD = new JSpinField();
		HD.setBounds(0, 433, 121, 20);
		panel.add(HD);
		
		HF = new JSpinField();
		HF.setBounds(97, 433, 121, 20);
		panel.add(HF);
		
		
		/*****************************************************************************
		 * 
		 * 		LABEL DATE DEBUT DATE FIN 
		 * 
		 * ****************************************************************************/
		JLabel dateDebut = new JLabel("DATE DEBUT: ");
		dateDebut.setHorizontalAlignment(SwingConstants.LEFT);
		dateDebut.setForeground(Color.RED);
		dateDebut.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
		dateDebut.setBounds(31, 66, 205, 20);
		panel.add(dateDebut);
		
		JLabel dateFin = new JLabel("DATE FIN: ");
		dateFin.setForeground(Color.RED);
		dateFin.setBounds(283, 92, 201, 14);
		panel.add(dateFin);
		
		
		
		
		
		 setR();
		
		
		
		cbS = new JComboBox<Spectacle>();
		cbS.setBounds(308, 303, 222, 22);
		panel.add(cbS);
		
		JLabel spect_enre = new JLabel("Spectacle enregistr\u00E9 ");
		spect_enre.setBounds(308, 287, 222, 14);
		panel.add(spect_enre);
		
		
		
		/********************************************************************************************************************************************
		 * 
		 * 
		 * 
		 * 
		 * 	bouton de debbug pr test un a un les ajouts 
		 * 
		 * 
		 * 
		 * **************************************************************************************************************************************************/
		
		/*
		
		JButton btnNewButton = new JButton("addRepresentation");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addRepresentation();
				
			}
		});
		
		btnNewButton.setBounds(265, 368, 89, 23);
		panel.add(btnNewButton);
		/* DEBUG */
		/*
		
		JButton btnNewButton_1 = new JButton("addConfiguration");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addConfiguration();
				JOptionPane.showMessageDialog(null, "config avec succes !");
			}
		});
		btnNewButton_1.setBounds(244, 370, 63, 23);
		panel.add(btnNewButton_1);
	
		addResc = new JButton("addReservation");
		addResc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				PlanningSalle planningSalle = null;
				
					planningSalle = addPlanning();
				
			
				addReservation(planningSalle);
				
			}
		});
		addResc.setBounds(273, 336, 89, 23);
		panel.add(addResc);
		/********************************************************************************************************
		 * 
		 * 
		 * 
		 * 		pour mettre a jour les spectacles si l org en ajoute un 
		 * 
		 * ********************************************************************************************************/
		JButton refresh = new JButton("rafraichir Spectcle ");
		refresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					activity.createCombobox();
					// ca refresh bien la combobox apres ajout 
			}
		});
		refresh.setBounds(382, 333, 148, 23);
		panel.add(refresh);
		
		
		/*********************************************************************************************
		 * 
		 *   debbug planning pr voir si on choppe bien les id 
		 * 
		 * ***************************************************************************************/
		/*
		cbPl = new JComboBox();
		cbPl.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cbPl.setBounds(275, 401, 257, 22);
		panel.add(cbPl);
		
		*/
		
		
		clear();
		
		
		
		
		
		
		
		
		
		
		
		
		
		createCombobox() ;
		//createComboboxPl() ; a titre de test 
		addRepresentation();
		
		
		/**********************************************************************
		 * 
		 * 
		 * 		BOUTON AJOUT DU PLANNING
		 * 
		 ************************************************************************/
		
		JButton addP = new JButton("planning");
		addP.setBounds(437, 429, 89, 23);
		panel.add(addP);
		
		JLabel lblNewLabel_7 = new JLabel("Descriptionn Configuration");
		lblNewLabel_7.setBounds(375, 374, 155, 14);
		panel.add(lblNewLabel_7);
		
		descCF = new JTextArea();
		descCF.setBounds(368, 394, 162, 27);
		panel.add(descCF);
		
		
		
		solde_ = new JSpinner();
		solde_.setBounds(440, 546, 90, 20);
		panel.add(solde_);
		
		JLabel lblNewLabel_8 = new JLabel("Acompte");
		lblNewLabel_8.setBounds(369, 574, 59, 14);
		panel.add(lblNewLabel_8);
		
		acompte_ = new JSpinner();
		acompte_.setBounds(444, 571, 86, 20);
		panel.add(acompte_);
		
		JLabel solde = new JLabel("Solde");
		solde.setHorizontalAlignment(SwingConstants.CENTER);
		solde.setBounds(352, 549, 78, 14);
		panel.add(solde);
		
		
		addP.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				PlanningSalle p ;
					p=addPlanning();
					JOptionPane.showMessageDialog(null, "planning avec succes !");
					
					//JOptionPane.showMessageDialog(null, "fk plann !"+pl.getId());
					//JOptionPane.showMessageDialog(null, "cbo plann !"+createComboboxPl() );
				
					
					
				
				
			}
		});
		
		
		
		
		

	}
	
	/*affichage des spectacles */
	
	public Spectacle  createCombobox() 
	{
		cbS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
		for (Spectacle  sp:
			allSpectacles) 
		{
			cbS.addItem(sp);
		}		
		
		
		;
	
		return spectacle =(Spectacle) cbS.getSelectedItem();
	}
	
	
	public PlanningSalle  createComboboxPl() 
	{
		cbS.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setIdPl();
			}
		});
		for (PlanningSalle  Pl:
			plp) 
		{
			cbPl.addItem(Pl);
		}		
		
		
		;
	
		return pl= (PlanningSalle) cbPl.getSelectedItem();
	}
	
	public void setIdPl()
	{
	
		pl= (PlanningSalle) cbPl.getSelectedItem();
		
		
	}
	public void setId()
	{
	
		spectacle= (Spectacle) cbS.getSelectedItem();
		
		
	}
	
	/*******************************************************************************************
	 * 
	 *  methode pr rendre des champs show ou hidden 
	 *  si on choppe DEBOUT ben y aura quedal en categorie
	 *  si on choque cirqueAssis y aura xxxx etc 
	 * 
	 * 
	 * *****************************************************************************************/
	
	private void clear() 
	{
		/*si la config debout donc sans cat est select */
		
		if (aucun != null)
		{
			aucun.setVisible(false);
		}
		/*si la cat bze est select */
		if (brz != null)
		{
			brz.setVisible(false);
		}
		/* si la cat or est select */
		if (or != null)
		{
			or.setVisible(false);
		}
			
		if (arg != null)
		{
			arg.setVisible(false);
		}
			
		if (dia!= null)
		{
			dia.setVisible(false);
		}
		/**********************************************************
		 * 
		 * 	MEME PROCEDURE AVC LES LABELS
		 * *********************************************************/	
		if (bronze != null)
		{
			bronze.setVisible(false);
		}
			
		if (or_ != null)
		{
			or_.setVisible(false);
		}
			
		if (argent != null)
		{
			argent.setVisible(false);
		}
			
		if (diam != null)
		{
			diam.setVisible(false);
		}
		
		if (debout != null)
		{
			debout.setVisible(false);
		}
			
	}
	
	
	
	
	/*		AJOUT ARTISTE 			*/
	
	private void createArtistes() 
	{
		for (Artiste artiste : artisteSlect) 
		{
			
		

			artiste.create();
		}
	}
	
	private boolean addSpectacle() 
	{
		//INSERT INTO Spectacle_(\"libel\",\"genre\",\"description\",\"nbrePlaceParClient\")"
		String titre_ = titre.getText();
		String genre_= genre.getText();
		String description_=desSp.getText();
		spectacle.setLibel(titre_);
		spectacle.setGenre(genre_);
		spectacle.setDescription(description_);
		spectacle.setNombrePlaceParClient((Integer) nbreMaxClient.getValue());
		
		spectacle.create();
		
		
		
		// fctionne
		return true;
	}
	
	
	private Date getDate() 
	{
		java.util.Date day = date.getDate();
		return new java.sql.Date(day.getTime());
	}
	
	
	/*******************************************************************************************
	 * 
	 * 			REPRESENTATION 
	 * 			ajout dans la liste les elements 
	 * 
	 * 
	 * ****************************************************************************************/
	private void addRepresentation()
	{
		
		for (Representation representation : representationList)
		{
			representation.create();
			//JOptionPane.showMessageDialog(null, "representa de addR/ repreList "+representationList);
		}
		
	}
	
	
	
	/*oki*/
	
	private PlanningSalle addPlanning() 
	{
		// pr obtenir la date ou l on fait la reserva de salle
		Date date = getDate();
		Date date2=getDate();
		String d1=adj.getText();
		
		
		
		//public PlanningSalle( Date dateFin, Date dateDebut, Date dateReservation,Spectacle spectacle) 
		PlanningSalle p= new PlanningSalle(date2,date,date,spectacle);
		//JOptionPane.showMessageDialog(null, "id specta   !"+spectacle.getId());
				//(date, spectacle);
		p.create();
		
		return p;
	}

	private void addReservation(PlanningSalle planningSalle) 
	{
		//public Reservation(float acompte ,float solde , 
		//float prix,String statut, PlanningSalle planningSalle , Personne organisateur) 
		/*spinner a cause des float*/
		/*
		Float solde=(Float) solde_.getValue();
		Float acompte= (Float)acompte_.getValue();
		Float prix=(Float) prix_.getValue();
		
		
		bordel avec builder, 0 c est tres bien les spectacle sont gratuit voila 
		*/
			Reservation reservation = new Reservation(0,0,0, planningSalle, 
				this.personne);
		
	//	JOptionPane.showMessageDialog(null, "personne de reserv  !"+this.personne);
		//JOptionPane.showMessageDialog(null," plann de reserv !"+ planningSalle);
		// le px varie en fct des jours de reserv donc on attrinue le jour au calcul du prix
		reservation.setPrixByday(getDate());
		
		reservation.create(this.personne.getId());
		//JOptionPane.showMessageDialog(null, "reserv ajoutee !");
	}
	/**************************************************************************************************
	 * 
	 * 	liste de cat en fct de la config recue en arg pour la config debout
	 * 	ici c est simple y a rien
	 * 
	 * **************************************************************************************************/
	private List<Categorie> catDebout(Configuration configuration) 
	{
		int prixDebout = (Integer) aucun.getValue();
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(Categorie.TypesCat.NEANT, prixDebout, place, configuration));
		return categories;
		
	}
	
	
	
	/**************************************************************************************************
	 * 
	 * 	liste de cat en fct de la config recue en arg pour la config concert
	 * 	concert n a as de diamant
	 * 
	 * **************************************************************************************************/
	private List<Categorie> catConcert(Configuration configuration) 
	{
		int pxBrz = (Integer) brz.getValue();
		int pxArg = (Integer) arg.getValue();
		int pxOr = (Integer) or.getValue();
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(Categorie.TypesCat.BRONZE, pxBrz, place, configuration));
		categories.add(new Categorie(Categorie.TypesCat.ARGENT, pxArg, place, configuration));
		categories.add(new Categorie(Categorie.TypesCat.OR, pxOr, place, configuration));

		return categories;
	}
	/**************************************************************************************************
	 * 
	 * 	liste de cat en fct de la config recue en arg pour la config cirque 
	 * 
	 * 
	 * **************************************************************************************************/
	private List<Categorie> catCirque(Configuration configuration) 
	{
		// je recup les valeurs entrees ds les chmps des differentes categ
		int pxBrz = (Integer) brz.getValue();
		int pxArg = (Integer) arg.getValue();
		int pxOr = (Integer) or.getValue();
		int pxDiam= (Integer) dia.getValue();
		// je cree la liste 
		List<Categorie> categories = new ArrayList<Categorie>();
		// j affecte les val
		categories.add(new Categorie(Categorie.TypesCat.BRONZE, pxBrz, place, configuration));
		categories.add(new Categorie(Categorie.TypesCat.ARGENT, pxArg, place, configuration));
		categories.add(new Categorie(Categorie.TypesCat.OR, pxOr, place, configuration));
		categories.add(new Categorie(Categorie.TypesCat.DIAMANT, pxDiam, place, configuration));
		return categories;
	}
	
	
	
	public void List() 
	{
		Spectacle spectacle = new Spectacle();
		allSpectacles = spectacle.findAll_();
	}
	
	// test debug
	
	public void ListP() 
	{
		
		PlanningSalle  s= new PlanningSalle();
		plp = s.findAll();
		
	}
	/*fonctionnel sans libel et sans description*/
	private void addConfiguration() 
	{
		String description = descCF.getText();
		String libel = place.toString();
		
		/*public Configuration( int id,String description, 
			String libel, 
			List<Categorie> categoriesList, Ticket type)*/
		
			Configuration configuration = new Configuration(description,libel, place);
			
			//JOptionPane.showMessageDialog(null, "id config  "+configuration.getId());
			int id =spectacle.lastRecord();//id spect ajoute
			
			boolean oki = configuration.create(id);
			if (oki) 
			{

				addCat(configuration) ;
				//JOptionPane.showMessageDialog(null, "categorie ajoutée  "+configuration.getId());
			}
		}

		private void addCat(Configuration configuration) 
		{

			List<Categorie> categories = setCat(configuration);
			for (Categorie categorie : categories) 
			{
				categorie.create(422);
				//JOptionPane.showMessageDialog(null, "id cat ds ad actt  "+categorie.getId());
			}
			
		}
		
	
	public void reserver() 
	{
		/*************************************************************************************************************
		 * 
		 * 		la 1ere etape , l org doit creer un spectacle sinon pas de configuration pour une repr car
		 * 		la base de tout c est le spectacle , pas de spectacle on stoppe 
		 * 
		 * ************************************************************************************************************/
		boolean oki = addSpectacle();
		boolean oki2=setR();
		
		if (oki && oki2) 
		{
			//planning oki
			PlanningSalle planningSalle = null;
			
				planningSalle = addPlanning();
			
			

			addReservation(planningSalle);

			addRepresentation();

			addConfiguration();

			createArtistes();

			JOptionPane.showMessageDialog(null, "Ajouté avec succes !");
			this.dispose();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du spectacle !");
		}
		

	}
	
	
	private List<Categorie> setCat(Configuration configuration) 
	{
		maxParPersonne = (Integer) nbreMaxClient.getValue();
		if (place == Ticket.DEBOUT) 
		{
			return catDebout(configuration);
		} 
		else if (place == Ticket.CONCERT_ASSIS)
		{
			return catConcert(configuration);
		} 
		else 
		{
			return catCirque(configuration);
		}

	}
	//oki fct
	private boolean setR() 
	{
		addR = new JButton("Ajouter representation");
		
		addR.setForeground(Color.BLACK);
		addR.setBackground(Color.WHITE);
		addR.setBounds(220, 427, 178, 27);
		
		
		addR.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				float heureD= HD.getValue();	
				float heureF=  HF.getValue() ;
				java.util.Date u = date.getDate();
				
				
				java.sql.Date date = new java.sql.Date(u.getTime());
				
				
				/*
				
				JOptionPane.showMessageDialog(null, "id spectacle "+id);
				JOptionPane.showMessageDialog(null, "heure debut  "+heureD);
				JOptionPane.showMessageDialog(null, "heure fin  "+heureF);
				JOptionPane.showMessageDialog(null, "date  "+date);
				*/
				
				
				Representation r = new Representation(heureD,heureF,date,spectacle);
				JOptionPane.showMessageDialog(null, "representation ajoute");
				
				
				r.create();
			
				
						
			}
		});
		
		
		
		panel.add(addR);
		
		
		
		
		
		
		
		return true;
	}
}
	
		

