package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.sql.Connection;

public class SearchSRData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String tabn="SR";
	static String col="SRName";
	static String con="";
	static String url = "";
	static String username = ""; 
	static String password = "";
	static int EST;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSRData frame = new SearchSRData(null,"", "",2,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public SearchSRData(final Connection conn,String col2, final String con,int ESt,final String URL,final String UN,final String PW) {
		setResizable(false);
		EST=ESt;
		url = URL;
		username = UN;
		password = PW;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 690, 494);
		contentPane.add(panel);
		
		Label label = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("Dialog", Font.ITALIC, 24));
		label.setBounds(461, 10, 210, 25);
		contentPane.add(label);
		
		Label label_1 = new Label("\u641C\u5C0B\u689D\u4EF6\uFF1A");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_1.setBounds(8, 10, 91, 48);
		contentPane.add(label_1);
		
		Label SRName = new Label("¼t°Ó¦WºÙ");
		SRName.setBounds(8, 64, 91, 25);
		contentPane.add(SRName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 64, 134, 25);
		contentPane.add(textField);
		
		JButton SearchBtn = new JButton("·j´M");
		SearchBtn.setBounds(525, 62, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					col="SRName";
					String con=textField.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				
				SearchSRData SRD=new SearchSRData(conn,col,con,EST, URL, UN, PW);
				SRD.setVisible(true);
				col="SRName";
				con="";
				TableDemo clear = new TableDemo(conn,tabn, "SearchSRData", URL, UN, PW);
				clear.GetData0(col,con,EST);				
				dispose();
			}
		});
		
		TableDemo tableDemo = new TableDemo(conn,tabn, "SearchSRData", URL, UN, PW);
		tableDemo.GetData0(col,con,EST);
		tableDemo.setBounds(8, 123, 671, 344);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
	}
}