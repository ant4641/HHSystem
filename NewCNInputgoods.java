package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class NewCNInputgoods extends JFrame {

	private JPanel contentPane;
	Connection con;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JTextField[] pMod=new JTextField[10];
	private JTextField[] pQua=new JTextField[10];
	private JTextField[] pNowIno=new JTextField[10];
	private JTextField InQua;
	static String[] ComData;
	static String[][] ComUnit;
	NewCNInputgoods clone = this;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCNInputgoods frame = new NewCNInputgoods(null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param conn2 
	 * @param password2 
	 * @param username2 
	 * @param uRL2 
	 */
	public NewCNInputgoods(Connection conn, String URL, String UN, String PW) {
		setResizable(false);
		setTitle("\u65B0\u589E\u7D44\u5408\u7522\u54C1\u9032\u8CA8");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 18));
		label.setBounds(466, 10, 155, 40);
		contentPane.add(label);
		
		String[] a={"0","1","2"};
		
		getCom();
		
		final JComboBox ComName = new JComboBox();
		ComName.setFont(new Font("標楷體", Font.PLAIN, 16));
		for(int i=0;i<ComData.length;i++){
			ComName.addItem(ComData[i]);
		}
		ComName.setBounds(155, 74, 158, 31);
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent ie) {
		    	  getUnit(ComName.getSelectedItem().toString());
		    	  for(int i=0 ; i<ComUnit.length;i++){
		    			  pMod[i].setText(ComUnit[i][0]);
		    			  pQua[i].setText(ComUnit[i][1]);
		    			  pNowIno[i].setText(ComUnit[i][2]);
		    		  
		    	  }
		      }
		    };
		ComName.addItemListener(itemListener);
		contentPane.add(ComName);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u7D44\u5408\u7269\u7522\u54C1\u9032\u8CA8");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_1.setBounds(178, 9, 207, 40);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7D44\u5408\u7269\u540D\u7A31\uFF1A");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_2.setBounds(26, 70, 207, 40);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u7D44\u4EF6\u5167\u5BB9\uFF1A");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_3.setBounds(26, 115, 115, 40);
		contentPane.add(label_3);
		
		for(int i=0 ;i<10 ;i++){
		pMod[i] = new JTextField();
		pMod[i].setBounds(155, 165+41*i, 115, 31);
		pMod[i].setColumns(10);
		pMod[i].setEditable(false);
		contentPane.add(pMod[i]);
		}

		for(int i=0 ;i<10 ;i++){
		pQua[i] = new JTextField();
		pQua[i].setColumns(10);
		pQua[i].setBounds(280, 165+41*i, 77, 31);
		pQua[i].setEditable(false);
		contentPane.add(pQua[i]);
		}
		
		for(int i=0 ;i<10 ;i++){
		pNowIno[i] = new JTextField();
		pNowIno[i].setColumns(10);
		pNowIno[i].setBounds(367, 165+41*i,75, 31);
		pNowIno[i].setEditable(false);
		contentPane.add(pNowIno[i]);
		}
		
		JLabel label_4 = new JLabel("\u9032\u8CA8\u6578\u91CF\uFF1A");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_4.setBounds(323, 70, 115, 40);
		contentPane.add(label_4);
		
		InQua = new JTextField();
		InQua.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for(int i=0 ; i<pQua.length;i++){
					if(!pQua[i].getText().equals("")){
						int qq=Integer.parseInt(pQua[i].getText());
						int newqq=Integer.parseInt(InQua.getText())*qq;
						pQua[i].setText(""+newqq);
					}
				}	
			}
		});
		InQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0 ; i<pQua.length;i++){
					if(!pQua[i].getText().equals("")){
						int qq=Integer.parseInt(pQua[i].getText());
						int newqq=Integer.parseInt(InQua.getText())*qq;
						pQua[i].setText(""+newqq);
					}
				}
			}
		});
		InQua.setColumns(10);
		InQua.setBounds(437, 76, 60, 31);
		contentPane.add(InQua);
		
		JLabel label_5 = new JLabel("\u7D44\u4EF6\u540D\u7A31");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_5.setBounds(155, 115, 115, 40);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u9700\u6C42\u91CF");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_6.setBounds(280, 115, 77, 40);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5EAB\u5B58\u91CF");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_7.setBounds(367, 115, 77, 40);
		contentPane.add(label_7);
		
		JLabel lblNewLabel = new JLabel("(\u8F38\u5165\u5F8C\u8ACB\u6309Enter)");
		lblNewLabel.setBounds(466, 112, 115, 15);
		contentPane.add(lblNewLabel);
		
		JButton goAdd = new JButton("\u65B0\u589E");
		goAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//檢查新增數量以及庫存數量
				int check=0;
				if(InQua.getText().equals("")){
					check++;
					JOptionPane.showMessageDialog(NewCNInputgoods.this,"進貨數量不可為空值", "進貨數量錯誤", JOptionPane.WARNING_MESSAGE);  	
				}else{
					int IQ=Integer.parseInt(InQua.getText());
					if(IQ<0 || IQ==0){
						check++;
						JOptionPane.showMessageDialog(NewCNInputgoods.this,"進貨數量不可為小於或等於0", "進貨數量錯誤", JOptionPane.WARNING_MESSAGE);  
					}else {
						for(int i=0 ; i<pQua.length;i++){
							if(!pQua[i].getText().equals("")){
								int pQ=Integer.parseInt(pQua[i].getText());
								int NQ=Integer.parseInt(pNowIno[i].getText());
								if(pQ>NQ){
									check++;
									String m="第 "+(i+1)+" 個組件庫存數量不足";
									JOptionPane.showMessageDialog(NewCNInputgoods.this,m, "庫存警告", JOptionPane.WARNING_MESSAGE);  
								}
							}
						}
					
					}
				}
				
				//數量都沒問題才做新增
				if(check==0){
					//System.out.println("OK ");
					
					System.out.println(ComName.getSelectedItem().toString());
					String CN=ComName.getSelectedItem().toString();
					PreviewNewCNInputgoods PCN=new PreviewNewCNInputgoods(con,clone,CN,InQua.getText(),url,username,password);
					PCN.setAlwaysOnTop(true); 
					PCN.requestFocus();  
					PCN.setVisible(true);
					dispose();
				}else{
					System.out.println("not ");
				}
				
			}
		});
		goAdd.setFont(new Font("標楷體", Font.PLAIN, 20));
		goAdd.setBounds(517, 562, 96, 40);
		contentPane.add(goAdd);

		

	}
	
	public void getCom() {
		Statement statement;
		ResultSet rs = null;
		ResultSetMetaData rsMetaData;
		int rows=0;
		int count=0;
		try {

			con = DriverManager.getConnection(url, username, password);
			//System.out.println("資料庫連結成功");
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT ProdModel FROM Prod Where ProdIsCom ='1'");
			while (rs.next()) {rows++;}
			ComData= new String[rows];
			rs = statement.executeQuery("SELECT ProdModel FROM Prod Where ProdIsCom ='1'");
			while (rs.next()) {
				ComData[count]=rs.getObject(1).toString();
				//System.out.println("ComData"+count+"--"+ComData[count]);
				count++;
			}
			
			//conn.close();
		} catch (SQLException sqlException) {// 資料庫操作發生錯誤
			sqlException.printStackTrace();
		}
	}
	public void getUnit(String CN){
		Statement statement;
		ResultSet rs = null;
		ResultSetMetaData rsMetaData;
		int rows=0;
		int count=0;
		ComUnit=new String[1][1];
		try {

			//conn = DriverManager.getConnection(url, username, password);
			//System.out.println("資料庫連結成功");
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT CNC.CNC_Comp_ProdModel,CNC.CNC_CompQuan,Prod.ProdNowInve FROM CNC,Prod Where Prod.ProdModel=CNC.CNC_Comp_ProdModel AND CNC.CN_Model ='"+CN+"'");
			while (rs.next()) {rows++;}
			ComUnit= new String[rows][3];
			System.out.println("rows: "+rows);
			System.out.println("---------");
			rs = statement.executeQuery("SELECT CNC.CNC_Comp_ProdModel,CNC.CNC_CompQuan,Prod.ProdNowInve FROM CNC,Prod Where Prod.ProdModel=CNC.CNC_Comp_ProdModel AND CNC.CN_Model ='"+CN+"'");
			while (rs.next()) {
				
				for(int i=1 ;i<=3 ;i++){
					//System.out.print(rs.getObject(i)+"\t"); 
					ComUnit[count][i-1]=rs.getObject(i).toString();
					//System.out.println(count+"-"+(i-1)+":"+ComUnit[count][i-1]); 
				}		
				System.out.print(ComUnit[count][0]+"--"+ComUnit[count][1]+"--"+ComUnit[count][2]);
				count++;
				System.out.println("----");
				
			}
			
			//conn.close();
		} catch (SQLException sqlException) {// 資料庫操作發生錯誤
			sqlException.printStackTrace();
		}
	
	}
}
