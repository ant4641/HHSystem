package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newED extends JFrame implements ItemListener {

	private JPanel conpane;
	private JTextField E_id;
	private JTextField E_name;
	private JTextField E_phone;
	private JTextField E_cell;
	private JTextField E_address;
	private JTextField E_bir;
	private JComboBox E_sex;
	private JTextField E_password;
	private JTextField E_fun;
	private JTextField E_ssn;
	private JLabel idCard;
	static String url = "";
	static String username = "";
	static String password = "";
	static int numberOfRows = 0;
	static int numberOfColumns = 0;
	private String[] names;

	newED clone = this;
	Connection con;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	private JCheckBox chckbxBoss = new JCheckBox("BOSS");
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Employee");
	private String column;
	private String res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newED frame = new newED(null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * 
	 * @param conn
	 */
	public newED(final Connection conn, String URL, String UN, String PW) {
		setResizable(false);
		
		url = URL;
		username = UN;
		password = PW;
		con = conn;
		setTitle("\u65B0\u589E\u4EBA\u4E8B\u8CC7\u6599");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
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

		JLabel idCard = new JLabel("員工編號 : " + getED_NO());
		idCard.setFont(new Font("標楷體", Font.PLAIN, 20));
		idCard.setBounds(295, 83, 279, 27);
		conpane.add(idCard);

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
		final newED clone = this;
		JButton eadd = new JButton("新增");
		System.out.println("new11");
		eadd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int empty = 0;
				System.out.println("new");
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				// 取得欄位的文字
				final String id = getED_NO();
				final String name = E_name.getText();
				final String phone = E_phone.getText();
				final String cell = E_cell.getText();
				final String epassword = E_password.getText();
				final String fun = E_fun.getText();
				final String essn = E_ssn.getText();
				final String add = E_address.getText();
				final String bir = E_bir.getText();
				final String sex = E_sex.getSelectedItem().toString();
				final String bosemp = res;
				
				System.out.println(cell);
				// 檢查格式有無錯誤
				try {
					int sta = 0;
					format.parse(bir);
					if ("".equals(id.trim())) {
						empty++;
					}
					if ("".equals(name.trim())) {
						empty++;
					}
					if ("".equals(phone.trim())) {
						empty++;
					}
					if ("".equals(cell.trim())) {
						empty++;
					}
					if ("".equals(epassword.trim())) {
						empty++;
					}
					if ("".equals(fun.toString().trim())) {
						empty++;
					}
					if ("".equals(essn.toString().trim())) {
						empty++;
					}
					if ("".equals(add.toString().trim())) {
						empty++;
					}
					if ("".equals(bir.toString().trim())) {
						empty++;
					}
					if ("".equals(sex.toString().trim())) {
						empty++;
					}
					if ("".equals(bosemp.toString().trim())) {
						empty++;
					}
					if (cell.length() != 10){
						JOptionPane.showMessageDialog(newED.this, "手機長度輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
						sta = 1;
					}
					if (phone.length() < 8 || phone.length() > 10){
						JOptionPane.showMessageDialog(newED.this, "電話長度輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
						sta = 1;
					}
					if (!essn.matches("[a-zA-Z]\\d{9}")){
						JOptionPane.showMessageDialog(newED.this, "身分證輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
						sta = 1;
					}
					else {
						if (checkID(essn) == 1){
							JOptionPane.showMessageDialog(newED.this, "身分證輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
							sta = 1;
						}
						try {
							int testPhone = Integer.parseInt(phone);
						} catch (NumberFormatException n) {
							JOptionPane.showMessageDialog(newED.this, "電話應輸入數字", "警告", JOptionPane.WARNING_MESSAGE);
							sta = 1;
						}
						try {
							int testCell = Integer.parseInt(cell);
							
						} catch (NumberFormatException n) {
							JOptionPane.showMessageDialog(newED.this, "手機應輸入數字", "警告", JOptionPane.WARNING_MESSAGE);
							sta = 1;
						}
						if (empty == 0&& sta==0) {
							previewED ed = new previewED(conn, clone, bosemp, id, name, phone, cell, add, bir, sex,
									epassword, fun, essn, url, username, password);
							ed.setAlwaysOnTop(true); 
							ed.requestFocus();  
							ed.setVisible(true);
							dispose();
							System.out.println("ok");
							
						}
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(newED.this, "輸入錯誤", "警告", JOptionPane.ERROR);
					n.printStackTrace();
				} catch (ParseException e1) {
					
					JOptionPane.showMessageDialog(newED.this, "日期輸入錯誤，請輸入如1996/07/05", "警告", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}

		});
		eadd.setFont(new Font("標楷體", Font.PLAIN, 20));
		eadd.setBounds(206, 530, 110, 37);
		conpane.add(eadd);

		JLabel company = new JLabel("洪陞實務有限公司");
		company.setFont(new Font("標楷體", Font.ITALIC, 25));
		company.setBounds(344, 10, 230, 51);
		conpane.add(company);

		JLabel e_Phone = new JLabel("手機號碼 :");
		e_Phone.setFont(new Font("標楷體", Font.PLAIN, 20));
		e_Phone.setBounds(295, 351, 110, 23);
		conpane.add(e_Phone);

		JLabel password = new JLabel("密碼 :");
		password.setFont(new Font("標楷體", Font.PLAIN, 20));
		password.setBounds(294, 152, 96, 25);
		conpane.add(password);

		E_name = new JTextField();
		E_name.setBounds(120, 154, 124, 25);
		conpane.add(E_name);
		E_name.setColumns(10);

		String[] sex12 = { "女", "男" };// 性別
		// JComboBox sexList = new JComboBox();
		E_sex = new JComboBox(sex12);
		E_sex.setBounds(121, 215, 72, 33);
		conpane.add(E_sex);
		// System.out.println(E_sex);

		E_phone = new JTextField();
		E_phone.setBounds(120, 350, 124, 29);
		conpane.add(E_phone);
		E_phone.setColumns(10);

		E_cell = new JTextField();
		E_cell.setBounds(402, 352, 144, 25);
		conpane.add(E_cell);
		E_cell.setColumns(10);

		E_address = new JTextField();
		E_address.setBounds(120, 436, 426, 25);
		conpane.add(E_address);
		E_address.setColumns(10);

		E_bir = new JTextField();
		E_bir.setBounds(381, 219, 165, 25);
		conpane.add(E_bir);
		E_bir.setColumns(10);

		E_password = new JTextField();
		E_password.setBounds(382, 154, 164, 25);
		conpane.add(E_password);
		E_password.setColumns(10);

		E_fun = new JTextField();// 職稱
		E_fun.setBounds(120, 283, 124, 27);
		conpane.add(E_fun);
		E_fun.setColumns(10);

		JLabel Ess = new JLabel("身分證字號 : ");// 身分
		Ess.setFont(new Font("標楷體", Font.PLAIN, 20));
		Ess.setBounds(295, 283, 160, 27);
		conpane.add(Ess);

		E_ssn = new JTextField();// 身分
		E_ssn.setBounds(431, 283, 115, 27);
		conpane.add(E_ssn);
		E_ssn.setColumns(10);

		ButtonGroup chkbox = new ButtonGroup();
		chkbox.add(chckbxBoss);
		chkbox.add(chckbxNewCheckBox);

		chckbxBoss.setFont(new Font("標楷體", Font.PLAIN, 20));
		chckbxBoss.setBounds(13, 83, 95, 27);
		conpane.add(chckbxBoss);
		chckbxBoss.addItemListener(this);

		chckbxNewCheckBox.setFont(new Font("標楷體", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(130, 83, 130, 23);
		conpane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(this);

	}

	public String getED_NO() { // 給予新員工編號
		SimpleDateFormat sdFormat = new SimpleDateFormat("mmddyyyy");
		Date d = new Date();
		String strDate = sdFormat.format(d);
		numberOfRows = 0;

		int num = 1;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT EID FROM Employee Where EID LIKE '%" + strDate + "%' ORDER BY EID");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.printf("%s\t", rs.getObject(i));
				}
				System.out.println();
				numberOfRows++;
			}
			if (numberOfRows != 0) {
				names = new String[numberOfRows];
				int count = 0;
				rs = statement.executeQuery("SELECT EID FROM Employee Where EID LIKE '%" + strDate + "%'ORDER BY EID");
				while (rs.next()) {
					for (int i = 1; i <= numberOfColumns; i++) {
						names[count] = rs.getObject(i).toString();
					}
					count++;
				}
				String strnum = names[count - 1].substring(8);
				num = Integer.parseInt(strnum);
				num++;
				String text = String.format("%03d", num);
				strDate = strDate + text;
			} else {
				String text = String.format("%03d", num);
				strDate = strDate + text;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strDate;

	}

	public String getDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}

	int checkID(String id) {
		id.toUpperCase(); // 轉大寫
		char first = id.charAt(0); // 取出第一個字母

		/* A-Z的對應數字 */
		int idum[] = { 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30,
				31, 33 };

		/*
		 * 轉成11碼的字串,'A'=65； substring:從index:1開始取String
		 */
		id = idum[first - 'A'] + id.substring(1);

		/* 把第一碼放到sum中,'0'=48 */
		int sum = id.charAt(0) - '0';

		/* 取2-10的總合 */
		for (int i = 1; i < 10; i++)
			sum += id.charAt(i) * (10 - i);

		/* 10-加總的尾數 = 第11碼 */
		int checksum = (10 - (sum % 10)) % 10;
		if (checksum == id.charAt(10) - '0')
			return 0;
		else
			return 1;
	}

	public void itemStateChanged(ItemEvent event) {
		int chkbox = event.getStateChange();
		// int res = 0;
		if (chkbox == ItemEvent.SELECTED) {

			if (event.getItem() == chckbxBoss) {
				column = chckbxBoss.getText();
				res = "1";
			}

			if (event.getItem() == chckbxNewCheckBox) {
				column = chckbxNewCheckBox.getText();
				res = "2";
			}
			System.out.println(res);

		}

	}

}