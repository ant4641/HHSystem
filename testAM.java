package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class testAM extends JFrame {
	static String url = "";
	static String username = ""; 
	static String password = "";
	private JPanel contentPane;
	Connection con ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testAM frame = new testAM(null,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password 
	 * @param username 
	 * @param url 
	 */
	public testAM(Connection conn,final String[] data,final String URL,final String UN,final String PW) {
		setResizable(false);
		setTitle("\u67E5\u770B\u7DAD\u4FEE\u55AE\u5167\u5BB9");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500, 200, 607, 632);
		contentPane = new JPanel();//?容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url = URL;
		username = UN;
		password = PW;
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 18));
		label.setBounds(410, 11, 159, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4E0D\u826F\u72C0\u6CC1/\u7DAD\u4FEE\u5167\u5BB9");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_1.setBounds(34, 167, 525, 33);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7DAD\u4FEE\u5831\u544A\u66F8");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_2.setBounds(239, 10, 119, 33);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6545\u969C\u539F\u56E0:");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(26, 229, 97, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6AA2\u67E5\u5167\u5BB9:");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(26, 297, 97, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8655\u7406:");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_5.setBounds(65, 373, 58, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5EFA\u8B70:");
		label_6.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_6.setBounds(65, 443, 58, 20);
		contentPane.add(label_6);
		
		JLabel AM_Num_lb = new JLabel("\u7DAD\u4FEE\u55AE\u865F:"+data[0]);
		AM_Num_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Num_lb.setBounds(34, 58, 225, 20);
		contentPane.add(AM_Num_lb);
		
		JLabel AM_CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31:"+data[1]);
		AM_CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_CTName_lb.setBounds(34, 95, 225, 20);
		contentPane.add(AM_CTName_lb);
		
		JLabel AM_EID_lb = new JLabel("\u8CA0\u8CAC\u54E1\u5DE5\u7DE8\u865F:"+data[2]);
		AM_EID_lb.setHorizontalAlignment(SwingConstants.LEFT);
		AM_EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_EID_lb.setBounds(253, 58, 306, 20);
		contentPane.add(AM_EID_lb);
		
		JLabel AM_ConpName_lb = new JLabel("\u806F\u7D61\u4EBA:"+data[3]);
		AM_ConpName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ConpName_lb.setBounds(312, 95, 247, 20);
		contentPane.add(AM_ConpName_lb);
		
		JLabel AM_ProdModel_lb = new JLabel("\u7522\u54C1\u578B\u865F:"+data[4]);
		AM_ProdModel_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ProdModel_lb.setBounds(34, 137, 225, 20);
		contentPane.add(AM_ProdModel_lb);
		
		JLabel ProdSN_lb = new JLabel("\u7522\u54C1\u5E8F\u865F:"+data[5]);
		ProdSN_lb.setHorizontalAlignment(SwingConstants.LEFT);
		ProdSN_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdSN_lb.setBounds(293, 137, 259, 20);
		contentPane.add(ProdSN_lb);
		
		final JTextPane AM_MReason_tp = new JTextPane();
		AM_MReason_tp.setEditable(false);
		AM_MReason_tp.setText(data[6]);
		JScrollPane SP = new JScrollPane(AM_MReason_tp);
		SP.setBounds(135, 214, 434, 53);
		contentPane.add(SP);

		final JTextPane AM_CkeckCon_tp = new JTextPane();
		AM_CkeckCon_tp.setEditable(false);
		AM_CkeckCon_tp.setText(data[7]);
		JScrollPane SP2 = new JScrollPane(AM_CkeckCon_tp);
		SP2.setBounds(135, 282, 434, 53);
		contentPane.add(SP2);

		JTextPane AM_Handle_tp = new JTextPane();
		AM_Handle_tp.setEditable(false);//設置選項不能用
		AM_Handle_tp.setText(data[8]);
		JScrollPane SP3 = new JScrollPane(AM_Handle_tp);
		SP3.setBounds(135, 350, 434, 53);
		contentPane.add(SP3);

		JTextPane AM_Suggest_tp = new JTextPane();
		AM_Suggest_tp.setEditable(false);
		AM_Suggest_tp.setText(data[9]);
		JScrollPane SP4 = new JScrollPane(AM_Suggest_tp);
		SP4.setBounds(135, 423, 434, 53);
		contentPane.add(SP4);
	
		JLabel AM_Fee_lb = new JLabel("\u7DAD\u4FEE+\u5DE5\u6642\u8CBB:"+data[10]);
		AM_Fee_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Fee_lb.setBounds(65, 488, 252, 20);
		contentPane.add(AM_Fee_lb);
		
		String state =getState(data[11]);//呼叫方法
		JLabel AM_Check_lb = new JLabel("\u7DAD\u4FEE\u72C0\u614B:"+state);
		AM_Check_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Check_lb.setBounds(317, 488, 252, 20);
		contentPane.add(AM_Check_lb);
		
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("標楷體", Font.PLAIN, 16));
		back.setBounds(375, 550, 87, 33);
		contentPane.add(back);

		JButton goedit_btn = new JButton("\u4FEE\u6539");
		goedit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyAM MAM= new ModifyAM(con,data,URL,UN,PW);
				MAM.setAlwaysOnTop(true); 
				MAM.requestFocus();  
				MAM.setVisible(true);
				dispose();
			}
		});
		goedit_btn.setFont(new Font("標楷體", Font.PLAIN, 16));
		goedit_btn.setBounds(472, 550, 109, 33);
		contentPane.add(goedit_btn);
		
	}
	public String getState(String AMCheck){//判斷狀況
		String check = null;
		switch(AMCheck){
		case "0" :{
			check="未處理";
			break;}
		case "1" :{
			check="已處理";
			break;}
		case "2" :{
			check="已收款";
			break;}
		}
		return check;
	}
}
