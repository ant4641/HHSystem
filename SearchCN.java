package HHSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchCN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String tabn="Prod";
	static String col="ProdName";
	static String con="";
	static String url="";
	static String username="";
	static String password="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCN frame = new SearchCN(null,"","","","","");
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
	 */
	public SearchCN(final Connection conn, String col2, String con2,String URL,String  UN,String  PW) {
		super("");
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("\u641C\u5C0B\u689D\u4EF6\uFF1A");//組合物名稱
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(31, 10, 91, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("組合物名稱：");//填搜尋欄位
		label_1.setBounds(31, 64, 91, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();//填搜尋欄位
		textField.setColumns(10);
		textField.setBounds(125, 64, 134, 25);
		contentPane.add(textField);
		
		TableDemo tableDemo = new TableDemo(conn,tabn, "SearchCN",URL,username,password);//tableDemo
		tableDemo.GetData2(col, con,"ProdIsCom","1");
		tableDemo.setBounds(31, 123, 468, 329);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
		
		JButton SearchBtn = new JButton("搜尋");//搜尋鍵
		SearchBtn.setBounds(400, 63, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					col="ProdName";
					con=textField.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				
					SearchCN scn=new SearchCN(conn,col,con,url,username,password);
					scn.setVisible(true);
					col="ProdName";
					con="";
					TableDemo clear = new TableDemo(conn,tabn, "SearchCN",url,username,password);//tableDemo
					clear.GetData2(col, con,"ProdIsCom","1");
				dispose();
			}
		});

		
		Label label_2 = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_2.setFont(new Font("Dialog", Font.ITALIC, 24));
		label_2.setBounds(327, 10, 210, 25);
		contentPane.add(label_2);
	}

}