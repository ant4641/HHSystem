package HHSystem;
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

public class PreviewModifyAM extends JFrame {
	private JPanel contentPane;
	static String url = "";
	static String username = ""; 
	static String password = "";
	Connection con ;
	// JLabel CTNum ;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PreviewModifyAM frame = new PreviewModifyAM(null,0,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param pW 
	 * @param uN 
	 * @param uRL 
	 * 
	 * @param string
	 */
	public PreviewModifyAM(Connection conn,final ModifyAM clone,final int AMNum, final String[] AMC,final String URL,final String UN,final String PW) {

		setResizable(false);
		setTitle("\u9810\u89BD\u4FEE\u6539\u7DAD\u4FEE\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500, 200, 607, 632);
		contentPane = new JPanel();
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
		label.setBounds(412, 11, 159, 33);
		contentPane.add(label);

		JLabel label_4 = new JLabel("\u4E0D\u826F\u72C0\u6CC1/\u7DAD\u4FEE\u5167\u5BB9");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(36, 167, 525, 33);
		contentPane.add(label_4);
		
		JLabel label_7 = new JLabel("\u7DAD\u4FEE\u5831\u544A\u66F8");
		label_7.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_7.setBounds(241, 10, 119, 33);
		contentPane.add(label_7);
		
		JLabel label_9 = new JLabel("\u6545\u969C\u539F\u56E0:");
		label_9.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_9.setBounds(28, 229, 97, 20);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("\u6AA2\u67E5\u5167\u5BB9:");
		label_10.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_10.setBounds(28, 297, 97, 20);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("\u8655\u7406:");
		label_11.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_11.setBounds(67, 373, 58, 20);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("\u5EFA\u8B70:");
		label_12.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_12.setBounds(67, 443, 58, 20);
		contentPane.add(label_12);
		
		JLabel AM_CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31:"+AMC[1]);
		AM_CTName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_CTName_lb.setBounds(36, 95, 225, 20);
		contentPane.add(AM_CTName_lb);

		JLabel AM_ConpName_lb = new JLabel("\u806F\u7D61\u4EBA:"+AMC[2]);
		AM_ConpName_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ConpName_lb.setBounds(314, 95, 247, 20);
		contentPane.add(AM_ConpName_lb);

		JLabel ProdSN_lb = new JLabel("\u7522\u54C1\u5E8F\u865F:"+AMC[4]);
		ProdSN_lb.setHorizontalAlignment(SwingConstants.LEFT);
		ProdSN_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdSN_lb.setBounds(295, 137, 259, 20);
		contentPane.add(ProdSN_lb);

		JLabel AM_EID_lb = new JLabel("\u8CA0\u8CAC\u54E1\u5DE5\u7DE8\u865F:"+AMC[0]);
		AM_EID_lb.setHorizontalAlignment(SwingConstants.LEFT);
		AM_EID_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_EID_lb.setBounds(255, 58, 306, 20);
		contentPane.add(AM_EID_lb);

		JLabel AM_ProdModel_lb = new JLabel("\u7522\u54C1\u578B\u865F:"+AMC[3]);
		AM_ProdModel_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ProdModel_lb.setBounds(36, 137, 225, 20);
		contentPane.add(AM_ProdModel_lb);

		JLabel AM_Num_lb = new JLabel("\u7DAD\u4FEE\u55AE\u865F:"+AMNum);
		AM_Num_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Num_lb.setBounds(36, 58, 225, 20);
		contentPane.add(AM_Num_lb);

		JLabel AM_Fee_lb = new JLabel("\u7DAD\u4FEE+\u5DE5\u6642\u8CBB:"+AMC[7]);
		AM_Fee_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Fee_lb.setBounds(67, 488, 252, 20);
		contentPane.add(AM_Fee_lb);

		final JTextPane AM_MReason_tp = new JTextPane();
		AM_MReason_tp.setEditable(false);
		AM_MReason_tp.setText(AMC[5]);
		// AM_MContent_tp.setBounds(122, 214, 434, 53);
		JScrollPane SP = new JScrollPane(AM_MReason_tp);
		SP.setBounds(135, 214, 434, 53);
		contentPane.add(SP);
		// contentPane.add(AM_MContent_tp);

		final JTextPane AM_CkeckCon_tp = new JTextPane();
		AM_CkeckCon_tp.setEditable(false);
		AM_CkeckCon_tp.setText(AMC[6]);
		// AM_CkeckCon_tp.setBounds(122, 282, 434, 53);
		JScrollPane SP2 = new JScrollPane(AM_CkeckCon_tp);
		SP2.setBounds(135, 282, 434, 53);
		contentPane.add(SP2);
		// contentPane.add(AM_CkeckCon_tp);

		JTextPane AM_Handle_tp = new JTextPane();
		AM_Handle_tp.setEditable(false);
		AM_Handle_tp.setText(AMC[8]);
		// AM_Handle_tp.setBounds(122, 350, 434, 53);
		JScrollPane SP3 = new JScrollPane(AM_Handle_tp);
		SP3.setBounds(135, 350, 434, 53);
		contentPane.add(SP3);
		// contentPane.add(AM_Handle_tp);

		JTextPane AM_Suggest_tp = new JTextPane();
		AM_Suggest_tp.setEditable(false);
		AM_Suggest_tp.setText(AMC[9]);
		// AM_Suggest_tp.setBounds(122, 423, 434, 53);
		JScrollPane SP4 = new JScrollPane(AM_Suggest_tp);
		SP4.setBounds(135, 423, 434, 53);
		contentPane.add(SP4);
		// contentPane.add(AM_Suggest_tp);



		JButton back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("標楷體", Font.PLAIN, 16));
		back.setBounds(377, 550, 87, 33);
		contentPane.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clone.setVisible(true);
				dispose();
			}
		});
		
		JButton confirmEdit = new JButton("\u78BA\u5B9A\u4FEE\u6539");
		confirmEdit.setFont(new Font("標楷體", Font.PLAIN, 16));
		confirmEdit.setBounds(474, 550, 109, 33);
		contentPane.add(confirmEdit);
		
		JLabel RepairState_lb = new JLabel("\u7DAD\u4FEE\u72C0\u614B:"+AMC[10]);
		RepairState_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		RepairState_lb.setBounds(319, 488, 252, 20);
		contentPane.add(RepairState_lb);
		
		confirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//按鈕監聽
				
				switch(AMC[10]){
				case "未處理" :{
					AMC[10]="0";
					break;}
				case "已處理" :{
					AMC[10]="1";
					break;}
				case "已收款" :{
					AMC[10]="2";
					break;}
				}
				System.out.println("AMC[10]: "+AMC[10]);
				
				//Connection conn;
				Statement statement;
				int isUpdate = 0;
				//更新資料
				try {
					//conn = DriverManager.getConnection(url,username,password);
					//System.out.println("連接成功");
					statement = con.createStatement();
						
					isUpdate = statement.executeUpdate("UPDATE AM SET AM_CTName='"+AMC[1]+"',AM_EID='"+AMC[0]+"',"
							+ "AM_ConpName='"+AMC[2]+"',AM_ProdModel='"+AMC[3]+"',AM_ProdSN='"+AMC[4]+"',"
							+ "AM_MReason='"+AMC[5]+"',AM_CkeckCon='"+AMC[6]+"',AM_Handle='"+AMC[8]+"',AM_Suggest='"+AMC[9]+"',AM_Fee='"+AMC[7]+"',AM_Check='"+AMC[10]+"' "
							+ "WHERE AM_Num='"+AMNum+"' ");
						 
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}

				if (isUpdate > 0)
					JOptionPane.showMessageDialog(PreviewModifyAM.this, "新增資料成功 !", "新增成功", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(PreviewModifyAM.this, "新增資料失敗 !", "新增失敗", JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}

}

