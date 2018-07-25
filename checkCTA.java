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

public class checkCTA extends JFrame {

	private JPanel contentPane;
	JLabel CTNum ;
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
	
	public checkCTA(Connection co,final String[] data,String URL,String  UN,String  PW) {
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
				rs = statement.executeQuery("SELECT * FROM CT Where CTA_Num = "+data[0]);
				  	
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
		
		setTitle("\u5BE9\u6838\u5BA2\u6236\u57FA\u672C\u8CC7\u6599");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("標楷體", Font.ITALIC, 22));
		company.setBounds(480, 10, 184, 33);
		contentPane.add(company);
		
		JLabel CTName=new JLabel("\u5BA2\u6236\u540D\u7A31\uFF1A"+names[1]);
		CTName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTName.setBounds(28, 56, 200, 15);
		contentPane.add(CTName);
		
		CTNum=new JLabel("\u5BA2\u6236\u4E3B\u6A94\u7533\u8ACB\u55AE\u865F\uFF1A"+names[0]);
		CTNum.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTNum.setBounds(28, 456, 313, 15);
		contentPane.add(CTNum);
	
		
		JLabel CTChiAbbr = new JLabel("\u4E2D\u6587\u7C21\u7A31\uFF1A"+names[6]);
		CTChiAbbr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTChiAbbr.setBounds(238, 56, 202, 15);
		contentPane.add(CTChiAbbr);
		
		JLabel CTPhone = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A"+names[2]);
		CTPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPhone.setBounds(450, 52, 214, 23);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A"+names[4]);
		CTFax.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFax.setBounds(28, 81, 200, 15);
		contentPane.add(CTFax);
		
		JLabel CTIndCate = new JLabel("\u884C\u696D\u985E\u5225\uFF1A"+names[7]);
		CTIndCate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTIndCate.setBounds(238, 81, 152, 15);
		contentPane.add(CTIndCate);

		JLabel CTTaxID = new JLabel("\u7D71\u4E00\u7DE8\u865F\uFF1A"+names[3]);
		CTTaxID.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTaxID.setBounds(450, 81, 175, 15);
		contentPane.add(CTTaxID);
		
		JLabel CTInvoTit = new JLabel("\u767C\u7968\u62AC\u982D\uFF1A"+names[28]);
		CTInvoTit.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoTit.setBounds(28, 106, 200, 15);
		contentPane.add(CTInvoTit);
		
		JLabel CTInvoAddr = new JLabel("\u5BA2\u6236\u767C\u7968\u5730\u5740\uFF1A"+names[29]);
		CTInvoAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoAddr.setBounds(28, 131, 636, 15);
		contentPane.add(CTInvoAddr);
		
		JLabel CTMMAddr = new JLabel("\u8ACB\u6B3E\u5730\u5740\uFF1A"+names[10]);
		CTMMAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTMMAddr.setBounds(28, 181, 636, 15);
		contentPane.add(CTMMAddr);
		
		JLabel CTAddr = new JLabel("\u5BA2\u6236\u5730\u5740\uFF1A"+names[7]);
		CTAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTAddr.setBounds(28, 156, 636, 15);
		contentPane.add(CTAddr);
		
		JLabel CTDelAddr = new JLabel("\u9001\u8CA8\u5730\u5740\uFF1A"+names[9]);
		CTDelAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDelAddr.setBounds(28, 206, 636, 15);
		contentPane.add(CTDelAddr);
		
		JLabel CTRecPhone = new JLabel("\u6536\u8CA8\u96FB\u8A71\uFF1A"+names[10]);
		CTRecPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecPhone.setBounds(238, 106, 202, 15);
		contentPane.add(CTRecPhone);
		
		JLabel CTRecName = new JLabel("\u6536\u8CA8\u4EBA\uFF1A"+names[11]);
		CTRecName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecName.setBounds(450, 106, 175, 15);
		contentPane.add(CTRecName);
		
		JLabel CTFounDate = new JLabel("\u6210\u7ACB\u65E5\u671F\uFF1A"+names[15]);
		CTFounDate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFounDate.setBounds(28, 256, 200, 15);
		contentPane.add(CTFounDate);
		
		JLabel CTBusiArea = new JLabel("\u71DF\u696D\u5834\u6240\uFF1A"+names[16]);
		CTBusiArea.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBusiArea.setBounds(238, 256, 186, 15);
		contentPane.add(CTBusiArea);
		
		JLabel CTConpName1 = new JLabel("\u806F\u7D61\u4EBA1\uFF1A"+names[12]);
		CTConpName1.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName1.setBounds(28, 231, 200, 15);
		contentPane.add(CTConpName1);
		
		JLabel CTConpName2 = new JLabel("\u806F\u7D61\u4EBA2\uFF1A"+names[13]);
		CTConpName2.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName2.setBounds(238, 231, 175, 15);
		contentPane.add(CTConpName2);
		
		JLabel CTConpName3 = new JLabel("\u806F\u7D61\u4EBA3\uFF1A"+names[14]);
		CTConpName3.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName3.setBounds(450, 231, 203, 15);
		contentPane.add(CTConpName3);
		
		JLabel CTPUC = new JLabel("\u5BE6\u6536\u8CC7\u672C\u984D\uFF1A"+names[18]);
		CTPUC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPUC.setBounds(28, 281, 269, 15);
		contentPane.add(CTPUC);
		
		JLabel CTTurnLast = new JLabel("\u4E0A\u5E74\u5EA6\u71DF\u696D\u984D\uFF1A"+names[19]);
		CTTurnLast.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTurnLast.setBounds(28, 306, 250, 15);
		contentPane.add(CTTurnLast);
		
		JLabel CTBank = new JLabel("\u4E3B\u8981\u5F80\u4F86\u9280\u884C/\u5206\u884C\uFF1A"+names[20]);
		CTBank.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBank.setBounds(28, 331, 339, 15);
		contentPane.add(CTBank);
		
		JLabel CTDAcco = new JLabel("\u7532\u5B58\u5E33\u865F\uFF1A"+names[21]);
		CTDAcco.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDAcco.setBounds(380, 331, 284, 15);
		contentPane.add(CTDAcco);
		
		JLabel CTBankName = new JLabel("\u6236\u540D\uFF1A"+names[22]);
		CTBankName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBankName.setBounds(28, 356, 250, 15);
		contentPane.add(CTBankName);
		
		JLabel CTSDelReq = new JLabel("\u5BA2\u6236\u7279\u6B8A\u4EA4\u8CA8\u8981\u6C42\uFF1A"+names[23]);
		CTSDelReq.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTSDelReq.setBounds(288, 356, 376, 15);
		contentPane.add(CTSDelReq);
		
		String CTPayCond = "";
		System.out.println(names[25]);
		if(names[25].equals("1"))CTPayCond="\u521D\u6B21\u4EA4\u6613\u6536\u73FE\u91D1(\u516C\u53F8\u898F\u5B9A)";
		if(names[25].equals("2"))CTPayCond="\u7D50\u5E33\u65E5\uFF1A30\u65E5";
		if(names[25].equals("3"))CTPayCond="\u6B21\u6708\u7D5060\u5929";
		JLabel label = new JLabel("\u4ED8\u6B3E\u689D\u4EF6\uFF1A"+CTPayCond);
		label.setFont(new Font("標楷體", Font.ITALIC, 16));
		label.setBounds(28, 381, 339, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("標楷體", Font.ITALIC, 16));
		label_1.setBounds(97, 557, 156, 15);
		contentPane.add(label_1);
		
		JLabel CTPayMeth = new JLabel("\u4ED8\u6B3E\u65B9\u5F0F\uFF1A"+names[24]);
		CTPayMeth.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayMeth.setBounds(28, 406, 313, 15);
		contentPane.add(CTPayMeth);
		
		JLabel build = new JLabel("\u5BA2\u6236\u8CA0\u8CAC\u4EBA\uFF1A"+names[27]);
		build.setFont(new Font("標楷體", Font.PLAIN, 16));
		build.setBounds(28, 431, 200, 15);
		contentPane.add(build);
		
		JButton ReturnCT = new JButton("\u8FD4\u56DE\u641C\u5C0B");
		ReturnCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//contentPane.setVisible(false);
				//backone.setVisible(false);
				dispose();
			}
		});
		ReturnCT.setFont(new Font("標楷體", Font.PLAIN, 17));
		ReturnCT.setBounds(309, 500, 103, 41);
		contentPane.add(ReturnCT);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		   JButton backCTA = new JButton("審核未過");
		   backCTA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{ 
						statement = conn.createStatement();
						String bR = backReason.getText().toString();
						System.out.println(bR); 
						statement.executeUpdate("UPDATE CTA SET CTA_Check = 2 Where CTA_Num =  "+names[30]+";");
						statement.executeUpdate("UPDATE CTA SET CTA_Reject = '"+bR+"' Where CTA_Num =  "+names[30]+";");
						conn.close();
						JOptionPane.showMessageDialog(checkCTA.this,"退回成功","成功",
								JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
						
						}catch(SQLException sqlException){//資料庫操作發生錯誤
					        sqlException.printStackTrace();
					    } 
				}
			});
		   	backCTA.setFont(new Font("標楷體", Font.PLAIN, 17));
		   	backCTA.setBounds(439, 500, 103, 41);
			contentPane.add(backCTA);
			
			JButton button_1 = new JButton("審核通過");
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					try{
					statement = conn.createStatement();
					statement.executeUpdate("UPDATE CTA SET CTA_Check = 1 Where CTA_Num =  "+names[30]+";");
					
					conn.close();
					JOptionPane.showMessageDialog(checkCTA.this,"審核成功","成功",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					
					}catch(SQLException sqlException){//資料庫操作發生錯誤
				        sqlException.printStackTrace();
				    }  
				} 
			});
			button_1.setFont(new Font("標楷體", Font.PLAIN, 17));
			button_1.setBounds(569, 500, 103, 41);
			contentPane.add(button_1);   
			
			backReason = new JTextField();
			backReason.setBounds(288, 431, 382, 62);
			contentPane.add(backReason);
			backReason.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\u9000\u4EF6\u539F\u56E0\uFF1A");
			lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
			lblNewLabel.setBounds(288, 406, 92, 15);
			contentPane.add(lblNewLabel);
		   

   }
}




