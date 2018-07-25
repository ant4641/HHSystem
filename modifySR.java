package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class modifySR extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTextField SRName;
	private JTextField SRNum;
	private JTextField SRPhone;
	private JTextField SRAddr;
	private JTextField SRFax;
	private JTextField SRTaxID;
	private JTextField SRPIC;
	private JTextField SRFactPhone;
	private JTextField SRFactFax;
	private JTextField SRBusiPhone;
	private JTextField SRDLPhone;
	private JTextField SRNetAddr;
	private JTextField SREmail;
	private String str;
	//private String EID = "20165423";
	JCheckBox chckbxNewCheckBox = new JCheckBox("製造、加工業");
	JCheckBox checkBox = new JCheckBox("買賣業");
	JCheckBox checkBox_1 = new JCheckBox("勞務、服務業");
	JCheckBox checkBox_2 = new JCheckBox("營繕、建築業");
	JCheckBox checkBox_3 = new JCheckBox("非營利事業");
	//資料庫JDBC Driver名稱
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	private JTextField SRInvoAddr;
	private JTextField SRFactAddr;
	static String column;
	static String condition;
	static String []names=new String[1];
	static Connection con;
	static Statement statement;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		 
	   //   System.out.println("資料庫連結成功"); 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int numberOfColumns=0;
					statement = con.createStatement();
					ResultSet rs = statement.executeQuery("SELECT * FROM SR Where SRA_Num = 1");
					final ResultSetMetaData rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					Object[] data = new Object[numberOfColumns];
				    while (rs.next()){
					      for(int i=1; i<=numberOfColumns; i++)
						   {
						     data[i-1]= rs.getObject(i);			  	
					       }
					 }
				    for(int i=1; i<=numberOfColumns; i++)
					   {
					     System.out.println("data["+(i-1)+"]:"+data[i-1].toString());			  	
				       }
					modifySR frame = new modifySR(null,data,1,"","","");//NewSRData(String ID)
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param pW 
	 * @param uN 
	 * @param uRL2 
	 */
	public modifySR(final Connection conn, final Object data[],final int EST,final String URL,final String UN,final String PW) {
		setResizable(false);
		con=conn;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		url = URL;
		username = UN;
		password = PW;
		JLabel label = new JLabel("洪陞實業有限公司");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(581, 10, 165, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u4F9B\u61C9\u5546\u57FA\u672C\u8CC7\u6599");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 37));
		label_1.setBounds(191, 30, 349, 40);
		contentPane.add(label_1);
		
		JLabel Name1 = new JLabel("供應商名稱：");
		Name1.setFont(new Font("標楷體", Font.PLAIN, 18));
		Name1.setBounds(30, 122, 121, 23);
		contentPane.add(Name1);
		
		SRName = new JTextField();
		SRName.setText(data[1].toString());
		SRName.setBounds(135, 125, 96, 21);
		contentPane.add(SRName);
		SRName.setColumns(10);
		
		JLabel Num = new JLabel("供應商編號：");
		Num.setFont(new Font("標楷體", Font.PLAIN, 18));
		Num.setBounds(241, 122, 108, 23);
		contentPane.add(Num);
		
		SRNum = new JTextField();
		SRNum.setText(data[0].toString());
		SRNum.setBounds(382, 125, 96, 21);
		contentPane.add(SRNum);
		SRNum.setColumns(10);
		
		JLabel Phone = new JLabel("供應商電話：");
		Phone.setFont(new Font("標楷體", Font.PLAIN, 18));
		Phone.setBounds(488, 122, 108, 23);
		contentPane.add(Phone);
		
		SRPhone = new JTextField();
		SRPhone.setText(data[4].toString());
		SRPhone.setColumns(10);
		SRPhone.setBounds(622, 125, 96, 21);
		contentPane.add(SRPhone);
		
		JLabel Addr = new JLabel("供應商地址：");
		Addr.setFont(new Font("標楷體", Font.PLAIN, 18));
		Addr.setBounds(30, 254, 108, 23);
		contentPane.add(Addr);
		
		SRAddr = new JTextField();
		SRAddr.setText(data[3].toString());
		SRAddr.setColumns(10);
		SRAddr.setBounds(171, 256, 547, 21);
		contentPane.add(SRAddr);
		
		JLabel Fax = new JLabel("供應商傳真：");
		Fax.setFont(new Font("標楷體", Font.PLAIN, 18));
		Fax.setBounds(30, 155, 108, 23);
		contentPane.add(Fax);
		
		SRFax = new JTextField();
		SRFax.setText(data[5].toString());
		SRFax.setColumns(10);
		SRFax.setBounds(135, 158, 96, 21);
		contentPane.add(SRFax);
		
		JLabel TaxID = new JLabel("供應商統一編號：");
		TaxID.setFont(new Font("標楷體", Font.PLAIN, 18));
		TaxID.setBounds(241, 155, 154, 23);
		contentPane.add(TaxID);
		
		SRTaxID = new JTextField();
		SRTaxID.setText(data[6].toString());
		SRTaxID.setColumns(10);
		SRTaxID.setBounds(382, 158, 96, 21);
		contentPane.add(SRTaxID);
		
		JLabel PIC = new JLabel("供應商負責人：");
		PIC.setFont(new Font("標楷體", Font.PLAIN, 18));
		PIC.setBounds(488, 155, 134, 23);
		contentPane.add(PIC);
		
		SRPIC = new JTextField();
		SRPIC.setText(data[8].toString());
		SRPIC.setColumns(10);
		SRPIC.setBounds(622, 158, 96, 21);
		contentPane.add(SRPIC);
		
		JLabel FactPhone = new JLabel("供應商工廠電話：");
		FactPhone.setFont(new Font("標楷體", Font.PLAIN, 18));
		FactPhone.setBounds(30, 188, 144, 23);
		contentPane.add(FactPhone);
		
		SRFactPhone = new JTextField();
		SRFactPhone.setText(data[11].toString());
		SRFactPhone.setColumns(10);
		SRFactPhone.setBounds(171, 191, 165, 21);
		contentPane.add(SRFactPhone);
		
		JLabel FactFax = new JLabel("供應商工廠傳真：");
		FactFax.setFont(new Font("標楷體", Font.PLAIN, 18));
		FactFax.setBounds(369, 188, 144, 23);
		contentPane.add(FactFax);
		
		SRFactFax = new JTextField();
		SRFactFax.setText(data[12].toString());
		SRFactFax.setColumns(10);
		SRFactFax.setBounds(510, 191, 166, 21);
		contentPane.add(SRFactFax);
		
		JLabel BusiPhone = new JLabel("供應商業務電話：");
		BusiPhone.setFont(new Font("標楷體", Font.PLAIN, 18));
		BusiPhone.setBounds(30, 221, 144, 23);
		contentPane.add(BusiPhone);
		
		SRBusiPhone = new JTextField();
		SRBusiPhone.setText(data[13].toString());
		SRBusiPhone.setColumns(10);
		SRBusiPhone.setBounds(171, 224, 165, 21);
		contentPane.add(SRBusiPhone);
		
		JLabel DLPhone = new JLabel("供應商專線電話：");
		DLPhone.setFont(new Font("標楷體", Font.PLAIN, 18));
		DLPhone.setBounds(369, 221, 144, 23);
		contentPane.add(DLPhone);
		
		SRDLPhone = new JTextField();
		SRDLPhone.setText(data[14].toString());
		SRDLPhone.setColumns(10);
		SRDLPhone.setBounds(510, 224, 165, 21);
		contentPane.add(SRDLPhone);
		
		JLabel NetAddr = new JLabel("供應商網址：");
		NetAddr.setFont(new Font("標楷體", Font.PLAIN, 18));
		NetAddr.setBounds(30, 347, 108, 23);
		contentPane.add(NetAddr);
		
		SRNetAddr = new JTextField();
		SRNetAddr.setText(data[15].toString());
		SRNetAddr.setColumns(10);
		SRNetAddr.setBounds(177, 349, 541, 21);
		contentPane.add(SRNetAddr);
		
		SREmail = new JTextField();
		SREmail.setText(data[16].toString());
		SREmail.setColumns(10);
		SREmail.setBounds(177, 382, 541, 21);
		contentPane.add(SREmail);
		
		JLabel Email = new JLabel("供應商信箱：");
		Email.setFont(new Font("標楷體", Font.PLAIN, 18));
		Email.setBounds(30, 380, 108, 23);
		contentPane.add(Email);
		//將選項設為群組，變成只能選單一一個選項
		ButtonGroup checkbox = new ButtonGroup();
		checkbox.add(chckbxNewCheckBox);
		checkbox.add(checkBox);
		checkbox.add(checkBox_1);
		checkbox.add(checkBox_2);
		checkbox.add(checkBox_3);
		
		String Rind="買賣業";//先預設為買賣業
		if(Rind.equals("製造、加工業")){
			chckbxNewCheckBox.setSelected(true);
		}
		if(Rind.equals("買賣業")){
			checkBox.setSelected(true);
		}
		if(Rind.equals("勞務、服務業")){
			checkBox_1.setSelected(true);
		}
		if(Rind.equals("營繕、建築業")){
			checkBox_2.setSelected(true);
		}
		if(Rind.equals("非營利事業")){
			checkBox_3.setSelected(true);
		}
		
		chckbxNewCheckBox.setFont(new Font("標楷體", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(117, 70, 134, 23);
		contentPane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(this);
		
		JLabel IndCate = new JLabel("產業別：");
		IndCate.setFont(new Font("標楷體", Font.PLAIN, 18));
		IndCate.setBounds(30, 68, 81, 23);
		contentPane.add(IndCate);
		
		
		checkBox.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox.setBounds(346, 70, 144, 23);
		contentPane.add(checkBox);
		checkBox.addItemListener(this);
		
		checkBox_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox_1.setBounds(584, 70, 134, 23);
		contentPane.add(checkBox_1);
		checkBox_1.addItemListener(this);
		
		checkBox_2.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox_2.setBounds(117, 93, 134, 23);
		contentPane.add(checkBox_2);
		checkBox_2.addItemListener(this);
		
		checkBox_3.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox_3.setBounds(346, 95, 134, 23);
		contentPane.add(checkBox_3);
		checkBox_3.addItemListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(checkBox);
		group.add(checkBox_1);
		group.add(checkBox_2);
		group.add(checkBox_3);
		group.add(chckbxNewCheckBox);
		checkBox.addItemListener(this);
		checkBox_1.addItemListener(this);
		checkBox_2.addItemListener(this);
		checkBox_3.addItemListener(this);
		chckbxNewCheckBox.addItemListener(this);
		
		
		final modifySR clone =this;
		final String[] SR=new String[15];
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   Statement statement;
				   ResultSet rs;
				   ResultSetMetaData rsMetaData;
				//檢查是否有空值
				String SRName2,SRNum2,SRAddr2,SRPhone2,SRFax2,SRTaxID2,SRPIC2,SRInvoAddr2,SRFactAddr2
				,SRFactPhone2,SRFactFax2,SRBusiPhone2,SRDLPhone2,SRNetAddr2,SREmail2;
				SRName2=SRName.getText();
				SRNum2=SRNum.getText();
				SRAddr2=SRAddr.getText();
				SRPhone2=SRPhone.getText();
				SRFax2=SRFax.getText();
				SRTaxID2=SRTaxID.getText();
				SRPIC2=SRPIC.getText();
				SRInvoAddr2=SRInvoAddr.getText();
				SRFactAddr2=SRFactAddr.getText();
				SRFactPhone2=SRFactPhone.getText();
				SRFactFax2=SRFactFax.getText();
				SRBusiPhone2=SRBusiPhone.getText();
				SRDLPhone2=SRDLPhone.getText();
				SRNetAddr2=SRNetAddr.getText();
				SREmail2=SREmail.getText();
				int empty=0;
				
				//把全部新增的產品資料放進STring陣列傳送
				SR[0]=SRName.getText().trim();
				SR[1]=SRNum.getText().trim();
				SR[2]=SRAddr.getText().trim();
				SR[3]=SRPhone.getText().trim();
				SR[4]=SRFax.getText().trim();
				SR[5]=SRTaxID.getText().trim();
				SR[6]=SRPIC.getText().trim();
				SR[7]=SRInvoAddr.getText().trim();
				SR[8]=SRFactAddr.getText().trim();
				SR[9]=SRFactPhone.getText().trim();
				SR[10]=SRFactFax.getText().trim();
				SR[11]=SRBusiPhone.getText().trim();
				SR[12]=SRDLPhone.getText().trim();
				SR[13]=SRNetAddr.getText().trim();
				SR[14]=SREmail.getText().trim();
				
				try{
					if("".equals(SRName2.toString().trim())){empty++;}
					if("".equals(SRNum2.toString().trim())){empty++;}
					if("".equals(SRAddr2.toString().trim())){empty++;}
					if("".equals(SRPhone2.toString().trim())){empty++;}
					if("".equals(SRFax2.toString().trim())){empty++;}
					if("".equals(SRTaxID2.toString().trim())){empty++;}
					if("".equals(SRPIC2.toString().trim())){empty++;}
					if("".equals(SRInvoAddr2.toString().trim())){empty++;}	
					if("".equals(SRFactAddr2.toString().trim())){empty++;}
					if("".equals(SRFactPhone2.toString().trim())){empty++;}
					if("".equals(SRFactFax2.toString().trim())){empty++;}
					if("".equals(SRBusiPhone2.toString().trim())){empty++;}
					if("".equals(SRDLPhone2.toString().trim())){empty++;}
					if("".equals(SRNetAddr2.toString().trim())){empty++;}
					if("".equals(SREmail2.toString().trim())){empty++;}
					if(empty==0){
						/*int a=1;
						while(true){
							if(...)
							break;
						}
						int SRA_Num = 1;*/
						if(checkSR(SRName2,SRTaxID2)!=1){
							//int check=1;//資料沒重複check=1
								previewmodifySR PD =new previewmodifySR(conn,data,clone,SRName.getText(),SRNum.getText(),SRAddr.getText(),SRPhone.getText(),SRFax.getText(),SRTaxID.getText(),SRPIC.getText(),SRInvoAddr.getText(),SRFactAddr.getText(),SRFactPhone.getText(),SRFactFax.getText(),SRBusiPhone.getText()
										,SRDLPhone.getText(),SRNetAddr.getText(),SREmail.getText(),str,EST,data[1].toString(),URL,UN,PW);
								PD.setAlwaysOnTop(true); 
								PD.requestFocus();  
								PD.setVisible(true);
								dispose();
							}/*else{
								JOptionPane.showMessageDialog(null, "供應商名稱重複","新增錯誤",JOptionPane.WARNING_MESSAGE);
							}
						}*/else{
							JOptionPane.showMessageDialog(modifySR.this, "資料重複","新增錯誤",JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(modifySR.this, "資料不可為空值", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(modifySR.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		button.setFont(new Font("標楷體", Font.PLAIN, 18));
		button.setBounds(646, 425, 76, 40);
		contentPane.add(button);
		
		JLabel InvoAddr = new JLabel("供應商發票位址：");
		InvoAddr.setFont(new Font("標楷體", Font.PLAIN, 18));
		InvoAddr.setBounds(30, 287, 144, 23);
		contentPane.add(InvoAddr);
		
		SRInvoAddr = new JTextField();
		SRInvoAddr.setText(data[9].toString());
		SRInvoAddr.setColumns(10);
		SRInvoAddr.setBounds(177, 289, 541, 21);
		contentPane.add(SRInvoAddr);
		
		JLabel FactAddr = new JLabel("供應商工廠地址：");
		FactAddr.setFont(new Font("標楷體", Font.PLAIN, 18));
		FactAddr.setBounds(30, 320, 144, 23);
		contentPane.add(FactAddr);
		
		SRFactAddr = new JTextField();
		SRFactAddr.setText(data[10].toString());
		SRFactAddr.setColumns(10);
		SRFactAddr.setBounds(177, 322, 541, 21);
		contentPane.add(SRFactAddr);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {		//監控物件是否被選擇
		int state = e.getStateChange();
		if(state==ItemEvent.SELECTED)
			if(e.getItem()==chckbxNewCheckBox){
				str = chckbxNewCheckBox.getText();
				}
		if(e.getItem()==checkBox){
			str = checkBox.getText();
			}
		if(e.getItem()==checkBox_1){
			str = checkBox_1.getText();
			}
		if(e.getItem()==checkBox_2){
			str = checkBox_2.getText();
			}
		if(e.getItem()==checkBox_3){
			str = checkBox_3.getText();
			}
		}
	public int checkSR(final String SRName3,final String SRTaxID3){		//檢查有無欠缺重要資料

		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   int checkname=0;
		   String[] NameTaxId=new String[2];
		   NameTaxId[0]=""; NameTaxId[1]=""; 
		   int numberOfColumns;
			   try{
				   statement = con.createStatement();
				   try{
					   rs = statement.executeQuery("Select SRName,SRTaxID From SR where SRName='"+SRName3+"' OR SRTaxID='"+SRTaxID3+"'");
					   rsMetaData = rs.getMetaData();
					   numberOfColumns = rsMetaData.getColumnCount();
					   while (rs.next()){  //顯示欄位裡的資料
						   for(int i=1; i<=numberOfColumns; i++)
						   {
							   NameTaxId[i-1]= rs.getObject(i).toString();
							   System.out.println((i-1)+": "+NameTaxId[i-1]);
							   }
						   }
				   }catch(SQLException SQLe){
					   SQLe.printStackTrace();
				   }
			   }catch(SQLException SQLe){
				   SQLe.printStackTrace();
			   }
		   if((!NameTaxId[0].equals(SRName3))||(!NameTaxId[1].equals(SRTaxID3))||(!NameTaxId[0].equals(SRName))||(!NameTaxId[1].equals(SRTaxID))){
		    	checkname=0;
		    	}
		   return checkname;
		   }
	}

