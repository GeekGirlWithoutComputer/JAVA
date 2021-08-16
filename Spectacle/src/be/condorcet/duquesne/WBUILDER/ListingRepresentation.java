package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.Personne;
import be.condorcet.duquesne.POJO.Representation;
import be.condorcet.duquesne.POJO.Spectacle;
import javax.swing.JTextField;

public class ListingRepresentation extends JFrame 
{

	private JPanel contentPane;
	private JPanel panel;
	private List<Representation> allRe = new ArrayList<Representation> ();
	private ListingRepresentation activity ;
	private Spectacle leSpectacle;
	private Spectacle spectacle = new Spectacle();
	private Representation r = new Representation();
	private Personne personne;
	
	private Spectacle s = new Spectacle();
	private JComboBox  <Representation> Combobox ;
	
	

	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Representation> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Representation> jListRepresentation;
	private JButton btnClose;
	private JTextField heureD;
	private JTextField heureF;
	private JTextField date;
	private JTextField nb;
	private JTextField sp;
	private JButton btnPlace;
	private JTextField spp;
	
	
			public ListingRepresentation(Spectacle s,Personne p) 
			{
				this.personne=personne;
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 680, 601);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				JPanel nbre = new JPanel() 
				{
					public void paintComponent(Graphics g) 
					{
						Image img = Toolkit.getDefaultToolkit()
								.getImage(MainActivity.class
										.getResource("/be/condorcet/duquesne/IMG/show.jpg")
										);
						g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
					}
				};
				
				nbre.setBounds(10, 11, 654, 540);
				contentPane.add(nbre);
				nbre.setLayout(null);
				 
				
			    Combobox = new JComboBox();
			    Combobox.setBounds(10, 28, 634, 22);
			    nbre.add(Combobox);
			    
			    heureD = new JTextField();
			    heureD.setBounds(10, 85, 264, 32);
			    nbre.add(heureD);
			    heureD.setColumns(10);
			    
			    heureF = new JTextField();
			    heureF.setBounds(10, 128, 264, 28);
			    nbre.add(heureF);
			    heureF.setColumns(10);
			    
			    date = new JTextField();
			    date.setBounds(10, 167, 264, 29);
			    nbre.add(date);
			    date.setColumns(10);
			    
			    nb = new JTextField();
			    nb.setBounds(10, 207, 264, 32);
			    nbre.add(nb);
			    nb.setColumns(10);
			    
			    sp = new JTextField();
			    sp.setBounds(10, 250, 264, 33);
			    nbre.add(sp);
			    sp.setColumns(10);
			    
			    btnPlace = new JButton("CHOIX DES PLACES");
			    btnPlace.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
			    btnPlace.setBackground(UIManager.getColor("CheckBox.foreground"));
			    btnPlace.setForeground(Color.BLACK);
			    btnPlace.setBounds(34, 442, 546, 48);
			    btnPlace.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						PlaceActivity page = new PlaceActivity
							(displayCombo( s) ,p);// a examiner
						page.setVisible(true);
						activity.dispose();
					}
				});
			    nbre.add(btnPlace);
			    
			    spp = new JTextField();
			    spp.setBounds(10, 305, 264, 33);
			    nbre.add(spp);
			    spp.setColumns(10);
				activity=this;
				
				 
		        JButton btnRetour = new JButton("RETOUR LISTE DES SPECTACLES ");
		 		btnRetour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		 		btnRetour.setBounds(34, 493, 546, 36);
		 		btnRetour.setBackground(Color.RED);
		 		btnRetour.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		 		btnRetour.addActionListener(new ActionListener() {
		 			public void actionPerformed(ActionEvent e) {
		 				ListingSpectacle page = new ListingSpectacle( p);
		 				page.setVisible(true);
		 				activity.dispose();
		 			}
		 		});
		 		nbre.add(btnRetour);
			
				
			/* selon les besoins du visu on peut choisur une jlist */ 
				displayCombo( s);
				//displayJlist( s) ;
		
		
			}
			
		
/************************************************************************************************************************************************
 * 
 * 
 * 				SYSTEME JLIST ET COMBOX SONT FONCTIONNELS 
 * 				LE JLIST EST MOINS JOLI 
 * 				
 * 
 * 
 * 		
 ******************************************************************************************************************************************************/
			
			
		
			
/**********************************************************************************************************
 * 
 * 									GENERATION D UN COMBO A L AIDE DU SPECTACLE RECU 
 * 									PlaceActivity recevra cet objet afin de lier representation et place sur les frames
 * 
 ************************************************************************************************************/
			private Representation  displayCombo(Spectacle s) 
			{
				
				s.getListRepresentationBySpectacle();
				Combobox.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						activity.setId();
					}
				});
				// modif 27 07 en llist 2
				if(!s.getRepresentationList().isEmpty()) 
				{
					for(Representation rep : s.getRepresentationList())
						Combobox.addItem(rep);
				
		        
					
				}

				else 
				{
					JLabel rep = new JLabel("NADA !");
			        rep.setHorizontalAlignment(SwingConstants.CENTER);
			        rep.setFont(new Font("Tahoma", Font.BOLD, 20));
					rep.setBounds(30, 360, 610, 45);
					contentPane.add(rep);
				}
				
				return r= (Representation) Combobox.getSelectedItem();
			}
			





/*********************************************************************************************************
 * 
 * 									GENERATION D UNE JLIST A L AIDE DU SPECTACLE RECU 
 * 
 * 
 ************************************************************************************************************/			
			private void displayJlist(Spectacle s) 
			{
				
				s.getListRepresentationBySpectacle();
				jListRepresentation = new JList<>();
				
				if(!s.getRepresentationList().isEmpty()) {
					for(Representation rep : s.getRepresentationList())
						listModelRep.addElement(rep);
				
					jListRepresentation.setVisibleRowCount(3);
					jListRepresentation.setModel(listModelRep);
					jListRepresentation.setBounds(50, 300, 150, 100);
		        
					scrollPane = new JScrollPane(jListRepresentation, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(50, 310, 500, 130);
					contentPane.add(scrollPane);   
				}

				else {
					JLabel lblNewLabel_7 = new JLabel("Aucune représentations présentes !");
			        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblNewLabel_7.setBounds(30, 360, 610, 45);
					contentPane.add(lblNewLabel_7);
				}
			}
			
			
/********************************************************************************************************************************************
 * 
 * 
 * 		FONCTION QUI PERMET D AFFICHER LES DIFFERENTES DONNEES DES REPRESENTATIONS DS DES LABELS
 * 
 * 
 * **********************************************************************************************************************************************
 */
			public void setId()
			{
				r= (Representation) Combobox.getSelectedItem();
				//r.findAll();
				
				
				
				//deux.setText("no de psectacle :  "+Integer.toString(s.getId()));
				
					
				
				
				heureD.setText("Heure de commencement : "+r.getHeureDebut());
				heureF.setText("Heure de fin : "+ r.getHeureFin());
				date.setText("date : "+r.getDateRepresentation());
				nb.setText("nbre de place  : "+r.getSpectacle().getNombrePlaceParClient());
				sp.setText("Spectacle de : " + r.getSpectacle().getLibel());
				spp.setText("Genre : "+r.getSpectacle().getGenre());
				
				
				
				
				
				
			}	
}

