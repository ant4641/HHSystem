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

public class previewED extends JFrame {

	private JPanel contentPane;
	private previewED clone = this;
	private JTextField E_id;
	private JTextField pricetext;
	private JTextField E_name;
	private JTextField E_sex;
	private JTextField E_cell;
	private JTextField E_bir;
	private JTextField E_password;
	static String url="";
	static String username="";
	static String password="";
	private String res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewED frame = new previewED(null,null, " ", " ", "", null, null, null, null, "", null, null, null,"","","");
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
	public previewED(final Connection conn, newED ed, final String boe, final String E_id, final String E_name, final String E_phone,
			final String E_cell, final String E_add, final String E_bir, final String E_sex, final String E_password,
			final String efun, final String essn,String URL,String  UN,String  PW) {
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		final newED noFrame = ed;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("預覽新增人事資料");
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel company = new JLabel("洪陞實務有限公司");
		company.setFont(new Font("標楷體", Font.ITALIC, 20));
		company.setBounds(371, 22, 178, 29);
		contentPane.add(company);
		// System.out.println(company);

		JLabel E_ID = new JLabel("員工編號 :" + E_id);
		E_ID.setFont(new Font("標楷體", Font.PLAIN, 20));
		E_ID.setBounds(321, 84, 253, 29);
		contentPane.add(E_ID);
		// System.out.println(E_ID);

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
		System.out.println(E_cell1);

		JButton new_ED = new JButton("確定新增");
		new_ED.setFont(new Font("標楷體", Font.PLAIN, 20));
		new_ED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(boe);
				Statement statement;
				int isUpdate = 0;
				int empty = 0;
				// boe,E_id, E_name, E_phone, E_cell, final String,, ,,,
				/*
				 * if("".equals(boe.getText().trim())){empty++;}
				 * if("".equals(E_id.getText().trim())){empty++;}
				 * if("".equals(E_name.trim())){empty++;}
				 * if("".equals(E_phone.getText().trim())){empty++;}
				 * if("".equals( E_cell.getText().trim())){empty++;}
				 * if("".equals( E_add.getText().trim())){empty++;}
				 * if("".equals( E_bir.getText().trim())){empty++;}
				 * if("".equals( E_sex.getText().trim())){empty++;}
				 * if("".equals( E_password.getText().trim())){empty++;}
				 * if("".equals( efun.getText().trim())){empty++;} if("".equals(
				 * essn.getText().trim())){empty++;}
				 * 
				 * if(empty==0){ if(pronum<20){ int b = pronum;
				 * pro[b].setVisible(true); mod[b].setVisible(true);
				 * qua[b].setVisible(true); pronum++; } }else{
				 * JOptionPane.showMessageDialog(null, "請先填完已有空格再新增", "警告",
				 * JOptionPane.INFORMATION_MESSAGE); } } }
				 */
				
					try {
						System.out.println("連接成功");
						statement = conn.createStatement();
						try {// boe,E_id, E_name, E_phone, E_cell, final String
								// E_add,E_bir, E_sex,E_password,efun,essn
							System.out.println(boe);
							System.out.println(E_id);
							System.out.println(E_name);
							System.out.println(E_phone);
							System.out.println(E_cell);
							System.out.println(E_add);
							System.out.println(E_bir);
							System.out.println(E_sex);
							System.out.println(E_password);
							System.out.println(efun);
							System.out.println(essn);
							isUpdate = statement.executeUpdate(
									"INSERT into Employee(EID,ESTA,EPass,EPost,EName,ESSN,ESex,EBirDate,EAddr,EPhone,ECPhone)VALUES('"
											+ E_id + "','" + boe + "','" + E_password + "','" + efun + "','" + E_name
											+ "','" + essn + "','" + E_sex + "','" + E_bir + "','" + E_add + "','"
											+ E_phone + "','" + E_cell + "')");
							System.out.println("Success");
						} catch (SQLException sqlException) {
							sqlException.printStackTrace();
						}
						if (isUpdate > 0) {
							System.out.println("noUpdate: " + isUpdate);

							JOptionPane.showMessageDialog(previewED.this, "新增人事資料成功 !", "新增成功", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(previewED.this, "新增人事資料失敗 !生日格式為'yyyy-mm-dd'", "新增失敗", JOptionPane.WARNING_MESSAGE);
							int result = JOptionPane.showConfirmDialog(previewED.this, "確定要結束程式嗎?", "確認訊息",
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
		new_ED.setBounds(97, 515, 126, 33);
		contentPane.add(new_ED);

		JButton back_ED = new JButton("返回新增");
		back_ED.setFont(new Font("標楷體", Font.PLAIN, 20));
		back_ED.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				noFrame.setVisible(true);
				dispose();
			}
		});
		back_ED.setBounds(305, 515, 126, 33);
		contentPane.add(back_ED);

		if (boe == "1") {
			res = "老闆";
		} else
			res = "員工";

		JLabel bosEmp = new JLabel(res);
		bosEmp.setFont(new Font("標楷體", Font.PLAIN, 20));
		bosEmp.setBounds(10, 82, 167, 31);
		contentPane.add(bosEmp);
		// System.out.println(res);
	}
}