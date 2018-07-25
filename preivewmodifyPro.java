package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class preivewmodifyPro extends JFrame {

	private JPanel contentPane;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preivewmodifyPro frame = new preivewmodifyPro(null,null, "", null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password2 
	 * @param username2 
	 * @param url2 
	 */
	public preivewmodifyPro(final Connection conn,modifyProData MPD, final String OPN, final String[] proData, String URL, String UN, String PW) {
		setResizable(false);
		final modifyProData Hidding = MPD;

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		JLabel ProPrice = new JLabel("產品出售價格：" + proData[3]);
		ProPrice.setBounds(121, 223, 279, 30);
		contentPane.add(ProPrice);
		ProPrice.setFont(new Font("標楷體", Font.PLAIN, 20));

		JLabel ProSafeIno = new JLabel("安全庫存量：" + proData[2]);
		ProSafeIno.setBounds(121, 183, 279, 30);
		contentPane.add(ProSafeIno);
		ProSafeIno.setFont(new Font("標楷體", Font.PLAIN, 20));

		JLabel ProName = new JLabel("產品名稱：" + proData[1]);
		ProName.setBounds(121, 143, 279, 30);
		contentPane.add(ProName);
		ProName.setFont(new Font("標楷體", Font.PLAIN, 20));

		JLabel ProModel = new JLabel("產品型號：" + proData[0]);
		ProModel.setBounds(121, 103, 279, 30);
		contentPane.add(ProModel);
		ProModel.setFont(new Font("標楷體", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("\u4FEE\u6539\u7522\u54C1\u57FA\u672C\u8CC7\u6599");
		label_1.setBounds(111, 52, 313, 40);
		contentPane.add(label_1);
		label_1.setFont(new Font("標楷體", Font.PLAIN, 37));

		JLabel label = new JLabel("洪陞實業有限公司");
		label.setBounds(382, 15, 165, 40);
		contentPane.add(label);
		label.setFont(new Font("標楷體", Font.ITALIC, 20));

		JButton back = new JButton("返回");
		back.setBounds(278, 269, 101, 43);
		contentPane.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hidding.setVisible(true);
				dispose();
			}
		});
		back.setFont(new Font("標楷體", Font.PLAIN, 20));

		JButton button = new JButton("確定修改");
		button.setBounds(398, 270, 115, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Connection conn;
				Statement statement;
				int Update = 0;

				try {
					//conn = DriverManager.getConnection(url, username, password);//接資料庫
					//System.out.println("連接成功");
					statement = con.createStatement();

					int safenum = Integer.parseInt(proData[2]); // 把安全庫存量的
																// 字串轉成數字
					int sp = Integer.parseInt(proData[3]);

					Update = statement.executeUpdate("UPDATE Prod SET ProdModel='" + proData[0] + "',ProdName='"
							+ proData[1] + "',ProdSafeInve='" + safenum + "',ProdSellPrice='" + sp
							+ "' WHERE ProdModel='" + OPN + "';"); //更新

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}

				if (Update > 0) {
					JOptionPane.showMessageDialog(preivewmodifyPro.this, "修改產品資料成功 !", "修改成功", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(preivewmodifyPro.this, "修改產品資料失敗 !", "修改失敗", JOptionPane.WARNING_MESSAGE);
					int result = JOptionPane.showConfirmDialog(preivewmodifyPro.this, "確定要結束程式嗎?", "確認訊息", JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			}
		});
		button.setFont(new Font("標楷體", Font.PLAIN, 20));

	}

}
