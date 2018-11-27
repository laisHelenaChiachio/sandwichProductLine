package main.java.sandwich.generator.frame;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.java.sandwich.spl.core.Sandwich;

public class CreateTableSandwich {
	
	CreateTableSandwich(){}
	
	public JTable setTable(ArrayList<String> dataTitle, ArrayList<Sandwich> arrayList) {
		
		String[] mainColunm = (String[]) dataTitle.toArray();		 
		Object[][] rows = new Object[arrayList.size()][dataTitle.size()];
		
//		for(int i = 0; i < arrayList.size(); i++) {
//			for(int j = 0; j < dataTitle.size(); j++) {
//				rows[i][j] = arrayList.get(i);
//			}
//		}
		
		
	    JTable table = new JTable(new DefaultTableModel(rows, mainColunm));
	    return table;
	}
}
