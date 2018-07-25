package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class SearchAM extends JFrame {

	private JPanel contentPane;
	private JTextField AM_CTName_tf;
	private JTextField AM_Num_tf;
	static String tabn="AM";
	static String usefuntion="SearchAM";
	static String col="AM_Num";
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
					SearchAM frame = new SearchAM(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public SearchAM(final Connection conn,String col2, String con2,final String URL,final String UN,final String PW) {
		setResizable(false);
		setTitle("\u67E5\u8A62\u7DAD\u4FEE\u55AE");
		url = URL;
		username = UN;
		password = PW;
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//開始設置視窗
		setBounds(100, 100, 747, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(533, 10, 165, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(" \u5BA2\u6236\u540D\u7A31\uFF1A");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_1.setBounds(12, 71, 126, 21);
		contentPane.add(label_1);
		
		AM_CTName_tf = new JTextField();
		AM_CTName_tf.setColumns(10);
		AM_CTName_tf.setBounds(118, 72, 139, 21);
		contentPane.add(AM_CTName_tf);
		
		AM_Num_tf = new JTextField();
		AM_Num_tf.setColumns(10);
		AM_Num_tf.setBounds(384, 73, 139, 21);
		contentPane.add(AM_Num_tf);
		
		JLabel label_3 = new JLabel("\u7DAD\u4FEE\u55AE\u865F\uFF1A");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(274, 73, 126, 21);
		contentPane.add(label_3);
		
		JLabel label_12 = new JLabel("\u689D\u4EF6\uFF1A\u5BA2\u6236\u540D\u7A31\u6216\u7DAD\u4FEE\u55AE\u865F ");
		label_12.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_12.setBounds(24, 30, 331, 21);
		contentPane.add(label_12);
		
		JButton button = new JButton("\u641C\u5C0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(AM_Num_tf.getText().equals("")){
					col="AM_CTName";
					con=AM_CTName_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="AM_Num";
					con=AM_Num_tf.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchAM SA=new SearchAM(conn,col,con,URL,UN,PW);//宣告SearchAM
				SA.setVisible(true);
				col="AM_Num";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,usefuntion,URL,UN,PW);//宣告TableDemo，呼叫其中的方法
				clear.GetData(col,con);
				dispose();
			
			}
		});
		button.setBounds(565, 60, 106, 32);
		contentPane.add(button);
		
	    TableDemo demo = new TableDemo(conn,tabn,usefuntion,URL,UN,PW);//宣告TableDemo，呼叫其中的方法
	    demo.GetData(col,con);
	    demo.setLayout(new GridLayout(1, 0));//版面配置
	    demo.setBounds(12, 118, 705, 364);
	    contentPane.add(demo);
	}
}
