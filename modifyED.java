package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.text.ParseException;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.util.Date;

public class modifyED extends JFrame implements ItemListener {

	private JPanel conpane;
	private JTextField E_name;
	private JTextField E_phone;
	private JTextField E_cell;
	private JTextField E_address;
	private JTextField E_bir;
	private JComboBox E_sex;
	private JTextField E_password;
	private JTextField E_fun;
	private JTextField E_ssn;
	private static Connection conn;
	private JLabel idCard;
	static String url="";
	static String username="";
	static String password="";
	static int numberOfRows = 0;
	static int numberOfColumns = 0;
	private String[] names;
	private String column;
	private String res;
	Connection cc;
	public modifyED(Connection conn,Object data[], String ID, String Name,String URL,String  UN,String  PW) {
		setResizable(false);
		cc=conn;
		url=URL;
		username=UN;
		password=PW;
		setTitle("修改人事資料");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 574);
		conpane = new JPanel();
		conpane.setForeground(Color.BLACK);
		conpane.setBackground(SystemColor.control);
		conpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(conpane);
		conpane.setLayout(null);

		JLabel ename = new JLabel("姓名 : ");
		ename.setFont(new Font("標楷體", Font.PLAIN, 20));
		ename.setBounds(13, 152, 121, 25);
		conpane.add(ename);

		JLabel esex = new JLabel("性別 : ");
		esex.setFont(new Font("標楷體", Font.PLAIN, 20));
		esex.setBounds(13, 213, 95, 33);
		conpane.add(esex);

		JLabel fuction = new JLabel("員工職務 : ");
		fuction.setFont(new Font("標楷體", Font.PLAIN, 20));
		fuction.setBounds(10, 285, 124, 25);
		conpane.add(fuction);

		JLabel ephone = new JLabel("聯絡電話 : ");
		ephone.setFont(new Font("標楷體", Font.PLAIN, 20));
		ephone.setBounds(10, 346, 110, 33);
		conpane.add(ephone);

		JLabel eaddress = new JLabel("聯絡地址 :  ");
		eaddress.setFont(new Font("標楷體", Font.PLAIN, 20));
		eaddress.setBounds(10, 430, 124, 33);
		conpane.add(eaddress);

		JLabel ebirth = new JLabel("生日 : ");
		ebirth.setFont(new Font("標楷體", Font.PLAIN, 20));
		ebirth.setBounds(295, 214, 95, 30);
		conpane.add(ebirth);
		final modifyED clone = this;
		JButton eadd = new JButton("修改");

		eadd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int empty = 0;
				System.out.println("modify");
				String bosemp, name, phone, cell, epassword, fun, essn, add, bir, sex;

				name = E_name.getText();
				phone = E_phone.getText();
				cell = E_cell.getText();
				epassword = E_password.getText();
				fun = E_fun.getText();
				essn = E_ssn.getText();
				add = E_address.getText();
				bir = E_bir.getText();
				sex = E_sex.getSelectedItem().toString();
				bosemp = res;

				try {

					if ("".equals(name.trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "名字不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(phone.trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "員工電話不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(cell.trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "手機號碼不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(epassword.trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "密碼不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(fun.toString().trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "員工職稱不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(essn.toString().trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "身分證字號不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(add.toString().trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "聯絡地址不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(bir.toString().trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "生日不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(sex.toString().trim())) {
						empty++;
						JOptionPane.showMessageDialog(modifyED.this, "性別不可空白", "警告", JOptionPane.WARNING_MESSAGE);
					}

					if ("".equals(bosemp.toString().trim())) {
						empty++;
					}

					if (empty == 0) {
						preModifyED ed = new preModifyED(conn,clone, bosemp, name, phone, cell, add, bir, sex, epassword,
								fun, essn,url,username,password);
						ed.setAlwaysOnTop(true); 
						ed.requestFocus();  
						ed.setVisible(true);
						dispose();
						System.out.println("ok");
					}

				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(modifyED.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		eadd.setFont(new Font("標楷體", Font.PLAIN, 20));
		eadd.setBounds(134, 492, 110, 37);
		conpane.add(eadd);

		JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("標楷體", Font.ITALIC, 25));
		company.setBounds(367, 1, 230, 51);
		conpane.add(company);

		JLabel e_Phone = new JLabel("手機號碼 :");
		e_Phone.setFont(new Font("標楷體", Font.PLAIN, 20));
		e_Phone.setBounds(295, 351, 110, 23);
		conpane.add(e_Phone);

		JLabel password = new JLabel("密碼 :");
		password.setFont(new Font("標楷體", Font.PLAIN, 20));
		password.setBounds(294, 152, 96, 25);
		conpane.add(password);

		JLabel Ess = new JLabel("身分證字號 : ");// 身分
		Ess.setFont(new Font("標楷體", Font.PLAIN, 20));
		Ess.setBounds(295, 283, 160, 27);
		conpane.add(Ess);

		final String[] ED = new String[10];
		E_name = new JTextField();
		E_name.setBounds(120, 154, 124, 25);
		conpane.add(E_name);
		E_name.setColumns(10);
		E_name.setText((String) data[4]);
		System.out.println(E_name);

		String[] sex12 = { "女", "男" };// 性別

		E_sex = new JComboBox(sex12);
		E_sex.setBounds(121, 215, 72, 33);
		conpane.add(E_sex);
		E_sex.setSelectedItem((String) data[6]);

		E_phone = new JTextField();
		E_phone.setBounds(120, 350, 124, 29);
		conpane.add(E_phone);
		E_phone.setColumns(10);
		E_phone.setText((String) data[9]);

		E_cell = new JTextField();
		E_cell.setBounds(402, 352, 144, 25);
		conpane.add(E_cell);
		E_cell.setColumns(10);
		E_cell.setText((String) data[10]);

		E_address = new JTextField();
		E_address.setBounds(120, 436, 426, 25);
		conpane.add(E_address);
		E_address.setColumns(10);
		E_address.setText((String) data[8]);

		E_bir = new JTextField();
		E_bir.setBounds(381, 219, 165, 25);
		conpane.add(E_bir);
		E_bir.setColumns(10);
		E_bir.setText((String) data[7]);

		E_password = new JTextField();
		E_password.setBounds(382, 154, 164, 25);
		conpane.add(E_password);
		E_password.setColumns(10);
		E_password.setText((String) data[2]);

		E_fun = new JTextField();// 職稱
		E_fun.setBounds(120, 283, 124, 27);
		conpane.add(E_fun);
		E_fun.setColumns(10);
		E_fun.setText((String) data[3]);

		E_ssn = new JTextField();// 身分
		E_ssn.setBounds(431, 283, 115, 27);
		conpane.add(E_ssn);
		E_ssn.setColumns(10);
		E_ssn.setText((String) data[5]);

		if (data[1] == "1") {
			res = "老闆";
		} else
			res = "員工";
		JLabel lblNewbosemp = new JLabel(res);
		lblNewbosemp.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblNewbosemp.setBounds(13, 87, 144, 27);
		conpane.add(lblNewbosemp);

		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4EBA\u4E8B\u8CC7\u6599");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 37));
		lblNewLabel.setBounds(170, 46, 321, 46);
		conpane.add(lblNewLabel);
		
		JButton back = new JButton("\u8FD4\u56DE\u4E0A\u9801");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		back.setFont(new Font("標楷體", Font.PLAIN, 20));
		back.setBounds(307, 492, 121, 37);
		conpane.add(back);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}
}