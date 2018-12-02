package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import sandwich.generator.core.MavenProjectGenerator;
import sandwich.shared.Feature;
import sandwich.generator.core.FinalProduct;

public class FinalScreenProductsList {

	private JFrame frame;

	private FinalProduct product;

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
		this.product = product;
		initialize(product);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(FinalProduct product) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 1020, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mainLabel = new JLabel("SOFTWARE FINAL");
		mainLabel.setBounds(50, 23, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);
		
		JLabel mainProducts = new JLabel("Produtos principais escolhidos");
		mainProducts.setBounds(-80, 78, 516, 26);
		mainProducts.setForeground(Color.WHITE);
		mainProducts.setFont(new Font("Chilanka", Font.BOLD, 19));
		mainProducts.setHorizontalAlignment(SwingConstants.CENTER);
		mainProducts.setAlignmentY(50);
		frame.getContentPane().add(mainProducts);

		JLabel productsName;
		int xposition = 50;
		int i = 0;

		Feature[] productFeatures = product.features.stream()
				.filter(Feature::isProduct)
				.toArray(Feature[]::new);
		for(Feature feature : productFeatures) {
			productsName = new JLabel(feature.toString());
			productsName.setBounds(xposition , 118, 222, 26);
			productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
			productsName.setForeground(Color.WHITE);
			productsName.setHorizontalAlignment(SwingConstants.LEFT);
			productsName.setAlignmentY(50);
			frame.getContentPane().add(productsName);
			xposition = xposition + 230;
		}
		
		JLabel productLine = new JLabel("Montagem de produtos para itens pertencentes à(s) categoria(s)");
		productLine.setBounds(-54, 140, 800, 100);
		productLine.setForeground(Color.WHITE);
		productLine.setFont(new Font("Chilanka", Font.BOLD, 19));
		productLine.setHorizontalAlignment(SwingConstants.CENTER);
		productLine.setAlignmentY(50);
		frame.getContentPane().add(productLine);
		
		xposition = 50;

		Feature[] productLineFeatures = product.features.stream()
				.filter(Feature::isProduct)
				.toArray(Feature[]::new);
		for(Feature feature : productLineFeatures) {
			productsName = new JLabel(feature.toString());
			productsName.setBounds(xposition , 207, 222, 26);
			productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
			productsName.setForeground(Color.WHITE);
			productsName.setHorizontalAlignment(SwingConstants.LEFT);
			productsName.setAlignmentY(50);
			frame.getContentPane().add(productsName);
			xposition = xposition + 230;
		}
		
		if(!product.getBread().isEmpty()) {
			JLabel productLineChoose = new JLabel("Categorias Escolhidas da Linha de Produto e Respectiva Ordem");
			productLineChoose.setBounds(25, 250, 580, 26);
			productLineChoose.setForeground(Color.WHITE);
			productLineChoose.setFont(new Font("Chilanka", Font.BOLD, 19));
			productLineChoose.setHorizontalAlignment(SwingConstants.CENTER);
			productLineChoose.setAlignmentY(50);
			frame.getContentPane().add(productLineChoose);
			
			xposition = 50;		
		
			for(i = 0; i < product.getOrderSandwichPL().size(); i++) {
				productsName = new JLabel(product.getOrderSandwichPL().get(i).toString());
				productsName.setBounds(xposition , 277, 222, 26);
				productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
				productsName.setForeground(Color.WHITE);
				productsName.setHorizontalAlignment(SwingConstants.LEFT);
				productsName.setAlignmentY(50);
				frame.getContentPane().add(productsName);
				xposition = xposition + 230;
			}
			
			JLabel itensPLChoose = new JLabel("Itens Escolhidos");
			itensPLChoose.setBounds(-150, 345, 516, 26);
			itensPLChoose.setForeground(Color.WHITE);
			itensPLChoose.setFont(new Font("Chilanka", Font.BOLD, 19));
			itensPLChoose.setHorizontalAlignment(SwingConstants.CENTER);
			itensPLChoose.setAlignmentY(50);
			frame.getContentPane().add(itensPLChoose);
			
			xposition = 50;		
			for(i = 0; i < product.getBread().size(); i++) {
				productsName = new JLabel(product.getBread().get(i).toString());
				productsName.setBounds(xposition , 380, 222, 26);
				productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
				productsName.setForeground(Color.WHITE);
				productsName.setHorizontalAlignment(SwingConstants.LEFT);
				productsName.setAlignmentY(50);
				frame.getContentPane().add(productsName);
				xposition = xposition + 230;
			}
			
			xposition = 50;		
			
			for(i = 0; i < product.getProtein().size(); i++) {
				productsName = new JLabel(product.getProtein().get(i).toString());
				productsName.setBounds(xposition , 420, 222, 26);
				productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
				productsName.setForeground(Color.WHITE);
				productsName.setHorizontalAlignment(SwingConstants.LEFT);
				productsName.setAlignmentY(50);
				frame.getContentPane().add(productsName);
				xposition = xposition + 230;
			}
			
			if(!product.getSalad().isEmpty()) {
				xposition = 50;		
				for(i = 0; i < product.getSalad().size(); i++) {
					productsName = new JLabel(product.getSalad().get(i).toString());
					productsName.setBounds(xposition , 455, 222, 26);
					productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
					productsName.setForeground(Color.WHITE);
					productsName.setHorizontalAlignment(SwingConstants.LEFT);
					productsName.setAlignmentY(50);
					frame.getContentPane().add(productsName);
					xposition = xposition + 230;
				}
			}
			
			if(!product.getCheese().isEmpty() && !product.getSalad().isEmpty() ) {
				xposition = 50;		
				for(i = 0; i < product.getCheese().size(); i++) {
					productsName = new JLabel(product.getCheese().get(i).toString());
					productsName.setBounds(xposition , 488, 222, 26);
					productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
					productsName.setForeground(Color.WHITE);
					productsName.setHorizontalAlignment(SwingConstants.LEFT);
					productsName.setAlignmentY(50);
					frame.getContentPane().add(productsName);
					xposition = xposition + 230;
				}
			}
			
			if(!product.getCheese().isEmpty() && product.getSalad().isEmpty() ) {
				xposition = 50;		
				for(i = 0; i < product.getCheese().size(); i++) {
					productsName = new JLabel(product.getCheese().get(i).toString());
					productsName.setBounds(xposition , 455, 222, 26);
					productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
					productsName.setForeground(Color.WHITE);
					productsName.setHorizontalAlignment(SwingConstants.LEFT);
					productsName.setAlignmentY(50);
					frame.getContentPane().add(productsName);
					xposition = xposition + 230;
				}
			}
		}
		
		if(product.isOnlyReadySandwichs()) { 
			JLabel sandwichReady = new JLabel("Sanduíches Montados Escolhidos"); //if there is no product line
			sandwichReady.setBounds(-70, 250, 516, 26);
			sandwichReady.setForeground(Color.WHITE);
			sandwichReady.setFont(new Font("Chilanka", Font.BOLD, 19));
			sandwichReady.setHorizontalAlignment(SwingConstants.CENTER);
			sandwichReady.setAlignmentY(50);
			frame.getContentPane().add(sandwichReady);
			
			xposition = 280;		
			for(i = 0; i < product.getSandwichReadyChosen().size(); i++) {
				productsName = new JLabel(product.getSandwichReadyChosen().get(i).toString());
				productsName.setBounds(50 , xposition, 710, 26);
				productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
				productsName.setForeground(Color.WHITE);
				productsName.setHorizontalAlignment(SwingConstants.LEFT);
				productsName.setAlignmentY(50);
				frame.getContentPane().add(productsName);
				xposition = xposition + 50;		
			}
		}
		if(!product.isOnlyPLSandwichs() && !product.isOnlyReadySandwichs()) {
			JLabel sandwichReady = new JLabel("Sanduíches Montados Escolhidos"); //if there is product line
			sandwichReady.setBounds(-54, 545, 500, 26);
			sandwichReady.setForeground(Color.WHITE);
			sandwichReady.setFont(new Font("Chilanka", Font.BOLD, 19));
			sandwichReady.setHorizontalAlignment(SwingConstants.CENTER);
			sandwichReady.setAlignmentY(50);
			frame.getContentPane().add(sandwichReady);
			
			xposition = 580;		
			for(i = 0; i < product.getSandwichReadyChosen().size(); i++) {
				productsName = new JLabel(product.getSandwichReadyChosen().get(i).toString());
				productsName.setBounds(50 , xposition, 710, 26);
				productsName.setFont(new Font("Chilanka", Font.ITALIC, 18));
				productsName.setForeground(Color.WHITE);
				productsName.setHorizontalAlignment(SwingConstants.LEFT);
				productsName.setAlignmentY(50);
				frame.getContentPane().add(productsName);
				xposition = xposition + 50;
			
			}
		}

		//Compile BUTTON
		JButton nextBtn = new JButton("Gerar");
		nextBtn.addActionListener(e -> Compile());
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 14));
		nextBtn.setBounds(1020 - 117 - 30, 120 - 40 -58, 117, 40);
		frame.add(nextBtn);
	}

	private void Compile(){

		// Generation the code
		try {
			MavenProjectGenerator generator = new MavenProjectGenerator(Paths.get("./out/"));
			generator
					.Cleanup()
					.AddEssentials();
			
			product.features.add(Feature.SandwichSteps);


			// Adding Variants
			// Product Drink
			if (product.features.contains(Feature.Drink)){
				generator.AddFile("src/main/java/sandwich/spl/variants/product/Drink.java");
			}
			// Product Additional
			if (product.features.contains(Feature.Additional)){
				generator.AddFile("src/main/java/sandwich/spl/variants/product/Additional.java");
			}

			// Anny Product Manufacture Step
			if (product.features.contains(Feature.SandwichSteps) ||
					product.features.contains(Feature.DrinkSteps) ||
					product.features.contains(Feature.AdditionalSteps)) {
//				generator.AddFile("src/main/java/sandwich/spl/variants/product/step/ProductItem.java");
//				generator.AddFile("src/main/java/sandwich/spl/variants/product/step/ProductManufactureStep.java");
			}
			// Product Steps for Sandwich
			if (product.features.contains(Feature.SandwichSteps)) {
				generator.AddFile("src/main/java/sandwich/spl/variants/product/step/SandwichStep.java");
			}
			// Product Steps for Drink
			if (product.features.contains(Feature.DrinkSteps)) {
				generator.AddFile("src/main/java/sandwich/spl/variants/product/step/DrinkStep.java");
			}
			// Product Steps for Additional
			if (product.features.contains(Feature.AdditionalSteps)) {
				generator.AddFile("src/main/java/sandwich/spl/variants/product/step/AdditionalStep.java");
			}

			// Save products (just as example really)
			product.serializeToFile(generator.getPath().resolve("data.json").toFile());

			generator
					.Compile(Paths.get(FirstWindow.mavenPath))
					.Compile(Paths.get(FirstWindow.mavenPath))
					.Execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
