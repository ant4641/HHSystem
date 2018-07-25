package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class testClient extends JFrame {

	private JPanel contentPane;
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
					testClient frame = new testClient(null,null,1,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param con 
	 * @param password 
	 * @param username 
	 * @param url 
	 */
	public testClient(final Connection conn, final String []data,final int EST,final String URL,final String UN,final String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		url = URL;
		username = UN;
		password = PW;
		JLabel CTNum = new JLabel("客戶編號："+data[0]);
		CTNum.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTNum.setBounds(201, 10, 205, 26);
		contentPane.add(CTNum);
		
		JLabel CTFax = new JLabel("客戶傳真："+data[4]);
		CTFax.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFax.setBounds(10, 71, 200, 15);
		contentPane.add(CTFax);
		
		JLabel CTChiAbbr = new JLabel("中文簡稱："+data[6]);
		CTChiAbbr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTChiAbbr.setBounds(220, 46, 202, 15);
		contentPane.add(CTChiAbbr);
		
		JLabel CTIndCate = new JLabel("行業類別："+data[7]);
		CTIndCate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTIndCate.setBounds(220, 71, 186, 15);
		contentPane.add(CTIndCate);
		
		JLabel CTPhone = new JLabel("客戶電話："+data[2]);
		CTPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPhone.setBounds(432, 46, 203, 15);
		contentPane.add(CTPhone);
		
		JLabel CTTaxID = new JLabel("統一編號："+data[3]);
		CTTaxID.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTaxID.setBounds(432, 71, 203, 15);
		contentPane.add(CTTaxID);
		
		JLabel label_6 = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_6.setFont(new Font("標楷體", Font.ITALIC, 22));
		label_6.setBounds(462, 0, 184, 33);
		contentPane.add(label_6);
		
		JLabel CTRecName = new JLabel("收貨人："+data[11]);
		CTRecName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecName.setBounds(432, 96, 175, 15);
		contentPane.add(CTRecName);
		
		JLabel CTRecPhone = new JLabel("收貨電話："+data[10]);
		CTRecPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecPhone.setBounds(220, 96, 202, 15);
		contentPane.add(CTRecPhone);
		
		JLabel CTInvoTit = new JLabel("發票抬頭："+data[28]);
		CTInvoTit.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoTit.setBounds(10, 96, 200, 15);
		contentPane.add(CTInvoTit);
		
		JLabel CTInvoAddr = new JLabel("客戶發票地址："+data[29]);
		CTInvoAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoAddr.setBounds(10, 121, 636, 15);
		contentPane.add(CTInvoAddr);
		
		JLabel CTMMAddr = new JLabel("請款地址："+data[8]);
		CTMMAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTMMAddr.setBounds(10, 146, 636, 15);
		contentPane.add(CTMMAddr);
		
		JLabel CTDelAddr = new JLabel("送貨地址："+data[9]);
		CTDelAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDelAddr.setBounds(10, 171, 636, 15);
		contentPane.add(CTDelAddr);
		
		JLabel CTConpName1 = new JLabel("聯絡人1："+data[12]);
		CTConpName1.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName1.setBounds(10, 196, 200, 15);
		contentPane.add(CTConpName1);
		
		JLabel CTConpName2 = new JLabel("聯絡人2："+data[13]);
		CTConpName2.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName2.setBounds(231, 196, 175, 15);
		contentPane.add(CTConpName2);
		
		JLabel CTConpName3 = new JLabel("聯絡人3："+data[14]);
		CTConpName3.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName3.setBounds(432, 196, 203, 15);
		contentPane.add(CTConpName3);
		
		JLabel CTBusiArea = new JLabel("營業場所："+data[16]);
		CTBusiArea.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBusiArea.setBounds(220, 221, 186, 15);
		contentPane.add(CTBusiArea);
		
		JLabel CTFounDate = new JLabel("成立日期："+data[15]);
		CTFounDate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFounDate.setBounds(10, 221, 200, 15);
		contentPane.add(CTFounDate);
		
		JLabel CTComType = new JLabel("公司型態："+data[17]);
		CTComType.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTComType.setBounds(10, 246, 269, 15);
		contentPane.add(CTComType);
		
		JLabel CTPUC = new JLabel("實收資本額："+data[18]);
		CTPUC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPUC.setBounds(10, 271, 269, 15);
		contentPane.add(CTPUC);
		
		JLabel CTTurnLast = new JLabel("上年度營業額："+data[19]);
		CTTurnLast.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTurnLast.setBounds(10, 296, 250, 15);
		contentPane.add(CTTurnLast);
		
		JLabel CTBank = new JLabel("主要往來銀行/分行："+data[20]);
		CTBank.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBank.setBounds(10, 321, 339, 15);
		contentPane.add(CTBank);
		
		JLabel CTDAcco = new JLabel("甲存帳號："+data[21]);
		CTDAcco.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDAcco.setBounds(362, 321, 284, 15);
		contentPane.add(CTDAcco);
		
		JLabel CTSDelReq = new JLabel("客戶特殊交貨要求："+data[23]);
		CTSDelReq.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTSDelReq.setBounds(270, 346, 376, 15);
		contentPane.add(CTSDelReq);
		
		JLabel CTBankName = new JLabel("戶名："+data[22]);
		CTBankName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBankName.setBounds(10, 346, 250, 15);
		contentPane.add(CTBankName);
		
		JLabel CTPayCond = new JLabel("付款條件："+data[25]);
		CTPayCond.setFont(new Font("標楷體", Font.ITALIC, 16));
		CTPayCond.setBounds(10, 371, 625, 15);
		contentPane.add(CTPayCond);
		
		JLabel CTPayMeth = new JLabel("付款方式："+data[24]);
		CTPayMeth.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayMeth.setBounds(10, 396, 348, 15);
		contentPane.add(CTPayMeth);
		
		JLabel CTMMMeth = new JLabel("請款方式："+data[26]);
		CTMMMeth.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTMMMeth.setBounds(10, 421, 242, 15);
		contentPane.add(CTMMMeth);
		
		JLabel CTPIC = new JLabel("客戶負責人："+data[27]);
		CTPIC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPIC.setBounds(416, 421, 191, 15);
		contentPane.add(CTPIC);

		JButton button = new JButton("返回");
		button.setFont(new Font("標楷體", Font.PLAIN, 16));
		button.setBounds(480, 464, 87, 23);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		JLabel CTName = new JLabel("客戶名稱："+data[1]);
		CTName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTName.setBounds(8, 46, 202, 15);
		contentPane.add(CTName);
		
		JButton reviseCT = new JButton("\u4FEE\u6539");
		reviseCT.setFont(new Font("標楷體", Font.PLAIN, 16));
		reviseCT.setBounds(374, 465, 87, 23);
		contentPane.add(reviseCT);
		reviseCT.setVisible(false);
		if(EST==1||EST==3)reviseCT.setVisible(true);
		reviseCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyCT modct = new ModifyCT(conn,data,EST,url,username,password);
				modct.setAlwaysOnTop(true); 
				modct.requestFocus();  
				modct.setVisible(true);
			}
		});
	}
}
