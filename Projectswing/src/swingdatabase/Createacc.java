package swingdatabase;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Createacc {

	public JFrame gaurav;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createacc window = new Createacc();
					window.gaurav.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Createacc() {
		initialize();
		Connect();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public JTextField user;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JPanel panel;
	

	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/database1","root","");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gaurav = new JFrame();
		gaurav.setBounds(100, 100, 450, 300);
		gaurav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gaurav.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(128, 0, 128));
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 434, 272);
		gaurav.getContentPane().add(panel);
		panel.setLayout(null);
		
		pass = new JTextField();
		pass.setBounds(208, 135, 86, 20);
		panel.add(pass);
		pass.setColumns(10);
		
		btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(157, 204, 79, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(208, 88, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBackground(Color.RED);
		lblPassword.setBounds(99, 131, 79, 26);
		panel.add(lblPassword);
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(99, 84, 79, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\download (1).jpg"));
		lblNewLabel_2.setBounds(127, 11, 167, 62);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\2794663.png"));
		lblNewLabel_3.setBounds(49, 87, 41, 23);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\download (3).png"));
		lblNewLabel_1.setBounds(49, 126, 34, 29);
		panel.add(lblNewLabel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 btnNewButton_1.addActionListener((ActionListener) this);
					   if(e.getSource()==btnNewButton_1) {
		               String b = textField.getText();
		            
		               String d = pass.getText();
		      String sql = "INSERT INTO s (Username,Password) VALUES"
		          + "('" +b+ "','" +d+ "')";
		          
		    Statement s = con.prepareStatement(sql);
		  
		    s.execute(sql);

//		    user.setText("");
//		    pass.setText("");
		   
//					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Submit succefully!!!");
					textField.setText("");
						pass.setText("");
						LoginPage p=new LoginPage();
						p.frame.setVisible(true);
				gaurav.dispose();
					   }
				}
				catch(Exception k) {
					System.out.println(k);
				}
			}
		});
		JButton btnNewButton = new JButton("Submit");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String username=user.getText();
//				String password=pass.getText();
//			
//			}
//});
		
	}
}
