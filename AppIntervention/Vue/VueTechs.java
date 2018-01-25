package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VueTechs extends JPanel implements ActionListener{
	
	public VueTechs() {
	this.setLayout(null);
	this.setBounds(50, 100, 600, 250);
	this.setBackground(Color.red);
	
	this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}