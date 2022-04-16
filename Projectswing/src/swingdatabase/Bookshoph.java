package swingdatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bookshoph {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookshoph window = new Bookshoph();
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
	public Bookshoph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 932, 970);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(-8, 94, 948, 620);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home.jpg"));
		lblNewLabel.setBounds(49, 58, 188, 234);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home1.jpg"));
		lblNewLabel_1.setBounds(286, 58, 302, 234);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home4.jpg"));
		lblNewLabel_2.setBounds(677, 58, 197, 234);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home2.jpg"));
		lblNewLabel_3.setBounds(49, 324, 188, 234);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(305, 371, 188, 227);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home8.jpg"));
		lblNewLabel_5.setBounds(323, 324, 225, 234);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\home9.jpg"));
		lblNewLabel_6.setBounds(684, 324, 197, 234);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 940, 97);
		frame.getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(173, 27, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About us");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aboutus d=new Aboutus();
				d.frame.setVisible(true);
			//	frame.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.PINK);
		btnNewButton_1.setBounds(382, 27, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage g=new LoginPage();
				g.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.PINK);
		btnNewButton_2.setBounds(625, 27, 89, 23);
		panel_1.add(btnNewButton_2);
	}
}
