package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class SearchPurchase extends JFrame {
	
	private JPanel contentPane;
	private JTextField PO_Num_T;
	private JTextField PO_PurDate_T;
	private JTable table;
	static String url ="";
	static String username =" " ; 
	static String password =" ";
	static String tabn="Purchase";
	static String col="PO_Num";
	static String con="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPurchase frame = new SearchPurchase(null,"","", "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param con2 
	 * @param col2 
	 * @param password 
	 * @param username 
	 */
	public SearchPurchase(final Connection conn,String col2, String con2,final String URL,final String UN,final String PW) {
		setResizable(false);
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		
		url=URL;
		username=UN;
		password=PW;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label HSName = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("Dialog", Font.ITALIC, 24));
		HSName.setBounds(461, 10, 210, 25);
		contentPane.add(HSName);
		
		Label label = new Label("\u641C\u5C0B\u689D\u4EF6\uFF1A");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(8, 10, 91, 48);
		contentPane.add(label);
		
		Label PO_Num = new Label("採購單編號：");
		PO_Num.setBounds(8, 64, 91, 25);
		contentPane.add(PO_Num);
		
		PO_Num_T = new JTextField();
		PO_Num_T.setColumns(10);
		PO_Num_T.setBounds(102, 64, 134, 25);
		contentPane.add(PO_Num_T);
		
		Label PO_PurDate = new Label("或   採購日期：");
		PO_PurDate.setBounds(245, 64, 97, 25);
		contentPane.add(PO_PurDate);
		
		PO_PurDate_T = new JTextField();
		PO_PurDate_T.setColumns(10);
		PO_PurDate_T.setBounds(348, 64, 157, 25);
		contentPane.add(PO_PurDate_T);
		
		JButton SearchBtn = new JButton("搜尋");
		SearchBtn.setBounds(525, 62, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PO_PurDate_T.getText().equals("")){    //若輸入的值等於字串
					col="PO_Num";
					con=PO_Num_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="PO_PurDate";
					con=PO_PurDate_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchPurchase SPD=new SearchPurchase(conn,col,con,url,username,password);
				SPD.setVisible(true);
				col="PO_Num";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,"SearchPurchase",url,username,password);
				clear.GetData(col,con);
				dispose();
			}
		});
		
		TableDemo tableDemo = new TableDemo(conn,tabn,"SearchPurchase",url,username,password);
		tableDemo.GetData(col,con);
		tableDemo.setBounds(8, 123, 671, 344);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
	}
}
