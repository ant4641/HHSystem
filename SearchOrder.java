package HHSystem;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

public class SearchOrder extends JFrame {

	private JPanel contentPane;
	private JTextField CTName_tf;
	private JTextField OR_Num_tf;
	//private JTable table;
	static String tabn="ORN";
	static String col="OR_Num";
	static String con="";
	static  String url = "";
	static  String username = ""; 
	static  String password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchOrder frame = new SearchOrder(null,"","", "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchOrder(final Connection conn,String col2, String con2,String URL, String UN, String PW) {
		setResizable(false);
		
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		
		setTitle("\u67E5\u8A62\u8A02\u55AE");
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
		label.setBounds(552, 10, 165, 40);
		contentPane.add(label);
		
		JLabel CTName = new JLabel(" \u5BA2\u6236\u540D\u7A31\uFF1A");
		CTName.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTName.setBounds(33, 71, 218, 21);
		contentPane.add(CTName);
		
		CTName_tf = new JTextField();
		CTName_tf.setColumns(10);
		CTName_tf.setBounds(141, 73, 139, 21);
		contentPane.add(CTName_tf);
		
		OR_Num_tf = new JTextField();
		OR_Num_tf.setBounds(440, 73, 122, 21);
		contentPane.add(OR_Num_tf);
		OR_Num_tf.setColumns(10);
		
	    JLabel lblNewLabel = new JLabel("\u8A02\u55AE\u7DE8\u865F");
	    lblNewLabel.setBounds(31, 128, 60, 15);
	    contentPane.add(lblNewLabel);
	    
	    JLabel ORNum = new JLabel("\u6216  \u8A02\u55AE\u7DE8\u865F\uFF1A");
	    ORNum.setFont(new Font("標楷體", Font.PLAIN, 20));
	    ORNum.setBounds(291, 73, 218, 21);
	    contentPane.add(ORNum);
	    
	    JLabel label_1 = new JLabel("\u641C\u5C0B\u689D\u4EF6");
	    label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
	    label_1.setBounds(44, 29, 218, 21);
	    contentPane.add(label_1);
		contentPane.repaint();

		JButton Search = new JButton("\u641C\u5C0B");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(OR_Num_tf.getText().equals("")){
					col="CTName";
					con=CTName_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="OR_Num";
					con=OR_Num_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchOrder SO=new SearchOrder(conn,col,con,url,username,password);
				SO.setVisible(true);
				col="OR_Num";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,"SearchOrder",url,username,password);
			    clear.GetData(col,con);
				dispose();
			}
		});
		Search.setBounds(584, 60, 106, 32);
		contentPane.add(Search);  
		
	    TableDemo demo = new TableDemo(conn,tabn,"SearchOrder",url,username,password);
	    demo.GetData(col,con);
	    demo.setLayout(new GridLayout(1, 0));
	    demo.setBounds(31, 153, 671, 330);
	    contentPane.add(demo);
	}
	
	
}
