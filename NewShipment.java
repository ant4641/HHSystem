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

public class NewShipment extends JFrame {

	private JPanel contentPane;
	private JTextField CTName_tf;
	static String tabn="ORN";
	static String usefuntion="NewShipment";
	static String col="OR_Num";
	static String con="";
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JTextField ORNum_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewShipment frame = new NewShipment(null, "","", "", "", "");
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
	 * @param con2 
	 * @param col2 
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public NewShipment(final Connection conn, String col2, String con2,String URL, String UN, String PW) {
		setResizable(false);
		
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		setTitle("\u65B0\u589E\u51FA\u8CA8\u55AE");
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
		
		JLabel CTName_lb = new JLabel(" \u5BA2\u6236\u540D\u7A31\uFF1A");
		CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTName_lb.setBounds(45, 71, 126, 21);
		contentPane.add(CTName_lb);
		
		CTName_tf = new JTextField();
		CTName_tf.setColumns(10);
		CTName_tf.setBounds(151, 72, 139, 21);
		contentPane.add(CTName_tf);
		
		JLabel label_2 = new JLabel("\u8A02\u55AE\u7DE8\u865F");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_2.setBounds(45, 128, 69, 15);
		contentPane.add(label_2);
		
		JButton GoSearch = new JButton("\u641C\u5C0B");
		GoSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CTName_tf.getText().equals("")){
					col="OR_Num";
					con=ORNum_tf.getText();
				}else{
					col="CTName";
					con=CTName_tf.getText();
				}
				NewShipment NS=new NewShipment(conn,col,con,url,username,password);
				NS.setVisible(true);
				dispose();
			}
		});
		GoSearch.setBounds(598, 60, 106, 32);
		contentPane.add(GoSearch);
		
		JLabel label_4 = new JLabel("\u8A02\u55AE\u65E5\u671F");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_4.setBounds(124, 129, 69, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5BA2\u6236\u540D\u7A31");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_5.setBounds(203, 129, 69, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u7533\u8ACB\u4EBA");
		label_6.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_6.setBounds(282, 128, 80, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5BE9\u6838\u65E5\u671F");
		label_7.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_7.setBounds(348, 128, 69, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u8A02\u55AE\u72C0\u614B");
		label_8.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_8.setBounds(427, 129, 69, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u9000\u4EF6\u539F\u56E0");
		label_9.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_9.setBounds(507, 128, 69, 15);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u8A02\u55AE\u5099\u8A3B");
		label_10.setFont(new Font("標楷體", Font.PLAIN, 16));
		label_10.setBounds(579, 128, 69, 15);
		contentPane.add(label_10);
		
		JLabel label_3 = new JLabel("\u6B65\u9A5F1\uFF1A\u5148\u641C\u5C0B\u5BA2\u6236");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(57, 30, 218, 21);
		contentPane.add(label_3);
		
		TableDemo demo = new TableDemo(conn,tabn,usefuntion,url,username,password);
		demo.GetData2(col,con,"OR_check","1");
		demo.setLayout(new GridLayout(1, 0));
		demo.setBounds(43, 153, 678, 364);
		contentPane.add(demo);
		
		ORNum_tf = new JTextField();
		ORNum_tf.setColumns(10);
		ORNum_tf.setBounds(429, 73, 139, 21);
		contentPane.add(ORNum_tf);
		
		JLabel label_1 = new JLabel("\u8A02\u55AE\u7DE8\u865F\uFF1A");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_1.setBounds(319, 73, 126, 21);
		contentPane.add(label_1);
		
	
	}
	
	
}


