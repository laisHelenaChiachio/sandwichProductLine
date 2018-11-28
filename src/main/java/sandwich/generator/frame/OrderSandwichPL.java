package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sandwich.generator.core.FinalProduct;

public class OrderSandwichPL {

	private JFrame frame;
	int breadOrder = 1;
	int proteinOrder = 2;
	int saladOrder = 3;
	int cheeseOrder = 4;

	/**
	 * Launch the application.
	 */
	public void setChooseOrderSandwichPL(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderSandwichPL window = new OrderSandwichPL(product);
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
	public OrderSandwichPL(FinalProduct product) {
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
		
		
		JLabel mainLabel = new JLabel("Escolha a ordem em que as opções de escolhas");
		mainLabel.setBounds(0, 45, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);
		
		JLabel mainLabel2 = new JLabel("dos itens deve aparecer");
		mainLabel2.setBounds(10, 83, 800, 26);
		mainLabel2.setForeground(Color.WHITE);
		mainLabel2.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel2.setAlignmentY(50);
		frame.getContentPane().add(mainLabel2);	
		
		JLabel protein = new JLabel("Proteína");
		protein.setBounds(95, 231, 153, 26);
		protein.setForeground(Color.WHITE);
		protein.setFont(new Font("Chilanka", Font.BOLD, 22));
		protein.setHorizontalAlignment(SwingConstants.CENTER);
		protein.setAlignmentY(50);
		frame.getContentPane().add(protein);	
	
		JLabel bread = new JLabel("Pão");
		bread.setBounds(64, 162, 153, 26);
		bread.setForeground(Color.WHITE);
		bread.setFont(new Font("Chilanka", Font.BOLD, 22));
		bread.setHorizontalAlignment(SwingConstants.CENTER);
		bread.setAlignmentY(50);
		frame.getContentPane().add(bread);	
		
		JLabel salad = new JLabel("Salada");
		salad.setBounds(461, 162, 153, 26);
		salad.setForeground(Color.WHITE);
		salad.setFont(new Font("Chilanka", Font.BOLD, 22));
		salad.setHorizontalAlignment(SwingConstants.CENTER);
		salad.setAlignmentY(50);
		frame.getContentPane().add(salad);	
		
		JLabel cheese = new JLabel("Queijo");
		cheese.setBounds(461, 231, 153, 26);
		cheese.setForeground(Color.WHITE);
		cheese.setFont(new Font("Chilanka", Font.BOLD, 22));
		cheese.setHorizontalAlignment(SwingConstants.CENTER);
		cheese.setAlignmentY(50);
		frame.getContentPane().add(cheese);
		
		JTextField textNumberSandwich = new JTextField();
		textNumberSandwich.setBounds(282, 154, 63, 41);
		textNumberSandwich.setText("1");
		frame.getContentPane().add(textNumberSandwich);	
		
		JTextField textNumberProtein = new JTextField();
		textNumberProtein.setBounds(282, 223, 63, 41);
		textNumberProtein.setText("2");
		frame.getContentPane().add(textNumberProtein);	
		
		
		JTextField textNumberSalad = new JTextField();
		textNumberSalad.setBounds(664, 154, 63, 41);
		textNumberSalad.setText("3");
		frame.getContentPane().add(textNumberSalad);	
		
		JTextField textNumberCheese = new JTextField();
		textNumberCheese.setBounds(664, 223, 63, 41);
		textNumberCheese.setText("4");
		frame.getContentPane().add(textNumberCheese);	
		
		if(product.getSalad().isEmpty()) {
			textNumberSalad.setEnabled(false);
			salad.setEnabled(false);
		}
		if(product.getCheese().isEmpty()) {
			textNumberCheese.setEnabled(false);
			cheese.setEnabled(false);
		}
		
		//NEXT BUTTON
		JButton nextBtn = new JButton("PRÓXIMO");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {
					breadOrder = Integer.parseInt(textNumberSandwich.getText()); //CORRECT BREAD VALUE
		            if(breadOrder < 1|| breadOrder > product.getNumberOfItens() ) 
		            	throw new Exception();       
	    		}catch(Exception e1) {
	            	setPopUpInfoVisible popUp = new setPopUpInfoVisible("Pão: Insira número entre 1 e " + product.getNumberOfItens());
	    			popUp.setPopUpInfoVisible("Pão: Insira número entre 1 e " + product.getNumberOfItens());
					textNumberSandwich.setText("1");
	    		}
				
				try {
					proteinOrder = Integer.parseInt(textNumberProtein.getText()); //CORRECT PROTEIN VALUE
		            if(proteinOrder < 1|| proteinOrder > product.getNumberOfItens()) 
		            	throw new Exception(); 
	    		}catch(Exception e2) {
	            	setPopUpInfoVisible popUp = new setPopUpInfoVisible("Proteína: Insira número entre 1 e " + product.getNumberOfItens());
	    			popUp.setPopUpInfoVisible("Proteína: Insira número entre 1 e " + product.getNumberOfItens());
					textNumberProtein.setText("2");
	    		}
				
				if(!product.getSalad().isEmpty()) {
					try {
						saladOrder = Integer.parseInt(textNumberSalad.getText()); //CORRECT SALAD VALUE
			            if(saladOrder < 1|| saladOrder > product.getNumberOfItens()) 
			            	throw new Exception(); 
		    		}catch(Exception e2) {
		            	setPopUpInfoVisible popUp = new setPopUpInfoVisible("Salada: Insira número entre 1 e " + product.getNumberOfItens());
		    			popUp.setPopUpInfoVisible("Salada: Insira número entre 1 e " + product.getNumberOfItens());
						textNumberSalad.setText("3");
		    		}
				}
				
				if(!product.getCheese().isEmpty()) {
					try {
						cheeseOrder = Integer.parseInt(textNumberCheese.getText());  //CORRECT CHEESE VALUE
			            if(cheeseOrder < 1|| cheeseOrder > product.getNumberOfItens()) 
			            	throw new Exception(); 
		    		}catch(Exception e2) {
		            	setPopUpInfoVisible popUp = new setPopUpInfoVisible("Queijo: Insira número entre 1 e " + product.getNumberOfItens());
		    			popUp.setPopUpInfoVisible("Queijo: Insira número entre 1 e " + product.getNumberOfItens());
		    			textNumberCheese.setText("4");
		    		}
				}
				
				if(breadOrder == proteinOrder || breadOrder == saladOrder ||  breadOrder == cheeseOrder ||  //EQUAL ORDER NUMBERS
						proteinOrder == saladOrder || proteinOrder == cheeseOrder || 
						saladOrder == cheeseOrder) {
					setPopUpInfoVisible popUp = new setPopUpInfoVisible("Ordem dos elementos não podem ser iguais");
	    			popUp.setPopUpInfoVisible("Ordem dos elementos não podem ser iguais");
				}else {
					HashMap<String, Integer> hashBread = new HashMap<>();
					hashBread.put("Pão", breadOrder);
					product.addOrderSandwichPL(hashBread);
					HashMap<String, Integer> hashProtein = new HashMap<>();
					hashProtein.put("Proteína", proteinOrder);
					product.addOrderSandwichPL(hashProtein);
					if(!product.getCheese().isEmpty()) {
						HashMap<String, Integer> hashCheese = new HashMap<>();
						hashCheese.put("Queijo", cheeseOrder);
						product.addOrderSandwichPL(hashCheese);
					}
					
					if(!product.getSalad().isEmpty()) {
						HashMap<String, Integer> hashSalad = new HashMap<>();
						hashSalad.put("Salada", saladOrder);
						product.addOrderSandwichPL(hashSalad);
					}

					if(product.isOnlyPLSandwichs() && !product.getOrderSandwichPL().isEmpty()) {
						FinalScreenProductsList finalScreen = new FinalScreenProductsList(product);
						finalScreen.setFinalScreenProductList(product);
						frame.setVisible(false);
					}	
					
					if(!product.isOnlyPLSandwichs() && !product.getOrderSandwichPL().isEmpty()) {
						ChooseSandwichReadyOnly readyOptions = new ChooseSandwichReadyOnly(product);
						readyOptions.setChooseSandwichOptionsAndOrder(product);
						frame.setVisible(false);
					}	
				}
			}
		});
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
		nextBtn.setBounds(653, 382, 117, 40);
		frame.getContentPane().add(nextBtn);
			
	}
}
