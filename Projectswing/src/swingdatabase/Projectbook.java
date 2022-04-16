package swingdatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.SQLException;
//import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Projectbook {

	public JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField edition;
	private JTextField price;
	private JTable table;
	private JTextField author;
	private JTextField qty;

	DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projectbook window = new Projectbook();
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
	public Projectbook() {
		initialize();
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(0, 0, 1290, 788);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(7, 42, 50, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("book name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(7, 73, 63, 17);
		frame.getContentPane().add(lblName);
		
		JLabel lblEdition = new JLabel("edition");
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBounds(7, 166, 50, 14);
		frame.getContentPane().add(lblEdition);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(7, 197, 50, 14);
		frame.getContentPane().add(lblPrice);
		
		id = new JTextField();
		id.setBounds(80, 42, 86, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(80, 70, 86, 20);
		frame.getContentPane().add(name);
		
		edition = new JTextField();
		edition.setColumns(10);
		edition.setBounds(80, 163, 86, 20);
		frame.getContentPane().add(edition);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(80, 194, 86, 20);
		frame.getContentPane().add(price);
		
		JScrollPane scrollPane = new JScrollPane();
	//	scrollPane.setBounds(288, 43, 390, 314);
		//frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				id.setText(model.getValueAt(i,0).toString());
				name.setText(model.getValueAt(i,1).toString());
				author.setText(model.getValueAt(i, 2).toString());
				qty.setText(model.getValueAt(i, 3).toString());
				edition.setText(model.getValueAt(i, 4).toString());
				price.setText(model.getValueAt(i, 5).toString());
				
				
			}
		});
//		table.setBackground(Color.MAGENTA);
//		model=new DefaultTableModel();
//		Object[] column= {"id","name","edition","price"};
//		Object[] row=new Object[4];
//		model.setColumnIdentifiers(column);
//	table.setModel(model);
//	scrollPane.setViewportView(table);
//	
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(new Color(60, 179, 113));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(id.getText().equals("")|| name.getText().equals("")||author.getText().equals("")||qty.getText().equals("")||edition.getText().equals("")||price.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "please fill complete information");
					}
						else {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost/booksho","root","");
							Statement stat=(Statement) con.createStatement();
							stat.executeUpdate("INSERT INTO book VALUES('"+id.getText()+"','"+name.getText()+"','"+author.getText()+"','"+qty.getText()+"','"+edition.getText()+"','"+price.getText()+"')");
//						row[0]=id.getText();
//						row[1]=name.getText();
//							row[2]=edition.getText();
//						row[3]=price.getText();
//							model.addRow(row);
							id.setText("");
							name.setText("");
							author.setText("");
							qty.setText("");
							edition.setText("");
							price.setText("");
						JOptionPane.showMessageDialog(null, "SAVE SUCCESSFULLY");
				}
				}
			catch(Exception k)
				{
					System.out.println(k);
				}
		
			}						
	
		});

		

		btnNewButton.setBounds(10, 225, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(95, 158, 160));
		btnDelete.setBackground(Color.BLUE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		int i=table.getSelectedRow();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/booksho","root","");
					Statement stat=(Statement) con.createStatement();
				    int a = Integer.parseInt(id.getText());
				    
			           
		            String sql="DELETE FROM book WHERE ID ='"+a+"'";
		            Statement s=(Statement) con.prepareStatement(sql);
		    
		                  s.execute(sql);
		                  JOptionPane.showMessageDialog(null, "Deleted successfully");
		                  
		                  id.setText("");
		            name.setText("");
		            author.setText("");
		            qty.setText("");
		            
		            edition.setText("");
		            price.setText("");
		                  
		        
//				if(i>=0) {
//					model.removeRow(i);
//					JOptionPane.showMessageDialog(null, "Deleted successfully");
//
//					
//				}	
//				else {
//					JOptionPane.showMessageDialog(null, "please slected row");
//				
//				}
			}catch(Exception c) {
					System.out.println(c);
				}
			}
			
		});

		btnDelete.setBounds(10, 259, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 192, 203));
		btnUpdate.setBackground(Color.RED);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/booksho","root","");
					Statement stat=(Statement) con.createStatement();
					 int a= Integer.parseInt(id.getText());
		                String b =name.getText();
		              String c=author.getText();
		                int d = Integer.parseInt(qty.getText());
		                int k = Integer.parseInt(edition.getText());
		                int f = Integer.parseInt(price.getText());
		               //String f=price.getText();
//		        	Statement stmt=con.createStatement();
		        	String sql="UPDATE book SET name='"+b+"',author='"+c+"',qty='"+d+"',edition='"+k+"',price='"+f+"' WHERE id="+a+"";
		        	 Statement s=(Statement) con.prepareStatement(sql);
		        	
					s.execute(sql);
					 JOptionPane.showMessageDialog(null, "Update successfully");
				}catch(Exception g) {
					System.out.println(g);
				}
				int i=table.getSelectedRow();
//				if(i>=0) {
//				model.setValueAt(id.getText(),i,0);
//				model.setValueAt(name.getText(),i,1);
//				model.setValueAt(edition.getText(),i,2);
//				model.setValueAt(price.getText(),i,3);
//				JOptionPane.showMessageDialog(null, "Update successfully");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "please selected row fist");
//
//
//				}
			}
		});
		btnUpdate.setBounds(126, 225, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(65, 105, 225));
		btnClear.setBackground(Color.MAGENTA);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				author.setText("");
				qty.setText("");
				edition.setText("");
				price.setText("");
				
			}
		});
		btnClear.setBounds(126, 259, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setForeground(new Color(50, 205, 50));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/booksho","root","");
					Statement stat=(Statement) con.createStatement();
					
			//	table.setBackground(Color.MAGENTA);
			if(e.getSource()==btnNewButton_1) {	
				int i = 0;
				i++;
				
				if( i/2==0) {
					
				
			//	table = new JTable();
				model=new DefaultTableModel();
				  String sql = "SELECT * FROM book";
				   Statement s = (Statement) con.prepareStatement(sql);
	               ResultSet rs = s.executeQuery(sql);
	               scrollPane.setBounds(288, 43, 390, 314);
	       		frame.getContentPane().add(scrollPane);
				String[] column= {"id","book name","author","qty","edition","price"};
				Object[] row= new Object[6];
				row[0]=id.getText();
				row[1]=name.getText();
				row[2]=author.getText();
				row[3]=qty.getText();
				row[4]=edition.getText();
				row[5]=price.getText();
				//	model.addRow(row);
				model.setColumnIdentifiers(column);
			table.setModel(model);
			scrollPane.setViewportView(table);

            while (rs.next()) {
                   //GET VALUES
                   int id = rs.getInt(1);
                   String name = rs.getString(2);
                   String author = rs.getString(3);
                   int qty=rs.getInt(4);
                   int edition = rs.getInt(5);
                   int t = rs.getInt(6);
                   model.addRow(new Object[]{id, name,author,qty, edition,t});
                   
                  //JOptionPane.showMessageDialog(this,id);
            }
           
            }
				else {
					scrollPane.setViewportView(null);
					
					table.setModel(null);
					 
            }
			 
			}
				}
				catch(Exception g) {
					System.out.println(g);
				}
			}
		});
		btnNewButton_1.setBounds(63, 293, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Author");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(7, 102, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		author = new JTextField();
		author.setBounds(80, 99, 86, 20);
		frame.getContentPane().add(author);
		author.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Qty");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(7, 137, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		qty = new JTextField();
		qty.setBounds(80, 130, 86, 20);
		frame.getContentPane().add(qty);
		qty.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\gaurav patil\\Downloads\\books-g4650bee57_1280.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1370, 749);
		frame.getContentPane().add(lblNewLabel_2);
		table = new JTable();
	}
}
