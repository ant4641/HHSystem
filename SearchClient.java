package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class SearchClient extends JFrame {

	private JPanel contentPane;
	private JTextField CTName_T;
	private JTextField CTChiAbbr_T;
	private JTable table;
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	static String tabn="CT";//table name
	static String col="CTName";
	static String con="";
	static int EST;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClient frame = new SearchClient(null,"", "",1,"","","");
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
	 * @param uRL 
	 */
	public SearchClient(final Connection conn,String col2, String con2,int ESt,final String URL,final String UN,final String PW) {
		setResizable(false);
		EST=ESt;
		url = URL;
		username = UN;
		password = PW;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		setBounds(100, 100, 714, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("搜尋條件：");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(10, 10, 91, 48);
		contentPane.add(label);
		
		Label CTName = new Label("客戶名稱：");
		CTName.setBounds(10, 64, 74, 25);
		contentPane.add(CTName);
		
		CTName_T = new JTextField();
		CTName_T.setColumns(10);
		CTName_T.setBounds(90, 64, 134, 25);
		contentPane.add(CTName_T);
		
		Label CTChiAbbr = new Label("或   客戶中文簡稱：");
		CTChiAbbr.setBounds(230, 64, 114, 25);
		contentPane.add(CTChiAbbr);
		
		CTChiAbbr_T = new JTextField();
		CTChiAbbr_T.setColumns(10);
		CTChiAbbr_T.setBounds(350, 64, 157, 25);
		contentPane.add(CTChiAbbr_T);
		
		JButton button = new JButton("搜尋");
		button.setBounds(527, 62, 99, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CTChiAbbr_T.getText().equals("")){
					col="CTName";
					con=CTName_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="CTChiAbbr";
					con=CTChiAbbr_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchClient SPD=new SearchClient(conn,col,con,EST,url,username,password);
				SPD.setVisible(true);
				col="CTName";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,"SearchClient",url,username,password);
				clear.GetData0(col,con,EST);
				dispose();
			}
		});
		
		Label label_3 = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_3.setFont(new Font("Dialog", Font.ITALIC, 24));
		label_3.setBounds(463, 10, 210, 25);
		contentPane.add(label_3);
		
		TableDemo tableDemo = new TableDemo(conn,tabn,"SearchClient",url,username,password);
		tableDemo.GetData0(col,con,EST);
		tableDemo.setBounds(10, 123, 671, 344);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
	}
}