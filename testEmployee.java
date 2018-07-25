package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


class testEmployee extends JFrame {
	static String url="";
	static String username="";
	static String password="";
	private static Connection conn;
	private JPanel contentPane;
	private Statement statement= null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 testEmployee frame = new  testEmployee(conn,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  testEmployee(Connection co,String[] dat,String URL,String  UN,String  PW) {
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		conn=co;
		final String id=dat[0];
		final String name=dat[4];
		final String[] data = dat;
		setTitle("\u4FEE\u6539\u4EBA\u4E8B\u8CC7\u6599");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0,0, 610, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("標楷體", Font.ITALIC, 20));
		company.setBounds(411, 10, 173, 24);
		contentPane.add(company);

		JLabel EID_lb = new JLabel("\u54E1\u5DE5\u7DE8\u865F："+data[0]);
		EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EID_lb.setBounds(29, 55, 231, 27);
		contentPane.add(EID_lb);
		
		String sta = null; 
		if(data[1].equals("1")){
			sta="管理者";
		}else if(data[1].equals("2")){
			sta="員工";
		}
		JLabel EPsta_lb = new JLabel("\u54E1\u5DE5\u968E\u7D1A："+sta);
		EPsta_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EPsta_lb.setBounds(264, 55, 249, 27);
		contentPane.add(EPsta_lb);
		
		JLabel EPpass_lb = new JLabel("\u54E1\u5DE5\u5BC6\u78BC："+data[2]);
		EPpass_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EPpass_lb.setBounds(264, 99, 249, 27);
		contentPane.add(EPpass_lb);
	
		JLabel EPost_lb = new JLabel("\u54E1\u5DE5\u8077\u52D9："+ data[3]);
		EPost_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EPost_lb.setBounds(29, 101, 249, 27);
		contentPane.add(EPost_lb);

		JLabel EName_lb = new JLabel("\u59D3\u540D：" + data[4]);
		EName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EName_lb.setBounds(29, 138, 207, 27);
		contentPane.add(EName_lb);
		
		JLabel ESSN_lb = new JLabel("\u8EAB\u5206\u8B49\u5B57\u865F："+data[5]);
		ESSN_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ESSN_lb.setBounds(264, 175, 309, 27);
		contentPane.add(ESSN_lb);
		
		JLabel ESex_lb = new JLabel("\u6027\u5225：" + data[6]);
		ESex_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ESex_lb.setBounds(29, 175, 189, 27);
		contentPane.add(ESex_lb);

		JLabel EBirDare_lb = new JLabel("\u751F\u65E5：" + data[7]);
		EBirDare_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EBirDare_lb.setBounds(264, 138, 243, 27);
		contentPane.add(EBirDare_lb);


		JLabel EAddr_lb = new JLabel("\u806F\u7D61\u5730\u5740：" + data[8]);
		EAddr_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EAddr_lb.setBounds(29, 286, 428, 49);
		contentPane.add(EAddr_lb);
		
		JLabel EPhone_lb = new JLabel("\u9023\u7D61\u96FB\u8A71：" + data[9]);
		EPhone_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EPhone_lb.setBounds(29, 212, 315, 27);
		contentPane.add(EPhone_lb);


		JLabel EPChone_lb = new JLabel("\u9023\u7D61\u624B\u6A5F："+data[10]);
		EPChone_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		EPChone_lb.setBounds(29, 249, 335, 27);
		contentPane.add(EPChone_lb);
		
		JButton comeback = new JButton("\u8FD4\u56DE\u641C\u5C0B");
		comeback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		comeback.setFont(new Font("標楷體", Font.PLAIN, 20));
		comeback.setBounds(123, 362, 124, 27);
		contentPane.add(comeback);


		JButton backAdd = new JButton("\u4FEE\u6539");
		backAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyED mED = new modifyED(conn,data,id,name,url,username,password);
				mED.setAlwaysOnTop(true); 
				mED.requestFocus();  
				mED.setVisible(true);
				dispose();
			}
		});
		backAdd.setFont(new Font("標楷體", Font.PLAIN, 20));
		backAdd.setBounds(344, 362, 124, 27);
		contentPane.add(backAdd);
		


		
	}
	/*public void ScreenSaver(String path) throws Exception  {
			Robot robot = new Robot();
			
			Dimension d = contentPane.getSize(getPreferredSize());
			Rectangle rect = new Rectangle(0, 0,610, 450);
			BufferedImage image = robot.createScreenCapture(rect);
			ImageIO.write(image, "png", new File(path));
	}*/
		
}
