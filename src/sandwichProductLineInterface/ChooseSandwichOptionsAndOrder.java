package sandwichProductLineInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sandwichProductLine.code.FinalProduct;
import sandwichProductLine.code.Sandwich;
import sandwichProductLine.code.SandwichsOptions;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JList;

public class ChooseSandwichOptionsAndOrder {

	private JFrame frame;
//	private JScrollPane scroll;
	private JList list;
	private String[][] columnData;

	/**
	 * Launch the application.
	 */
	public static void setChooseSandwichOptionsAndOrder(FinalProduct product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSandwichOptionsAndOrder window = new ChooseSandwichOptionsAndOrder(product);
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
	public ChooseSandwichOptionsAndOrder(FinalProduct product) {
		initialize(product);
//		list.setListData(columnData);
//		list.setCellRenderer(new MyCellRenderer());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(FinalProduct product) {
		SandwichsOptions sandwichOptions = new SandwichsOptions();
			
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel mainLabel = new JLabel("Choose Sandwich Options");
		mainLabel.setBounds(0, 46, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);
		
//		JList list = new JList();
//		list.setBounds(10, 85, 767, 353);
//		list.setBackground(Color.WHITE);
//		list.setVisibleRowCount(sandwichOptions.getSandwichOptions().size());
//		frame.getContentPane().add(list);
	}
}
