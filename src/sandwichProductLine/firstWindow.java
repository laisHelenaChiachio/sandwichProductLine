package sandwichProductLine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class firstWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstWindow window = new firstWindow();
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
	public firstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mainLabel = new JLabel("CREATE YOUR OWN SOFTWARE");
		mainLabel.setBounds(0, 46, 800, 26);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Chilanka", Font.BOLD, 22));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setAlignmentY(50);
		frame.getContentPane().add(mainLabel);
		
		JLabel alunos = new JLabel("Alunos:");
		alunos.setBounds(64, 127, 144, 26);
		alunos.setForeground(Color.WHITE);
		alunos.setFont(new Font("Chilanka", Font.BOLD, 19));
		alunos.setHorizontalAlignment(SwingConstants.CENTER);
		alunos.setAlignmentY(50);
		frame.getContentPane().add(alunos);
		
		JLabel andy = new JLabel("Andreas Munte Foerster         			7143997");
		andy.setBounds(150, 165, 460, 26);
		andy.setForeground(Color.WHITE);
		andy.setFont(new Font("Chilanka", Font.BOLD, 19));
		andy.setHorizontalAlignment(SwingConstants.CENTER);
		andy.setAlignmentY(50);
		frame.getContentPane().add(andy);
		
		JLabel lais = new JLabel("Lais Helena Chiachio de Miranda 		     	8517032");
		lais.setBounds(142, 222, 522, 26);
		lais.setForeground(Color.WHITE);
		lais.setFont(new Font("Chilanka", Font.BOLD, 19));
		lais.setHorizontalAlignment(SwingConstants.CENTER);
		lais.setAlignmentY(50);
		frame.getContentPane().add(lais);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Chilanka", Font.BOLD, 14));
		btnStart.setBounds(337, 308, 127, 44);
		frame.getContentPane().add(btnStart);
	}
}
