package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class InscriptionInfo extends JFrame {

	private JPanel contentPane;

	
	public InscriptionInfo()
	{
		InscriptionInfo activity= this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		
		JTextArea textArea = new JTextArea( "Si vous ne savez pas qui vous etes  " +
			    "vous devez essayer de savoir ce que vous faites ici  sur l application de reservation de spectacle  " +
			    "cherchez vous un spectacle a regarder?  " +
			    "si oui vous etes un client"+
			    "si vous chercher a vous produire en tant qu artiste "+
			    "vous etes un artiste"+
			    "si vous chercher des salles a louer "
			    +
			    "vous etes un orgabisateur "
			    +
			    "et si pas vous n avez rien a foutre ici "
			);
		contentPane.add(textArea, BorderLayout.CENTER);
	
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btnR = new JButton("RETOUR");
		contentPane.add(btnR, BorderLayout.SOUTH);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainActivity page = new MainActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});
		
	}

}
