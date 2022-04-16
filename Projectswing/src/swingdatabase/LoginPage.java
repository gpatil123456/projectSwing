package swingdatabase;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class LoginPage {

	public JFrame frame;
	private JTextField pass;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("gaurav");
		frame.setBounds(100, 100, 526, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.YELLOW);
		panel.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(0, 0, 510, 305);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea user = new JTextArea();
		user.setBounds(183, 77, 153, 24);
		panel_1.add(user);
		user.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(72, 78, 89, 19);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(77, 124, 73, 28);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBackground(Color.RED);
		
		pass = new JTextField();
		pass.setBounds(183, 128, 153, 24);
		panel_1.add(pass);
		pass.setBackground(Color.WHITE);
		pass.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create account");
		btnNewButton_1.setBounds(308, 178, 153, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(new Color(250, 250, 210));
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(222, 222, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(72, 209, 204));
		
		JCheckBox rember = new JCheckBox("Remember me");
		rember.setBounds(44, 177, 117, 24);
		panel_1.add(rember);
		rember.setBackground(Color.YELLOW);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\2794663.png"));
		lblNewLabel_3.setBounds(21, 77, 31, 23);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\download (3).png"));
		lblNewLabel_4.setBounds(21, 122, 51, 36);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Desktop\\download.jpg"));
		lblNewLabel_1.setBounds(222, 11, 115, 48);
		panel_1.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
//				  frame.dispose()			  new Bookshop2();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","");
					Statement stmt=con.createStatement();
				//	JCheckBox rember = new JCheckBox("Remember me");
					String sql="select * from  s where Username='"+user.getText()+"' and Password='"+pass.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					
					  
					
					 if(rs.next()) {
					
						
					JOptionPane.showMessageDialog(null,"login suceefully...");
				 Projectbook d=new Projectbook();
				d.frame.setVisible(true);	
				 frame.dispose();
					 }
					else  {
						JOptionPane.showMessageDialog(null,"incorrrect username and password..");
						}
					con.close();
				}catch(Exception k) {
					System.out.println(k);
				}
				// 
				
			}
			
			
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Createacc g=new Createacc();
			g.gaurav.setVisible(true);
			frame.dispose();
				
				
				
			}
		});
	}
}
