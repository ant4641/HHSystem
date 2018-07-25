package HHSystem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class viewCheckOR extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Connection conn;
	static String tabn="ORN";
	static String col="OR_Num";
	static String con="";
	static String usefunction="viewCheckOR";
	static String url="";
	static String username="";
	static String password="";
	
	public viewCheckOR(Connection co,String col2, String con2,String URL,String  UN,String  PW) {
		setResizable(false);
		conn=co;
		url=URL;
		username=UN;
		password=PW;
		setResizable(false);
		
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		
		setTitle("審核訂單");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(552, 10, 165, 40);
		contentPane.add(label);
		
	    JLabel lblNewLabel = new JLabel("\u8A02\u55AE\u7DE8\u865F");
	    lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
	    lblNewLabel.setBounds(31, 69, 69, 15);
	    contentPane.add(lblNewLabel);
		contentPane.repaint();
		
	    TableDemo demo = new TableDemo(conn,tabn,usefunction,url,username,password);
	    demo.GetData2(col,con,"OR_check","0");
	    demo.setLayout(new GridLayout(1, 0));
	    demo.setBounds(31, 94, 674, 364);
	    contentPane.add(demo);
	    
	    JLabel label_2 = new JLabel("\u8A02\u55AE\u65E5\u671F");
	    label_2.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_2.setBounds(110, 69, 69, 15);
	    contentPane.add(label_2);
	    
	    JLabel label_3 = new JLabel("\u5BA2\u6236\u540D\u7A31");
	    label_3.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_3.setBounds(189, 69, 69, 15);
	    contentPane.add(label_3);
	    
	    JLabel label_4 = new JLabel("\u7533\u8ACB\u4EBA");
	    label_4.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_4.setBounds(268, 69, 69, 15);
	    contentPane.add(label_4);
	    
	    
	    
	    JLabel label_1 = new JLabel("\u672A\u6838\u51C6\u8A02\u55AE");
	    label_1.setFont(new Font("標楷體", Font.PLAIN, 18));
	    label_1.setBounds(31, 25, 128, 29);
	    contentPane.add(label_1);
	    
	    JLabel label_6 = new JLabel("\u5BE9\u6838\u65E5\u671F");
	    label_6.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_6.setBounds(328, 69, 69, 15);
	    contentPane.add(label_6);
	    
	    JLabel label_7 = new JLabel("\u8A02\u55AE\u72C0\u614B");
	    label_7.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_7.setBounds(407, 69, 69, 15);
	    contentPane.add(label_7);
	    
	    JLabel label_8 = new JLabel("\u9000\u4EF6\u539F\u56E0");
	    label_8.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_8.setBounds(486, 69, 69, 15);
	    contentPane.add(label_8);
	    
	    JLabel label_9 = new JLabel("\u8A02\u55AE\u5099\u8A3B");
	    label_9.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_9.setBounds(562, 69, 69, 15);
	    contentPane.add(label_9);
	    
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
