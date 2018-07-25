package HHSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableColumn;
import javax.swing.event.AncestorEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;
public class PreviewSM extends JFrame {

	private JPanel contentPane;
	Connection con;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JButton backSearch_btn;
	private JTable table;
	private JTable table_1;
	private String ctNum="",ctPho="",ctAddr="";
	private String[][] ORNData= new String[0][0];
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	static String interest;
	static String passway;
	static String SM_Num;
	static String OR_Num;
	static String CTName;
	static String SMDate;
	static int SellTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviewSM frame = new PreviewSM(null,null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public PreviewSM(Connection conn,String[] data,String URL, String UN, String PW) {
		setResizable(false);
		
		setTitle("\u65B0\u589E\u51FA\u8CA8\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0,0, 916, 871);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		getCT(data[2]);
		getPRO(data[0]);
		SMDate=getDateTime();
		SM_Num="SM"+data[0];	//設定出貨單號為SM+訂單號碼
		CTName=data[2];
		OR_Num=data[0];	//搜尋頁傳過來的訂單號碼放進全域變數
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.PLAIN, 24));
		label.setBounds(26, 5, 202, 40);
		contentPane.add(label);
		
		JLabel SM_Date = new JLabel("\u51FA\u8CA8\u65E5\u671F\uFF1A"+SMDate);
		SM_Date.setFont(new Font("標楷體", Font.PLAIN, 20));
		SM_Date.setBounds(522, 51, 236, 21);
		contentPane.add(SM_Date);
		
		JLabel ORNum_lb = new JLabel("\u8A02\u55AE\u865F\u78BC\uFF1A"+data[0]);
		ORNum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ORNum_lb.setBounds(26, 51, 239, 21);
		contentPane.add(ORNum_lb);
		
		JLabel SM_Num_lb = new JLabel("\u51FA\u8CA8\u55AE\u865F\uFF1A"+SM_Num);
		SM_Num_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		SM_Num_lb.setBounds(522, 87, 236, 21);
		contentPane.add(SM_Num_lb);
		
		JLabel CTPhone_lb = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A"+ctPho);
		CTPhone_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTPhone_lb.setBounds(26, 118, 271, 21);
		contentPane.add(CTPhone_lb);
		
		JLabel CTDelAddr_lb = new JLabel("\u9001\u8CA8\u5730\u5740\uFF1A"+ctAddr);
		CTDelAddr_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTDelAddr_lb.setBounds(26, 149, 780, 47);
		contentPane.add(CTDelAddr_lb);
		
		JLabel CTNum_lb = new JLabel("\u5BA2\u6236\u7DE8\u865F\uFF1A"+ctNum);
		CTNum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTNum_lb.setBounds(26, 87, 237, 21);
		contentPane.add(CTNum_lb);
		
		JLabel CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31\uFF1A"+data[2]);
		CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		CTName_lb.setBounds(263, 87, 248, 21);
		contentPane.add(CTName_lb);
		
		JLabel label_15 = new JLabel("\u5099\u8A3B:");
		label_15.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_15.setBounds(555, 203, 68, 31);
		contentPane.add(label_15);
		
		final JComboBox Passway = new JComboBox();
		Passway.setFont(new Font("標楷體", Font.PLAIN, 20));
		Passway.addItem("-請選擇-");
		Passway.addItem("送達");
		Passway.addItem("託運");
		Passway.addItem("自取");
		Passway.addItem("快遞");
		Passway.addItem("郵寄");
		Passway.addItem("盒裝");
		Passway.setBounds(621, 113, 115, 31);
		contentPane.add(Passway);
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent ie) {
		    	  passway=Passway.getSelectedItem().toString();
		      }
		    };
		Passway.addItemListener(itemListener);
		
		JLabel label_2 = new JLabel("\u51FA\u8CA8\u55AE");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 30));
		label_2.setBounds(340, 13, 103, 40);
		contentPane.add(label_2);
		
		JLabel Passway_lb = new JLabel("\u51FA\u8CA8\u65B9\u5F0F\uFF1A");
		Passway_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		Passway_lb.setBounds(522, 118, 236, 21);
		contentPane.add(Passway_lb);
		
		JLabel SellSum_lb = new JLabel("\u92B7\u552E\u984D\u5408\u8A08\uFF1A"+getSum());
		SellSum_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		SellSum_lb.setBounds(319, 697, 202, 26);
		contentPane.add(SellSum_lb);
		
		JLabel lbll = new JLabel("\u71DF\u696D\u7A05\uFF1A");
		lbll.setFont(new Font("標楷體", Font.PLAIN, 20));
		lbll.setBounds(179, 731, 96, 26);
		contentPane.add(lbll);
		
		final JLabel intersset_lb = new JLabel("\u4E8C\u806F\u5F0F\uFF1A");
		intersset_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		intersset_lb.setBounds(359, 731, 160, 26);
		contentPane.add(intersset_lb);
		
		final JLabel SellTotal_lb = new JLabel("\u7E3D\u8A08\uFF1A");
		SellTotal_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		SellTotal_lb.setBounds(379, 761, 150, 26);
		contentPane.add(SellTotal_lb);
		
		final JComboBox interest_cb = new JComboBox();
		interest_cb.setModel(new DefaultComboBoxModel(new String[] {"\u8ACB\u9078\u64C7"}));
		interest_cb.setFont(new Font("標楷體", Font.PLAIN, 20));
		interest_cb.setBounds(263, 729, 86, 31);
		interest_cb.addItem("應稅");
		interest_cb.addItem("零稅率");
		interest_cb.addItem("免稅");
		contentPane.add(interest_cb);
		ItemListener itemListener1 = new ItemListener() {
		      public void itemStateChanged(ItemEvent ie) {
		    	  interest=interest_cb.getSelectedItem().toString();
					switch(interest){
						case "應稅" :{
							intersset_lb.setText("\u4E8C\u806F\u5F0F\uFF1A"+(int)(getSum()*0.05));
							SellTotal_lb.setText("\u7E3D\u8A08\uFF1A"+(int)(getSum()*1.05));
							SellTotal=(int)(getSum()*1.05);
							break;
							}
						case "零稅率" :{
							intersset_lb.setText("\u4E8C\u806F\u5F0F\uFF1A"+0);
							SellTotal_lb.setText("\u7E3D\u8A08\uFF1A"+getSum());
							SellTotal=getSum();
							break;
							}
						case "免稅" :{
							intersset_lb.setText("\u4E8C\u806F\u5F0F\uFF1A"+0);
							SellTotal_lb.setText("\u7E3D\u8A08\uFF1A"+getSum());
							SellTotal=getSum();
							break;
							}
					}
		      }
		    };
		interest_cb.addItemListener(itemListener1);
		
		Object[][] a={{"聯軸器","MTH-40*50","1","30","5000"},{"聯軸器","MTHCHK-40*50500000","1","30","5000"},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"聯軸器","MTH-40*50","1","30","5000"},{"聯軸器","MTHCHK-40*50500000","1","30","5000"},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""},{"l","1","","",""}};
		String[] cols={"產品名稱","型號(含規格)","數量","單價$","總價$"};
		JTable table;
		table= new JTable(ORNData,cols);
		table.setFont(new Font("標楷體", Font.PLAIN, 20));
		table.setEnabled(false);
		table.setRowHeight(23);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFillsViewportHeight(true); 
		TableColumn column;
		column=table.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);
		column=table.getColumnModel().getColumn(1);
		column.setPreferredWidth(150);
		column=table.getColumnModel().getColumn(2);
		column.setPreferredWidth(15);
		column=table.getColumnModel().getColumn(3);
		column.setPreferredWidth(30);
		column=table.getColumnModel().getColumn(4);
		column.setPreferredWidth(30);
		JScrollPane SP=new JScrollPane(table);
		SP.setBounds(24, 206, 505, 487);
		contentPane.add(SP);
		
		JLabel CTSSugn_lb = new JLabel("\u5BA2\u6236\u7C3D\u6536");
		CTSSugn_lb.setHorizontalAlignment(SwingConstants.CENTER);
		CTSSugn_lb.setFont(new Font("標楷體", Font.PLAIN, 24));
		CTSSugn_lb.setBounds(531, 683, 287, 40);
		contentPane.add(CTSSugn_lb);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(532, 727, 286, 60);
		contentPane.add(textPane);
		
		final JTextPane PS_tp = new JTextPane();
		PS_tp.setEditable(false);
		PS_tp.setBounds(555, 237, 231, 239);
		PS_tp.setFont(new Font("標楷體", Font.PLAIN, 16));
		PS_tp.setText("1.\u6536\u8CA8\u5F8C\u82E5\u6709\u4E0D\u5408\uFF0C\u8ACB\u65BC7\u65E5\u5167\u9000\u56DE\u3002\r\n2.\u82E5\u9700\u9000\u8CA8\uFF0C\u8ACB\u52D9\u5FC5\u9023\u540C\u767C\u7968\u4E00\u4F75\u9000\u56DE\u3002\r\n\r\n\u672C\u4EA4\u6613\u70BA\u9644\u689D\u4EF6\u8CB7\u8CE3\uFF0C\u4F9D\u52D5\u7522\u4EA4\u6613\u6CD5\u7B2C\u4E09\u7AE0\u4E4B\u898F\u5B9A\uFF0C\u5728\u8CA8\u6B3E\u672A\u4ED8\u6E05\u6216\u7968\u64DA\u672A\u514C\u73FE\u511F\u4ED8\u4E4B\u524D\uFF0C\r\n\u6A19\u7684\u7269\u4E4B\u6240\u6709\u6B0A\u4ECD\u898F\u5C6C\u672C\u516C\u53F8\u6240\u6709\uFF0C\u8CB7\u53D7\u4EBA\u7121\u6B0A\u7570\u8B70\uFF0C\u672C\u516C\u53F8\u7121\u9808\u6CD5\u5F8B\u7A0B\u5E8F\u96A8\u6642\u53D6\u56DE\u672C\u8CA8\u54C1\u3002");
		contentPane.add(PS_tp);
		
		backSearch_btn = new JButton("\u8FD4\u56DE\u641C\u5C0B");
		backSearch_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backSearch_btn.setFont(new Font("標楷體", Font.PLAIN, 17));
		backSearch_btn.setBounds(594, 797, 103, 41);
		contentPane.add(backSearch_btn);
		
		
		JButton gooAdd_btn = new JButton("\u65B0\u589E");
		gooAdd_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
			try{
				if(passway==null){
					JOptionPane.showMessageDialog(PreviewSM.this, "請選擇出貨方式","出貨方式未選",JOptionPane.INFORMATION_MESSAGE);	
				}else if(interest==null){
					JOptionPane.showMessageDialog(PreviewSM.this, "請選擇營業稅類別","營業稅類別未選",JOptionPane.INFORMATION_MESSAGE);	
				}else if(screenSave("D:HHSystem/ShipmentPapers/")==true){//準備更新產品序號表加進已出貨的單號
						if(updatePro()==1){
							if(goAdd()==1){
								//System.out.println("go print ");
										JOptionPane.showMessageDialog(PreviewSM.this, "產生出貨單成功請到 'D:/ShipmentPapers/' 裡確認","產生出貨單成功",JOptionPane.INFORMATION_MESSAGE);		
										int result=JOptionPane.showConfirmDialog(PreviewSM.this,
									               "確定要結束程式嗎?",
									               "確認訊息",
									               JOptionPane.YES_NO_OPTION,
									               JOptionPane.WARNING_MESSAGE);
									    if (result==JOptionPane.YES_OPTION) {dispose();}
							 }
						}else{ 
							JOptionPane.showMessageDialog(PreviewSM.this, "更新產品已出貨狀態失敗","更新錯誤",JOptionPane.INFORMATION_MESSAGE);	
						}
					
				}	
			}catch (Exception e){
				e.printStackTrace();
			}

			}
		});
		gooAdd_btn.setFont(new Font("標楷體", Font.PLAIN, 17));
		gooAdd_btn.setBounds(715, 797, 103, 41);
		contentPane.add(gooAdd_btn);
		
	}
	
	public void getCT(String CTName){
		
		Statement statement;
		ResultSet rs = null;
		 try{
		       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
		         
		         System.out.println("資料庫連結成功"); 
		         statement = con.createStatement();
				rs = statement.executeQuery("SELECT * FROM CT Where CTName = '"+CTName+"'");
				while(rs.next()){
					ctNum=rs.getString("CTNum");
					ctPho=rs.getString("CTPhone");
					ctAddr=rs.getString("CTDelAddr");
				}
				
			  }catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }
	}
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd ");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
	public void getPRO(String OR_Num){
		ORNData= new String[1][1];
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		numberOfRows=0;
			try {
				
				//System.out.println("連接成功");
				statement = con.createStatement();
				
				try{
				  //取出等待對應的商品型號、庫存、訂單總數量
				
					rs = statement.executeQuery("SELECT Prod.ProdName,ORNCon.OR_ProdModel,ORNCon.OR_PurQuan,Prod.ProdSellPrice FROM ORNCon,Prod Where ORNCon.OR_ProdModel=Prod.ProdModel AND ORNCon.OR_Num ='"+OR_Num+"'");
					rsMetaData = rs.getMetaData();
					while(rs.next()){numberOfRows++;};  //計算資料有幾筆
					//System.out.println("numberOfRows: "+numberOfRows);
					
					rs = statement.executeQuery("SELECT Prod.ProdName,ORNCon.OR_ProdModel,ORNCon.OR_PurQuan,Prod.ProdSellPrice FROM ORNCon,Prod Where ORNCon.OR_ProdModel=Prod.ProdModel AND ORNCon.OR_Num ='"+OR_Num+"'");
				    rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					
					ORNData=new String[numberOfRows][5];  //用於存放取出的產品型號和現有庫存 和 訂單總需求量
					int count2=0;
				
					while (rs.next()){  //顯示欄位裡的資料
				    	
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	  ORNData[count2][i-1]=rs.getObject(i).toString();
					    	 // System.out.println("--PurchaseData["+count2+"]["+(i-1)+"]: "+PurchaseData[count2][i-1]);	  
					       }
					      ORNData[count2][4]=""+Integer.parseInt(ORNData[count2][2])*Integer.parseInt(ORNData[count2][3]);
					      count2++;
					 
					     }

				     //取出等待對應的商品型號、庫存、訂單總數量 完成
				     }catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
	}
	public int getSum(){
		int Sum=0;
		for(int i=0; i<numberOfRows; i++){
			Sum+=Integer.parseInt(ORNData[i][4]);
		}
		return Sum;
	}
	public int updatePro(){
	
	Statement statement = null;
	ResultSet rs = null;
	ResultSetMetaData rsMetaData;
		try {
			
			// System.out.println("資料庫連結成功");
			statement = con.createStatement();
		} catch (SQLException sqlException) {// 資料庫操作發生錯誤
			sqlException.printStackTrace();
		}
		
	int isUpdate=0;
	
	//0* 先確認要出貨的商品是否為組合物
	int[] isCom = new int[numberOfRows];
	for(int i=0 ;i<numberOfRows;i++){
		try{

			rs = statement.executeQuery("Select ProdIsCom From Prod where ProdModel='" + ORNData[i][1] + "' ");
			if (rs.next()) {
				isCom[i] = Integer.parseInt(rs.getObject(1).toString()); // 將符合的客戶名稱放進確認變數裡
				//System.out.println(ORNData[i][0]+": " + isCom[i]);
			}
		}catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	    }
	}
	
	//1*更新新增的產品的產品序號後面的出貨單號
	for(int i=0 ;i<numberOfRows;i++){
		//proSNMin=new String[numberOfRows][Integer.parseInt(ORNData[i][2])];
		if(isCom[i]==0){		//一般產品更新ProdSN
			try{
		        int Qua=Integer.parseInt(ORNData[i][2]);	//用於存放出貨產品的數量
		        System.out.println("---"+ORNData[i][1]+": "+ORNData[i][2]+"-"+Qua);
		    
		        	isUpdate += statement.executeUpdate("UPDATE ProdSN SET SM_Num='"+SM_Num+"' WHERE ProdModel='"+ORNData[i][1]+"' AND SM_Num='0' AND CC_Num='0' LIMIT "+Qua+" ");
		        System.out.println("---------------");
		        System.out.println("isUpdate1-1: "+isUpdate);
		        //isUpdate=0;
			  }catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }
		}else{			//組合產品更新CNSN
			try{
		        int Qua=Integer.parseInt(ORNData[i][2]);	//用於存放出貨產品的數量
		        System.out.println("---"+ORNData[i][1]+": "+ORNData[i][2]+"-"+Qua);
		    
		        	isUpdate += statement.executeUpdate("UPDATE CNSN SET CNSN_SMN='"+SM_Num+"' WHERE CNSN_Model='"+ORNData[i][1]+"' AND CNSN_SMN='0' LIMIT "+Qua+" ");
		        System.out.println("---------------");
		        System.out.println("isUpdate1-2: "+isUpdate);
		        //isUpdate=0;
		        
				
			  }catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }
		}
	}
	//1*更新新增的產品的產品序號後面的出貨單號--結束
	
	//2*更新出貨的商品的庫存量
	int isUpdate2=0;
	int[][] proStock= new int[numberOfRows][2];
	for(int i=0 ;i<numberOfRows;i++){
		//proSNMin=new String[numberOfRows][Integer.parseInt(ORNData[i][2])];
			try{
					//2*2 先取出出貨的商品的
					
					//System.out.println("資料庫連結成功"); 
					System.out.println("---------------");
					statement = con.createStatement();
					rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel='"+ORNData[i][1]+"' ");
					while(rs.next()){
						proStock[i][0]=Integer.parseInt(rs.getString("ProdNowInve"));
						proStock[i][1]=Integer.parseInt(rs.getString("ProdOrderReqQuan"));
						System.out.println("--"+ORNData[i][1]+"-舊庫存"+proStock[i][0]+"-舊訂需"+proStock[i][1]);
					};  //計算資料有幾筆
					
			        int newNI=proStock[i][0]-Integer.parseInt(ORNData[i][2]);	//計算新的庫存
			        int newOR=proStock[i][1]-Integer.parseInt(ORNData[i][2]);	//計算新的訂須
			        System.out.println("---"+ORNData[i][1]+": 新庫存"+newNI+"- 新訂需"+newOR);
			     
			        	isUpdate2 += statement.executeUpdate("UPDATE Prod SET ProdNowInve='"+newNI+"',ProdOrderReqQuan='"+newOR+"' WHERE ProdModel='"+ORNData[i][1]+"' ");
			       
			        System.out.println("---------------");
			        System.out.println("isUpdate2: "+isUpdate2);
			        //isUpdate=0;
			        
				
				  }catch(SQLException sqlException){//資料庫操作發生錯誤
		        sqlException.printStackTrace();
		      }
	}
	
	
	//2*更新出貨的商品的庫存量--結束
	
		int sumQua=0;
		for(int i=0; i<numberOfRows; i++){
			sumQua+=Integer.parseInt(ORNData[i][2]);
		}
		//System.out.println("numberOfRows: "+numberOfRows);
		if(isUpdate==sumQua){
			if(isUpdate2==numberOfRows){
				//System.out.println("ok");
				return 1;
			}else {return 0; }
			
		}else{
			//System.out.println("no");
			return 0;
		}
		
	}
	public int goAdd(){
		System.out.println("-------goAdd--------");
		System.out.println("-------goAdd--------");
		int isUpdate=0;
		try{
			
			Statement statement;
			ResultSet rs = null;
			
			//1* 把新增的出貨單資訊插入SM
			
			//System.out.println("連接成功2");
			statement = con.createStatement();
			isUpdate += statement.executeUpdate("INSERT INTO SM(SM_Num,SM_ORNum,SM_CTName,SM_Date,SM_Addr,"
					+ "SM_SMeth,SM_BusiTax,SM_TPrice) "
					+ "VALUES ('"+SM_Num+"','"+OR_Num+"', '"+CTName+"', '"+SMDate+"', '"+ctAddr+"', '"+passway+"', '"+interest+"', '"+SellTotal+"')");
			//pk出貨單號SM_Num：fk客戶名稱SM_CTName、出貨日期 SM_Date、送貨住址SM_Addr、出貨方式SM_SMeth、
			//營業稅方式SM_BusiTax、總價SM_TPrice
			System.out.println("isUpdate1: "+isUpdate);
			
			//2* 更新訂單的狀態
			if(isUpdate==1){
				
				//System.out.println("連接成功2");
				statement = con.createStatement();
				isUpdate += statement.executeUpdate("UPDATE ORN SET OR_check='3' "
						+ "WHERE OR_Num ='"+OR_Num+"' ");
			}
			System.out.println("isUpdate2: "+isUpdate);
			//2* 更新訂單的狀態
			
			//3* 把新增的出貨單資訊插入SMM
			if(isUpdate==2){
				//isUpdate=0;
				for(int i=0 ;i<numberOfRows;i++){
				
				//System.out.println("連接成功2");
				statement = con.createStatement();
				isUpdate += statement.executeUpdate("INSERT INTO SMM(SM_Num,SM_ProdModel,SM_Quan)"
						+ "VALUES ('"+SM_Num+"', '"+ORNData[i][1]+"', '"+ORNData[i][2]+"');");
				}
			}
			System.out.println("isUpdate3: "+isUpdate);
			
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		int checkUpdate=numberOfRows+2;
		if(isUpdate==checkUpdate){
			//System.out.println("OK");
			return 1;
		}else{
			return 0;
		}
	}

	public boolean screenSave(String path) throws Exception {
		
	Robot robot = new Robot();
	int xpoint=contentPane.getLocationOnScreen().x; //取得視窗在任何地方時的X值
	int ypoint=contentPane.getLocationOnScreen().y;	//取得視窗在任何地方時的Y值
	int width=contentPane.getBounds().width;		//取得視窗的寬度
	int height=contentPane.getBounds().height-62;	////取得視窗的寬度並 減去最下方不要截圖的部分的高度
	boolean checkPrint = false;
	//System.out.println(xpoint);
	//System.out.println(ypoint);
	Rectangle rect = new Rectangle(xpoint,ypoint,width,height);	//這裡設定視窗x,y的起始值和擷取的視窗長和寬大小
	BufferedImage image = robot.createScreenCapture(rect);
	File F=new File(path);
	//System.out.println("--"+F.exists());
	if(F.exists()==false){
		JOptionPane.showMessageDialog(PreviewSM.this, "請先到 D槽(D:/HHSystem)裡新增'ShipmentPapers'資料夾","無出貨單存放資料夾",JOptionPane.INFORMATION_MESSAGE);		
	}else{
		F=new File("D:HHSystem/ShipmentPapers/"+SM_Num+".jpg");
		checkPrint=ImageIO.write(image, "jpg",F);
	}
	//System.out.println(checkPrint);
	return checkPrint;
	}
}


