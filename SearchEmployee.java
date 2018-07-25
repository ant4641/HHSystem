package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField EName_tf;
	private JTextField EID_tf;
	private static Connection conn;
	static String tabn="Employee";
	static String usefuntion="SearchEmployee";
	static String col="EID";
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
					SearchEmployee frame = new SearchEmployee(conn,"","","","","");
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
	public SearchEmployee(Connection co,String col2, String con2,String URL,String  UN,String  PW) {
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		conn=co;
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		setTitle("\u67E5\u8A62\u54E1\u5DE5");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(561, 10, 165, 40);
		contentPane.add(label);
		
		JLabel EName_lb = new JLabel("\u54E1\u5DE5\u540D\u7A31\uFF1A");
		EName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EName_lb.setBounds(42, 71, 218, 21);
		contentPane.add(EName_lb);
		
		EName_tf = new JTextField();
		EName_tf.setColumns(10);
		EName_tf.setBounds(150, 73, 139, 21);
		contentPane.add(EName_tf);
		
		EID_tf = new JTextField();
		EID_tf.setColumns(10);
		EID_tf.setBounds(449, 73, 122, 21);
		contentPane.add(EID_tf);
		
		JLabel EID_lb = new JLabel("\u6216  \u54E1\u5DE5\u7DE8\u865F\uFF1A");
		EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EID_lb.setBounds(300, 73, 218, 21);
		contentPane.add(EID_lb);
		
		
		JButton Search = new JButton("\u641C\u5C0B");
		Search.setFont(new Font("標楷體", Font.PLAIN, 20));
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EID_tf.getText().equals("")){
					col="EName";
					con=EName_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="EID";
					con=EID_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchEmployee SE=new SearchEmployee(conn,col,con,url,username,password);
				SE.setVisible(true);
				col="EID";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,usefuntion,url,username,password);
				clear.GetData(col,con);
				dispose();
			}
		});
		Search.setBounds(594, 70, 106, 32);
		contentPane.add(Search);
		
		 TableDemo demo = new TableDemo(conn,tabn,usefuntion,url,username,password);
		 demo.GetData(col,con);
		 demo.setLayout(new GridLayout(1, 0));
		 demo.setBounds(31, 153, 705, 364);
		 contentPane.add(demo);
	}
}

