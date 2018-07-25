package HHSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.Window.Type;

public class NewCustomer extends JFrame implements ItemListener {
	//資料庫JDBC Driver名稱
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	private JPanel contentPane;
	Connection cc;
	private JTextField CTName_t, CTChiAbbr_t, CTPhone_t, CTFax_t, CTIndCate_t, CTTaxID_t, 
	                   CTInvoTit_t, CTRecPhone_t, CTRecName_t, CTInvoAddr_t, CTMMAddr_t, 
	                   CTDelAddr_t, CTConpName1_t, CTConpName2_t, CTConpName3_t, CTFounDate_t, 
	                   CTBank_t, CTDAcco_t, CTBankName_t, CTSDelReq_t, other1_t, other2_t, CTAddr_t;
	
	NewCustomer clone = this;
	private String column, column2, column3, column4, column5, column6, column7;
	JCheckBox Rent = new JCheckBox("\u79DF\u8CC3");
	JCheckBox Own = new JCheckBox("\u81EA\u6709");
	JCheckBox checkBox1 = new JCheckBox("\u4E0A\u5E02\u3001\u6AC3\u516C\u53F8");
	JCheckBox checkBox2 = new JCheckBox("\u516C\u958B\u767C\u884C");
	JCheckBox checkBox3 = new JCheckBox("\u672A\u516C\u958B");
	JCheckBox checkBox4 = new JCheckBox("5\u5343\u842C\u4EE5\u4E0A");
	JCheckBox checkBox5 = new JCheckBox("1\u5343\u842C~5\u5343\u842C");
	JCheckBox checkBox6 = new JCheckBox("1\u5343\u842C\u4EE5\u4E0A");
	JCheckBox checkBox7 = new JCheckBox("1\u5104\u4EE5\u4E0A");
	JCheckBox checkBox8 = new JCheckBox("2\u5343\u842C~1\u5104");
	JCheckBox checkBox9 = new JCheckBox("2\u5343\u842C\u4EE5\u4E0B");
	JCheckBox checkBox10 = new JCheckBox("\u652F\u7968");
	JCheckBox checkBox11 = new JCheckBox("\u532F\u6B3E");
	JCheckBox checkBox12 = new JCheckBox("\u73FE\u91D1");
	JCheckBox Other1 = new JCheckBox("\u5176\u4ED6\uFF1A");
	JCheckBox checkBox13 = new JCheckBox("\u9644\u56DE\u90F5");
	JCheckBox checkBox14 = new JCheckBox("\u4E0D\u9644\u56DE\u90F5");
	JCheckBox checkBox15 = new JCheckBox("\u9808\u9644\u6587\u4EF6");
	JCheckBox Other2 = new JCheckBox("\u5176\u4ED6\uFF1A");
	JCheckBox checkBox_1 = new JCheckBox("\u7576\u670830\u5929");
	JCheckBox checkBox_2 = new JCheckBox("\u6B21\u6708\u7D5060\u5929");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void itemStateChanged(ItemEvent event)
    {
		
      int chkbox = event.getStateChange();
      if(chkbox == ItemEvent.SELECTED)
     
		 if(event.getItem()==Own)
		 {
		     column=Own.getText();
		 }
		 
		 if(event.getItem()==Rent)
		 {
		     column=Rent.getText();
		 }
		
	  int chkbox2 = event.getStateChange();	 
	  if(chkbox2 == ItemEvent.SELECTED)
		     
		 if(event.getItem()==checkBox1)
		 {
			 column2=checkBox1.getText();
		 }
			 
		 if(event.getItem()==checkBox2)
		 {
			 column2=checkBox2.getText();
		 }
			 
		 if(event.getItem()==checkBox3)
		 {
			 column2=checkBox3.getText();
		 }	
		 
	  int chkbox3 = event.getStateChange();	 
	  if(chkbox3 == ItemEvent.SELECTED)
			     
		 if(event.getItem()==checkBox4)
		 {
			 column3=checkBox4.getText();
		 }
				 
		 if(event.getItem()==checkBox5)
		 {
			 column3=checkBox5.getText();
		 }
				 
		 if(event.getItem()==checkBox6)
		 {
			 column3=checkBox6.getText();
		 }	
		
	  int chkbox4 = event.getStateChange();	 
	  if(chkbox4 == ItemEvent.SELECTED)
				     
		 if(event.getItem()==checkBox7)
		 {
			 column4=checkBox7.getText();
		 }
					 
		 if(event.getItem()==checkBox8)
		 {
			 column4=checkBox8.getText();
		 }
					 
		 if(event.getItem()==checkBox9)
		 {
			 column4=checkBox9.getText();
		 }	
		 
		 int chkbox5 = event.getStateChange();	 
		  if(chkbox5 == ItemEvent.SELECTED)
					     
			 if(event.getItem()==checkBox10)
			 {
				 column5=checkBox10.getText();
			 }
						 
			 if(event.getItem()==checkBox11)
			 {
				 column5=checkBox11.getText();
			 }
						 
			 if(event.getItem()==checkBox12)
			 {
				 column5=checkBox12.getText();
			 }	
			 if(event.getItem()==Other1)
			 {
				 column5=other1_t.getText();
			 }	
			 
			 int chkbox6 = event.getStateChange();	 
			  if(chkbox6 == ItemEvent.SELECTED)
						     
				 if(event.getItem()==checkBox13)
				 {
					 column6=checkBox13.getText();
				 }
							 
				 if(event.getItem()==checkBox14)
				 {
					 column6=checkBox14.getText();
				 }
							 
				 if(event.getItem()==checkBox15)
				 {
					 column6=checkBox15.getText();
				 }	
				 if(event.getItem()==Other2)
				 {
					 column6=other2_t.getText();
				 }	
				 
				 int chkbox7 = event.getStateChange();	 
				  if(chkbox7 == ItemEvent.SELECTED)
							     		 
					 if(event.getItem()==checkBox_1)
					 {
						 column7=checkBox_1.getText();
					 }
								 
					 if(event.getItem()==checkBox_2)
					 {
						 column7=checkBox_2.getText();
					 }	
					 
    }
	/**
	 * Create the frame.
	 * @param password2 
	 * @param username2 
	 * @param uRL2 
	 */
	public NewCustomer(Connection conn,String EI,String EN,final String URL,final String UN,final String PW) {
		setResizable(false);
			cc=conn;
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
			url = URL;
			username = UN;
			password = PW;
		   final String Ei=EI;
		   final String En=EN;
	       
		setTitle("\u65B0\u589E\u5BA2\u6236\u57FA\u672C\u8CC7\u6599");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(460, 0, 701, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("標楷體", Font.ITALIC, 22));
		company.setBounds(469, 10, 184, 33);
		contentPane.add(company);
		
		JLabel CTName = new JLabel("\u5BA2\u6236\u5168\u540D\uFF1A");
		CTName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTName.setBounds(28, 56, 80, 15);
		contentPane.add(CTName);
		
		JLabel CTChiAbbr = new JLabel("\u4E2D\u6587\u7C21\u7A31\uFF1A");
		CTChiAbbr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTChiAbbr.setBounds(238, 56, 80, 15);
		contentPane.add(CTChiAbbr);
		
		JLabel CTPhone = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A");
		CTPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPhone.setBounds(450, 56, 80, 15);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A");
		CTFax.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFax.setBounds(28, 81, 100, 15);
		contentPane.add(CTFax);
		
		JLabel CTIndCate = new JLabel("\u884C\u696D\u985E\u5225\uFF1A");
		CTIndCate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTIndCate.setBounds(238, 81, 100, 15);
		contentPane.add(CTIndCate);
		
		JLabel CTTaxID = new JLabel("\u7D71\u4E00\u7DE8\u865F\uFF1A");
		CTTaxID.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTaxID.setBounds(450, 81, 80, 15);
		contentPane.add(CTTaxID);
		
		JLabel CTInvoTit = new JLabel("\u767C\u7968\u62AC\u982D\uFF1A");
		CTInvoTit.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoTit.setBounds(28, 106, 80, 15);
		contentPane.add(CTInvoTit);
		
		final JLabel CTInvoAddr = new JLabel("\u5BA2\u6236\u767C\u7968\u5730\u5740\uFF1A");
		CTInvoAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoAddr.setBounds(28, 131, 120, 15);
		contentPane.add(CTInvoAddr);
		
		JLabel CTMMAddr = new JLabel("\u8ACB\u6B3E\u5730\u5740\uFF1A");
		CTMMAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTMMAddr.setBounds(28, 156, 100, 15);
		contentPane.add(CTMMAddr);
		
		JLabel CTDelAddr = new JLabel("\u9001\u8CA8\u5730\u5740\uFF1A");
		CTDelAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDelAddr.setBounds(28, 181, 100, 15);
		contentPane.add(CTDelAddr);
		
		JLabel CTRecPhone = new JLabel("\u6536\u8CA8\u96FB\u8A71\uFF1A");
		CTRecPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecPhone.setBounds(238, 106, 100, 15);
		contentPane.add(CTRecPhone);
		
		JLabel CTRecName = new JLabel("\u6536\u8CA8\u4EBA\uFF1A");
		CTRecName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecName.setBounds(450, 106, 100, 15);
		contentPane.add(CTRecName);
		
		JLabel CTFounDate = new JLabel("\u6210\u7ACB\u65E5\u671F\uFF1A");
		CTFounDate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFounDate.setBounds(28, 231, 100, 15);
		contentPane.add(CTFounDate);
		
		JLabel CTBusiArea = new JLabel("\u71DF\u696D\u5834\u6240\uFF1A");
		CTBusiArea.setBackground(new Color(240, 240, 240));
		CTBusiArea.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBusiArea.setBounds(259, 231, 100, 15);
		contentPane.add(CTBusiArea);
		
		JLabel CTComType = new JLabel("\u516C\u53F8\u578B\u614B\uFF1A");
		CTComType.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTComType.setBounds(28, 256, 80, 15);
		contentPane.add(CTComType);
		
		ButtonGroup chkbox = new ButtonGroup();           //營業場所
		Own.setBackground(new Color(240, 240, 240));
		Own.setFont(new Font("標楷體", Font.PLAIN, 16));
		Own.setBounds(341, 228, 58, 20);
		contentPane.add(Own);
		
		Rent.setBackground(new Color(240, 240, 240));
		Rent.setFont(new Font("標楷體", Font.PLAIN, 16));
		Rent.setBounds(416, 227, 97, 23);
		contentPane.add(Rent);
		Own.addItemListener(this);
		Rent.addItemListener(this);
		chkbox.add(Own);
		chkbox.add(Rent);
		 
		ButtonGroup chkbox2 = new ButtonGroup();                 //公司型態
		checkBox1.setBackground(new Color(240, 240, 240));
		checkBox1.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox1.setBounds(140, 253, 132, 23);
		contentPane.add(checkBox1);
		
		checkBox2.setBackground(new Color(240, 240, 240));
		checkBox2.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox2.setBounds(269, 252, 97, 23);
		contentPane.add(checkBox2);
		
		checkBox3.setBackground(new Color(240, 240, 240));
		checkBox3.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox3.setBounds(416, 252, 97, 23);
		contentPane.add(checkBox3);
		checkBox1.addItemListener(this);
		checkBox2.addItemListener(this);
		checkBox3.addItemListener(this);
		chkbox2.add(checkBox1);
		chkbox2.add(checkBox2);
		chkbox2.add(checkBox3);
		
		ButtonGroup chkbox3 = new ButtonGroup();                    //實收資本額
		checkBox4.setBackground(new Color(240, 240, 240));
		checkBox4.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox4.setBounds(140, 281, 105, 15);
		contentPane.add(checkBox4);
		
		checkBox5.setBackground(new Color(240, 240, 240));
		checkBox5.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox5.setBounds(270, 281, 140, 15);
		contentPane.add(checkBox5);
		
		checkBox6.setBackground(new Color(240, 240, 240));
		checkBox6.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox6.setBounds(416, 281, 112, 15);
		contentPane.add(checkBox6);
		checkBox4.addItemListener(this);
		checkBox5.addItemListener(this);
		checkBox6.addItemListener(this);
		chkbox3.add(checkBox4);
		chkbox3.add(checkBox5);
		chkbox3.add(checkBox6);
		
		ButtonGroup chkbox4 = new ButtonGroup();                   //上年度營業額
		checkBox7.setBackground(new Color(240, 240, 240));
		checkBox7.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox7.setBounds(140, 306, 100, 15);
		contentPane.add(checkBox7);
		
		checkBox8.setBackground(new Color(240, 240, 240));
		checkBox8.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox8.setBounds(270, 306, 97, 15);
		contentPane.add(checkBox8);
		
		checkBox9.setBackground(new Color(240, 240, 240));
		checkBox9.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox9.setBounds(416, 306, 100, 15);
		contentPane.add(checkBox9);
		checkBox7.addItemListener(this);
		checkBox8.addItemListener(this);
		checkBox9.addItemListener(this);
		chkbox4.add(checkBox7);
		chkbox4.add(checkBox8);
		chkbox4.add(checkBox9);
		
		ButtonGroup chkbox5 = new ButtonGroup();                        //付款方式
		checkBox10.setBackground(new Color(240, 240, 240));
		checkBox10.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox10.setBounds(124, 402, 67, 23);
		contentPane.add(checkBox10);
		
		checkBox11.setBackground(new Color(240, 240, 240));
		checkBox11.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox11.setBounds(200, 402, 97, 23);
		contentPane.add(checkBox11);
		
		checkBox12.setBackground(new Color(240, 240, 240));
		checkBox12.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox12.setBounds(295, 402, 87, 23);
		contentPane.add(checkBox12);
		
		Other1.setBackground(new Color(240, 240, 240));
		Other1.setFont(new Font("標楷體", Font.PLAIN, 16));
		Other1.setBounds(392, 402, 73, 23);
		contentPane.add(Other1);
		checkBox10.addItemListener(this);
		checkBox11.addItemListener(this);
		checkBox12.addItemListener(this);
		Other1.addItemListener(this);
		chkbox5.add(checkBox10);
		chkbox5.add(checkBox11);
		chkbox5.add(checkBox12);
		chkbox5.add(Other1);
		
		ButtonGroup chkbox6 = new ButtonGroup();                        //請款方式
		checkBox13.setBackground(new Color(240, 240, 240));
		checkBox13.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox13.setBounds(124, 427, 73, 23);
		contentPane.add(checkBox13);
		
		checkBox14.setBackground(new Color(240, 240, 240));
		checkBox14.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox14.setBounds(200, 427, 97, 23);
		contentPane.add(checkBox14);
		
		checkBox15.setBackground(new Color(240, 240, 240));
		checkBox15.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox15.setBounds(295, 427, 100, 23);
		contentPane.add(checkBox15);
		
		Other2.setBackground(new Color(240, 240, 240));
		Other2.setFont(new Font("標楷體", Font.PLAIN, 16));
		Other2.setBounds(392, 427, 73, 23);
		contentPane.add(Other2);
		checkBox13.addItemListener(this);
		checkBox14.addItemListener(this);
		checkBox15.addItemListener(this);
		Other2.addItemListener(this);
		chkbox6.add(checkBox13);
		chkbox6.add(checkBox14);
		chkbox6.add(checkBox15);
		chkbox6.add(Other2);
		
		ButtonGroup chkbox7 = new ButtonGroup();
		
		checkBox_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox_1.setBackground(SystemColor.menu);
		checkBox_1.setBounds(124, 377, 115, 23);
		contentPane.add(checkBox_1);
		
		checkBox_2.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkBox_2.setBackground(SystemColor.menu);
		checkBox_2.setBounds(295, 377, 113, 23);
		contentPane.add(checkBox_2);
		checkBox_1.addItemListener(this);
		checkBox_2.addItemListener(this);
		chkbox7.add(checkBox_1);
		chkbox7.add(checkBox_2);
		
		
		JLabel CTConpName1 = new JLabel("\u806F\u7D61\u4EBA1\uFF1A");   
		CTConpName1.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName1.setBounds(28, 206, 100, 15);
		contentPane.add(CTConpName1);
		
		JLabel CTConpName2 = new JLabel("\u806F\u7D61\u4EBA2\uFF1A");
		CTConpName2.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName2.setBounds(249, 206, 100, 15);
		contentPane.add(CTConpName2);
		
		JLabel CTConpName3 = new JLabel("\u806F\u7D61\u4EBA3\uFF1A");
		CTConpName3.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName3.setBounds(450, 206, 80, 15);
		contentPane.add(CTConpName3);
		
		JLabel CTPUC = new JLabel("\u5BE6\u6536\u8CC7\u672C\u984D\uFF1A");
		CTPUC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPUC.setBounds(28, 281, 100, 15);
		contentPane.add(CTPUC);
		
		
		JLabel CTTurnLast = new JLabel("\u4E0A\u5E74\u5EA6\u71DF\u696D\u984D\uFF1A");
		CTTurnLast.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTurnLast.setBounds(28, 306, 120, 15);
		contentPane.add(CTTurnLast);
		
		JLabel CTBank = new JLabel("\u4E3B\u8981\u5F80\u4F86\u9280\u884C/\u5206\u884C\uFF1A");
		CTBank.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBank.setBounds(28, 331, 152, 15);
		contentPane.add(CTBank);
		
		JLabel CTDAcco = new JLabel("\u7532\u5B58\u5E33\u865F\uFF1A");
		CTDAcco.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDAcco.setBounds(380, 331, 80, 15);
		contentPane.add(CTDAcco);
		
		JLabel CTBankName = new JLabel("\u6236\u540D\uFF1A");
		CTBankName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBankName.setBounds(28, 356, 59, 15);
		contentPane.add(CTBankName);
		
		JLabel CTSDelReq = new JLabel("\u5BA2\u6236\u7279\u6B8A\u4EA4\u8CA8\u8981\u6C42\uFF1A");
		CTSDelReq.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTSDelReq.setBounds(288, 356, 152, 15);
		contentPane.add(CTSDelReq);
		
		JLabel CTPayCond = new JLabel("\u4ED8\u6B3E\u689D\u4EF6\uFF1A");
		CTPayCond.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayCond.setBounds(28, 381, 80, 15);
		contentPane.add(CTPayCond);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("標楷體", Font.ITALIC, 16));
		label_1.setBounds(97, 557, 156, 15);
		contentPane.add(label_1);
		
		JLabel CTPayMeth = new JLabel("\u4ED8\u6B3E\u65B9\u5F0F\uFF1A");
		CTPayMeth.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayMeth.setBounds(28, 406, 90, 15);
		contentPane.add(CTPayMeth);
		
		JLabel lblNewLabel = new JLabel("\u8ACB\u6B3E\u65B9\u5F0F\uFF1A");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 431, 80, 15);
		contentPane.add(lblNewLabel);
		
		JLabel CTPIC = new JLabel("\u5BA2\u6236\u8CA0\u8CAC\u4EBA\uFF1A"+En);
		CTPIC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPIC.setBounds(395, 456, 211, 15);
		contentPane.add(CTPIC);
		
		JLabel CTAddr = new JLabel("\u5BA2\u6236\u5730\u5740\uFF1A");
		CTAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTAddr.setBounds(28, 456, 80, 15);
		contentPane.add(CTAddr);
		
		
		JButton add = new JButton("\u65B0\u589E");
		add.setFont(new Font("標楷體", Font.PLAIN, 16));
		add.addActionListener(new ActionListener() {	 
			public void actionPerformed(ActionEvent e) {
				//檢查是否有空值
				int empty=0;
				String CTName,CTChiAbbr,CTPhone,CTFax,CTIndCate,CTTaxID,CTInvoTit,CTRecPhone,CTRecName,
				CTInvoAddr,CTMMAddr,CTDelAddr,CTConpName1,CTConpName2,CTConpName3,CTFounDate,CTBank,
				CTDAcco,CTBankName,CTSDelReq,CTAddr ;
			
				CTName = CTName_t.getText();
				CTChiAbbr = CTChiAbbr_t.getText();
				CTPhone = CTPhone_t.getText();
				CTFax = CTFax_t.getText();
				CTIndCate = CTIndCate_t.getText();
				CTTaxID = CTTaxID_t.getText();
				CTInvoTit = CTInvoTit_t.getText();
				CTRecPhone = CTRecPhone_t.getText();
				CTRecName = CTRecName_t.getText();
				CTInvoAddr = CTInvoAddr_t.getText();
				CTMMAddr = CTMMAddr_t.getText();
				CTDelAddr = CTDelAddr_t.getText();
				CTConpName1 = CTConpName1_t.getText();
				CTConpName2 = CTConpName2_t.getText();
				CTConpName3 = CTConpName3_t.getText();
				CTFounDate = CTFounDate_t.getText();
				CTBank = CTBank_t.getText();
				CTDAcco = CTDAcco_t.getText();
				CTBankName = CTBankName_t.getText();
				CTSDelReq = CTSDelReq_t.getText();
				CTAddr = CTAddr_t.getText();
				//int empty=0;
				
				try{
					if("".equals(CTName.toString().trim())){empty++;}
					if("".equals(CTChiAbbr.toString().trim())){empty++;}
					if("".equals(CTPhone.toString().trim())){empty++;}
					if("".equals(CTFax.toString().trim())){empty++;}
					if("".equals(CTIndCate.toString().trim())){empty++;}
					if("".equals(CTTaxID.toString().trim())){empty++;}
					if("".equals(CTInvoTit.toString().trim())){empty++;}
					if("".equals(CTRecPhone.toString().trim())){empty++;}
					if("".equals(CTRecName.toString().trim())){empty++;}
					if("".equals(CTInvoAddr.toString().trim())){empty++;}
					if("".equals(CTMMAddr.toString().trim())){empty++;}
					if("".equals(CTDelAddr.toString().trim())){empty++;}
					if("".equals(CTConpName1.toString().trim())){empty++;}
					if("".equals(CTConpName2.toString().trim())){empty++;}
					if("".equals(CTConpName3.toString().trim())){empty++;}
					if("".equals(CTFounDate.toString().trim())){empty++;}
					if("".equals(CTBank.toString().trim())){empty++;}
					if("".equals(CTDAcco.toString().trim())){empty++;}
					if("".equals(CTBankName.toString().trim())){empty++;}
					if("".equals(CTSDelReq.toString().trim())){empty++;}
					if("".equals(CTAddr.toString().trim())){empty++;}
					//沒有空值，才執行傳送給預覽畫面
					if(empty ==0){
						
						if(!checkCT(CTName,CTChiAbbr).equals(CTName)){
							System.out.println("OK");
							
							if(CTTaxIDpattern(CTTaxID)&&CTPhonepattern(CTPhone)&&CTFaxpattern(CTFax)&&CTDAccopattern(CTDAcco)&&CTRecPhonepattern(CTRecPhone))
						    {
							
							//if(CTFounDate_t.getText()=="")CTFounDate_t.setText(null);
							PreviewCustomer preview = new PreviewCustomer(cc,clone, CTName_t.getText(), CTChiAbbr_t.getText(), CTPhone_t.getText(),
									CTFax_t.getText(), CTIndCate_t.getText(), CTTaxID_t.getText(), CTInvoTit_t.getText(), 
									CTRecPhone_t.getText(), CTRecName_t.getText(), CTInvoAddr_t.getText(), CTMMAddr_t.getText(),
									CTDelAddr_t.getText(), CTConpName1_t.getText(), CTConpName2_t.getText(), CTConpName3_t.getText(),
									CTFounDate_t.getText(), CTBank_t.getText(), CTDAcco_t.getText(), CTBankName_t.getText(),
									CTSDelReq_t.getText(), other1_t.getText(), other2_t.getText(), En,
									column, column2, column3, column4, column5, column6, column7, CTAddr_t.getText(),En,Ei,URL,UN,PW);
								System.out.println(Ei+" "+En);
								preview.setAlwaysOnTop(true); 
								preview.requestFocus();  
								preview.setVisible(true);
								dispose();
						    }else{
						        JOptionPane.showMessageDialog(NewCustomer.this, "電話傳真 或 統編 或 甲存帳號 或 收貨電話 或 客戶傳真 格式輸入錯誤", "新增錯誤", JOptionPane.WARNING_MESSAGE) ;
						       }	
						
					}else{
							JOptionPane.showMessageDialog(NewCustomer.this, "客戶名稱和簡稱不可重複", "新增錯誤", JOptionPane.WARNING_MESSAGE)	;
						}
					}else{
						JOptionPane.showMessageDialog(NewCustomer.this, "不可有欄位為空值", "警告", JOptionPane.WARNING_MESSAGE)	;
						}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(NewCustomer.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		add.setBounds(565, 489, 87, 23);
		contentPane.add(add);
		
		CTChiAbbr_t = new JTextField();
		CTChiAbbr_t.setBounds(323, 56, 117, 15);
		contentPane.add(CTChiAbbr_t);
		CTChiAbbr_t.setColumns(10);
		
		CTPhone_t = new JTextField();
		CTPhone_t.setBounds(533, 57, 120, 15);
		contentPane.add(CTPhone_t);
		CTPhone_t.setColumns(10);
		
		CTFax_t = new JTextField();
		CTFax_t.setBounds(112, 82, 116, 15);
		contentPane.add(CTFax_t);
		CTFax_t.setColumns(10);
		
		CTIndCate_t = new JTextField();
		CTIndCate_t.setBounds(323, 82, 117, 15);
		contentPane.add(CTIndCate_t);
		CTIndCate_t.setColumns(10);
		
		CTTaxID_t = new JTextField();
		CTTaxID_t.setBounds(533, 82, 122, 15);
		contentPane.add(CTTaxID_t);
		CTTaxID_t.setColumns(10);
		
		CTInvoTit_t = new JTextField();
		CTInvoTit_t.setBounds(111, 107, 117, 15);
		contentPane.add(CTInvoTit_t);
		CTInvoTit_t.setColumns(10);
		
		CTRecPhone_t = new JTextField();
		CTRecPhone_t.setBounds(323, 106, 117, 15);
		contentPane.add(CTRecPhone_t);
		CTRecPhone_t.setColumns(10);
		
		CTRecName_t = new JTextField();
		CTRecName_t.setBounds(533, 106, 120, 15);
		contentPane.add(CTRecName_t);
		CTRecName_t.setColumns(10);
		
		CTInvoAddr_t = new JTextField();
		CTInvoAddr_t.setBounds(140, 132, 513, 15);
		contentPane.add(CTInvoAddr_t);
		CTInvoAddr_t.setColumns(10);
		
		CTMMAddr_t = new JTextField();
		CTMMAddr_t.setBounds(112, 156, 541, 15);
		contentPane.add(CTMMAddr_t);
		CTMMAddr_t.setColumns(10);
		
		CTDelAddr_t = new JTextField();
		CTDelAddr_t.setBounds(112, 181, 541, 15);
		contentPane.add(CTDelAddr_t);
		CTDelAddr_t.setColumns(10);
		
		CTConpName1_t = new JTextField();
		CTConpName1_t.setBounds(112, 206, 127, 15);
		contentPane.add(CTConpName1_t);
		CTConpName1_t.setColumns(10);
		
		CTConpName2_t = new JTextField();
		CTConpName2_t.setBounds(323, 206, 117, 15);
		contentPane.add(CTConpName2_t);
		CTConpName2_t.setColumns(10);
		
		CTConpName3_t = new JTextField();
		CTConpName3_t.setBounds(525, 207, 128, 15);
		contentPane.add(CTConpName3_t);
		CTConpName3_t.setColumns(10);
		
		CTFounDate_t = new JTextField();
		CTFounDate_t.setBounds(111, 232, 129, 15);
		contentPane.add(CTFounDate_t);
		CTFounDate_t.setColumns(10);
		
		CTBank_t = new JTextField();
		CTBank_t.setBounds(180, 332, 186, 15);
		contentPane.add(CTBank_t);
		CTBank_t.setColumns(10);
		
		CTDAcco_t = new JTextField();
		CTDAcco_t.setBounds(469, 332, 184, 15);
		contentPane.add(CTDAcco_t);
		CTDAcco_t.setColumns(10);
		
		CTBankName_t = new JTextField();
		CTBankName_t.setBounds(78, 356, 194, 15);
		contentPane.add(CTBankName_t);
		CTBankName_t.setColumns(10);
		
		CTSDelReq_t = new JTextField();
		CTSDelReq_t.setBounds(436, 357, 217, 15);
		contentPane.add(CTSDelReq_t);
		CTSDelReq_t.setColumns(10);
		
		other1_t = new JTextField();
		other1_t.setBounds(465, 407, 188, 15);
		contentPane.add(other1_t);
		other1_t.setColumns(10);
		
		other2_t = new JTextField();
		other2_t.setBounds(469, 432, 184, 15);
		contentPane.add(other2_t);
		other2_t.setColumns(10);
		
		CTName_t = new JTextField();
		CTName_t.setBounds(113, 56, 115, 15);
		contentPane.add(CTName_t);
		CTName_t.setColumns(10);
		
		CTAddr_t = new JTextField();
		CTAddr_t.setBounds(110, 456, 248, 15);
		contentPane.add(CTAddr_t);
		CTAddr_t.setColumns(10);
		
		
	}
	
	public static boolean CTRecPhonepattern(String value) {	//收貨電話
	     Pattern pattern = Pattern.compile("^[-+]?\\d+$");	
	     return pattern.matcher(value).matches();
	 }
	
	public static boolean CTDAccopattern(String value) {	//甲存帳號
	     Pattern pattern = Pattern.compile("^[-+]?\\d+$");	
	     return pattern.matcher(value).matches();
	 }
	
	public static boolean CTFaxpattern(String value) {	//客戶傳真
	     Pattern pattern = Pattern.compile("^[-+]?\\d+$");	
	     return pattern.matcher(value).matches();
	 }
	
	public static boolean CTPhonepattern(String value) {	//客戶電話
	     Pattern pattern = Pattern.compile("^[-+]?\\d+$");	
	     return pattern.matcher(value).matches();
	 }
	
	public static boolean CTTaxIDpattern(String value) {	//統一編號驗證
	     Pattern pattern = Pattern.compile("^[-+]?\\d+$");	// 0-9整數
	     return pattern.matcher(value).matches();
	 }
	
	
	public String checkCT(String CTName2,String CTChiAbbr2){
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String checkname="";
		   int numberOfColumns;
				try {
					statement = cc.createStatement();
					try{
						rs = statement.executeQuery("Select CTName From CT where CTName='"+CTName2+"' AND CTChiAbbr='"+CTChiAbbr2+"'");
						rsMetaData = rs.getMetaData();
						numberOfColumns = rsMetaData.getColumnCount();	
						while (rs.next()){  //顯示欄位裡的資料
						      for(int i=1; i<=numberOfColumns; i++)
							   {
						    	 if(rs.getObject(i).equals(CTName2)	){ //將符合的客戶名稱放進確認變數裡
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
}
	

