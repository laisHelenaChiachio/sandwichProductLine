package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sandwich.shared.Category;
import sandwich.shared.CategoryNames;
import sandwich.shared.Feature;
import sandwich.generator.core.FinalProduct;

import javax.swing.JCheckBox;


public class ChooseMainProducts {
	private JFrame frame;
	private FinalProduct finalProduct;
	private ArrayList<String> listOfProducts = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	public void setChooseMainPoductsVisible() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseMainProducts frame = new ChooseMainProducts();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseMainProducts() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//PAGE TITLE
		JLabel chooseProductsLabel = new JLabel("Escolha os produtos com os quais seu estabelecimento trabalha");
		chooseProductsLabel.setBounds(0, 46, 800, 26);
		chooseProductsLabel.setForeground(Color.WHITE);
		chooseProductsLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		chooseProductsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseProductsLabel.setAlignmentY(50);
		frame.add(chooseProductsLabel);
		
		//SANDWICH BOX
		JCheckBox sandwichCheckBox = new JCheckBox("      SANDUÍCHE");
		sandwichCheckBox.setEnabled(false);
		sandwichCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		sandwichCheckBox.setSelected(true);
		sandwichCheckBox.setBackground(new Color(204, 153, 153));
		sandwichCheckBox.setForeground(new Color(255, 255, 255));
		sandwichCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
		sandwichCheckBox.setBounds(36, 181, 223, 79); 
		frame.add(sandwichCheckBox);
		
		//DRINK BOX
		JCheckBox drinksCheckBox = new JCheckBox("      BEBIDAS");
		drinksCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		drinksCheckBox.setForeground(Color.WHITE);
		drinksCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
		drinksCheckBox.setBackground(new Color(204, 153, 153));
		drinksCheckBox.setBounds(283, 181, 211, 79);
		frame.add(drinksCheckBox);
		
		//ADITIONAL BOX
		JCheckBox addsCheckBox = new JCheckBox("      ADICIONAIS");
		addsCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		addsCheckBox.setForeground(Color.WHITE);
		addsCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
		addsCheckBox.setBackground(new Color(204, 153, 153));
		addsCheckBox.setBounds(556, 181, 199, 79);
		frame.add(addsCheckBox);
		
		//NEXT BUTTON
		JButton nextBtn = new JButton("PRÓXIMO");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        finalProduct = new FinalProduct(listOfProducts);
				listOfProducts.add(CategoryNames.getWichCategory(Category.SANDWICH));
				finalProduct.features.add(Feature.Sandwich);
				if(drinksCheckBox.isSelected()) {
					listOfProducts.add(CategoryNames.getWichCategory(Category.DRINK));
					finalProduct.features.add(Feature.Drink);
				}
				if(addsCheckBox.isSelected()){
					listOfProducts.add(CategoryNames.getWichCategory(Category.ADDITIONAL));
					finalProduct.features.add(Feature.Additional);
				}
				frame.setVisible(false);
				ChooseProductLineOptions chooseProductLineOptions = new ChooseProductLineOptions(finalProduct);
				chooseProductLineOptions.setChooseProductLineOptionsVisible(finalProduct);
			}
		});
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
		nextBtn.setBounds(653, 382, 117, 40);
		frame.add(nextBtn);
	}	

}

