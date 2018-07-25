package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JComboBox.*;

import javax.swing.*;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	String Dep1[] = {"請選擇","採購單","進貨","訂單","出貨","毛利","請款資料","維修單","庫存","供應商基本資料","客戶基本資料","組合表","退件","人事資料","審核"};//14
	String Dep2[] = {"請選擇","採購單","進貨","訂單","出貨","毛利","請款資料","維修單","庫存","供應商基本資料","客戶基本資料","組合表","退件"};//13
	//-----------------------------------------採購單1
	JButton newPur = new JButton("\u65b0\u589e\u63a1\u8cfc\u55ae");
	JButton serPur = new JButton("\u67e5\u8a62\u63a1\u8cfc\u55ae");
	//-----------------------------------------進貨2
	JButton newPro = new JButton("\u65b0\u589e\u7522\u54c1\u8cc7\u6599");
	JButton serPro = new JButton("\u67e5\u8a62\u7522\u54c1\u8cc7\u6599");
	JButton newIG = new JButton("\u65b0\u589e\u9032\u8ca8\u8cc7\u6599");
	JButton newCNIG = new JButton("\u65b0\u589e\u7d44\u5408\u7522\u54c1");
	//-----------------------------------------訂單3
	JButton newOrder = new JButton("\u65B0\u589E\u8A02\u55AE");
	JButton serOrder = new JButton("\u67e5\u8a62\u8a02\u55ae");
	//-----------------------------------------出貨4
	JButton newSM = new JButton("\u65b0\u589e\u51fa\u8ca8\u55ae");
	JButton serSM = new JButton("\u67e5\u8a62\u51fa\u8ca8\u55ae");
	//-----------------------------------------毛利5
	JButton serGP = new JButton("\u67e5\u8a62\u6bdb\u5229");
	//-----------------------------------------請款資料6
	JButton newMMO = new JButton("\u65b0\u589e\u8acb\u6b3e\u8cc7\u6599");
	JButton serMMO = new JButton("\u67e5\u8a62\u8acb\u6b3e\u8a18\u9304");
	//-----------------------------------------維修單7
	JButton newAM = new JButton("\u65b0\u589e\u7dad\u4fee\u55ae\u8cc7\u6599");
	JButton serAM = new JButton("\u67e5\u8a62\u7dad\u4fee\u55ae\u8cc7\u6599");
	//-----------------------------------------庫存8
	JButton serProStock = new JButton("\u67e5\u8a62\u5eab\u5b58");
	//-----------------------------------------供應商9
	JButton newSR = new JButton("\u65b0\u589e\u4f9b\u61c9\u5546\u8cc7\u6599");
	JButton serSRD = new JButton("\u67e5\u8a62\u4f9b\u61c9\u5546\u8cc7\u6599");
	//-----------------------------------------客戶10
	JButton newCT = new JButton("\u65b0\u589e\u5ba2\u6236\u8cc7\u6599");
	JButton serCT = new JButton("\u67e5\u8a62\u5ba2\u6236\u8cc7\u6599");
	//-----------------------------------------組合表11
	JButton serCN = new JButton("\u67e5\u8a62\u7d44\u5408\u8868\u516c\u5f0f");
	JButton newAF = new JButton("\u65b0\u589e\u7d44\u5408\u8868\u516c\u5f0f");
	//-----------------------------------------退件12
	JButton receiveORR = new JButton("\u63a5\u6536\u8a02\u55ae\u9000\u4ef6");
	JButton receiveSRR = new JButton("\u63a5\u6536\u4F9B\u61C9\u5546\u9000\u4ef6");
	JButton receiveCTR = new JButton("\u63a5\u6536\u5ba2\u6236\u9000\u4ef6");
	//-----------------------------------------人事資料13
	JButton newED = new JButton("\u65b0\u589e\u4eba\u4e8b\u8cc7\u6599");
	JButton serED = new JButton("\u67e5\u8a62\u4eba\u4e8b\u8cc7\u6599");
	//-----------------------------------------審核14
	JButton viewCCTA = new JButton("\u5BE9\u6838\u5BA2\u6236\u8CC7\u6599");
	JButton viewCSRA = new JButton("\u5BE9\u6838\u4F9B\u61C9\u5546\u8CC7\u6599");
	JButton viewCOR = new JButton("\u5BE9\u6838\u8A02\u55AE\u8CC7\u6599");
	JComboBox chDep;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(null,"","",1,"","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param conn 
	 */
	public MainMenu(Connection conn, String EI,String EN,int Es,final String URL,final String DBIP,final String username,final String password){
		setResizable(false);
		getContentPane().setLayout(null);
		
		final int EST=Es;
		final String Ei=EI;
		final String En=EN;
		
		setTitle("\u4E3B\u756B\u9762");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(EST==1)chDep = new JComboBox(Dep1);  //員工等級為1，表管理者。顯示Dep1清單
		if(EST==2)chDep = new JComboBox(Dep2);  //員工等級為2，表員工。顯示Dep2清單
		
			chDep.setFont(new Font("標楷體", Font.PLAIN, 16));
			chDep.setBounds(10, 48, 160, 30);
			contentPane.add(chDep);
			
			chDep.addActionListener( new  ActionListener() {   
			      public void  actionPerformed(ActionEvent e) {
			    	  //-----------------------採購單1
			    	  newPur.setVisible(false);	
			    	  serPur.setVisible(false);	
			    	  //-----------------------進貨2
			    	  newPro.setVisible(false);
			    	  serPro.setVisible(false);
			    	  newIG.setVisible(false);
			    	  newCNIG.setVisible(false);
			    	  //-----------------------訂單3
			    	  newOrder.setVisible(false);
			    	  serOrder.setVisible(false);
			    	  //-----------------------出貨4
			    	  newSM.setVisible(false);
			    	  serSM.setVisible(false);
			    	  //-----------------------毛利5
			    	  serGP.setVisible(false);
			    	  //-----------------------請款資料6
			    	  newMMO.setVisible(false);
			    	  serMMO.setVisible(false);
			    	  //-----------------------維修單7
			    	  newAM.setVisible(false);
			    	  serAM.setVisible(false);
			    	  //-----------------------庫存8
			    	  serProStock.setVisible(false);
			    	  //-----------------------供應商9
			    	  newSR.setVisible(false);
			    	  serSRD.setVisible(false);
			    	  //-----------------------客戶10
			    	  newCT.setVisible(false);
			    	  serCT.setVisible(false);
			    	  //-----------------------組合表11
			    	  serCN.setVisible(false);
			    	  newAF.setVisible(false);
			    	  //-----------------------退件12
			    	  receiveORR.setVisible(false);
			    	  receiveSRR.setVisible(false);
			    	  receiveCTR.setVisible(false);
			    	  //-----------------------人事資料13
			    	  newED.setVisible(false);
			    	  serED.setVisible(false);
			    	  //-----------------------審核14
			    	  viewCCTA.setVisible(false);
			    	  viewCSRA.setVisible(false);
			    	  viewCOR.setVisible(false);
			    	int sel=((JComboBox)e.getSource()).getSelectedIndex();  //用此變數接使用者的功能選項
			        System.out.println( "Selected index="  + ((JComboBox)e.getSource()).getSelectedIndex());
			        if(sel==1){//採購單			//如果選到採購單，就把採購單的相關功能打開
			        	newPur.setVisible(true);
			        	serPur.setVisible(true);	
			        }
			        if(sel==2){//進貨
			        	newPro.setVisible(true);
			        	serPro.setVisible(true);
			        	newIG.setVisible(true);
			        	newCNIG.setVisible(true);
			        }
			        if(sel==3){//訂單
			        	newOrder.setVisible(true);
			        	serOrder.setVisible(true);
			        }
			        if(sel==4){//出貨
			        	newSM.setVisible(true);
				    	serSM.setVisible(true);
			        }
			        if(sel==5){//毛利
			        	serGP.setVisible(true);
			        }
			        if(sel==6){//請款資料
			        	newMMO.setVisible(true);
			        	serMMO.setVisible(true);
			        }
			        if(sel==7){//維修單
			        	newAM.setVisible(true);
			        	serAM.setVisible(true);
			        }
			        if(sel==8){//庫存
			        	serProStock.setVisible(true);
			        }
			        if(sel==9){//供應商
			        	newSR.setVisible(true);
			        	serSRD.setVisible(true);
			        }
			        if(sel==10){//客戶
			        	newCT.setVisible(true);
			        	serCT.setVisible(true);
			        }
			        if(sel==11){//組合表
			        	serCN.setVisible(true);
			        	if(EST==1)newAF.setVisible(true);
			        }
			        if(sel==12){//退件
			        	receiveORR.setVisible(true);
			        	receiveSRR.setVisible(true);
				    	receiveCTR.setVisible(true);
			        }
			        if(sel==13){//人事資料
			        	newED.setVisible(true);
			        	serED.setVisible(true);
			        }
			        if(sel==14){//審核
			        	viewCCTA.setVisible(true);
			        	viewCSRA.setVisible(true);
			        	viewCOR.setVisible(true);	
			        }
			      }
				  }); 
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 22));
		label.setBounds(533, 0, 227, 50);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("登入者："+EN+"  員工編號："+EI);
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 367, 15);
		contentPane.add(lblNewLabel);

		//-----------------------------------------採購單1  //創建採購單的視窗物件
		newPur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPurchase npur = new NewPurchase(conn,URL,username,password);
				npur.setAlwaysOnTop(true); 
				npur.requestFocus();       
				npur.setVisible(true);
			}
		});
		newPur.setFont(new Font("標楷體", Font.PLAIN, 16));
		newPur.setBounds(193, 48, 160, 30);
		contentPane.add(newPur);
		newPur.setVisible(false);	
		
		serPur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchPurchase spc = new SearchPurchase(conn,"","",URL,username,password);
				spc.setAlwaysOnTop(true); 
				spc.requestFocus();  
				spc.setVisible(true);
			}
		});
		serPur.setFont(new Font("標楷體", Font.PLAIN, 16));
		serPur.setBounds(193, 81, 160, 30);
		contentPane.add(serPur);
		serPur.setVisible(false);	
		//-----------------------------------------進貨2
		newPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewProData npd = new NewProData(conn,URL,username,password);
				npd.setAlwaysOnTop(true); 
				npd.requestFocus();  
				npd.setVisible(true);
			}
		});
		newPro.setFont(new Font("標楷體", Font.PLAIN, 16));
		newPro.setBounds(193, 48, 160, 30);
		contentPane.add(newPro);
		newPro.setVisible(false);	
		
		serPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchProData spd = new SearchProData(conn,"","",EST,URL,username,password);
				spd.setAlwaysOnTop(true); 
				spd.requestFocus();  
				spd.setVisible(true);
			}
		});
		serPro.setFont(new Font("標楷體", Font.PLAIN, 16));
		serPro.setBounds(193, 81, 160, 30);
		contentPane.add(serPro);
		serPro.setVisible(false);
		
		newIG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewInputgoods nig = new NewInputgoods(conn,"","",URL,username,password);
				nig.setAlwaysOnTop(true); 
				nig.requestFocus();  
				nig.setVisible(true);
			}
		});
		newIG.setFont(new Font("標楷體", Font.PLAIN, 16));
		newIG.setBounds(193, 114, 160, 30);
		contentPane.add(newIG);
		newIG.setVisible(false);
		
		newCNIG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewCNInputgoods ncnig = new NewCNInputgoods(conn,URL,username,password);
				ncnig.setAlwaysOnTop(true); 
				ncnig.requestFocus();  
				ncnig.setVisible(true);
			}
		});
		newCNIG.setFont(new Font("標楷體", Font.PLAIN, 16));
		newCNIG.setBounds(193, 147, 160, 30);
		contentPane.add(newCNIG);
		newCNIG.setVisible(false);
		//-----------------------------------------訂單3
		newOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				neworder newo = new neworder(conn,Ei,URL,username,password);
				newo.setAlwaysOnTop(true); 
				newo.requestFocus();  
				newo.setVisible(true);
			}
		});
		newOrder.setFont(new Font("標楷體", Font.PLAIN, 16));
		newOrder.setBounds(193, 48, 160, 30);
		contentPane.add(newOrder);
		newOrder.setVisible(false);
		
		serOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchOrder so = new SearchOrder(conn,"","",URL,username,password);
				so.setAlwaysOnTop(true); 
				so.requestFocus();  
				so.setVisible(true);
			}
		});
		serOrder.setFont(new Font("標楷體", Font.PLAIN, 16));
		serOrder.setBounds(193, 81, 160, 30);
		contentPane.add(serOrder);
		serOrder.setVisible(false);
		//-----------------------------------------出貨4
		newSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewShipment nesm = new NewShipment(conn,"","",URL,username,password);
				nesm.setAlwaysOnTop(true); 
				nesm.requestFocus();  
				nesm.setVisible(true);
			}
		});
		newSM.setFont(new Font("標楷體", Font.PLAIN, 16));
		newSM.setBounds(193, 48, 160, 30);
		contentPane.add(newSM);
		newSM.setVisible(false);
		
		serSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchSM ssm = new SearchSM(conn,"","","",URL,username,password);
				ssm.setAlwaysOnTop(true); 
				ssm.requestFocus();  
				ssm.setVisible(true);
			}
		});
		serSM.setFont(new Font("標楷體", Font.PLAIN, 16));
		serSM.setBounds(193, 81, 160, 30);
		contentPane.add(serSM);
  	  	serSM.setVisible(false);
		//-----------------------------------------毛利5
  	  	serGP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchGrossProfit segp = new SearchGrossProfit(conn,"","","",URL,username,password);
				segp.setAlwaysOnTop(true); 
				segp.requestFocus();  
				segp.setVisible(true);
			}
		});
  	  	serGP.setFont(new Font("標楷體", Font.PLAIN, 16));
  	  	serGP.setBounds(193, 48, 160, 30);
		contentPane.add(serGP);
		serGP.setVisible(false);
		//-----------------------------------------請款資料6
  	  	newMMO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewMMO nemmo = new NewMMO(conn,"","",URL,username,password);
				nemmo.setAlwaysOnTop(true); 
				nemmo.requestFocus();  
				nemmo.setVisible(true);
			}
		});
  	  	newMMO.setFont(new Font("標楷體", Font.PLAIN, 16));
  	  	newMMO.setBounds(193, 48, 160, 30);
		contentPane.add(newMMO);
  	  	newMMO.setVisible(false);
  	  	
  	  	serMMO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchMMO smmo = new SearchMMO(conn,"","",URL,username,password);
				smmo.setAlwaysOnTop(true); 
				smmo.requestFocus();  
				smmo.setVisible(true);
			}
		});
  	  	serMMO.setFont(new Font("標楷體", Font.PLAIN, 16));
  	  	serMMO.setBounds(193, 81, 160, 30);
		contentPane.add(serMMO);
  	  	serMMO.setVisible(false);
		//-----------------------------------------維修單7
  	  	newAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewAM neam = new NewAM(conn,URL,username,password);
				neam.setAlwaysOnTop(true); 
				neam.requestFocus();  
				neam.setVisible(true);
			}
		});
  	  	newAM.setFont(new Font("標楷體", Font.PLAIN, 16));
  	  	newAM.setBounds(193, 48, 160, 30);
		contentPane.add(newAM);
		newAM.setVisible(false);
		
		serAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchAM sam = new SearchAM(conn,"","",URL,username,password);
				sam.setAlwaysOnTop(true); 
				sam.requestFocus();  
				sam.setVisible(true);
			}
		});
		serAM.setFont(new Font("標楷體", Font.PLAIN, 16));
		serAM.setBounds(193, 81, 160, 30);
		contentPane.add(serAM);
		serAM.setVisible(false);
		//-----------------------------------------庫存8
		serProStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchProStock sps = new SearchProStock(conn,"","",URL,username,password);
				sps.setAlwaysOnTop(true); 
				sps.requestFocus();  
				sps.setVisible(true);
			}
		});
		serProStock.setFont(new Font("標楷體", Font.PLAIN, 16));
		serProStock.setBounds(193, 48, 160, 30);
		contentPane.add(serProStock);
		serProStock.setVisible(false);
		
		//-----------------------------------------供應商9
		newSR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewSRData nesrd = new NewSRData(conn,En,Ei,URL,username,password);
				nesrd.setAlwaysOnTop(true); 
				nesrd.requestFocus();  
				nesrd.setVisible(true);
			}
		});
		newSR.setFont(new Font("標楷體", Font.PLAIN, 16));
		newSR.setBounds(193, 48, 160, 30);
		contentPane.add(newSR);
		newSR.setVisible(false);
		
		serSRD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchSRData ssrd = new SearchSRData(conn,"","",EST,URL,username,password);
				ssrd.setAlwaysOnTop(true); 
				ssrd.requestFocus();  
				ssrd.setVisible(true);
			}
		});
		serSRD.setFont(new Font("標楷體", Font.PLAIN, 16));
		serSRD.setBounds(193, 81, 160, 30);
		contentPane.add(serSRD);
		serSRD.setVisible(false);
		//-----------------------------------------客戶10
		newCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewCustomer nct = new NewCustomer(conn,Ei,En,URL,username,password);
				nct.setAlwaysOnTop(true); 
				nct.requestFocus();  
				nct.setVisible(true);
			}
		});
		newCT.setFont(new Font("標楷體", Font.PLAIN, 16));
		newCT.setBounds(193, 48, 160, 30);
		contentPane.add(newCT);
		newCT.setVisible(false);
		
		serCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchClient sct = new SearchClient(conn,"","",EST,URL,username,password);
				sct.setAlwaysOnTop(true); 
				sct.requestFocus();  
				sct.setVisible(true);
			}
		});
		serCT.setFont(new Font("標楷體", Font.PLAIN, 16));
		serCT.setBounds(193, 81, 160, 30);
		contentPane.add(serCT);
		serCT.setVisible(false);
		//-----------------------------------------組合表11
		serCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchCN scn = new SearchCN(conn,"","",URL,username,password);
				scn.setAlwaysOnTop(true); 
				scn.requestFocus();  
				scn.setVisible(true);
			}
		});
		serCN.setFont(new Font("標楷體", Font.PLAIN, 16));
		serCN.setBounds(193, 48, 160, 30);
		contentPane.add(serCN);
		serCN.setVisible(false);
		
		newAF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addfmalu afm = new addfmalu(conn,URL,username,password);
				afm.setAlwaysOnTop(true); 
				afm.requestFocus();  
				afm.setVisible(true);
			}
		});
		newAF.setFont(new Font("標楷體", Font.PLAIN, 16));
		newAF.setBounds(193, 81, 160, 30);
		contentPane.add(newAF);
		newAF.setVisible(false);
		//-----------------------------------------退件12
		receiveORR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receiveORReturn rorr = new receiveORReturn(conn,Ei,URL,username,password);
				rorr.setAlwaysOnTop(true); 
				rorr.requestFocus();  
				rorr.setVisible(true);
			}
		});
		receiveORR.setFont(new Font("標楷體", Font.PLAIN, 16));
		receiveORR.setBounds(193, 48, 160, 30);
		contentPane.add(receiveORR);
		receiveORR.setVisible(false);
		
		receiveSRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receiveSRReturn rsrr = new receiveSRReturn(conn,Ei,URL,username,password);
				rsrr.setAlwaysOnTop(true); 
				rsrr.requestFocus();  
				rsrr.setVisible(true);
			}
		});
		receiveSRR.setFont(new Font("標楷體", Font.PLAIN, 16));
		receiveSRR.setBounds(193, 81, 160, 30);
		contentPane.add(receiveSRR);
		receiveSRR.setVisible(false);
		
		receiveCTR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receiveCTReturn rctr = new receiveCTReturn(conn,Ei,URL,username,password);
				rctr.setAlwaysOnTop(true); 
				rctr.requestFocus();  
				rctr.setVisible(true);
			}
		});
		receiveCTR.setFont(new Font("標楷體", Font.PLAIN, 16));
		receiveCTR.setBounds(193, 114, 160, 30);
		contentPane.add(receiveCTR);
		receiveCTR.setVisible(false);
		//-----------------------------------------人事資料13
		newED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newED need = new newED(conn,URL,username,password);
				need.setAlwaysOnTop(true); 
				need.requestFocus();  
				need.setVisible(true);
			}
		});
		newED.setFont(new Font("標楷體", Font.PLAIN, 16));
		newED.setBounds(193, 48, 160, 30);
		contentPane.add(newED);
		newED.setVisible(false);
		
		serED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchEmployee se  = new SearchEmployee(conn,"","",URL,username,password);
				se.setAlwaysOnTop(true); 
				se.requestFocus();  
				se.setVisible(true);
			}
		});
		serED.setFont(new Font("標楷體", Font.PLAIN, 16));
		serED.setBounds(193, 81, 160, 30);
		contentPane.add(serED);
		serED.setVisible(false);
		//-----------------------------------------審核14
		viewCCTA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewCheckCTA vcc = new viewCheckCTA(conn,"","",URL,username,password);
				vcc.setAlwaysOnTop(true); 
				vcc.requestFocus();  
				vcc.setVisible(true);
			}
		});
		viewCCTA.setFont(new Font("標楷體", Font.PLAIN, 16));
		viewCCTA.setBounds(193, 48, 160, 30);
		contentPane.add(viewCCTA);
		viewCCTA.setVisible(false);
		
		viewCSRA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewCheckSRA vsra = new viewCheckSRA(conn,"","",URL,username,password);
				vsra.setAlwaysOnTop(true); 
				vsra.requestFocus();  
				vsra.setVisible(true);
			}
		});
		viewCSRA.setFont(new Font("標楷體", Font.PLAIN, 16));
		viewCSRA.setBounds(193, 81, 160, 30);
		contentPane.add(viewCSRA);
		viewCSRA.setVisible(false);
		
		viewCOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewCheckOR vor = new viewCheckOR(conn,"","",URL,username,password);
				vor.setAlwaysOnTop(true); 
				vor.requestFocus();  
				vor.setVisible(true);
			}
		});
		viewCOR.setFont(new Font("標楷體", Font.PLAIN, 16));
		viewCOR.setBounds(193, 114, 160, 30);
		contentPane.add(viewCOR);
		viewCOR.setVisible(false);
		
	  JButton Logout = new JButton("\u767B\u51FA");
	  Logout.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  		Login LI = new Login(Ei,DBIP); 
	  		LI.setVisible(true);
	  		try{
	  		conn.close();
	  		System.exit(0);
	  		}catch (SQLException sqlException){
	  			sqlException.printStackTrace();
	  		}
	  		dispose();
	  	}
	  });
	  Logout.setFont(new Font("標楷體", Font.PLAIN, 16));
	  Logout.setBounds(10, 439, 87, 23);
	  contentPane.add(Logout);
	}
}
	