package HHSystem;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class previewMMO extends JFrame {

	private JPanel contentPane;
	Connection cc =null;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	static int numberOfRows=0;
	static int numberOfColumns=0;
	private String [] CTData;
	private Object[][]a,b;
	private int sum = 0;
	private String []names;
	private String MMOCTName;
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
					previewMMO frame = new previewMMO(null,"","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getMMO_NO(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		String strDate = sdFormat.format(d);	//先以今天的日期當做請款單編號
		numberOfRows=0;
		int num = 1;
		try {			//把剛產出新的請款單編號去和DB裡已有的做比對，有的話要加數字
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT MMO_Num FROM MMO Where MMO_Num LIKE '%"+strDate+"%'ORDER BY MMO_Num");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			if(numberOfRows!=0){  //如果編號已存在，就取出當天裡最大的編號
				names = new String[numberOfRows] ;
				int count = 0;
				rs = statement.executeQuery("SELECT MMO_Num FROM MMO Where MMO_Num LIKE '%"+strDate+"%'ORDER BY MMO_Num");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	  names[count] = rs.getObject(i).toString();	
			       }  
			      count++;
			}
			String strnum = names[count-1].substring(12); //取出最大編號後要取得日期12碼後得排序號
			num = Integer.parseInt(strnum);					//將排序號轉成數字
			num++;											//將排序號+1
			String text = String.format("%03d", num);		//在排序號前面加3個0，做為新的排序號
			strDate = "MMO-"+strDate+text;					//將一開始產生的採購單編號(同天產生的)，加上新的排序號，成為新的採購單編號
			}
			else{
				String text = String.format("%03d", num);	//如果一開始得採購單編號沒有重複，那就式當天的第一比採購單，排序號為1
				strDate = "MMO-"+strDate+text;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strDate;
		
	}
	public void getCTD(String name){		//用於取出客戶的名稱、傳真、電話、地址、付款條件
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d = new Date();
		String strDate = sdFormat.format(d);
		numberOfRows =0;
		try {
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT CTName,CTTaxID,CTPhone,CTFax,CTAddr,CTPayCond FROM CT Where CTName = '"+name+"'");
			//MMO.MMO_SAcco_End
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			CTData = new String[numberOfColumns+1] ;
			while (rs.next()){
				for(int i=1; i<=numberOfColumns; i++)
				   {
					if(rs.getObject(i)==null){
						CTData[i-1] = "";
			    	 }else{
			    		 CTData[i-1]=rs.getObject(i).toString();	
			    	 }
				}
		  }  		
			rs = statement.executeQuery("SELECT MMO_SAcco_End FROM MMO Where MMO_CTName = '"+name+"'");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			if(numberOfRows!=0){
			rs = statement.executeQuery("SELECT MMO_SAcco_End FROM MMO Where MMO_CTName = '"+name+"'");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	  if(rs.getObject(i)== null){
			    		  CTData[6] = strDate;
			    		  break;
			    	  }else
			    		  CTData[6]=rs.getObject(i).toString();	
				   }
				}
			}else{
				CTData[6] = strDate;
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getSMMD(String name){		//取出出貨單裡的內容物
		numberOfRows =0;
		try {
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			//MMO.MMO_SAcco_End
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
		    while (rs.next()){						//計算有幾筆已出貨的商品
		      for(int i=1; i<=numberOfColumns; i++)
			   {
			     System.out.printf("%s\t",rs.getObject(i));			  	
		       }
		      System.out.println();	
		      numberOfRows++;
		     }
		    b=new Object[numberOfRows][numberOfColumns];		
		    System.out.println(numberOfRows);	
			int order = 0;
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	 if(rs.getObject(i)==null){		//將出貨的商品資料放進B陣列裡
			    		 b[order][i-1]="";
			    	 }else{
			    		 b[order][i-1]=rs.getObject(i);	
			    	 }
				     		  	
			       }
			      order++;
			 }
			a = new Object[numberOfRows+1][7];		
			for(int i=0;i<numberOfRows;i++){
				a[i][0] = b[i][2];
				a[i][1] = b[i][3];
				a[i][2] = b[i][1];
				a[i][3] = b[i][5];
				a[i][4] = b[i][6];
				int count = (Integer) a[i][3]* (Integer) a[i][4];
				a[i][5] = count;
				a[i][6] = "";
				sum = sum + count;
			}
			Object [] sumarr  = new Object[]{"","","","","","",sum};
			for(int i=0;i<7;i++)
			a[numberOfRows][i] = sumarr[i];
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public previewMMO(final Connection conn, final String name,final String URL,final String UN,final String PW) {
		setResizable(false);
		setTitle("\u8ACB\u6B3E\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cc=conn;
		MMOCTName = name;
		url = URL;
		username = UN;
		password = PW;
		getCTD(name);
		
		JLabel MMO_Num = new JLabel("請款單號碼："+getMMO_NO());
		MMO_Num.setFont(new Font("新細明體", Font.PLAIN, 20));
		MMO_Num.setBounds(262, 12, 292, 39);
		contentPane.add(MMO_Num);
		
		JLabel busname = new JLabel("洪陞實業有限公司");
		busname.setFont(new Font("標楷體", Font.ITALIC, 36));
		busname.setBounds(583, 1, 302, 50);
		contentPane.add(busname);
		
		JLabel CTName = new JLabel("客戶名稱："+CTData[0]);
		CTName.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTName.setBounds(51, 60, 292, 39);
		contentPane.add(CTName);
		
		JLabel CTTaxID = new JLabel("統一編號："+CTData[1]);
		CTTaxID.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTTaxID.setBounds(350, 65, 252, 28);
		contentPane.add(CTTaxID);
		
		JLabel CTPhone = new JLabel("電話："+CTData[2]);
		CTPhone.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTPhone.setBounds(49, 111, 176, 34);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("傳真："+CTData[3]);
		CTFax.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTFax.setBounds(350, 115, 167, 26);
		contentPane.add(CTFax);
		
		JLabel CTMMAddr = new JLabel("公司地址："+CTData[4]);
		CTMMAddr.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTMMAddr.setBounds(51, 155, 394, 28);
		contentPane.add(CTMMAddr);
		System.out.println(CTData[6]);
		int year = Integer.parseInt(CTData[6].substring(0, 4));
		int month = Integer.parseInt(CTData[6].substring(5, 7));
		int day = Integer.parseInt(CTData[6].substring(8));
		String md = "";
		switch(CTData[5]){
			case "當月30日":{
				if(month==3||month==5||month==7||month==8||month==10||month==12){
					if(day==30||day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						month = month-1;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else if(month==1){
					if(day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						System.out.println("OK");
						year = year-1;
						month = 12;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else{
					month = month-1;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				break;
			}
			case "次月結60天":{
				if(month!=1||month!=2){
				if(day==31){
					month = month -1;
					day = 1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
					break;
				}else{
					month = month-2;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				
			}else{
					year = year-1;
					if(month==1){
						if(day==31){
							month = month -1;
							day = 1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
							break;
						}else{
							month = month-2;
							day = day+1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						}
					}else{
							month = month-2;
							day = day+1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						}
					}
					break;
				}
			default :{
				if(month==3||month==5||month==7||month==8||month==10||month==12){
					if(day==30||day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						month = month-1;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else{
					month = month-1;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				break;
			}
		}
		final String MMO_SAcco_Start = md;
		JLabel MMO_SAcco = new JLabel("結帳日期："+MMO_SAcco_Start+"  到    "+CTData[6]);
		MMO_SAcco.setFont(new Font("新細明體", Font.PLAIN, 20));
		MMO_SAcco.setBounds(51, 193, 394, 28);
		contentPane.add(MMO_SAcco);
		
		getSMMD(name);
		String[] cols={"購買單號","商品名稱","商品型號","數量","單價","小計","總計金額"};
		JTable table;
		
		table= new JTable(a,cols);
		table.setFont(new Font("新細明體", Font.PLAIN, 16));
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		TableColumn column;
		column=table.getColumnModel().getColumn(0);
		column.setPreferredWidth(250);
		column=table.getColumnModel().getColumn(1);
		column.setPreferredWidth(250);
		column=table.getColumnModel().getColumn(2);
		column.setPreferredWidth(330);
		column=table.getColumnModel().getColumn(3);
		column.setPreferredWidth(70);
		column=table.getColumnModel().getColumn(4);
		column.setPreferredWidth(100);
		column=table.getColumnModel().getColumn(5);
		column.setPreferredWidth(150);
		column=table.getColumnModel().getColumn(6);
		column.setPreferredWidth(150);

		JScrollPane SP=new JScrollPane(table);
		SP.setBounds(51, 231, 598, 383);
		contentPane.add(SP);
		
		JLabel label = new JLabel("合計金額："+sum);
		label.setFont(new Font("新細明體", Font.PLAIN, 20));
		label.setBounds(635, 172, 250, 28);
		contentPane.add(label);
		int a = (int) (sum*0.05);
		a=(int)(sum*1.05);
		
		JLabel InvoNum_lb = new JLabel("發票號碼：");
		InvoNum_lb.setFont(new Font("新細明體", Font.PLAIN, 20));
		InvoNum_lb.setBounds(636, 116, 102, 28);
		contentPane.add(InvoNum_lb);
		
		final JTextField InvoNum_tf = new JTextField();
		InvoNum_tf.setBounds(741, 120, 130, 25);
		contentPane.add(InvoNum_tf);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.setBounds(772, 643, 99, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMMO nmmo=new NewMMO(cc,"SM_CTName","",URL,UN,PW);
				nmmo.setVisible(true);
				dispose();
			}
		});
		button.setBounds(663, 643, 99, 27);
		contentPane.add(button);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement statement;
				int isUpdate = 0;
				System.out.println(MMO_SAcco_Start);
				if(InvoNum_tf.getText().equals("")){
					JOptionPane.showMessageDialog(previewMMO.this, "發票號碼不可為空白","空值錯誤",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					try{
						if(screenSave("D:/HHSystem/MakeMoneyPapers/")==true){
							try {
								String mmonum = getMMO_NO();
								//System.out.println("連接成功");
								statement = cc.createStatement();
								try{
									isUpdate = statement.executeUpdate("INSERT into MMO(MMO_Num,MMO_InvoNum,MMO_SAcco_Start,MMO_SAcco_End,MMO_CTName)"
											+ "VALUES('"+mmonum+"','"+InvoNum_tf.getText()+"','"+MMO_SAcco_Start+"','"+CTData[6]+"','"+MMOCTName+"')");
									isUpdate += statement.executeUpdate("Update SM set MMO_Num = '"+mmonum+"' Where SM_CTName = '"+name+"' AND SM_check='0' ");
									
								}catch(SQLException sqlException){
									sqlException.printStackTrace();
								}
								if(isUpdate>0){
									JOptionPane.showMessageDialog(previewMMO.this, "請到 D:HHSystem/MakeMomeyPapers/裡確認截圖 ","新增請款單成功",JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}else{
									JOptionPane.showMessageDialog(previewMMO.this, "新增請款單資料失敗 !","新增失敗",JOptionPane.WARNING_MESSAGE);
									int result=JOptionPane.showConfirmDialog(previewMMO.this,
								               "確定要結束程式嗎?",
								               "確認訊息",
								               JOptionPane.YES_NO_OPTION,
								               JOptionPane.WARNING_MESSAGE);
								    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
								    
								}
							} catch (SQLException SQLe) {
								SQLe.printStackTrace();
							}

						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
			
				}
				
			}	
		});
	}
	
	public boolean screenSave(String path) throws Exception {
		
		Robot robot = new Robot();
		int xpoint=contentPane.getLocationOnScreen().x; //取得視窗在任何地方時的X值
		int ypoint=contentPane.getLocationOnScreen().y;	//取得視窗在任何地方時的Y值
		int width=contentPane.getBounds().width;		//取得視窗的寬度
		int height=contentPane.getBounds().height-83;	////取得視窗的寬度並 減去最下方不要截圖的部分的高度
		Rectangle rect = new Rectangle(xpoint,ypoint,width,height);	//這裡設定視窗x,y的起始值和擷取的視窗長和寬大小
		BufferedImage image = robot.createScreenCapture(rect);
		boolean checkPrint=false;
		File F=new File(path);
		//System.out.println("--"+F.exists());
		if(F.exists()==false){
			JOptionPane.showMessageDialog(previewMMO.this, "請先到 D槽(D:/HHSystem)裡新增'MakeMoneyPapers'資料夾","無出貨單存放資料夾",JOptionPane.INFORMATION_MESSAGE);		
		}else{
			F=new File("D:/HHSystem/MakeMoneyPapers/MMO"+getMMO_NO()+".jpg");
			checkPrint=ImageIO.write(image, "jpg",F);
		}
		System.out.println(checkPrint);
		
		return checkPrint;
		}
}
