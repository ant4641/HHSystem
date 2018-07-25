package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
//import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//import javax.swing.JToggleButton;
//import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
//import java.awt.Label;
public class neworder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static int count =0 ;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JTextField CTName_tf;
	private JTextField CTNum_tf;
	private JTextField PS_tf;
	private JTextField pro[]=new JTextField[20];
	private JTextField mod[]=new JTextField[20];
	private JTextField qua[]=new JTextField[20];
	static int pronum = 10;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					neworder frame = new neworder(null,"", "", "", "");
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
	 * @param uRL2 
	 */
	public neworder(final Connection conn,final String EI,String URL, String UN, String PW) {
		setResizable(false);
		
		setTitle(" \u65B0\u589E\u8A02\u55AE\u9801\u9762");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 892, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		//訂單編號在此行
		final String OR_Num = getOR_num(); 
		JLabel OR_Num_lb = new JLabel("\u8A02\u55AE\u865F\u78BC\uFF1A"+OR_Num);
		OR_Num_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_Num_lb.setBounds(608, 75, 236, 21);
		contentPane.add(OR_Num_lb);
		
		JLabel CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31\uFF1A");
		CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTName_lb.setBounds(54, 106, 117, 21);
		contentPane.add(CTName_lb);
		
		final String date =getDateTime();
		
		JLabel OR_Date_lb = new JLabel("\u8A02\u55AE\u65E5\u671F\uFF1A"+date);
		OR_Date_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_Date_lb.setBounds(54, 20, 236, 21);
		contentPane.add(OR_Date_lb);
		
		JLabel CTNum_lb = new JLabel("\u5BA2\u6236\u7DE8\u865F\uFF1A");
		CTNum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTNum_lb.setBounds(54, 75, 101, 21);
		contentPane.add(CTNum_lb);
		
		JLabel ProdName_lb = new JLabel("\u7522\u54C1\u540D\u7A31");
		ProdName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdName_lb.setBounds(54, 153, 101, 26);
		contentPane.add(ProdName_lb);
		
		JLabel ProdModel_lb = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		ProdModel_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdModel_lb.setBounds(209, 156, 150, 21);
		contentPane.add(ProdModel_lb);
		
		JLabel OR_PurQuan_lb = new JLabel("\u6578\u91CF");
		OR_PurQuan_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_PurQuan_lb.setBounds(376, 153, 62, 26);
		contentPane.add(OR_PurQuan_lb);
		
		JLabel CTPhone_lb = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A");
		CTPhone_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTPhone_lb.setBounds(321, 106, 101, 21);
		contentPane.add(CTPhone_lb);
		
		JLabel PS_lb =  new JLabel("\u5099\u8A3B\uFF1A");
		PS_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		PS_lb.setBounds(54, 613, 82, 31);
		contentPane.add(PS_lb);
		
		JLabel Company_lb = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		Company_lb.setFont(new Font("標楷體", Font.ITALIC, 20));
		Company_lb.setBounds(691, 10, 165, 40);
		contentPane.add(Company_lb);
		
		CTName_tf = new JTextField();
		CTName_tf.setBounds(156, 108, 139, 21);
		contentPane.add(CTName_tf);
		CTName_tf.setColumns(10);
		
		CTNum_tf = new JTextField();
		CTNum_tf.setBounds(156, 75, 139, 21);
		contentPane.add(CTNum_tf);
		CTNum_tf.setColumns(10);
		
		PS_tf = new JTextField();
		PS_tf.setBounds(124, 603, 639, 40);
		contentPane.add(PS_tf);
		PS_tf.setColumns(10);
		
		JLabel CTFax_lb = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A");
		CTFax_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTFax_lb.setBounds(321, 75, 263, 21);
		contentPane.add(CTFax_lb);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u589E\u8A02\u55AE");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 37));
		lblNewLabel.setBounds(360, 25, 160, 40);
		contentPane.add(lblNewLabel);
		
		JLabel OR_Appt_EID_lb = new JLabel("\u586B\u55AE\u4EBA:"+EI);
		OR_Appt_EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		OR_Appt_EID_lb.setBounds(608, 106, 236, 21);
		contentPane.add(OR_Appt_EID_lb);
		
		JLabel label = new JLabel("\u7522\u54C1\u540D\u7A31");
		label.setFont(new Font("標楷體", Font.PLAIN, 20));
		label.setBounds(466, 153, 101, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_1.setBounds(621, 156, 150, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6578\u91CF");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_2.setBounds(773, 153, 62, 26);
		contentPane.add(label_2);
				
		//建立10個產品名稱
		for(int i=0;i<10;i++){
			pro[i]=new JTextField();
			pro[i].setColumns(10);
			pro[i].setBounds(54,189+38*i, 123, 26);
			contentPane.add(pro[i]);
			//prod[i].setVisible(false);

		}
		//建立10個產品型號
		for(int i=0;i<10;i++){
			mod[i]=new JTextField();
			mod[i].setColumns(10);
			mod[i].setBounds(209,189+38*i, 123, 26);
			contentPane.add(mod[i]);
			//prod[i].setVisible(false);

		}
		//建立10個訂購數量
		for(int i=0;i<10;i++){
			qua[i]=new JTextField();
			qua[i].setColumns(10);
			qua[i].setBounds(376,189+38*i, 46, 26);
			contentPane.add(qua[i]);
			//prod[i].setVisible(false);

		}
		
				//建立隱藏10個產品名稱
				for(int i=10;i<20;i++){
					pro[i]=new JTextField();
					pro[i].setColumns(10);
					pro[i].setBounds(466,189+38*(i-10), 123, 26);
					contentPane.add(pro[i]);
					pro[i].setVisible(false);

				}
				//建立隱藏10個產品型號
				for(int i=10;i<20;i++){
					mod[i]=new JTextField();
					mod[i].setColumns(10);
					mod[i].setBounds(621,189+38*(i-10), 123, 26);
					contentPane.add(mod[i]);
					mod[i].setVisible(false);

				}
				//建立隱藏10個訂購數量
				for(int i=10;i<20;i++){
					qua[i]=new JTextField();
					qua[i].setColumns(10);
					qua[i].setBounds(773,189+38*(i-10), 46, 26);
					contentPane.add(qua[i]);
					qua[i].setVisible(false);

				}
		
		
		//增多商品 把隱藏的欄位秀出
		JButton addMorePro_Btn = new JButton("\u589E\u591A\u5546\u54C1");
		addMorePro_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int empty=0;
				for(int i =0 ; i<20 ;i++){		//確認前10商品已填好才可新增按鈕
					if("".equals(pro[i].getText().trim())){empty++;}
				}
				if(empty==0){
					if(pronum<20){
						int b = pronum;
						pro[b].setVisible(true);
						mod[b].setVisible(true);
						qua[b].setVisible(true);
						pronum++;
					}
				}else{
					JOptionPane.showMessageDialog(neworder.this, "請先填完已有空格再新增", "警告", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		addMorePro_Btn.setFont(new Font("標楷體", Font.PLAIN, 20));
		addMorePro_Btn.setBounds(544, 25, 123, 40);
		contentPane.add(addMorePro_Btn);
		
		final neworder clone =this;
		final String[] pro2=new String[20];
		final String[] mod2=new String[20];
		final String[] qua2=new String[20];
		
		
		//新增建------------
		JButton goOrder_Btn = new JButton("\u65B0\u589E");
		goOrder_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//檢查是否有空值
				String CTNum,CTName;
				CTNum = CTNum_tf.getText();
				CTName = CTName_tf.getText();
				int empty=0;
				int proEmpty=0;
				//把全部新增的產品資料放進STring陣列傳送
				for(int i=0;i<20;i++){
					pro2[i]=pro[i].getText().trim();
					mod2[i]=mod[i].getText().trim();
					qua2[i]=qua[i].getText().trim();
					//System.out.println("pro2+mod2+qua2"+i+" :"+pro2[i]+"-"+mod2[i]+"-"+qua2[i]);
				}
				
				try{
				if("".equals(CTNum.toString().trim())){empty++;}
				if("".equals(CTName.toString().trim())){empty++;}
				for(int i=0; i<20 ;i++){
					if("".equals(pro[i].getText().trim())){proEmpty++;}
				}
				//沒有空值，才執行傳送給預覽畫面
				if(empty ==0){
						//checkname=rs.getobject(i)等於雙金天龍
					if(checkCT(CTNum,CTName).equals(CTName)){
						if(checkpro(pro2,mod2,qua2)==true){
							if(proEmpty!=20){
								previewNO PN = new previewNO(conn,
										clone,date,CTName_tf.getText(),CTNum_tf.getText(),OR_Num,
										PS_tf.getText(),EI,
										pro2,mod2,qua2,url,username,password);
								PN.setAlwaysOnTop(true); 
								PN.requestFocus();  
								PN.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(neworder.this, "不能新增空白訂單","新增錯誤",JOptionPane.WARNING_MESSAGE);	
							}
						}
					}else{
						JOptionPane.showMessageDialog(neworder.this, "沒有該客戶資料!\n 客戶編號或名稱錯誤","新增錯誤",JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(neworder.this, "客戶名稱和編號不可為空值", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(neworder.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
				n.printStackTrace();
			}

			}
		});
		goOrder_Btn.setFont(new Font("標楷體", Font.PLAIN, 20));
		goOrder_Btn.setBounds(773, 604, 82, 40);
		contentPane.add(goOrder_Btn);
		//新增建-------------
		
	}
	
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd ");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
	
	public String getOR_num(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("MMddmmss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
	
	public String checkCT(String CTNum2,String CTName2){ //用於確認訂單的客戶是否純在
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String checkname="";
		   int numberOfColumns;
			try {
				statement = con.createStatement();
				try{
					rs = statement.executeQuery("Select CTName From CT where CTName='"+CTName2+"' AND CTNum='"+CTNum2+"'");
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					while (rs.next()){  //顯示欄位裡的資料
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	 if(rs.getObject(i).equals(CTName2)){ //將符合的客戶名稱放進確認變數裡
					    	//  	 System.out.print(i+":");
							//     System.out.print(rs.getObject(i)+"\t");
							     checkname=(String)rs.getObject(i);	 //將符合的客戶名稱放進確認變數裡
							     break;
					    	 }	  	
					       }
					   }	
				}catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		return checkname;
	}
	
	public boolean checkpro(final String[] pro,final String[] mod,final String[] qua){
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String[][] checkpro=new String[0][0];  //用於存放取出待對應新增的商品的資料
		   int numberOfColumns=0;
		   int numberOfRows=0;
		   int kk=0;  // 計算產品資料是否有錯的計數器
		   
		   try{
		        statement = con.createStatement();
		        
				rs = statement.executeQuery("SELECT ProdName,ProdModel FROM Prod");
				rsMetaData = rs.getMetaData();
				while (rs.next()){ numberOfRows++;} //計算有幾筆(row的數量)資料
				//System.out.println("numberOfRows:" +numberOfRows);
				checkpro=new String[numberOfRows][2]; //用於存放取出的產品型號和名稱

				rs = statement.executeQuery("SELECT ProdName,ProdModel FROM Prod");
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				
				    int count=0; 
				    while (rs.next()){  //當record裡有資料時，顯示所有欄位資料
				    	
				      for(int i=1; i<=numberOfColumns; i++)
					   {
				    	 System.out.print(i+":");
					     System.out.print(rs.getObject(i)+"\t");   //欄位裡的值
					     checkpro[count][i-1]=(String)rs.getObject(i);
					     System.out.println(count+"-"+(i-1)+":"+checkpro[count][i-1]); 
				       }
				      count++;
				      System.out.println();	
				     }

		    }catch(SQLException sqlException){//資料庫操作發生錯誤
		        sqlException.printStackTrace();
		    }
		   int checkNameModel=0;
		   //System.out.println("----------------------1");
		   //System.out.println("pro :"+pro[0]+"-"+mod[0]);
		   //System.out.println("check :"+checkpro[0][0]+"-"+checkpro[0][1]);
			   for(int i=0 ; i<20; i++){
				   if((pro[i].equals(""))&&(mod[i].equals(""))){  //產品名稱和型號欄位皆空的省略檢查
					   if(!qua[i].equals("")){
						   	kk++;
						    String s=("第"+(i+1)+"個 產品名稱和型號皆為空，請把數量也清空");
							JOptionPane.showMessageDialog(neworder.this,s, "警告", JOptionPane.WARNING_MESSAGE);
					   }
				   }
				   else{
					   for(int j=0 ;j<numberOfRows;j++){
							  if((pro[i].equals(checkpro[j][0]))&&((mod[i].equals(checkpro[j][1])))){
									  checkNameModel++;
								  //System.out.println("----------------------2");
								  // System.out.println(checkNameModel);
							  }
						   }
						   if(checkNameModel!=1){	//查沒對應到商品的兩種可能
							   kk++;
							   if((pro[i].equals(""))||(mod[i].equals(""))){
								    String s=("第"+(i+1)+"個 產品名稱:"+pro[i]+" 或 型號:"+mod[i]+" 有空值錯誤!");
									JOptionPane.showMessageDialog(neworder.this,s, "警告", JOptionPane.WARNING_MESSAGE);
							   }else{
								    String s=("第"+(i+1)+"個 產品名稱:"+pro[i]+" 或 型號:"+mod[i]+" 輸入錯誤，查無該商品!");
									JOptionPane.showMessageDialog(neworder.this,s, "警告", JOptionPane.WARNING_MESSAGE);
							   }
							}else if(checkNameModel==1){ //查沒對應到商品的兩種可能 結束 後 準備確認正確產品的數量
								  if(qua[i].equals("")){
									  kk++;
									  String s=("第"+(i+1)+"個 產品名稱:"+pro[i]+" 的訂購數量不可為空值");
									  JOptionPane.showMessageDialog(neworder.this,s, "警告", JOptionPane.WARNING_MESSAGE);
								  }
								  else{
									  int quaa=new Integer(qua[i]);
									  if(quaa<=0){
										  kk++;
										  String s=("名稱:"+pro[i]+" 的訂購數量不可為小於或等於 0 ");
										  JOptionPane.showMessageDialog(neworder.this,s, "警告", JOptionPane.WARNING_MESSAGE);										  
									  }
								  }
							}
						   checkNameModel=0;
								
				   }
			   }//產品名稱和型號欄位皆空的省略檢查 結束
			   
			   if(kk>0){ //確認產品資訊是否還有錯
				   return false;  
			   }
			   else
				   return true;
	}
}

