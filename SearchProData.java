package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;

public class SearchProData extends JFrame {

	private JPanel contentPane;
	private JTextField ProModel_T;
	private JTextField ProName_T;
	private JTable table;
	static String tabn="Prod";
	static String col="ProdModel";
	static String con="";
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchProData frame = new SearchProData(null,"","",1, "", "", "");
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
	 * @param password 
	 * @param username 
	 * @param uRL 
	 */
	public SearchProData(final Connection conn, String col2, String con2,final int EST, String URL, String UN, String PW) {
		super("查詢產品基本資料");
		setResizable(false);
		if((!col2.equals(""))&&(!con2.equals(""))){//抓輸入的字串
			col=col2;
			con=con2;
		}
		url=URL;
		username=UN;
		password=PW;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//關閉
		setBounds(100, 100, 747, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label SearchCondition = new Label("搜尋條件：");
		SearchCondition.setBounds(39, 20, 77, 25);
		contentPane.add(SearchCondition);
		
		Label ProdModel = new Label("產品型號：");
		ProdModel.setBounds(39, 74, 77, 25);
		contentPane.add(ProdModel);
		
		Label ProName = new Label("或	產品名稱：");
		ProName.setBounds(262, 74, 97, 25);
		contentPane.add(ProName);
		
		ProModel_T = new JTextField();
		ProModel_T.setBounds(122, 74, 134, 25);
		contentPane.add(ProModel_T);
		ProModel_T.setColumns(10);
		
		ProName_T = new JTextField();
		ProName_T.setBounds(365, 74, 157, 25);
		contentPane.add(ProName_T);
		ProName_T.setColumns(10);
		
		Label HSName = new Label("洪陞實業有限公司");
		HSName.setFont(new Font("Dialog", Font.ITALIC, 24));
		HSName.setBounds(492, 20, 210, 25);
		contentPane.add(HSName);
		
		JButton SearchBtn = new JButton("搜尋");
		SearchBtn.setBounds(536, 72, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ProModel_T.getText().equals("")){    //依照輸入的條件抓符合的資料
					col="ProdName";
					con=ProName_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="ProdModel";
					con=ProModel_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				SearchProData SPD=new SearchProData(conn,col,con,EST,url,username,password);
				SPD.setVisible(true);
				col="ProdModel";
				con="";
				TableDemo clear = new TableDemo(conn,tabn,"SearchProData",url,username,password);
				clear.GetData0(col,con,EST);
				dispose();
			}
		});
		TableDemo demo = new TableDemo(conn,tabn,"SearchProData",url,username,password);
		demo.GetData0(col,con,EST);
	    demo.setLayout(new GridLayout(1, 0));
	    demo.setBounds(31, 153, 671, 330);
	    contentPane.add(demo);
		
	}

}