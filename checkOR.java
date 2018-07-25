package HHSystem;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class checkOR extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String url="";
	static String username="";
	static String password="";
	private JLabel proset[]=new JLabel [20];
	private JLabel modset[]=new JLabel[20];
	private JLabel quaset[]=new JLabel[20];
	private String[][] pro =new String[0][0];
	private static Connection conn;
	private Statement statement;
	private ResultSet rs;
	private ResultSetMetaData rsMetaData;
	private JTextField backReason;
	  
	public checkOR(Connection co,String[] data,String URL,String  UN,String  PW) {
		setResizable(false);
		conn=co;
		url=URL;
		username=UN;
		password=PW;
		setResizable(false);
		final String num=data[0];
		String[] NPF=new String[3];
		NPF=getNumPhoFax(data[2],conn);
		
		setTitle("\u8A72\u8A02\u55AE\u57FA\u672C\u8CC7\u6599");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 871, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(674, 10, 165, 40);
		contentPane.add(label);
		
		JLabel OR_Date_lb = new JLabel("訂單日期: "+data[1]);
		OR_Date_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_Date_lb.setBounds(37, 20, 236, 21);
		contentPane.add(OR_Date_lb);
		
		JLabel ORNum_lb = new JLabel("\u8A02\u55AE\u865F\u78BC\uFF1A"+data[0]);
		ORNum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ORNum_lb.setBounds(591, 82, 239, 21);
		contentPane.add(ORNum_lb);
		
		JLabel label_4 = new JLabel("\u6578\u91CF");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(756, 153, 62, 26);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_5.setBounds(580, 156, 150, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u7522\u54C1\u540D\u7A31");
		label_6.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_6.setBounds(449, 153, 101, 26);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u6578\u91CF");
		label_7.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_7.setBounds(359, 153, 62, 26);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		label_8.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_8.setBounds(164, 156, 173, 21);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u7522\u54C1\u540D\u7A31");
		label_9.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_9.setBounds(37, 153, 101, 26);
		contentPane.add(label_9);
		
		//PhFa=getPhoFax(data[2]);
		JLabel CTPhone_lb = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A"+NPF[2]);
		CTPhone_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTPhone_lb.setBounds(304, 113, 271, 21);
		contentPane.add(CTPhone_lb);
		
		JLabel CTFax_lb = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A"+NPF[1]);
		CTFax_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTFax_lb.setBounds(304, 82, 263, 21);
		contentPane.add(CTFax_lb);
		
		JLabel CTNum_lb = new JLabel("\u5BA2\u6236\u7DE8\u865F\uFF1A"+NPF[0]);
		CTNum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTNum_lb.setBounds(37, 82, 237, 21);
		contentPane.add(CTNum_lb);
		
		JLabel CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31\uFF1A"+data[2]);
		CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTName_lb.setBounds(37, 113, 248, 21);
		contentPane.add(CTName_lb);
		
		JLabel OR_Appt_EID_lb = new JLabel("\u586B\u55AE\u4EBA: "+data[3]);
		OR_Appt_EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_Appt_EID_lb.setBounds(591, 113, 236, 21);
		contentPane.add(OR_Appt_EID_lb);
		
		JLabel label_15 = new JLabel("\u5099\u8A3B\uFF1A"+data[7]);
		label_15.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_15.setBounds(37, 604, 469, 31);
		contentPane.add(label_15);
		
		String os;
		//System.out.println("data[5]"+data[5]);
		os=Orderstate(data[5]);
		JLabel OR_state_lb = new JLabel("訂單狀態: "+os);
		OR_state_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_state_lb.setBounds(304, 20, 236, 21);
		contentPane.add(OR_state_lb);
		
		JLabel OR_ApplyDate = new JLabel("申請日期: "+data[4]);
		OR_ApplyDate.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_ApplyDate.setBounds(304, 51, 236, 21);
		contentPane.add(OR_ApplyDate);
		
		for(int i=0;i<10;i++){
			proset[i]=new JLabel();
			//proset[i].setText("1");
			proset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
			proset[i].setBounds(37,189+38*i, 123, 26);
			contentPane.add(proset[i]);
			//prod[i].setVisible(false);

		}
		for(int i=0;i<10;i++){
			modset[i]=new JLabel();
			//modset[i].setText("2");
			modset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
			modset[i].setBounds(164,189+38*i, 150, 26);
			contentPane.add(modset[i]);
			//prod[i].setVisible(false);

		}
		//建立10個訂購數量
		for(int i=0;i<10;i++){
			quaset[i]=new JLabel();
			//quaset[i].setText("3");
			quaset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
			quaset[i].setBounds(359,189+38*i, 46, 26);
			contentPane.add(quaset[i]);
			//prod[i].setVisible(false);

		}
			//建立右邊10個產品名稱
			for(int i=10;i<20;i++){
				proset[i]=new JLabel();
				//proset[i].setText("1");
				proset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
				proset[i].setBounds(449,189+38*(i-10), 123, 26);
				contentPane.add(proset[i]);
				//pro[i].setVisible(false);
	
			}
			//建立右邊10個產品型號
			for(int i=10;i<20;i++){
				modset[i]=new JLabel();
				//modset[i].setText("2");
				modset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
				modset[i].setBounds(580,189+38*(i-10), 123, 26);
				contentPane.add(modset[i]);
				//mod[i].setVisible(false);
	
			}
			//建立右邊10個訂購數量
			for(int i=10;i<20;i++){
				quaset[i]=new JLabel();
				//quaset[i].setText("3");
				quaset[i].setFont(new Font("標楷體", Font.PLAIN, 20));
				quaset[i].setBounds(756,189+38*(i-10), 46, 26);
				contentPane.add(quaset[i]);
				//qua[i].setVisible(false);
			}
			getpro(data[0],conn); //將用訂單編號抓到的產品資料放進pro陣列裡
			for(int i=0 ;i<pro.length;i++){
				proset[i].setText(pro[i][2]);
				modset[i].setText(pro[i][0]);
				quaset[i].setText(pro[i][1]);
			}
			
			JButton ReturnSO = new JButton("\u8FD4\u56DE\u641C\u5C0B");
			ReturnSO.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//contentPane.setVisible(false);
					//backone.setVisible(false);
					dispose();
				}
			});
			ReturnSO.setFont(new Font("標楷體", Font.PLAIN, 17));
			ReturnSO.setBounds(526, 639, 103, 41);
			contentPane.add(ReturnSO);
			
			backReason = new JTextField();
			backReason.setBounds(128, 643, 382, 35);
			contentPane.add(backReason);
			backReason.setColumns(10);
			
			JButton returnOR = new JButton("審核未過");
			returnOR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						conn = DriverManager.getConnection(url, username, password ); 
						System.out.println("資料庫連結成功"); 
						statement = conn.createStatement();
						String bR = backReason.getText().toString();
						
						statement.executeUpdate("UPDATE ORN SET OR_check = 2 Where OR_NUM = "+num+";");
						statement.executeUpdate("UPDATE ORN SET OR_Rejec = '"+bR+"' Where OR_NUM = "+num+";");
						
						conn.close();
						JOptionPane.showMessageDialog(checkOR.this,"退回成功","成功",
								JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
						
						}catch(SQLException sqlException){//資料庫操作發生錯誤
					        sqlException.printStackTrace();
					    }  
				}
			});
			returnOR.setFont(new Font("標楷體", Font.PLAIN, 17));
			returnOR.setBounds(632, 639, 103, 41);
			contentPane.add(returnOR);
			
			JButton button_1 = new JButton("審核通過");
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					try{
					statement = conn.createStatement();
					statement.executeUpdate("UPDATE ORN SET OR_check = 1 Where OR_NUM =  "+num+";");
					
					conn.close();
					JOptionPane.showMessageDialog(checkOR.this,"審核成功","成功",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					
					}catch(SQLException sqlException){//資料庫操作發生錯誤
				        sqlException.printStackTrace();
				    }  
				} 
			});
			button_1.setFont(new Font("標楷體", Font.PLAIN, 17));
			button_1.setBounds(736, 639, 103, 41);
			contentPane.add(button_1);
			
			JLabel label_1 = new JLabel("\u9000\u4EF6\u539F\u56E0\uFF1A");
			label_1.setFont(new Font("標楷體", Font.PLAIN, 16));
			label_1.setBounds(37, 645, 81, 15);
			contentPane.add(label_1);
			
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public String Orderstate(String state){
		int s=Integer.parseInt(state);
		switch(s){
		case 0:{ return "未審核" ; }
		case 1:{ return "審核通過" ; }
		case 2:{ return "審核未通過" ; }
		case 3:{ return "為預備訂單" ; }
		
		default :return "有錯誤";
		}
	}
	
	public String[] getNumPhoFax(String CTName2,Connection co){
		
		   Connection conn=co;
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String[] checknum2=new String[3];
		   int numberOfColumns;
		   
		
			try {
				statement = conn.createStatement();
				try{
					rs = statement.executeQuery("Select CTNum,CTFax,CTPhone From CT where CTName='"+CTName2+"'");
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					while (rs.next()){  //顯示欄位裡的資料
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					       //System.out.print(i+":");
						   // System.out.println((String)rs.getObject(i)+"\t");
						    checknum2[i-1]=rs.getObject(i).toString();   //取得傳真和電話放陣列傳出
						    //System.out.println("CT "+i+":"+checknum2[i]);
					       }
					   }	
				}catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		
		return checknum2;
	}
	
	public void getpro(String ORNum,Connection co){

		Connection conn=co;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		int numberOfColumns=0;
		int numberOfRows=0;
		   
			try {
				statement = conn.createStatement();
				
				try{
				  //取出等待對應的商品型號、庫存、訂單總數量
					
				    rs = statement.executeQuery("SELECT ORNCon.OR_ProdModel,ORNCon.OR_PurQuan,Prod.ProdName FROM ORNCon ,Prod WHERE ORNCon.OR_ProdModel=Prod.ProdModel AND ORNCon.OR_Num="+ORNum+" ");					
					rsMetaData = rs.getMetaData();
					while(rs.next()){numberOfRows++;};  //計算資料有幾筆
					
				    rs = statement.executeQuery("SELECT ORNCon.OR_ProdModel,ORNCon.OR_PurQuan,Prod.ProdName FROM ORNCon ,Prod WHERE ORNCon.OR_ProdModel=Prod.ProdModel AND ORNCon.OR_Num="+ORNum+" ");
				    rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					
					pro=new String[numberOfRows][3];  //用於存放取出的產品型號和現有庫存 和 訂單總需求量
					int count2=0;
					while (rs.next()){  //顯示欄位裡的資料
				    	
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	// System.out.print(i+":");
						    // System.out.print(rs.getObject(i)+"\t");
						     pro[count2][i-1]=rs.getObject(i).toString();					
						    // System.out.println(count2+"-"+(i-1)+":"+pro[count2][i-1]); 
					       }
					      count2++;
					      System.out.println();	
					     }
					
				     conn.close();
				     //取出等待對應的商品型號、庫存、訂單總數量 完成
				     }catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		
	}
}

