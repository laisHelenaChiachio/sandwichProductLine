package sandwichProductLineInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sandwichProductLine.code.FinalProduct;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class SandwichOptions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void setSandwichOptions(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SandwichOptions frame = new SandwichOptions(product);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SandwichOptions(FinalProduct product) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204, 153, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//PAGE TITLE
		JLabel chooseProductsLabel = new JLabel("Escolha opções de sanduíches que deseja oferecer em seu cardápio");
		chooseProductsLabel.setBounds(0, 46, 800, 26);
		chooseProductsLabel.setForeground(Color.WHITE);
		chooseProductsLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		chooseProductsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseProductsLabel.setAlignmentY(50);
		contentPane.add(chooseProductsLabel);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setBounds(58, 103, 652, 296);
		contentPane.add(table);
	}
}
