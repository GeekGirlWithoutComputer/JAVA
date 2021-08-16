package be.condorcet.duquesne.WBUILDER;
import be.condorcet.duquesne.POJO.*;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class ListingSpectacle extends JFrame {

	private JPanel contentPane;


	private DefaultListModel<String> listModelArt = new DefaultListModel<>();
	private DefaultListModel<Representation> listModelRep = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JList<String> jListArt;
	private JList<Representation> jListRepresentation;
	private JButton btnClose;
	private JLabel genre;
	private ListingSpectacle activity;
	
	
	
	private Spectacle s = new Spectacle();
	private Personne personne;
	
	private Representation r = new Representation();
	private JComboBox<Spectacle> Spp;
	private JComboBox <Representation>rere;
	
	private   JLabel libel,test;
	private TextArea txydescr;
	
	public ListingSpectacle(Personne p)
	{
		this.personne=personne;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 601);
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
								.getResource("/be/condorcet/duquesne/IMG/s.jpg")
								);
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(0, 0, 664, 562);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
       
		Spp = new JComboBox<Spectacle>();
		Spp.setBackground(Color.LIGHT_GRAY);
		Spp.setBounds(10, 32, 644, 45);
		panel_1.add(Spp);
		
		JButton repB = new JButton("AFFICHER LES REPRESENTATIONS");
		repB.setBounds(205, 398, 401, 23);
		panel_1.add(repB);
		repB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ListingRepresentation page = new ListingRepresentation (createCombobox(),p );
				page.setVisible(true);
				activity.dispose();
			}
		});
		
		 
       test = new JLabel("\" \" ");
       test.setForeground(new Color(245, 255, 250));
       test.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
       test.setBackground(UIManager.getColor("Button.highlight"));
       test.setBounds(10, 211, 221, 30);
       panel_1.add(test);
       
        genre = new JLabel("\" \"");
        genre.setForeground(new Color(240, 255, 255));
        genre.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 12));
        genre.setBackground(UIManager.getColor("Button.highlight"));
        genre.setBounds(10, 186, 251, 14);
        panel_1.add(genre);
        
         
         libel = new JLabel("\" \"");
         libel.setForeground(new Color(240, 255, 255));
         libel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 12));
         libel.setBackground(UIManager.getColor("Button.highlight"));
         libel.setBounds(10, 150, 427, 25);
         panel_1.add(libel);
         
         txydescr = new TextArea();
         txydescr.setBounds(20, 247, 387, 78);
         panel_1.add(txydescr);
         
         JButton btnRetour = new JButton("RETOUR MENU PRINCIPAL");
 		btnRetour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
 		btnRetour.setBounds(310, 504, 320, 36);
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
		
		activity = this;
		
		init();
		
		//ssdisplayRepresentationFrame(s);
		createCombobox() ;
		
	
	}
	
	
	
	
	
	
	
	
	
	// test pr recup de l autre coté 
	
	public Spectacle getSpectacleChoisit() {
		return createCombobox() ;
	}





	public Spectacle  createCombobox() 
	{
		Spp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
			}
		});
		
		
		//JOptionPane.showMessageDialog(null, "taille radio ."+ size.toString());
		for (Spectacle  sp: allSpectacles) 
		{
			Spp.addItem(sp);
			
		}		
		// JOptionPane.showMessageDialog( null,"item id ."+currentSpectacle); // test
		
		;
	
		return s =(Spectacle) Spp.getSelectedItem();
	}
	
	
	
	
	
	
	
	
	
	/*
	
	public Spectacle  createList() 
	{
		SpectacleCombox = new JComboBox<Spectacle>();
		SpectacleCombox.setBounds(10, 37, 321, 21);
		
		SpectacleCombox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				activity.setId();
				String id= s.toString();
			//JOptionPane.showMessageDialog(null, "select combo  ."+id);
				//+ s.toString());// ici je recup id 
			}
		});
		contentPane.add(SpectacleCombox);
		
		
		for (Spectacle sp : s.findAll_()) 
		{
			SpectacleCombox.addItem(sp);
		}		
	return 	s = (Spectacle) SpectacleCombox.getSelectedItem();
	//	JOptionPane.showMessageDialog(null, "select combo  ."+ s.toString());	
	}
	*/
	
	public void setId()
	{
	//selection de l item
		s= (Spectacle) Spp.getSelectedItem();
		
		Representation r= new Representation();
		r.findAll();
		
		
		libel.setText("nom  :  "+s.getLibel());
		
			
		
		
		test.setText("NO : "+Integer.toString(s.getId()));
		
		genre.setText("genre : "+s.getGenre());
		 
		txydescr.setText("description  : "+s.getDescription());
		
		
	}
	private List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
	private List<Representation> allRe = new ArrayList<Representation> ();
	public void init() 
	{
		Spectacle spectacle = new Spectacle();
		allSpectacles = spectacle.findAll_();
	}
}
