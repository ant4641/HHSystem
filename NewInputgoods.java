package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class NewInputgoods extends JFrame {

	private JPanel contentPane;
	private JTextField PO_SRName_T;
	private JTextField PO_PurDate_T;
	private JTable table;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";

	static String tabn="Purchase";
	static String usefunction="NewInputgoods";
	static String col="PO_SRName";
	static String con="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewInputgoods frame = new NewInputgoods(null,"","", "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewInputgoods(final Connection conn,String col2, String con2, String URL, String UN, String PW) {
		setResizable(false);
		setFont(new Font("標楷體", Font.PLAIN, 20));
		setTitle("\u65B0\u589E\u9032\u8CA8");
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		url=URL;
		username=UN;
		password=PW;
		PO_SRName_T = new JTextField();
		PO_SRName_T.setColumns(10);
		PO_SRName_T.setBounds(125, 62, 134, 25);
		contentPane.add(PO_SRName_T);
		
		PO_PurDate_T = new JTextField();
		PO_PurDate_T.setColumns(10);
		PO_PurDate_T.setBounds(401, 64, 134, 25);
		contentPane.add(PO_PurDate_T);
		
		JButton SearchBtn = new JButton("搜尋");
		SearchBtn.setBounds(545, 61, 99, 27);
		contentPane.add(SearchBtn);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PO_PurDate_T.getText().equals("")){
					col="PO_SRName";
					con=PO_SRName_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}else{
					col="PO_PurDate";
					con=PO_PurDate_T.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				}
				NewInputgoods NI=new NewInputgoods(conn,col,con,url,username,password);
				NI.setVisible(true);
				dispose();
			}
		});
		
		final NewInputgoods clone =this; //為新增進貨資料的主畫面
		TableDemo tableDemo = new TableDemo(conn,tabn,usefunction,url,username,password);
		tableDemo.GetData2(col,con,"PO_Check","0");
		tableDemo.setClone(clone);		//用TableDemo時，多一行把第一個畫面設定進去
		tableDemo.setBounds(8, 123, 749, 344);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));
		
		JLabel PO_SRName = new JLabel("\u4F9B\u61C9\u5546\u540D\u7A31\uFF1A");
		PO_SRName.setFont(new Font("標楷體", Font.PLAIN, 20));
		PO_SRName.setBounds(8, 62, 120, 25);
		contentPane.add(PO_SRName);
		
		JLabel PO_PurDate = new JLabel("\u6216 \u63A1\u8CFC\u65E5\u671F\uFF1A");
		PO_PurDate.setFont(new Font("標楷體", Font.PLAIN, 20));
		PO_PurDate.setBounds(270, 64, 134, 25);
		contentPane.add(PO_PurDate);
		
		JLabel lblNewLabel = new JLabel("\u683C\u5F0F:YYYY-MM-DD");
		lblNewLabel.setBounds(401, 92, 134, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 24));
		label.setBounds(543, 26, 214, 25);
		contentPane.add(label);
	}
}
