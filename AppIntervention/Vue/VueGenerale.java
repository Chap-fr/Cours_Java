package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.Main;

public class VueGenerale extends JFrame implements ActionListener {

	
	private JPanel panelMenu = new JPanel();
	private JButton tabButton [] = new JButton[4];
	private String tab[] = {"Clients","Techniciens","Interventions","Quitter"};
	
	//instanciation des panneaux
	private VueClients uneVueClients = new VueClients();
	private VueTechs uneVueTechs = new VueTechs();
	private VueInter uneVueInter = new VueInter();

	
	
	
	/*********** LE CONSTRUCTEUR ********/
	
	public VueGenerale()
	{
		this.setTitle("Logiciel de gestion des interventions");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(200, 200, 700, 400);
		this.getContentPane().setBackground(Color.gray);
		
		//construction panel menu
		this.panelMenu.setBounds(0, 20, 700, 30);
		this.panelMenu.setLayout(new GridLayout(1, 4));
		
		//construction des boutons
		for (int i = 0; i < this.tabButton.length; i++) {
			this.tabButton[i] = new JButton(this.tab[i]);
			this.panelMenu.add(this.tabButton[i]);
			this.tabButton[i].addActionListener(this);
			
		}
		
		this.panelMenu.setVisible(true);
		
		this.add(this.panelMenu);
		this.add(this.uneVueClients);
		this.add(this.uneVueInter);
		this.add(this.uneVueTechs);

		
		
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "Clients":
			this.uneVueClients.setVisible(true);
			this.uneVueInter.setVisible(false);
			this.uneVueTechs.setVisible(false);
			break;
		case "Techniciens":
			this.uneVueClients.setVisible(false);
			this.uneVueInter.setVisible(false);
			this.uneVueTechs.setVisible(true);
			break;
		case "Interventions":
			this.uneVueClients.setVisible(false);
			this.uneVueInter.setVisible(true);
			this.uneVueTechs.setVisible(false);
			break;
		case "Quitter":
			this.dispose();
			Main.rendreVisible(true);
			break;
		
		}
		
		
	}

}
