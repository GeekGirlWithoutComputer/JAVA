
package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;
import be.condorcet.duquesne.POJO.Categorie.TypesCat;
import be.condorcet.duquesne.POJO.Configuration.Ticket;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class PlaceActivity extends JFrame 
{
	
	/*                       VARIABLES                                                      */

	private JPanel contentPane;
	private Personne personne;
	private List<Representation> allRepresentation = new ArrayList<Representation>();
	private Categorie catItem;
	Configuration configItem;
	private Reservation reserve;
	private Representation representation;
	private JButton btnDeconn;
	private PlaceActivity activity;
	private JButton btnAchat;
	private JPanel panel;
	private JSpinField spinnerBronze, spinnerArgent, spinnerOr, spinnerDiamant;
	private JLabel lblDiamant, lblBronze, lblArgent, lblOr;
	private JLabel lblBase;
	private JSpinField spinnerBase;
	private List<Place> places = new ArrayList<Place>();
	private Commande commande = new Commande();
	private Spectacle spectacle = new Spectacle();
	private Configuration cfg;
	
	Categorie categ;
	private ListingSpectacle frame = new ListingSpectacle(personne) ;
	List<Categorie> catList ;
   /*                                                                               */
	public PlaceActivity(Representation r, Personne personne) 
	{
		activity=this;
		representation= new Representation();
		cfg  = spectacle.getConfig();
				/*representation
				.getSpectacle()
				.getConfiguration();*/
		 catList = spectacle.getConfig().getCategories();
		/* init ds var recu ds la frame en arg  */
		this.representation=r;
		this.personne = personne;
		
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 681, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*     BOUTON POUR CONFIRMER L ACHAT DES PLACES                             */
		
		btnAchat = new JButton("ACHETER");
		btnAchat.setBackground(Color.DARK_GRAY);
		btnAchat.setForeground(Color.WHITE);
		btnAchat.setBounds(10, 287, 308, 72);
		btnAchat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Achatactivity page = new Achatactivity(representation, 
						personne, 
						commande , 
						cfg);
				page.setVisible(true);
				activity.dispose();
			}
		});
		
		panel.add(btnAchat);
		lblBronze = new JLabel("BRONZE");
		lblBronze.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArgent = new JLabel("ARGENT");
		lblArgent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiamant = new JLabel("DIAMANT");
		lblDiamant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerBronze = new JSpinField();
		spinnerArgent = new JSpinField();
		spinnerOr = new JSpinField();
		spinnerDiamant = new JSpinField();
		lblBase = new JLabel("DEBOUT");
		lblBase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBase.setBounds(39, 198, 103, 27);
		panel.add(lblBase);
		spinnerBase = new JSpinField();
		spinnerBase.setBounds(151, 200, 80, 25);
		panel.add(spinnerBase);
		lblBronze.setBounds(55, 52, 87, 27);
		lblArgent.setBounds(39, 89, 87, 27);
		spinnerArgent.setBounds(151, 89, 80, 27);
		spinnerOr.setBounds(151, 126, 80, 27);
		spinnerBronze.setBounds(151, 52, 80, 27);
		lblDiamant.setBounds(39, 163, 87, 27);
		spinnerDiamant.setBounds(151, 163, 80, 27);
		lblOr.setBounds(39, 126, 87, 27);
		panel.add(lblBronze);
		panel.add(spinnerBronze);
		panel.add(lblArgent);
		panel.add(spinnerArgent);
		panel.add(spinnerOr);
		panel.add(lblDiamant);
		panel.add(lblOr);
		panel.add(spinnerDiamant);
		spinnerBronze
		.setMinimum(0);
		spinnerArgent.setMinimum(0);
		spinnerOr.setMinimum(0);
		spinnerDiamant.setMinimum(0);
		spinnerBase.setMinimum(0);
		
		
		btnDeconn = new JButton("DECONNEXION");
		btnDeconn.setBounds(314, 287, 332, 72);
		panel.add(btnDeconn);
		btnDeconn.setForeground(Color.WHITE);
		btnDeconn.setBackground(Color.DARK_GRAY);
		
		
		btnDeconn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				StartActivity page = new StartActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});

		
		
		
		
	
		
	}

	
	
	
	
	
	
	
	
	
/***************************************************************************************************************************
 * 
 * 
 * 
 * EN FCT DE TTES LES PLACES QUE LE CLIENT AURA SELECT ON VA CALCULER SELON LE PRIX DE CHAQUE PLACE ET FIRE LE TOT
 * 
 * 
 * 
 * 	
 *************************************************************************************************************************/
	public float prixPlaceTotal() 
	{

		float prix = 0;
		int nbreDiamant = (int) spinnerDiamant.getValue();
		int nbreBronze = (int) spinnerBronze.getValue();
		int nbreArgent = (int) spinnerArgent.getValue();
		int nbreOr = (int) spinnerOr.getValue();
		
		for (Categorie categorie : catList) 
		{
			TypesCat type = TypesCat.valueOf(categorie.getType());
			switch (type) 
			{
			case DIAMANT:
				prix =prix + nbreDiamant * categorie.getPrix();
				/*boucle d ajout sur le nbre de plce en diamant ds la liste de places*/
				for (int i = 0; i < nbreDiamant; i++) 
				{
					//ajout des places type diamant
					places.add(new Place
							(categorie.getPrix(), 
									representation, 
									commande, 
									TypesCat.DIAMANT));
				}
				break;
			case OR:
				prix=prix + nbreOr * categorie.getPrix();
				/*boucle d ajout sur le nbre de plce en or */
				for (int i = 0; i < nbreOr; i++) 
				{
					////ajout des places type or
					places.add(new Place(categorie.getPrix(),
							representation, 
							commande, 
							TypesCat.OR));
				}
				break;
			case ARGENT:
				prix= prix+ nbreArgent * categorie.getPrix();
				for (int i = 0; i < nbreArgent; i++) 
				{
					places.add(new Place(categorie.getPrix(), 
							representation, 
							commande, 
							TypesCat.ARGENT));
				}
				break;
			case BRONZE:

				prix =prix + nbreBronze * categorie.getPrix();
				for (int i = 0; i < nbreBronze; i++) 
				{
					places.add(new Place(categorie.getPrix(),
							representation, 
							commande, 
							TypesCat.BRONZE));
				}
				break;
			
			}

		}
		/*a l issue de tt ça on obtient un prix qui s est cumul au fil des cases */
		return prix;
	}
	
	
/**********************************************************************************************************
 * 
 * ici on va devoir aller chercher ds representation le spectacle associé et le nbre de place par client
 * ensuite on chope ttes les valeurs entree par le client 
 * si ce que le client selct est oki on retourne 1 si pas 0 
 * 
************************************************************************************************************ */
	public int nbrePlaceOki() 
	{
		int nbreDiamant = (int) spinnerDiamant.getValue();
		int nbreBronze = (int) spinnerBronze.getValue();
		int nbreArgent = (int) spinnerArgent.getValue();
		int nbreOr = (int) spinnerOr.getValue();
		int nbrePlaceMaximum = representation.getSpectacle().getNombrePlaceParClient();
		int nbreDebout = (int) spinnerBase.getValue();
		int total = nbreBronze 
				+ nbreArgent 
				+ nbreDiamant 
				+ nbreOr 
				+nbreDebout;
		// si le total est a zero c est que la personne n a rien select 
		if (total == 0) 
		{
			JOptionPane.showMessageDialog(null, "Veuillez selectionner qque chose ou sortir de l application  !");
			return 0;
		} 
		/* si le total des places prises par clientn n est pas  superieur au nbre total des places restantes on retournes 1*/
		else if (total <= nbrePlaceMaximum) 
		{
			return 1;
		} 
		/* dans ce cas c est qu il a pris trop de place et on lu indique le nbre autorisé  et on retourne 0*/
		else 
		{
			JOptionPane.showMessageDialog(null, "Nombre de places maximum autorisé apr client est fixé à  : " 
		+ nbrePlaceMaximum + " de places"
					+ " |le nombre  : " + total  + "de places que vous avez selectionnées est trop elevé");
			return 0;

		}

	}
	/****************************************************************************************************
	 * 
	 * 
	 * ici on va chercher les diff categories qui sont ds les differentes config cirque debout cirque assis
	 * 
	 * ****************************************************************************************************/
	public int  place() 
	{
		int nbreDiamant = (int) spinnerDiamant.getValue();
		int nbreBronze = (int) spinnerBronze.getValue();
		int nbreArgent = (int) spinnerArgent.getValue();
		int nbreOr = (int) spinnerOr.getValue();
		int nbrePlaceMaximum = representation.getSpectacle().getNombrePlaceParClient();
		int nbreDebout = (int) spinnerBase.getValue();
		
		// drapeau oki levé a 1 
		int oki = 1;
		for (Categorie categorie : catList) 
		{
			TypesCat type = TypesCat.valueOf(categorie.getType());
			int nb=categorie.getNbrePlaceLibre();
			switch (type) 
			{
			/*si le nbre de place en diamant que le client a pris  est plus  gde que le nbre de place qu il 
			 * reste reellement  on retourne 0 avec un msg d erreur */
			case DIAMANT:
				if (nbreDiamant> nb) 
				{
					oki = 0;
					JOptionPane.showMessageDialog(null, "cette categorie ne dispose que de :  " 
					+ categorie.getNbrePlaceLibre()
					+ " de places disponibles  pour le :  \"DIAMANT\" ");
				}
				break;
			case OR:
				if (nbreOr >nb) 
				{
					oki=0;
					JOptionPane.showMessageDialog(null,
							"cette categorie ne dispose que de : " 
					+ nb + "de places disponibles  pour le \"OR\"");
				}
				
				break;
			case ARGENT:
				if (nbreArgent> nb)
				{
					oki=0;
					JOptionPane.showMessageDialog(null,"cette categorie ne dispose que de : " 
					+ nb
					+ " de places disponibles  pour le \"ARGENT \"");
				}
				break;
			case BRONZE:
				if (nbreBronze > nb) 
				{
					oki=0;;
					JOptionPane.showMessageDialog(null, "cette categorie ne dispose que de : " 
					+ nb
					+ "de places disponibles  pour le \"bronze\" ");
				}
				break;
			
			}

		}
		/*en fct des selection on renvoie 1 ou 0 et en fct de ça on avise de ce qu on renvoie avec l utilisation de cette fct */
		return oki;
	}
/**************************************************************************************************************************
 * 
 * 
 * 			ON VERIFIE CE QUE RENVOIE LES DEUX  FONCTIONS QUI VERIF NBRE DE PLCES 
 * 			pour rappel si 0 pas oki si 1 oki 
 * 			
 * 
 * **************************************************************************************************************************/
	public void confirmer() 
	{
		/*si les deux fcts renvoient chacune 1 c est que c est bon  */
		if (place()==1 && nbrePlaceOki() == 1) 
		{
			// on ajoute a la cde le prix total obtenu ds la fct qui calcul tt
			commande.setCout(prixPlaceTotal());
			// on ajoute la liste de ttes les places créees precedemment
			commande.setPlaces(places);
			
			List<Categorie> categories = new ArrayList<Categorie>();
			
			for(Categorie categorie : categories) 
			{
				//categorie.set
				//.setConfiguration(configuration);
			}
			//Payement page = new Payement(currentSpectacle, personne, commande , configuration);
			//page.setVisible(true);
			activity.dispose();
		}
	}
}
