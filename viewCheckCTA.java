package HHSystem;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class viewCheckCTA extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Connection conn;
	static String tabn="CTA";
	static String col="CTA_Num";
	static String con="";
	static String usefunction="viewCheckCTA";
	static String url="";
	static String username="";
	static String password="";
	
	public viewCheckCTA(Connection co,String col2, String con2,String URL,String  UN,String  PW) {
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
		
		setTitle("審核新增客戶基本資料");
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
		
	    JLabel lblNewLabel = new JLabel("\u7533\u8ACB\u55AE\u865F");
	    lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
	    lblNewLabel.setBounds(31, 69, 69, 15);
	    contentPane.add(lblNewLabel);
		contentPane.repaint();
		
	    TableDemo demo = new TableDemo(conn,tabn,usefunction,url,username,password	);
	    demo.GetData2(col,con,"CTA_check","0");
	    demo.setLayout(new GridLayout(1, 0));
	    demo.setBounds(31, 94, 528, 364);
	    contentPane.add(demo);
	    
	    JLabel label_2 = new JLabel("\u7533\u8ACB\u4EBA");
	    label_2.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_2.setBounds(110, 69, 69, 15);
	    contentPane.add(label_2);
	    
	    JLabel label_3 = new JLabel("\u7533\u8ACB\u4EBA\u7DE8\u865F");
	    label_3.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_3.setBounds(178, 69, 80, 15);
	    contentPane.add(label_3);
	    
	    JLabel label_1 = new JLabel("\u672A\u5BE9\u6838\u5BA2\u6236\u8CC7\u6599");
	    label_1.setFont(new Font("標楷體", Font.PLAIN, 18));
	    label_1.setBounds(31, 25, 137, 29);
	    contentPane.add(label_1);
	    
	    JLabel label_6 = new JLabel("\u7533\u8ACB\u65E5\u671F");
	    label_6.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_6.setBounds(263, 69, 69, 15);
	    contentPane.add(label_6);
	    
	    JLabel label_7 = new JLabel("\u8A02\u55AE\u72C0\u614B");
	    label_7.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_7.setBounds(334, 69, 69, 15);
	    contentPane.add(label_7);
	    
	    JLabel label_8 = new JLabel("\u9000\u4EF6\u539F\u56E0");
	    label_8.setFont(new Font("標楷體", Font.PLAIN, 16));
	    label_8.setBounds(413, 69, 69, 15);
	    contentPane.add(label_8);
	    
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    /*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});*/
	}
}
