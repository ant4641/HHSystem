package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;

public class SearchMMO extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	static String tabn="MMO";
	static String col="MMO_Num";
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
					SearchMMO frame = new SearchMMO(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}///應該不會有主程式

	/**
	 * Create the frame.
	 * @param conn 
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public SearchMMO(final Connection conn, String col2, String con2,final String URL,final String UN,final String PW) {
		setResizable(false);//視窗是否可以被縮放
		url = URL;
		username = UN;
		password = PW;
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //關閉事件Dispose of the frame object, but keep the application running.
		setBounds(100, 100, 719, 518);//組件
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//視窗
		
		Label label = new Label("\u641C\u5C0B\u689D\u4EF6\uFF1A");//文字標籤
		label.setBounds(23, 10, 77, 25);
		contentPane.add(label);//往窗口中加組件
		
		Label MMO_Num = new Label("請款單編號：");
		MMO_Num.setBounds(23, 64, 98, 25);
		contentPane.add(MMO_Num);
		
		textField = new JTextField();//輸入框
		textField.setColumns(10);
		textField.setBounds(127, 64, 134, 25);
		contentPane.add(textField);
		
		Label label_2 = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_2.setFont(new Font("Dialog", Font.ITALIC, 24));
		label_2.setBounds(476, 10, 210, 25);
		contentPane.add(label_2);

		Label MMO_CTName = new Label("或	 客戶名稱：");
		MMO_CTName.setBounds(267, 64, 110, 25);
		contentPane.add(MMO_CTName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(383, 64, 157, 25);
		contentPane.add(textField_1);
		
		TableDemo tableDemo = new TableDemo(conn,tabn, "SearchMMO",URL,UN,PW);//呼叫TableDemo
		tableDemo.GetData(col, con);//呼叫TableDemo的方法
		tableDemo.setBounds(15, 127, 671, 330);
		tableDemo.setLayout(new GridLayout(1, 0));//界面上的?件的格式布局
		contentPane.add(tableDemo);
		
		JButton button = new JButton("搜尋");//按鈕
		button.setBounds(573, 64, 99, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {//按鈕監聽器
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().equals("")){//判斷取值
					col="MMO_Num";
					con=textField.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="MMO_CTName";
					con=textField_1.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchMMO smmo=new SearchMMO(conn,col,con,URL,UN,PW);
				smmo.setVisible(true);
				col="MMO_Num";
				con="";
				TableDemo clear = new TableDemo(conn,tabn, "SearchMMO",URL,UN,PW);//呼叫TableDemo
				clear.GetData(col, con);//呼叫TableDemo的方法
				dispose();//關閉視窗，釋放資源
			}
		});

	}
}