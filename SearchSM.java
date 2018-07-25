package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SearchSM extends JFrame {  //查詢出貨單

	private JPanel contentPane;
	private JTextField SM_CTName_tf;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	static String tabn="SM";
	static String usefuntion="SearchSM";
	static String col="SM_Num";
	static String con="";
	static String cont="";
	private JTextField End_T_tf;
	private JTextField Start_T_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSM frame = new SearchSM(null,"","","", "", "", "");
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
	public SearchSM(final Connection conn, String col2, String con2, String con3,String URL, String UN, String PW) {
		setResizable(false);
		
		if((!col2.equals(""))&&(!con2.equals(""))&&(!con3.equals(""))){
			col=col2;
			con=con2;
			cont=con3;
		}
		setTitle("\u67E5\u8A62\u51FA\u8CA8\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		url=URL;
		username=UN;
		password=PW;
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(566, 10, 165, 40);
		contentPane.add(label);
		
		JLabel SM_CTName_lb = new JLabel(" \u5BA2\u6236\u540D\u7A31\uFF1A");
		SM_CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		SM_CTName_lb.setBounds(45, 71, 126, 21);
		contentPane.add(SM_CTName_lb);
		
		SM_CTName_tf = new JTextField();
		SM_CTName_tf.setColumns(10);
		SM_CTName_tf.setBounds(151, 72, 139, 21);
		contentPane.add(SM_CTName_tf);
		
		JLabel label_2 = new JLabel("\u51FA\u8CA8\u7DE8\u865F");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_2.setBounds(45, 128, 69, 15);
		contentPane.add(label_2);
		
		End_T_tf = new JTextField();
		End_T_tf.setColumns(10);
		End_T_tf.setBounds(417, 73, 139, 21);
		contentPane.add(End_T_tf);
		
		JLabel label_1 = new JLabel("\u81F3 \u6642\u9593\uFF1A");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_1.setBounds(307, 73, 126, 21);
		contentPane.add(label_1);
		
		Start_T_tf = new JTextField();
		Start_T_tf.setColumns(10);
		Start_T_tf.setBounds(417, 42, 139, 21);
		contentPane.add(Start_T_tf);
		
		JLabel label_11 = new JLabel("\u5F9E \u6642\u9593\uFF1A");
		label_11.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_11.setBounds(307, 42, 126, 21);
		contentPane.add(label_11);
		
		JLabel label_4 = new JLabel("\u8A02\u55AE\u7DE8\u865F");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_4.setBounds(124, 129, 69, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5BA2\u6236\u540D\u7A31");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_5.setBounds(203, 129, 69, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u51FA\u8CA8\u65E5\u671F");
		label_6.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_6.setBounds(274, 128, 69, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5BA2\u6236\u5730\u5740");
		label_7.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_7.setBounds(348, 128, 69, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u9001\u8CA8\u65B9\u5F0F");
		label_8.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_8.setBounds(427, 129, 69, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u71DF\u696D\u7A05\u5225");
		label_9.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_9.setBounds(507, 128, 69, 15);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u8CA8\u55AE\u7E3D\u8A08");
		label_10.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_10.setBounds(579, 128, 69, 15);
		contentPane.add(label_10);
		
		JLabel label_3 = new JLabel("\u6B65\u9A5F1\uFF1A\u5148\u641C\u5C0B\u5BA2\u6236 ");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(57, 30, 229, 21);
		contentPane.add(label_3);
		System.out.println("cont: "+cont);
		JButton GoSearch = new JButton("\u641C\u5C0B");
		GoSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(SM_CTName_tf.getText().equals("")){  //如果客戶名稱欄位空白
					col="SM_Date";
					con=Start_T_tf.getText();
					cont=End_T_tf.getText();
				}else{
					col="SM_CTName";
					con=SM_CTName_tf.getText();
					cont="";
				}
				SearchSM SSM=new SearchSM(conn,col,con,cont,url,username,password);
				SSM.setVisible(true);
				col="SM_Num";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,usefuntion,url,username,password);
				clear.GetData2(col,con,"SM_check","0");
				dispose();
			}
		});
		GoSearch.setBounds(598, 60, 106, 32);
		contentPane.add(GoSearch);
		
		TableDemo demo = new TableDemo(conn,tabn,usefuntion,url,username,password);
		if(!cont.equals("")){
			System.out.println("go this");
			demo.GetData4(col, con, cont,"SM_check","0");
		}else{
			demo.GetData2(col,con,"SM_check","0");
		}
		demo.setLayout(new GridLayout(1, 0));
		demo.setBounds(43, 153, 678, 364);
		contentPane.add(demo);
		
		JLabel lblNewLabel = new JLabel("(\u65E5\u671F\u683C\u5F0F:1999-99-99)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(417, 103, 139, 16);
		contentPane.add(lblNewLabel);
		
		JLabel label_12 = new JLabel("\u51FA\u8CA8\u55AE\u72C0\u614B");
		label_12.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_12.setBounds(652, 128, 102, 15);
		contentPane.add(label_12);
	}
}
