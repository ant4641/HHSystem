package HHSystem;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class previewPurchase extends JFrame {
	
	private JPanel contentPane;
	Connection cc =null;	Statement stmt;	ResultSet rs;	ResultSetMetaData rsMetaData;
	private JTextField AttnName,HS_HandName;
	private JLabel[] lblNewLabel=new JLabel[10],lblNewLabel_1=new JLabel[10],lblNewLabel_2=new JLabel[10]
			,lblNewLabel_3=new JLabel[10],lblNewLabel_4=new JLabel[10];
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField PO_Remark_T;
	private JTextField PO_GetDate_T;
	private String []names;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	static String PurNum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewPurchase frame = new previewPurchase(null,"","","","","","",null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pocurr 
	 * @param paycond 
	 * @param password 
	 * @param username 
	 * @param uRL 
	 * @wbp.parser.constructor
	 */
	public previewPurchase(Connection conn,NewPurchase clone, final String[] arr, final String attn,final String hsHandN,final String poGetDate,final String text,
			final String[] lblNewLabel2,final String[] lblNewLabel2_1,final String[] lblNewLabel2_2,final String paycond,final String pocurr,final String URL,final String UN,final String PW) {
		super("預覽採購單");
		setResizable(false);
		final NewPurchase NOframe = clone;
		setFont(new Font("Dialog", Font.PLAIN, 16));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1015, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PurNum=arr[1];
		url=URL;
		username=UN;
		password=PW;
		cc=conn;
		
		Label time = new Label(arr[0]);
		time.setFont(new Font("Dialog", Font.PLAIN, 20));
		time.setBounds(10, 7, 168, 43);
		contentPane.add(time);
		
		JLabel orderNumber = new JLabel("\u63A1\u8CFC\u55AE\u865F\u78BC(P/O)\uFF1A"+arr[1]);
		orderNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
		orderNumber.setBounds(327, 13, 360, 28);
		contentPane.add(orderNumber);
		
		Label busname = new Label("洪陞實業有限公司");
		busname.setFont(new Font("標楷體", Font.ITALIC, 24));
		busname.setBounds(776, 0, 206, 50);
		contentPane.add(busname);
		
		Label sr = new Label(arr[2]);
		sr.setFont(new Font("Dialog", Font.PLAIN, 20));
		sr.setBounds(10, 49, 99, 43);
		contentPane.add(sr);
		
		JLabel srAddr = new JLabel(arr[3]);
		srAddr.setFont(new Font("Dialog", Font.PLAIN, 20));
		srAddr.setBounds(12, 98, 403, 30);
		contentPane.add(srAddr);
		
		JLabel srTel = new JLabel(arr[4]);	
		srTel.setFont(new Font("Dialog", Font.PLAIN, 20));
		srTel.setBounds(12, 138, 221, 38);
		contentPane.add(srTel);
		
		JLabel srFax = new JLabel(arr[5]);
		srFax.setFont(new Font("Dialog", Font.PLAIN, 20));
		srFax.setBounds(243, 138, 221, 38);
		contentPane.add(srFax);
		
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
		
		JLabel ATTN = new JLabel("ATTN："+attn);
		ATTN.setFont(new Font("Dialog", Font.PLAIN, 20));
		ATTN.setBounds(24, 189, 257, 25);
		contentPane.add(ATTN);
		
		JLabel HS_Hand = new JLabel("經辦："+hsHandN);
		HS_Hand.setFont(new Font("Dialog", Font.PLAIN, 20));
		HS_Hand.setBounds(680, 186, 221, 22);
		contentPane.add(HS_Hand);
		
		Label PO_GetDate = new Label("交貨日期："+poGetDate);
		PO_GetDate.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_GetDate.setBounds(311, 185, 302, 25);
		contentPane.add(PO_GetDate);
		
		Label PayCond = new Label("付款條件："+paycond);
		PayCond.setFont(new Font("Dialog", Font.PLAIN, 20));
		PayCond.setBounds(24, 228, 277, 25);
		contentPane.add(PayCond);
		
		Label PO_Curr = new Label("幣別："+pocurr);
		PO_Curr.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_Curr.setBounds(351, 228, 262, 25);
		contentPane.add(PO_Curr);
		
		Label PO_Remark = new Label("採購單備註："+text);
		PO_Remark.setFont(new Font("Dialog", Font.PLAIN, 20));
		PO_Remark.setBounds(36, 632, 577, 25);
		contentPane.add(PO_Remark);
		
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
		
		for(int i=0;i<10;i++){
			lblNewLabel[i]= new JLabel();
			lblNewLabel[i].setBounds(36, 302+30*i, 127, 30);
			lblNewLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblNewLabel[i]);
		}
		
		for(int i=0;i<10;i++){
			lblNewLabel_1[i] = new JLabel();
			lblNewLabel_1[i].setBounds(200, 305+30*i, 156, 27);
			lblNewLabel_1[i].setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblNewLabel_1[i]);
		}
		for(int i=0;i<10;i++){
			lblNewLabel_2[i] = new JLabel();
			lblNewLabel_2[i].setBounds(401, 305+30*i, 60, 27);
			lblNewLabel_2[i].setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblNewLabel_2[i]);
		}

			
			int procount=0;  //計算已放入預覽給使用者看的商品數
			int put=0;		 //名稱重複的，數量直接機加起來
			try{
			for(int i=0 ;i<10 ;i++){
				if((!lblNewLabel2[i].equals("")) && (!lblNewLabel2_1[i].equals(""))){
					for(int k=0 ;k<10 ;k++){
						if((lblNewLabel2[i].equals(lblNewLabel[k].getText())) && 
						   (lblNewLabel2_1[i].equals(lblNewLabel_1[k].getText())) ){
							int qq=Integer.parseInt(lblNewLabel_2[k].getText());
							qq+=Integer.parseInt(lblNewLabel2_2[i]);
							lblNewLabel_2[k].setText(""+qq);
							put=1;
						}
					}
					if(put!=1){
						lblNewLabel[procount].setText(lblNewLabel2[i]);
						lblNewLabel_1[procount].setText(lblNewLabel2_1[i]);
						lblNewLabel_2[procount].setText(lblNewLabel2_2[i]);
						procount++;
					}
					put=0;
				}
					 
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			JButton backEditor_Btn = new JButton("\u8FD4\u56DE\u7DE8\u8F2F");
			backEditor_Btn.setFont(new Font("標楷體", Font.PLAIN, 17));
			backEditor_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NOframe.setVisible(true);
					dispose();
				}
			});
			backEditor_Btn.setBounds(754, 673, 103, 41);
			contentPane.add(backEditor_Btn);

			JButton comfirmAdd_Btn = new JButton("\u78BA\u5B9A\u65B0\u589E");
			comfirmAdd_Btn.setFont(new Font("標楷體", Font.PLAIN, 17));
			comfirmAdd_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println(replace(poGetDate));

						int isUpdate = 0;
						try{
							if(screenSave("D:HHSystem/PurchasePapers/")==true){
								try {
									stmt = cc.createStatement();
									try{
										//新增一比採購單的資料進Purchase
										isUpdate = stmt.executeUpdate("INSERT into Purchase(PO_Num,PO_PurDate,PO_PayCond,PO_Hand,PO_Curr,PO_Check,PO_GetDate,PO_Remark,PO_Attn,PO_SRName)"
												+ "VALUES('"+arr[1]+"','"+replace(arr[0])+"','"+paycond+"','"+hsHandN+"','"+pocurr+"','0','"+replace(poGetDate)+"','"+text+"','"+attn+"','"+arr[2]+"')");
										//新增採購單裡預購買的資料進PurProd
										for(int i=0; i<lblNewLabel.length; i++){  
											if(!lblNewLabel[i].getText().equals("")){
												isUpdate = stmt.executeUpdate("INSERT into PurProd(PO_Num,PO_ProdModel,PO_PurQuan)VALUES('"+arr[1]+"','"+lblNewLabel_1[i].getText()+"','"+lblNewLabel_2[i].getText()+"')");
											}
										}
										//System.out.println(isUpdate);
										//接著更新欲購買商品的採購中數量和預計入庫日期
										for(int i=0; i<lblNewLabel.length; i++){  
										if(!lblNewLabel[i].getText().equals("")){
											int sum = 0;
											stmt = cc.createStatement();
											rs = stmt.executeQuery("SELECT ProdPurQuan FROM Prod Where ProdModel = '"+lblNewLabel_1[i].getText()+"'");
											while(rs.next()){
											sum = Integer.parseInt(lblNewLabel_2[i].getText())+Integer.parseInt(rs.getString("ProdPurQuan"));
											}
											isUpdate += stmt.executeUpdate("Update Prod set ProdPurQuan ='"+sum+"',ProdScheRecDate = '"+replace(poGetDate)+"'"
													+ "Where ProdModel = '"+lblNewLabel_1[i].getText()+"'");
										}
									}
									}catch(SQLException sqlException){
										sqlException.printStackTrace();
									}
									if(isUpdate>0){
										//System.out.println("noUpdate: "+isUpdate);
										JOptionPane.showMessageDialog(previewPurchase.this, "請到'D:HHSystem/PurchasePapers/'裡查看採購單","新增採購單成功",JOptionPane.INFORMATION_MESSAGE);
										dispose();
									}else{
										JOptionPane.showMessageDialog(previewPurchase.this, "新增採購單資料失敗 !","新增失敗",JOptionPane.WARNING_MESSAGE);
										int result=JOptionPane.showConfirmDialog(previewPurchase.this,
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
			});
			comfirmAdd_Btn.setBounds(879, 673, 103, 41);
			contentPane.add(comfirmAdd_Btn);

	}
	public previewPurchase(Object object, String string, String string2, String string3, String string4, String string5,
			String string6, Object object2, Object object3, Object object4) {

	}
	public String replace(String s)
    {
     if(s.equals(""))//如果傳入的字串為空的話，則回傳空字串
      return "";
     if(s.substring(0, 1).equals("年"))//如果讀出的字元等於要取代的字元，則將新的字元加上去
      return "/"+replace(s.substring(1));
     else if(s.substring(0, 1).equals("月"))//如果讀出的字元等於要取代的字元，則將新的字元加上去
         return "/"+replace(s.substring(1));
     else if(s.substring(0, 1).equals("日"))//如果讀出的字元等於要取代的字元，則將新的字元加上去
         return "/"+replace(s.substring(1));
     else//如果不等於的話，補回至原本的字串
      return s.substring(0, 1)+replace(s.substring(1));
    }
	
	public boolean screenSave(String path) throws Exception {
		
		Robot robot = new Robot();
		int xpoint=contentPane.getLocationOnScreen().x; //取得視窗在任何地方時的X值
		int ypoint=contentPane.getLocationOnScreen().y;	//取得視窗在任何地方時的Y值
		int width=contentPane.getBounds().width;		//取得視窗的寬度
		int height=contentPane.getBounds().height-79;	////取得視窗的寬度並 減去最下方不要截圖的部分的高度
		Rectangle rect = new Rectangle(xpoint,ypoint,width,height);	//這裡設定視窗x,y的起始值和擷取的視窗長和寬大小
		BufferedImage image = robot.createScreenCapture(rect);
		boolean checkPrint = false;
		File F=new File(path);
		//System.out.println("--"+F.exists());
		if(F.exists()==false){
			JOptionPane.showMessageDialog(previewPurchase.this, "請先到 D槽(D:/HHSystem)裡新增'PurchasePapers' 資料夾","無出貨單存放資料夾",JOptionPane.INFORMATION_MESSAGE);		
		}else{
			F=new File("D:/HHSystem/PurchasePapers/P"+PurNum+".jpg");
			checkPrint=ImageIO.write(image, "jpg",F);
			//System.out.println(checkPrint);
		}

		return checkPrint;
		}
}
