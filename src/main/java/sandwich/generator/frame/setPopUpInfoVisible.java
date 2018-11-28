package sandwich.generator.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;

public class setPopUpInfoVisible {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void setPopUpInfoVisible(String descriptionText) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setPopUpInfoVisible window = new setPopUpInfoVisible(descriptionText);
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
	public setPopUpInfoVisible(String descriptionText) {
		initialize(descriptionText);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String descriptionText) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(50, 50, 350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(245, 222, 179));
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		
		JTextArea lblNewLabel = new JTextArea(descriptionText);
		lblNewLabel.setEditable(false);
		lblNewLabel.setLineWrap(true);
		lblNewLabel.setFont(new Font("Chilanka", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(238, 232, 170));
		lblNewLabel.setWrapStyleWord(true);
		lblNewLabel.setBounds(20, 20, 273, 86);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel);
		
		//NEXT BUTTON
		JButton nextBtn = new JButton("OK");
		nextBtn.setFont(new Font("Chilanka", Font.BOLD, 12));
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
			}
		});
		nextBtn.setBounds(114, 107, 122, 35);
		frame.getContentPane().add(nextBtn);	
		
	}

}
