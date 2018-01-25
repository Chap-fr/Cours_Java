package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controler.Client;
import controler.Tableau;
import modele.Modele;

public class VueClients extends JPanel implements ActionListener {
	
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btEditer = new JButton("Editer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtIdClient = new JTextField();
	private JTextField txtNomClient = new JTextField();
	private JTextField txtAdresseClient = new JTextField();
	private JComboBox txtTypeClient = new JComboBox();
	
	private JPanel unPanel = new JPanel();
	
	//declaration d'une JTable
	private JTable tabClient;
	private Tableau unTableau; //objet modele de la classe tableau
	
	
	
	
	public VueClients() {
		
			
		this.setLayout(null);
		this.setBounds(50, 50, 600, 350);
		this.setBackground(Color.yellow);
		
		this.unPanel.setLayout(new GridLayout(2, 2));
		this.unPanel.setBounds(20, 200, 550, 100);
		this.unPanel.add(new JLabel("Id Client : "));
		this.unPanel.add(this.txtIdClient);
		
		this.txtIdClient.setEditable(false);
		
		
		this.unPanel.add(new JLabel("Nom Client : "));
		this.unPanel.add(this.txtNomClient);
		
		this.unPanel.add(new JLabel("Adresse Client : "));
		this.unPanel.add(this.txtAdresseClient);
		
		this.txtTypeClient.addItem("public");
		this.txtTypeClient.addItem("privé");

		this.unPanel.add(new JLabel("Type Client : "));
		this.unPanel.add(this.txtTypeClient);
		
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btAjouter);
		this.unPanel.add(this.btSupprimer);
		this.unPanel.add(this.btEditer);
		this.unPanel.add(this.btAjouter);
		this.unPanel.setVisible(true);
		this.add(unPanel);


		//rendre boutons cliquable
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btEditer.addActionListener(this);
		this.btAnnuler.addActionListener(this);


		//insertion de la table dans la fenetre
		String  entete[] ={"Id Client", "Nom Client", "Adresse Client", "Type Client"};
		
		Object donnees[][] = this.remplirDonnees();
		
		//instanciation de la classe tableau
		this.unTableau = new Tableau(donnees, entete);
		//instanciation de la jtable avec l'objet modele de table
		this.tabClient = new JTable(this.unTableau);
		
		JScrollPane uneScroll=new JScrollPane(tabClient);
		uneScroll.setBounds(20, 10, 550, 150);
		this.add(uneScroll);
		
		
		//ajout event click
		this.tabClient.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ligne = tabClient.getSelectedRow();
				txtIdClient.setText(tabClient.getValueAt(ligne, 0).toString());
				txtNomClient.setText(tabClient.getValueAt(ligne, 1).toString());
				txtAdresseClient.setText(tabClient.getValueAt(ligne, 2).toString());
				txtTypeClient.setSelectedItem(tabClient.getValueAt(ligne, 3).toString());
				
			}
		});
		
		this.setVisible(false);
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.btAjouter) {
			
			String nom=this.txtNomClient.getText();
			String adresse=this.txtAdresseClient.getText();
			String typeclient=this.txtTypeClient.getSelectedItem().toString();
			
			
			if(nom.equals("") || adresse.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir les donnees");
			}
			//instanciation de la classe clients
			
			Client unClient = new Client (nom, adresse, typeclient);
			
			//appel du Modele pour inserer un client dans la bdd
			
			Modele.insertClient(unClient);
			JOptionPane.showMessageDialog(this, "Insertion reussie !");
			unClient = Modele.selectWhereClient(unClient);
			Object uneLigne[] = {unClient.getIdClient(), unClient.getNom(), unClient.getAdresse(), unClient.getTypeClient()};
			this.unTableau.add(uneLigne);
			this.txtNomClient.setText("");
			this.txtAdresseClient.setText("");

			
			
		}else if (e.getSource()== this.btSupprimer) {
			
			
			int idClient = Integer.parseInt(this.txtIdClient.getText());
			String nom=this.txtNomClient.getText();
			String adresse=this.txtAdresseClient.getText();
			String typeclient=this.txtTypeClient.getSelectedItem().toString();
			
			Client unClient = new Client (idClient, nom, adresse, typeclient);
			
			Modele.deleteClient(unClient);
			JOptionPane.showMessageDialog(this, "Suppression reussie !");
			
			
			
		}else if (e.getSource()==this.btEditer) {
			
			
			int idClient = Integer.parseInt(this.txtIdClient.getText());

			String nom=this.txtNomClient.getText();
			String adresse=this.txtAdresseClient.getText();
			String typeclient=this.txtTypeClient.getSelectedItem().toString();
						
			Client unClient = new Client (idClient, nom, adresse, typeclient);
						
			Modele.updateClient(unClient);
			JOptionPane.showMessageDialog(this, "Edition reussie !");
			
		}else if(e.getSource()==this.btAnnuler) {
			
			this.txtAdresseClient.setText("");
			this.txtNomClient.setText("");
			this.txtIdClient.setText("");

		}
		
		
	}
	
	public Object[][] remplirDonnees(){
		
		ArrayList<Client> lesClients = Modele.selectAllClients();
		Object donnees [][] = new Object[lesClients.size()][4];
		int i = 0;
		for(Client unClient : lesClients) {
			donnees[i][0] = unClient.getIdClient() +"";
			donnees[i][1] = unClient.getNom();
			donnees[i][2] = unClient.getAdresse();
			donnees[i][3] = unClient.getTypeClient();
			i++;

			&
		}return donnees;
		
	}

}
