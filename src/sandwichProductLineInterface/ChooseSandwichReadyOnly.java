package sandwichProductLineInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sandwichProductLine.code.Category;
import sandwichProductLine.code.CategoryNames;
import sandwichProductLine.code.FinalProduct;
import sandwichProductLine.code.SandwichsOptionsOfItens;
import javax.swing.JButton;



public class ChooseSandwichReadyOnly {

	private JFrame frame;
    JTable jtable;

	/**
	 * Launch the application.
	 */
	public void setChooseSandwichOptionsAndOrder(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSandwichReadyOnly window = new ChooseSandwichReadyOnly(product);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseSandwichReadyOnly(FinalProduct product) {
		initialize(product);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(FinalProduct product) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel mainLabel = new JLabel("Escolha as opções de sanduíches");
		mainLabel.setBounds(0, 46, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);		
		
		String[] mainColunm = {"Nome", "Descrição", "Preço"};		 
		Object[][] rows = {
	    		{"X-burguer", "Dois Hamburgueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer", "R$16,00"},
	    		{"X-Salada", "Dois Hamburgueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer e alface", "R$17,50"},
	    		{"X-Salada", "ueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer e bacon", "R$21,00"},
	    	};

	    jtable = new JTable(new DefaultTableModel(
	    	new Object[][] {
	    		{"X-burguer", "Dois Hamburgueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer", "R$16,00"},
	    		{"X-Salada", "Dois Hamburgueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer e alface", "R$17,50"},
	    		{"X-Bacon", "ueres, acompanhado de tomate, maionese e queijo tipo mussarela derretido no pao de hamburguer e bacon", "R$21,00"},
	    	},
	    	new String[] {
	    		"Nome", "Descri\u00E7\u00E3o", "Pre\u00E7o"
	    	}
	    ));
	    
	    jtable.setSurrendersFocusOnKeystroke(true);
		jtable.setFillsViewportHeight(true);
		jtable.setForeground(Color.BLACK);
		jtable.setBackground(new Color(204, 153, 153));
		jtable.setBounds(61, 79, 564, 258);	
		jtable.setRowSelectionInterval(0,2); //no intervalo
		jtable.setRowHeight(70);


		        
		JScrollPane jsp = new JScrollPane (jtable);		
		jsp.setBackground(new Color(204, 153, 153));
		jsp.setBounds(93, 88, 603, 233);	
		jsp.setForeground(Color.BLACK);
		
		frame.getContentPane().add(jsp);
		
		//NEXT BUTTON
				JButton nextBtn = new JButton("PRÓXIMO");
				nextBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						if(jtable.isRowSelected(0) || jtable.isRowSelected(1) || jtable.isRowSelected(2)){
							for(int i = 0; i < 3; i++) {
								if(jtable.isRowSelected(i)) {
									HashMap<String, String> data = new HashMap<String, String>();
									data.put(rows[i][0].toString(),rows[i][1].toString());
									product.setSandwichReadyChosen(data);					
								}
							}
							//Final screen
							FinalScreenProductsList finalScreen = new FinalScreenProductsList(product);
							finalScreen.setFinalScreenProductList(product);
							frame.setVisible(false);
							

						}
						else {
							setPopUpInfoVisible popUp = new setPopUpInfoVisible("Selecione pelo menos uma opção");
							popUp.setPopUpInfoVisible("Selecione pelo menos uma opção");
						}
						
					}
				});
				nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
				nextBtn.setBounds(653, 382, 117, 40);
				frame.getContentPane().add(nextBtn);		    
	}
}
