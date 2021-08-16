package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import be.condorcet.duquesne.POJO.*;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class MainActivity extends JFrame 
{
	
	/******************************************************************************
	 *  point d entree , le main , c est cette page qui demarre 
	 * 
	 * ******************************************************************************/
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{	
					MainActivity frame = new MainActivity();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	private JPanel contentPane;
	private List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
	private Spectacle leSpectacle;
	private Spectacle spectacle = new Spectacle();
	private JComboBox<Spectacle> sp_cm;
	


	public MainActivity() 
	{

		List();
		MainActivity activity = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
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

		JLabel lblNewLabel_1 = new JLabel("     LISTE DES SPECTACLES ");
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(10, 11, 414, 84);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Rubik", Font.BOLD | Font.ITALIC, 23));
		panel_1.add(lblNewLabel_1);
		sp_cm = new JComboBox<Spectacle>();
		sp_cm.setBounds(20, 110, 387, 21);
		panel_1.add(sp_cm);
		
		JLabel lblNewLabel = new JLabel("Interesse(e)? Cliquez sur le menu pour vous connecter "
				);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 170, 434, 65);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ou vous inscrire afin de reserver ");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 219, 352, 27);
		panel_1.add(lblNewLabel_2);
		
		JButton menu = new JButton("ACCES AU MENU");
		menu.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 13));
		menu.setBounds(52, 257, 296, 42);
		panel_1.add(menu);
		
		
		/* test pr verif 
		JButton abcd = new JButton("New button");
		abcd.setBounds(309, 39, 89, 23);
		panel_1.add(abcd);
		
		abcd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Personne p = new Personne();
				ListingCommande start = new ListingCommande(p);
				start.setVisible(true);
				activity.dispose();
				}
		});*/
		
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				StartActivity start = new StartActivity();
				start.setVisible(true);
				activity.dispose();
				}
		});
		Dimension size= sp_cm.size();// test
		//leSpectacle = (Spectacle) sp_cm.getSelectedItem();// test 
			

		createCombobox();
		//JOptionPane.showMessageDialog(null, "cbbox ds main  ."+ createCombobox());	
	}
	
	public Spectacle  createCombobox() 
	{
		//JOptionPane.showMessageDialog(null, "taille radio ."+ size.toString());
		Spectacle sss = new Spectacle();
		for (Spectacle  sp:
			allSpectacles) 
		{
			sp_cm.addItem(sp);
		}		
		// JOptionPane.showMessageDialog( null,"item id ."+currentSpectacle); // test
		
		;
	
		return leSpectacle =(Spectacle) sp_cm.getSelectedItem();
	}
	
	
	
	
	
	
	public void List() 
	{
		Spectacle spectacle = new Spectacle();
		allSpectacles = spectacle.findAll_();
	}
}
