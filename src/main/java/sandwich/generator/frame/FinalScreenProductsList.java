package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sandwich.shared.FinalProduct;

public class FinalScreenProductsList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void setFinalScreenProductList(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalScreenProductsList window = new FinalScreenProductsList(product);
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
	public FinalScreenProductsList(FinalProduct product) {
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
				
		JLabel mainLabel = new JLabel("SOFTWARE FINAL");
		mainLabel.setBounds(0, 23, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);	
		
		JLabel mainProducts = new JLabel("Produtos escolhidos");
		mainProducts.setBounds(-83, 78, 516, 26);
		mainProducts.setForeground(Color.WHITE);
		mainProducts.setFont(new Font("Chilanka", Font.BOLD, 19));
		mainProducts.setHorizontalAlignment(SwingConstants.CENTER);
		mainProducts.setAlignmentY(50);
		frame.getContentPane().add(mainProducts);	
		
		JLabel productsName;
		int xposition = 32;
		int i = 0;
		
		for(i = 0; i < product.getMainProductListSize(); i++) {
			productsName = new JLabel(product.getMainProducts().get(i));
			productsName.setBounds(xposition , 118, 222, 26);
			productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
			productsName.setForeground(Color.WHITE);
			productsName.setHorizontalAlignment(SwingConstants.LEFT);
			productsName.setAlignmentY(50);
			frame.getContentPane().add(productsName);	
			xposition = xposition + 234;
		}
		
		JLabel productLine = new JLabel("Linha de Produto");
		productLine.setBounds(-101, 160, 516, 26);
		productLine.setForeground(Color.WHITE);
		productLine.setFont(new Font("Chilanka", Font.BOLD, 19));
		productLine.setHorizontalAlignment(SwingConstants.CENTER);
		productLine.setAlignmentY(50);
		frame.getContentPane().add(productLine);	
		
		xposition = 32;		
		
		for(i = 0; i < product.getProductLineListSize(); i++) {
			productsName = new JLabel(product.getProductLine().get(i));
			productsName.setBounds(xposition , 207, 222, 26);
			productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
			productsName.setForeground(Color.WHITE);
			productsName.setHorizontalAlignment(SwingConstants.LEFT);
			productsName.setAlignmentY(50);
			frame.getContentPane().add(productsName);	
			xposition = xposition + 234;
		}
		
	
		JLabel productLineChoose = new JLabel("Itens da Linha de Produto e Respectiva Ordem");
		productLineChoose.setBounds(50, 239, 516, 26);
		productLineChoose.setForeground(Color.WHITE);
		productLineChoose.setFont(new Font("Chilanka", Font.BOLD, 19));
		productLineChoose.setHorizontalAlignment(SwingConstants.CENTER);
		productLineChoose.setAlignmentY(50);
		frame.getContentPane().add(productLineChoose);	
		
		xposition = 32;		
	
		
		for(i = 0; i < product.getOrderSandwichPL().size(); i++) {
			productsName = new JLabel(product.getOrderSandwichPL().get(i).toString());
			productsName.setBounds(xposition , 277, 222, 26);
			productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
			productsName.setForeground(Color.WHITE);
			productsName.setHorizontalAlignment(SwingConstants.LEFT);
			productsName.setAlignmentY(50);
			frame.getContentPane().add(productsName);	
			xposition = xposition + 234;
		}
		

	}
	
	
	
}
