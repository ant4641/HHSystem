package HHSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NewPurchase extends JFrame {

	private JPanel contentPane;
	static int pronum = 0;
	static int numberOfRows=0;
	static int numberOfColumns=0;
	JLabel srAddr = new JLabel("廠商地址："),srTel = new JLabel("廠商電話："),srFax = new JLabel("廠商傳真：");
	Connection con =null;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	private JTextField AttnName,HS_HandName;
	private JTextField[] lblNewLabel=new JTextField[10],lblNewLabel_1=new JTextField[10],lblNewLabel_2=new JTextField[10]
			,lblNewLabel_3=new JTextField[10],lblNewLabel_4=new JTextField[10];
	private JTextField textField;
	private JTextField textField_1,textField_2,textField_3,textField_4;
	private JTextField PO_Remark_T;
	private JTextField PO_GetDate_T;
	private String []names;
	private JTextField PayCond_T,PO_Curr_T;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPurchase frame = new NewPurchase(null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//用於產生新的採購單編號之函式
	public String getPur_NO(final String URL,final String username, final String password){
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		String strDate = sdFormat.format(d);	//先以今天的日期當做採購單編號
		numberOfRows=0;
		int num = 1;
		try {		//把剛產出新的採購單編號去和DB裡已有的做比對，有的話要加數字
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT PO_Num FROM Purchase Where PO_Num LIKE '%"+strDate+"%'ORDER BY PO_Num");
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
			if(numberOfRows!=0){	//如果編號已存在，就取出當天裡最大的編號
				names = new String[numberOfRows] ;
				int count = 0;
				rs = statement.executeQuery("SELECT PO_Num FROM Purchase Where PO_Num LIKE '%"+strDate+"%'ORDER BY PO_Num");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	  names[count] = rs.getObject(i).toString();	
			       }  
			      count++;
			}
			String strnum = names[count-1].substring(8);		//取出最大編號後要取得日期8碼後得排序號
			num = Integer.parseInt(strnum);			//將排序號轉成數字
			num++;									//將排序號+1
			String text = String.format("%03d", num);//在排序號前面加3個0，做為新的排序號
			strDate = strDate+text;					//將一開始產生的採購單編號(同天產生的)，加上新的排序號，成為新的採購單編號
			}
			else{
				String text = String.format("%03d", num);	//如果一開始得採購單編號沒有重複，那就式當天的第一比採購單，排序號為1
				strDate = strDate+text;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strDate;
		
	}
	public String getDateTime(){
		//呼叫SimpleDateFormat物件，取得系統時間
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
		}
	/**
	 * Create the frame.
	 * @param conn 
	 */
	public NewPurchase(final Connection conn, final String URL,final String username, final String password) {
		super("新增採購單");
		setResizable(false);
		final NewPurchase clone = this;
		setFont(new Font("Dialog", Font.PLAIN, 16));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1015, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		
		Label busname = new Label("洪陞實業有限公司");
		busname.setFont(new Font("標楷體", Font.ITALIC, 24));
		busname.setBounds(776, 0, 206, 50);
		contentPane.add(busname);
		
		final String date =getDateTime();
		Label time = new Label(date);
		time.setFont(new Font("Dialog", Font.PLAIN, 20));
		time.setBounds(10, 7, 180, 43);
		contentPane.add(time);
		
		Label sr = new Label("廠商名稱：");
		sr.setFont(new Font("Dialog", Font.PLAIN, 20));
		sr.setBounds(10, 49, 99, 43);
		contentPane.add(sr);
		
		final JComboBox srName = new JComboBox();
		srName.addItem("---請選擇廠商---");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				//從DB取得所有的廠商名稱
				statement = con.createStatement();
				rs = statement.executeQuery("SELECT SRName FROM SR");
				while(rs.next()){	//每取出一個廠商名稱就增加進下拉式選單裡面
					srName.addItem(rs.getString("SRName"));
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		srName.setBounds(115, 59, 200, 33);
		contentPane.add(srName);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent ie) {
		    	  try {
		    		 //當選好廠商名稱後，會去DB撈出廠商的地址電話和傳真顯示於名稱下方
					statement = con.createStatement();
					rs = statement.executeQuery("SELECT * FROM SR where SRName = '"+srName.getSelectedItem()+"'");
					while(rs.next()){
						srAddr.setText("廠商地址："+rs.getString("SRAddr"));
						srTel.setText("廠商電話："+rs.getString("SRPhone"));
						srFax.setText("廠商傳真："+rs.getString("SRFax"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		      }
		    };
		srName.addItemListener(itemListener);
	
		srAddr.setFont(new Font("Dialog", Font.PLAIN, 20));
		srAddr.setBounds(12, 98, 403, 30);
		contentPane.add(srAddr);
			
		srTel.setFont(new Font("Dialog", Font.PLAIN, 20));
		srTel.setBounds(12, 138, 221, 38);
		contentPane.add(srTel);
		
		srFax.setFont(new Font("Dialog", Font.PLAIN, 20));
		srFax.setBounds(243, 138, 221, 38);
		contentPane.add(srFax);
		
		JLabel ATTN = new JLabel("ATTN：");
		ATTN.setFont(new Font("Dialog", Font.PLAIN, 20));
		ATTN.setBounds(24, 189, 85, 25);
		contentPane.add(ATTN);
		
		AttnName = new JTextField();
		AttnName.setBounds(115, 186, 168, 25);
		contentPane.add(AttnName);
		AttnName.setColumns(10);
		
		JLabel orderNumber = new JLabel("\u63A1\u8CFC\u55AE\u865F\u78BC(P/O)\uFF1A"+getPur_NO(URL,username,password));
		orderNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		orderNumber.setBounds(327, 13, 363, 28);
		contentPane.add(orderNumber);
		
		final JLabel HSName = new JLabel("採購公司名稱：洪陞實業有限公司");
		HSName.setFont(new Font("Dialog", Font.PLAIN, 20));
		HSName.setBounds(547, 53, 332, 33);
		contentPane.add(HSName);
		
		final JLabel HSAddr = new JLabel("台中市北屯區遼寧路一段606巷30號12樓");
		HSAddr.setFont(new Font("Dialog", Font.PLAIN, 20));
		HSAddr.setBounds(547, 85, 384, 30);
		contentPane.add(HSAddr);
		
		final JLabel HSTel = new JLabel("採購公司電話：04-22478242");
		HSTel.setFont(new Font("Dialog", Font.PLAIN, 20));
		HSTel.setBounds(547, 119, 257, 29);
		contentPane.add(HSTel);
		
		final JLabel HSFax = new JLabel("採購公司傳真：04-22478697");
		HSFax.setFont(new Font("Dialog", Font.PLAIN, 20));
		HSFax.setBounds(547, 151, 257, 25);
		contentPane.add(HSFax);
		
		JLabel HS_Hand = new JLabel("經辦：");
		HS_Hand.setFont(new Font("Dialog", Font.PLAIN, 20));
		HS_Hand.setBounds(680, 186, 60, 22);
		contentPane.add(HS_Hand);
		
		HS_HandName = new JTextField();
		HS_HandName.setBounds(758, 188, 192, 21);
		contentPane.add(HS_HandName);
		HS_HandName.setColumns(10);
		
		JLabel ProName = new JLabel("產品名稱");
		ProName.setFont(new Font("新細明體", Font.PLAIN, 20));
		ProName.setBounds(60, 259, 87, 33);
		contentPane.add(ProName);
		
		JLabel ProModel = new JLabel("型號規格");
		ProModel.setFont(new Font("新細明體", Font.PLAIN, 20));
		ProModel.setBounds(233, 259, 80, 33);
		contentPane.add(ProModel);
		
		JLabel ProQuan = new JLabel("數量");
		ProQuan.setFont(new Font("新細明體", Font.PLAIN, 20));
		ProQuan.setBounds(408, 259, 69, 33);
		contentPane.add(ProQuan);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(36, 302, 127, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(200, 305, 156, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(401, 305, 60, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("增加商品");
		btnNewButton_1.setBounds(821, 273, 99, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int empty=0;
				for(int i =0 ; i<9 ;i++){		//確認前10商品已填好才可新增按鈕
					if("".equals(textField.getText().trim())){empty++;}
					if("".equals(textField_1.getText().trim())){empty++;}
					if("".equals(textField_2.getText().trim())){empty++;}

				}
				if(empty==0){		//確認前10商品已填好才可新增按鈕
					if(pronum<9){
						int b = pronum;
						lblNewLabel[b].setVisible(true);
						lblNewLabel_1[b].setVisible(true);
						lblNewLabel_2[b].setVisible(true);
						pronum++;
					}
				}else{
					JOptionPane.showMessageDialog(NewPurchase.this, "請先填完已有空格再新增", "警告", JOptionPane.INFORMATION_MESSAGE);
				}	
			}
		});
		
		for(int i=0;i<9;i++){
			lblNewLabel_1[i] = new JTextField();
			lblNewLabel_1[i].setBounds(200, 335+30*i, 156, 27);
			lblNewLabel_1[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1[i].setVisible(false);
			contentPane.add(lblNewLabel_1[i]);
		}
		for(int i=0;i<9;i++){
			lblNewLabel_2[i] = new JTextField();
			lblNewLabel_2[i].setBounds(401, 335+30*i, 60, 27);
			lblNewLabel_2[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2[i].setVisible(false);
			contentPane.add(lblNewLabel_2[i]);
		}
		for(int i=0;i<9;i++){
			lblNewLabel[i]= new JTextField();
			lblNewLabel[i].setBounds(36, 332+30*i, 127, 30);
			lblNewLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel[i].setVisible(false);
			contentPane.add(lblNewLabel[i]);
		}
		/*for(int i=0;i<9;i++){
			lblNewLabel_3[i] = new JTextField();
			lblNewLabel_3[i].setBounds(535, 333+30*i, 60, 27);
			lblNewLabel_3[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3[i].setVisible(false);
			contentPane.add(lblNewLabel_3[i]);
		}
		for(int i=0;i<9;i++){
			lblNewLabel_4[i]= new JTextField();
			lblNewLabel_4[i].setBounds(680, 335+30*i, 85, 27);
			lblNewLabel_4[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4[i].setVisible(false);
			contentPane.add(lblNewLabel_4[i]);
		}
		*/
		 
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//檢查是否有空值
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String[] lblNewLabel2=new String[10];
				String[] lblNewLabel2_1=new String[10];
				String[] lblNewLabel2_2=new String[10];
				//String[] lblNewLabel2_3=new String[10];
				//String[] lblNewLabel2_4=new String[10];
				String Attn,hsHandN,poGetDate,paycond,pocurr;
				//取得該填入欄位的值
				Attn = AttnName.getText();
				hsHandN = HS_HandName.getText();
				poGetDate = PO_GetDate_T.getText();
				paycond = PayCond_T.getText();
				pocurr = PO_Curr_T.getText();
				int empty=0;
				
				format.setLenient(false);
				
				lblNewLabel2[0]=textField.getText().trim();
				lblNewLabel2_1[0]=textField_1.getText().trim();
				lblNewLabel2_2[0]=textField_2.getText().trim();
				//lblNewLabel2_3[0]=textField_3.getText().trim();
				//lblNewLabel2_4[0]=textField_4.getText().trim();
				
				//把全部新增的產品資料放進STring陣列傳送
				
				for(int i=1;i<10;i++){
					if(lblNewLabel2[i]!=""&&lblNewLabel2_1[i]!=""){
					lblNewLabel2[i]=lblNewLabel[i-1].getText().trim();
					lblNewLabel2_1[i]=lblNewLabel_1[i-1].getText().trim();
					lblNewLabel2_2[i]=lblNewLabel_2[i-1].getText().trim();
					//lblNewLabel2_3[i]=lblNewLabel_3[i-1].getText().trim();
					//lblNewLabel2_4[i]=lblNewLabel_4[i-1].getText().trim();
					}

				}
				for(int i=0;i<10;i++){
					System.out.print(lblNewLabel2[i]+"\t");
					System.out.print(lblNewLabel2_1[i]+"\t");
					System.out.print(lblNewLabel2_2[i]+"\t");
					//System.out.print(lblNewLabel2_3[i]+"\t");
					//System.out.println(lblNewLabel2_4[i]);
				}
				String SN=(String) srName.getSelectedItem();
				if(SN.equals("---請選擇廠商---")){
					empty++;}
				try{
					format.parse(poGetDate);
				if("".equals(Attn.toString().trim())){empty++;}
				if("".equals(hsHandN.toString().trim())){empty++;}
				if("".equals(poGetDate.toString().trim())){empty++;}
				if("".equals(paycond.toString().trim())){empty++;}
				if("".equals(pocurr.toString().trim())){empty++;}
				//沒有空值，才執行傳送給預覽畫面
				if(empty ==0){
							String [] arr = {getDateTime(),getPur_NO(URL,username,password),(String) srName.getSelectedItem(),
									srAddr.getText(),srTel.getText(),srFax.getText()};
							
							previewPurchase PN = new previewPurchase(con,
									clone,arr,Attn,hsHandN,poGetDate,PO_Remark_T.getText(),
									lblNewLabel2,lblNewLabel2_1,lblNewLabel2_2,paycond,pocurr,URL,username,password);
							PN.setAlwaysOnTop(true); 
							PN.requestFocus();  
							PN.setVisible(true);
							dispose();
						
				}else{
					JOptionPane.showMessageDialog(NewPurchase.this, "ATT、交貨日期、經辦、付款條件、幣別不可為空值 \n 或廠商不可沒選", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(NewPurchase.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
				n.printStackTrace();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(NewPurchase.this, "日期輸入錯誤，請輸入如1996/07/05", "警告", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}

			}
		});
		btnNewButton.setBounds(833, 634, 87, 23);
		contentPane.add(btnNewButton);
		
		Label PO_Remark = new Label("\u63A1\u8CFC\u55AE\u5099\u8A3B\uFF1A");
		PO_Remark.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_Remark.setBounds(24, 632, 123, 25);
		contentPane.add(PO_Remark);
		
		PO_Remark_T = new JTextField();
		PO_Remark_T.setBounds(153, 632, 573, 25);
		contentPane.add(PO_Remark_T);
		PO_Remark_T.setColumns(10);
		
		Label PO_GetDate = new Label("交貨日期：");
		PO_GetDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_GetDate.setBounds(311, 185, 104, 25);
		contentPane.add(PO_GetDate);
		
		PO_GetDate_T = new JTextField();
		PO_GetDate_T.setBounds(437, 189, 192, 25);
		contentPane.add(PO_GetDate_T);
		PO_GetDate_T.setColumns(10);
		
		Label PayCond = new Label("付款條件：");
		PayCond.setFont(new Font("Dialog", Font.PLAIN, 20));
		PayCond.setBounds(24, 228, 110, 25);
		contentPane.add(PayCond);
		
		PayCond_T = new JTextField();
		PayCond_T.setBounds(135, 228, 180, 25);
		contentPane.add(PayCond_T);
		PayCond_T.setColumns(10);
		
		Label PO_Curr = new Label("幣別：");
		PO_Curr.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_Curr.setBounds(351, 228, 80, 25);
		contentPane.add(PO_Curr);
		
		PO_Curr_T = new JTextField();
		PO_Curr_T.setColumns(10);
		PO_Curr_T.setBounds(437, 227, 180, 25);
		contentPane.add(PO_Curr_T);
		
	}
}

