package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PreviewNEWSRData extends JFrame {
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	//private JTextField SRInvoAddr;
	//private JTextField SRFactAddr;
	static String column;
	static String condition;
	private JPanel contentPane;
	Connection cc;
	//final int max;
	/**
	 * Launch the application.
	 */
	public static void main(Connection conn,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviewNEWSRData frame = new PreviewNEWSRData(null,null,"","","","","","","","","","","","","","","","","","","","");//18個""
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password2 
	 * @param username2 
	 * @param url2 
	 */
	
	public PreviewNEWSRData(Connection conn,NewSRData NSRD,final String SRName,final String SRAddr,final String SRPhone,final String SRFax,final String SRTaxID,final String SRPIC,final String SRInvoAddr,final String SRFactAddr,final String SRFactPhone,final String SRFactFax,final String SRBusiPhone,final String SRDLPhone,final String SRNetAddr,final String SREmail,final String str,final String EN,final String EI,final String URL,final String UN,final String PW) {

		setResizable(false);
		final NewSRData Hidding = NSRD;
		cc=conn;
		url = URL;
		username = UN;
		password = PW;
		final String date =getDateTime();
		
		final int srnum=getMax("SR","SRNum");
		final int max=getMax("SRA","SRA_Num");
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u589E\u4F9B\u61C9\u5546\u57FA\u672C\u8CC7\u6599");
		label.setFont(new Font("標楷體", Font.PLAIN, 37));
		label.setBounds(161, 20, 349, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_1.setFont(new Font("標楷體", Font.ITALIC, 20));
		label_1.setBounds(551, 0, 165, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7522\u696D\u5225\uFF1A"+str);
		label_2.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_2.setBounds(0, 79, 237, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4F9B\u61C9\u5546\u540D\u7A31\uFF1A"+SRName);
		label_3.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_3.setBounds(0, 112, 201, 23);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u4F9B\u61C9\u5546\u50B3\u771F\uFF1A"+SRFax);
		label_4.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_4.setBounds(0, 145, 201, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u4F9B\u61C9\u5546\u7DE8\u865F\uFF1A"+srnum);
		label_5.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_5.setBounds(211, 79, 237, 23);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u4F9B\u61C9\u5546\u7D71\u4E00\u7DE8\u865F\uFF1A"+SRTaxID);
		label_6.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_6.setBounds(211, 145, 237, 23);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u4F9B\u61C9\u5546\u96FB\u8A71\uFF1A"+SRPhone);
		label_7.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_7.setBounds(211, 112, 258, 23);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u4F9B\u61C9\u5546\u8CA0\u8CAC\u4EBA\uFF1A"+SRPIC);
		label_8.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_8.setBounds(458, 145, 258, 23);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u50B3\u771F\uFF1A"+SRFactFax);
		label_9.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_9.setBounds(339, 178, 377, 23);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u4F9B\u61C9\u5546\u5C08\u7DDA\u96FB\u8A71\uFF1A"+SRDLPhone);
		label_10.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_10.setBounds(339, 211, 377, 23);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u96FB\u8A71\uFF1A"+SRFactPhone);
		label_11.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_11.setBounds(0, 178, 319, 23);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("\u4F9B\u61C9\u5546\u696D\u52D9\u96FB\u8A71\uFF1A"+SRBusiPhone);
		label_12.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_12.setBounds(0, 211, 319, 23);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("\u4F9B\u61C9\u5546\u5730\u5740\uFF1A"+SRAddr);
		label_13.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_13.setBounds(0, 244, 722, 23);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("\u4F9B\u61C9\u5546\u767C\u7968\u4F4D\u5740\uFF1A"+SRInvoAddr);
		label_14.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_14.setBounds(0, 277, 716, 23);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("\u4F9B\u61C9\u5546\u5DE5\u5EE0\u5730\u5740\uFF1A"+SRFactAddr);
		label_15.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_15.setBounds(0, 310, 716, 23);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("\u4F9B\u61C9\u5546\u7DB2\u5740\uFF1A"+SRNetAddr);
		label_16.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_16.setBounds(0, 337, 716, 23);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("\u4F9B\u61C9\u5546\u4FE1\u7BB1\uFF1A"+SREmail);
		label_17.setFont(new Font("標楷體", Font.PLAIN, 18));
		label_17.setBounds(0, 370, 716, 23);
		contentPane.add(label_17);
		
		JButton button = new JButton("確定新增");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement;
				int Update=0;
				//int Update2=0;
					try{
						statement = cc.createStatement();
						try{
							Update = statement.executeUpdate("Insert Into SRA(SRA_Num,SRA_Appt,SRA_Appt_EID,SRA_ApplyDate,SRA_Check,SRA_Reject)VALUES('"+max+"','"+EN+"','"+EI+"','"+date+"','0','"+""+"')" );
							Update = statement.executeUpdate("Insert Into SR(SRA_Num,SRName,SRNum,SRAddr,SRPhone,SRFax,SRTaxID,SRIndCate,SRPIC,SRInvoAddr,SRFactAddr,SRFactPhone,SRFactFax,SRBusiPhone,SRDLPhone,SRNetAddr,SREmail) "
									+"VALUES('"+max+"','"+SRName+"','"+srnum+"','"+SRAddr+"','"+SRPhone+"','"+SRFax+"','"+SRTaxID+"','"+str+"','"+SRPIC+"','"+SRInvoAddr+"','"+SRFactAddr+"','"+SRFactPhone+"','"+SRFactFax+"','"+SRBusiPhone+"','"+SRDLPhone+"','"+SRNetAddr+"','"+SREmail+"')");
						}catch(SQLException sqlException){
							sqlException.printStackTrace();
						}
					}catch(SQLException SQLe){
						SQLe.printStackTrace();
					}
					if(Update>0){
						JOptionPane.showMessageDialog(PreviewNEWSRData.this, "新增產品資料成功 !","新增成功",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else{
							JOptionPane.showMessageDialog(PreviewNEWSRData.this, "新增產品資料失敗 !","新增失敗",JOptionPane.WARNING_MESSAGE);
							int result=JOptionPane.showConfirmDialog(PreviewNEWSRData.this,
									"確定要結束程式嗎?",
									"確認訊息",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.WARNING_MESSAGE);
							if (result==JOptionPane.YES_OPTION) {System.exit(0);}
							}
			}
		});
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(601, 405, 115, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hidding.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		button_1.setBounds(498, 405, 101, 43);
		contentPane.add(button_1);
	}
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd ");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
	public int getMax(String tableName,String colName){
		Statement statement;
		ResultSet rs = null;
		int[] numlist  = new int[5];
		int col=0,pick=0;
		int Max=0;
				try{
				        statement = cc.createStatement();
						rs = statement.executeQuery("SELECT "+colName+" FROM "+tableName+" Order By "+colName+" ASC");
						while(rs.next()){	col++;	}
						numlist= new int[col];
						int pp=0;
						rs = statement.executeQuery("SELECT "+colName+" FROM "+tableName+" Order By "+colName+" ASC");
						while(rs.next()){
							pick=Integer.parseInt(rs.getObject(1).toString());
							numlist[pp]=pick;
							pp++;
							System.out.println("numlist["+pp+"]= "+pick);
						}
						pp=0;
						Arrays.sort(numlist);
						Max=numlist[col-1];
						System.out.println("Max1: "+Max);
						Max=Max+1;
						System.out.println("-----------------------");
						System.out.println("Max2: "+Max);
					  }catch(SQLException sqlException){
			        sqlException.printStackTrace();
			      }
				return Max;
	
	}
	/*
	public int getMax(String tableName,String colName){
		Statement statement;
		ResultSet rs = null;
		int Max=0;
				try{
				        statement = cc.createStatement();
						rs = statement.executeQuery("SELECT "+colName+" FROM "+tableName+" Order By "+colName+" ASC");
						while(rs.next()){
							Max=Integer.parseInt(rs.getObject(1).toString());						
							System.out.println("Max: "+Max);  //看Max的變化
						}
						Max=Max+1;
						System.out.println("-----------------------");
						System.out.println("Max: "+Max);
					  }catch(SQLException sqlException){
			        sqlException.printStackTrace();
			      }
				return Max;
	
	}*/
}
