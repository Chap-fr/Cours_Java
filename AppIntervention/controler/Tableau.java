package controler;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel{
	
	
	private Object [][]donnees;		//matrice des donnees
	private String entete[];			//entetes des colones
	
	public Tableau (Object [][]donnees, String entete[]) {
		
		this.donnees = donnees;
		this.entete = entete;
		
	}

	@Override
	public int getColumnCount() {
		
		
		return this.entete.length;	//nombre de colones à l'entete 
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		
		return this.donnees[rowIndex][columnIndex];
		//retourne l'element de la matrice d'indice rowIndex, rowColumn
		
		
	}
	
	public String getColumnName(int columnIndex) {
		return this.entete[columnIndex];
	}
	
	public void add(Object ligne[]) {
		
		Object newTable [][] = new Object [this.donnees.length+1][this.entete.length];
		//recopie de la matrice dans la nouvelle matrice
		for(int i=0; i<this.donnees.length; i++) {
			newTable[i] = this.donnees[i];
		}
		
		//ajout de la ligne a la fin de la table
		newTable[this.donnees.length] = ligne;
		//mise a jour de la matrice
		this.donnees= newTable;
		//mise a jour du graphique
		this.fireTableDataChanged();
	}
	
	public void delete(int rowIndex) {
		
	}
	
	public void update(int rowIndex, Object ligne[]) {
		
	}
	
	
	

}
