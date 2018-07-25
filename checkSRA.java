package HHSystem;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import javax.swing.JTextField;

public class checkSRA extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String url="";
	static String username="";
	static String password="";
	static String []names=new String[1];
	static int numberOfColumns = 0;
	private static Connection conn;
	private Statement statement;
	private ResultSet rs;
	private ResultSetMetaData rsMetaData;
	private JTextField backReason;
	
	public checkSRA(Connection co,final String[] data,String URL,String  UN,String  PW) {
		setResizable(false);
		conn=co;
		url=URL;
		username=UN;
		password=PW;
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		numberOfColumns=0;
		
			try {
				statement = conn.createStatement();
				rs = statement.executeQuery("SELECT * FROM SR Where SRA_Num = "+data[0]);
				  	
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
				System.out.println("numberOfColumns="+numberOfColumns);	
				while(rs.next()){
					for(int i=1;i<=numberOfColumns;i++){
			    	 	if(rs.getObject(i)==null){
			    		 	names[i-1]="";
			    	 	}else{
			    		 	names[i-1]=rs.getObject(i).toString();	
			    	 	}		System.out.println(names[i-1]);	
			    	}
				}
				
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();}
		
		
		System.out.println("---------check--------"+names.length);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5BE9\u6838\u4F9B\u61C9\u5546\u57FA\u672C\u8CC7\u6599");
		label.setFont(new Font("標楷體", Font.PLAIN, 37));
		label.setBounds(161, 20, 349, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_1.setFont(new Font("標楷體", Font.ITALIC, 20));
		label_1.setBounds(551, 0, 165, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7522\u696D\u5225\uFF1A"+names[7]);
		label_2.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_2.setBounds(0, 79, 237, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4F9B\u61C9\u5546\u540D\u7A31\uFF1A"+names[1]);
		label_3.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_3.setBounds(0, 112, 201, 23);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u4F9B\u61C9\u5546\u50B3\u771F\uFF1A"+names[5]);
		label_4.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_4.setBounds(0, 145, 201, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u4F9B\u61C9\u5546\u7DE8\u865F\uFF1A"+names[2]);
		label_5.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_5.setBounds(211, 112, 237, 23);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u4F9B\u61C9\u5546\u7D71\u4E00\u7DE8\u865F\uFF1A"+names[6]);
		label_6.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_6.setBounds(211, 145, 237, 23);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u4F9B\u61C9\u5546\u96FB\u8A71\uFF1A"+names[4]);
		label_7.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_7.setBounds(458, 112, 258, 23);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u4F9B\u61C9\u5546\u8CA0\u8CAC\u4EBA\uFF1A"+names[8]);
		label_8.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_8.setBounds(458, 145, 258, 23);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u50B3\u771F\uFF1A"+names[12]);
		label_9.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_9.setBounds(339, 178, 377, 23);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u4F9B\u61C9\u5546\u5C08\u7DDA\u96FB\u8A71\uFF1A"+names[14]);
		label_10.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_10.setBounds(339, 211, 377, 23);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u96FB\u8A71\uFF1A"+names[11]);
		label_11.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_11.setBounds(0, 178, 319, 23);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("\u4F9B\u61C9\u5546\u696D\u52D9\u96FB\u8A71\uFF1A"+names[13]);
		label_12.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_12.setBounds(0, 211, 319, 23);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("\u4F9B\u61C9\u5546\u5730\u5740\uFF1A"+names[3]);
		label_13.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_13.setBounds(0, 244, 722, 23);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("\u4F9B\u61C9\u5546\u767C\u7968\u4F4D\u5740\uFF1A"+names[9]);
		label_14.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_14.setBounds(0, 277, 716, 23);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u5730\u5740\uFF1A"+names[10]);
		label_15.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_15.setBounds(0, 310, 716, 23);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("\u4F9B\u61C9\u5546\u7DB2\u5740\uFF1A"+names[15]);
		label_16.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_16.setBounds(0, 337, 716, 23);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("\u4F9B\u61C9\u5546\u4FE1\u7BB1\uFF1A"+names[16]);
		label_17.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_17.setBounds(0, 370, 716, 23);
		contentPane.add(label_17);
		
		JButton ReturnSRA = new JButton("\u8FD4\u56DE\u641C\u5C0B");
		ReturnSRA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//contentPane.setVisible(false);
				//backone.setVisible(false);
				dispose();
			}
		});
		
		ReturnSRA.setFont(new Font("標楷體", Font.PLAIN, 17));
		ReturnSRA.setBounds(310, 475, 103, 41);
		contentPane.add(ReturnSRA);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		   JButton backSRA = new JButton("審核未過");
		   backSRA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						statement = conn.createStatement();
						String bR = backReason.getText().toString();
						System.out.println(bR); 
						statement.executeUpdate("UPDATE SRA SET SRA_Check = 2 Where SRA_Num =  "+names[0]+";");
						statement.executeUpdate("UPDATE SRA SET SRA_Reject = '"+bR+"' Where SRA_Num =  "+names[0]+";");
						conn.close();
						JOptionPane.showMessageDialog(checkSRA.this,"退回成功","成功",
								JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
						
						}catch(SQLException sqlException){//資料庫操作發生錯誤
					        sqlException.printStackTrace();
					    } 
				}
			});
		   	backSRA.setFont(new Font("標楷體", Font.PLAIN, 17));
		   	backSRA.setBounds(438, 475, 103, 41);
			contentPane.add(backSRA);
			
			JButton button_1 = new JButton("審核通過");
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					try{
					statement = conn.createStatement();
					statement.executeUpdate("UPDATE SRA SET SRA_Check = 1 Where SRA_Num =  "+names[0]+";");
					
					conn.close();
					JOptionPane.showMessageDialog(checkSRA.this,"審核成功","成功",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					
					}catch(SQLException sqlException){//資料庫操作發生錯誤
				        sqlException.printStackTrace();
				    }  
				} 
			});
			button_1.setFont(new Font("標楷體", Font.PLAIN, 17));
			button_1.setBounds(569, 475, 103, 41);
			contentPane.add(button_1);   
			
			backReason = new JTextField();
			backReason.setBounds(290, 403, 382, 62);
			contentPane.add(backReason);
			backReason.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\u9000\u4EF6\u539F\u56E0\uFF1A");
			lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
			lblNewLabel.setBounds(179, 403, 92, 15);
			contentPane.add(lblNewLabel);

   }
}




