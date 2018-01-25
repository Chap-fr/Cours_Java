package Vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VueInter extends JPanel implements ActionListener{
	
	public VueInter() {
	this.setLayout(null);
	this.setBounds(50, 100, 600, 250);
	this.setBackground(Color.blue);
	
	this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
