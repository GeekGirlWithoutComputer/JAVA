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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartActivity extends JFrame 
{

	/*****************************************************************************************************
	 *  les attributs 
	 *
	 ******************************************************************************************************/
	private JPanel contentPane;

	
	public StartActivity () 
	{
		var activity = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
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
		panel_1.setBounds(0, 2, 682, 379);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("MENU   PRINCIPAL ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 39, 548, 56);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 30));
		panel_1.add(lblNewLabel_1);

		/*********************************************************************************
		 * 
		 * nle clic sur le btn permet l acces a la page de connexion
		 * 
		 ************************************************************************************/
		JButton loginBtn = new JButton("CONNEXION");
		loginBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ConnexionActivity page = new ConnexionActivity ();
				page.setVisible(true);
				activity.dispose();
			}
		});
		loginBtn.setBounds(426, 208, 150, 78);
		loginBtn.setForeground(Color.black);
		loginBtn.setBackground(Color.RED);
		panel_1.add(loginBtn);
		/*********************************************************************************
		 * 
		 * nle clic sur le btn permet l acces a la page d inscription 
		 * 
		 ************************************************************************************/
		JButton registerBtn = new JButton("INSCRIPTION");
		registerBtn.setBounds(65, 208, 172, 78);
		panel_1.add(registerBtn);
		registerBtn.setForeground(Color.black);
		registerBtn.setBackground(Color.RED);
		registerBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisActivity page= new RegisActivity();
				page.setVisible(true);
				activity.dispose();
			}
		});

	}}

