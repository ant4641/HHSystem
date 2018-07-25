package HHSystem;

//import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.Window.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PreviewCustomer extends JFrame {

	protected static final String Max = null;
	protected static final String S001 = null;
	private JPanel contentPane;
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	Connection cc;
	//JLabel CTNum ; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private NewCustomer frame;

			public void run() {
				try {
					NewCustomer frame = new NewCustomer(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					frame = new NewCustomer(null,"","","","","");
				} catch (Exception e) {
					 if( e != null ){
					  e.printStackTrace();
					 }
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @param string 
	 * @param pW 
	 * @param uN 
	 * @param uRL 
	 */
	public PreviewCustomer(Connection conn,final NewCustomer clone,final String CTNa,final String CTCA,final String CTP,final String CTF,final String CTIC,final String CTTID,final String CTIT, 
			final String CTRP,final String CTRN,final String CTIA,final String CTMMA,final String CTDA,final String CTCN1,final String CTCN2,
			final String CTCN3,final String CTFD,final String CTB,final String CTDAc,final String CTBN,final String CTSDR,final String Other1,
			final String Other2,final String CTPIC,final String string, final String string2, final String string3, 
			final String string4, final String string5, final String string6, final String string7, final String CTAd,String CTAAP,String CTA_EID,final String URL,final String UN,final String PW) {

		setResizable(false);
		cc=conn;
		url = URL;
		username = UN;
		password = PW;
		final String CTAA=CTAAP;
		final String CTAEID=CTA_EID;
		final String date =getDateTime();
			
		setTitle("\u9810\u89BD\u65B0\u589E\u5BA2\u6236\u57FA\u672C\u8CC7\u6599");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(460, 0, 701, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("標楷體", Font.ITALIC, 22));
		company.setBounds(480, 10, 184, 33);
		contentPane.add(company);
		
			
		JLabel CTName = new JLabel("\u5BA2\u6236\u5168\u540D\uFF1A"+CTNa);
		CTName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTName.setBounds(28, 56, 200, 15);
		contentPane.add(CTName);
		
		JLabel CTChiAbbr = new JLabel("\u4E2D\u6587\u7C21\u7A31\uFF1A"+CTCA);
		CTChiAbbr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTChiAbbr.setBounds(238, 56, 202, 15);
		contentPane.add(CTChiAbbr);
		
		final JLabel CTPhone = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A"+CTP);
		CTPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPhone.setBounds(450, 56, 175, 15);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A"+CTF);
		CTFax.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFax.setBounds(28, 81, 163, 15);
		contentPane.add(CTFax);
		
		JLabel CTIndCate = new JLabel("\u884C\u696D\u985E\u5225\uFF1A"+CTIC);
		CTIndCate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTIndCate.setBounds(238, 81, 152, 15);
		contentPane.add(CTIndCate);
		
		final JLabel CTTaxID = new JLabel("\u7D71\u4E00\u7DE8\u865F\uFF1A"+CTTID);
		CTTaxID.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTaxID.setBounds(450, 81, 175, 15);
		contentPane.add(CTTaxID);
		
		JLabel CTInvoTit = new JLabel("\u767C\u7968\u62AC\u982D\uFF1A"+CTIT);
		CTInvoTit.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoTit.setBounds(28, 106, 200, 15);
		contentPane.add(CTInvoTit);
		
		JLabel CTInvoAddr = new JLabel("\u5BA2\u6236\u767C\u7968\u5730\u5740\uFF1A"+CTIA);
		CTInvoAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTInvoAddr.setBounds(28, 131, 636, 15);
		contentPane.add(CTInvoAddr);
		
		JLabel CTMMAddr = new JLabel("\u8ACB\u6B3E\u5730\u5740\uFF1A"+CTMMA);
		CTMMAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTMMAddr.setBounds(28, 156, 636, 15);
		contentPane.add(CTMMAddr);
		
		JLabel CTDelAddr = new JLabel("\u9001\u8CA8\u5730\u5740\uFF1A"+CTDA);
		CTDelAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDelAddr.setBounds(28, 181, 636, 15);
		contentPane.add(CTDelAddr);
		
		JLabel CTRecPhone = new JLabel("\u6536\u8CA8\u96FB\u8A71\uFF1A"+CTRP);
		CTRecPhone.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecPhone.setBounds(238, 106, 202, 15);
		contentPane.add(CTRecPhone);
		
		JLabel CTRecName = new JLabel("\u6536\u8CA8\u4EBA\uFF1A"+CTRN);
		CTRecName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTRecName.setBounds(450, 106, 175, 15);
		contentPane.add(CTRecName);
		
		JLabel CTFounDate = new JLabel("\u6210\u7ACB\u65E5\u671F\uFF1A"+CTFD);
		CTFounDate.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTFounDate.setBounds(28, 231, 200, 15);
		contentPane.add(CTFounDate);
		
		JLabel CTBusiArea = new JLabel("\u71DF\u696D\u5834\u6240\uFF1A"+string);
		CTBusiArea.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBusiArea.setBounds(238, 227, 186, 15);
		contentPane.add(CTBusiArea);
		
		JLabel CTComType = new JLabel("\u516C\u53F8\u578B\u614B\uFF1A"+string2);
		CTComType.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTComType.setBounds(28, 256, 269, 15);
		contentPane.add(CTComType);
		
		JLabel CTConpName1 = new JLabel("\u806F\u7D61\u4EBA1\uFF1A"+CTCN1);
		CTConpName1.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName1.setBounds(28, 206, 200, 15);
		contentPane.add(CTConpName1);
		
		JLabel CTConpName2 = new JLabel("\u806F\u7D61\u4EBA2\uFF1A"+CTCN2);
		CTConpName2.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName2.setBounds(249, 206, 175, 15);
		contentPane.add(CTConpName2);
		
		JLabel CTConpName3 = new JLabel("\u806F\u7D61\u4EBA3\uFF1A"+CTCN3);
		CTConpName3.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTConpName3.setBounds(450, 206, 203, 15);
		contentPane.add(CTConpName3);
		
		JLabel CTPUC = new JLabel("\u5BE6\u6536\u8CC7\u672C\u984D\uFF1A"+string3);
		CTPUC.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPUC.setBounds(28, 281, 269, 15);
		contentPane.add(CTPUC);
		
		JLabel CTTurnLast = new JLabel("\u4E0A\u5E74\u5EA6\u71DF\u696D\u984D\uFF1A"+string4);
		CTTurnLast.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTTurnLast.setBounds(28, 306, 250, 15);
		contentPane.add(CTTurnLast);
		
		JLabel CTBank = new JLabel("\u4E3B\u8981\u5F80\u4F86\u9280\u884C/\u5206\u884C\uFF1A"+CTB);
		CTBank.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBank.setBounds(28, 331, 339, 15);
		contentPane.add(CTBank);
		
		JLabel CTDAcco = new JLabel("\u7532\u5B58\u5E33\u865F\uFF1A"+CTDAc);
		CTDAcco.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTDAcco.setBounds(380, 331, 284, 15);
		contentPane.add(CTDAcco);
		
		JLabel CTBankName = new JLabel("\u6236\u540D\uFF1A"+CTBN);
		CTBankName.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTBankName.setBounds(28, 356, 250, 15);
		contentPane.add(CTBankName);
		
		JLabel CTSDelReq = new JLabel("\u5BA2\u6236\u7279\u6B8A\u4EA4\u8CA8\u8981\u6C42\uFF1A"+CTSDR);
		CTSDelReq.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTSDelReq.setBounds(288, 356, 376, 15);
		contentPane.add(CTSDelReq);
		
		JLabel CTPayCond = new JLabel("\u4ED8\u6B3E\u689D\u4EF6\uFF1A"+string7);
		CTPayCond.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayCond.setBounds(28, 381, 625, 15);
		contentPane.add(CTPayCond);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("標楷體", Font.ITALIC, 16));
		label_1.setBounds(97, 557, 156, 15);
		contentPane.add(label_1);
		
		JLabel CTPayMeth = new JLabel("\u4ED8\u6B3E\u65B9\u5F0F\uFF1A"+string5+Other1);
		CTPayMeth.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTPayMeth.setBounds(28, 406, 348, 15);
		contentPane.add(CTPayMeth);
		
		
		JLabel lblNewLabel = new JLabel("\u8ACB\u6B3E\u65B9\u5F0F\uFF1A"+string6+Other2);
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 431, 242, 15);
		contentPane.add(lblNewLabel);
		
		JLabel build = new JLabel("\u5BA2\u6236\u8CA0\u8CAC\u4EBA\uFF1A"+CTPIC);
		build.setFont(new Font("標楷體", Font.PLAIN, 16));
		build.setBounds(380, 456, 200, 15);
		contentPane.add(build);
		
		JLabel CTAddr = new JLabel("\u5BA2\u6236\u5730\u5740\uFF1A"+CTAd);
		CTAddr.setFont(new Font("標楷體", Font.PLAIN, 16));
		CTAddr.setBounds(28, 456, 339, 15);
		contentPane.add(CTAddr);
		
		JButton cencel = new JButton("\u53D6\u6D88");
		cencel.setFont(new Font("標楷體", Font.PLAIN, 16));
		cencel.setBounds(437, 501, 87, 23);
		contentPane.add(cencel);
		cencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clone.setVisible(true);
				dispose();
				
				
			}
		});
		
		final Statement statement;
			
		JButton confirmAdd = new JButton("\u78BA\u5B9A\u65B0\u589E");
		confirmAdd.setFont(new Font("標楷體", Font.PLAIN, 16));
		confirmAdd.setBounds(534, 501, 121, 23);
		contentPane.add(confirmAdd);

		
		confirmAdd.addActionListener(new ActionListener() {
			
			public int getMax(String CTA,String CTA_Num){
				Statement statement;
				ResultSet rs = null;
				int Max=0;
				int isUpdate = 0;
						try{
						        statement = cc.createStatement();
								rs = statement.executeQuery("SELECT "+CTA_Num+" FROM "+CTA+" Order By "+CTA_Num+" ASC");
								
								
								//if(!rs.next()){System.out.println("ABmax"+i+": "+ABmax[i]);}
								while(rs.next()){
									Max=Integer.parseInt(rs.getObject(1).toString());						
									System.out.println("Max: "+Max);  //看Max的變化	
								
								}
								Max=Max+1;
								System.out.println("-----------------------");
								System.out.println("Max: "+Max);
								 //conn.close();
								 
								 
								 
							  }catch(SQLException sqlException){
					        sqlException.printStackTrace();
					      }
						return Max;
						
			}	
						
			public void actionPerformed(ActionEvent e){
				Statement statement;
				int isUpdate = 0;

					try {
						//System.out.println("連接成功");
						statement = cc.createStatement();
						try{
					        //System.out.println("123");
							isUpdate = statement.executeUpdate("INSERT into CTA(CTA_Appt,CTA_Appt_EID,CTA_ApplyDate,CTA_Check,CTA_Reject)VALUES('"+CTAA+"','"+CTAEID+"','"+date+"','"+0+"','"+""+"')");
							int max = getMax("CTA","CTA_Num")-1;
							isUpdate += statement.executeUpdate("INSERT into CT(CTA_Num,CTName,CTChiAbbr,CTPhone,CTFax,CTIndCate,CTTaxID,CTInvoTit,CTRecPhone,CTRecName,CTInvoAddr,CTMMAddr,CTDelAddr,CTConpName1,CTConpName2,CTConpName3,CTFounDate,CTBank,CTDAcco,CTBankName,CTSDelReq,CTPIC,CTBusiArea,CTComType,CTPUC,CTTurnLast,CTPayMeth,CTMMMeth,CTAddr,CTPayCond)VALUES('"+max+"','"+CTNa+"','"+CTCA+"','"+CTP+"','"+CTF+"','"+CTIC+"','"+CTTID+"','"+CTIT+"','"+CTRP+"','"+CTRN+"','"+CTIA+"','"+CTMMA+"','"+CTDA+"','"+CTCN1+"','"+CTCN2+"','"+CTCN3+"','"+CTFD+"','"+CTB+"','"+CTDAc+"','"+CTBN+"','"+CTSDR+"','"+CTPIC+"','"+string+"','"+string2+"','"+string3+"','"+string4+"','"+string5+"','"+string6+"','"+CTAd+"','"+string7+"')");
						}catch(SQLException sqlException){
							sqlException.printStackTrace();
						}
						
						if(isUpdate>0)
							JOptionPane.showMessageDialog(PreviewCustomer.this, "新增資料成功 !","新增成功",JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(PreviewCustomer.this, "新增資料失敗 !","新增失敗",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException SQLe) {
						SQLe.printStackTrace();
					}
			}
		});
		
   }
	private String getDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd ");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}
}