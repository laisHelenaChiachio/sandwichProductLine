package sandwichProductLineInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sandwichProductLine.code.FinalProduct;

public class ChooseSandwichLineOnly {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void setChooseSandwichLineOnly(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSandwichLineOnly window = new ChooseSandwichLineOnly(product);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChooseSandwichLineOnly(FinalProduct product) {
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
		
	
		//PÃO
		JLabel breadLaber = new JLabel("Pão");
		breadLaber.setBounds(-28, 84, 173, 26);
		breadLaber.setForeground(Color.WHITE);
		breadLaber.setFont(new Font("Chilanka", Font.BOLD, 22));
		breadLaber.setHorizontalAlignment(SwingConstants.CENTER);
		breadLaber.setAlignmentY(50);
		
		frame.getContentPane().add(breadLaber);
		JCheckBox breadAmerican = new JCheckBox("Americano");
		breadAmerican.setEnabled(true);
		breadAmerican.setHorizontalAlignment(SwingConstants.CENTER);
		breadAmerican.setBackground(new Color(204, 153, 153));
		breadAmerican.setForeground(new Color(255, 255, 255));
		breadAmerican.setFont(new Font("Chilanka", Font.BOLD, 16));
		breadAmerican.setBounds(214, 118, 163, 45); 
		frame.getContentPane().add(breadAmerican);
		
		JCheckBox breadItalian = new JCheckBox("Italiano");
		breadItalian.setEnabled(true);
		breadItalian.setHorizontalAlignment(SwingConstants.CENTER);
		breadItalian.setBackground(new Color(204, 153, 153));
		breadItalian.setForeground(new Color(255, 255, 255));
		breadItalian.setFont(new Font("Chilanka", Font.BOLD, 16));
		breadItalian.setBounds(402, 118, 163, 45); 
		frame.getContentPane().add(breadItalian);
		
		JCheckBox breadBrioche = new JCheckBox("Brioche");
		breadBrioche.setEnabled(true);
		breadBrioche.setHorizontalAlignment(SwingConstants.CENTER);
		breadBrioche.setBackground(new Color(204, 153, 153));
		breadBrioche.setForeground(new Color(255, 255, 255));
		breadBrioche.setFont(new Font("Chilanka", Font.BOLD, 16));
		breadBrioche.setBounds(607, 118, 163, 45); 
		frame.getContentPane().add(breadBrioche);
		
		JCheckBox breadAustralian = new JCheckBox("Australiano");
		breadAustralian.setEnabled(true);
		breadAustralian.setHorizontalAlignment(SwingConstants.CENTER);
		breadAustralian.setBackground(new Color(204, 153, 153));
		breadAustralian.setForeground(new Color(255, 255, 255));
		breadAustralian.setFont(new Font("Chilanka", Font.BOLD, 16));
		breadAustralian.setBounds(18, 118, 163, 45); 
		frame.getContentPane().add(breadAustralian);
		
		//SALAD
		JLabel saladLabel = new JLabel("Salada");
		saladLabel.setBounds(-28, 348, 173, 26);
		saladLabel.setForeground(Color.WHITE);
		saladLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		saladLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saladLabel.setAlignmentY(50);
		frame.getContentPane().add(saladLabel);		
		
		JCheckBox lettuce = new JCheckBox("Folhas de alface");
		lettuce.setEnabled(true);
		lettuce.setHorizontalAlignment(SwingConstants.CENTER);
		lettuce.setBackground(new Color(204, 153, 153));
		lettuce.setForeground(new Color(255, 255, 255));
		lettuce.setFont(new Font("Chilanka", Font.BOLD, 16));
		lettuce.setBounds(49, 382, 163, 41); 
		frame.getContentPane().add(lettuce);
		
		JCheckBox tomato = new JCheckBox("Tomate");
		tomato.setEnabled(true);
		tomato.setHorizontalAlignment(SwingConstants.CENTER);
		tomato.setBackground(new Color(204, 153, 153));
		tomato.setForeground(new Color(255, 255, 255));
		tomato.setFont(new Font("Chilanka", Font.BOLD, 16));
		tomato.setBounds(214, 387, 143, 30); 
		frame.getContentPane().add(tomato);
		
		JCheckBox olive = new JCheckBox("azeitonas");
		olive.setEnabled(true);
		olive.setHorizontalAlignment(SwingConstants.CENTER);
		olive.setBackground(new Color(204, 153, 153));
		olive.setForeground(new Color(255, 255, 255));
		olive.setFont(new Font("Chilanka", Font.BOLD, 16));
		olive.setBounds(417, 387, 138, 30); 
		frame.getContentPane().add(olive);
		
		//CHEESE
		JLabel cheeseLaber = new JLabel("Queijo");
		cheeseLaber.setBounds(-28, 265, 173, 26);
		cheeseLaber.setForeground(Color.WHITE);
		cheeseLaber.setFont(new Font("Chilanka", Font.BOLD, 22));
		cheeseLaber.setHorizontalAlignment(SwingConstants.CENTER);
		cheeseLaber.setAlignmentY(50);
		frame.getContentPane().add(cheeseLaber);		
		
		JCheckBox cheddar = new JCheckBox("Queijo Cheddar");
		cheddar.setEnabled(true);
		cheddar.setHorizontalAlignment(SwingConstants.CENTER);
		cheddar.setBackground(new Color(204, 153, 153));
		cheddar.setForeground(new Color(255, 255, 255));
		cheddar.setFont(new Font("Chilanka", Font.BOLD, 16));
		cheddar.setBounds(49, 299, 163, 41); 
		frame.getContentPane().add(cheddar);
		
		JCheckBox prato = new JCheckBox("Queijo Prato");
		prato.setEnabled(true);
		prato.setHorizontalAlignment(SwingConstants.CENTER);
		prato.setBackground(new Color(204, 153, 153));
		prato.setForeground(new Color(255, 255, 255));
		prato.setFont(new Font("Chilanka", Font.BOLD, 16));
		prato.setBounds(234, 304, 143, 30); 
		frame.getContentPane().add(prato);
		
		JCheckBox provolone = new JCheckBox("Queijo Provolone");
		provolone.setEnabled(true);
		provolone.setHorizontalAlignment(SwingConstants.CENTER);
		provolone.setBackground(new Color(204, 153, 153));
		provolone.setForeground(new Color(255, 255, 255));
		provolone.setFont(new Font("Chilanka", Font.BOLD, 16));
		provolone.setBounds(430, 304, 163, 30); 
		frame.getContentPane().add(provolone);
		
		//PROTEIN
		JLabel proteinLaber = new JLabel("Proteína");
		proteinLaber.setBounds(-28, 174, 173, 26);
		proteinLaber.setForeground(Color.WHITE);
		proteinLaber.setFont(new Font("Chilanka", Font.BOLD, 22));
		proteinLaber.setHorizontalAlignment(SwingConstants.CENTER);
		proteinLaber.setAlignmentY(50);
		frame.getContentPane().add(proteinLaber);		
				
		JCheckBox redMeat = new JCheckBox("Carne vermelha");
		redMeat.setEnabled(true);
		redMeat.setHorizontalAlignment(SwingConstants.CENTER);
		redMeat.setBackground(new Color(204, 153, 153));
		redMeat.setForeground(new Color(255, 255, 255));
		redMeat.setFont(new Font("Chilanka", Font.BOLD, 16));
		redMeat.setBounds(231, 208, 163, 41); 
		frame.getContentPane().add(redMeat);
		
		JCheckBox chicken = new JCheckBox("Peito de Frango");
		chicken.setEnabled(true);
		chicken.setHorizontalAlignment(SwingConstants.CENTER);
		chicken.setBackground(new Color(204, 153, 153));
		chicken.setForeground(new Color(255, 255, 255));
		chicken.setFont(new Font("Chilanka", Font.BOLD, 16));
		chicken.setBounds(430, 213, 163, 30); 
		frame.getContentPane().add(chicken);
		
		JCheckBox egg = new JCheckBox("Ovo");
		egg.setEnabled(true);
		egg.setHorizontalAlignment(SwingConstants.CENTER);
		egg.setBackground(new Color(204, 153, 153));
		egg.setForeground(new Color(255, 255, 255));
		egg.setFont(new Font("Chilanka", Font.BOLD, 16));
		egg.setBounds(597, 213, 163, 30); 
		frame.getContentPane().add(egg);
		
		JCheckBox pig = new JCheckBox("Presunto");
		pig.setEnabled(true);
		pig.setHorizontalAlignment(SwingConstants.CENTER);
		pig.setBackground(new Color(204, 153, 153));
		pig.setForeground(new Color(255, 255, 255));
		pig.setFont(new Font("Chilanka", Font.BOLD, 16));
		pig.setBounds(18, 213, 163, 30); 
		frame.getContentPane().add(pig);
				
		
		//NEXT BUTTON
		JButton nextBtn = new JButton("PRÓXIMO");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!breadAmerican.isSelected() && !breadItalian.isSelected() && !breadBrioche.isSelected() && !breadAustralian.isSelected()) {
					setPopUpInfoVisible popUp = new setPopUpInfoVisible("Selecione pelo menos um tipo de pão");
					popUp.setPopUpInfoVisible("Selecione pelo menos um tipo de pão");
				} else {
					if(breadAmerican.isSelected())
						product.setBread("Pão Americano");
					if(breadItalian.isSelected())
						product.setBread("Pão Italiano");
					if(breadBrioche.isSelected())
						product.setBread("Pão Brioche");
					if(breadAustralian.isSelected())
						product.setBread("Pão Australiano");
				}
				
				if(!redMeat.isSelected() && !chicken.isSelected() && !egg.isSelected() && !pig.isSelected()) {
					setPopUpInfoVisible popUp = new setPopUpInfoVisible("Selecione pelo menos uma proteína");
					popUp.setPopUpInfoVisible("Selecione pelo menos uma proteína");
				} else {
					if(redMeat.isSelected())
						product.setProtein("Carne Vermelha");
					if(chicken.isSelected())
						product.setProtein("Peito de Frango");
					if(egg.isSelected())
						product.setProtein("Ovo");
					if(pig.isSelected())
						product.setProtein("Presunto");
				}
				
				if(cheddar.isSelected())
					product.setCheese("Queijo Cheddar");
				if(prato.isSelected())
					product.setCheese("Queijo Prato");
				if(provolone.isSelected())
					product.setCheese("Queijo Provolone");
				
				
				if(lettuce.isSelected())
					product.setCheese("Folhas de Alface");
				if(tomato.isSelected())
					product.setCheese("Rodelas de Tomate");
				if(olive.isSelected())
					product.setCheese("Azeitonas");
				
				if((breadAmerican.isSelected() || breadItalian.isSelected() || breadBrioche.isSelected() || breadAustralian.isSelected()) 
						&& (redMeat.isSelected() || chicken.isSelected() || egg.isSelected() || pig.isSelected())) {
					OrderSandwichPL orderSandwich = new OrderSandwichPL(product);
					orderSandwich.setChooseOrderSandwichPL(product);
					frame.setVisible(false);
				}
			}
		});
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
		nextBtn.setBounds(653, 382, 117, 40);
		frame.getContentPane().add(nextBtn);
	}
}
