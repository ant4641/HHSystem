package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.event.*;
import java.sql.Connection;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

public class SearchProStock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String tabn="Prod";
	static String col="ProdName";
	static String con="";
	static String url = "";
	static String username = ""; 
	static String password = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchProStock frame = new SearchProStock(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param conn 
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public SearchProStock(final Connection conn, String col2, String con2,final String URL,final String UN,final String PW) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		url = URL;
		username = UN;
		password = PW;
		setBounds(100, 100, 555, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u641C\u5C0B\u689D\u4EF6\uFF1A");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(31, 10, 91, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("\u5EE0\u5546\u540D\u7A31");
		label_1.setBounds(31, 64, 91, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(125, 64, 134, 25);
		contentPane.add(textField);
		
		TableDemo tableDemo = new TableDemo(conn,"Prod", "SearchProStock",URL,UN,PW);
		tableDemo.GetData3(col, con);
		tableDemo.setBounds(31, 123, 468, 329);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
		
		JButton SearchBtn = new JButton("搜尋");
		SearchBtn.setBounds(400, 63, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {//按鈕監聽
			public void actionPerformed(ActionEvent e) {

					col="ProdName";
					con=textField.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				
					SearchProStock Sps=new SearchProStock(conn,col,con,URL,UN,PW);
				Sps.setVisible(true);
				col="ProdName";
				con="";
				TableDemo clear = new TableDemo(conn,"Prod", "SearchProStock",URL,UN,PW);
				clear.GetData3(col, con);
				dispose();
			}
		});

		
		Label label_2 = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_2.setFont(new Font("Dialog", Font.ITALIC, 24));
		label_2.setBounds(327, 10, 210, 25);
		contentPane.add(label_2);
	}
}