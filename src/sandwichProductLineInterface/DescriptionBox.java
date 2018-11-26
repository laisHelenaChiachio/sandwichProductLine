package sandwichProductLineInterface;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sandwichProductLine.code.CategoryNames;
import sandwichProductLine.code.FinalProduct;

import java.awt.Color;
import java.awt.Font;
import java.util.Locale.Category;

import javax.swing.JLabel;

public class DescriptionBox extends JPanel {
	
	private String descriptionText = "uhaihaiuauiahiauha";

	/**
	 * Create the panel.
	 */
	public DescriptionBox() {
		setBackground(new Color(245, 222, 179));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(descriptionText);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(new Color(245, 222, 179));
		lblNewLabel.setBounds(12, 12, 273, 86);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Chilanka", Font.BOLD, 17));
		lblNewLabel.setAlignmentY(50);
		add(lblNewLabel);

	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

}
