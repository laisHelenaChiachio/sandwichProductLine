package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

import sandwich.generator.frame.ChooseSandwichProductLineOptions.ChooseSandwichLineOnly;
import sandwich.shared.Category;
import sandwich.shared.CategoryNames;
import sandwich.shared.Feature;
import sandwich.generator.core.FinalProduct;

public class ChooseProductLineOptions {

	private JFrame frame;
	private ArrayList<String> listOfProductLinesChosen = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	public static void setChooseProductLineOptionsVisible(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseProductLineOptions frame = new ChooseProductLineOptions(product);
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
	public ChooseProductLineOptions(FinalProduct product) {
		
		JCheckBox addsCheckBox = new JCheckBox("      Para ADICIONAIS");
		JCheckBox drinksCheckBox = new JCheckBox("      Para BEBIDAS");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lanches prontos também");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//PAGE TITLE
		JLabel chooseProductsLabel = new JLabel("Escolha para quais produtos deseja que o software ");
		chooseProductsLabel.setBounds(0, 38, 800, 26);
		chooseProductsLabel.setForeground(Color.WHITE);
		chooseProductsLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		chooseProductsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseProductsLabel.setAlignmentY(50);
		frame.add(chooseProductsLabel);
		
		JLabel chooseProductsLabel2 = new JLabel("proporcione uma linha de montagem");
		chooseProductsLabel2.setBounds(10, 74, 800, 26);
		chooseProductsLabel2.setForeground(Color.WHITE);
		chooseProductsLabel2.setFont(new Font("Chilanka", Font.BOLD, 22));
		chooseProductsLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		chooseProductsLabel2.setAlignmentY(50);
		frame.add(chooseProductsLabel2);
		
		//SANDWICH BOX
		JCheckBox sandwichCheckBox = new JCheckBox("      Para SANDUÍCHE");
		sandwichCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setBounds(75, 242, 293, 79);
				rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
				rdbtnNewRadioButton.setForeground(Color.WHITE);
				rdbtnNewRadioButton.setFont(new Font("Chilanka", Font.BOLD, 18));
				rdbtnNewRadioButton.setBackground(new Color(204, 153, 153));
				frame.add(rdbtnNewRadioButton);
			}
		});
		sandwichCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		sandwichCheckBox.setForeground(Color.WHITE);
		sandwichCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
		sandwichCheckBox.setBackground(new Color(204, 153, 153));
		sandwichCheckBox.setBounds(19, 181, 211, 79);
		sandwichCheckBox.setEnabled(true);
		sandwichCheckBox.setVisible(true);
		frame.add(sandwichCheckBox);


		//DRINK BOX
		if(product.getProductWasSelected(Category.DRINK)) {
			drinksCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
			drinksCheckBox.setForeground(Color.WHITE);
			drinksCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
			drinksCheckBox.setBackground(new Color(204, 153, 153));
			drinksCheckBox.setBounds(279, 181, 211, 79);
			frame.add(drinksCheckBox);
		}
		
		//ADITIONAL BOX
		if(product.getProductWasSelected(Category.ADDITIONAL)) {
			addsCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
			addsCheckBox.setForeground(Color.WHITE);
			addsCheckBox.setFont(new Font("Chilanka", Font.BOLD, 18));
			addsCheckBox.setBackground(new Color(204, 153, 153));
			addsCheckBox.setBounds(533, 181, 237, 79);
			frame.add(addsCheckBox);
		}
		
		
		//NEXT BUTTON
		JButton nextBtn = new JButton("PRÓXIMO");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(product.getProductWasSelected(Category.SANDWICH) && sandwichCheckBox.isSelected()) {
					listOfProductLinesChosen.add(CategoryNames.getWichCategory(Category.SANDWICH));
					}
				if(product.getProductWasSelected(Category.DRINK) && drinksCheckBox.isSelected()) {
					listOfProductLinesChosen.add(CategoryNames.getWichCategory(Category.DRINK));
				}
				if(product.getProductWasSelected(Category.ADDITIONAL) && addsCheckBox.isSelected()) {
					listOfProductLinesChosen.add(CategoryNames.getWichCategory(Category.ADDITIONAL));
				}
				product.setProductLine(listOfProductLinesChosen);	
				frame.setVisible(false);
				
				if(!sandwichCheckBox.isSelected()) { //JUST READY SANDWICHS
					product.setOnlyReadySandwichs(true);
					ChooseSandwichReadyOnly readyOptions = new ChooseSandwichReadyOnly(product);
					readyOptions.setChooseSandwichOptionsAndOrder(product);
				}
				if(sandwichCheckBox.isSelected() && !rdbtnNewRadioButton.isSelected()) { //JUST PRODUCT LINE SANDWICHS
					product.setOnlyPLSandwichs(true);
					ChooseSandwichLineOnly productLineOptions = new ChooseSandwichLineOnly(product);
					productLineOptions.setChooseSandwichLineOnly(product);
					product.features.add(Feature.SandwichSteps);
				}
				if(sandwichCheckBox.isSelected() && rdbtnNewRadioButton.isSelected()) { //PRODUCT LINE  AND READYSANDWICHS
					product.setOnlyPLSandwichs(false);
					product.setOnlyReadySandwichs(false);
					ChooseSandwichLineOnly productLineOptions = new ChooseSandwichLineOnly(product);
					productLineOptions.setChooseSandwichLineOnly(product);
				}			
			}
		});
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
		nextBtn.setBounds(653, 382, 117, 40);
		
		frame.add(nextBtn);
		
		
				
	}
}
