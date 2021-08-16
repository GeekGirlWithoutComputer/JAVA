package be.condorcet.duquesne.WBUILDER;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FinalActivityPlace extends JFrame {

	private JPanel contentPane;

	public FinalActivityPlace() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
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
		
		JOptionPane.showMessageDialog(null, "achat effectué  !");
	}

}
