package swingdatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Aboutus {

	public JFrame frame;
	/**
	 * @wbp.nonvisual location=-10,19
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aboutus window = new Aboutus();
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
	public Aboutus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel_1.setBounds(0, 0, 700, 557);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\aboutus1.jpg"));
		lblNewLabel.setBounds(57, 11, 252, 253);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\aboutus.jpg"));
		lblNewLabel_1.setBounds(352, 35, 301, 199);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\aboutus4.jpg"));
		lblNewLabel_2.setBounds(87, 275, 245, 253);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\aboutus7.jpg"));
		lblNewLabel_3.setBounds(394, 275, 296, 246);
		panel_1.add(lblNewLabel_3);
	}

}
