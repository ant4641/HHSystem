package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JButton;

public class testMMO extends JFrame {

	private JPanel contentPane;
	Connection con ;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	static int numberOfRows=0;
	static int numberOfColumns=0;
	private String [] CTData;
	private Object[][]a,b;
	private int sum = 0;
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
					testMMO frame = new testMMO(null,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}///不會有主程式
	public void getCTData(String name){//至資料庫讀取資料
		numberOfRows =0;
		try {
			//cc=DriverManager.getConnection(url,username,password);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT CTTaxID,CTPhone,CTFax,CTAddr FROM CT Where CTName = '"+name+"'");
			//MMO.MMO_SAcco_End
			rsMetaData = rs.getMetaData();//取得資料集
			numberOfColumns = rsMetaData.getColumnCount();
			CTData = new String[numberOfColumns] ;
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
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
	public void getSMMD(String name){//連接資料庫取資料
		numberOfRows =0;
		try {
			//cc=DriverManager.getConnection(url,username,password);
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			//MMO.MMO_SAcco_End
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
		    b=new Object[numberOfRows][numberOfColumns];
		    System.out.println();	
			int order = 0;
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	 if(rs.getObject(i)==null){
			    		 b[order][i-1]="";
			    	 }else{
			    		 b[order][i-1]=rs.getObject(i);	
			    	 }
				     		  	
			       }
			      order++;
			 }
			
			a = new Object[numberOfRows+1][7];//存入另一個陣列
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
	/**
	 * Create the frame.
	 * @param password 
	 * @param username 
	 * @param url 
	 */
	public testMMO(Connection conn,final String[] Data,final String URL,final String UN,final String PW) {//設置視窗
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		con=conn;
		url = URL;
		username = UN;
		password = PW;
		setBounds(100, 100, 916, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MMO_Num = new JLabel("請款單號碼："+Data[0]);
		MMO_Num.setFont(new Font("新細明體", Font.PLAIN, 20));
		MMO_Num.setBounds(262, 12, 292, 39);
		contentPane.add(MMO_Num);
		
		JLabel busname = new JLabel("洪陞實業有限公司");
		busname.setFont(new Font("標楷體", Font.ITALIC, 36));
		busname.setBounds(583, 1, 302, 50);
		contentPane.add(busname);
		getCTData(Data[4]);
		JLabel CTName = new JLabel("客戶名稱："+Data[4]);
		CTName.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTName.setBounds(51, 60, 292, 39);
		contentPane.add(CTName);
		
		JLabel CTTaxID = new JLabel("統一編號："+CTData[0]);
		CTTaxID.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTTaxID.setBounds(51, 103, 252, 28);
		contentPane.add(CTTaxID);
		
		JLabel CTPhone = new JLabel("電話："+CTData[1]);
		CTPhone.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTPhone.setBounds(51, 135, 176, 34);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("傳真："+CTData[2]);
		CTFax.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTFax.setBounds(250, 139, 167, 26);
		contentPane.add(CTFax);
		
		JLabel label_4 = new JLabel("發票號碼："+Data[1]);
		label_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_4.setBounds(477, 183, 219, 28);
		contentPane.add(label_4);
		
		JLabel CTMMAddr = new JLabel("公司地址："+CTData[3]);
		CTMMAddr.setFont(new Font("新細明體", Font.PLAIN, 20));
		CTMMAddr.setBounds(51, 177, 394, 28);
		contentPane.add(CTMMAddr);
		
		JLabel MMO_SAcco = new JLabel("結帳日期："+Data[2]+"  到    "+Data[3]);
		MMO_SAcco.setFont(new Font("新細明體", Font.PLAIN, 20));
		MMO_SAcco.setBounds(51, 208, 394, 28);
		contentPane.add(MMO_SAcco);
		
		getSMMD(Data[4]);
		String[] cols={"購買單號","商品名稱","商品型號","數量","單價","小計","總計金額"};
		JTable table;
		
		table= new JTable(a,cols);
		table.setFont(new Font("新細明體", Font.PLAIN, 16));
		table.setEnabled(false);//表格直接?置為不可選擇
		table.setFillsViewportHeight(true);////是否要填滿整個panel
		TableColumn column;
		column=table.getColumnModel().getColumn(0);//欄
		column.setPreferredWidth(250);////設置列?
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

		JScrollPane SP=new JScrollPane(table);//表格視窗上下左右滾動
		SP.setBounds(36, 257, 598, 383);
		contentPane.add(SP);
		
		JLabel label = new JLabel("合計金額："+sum);
		label.setFont(new Font("新細明體", Font.PLAIN, 20));
		label.setBounds(648, 318, 250, 28);
		contentPane.add(label);
		
		JButton BackBtn= new JButton("返回上頁");
		BackBtn.setBounds(634, 643, 128, 39);
		BackBtn.setFont(new Font("標楷體", Font.PLAIN, 20));
		contentPane.add(BackBtn);
		BackBtn.addActionListener(new ActionListener(){//按鈕事件
			public void actionPerformed(ActionEvent a){
				dispose();
			}
		});
		JButton button = new JButton("已付款!");
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(772, 643, 113, 39);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("請款狀態："+Data[5]);
		label_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_1.setBounds(477, 71, 219, 28);
		contentPane.add(label_1);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){//按鈕事件
				if(Data[5].equals("未請款")){
					int isUpdate = 0;
					//Connection conn; 資料庫
					Statement statement;
						try {
							//System.out.println("連接成功");
							statement = conn.createStatement();//為了下sql指令
							try{
								
								int sum = 0;
								//cc=DriverManager.getConnection(url,username,password);
								Statement stmt = con.createStatement();
								rs = stmt.executeQuery("SELECT CT_PayCount FROM CT Where CTName = '"+Data[4]+"'");
								while(rs.next()){
								sum = Integer.parseInt(rs.getString("CT_PayCount"));
								}
								sum = sum+1;
								isUpdate = statement.executeUpdate("Update CT set CT_PayCount ='"+sum+"' Where CTName = '"+Data[4]+"'");
								isUpdate += statement.executeUpdate("Update SM set SM_Check ='1' Where SM_CTName = '"+Data[4]+"' AND MMO_Num = '"+Data[0]+"'");
								isUpdate += statement.executeUpdate("Update MMO set MMO_Check ='已請款' Where MMO_CTName = '"+Data[4]+"' AND MMO_Num = '"+Data[0]+"'");
								
							}catch(SQLException sqlException){
								sqlException.printStackTrace();
							}
							if(isUpdate>0){//顯示對話框訊息
								JOptionPane.showMessageDialog(testMMO.this, "修改請款單資料成功 !","修改成功",JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else{//顯示對話框訊息
								JOptionPane.showMessageDialog(testMMO.this, "修改請款單資料失敗 !","修改失敗",JOptionPane.WARNING_MESSAGE);
								int result=JOptionPane.showConfirmDialog(testMMO.this,
							               "確定要結束程式嗎?",
							               "確認訊息",
							               JOptionPane.YES_NO_OPTION,
							               JOptionPane.WARNING_MESSAGE);
							    if (result==JOptionPane.YES_OPTION) {System.exit(0);}//顯示對話框按鈕
							    
							}
						} catch (SQLException SQLe) {
							SQLe.printStackTrace();
						}
				}else{
					JOptionPane.showMessageDialog(testMMO.this, "此請款單已收過款","請款單狀態提醒",JOptionPane.INFORMATION_MESSAGE);
				}
			
			
			}
		});
	
	}
}
