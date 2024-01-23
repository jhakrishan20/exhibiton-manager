package art.gallery.management;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class showTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showTable frame = new showTable();
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
	public showTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("Display Data");
		btnShow.addActionListener(new ActionListener() {
			private AbstractButton tblData;

			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/sales	","root","1234");
					java.sql.Statement st=con.createStatement();
					String query="select first_name,last_name,grade from sales";
					ResultSet rs=st.executeQuery(query);
					 ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					
					//AbstractButton tblData = null;
					DefaultTableModel model=(DefaultTableModel) tblData.getModel();
					int cols=rsmd.getColumnCount();
					String[]colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String artwork,artist,price;
					while(rs.next()) {
						artwork=rs.getString(1);
						artist=rs.getString(2);
						price=rs.getString(3);
						String[] row= {artwork,artist,price};
						model.addRow(row);
					}
					st.close();
					con.close();
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnShow.setBounds(42, 189, 114, 40);
		contentPane.add(btnShow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 52, 283, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
		

}
