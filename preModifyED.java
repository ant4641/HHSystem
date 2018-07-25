package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class preModifyED extends JFrame {

	private JPanel contentPane;
	private preModifyED clone = this;
	private JTextField E_id;
	private JTextField pricetext;
	private JTextField E_name;
	private JTextField E_sex;
	private JTextField E_cell;
	private JTextField E_bir;
	private JTextField E_password;
	private String res;
	static String url="";
	static String username="";
	static String password="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preModifyED frame = new preModifyED(null,null, "", "", null, null, null, null, "", null, null, null,"","","");
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
	public preModifyED(Connection conn, modifyED mod, final String boe, final String E_name, final String E_phone, final String E_cell,
			final String E_add, final String E_bir, final String E_sex, final String E_password, final String efun,
			final String essn,String URL,String  UN,String  PW) {
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		setTitle("\u9810\u89BD\u4FEE\u6539\u4EBA\u4E8B\u8CC7\u6599");
		// System.out.println("OK" + boe);
		final modifyED noFrame = mod;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel company = new JLabel("洪陞實務有限公司");
		company.setFont(new Font("標楷體", Font.ITALIC, 20));
		company.setBounds(406, 0, 178, 29);
		contentPane.add(company);
		// System.out.println(company);

		/*
		 * JLabel E_ID = new JLabel("員工編號 :" + E_id); E_ID.setFont(new
		 * Font("標楷體", Font.PLAIN, 20)); E_ID.setBounds(321, 83, 253, 29);
		 * contentPane.add(E_ID);
		 */

		// System.out.println(E_ID);
		if (boe == "老闆") {
			res = "1";
		} else
			res = "2";
		System.out.println("2017" + res);
		JLabel bosEmp = new JLabel(boe);
		bosEmp.setFont(new Font("標楷體", Font.PLAIN, 20));
		bosEmp.setBounds(10, 82, 167, 31);
		contentPane.add(bosEmp);
		System.out.println(res);

		JLabel E_name1 = new JLabel("姓名 :" + E_name);
		E_name1.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_name1.setBounds(10, 141, 281, 29);
		contentPane.add(E_name1);
		// System.out.println(E_name1);

		JLabel E_Sex = new JLabel("性別 :" + E_sex);
		E_Sex.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_Sex.setBounds(10, 201, 167, 29);
		contentPane.add(E_Sex);
		// System.out.println(E_Sex);

		JLabel E_fun = new JLabel("員工職稱 :" + efun);
		E_fun.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_fun.setBounds(10, 263, 235, 29);
		contentPane.add(E_fun);
		// System.out.println(E_fun);

		JLabel Ephone = new JLabel("連絡電話 :" + E_phone);
		Ephone.setFont(new Font("標楷體", Font.PLAIN, 20));
		Ephone.setBounds(10, 331, 213, 29);
		contentPane.add(Ephone);
		// System.out.println(Ephone);

		JLabel E_addre = new JLabel("聯絡地址 :" + E_add);
		E_addre.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_addre.setBounds(10, 403, 526, 29);
		contentPane.add(E_addre);
		// System.out.println(E_addre);
		JLabel E_passed = new JLabel("密碼 :" + E_password);
		E_passed.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_passed.setBounds(322, 141, 227, 29);
		contentPane.add(E_passed);
		// System.out.println(E_passed);
		JLabel E_BD = new JLabel("生日 :" + E_bir);
		E_BD.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_BD.setBounds(322, 203, 227, 24);
		contentPane.add(E_BD);
		// System.out.println(E_BD);
		JLabel E_ssn = new JLabel("身分證字號 :" + essn);
		E_ssn.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_ssn.setBounds(322, 263, 227, 29);
		contentPane.add(E_ssn);
		// System.out.println(E_ssn);

		JLabel E_cell1 = new JLabel("手機號碼 :" + E_cell);
		E_cell1.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_cell1.setBounds(322, 331, 214, 29);
		contentPane.add(E_cell1);
		// System.out.println(E_cell1);

		JButton new_ED = new JButton("確定修改");
		new_ED.setFont(new Font("標楷體", Font.PLAIN, 20));
		new_ED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(boe);
				Connection conn;
				Statement statement;
				int isUpdate = 0;
				int empty = 0;

				
					try {
						conn = DriverManager.getConnection(url,username,password);
						System.out.println("連接成功");
						statement = conn.createStatement();
						try {
							isUpdate = statement.executeUpdate("UPDATE Employee SET EPass ='" + E_password
									+ "',EPost = '" + efun + "',EName='" + E_name + "',ESSN = '" + essn + "', ESex = '"
									+ E_sex + "',EBirDate = '" + E_bir + "',EAddr = '" + E_add + "',EPhone = '"
									+ E_phone + "',ECPhone = '" + E_cell + "' WHERE EID = 'U0331' LIMIT 3");

							System.out.println("Success");
						} catch (SQLException sqlException) {
							sqlException.printStackTrace();
						}
						if (isUpdate > 0) {
							System.out.println("noUpdate: " + isUpdate);
							JOptionPane.showMessageDialog(preModifyED.this, "修改人事資料成功 !", "修改成功", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(preModifyED.this, "修改人事資料失敗 !'", "修改失敗", JOptionPane.WARNING_MESSAGE);
							int result = JOptionPane.showConfirmDialog(preModifyED.this, "確定要結束程式嗎?", "確認訊息",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								System.exit(0);
							}

						}
					} catch (SQLException SQLe) {
						SQLe.printStackTrace();
					}
				

			}
		});
		new_ED.setBounds(322, 508, 126, 33);
		contentPane.add(new_ED);

		JButton back_ED = new JButton("返回修改");
		back_ED.setFont(new Font("標楷體", Font.PLAIN, 20));
		back_ED.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				noFrame.setVisible(true);
				dispose();
			}
		});
		back_ED.setBounds(101, 508, 126, 33);
		contentPane.add(back_ED);
		
		JLabel lblNewLabel = new JLabel("\u9810\u89BD\u4FEE\u6539\u4EBA\u4E8B\u8CC7\u6599");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 37));
		lblNewLabel.setBounds(131, 32, 341, 40);
		contentPane.add(lblNewLabel);

	}
}
