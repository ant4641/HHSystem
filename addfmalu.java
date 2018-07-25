package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class addfmalu extends JFrame {

	private JPanel contentPane3;
	private JTextField nametext;
	private JTextField pricetext;
	private JTextField CN_name1[] = new JTextField[10];// �s��
	private JTextField quantity1[] = new JTextField[10];// �ƶq
	private JTextField C_Modle1[] = new JTextField[10];// ��
	private JTextField CN_aver[] = new JTextField[10];
	static int connum = 1;
	static String url="";
	static String username="";
	static String password="";
	static int numberOfRows = 0;
	static int numberOfColumns = 0;
	Connection cc;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	private String[] names;
	private JTextField pricetext_1;// �զX���s��;
	private JTextField cc_model;
	private JTextField abText;
	String model1;
	String no_Number;
	String cost;
	private JTextField C_averC;

	public static void main(Connection cc,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addfmalu frame = new addfmalu(null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public addfmalu(Connection conn,String URL,String  UN,String  PW) {
		setResizable(false);
		cc=conn;
		url=URL;
		username=UN;
		password=PW;
		setBackground(Color.BLACK);
		setTitle("�s�W�զX������");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 900, 694);
		contentPane3 = new JPanel();
		contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane3);
		contentPane3.setLayout(null);

		JLabel company = new JLabel("�x����~�������q");
		company.setFont(new Font("�з���", Font.ITALIC, 26));
		company.setBounds(610, 18, 226, 40);
		contentPane3.add(company);

		no_Number = getfmalu_NO();

		JLabel price = new JLabel("�զX�����:");
		price.setFont(new Font("�з���", Font.PLAIN, 20));
		price.setBounds(309, 131, 148, 46);
		contentPane3.add(price);

		pricetext_1 = new JTextField();// ���
		pricetext_1.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent arg0) {
				if (!pricetext_1.getText().equals("") && !C_averC.getText().equals("")) {
					int price = Integer.parseInt(pricetext_1.getText());
					int average = Integer.parseInt(C_averC.getText());
					if (price < average) {
						JOptionPane.showMessageDialog(addfmalu.this, "�`�N : �զX���~����p��զ�����������", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		pricetext_1.setFont(new Font("�з���", Font.PLAIN, 20));
		pricetext_1.setBounds(441, 138, 127, 33);
		contentPane3.add(pricetext_1);
		pricetext_1.setColumns(10);

		JLabel name = new JLabel("�զX���W��:");
		name.setFont(new Font("�з���", Font.PLAIN, 20));
		name.setBounds(10, 82, 110, 33);
		contentPane3.add(name);

		nametext = new JTextField();
		nametext.setFont(new Font("�з���", Font.PLAIN, 20));
		nametext.setBounds(167, 82, 127, 33);
		contentPane3.add(nametext);
		nametext.setColumns(10);

		JLabel cn_name = new JLabel("�զ����W��");
		cn_name.setFont(new Font("�з���", Font.PLAIN, 20));
		cn_name.setBounds(10, 201, 127, 40);
		contentPane3.add(cn_name);

		final JLabel C_Modle = new JLabel("�զ�������");
		C_Modle.setFont(new Font("�з���", Font.PLAIN, 20));
		C_Modle.setBounds(182, 205, 106, 33);
		contentPane3.add(C_Modle);

		final JLabel quan = new JLabel("�զ��ݨD�ƶq");
		quan.setFont(new Font("�з���", Font.PLAIN, 20));
		quan.setBounds(478, 205, 134, 33);
		contentPane3.add(quan);

		for (int i = 0; i < 10; i++) {// �ƶq
			quantity1[i] = new JTextField();
			quantity1[i].setBounds(478, 245 + 40 * i, 130, 33);
			quantity1[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane3.add(quantity1[i]);
		}

		for (int i = 0; i < 10; i++) {
			CN_name1[i] = new JTextField();
			CN_name1[i].setBounds(10, 245 + 40 * i, 106, 33);
			CN_name1[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane3.add(CN_name1[i]);
			CN_name1[i].setColumns(10);
			CN_name1[i].setEditable(false);
		}

		for (int i = 0; i < 10; i++) {
			final int k = i;
			String ave;
			C_Modle1[i] = new JTextField();
			C_Modle1[i].setBounds(182, 245 + 40 * i, 106, 33);
			C_Modle1[i].addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if (!C_Modle1[k].getText().equals("")) {
						try {
							statement = cc.createStatement();
							rs = statement.executeQuery(
									"SELECT * FROM Prod Where ProdModel =  '" + C_Modle1[k].getText() + "'");

							if (rs.next()) {
								CN_name1[k].setText(rs.getString("ProdName"));
								int intstr = getAvePrice(C_Modle1[k].getText());
								String str = Integer.toString(intstr);
								// System.out.println(str);
								CN_aver[k].setText(str);
							} else {
								JOptionPane.showMessageDialog(addfmalu.this, "�d�L����", "ĵ�i", JOptionPane.WARNING_MESSAGE);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			C_Modle1[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane3.add(C_Modle1[i]);
			C_Modle1[i].setColumns(10);
		}
		
		for (int i = 0; i < 10; i++) {// ��������
			CN_aver[i] = new JTextField();
			CN_aver[i].setBounds(348, 245 + 40 * i, 96, 33);
			CN_aver[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane3.add(CN_aver[i]);
			CN_aver[i].setColumns(10);
			CN_aver[i].setEditable(false);
		}

		JLabel lblNewC = new JLabel("��������");
		lblNewC.setFont(new Font("�з���", Font.PLAIN, 20));
		lblNewC.setBounds(348, 208, 96, 26);
		contentPane3.add(lblNewC);

		JLabel lblNewLabel = new JLabel("�s�W�զX����");
		lblNewLabel.setFont(new Font("�з���", Font.PLAIN, 28));
		lblNewLabel.setBounds(253, 17, 191, 55);
		contentPane3.add(lblNewLabel);

		JLabel CC_cost = new JLabel("�զ�����������:");
		CC_cost.setFont(new Font("�з���", Font.PLAIN, 20));
		CC_cost.setBounds(10, 131, 159, 46);
		contentPane3.add(CC_cost);

		JLabel lblvucl = new JLabel("�զX������:");
		lblvucl.setFont(new Font("�з���", Font.PLAIN, 20));
		lblvucl.setBounds(309, 82, 110, 33);
		contentPane3.add(lblvucl);

		cc_model = new JTextField();
		cc_model.setFont(new Font("�з���", Font.PLAIN, 20));
		cc_model.setColumns(10);
		cc_model.setBounds(441, 82, 127, 33);
		contentPane3.add(cc_model);

		JLabel abtext = new JLabel("�W���Y�g:");
		abtext.setFont(new Font("�з���", Font.PLAIN, 20));
		abtext.setBounds(610, 82, 110, 33);
		contentPane3.add(abtext);

		abText = new JTextField();// �W���Y�g
		abText.setFont(new Font("�з���", Font.PLAIN, 20));
		abText.setColumns(10);
		abText.setBounds(719, 82, 127, 33);
		contentPane3.add(abText);

		final addfmalu clone = this;
		JButton btnRenew = new JButton("�s�W");
		btnRenew.setFont(new Font("�з���", Font.PLAIN, 20));
		btnRenew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<10;i++){
					if(C_Modle1[i].getText().equals("")){
						CN_name1[i].setText("");
						quantity1[i].setText("");
						CN_aver[i].setText("");
					}
				}
				
				int empty = 0, nameEmpty = 0;
				String C_Number, C_Name, C_Model, C_SellPrice, C_average, C_ab, C_Sum;// �զX����������
				C_Number = no_Number;
				C_Name = nametext.getText();
				C_Model = cc_model.getText();
				C_SellPrice = pricetext_1.getText();
				C_ab = abText.getText();
				C_Sum = C_averC.getText();

				String[] nametext2 = new String[10];// �s��
				String[] quantity2 = new String[10];// �ƶq
				String[] modle2 = new String[10];// ����
				String[] ave2 = new String[10];
				for (int i = 0; i < 10; i++) {
					nametext2[i] = CN_name1[i].getText().trim();
					quantity2[i] = quantity1[i].getText().trim();
					modle2[i] = C_Modle1[i].getText().trim();
					ave2[i] = CN_aver[i].getText().trim();
				}

				try {

					if ("".equals(C_Name.trim())) {
						empty++;
						JOptionPane.showMessageDialog(addfmalu.this, "�զX���W�٤��i���ť�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(C_Model.trim())) {
						empty++;
						JOptionPane.showMessageDialog(addfmalu.this, "�զX���������i���ť�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(C_SellPrice.trim())) {
						empty++;
						JOptionPane.showMessageDialog(addfmalu.this, "�զX��������i���ť�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
					if ("".equals(C_ab.trim())) {
						empty++;
						JOptionPane.showMessageDialog(addfmalu.this, "�W���Y�g���i���ť�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}

					for (int i = 0; i < 10; i++) {
						if ("".equals(nametext2[i].trim())) {
							nameEmpty++;
						}
					}

					if (empty == 0) {
						if (!nametext.getText().equals(cc_model.getText())) {
							if (checkpro(nametext2, modle2, quantity2) == true) {
								if (nameEmpty != 10) {									
									previewfmalu pre = new previewfmalu(cc,clone,C_Name, C_Model, C_Sum,
											C_SellPrice, C_ab, nametext2, modle2, quantity2, ave2,url,username,password);// �Ŧ�O�����ܼơB���O�ϰ��ܼơA�ϰ��ܼƷ|�bfunction�̭��w�q
									pre.setAlwaysOnTop(true); 
									pre.requestFocus();  
									pre.setVisible(true);
									dispose();
								} else {
									JOptionPane.showMessageDialog(addfmalu.this, "�զX�����i����", "ĵ�i", JOptionPane.WARNING_MESSAGE);
								}
							}
						} else {
							JOptionPane.showMessageDialog(addfmalu.this, "�զX���W�٩M�������i����", "ĵ�i", JOptionPane.WARNING_MESSAGE);
						}
					}

				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(addfmalu.this, "��J���~", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		btnRenew.setBounds(662, 612, 148, 33);
		contentPane3.add(btnRenew);

		JButton sumCost = new JButton("\u8A08\u7B97\u7E3D\u6210\u672C");
		sumCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum = 0;
				int[] q = new int[10];
				int[] average = new int[10];
				for (int i = 0; i < 10; i++) {
					if ((quantity1[i].equals("")) &&( CN_aver[i].equals(""))) {
						break;
					} else {
						try {
							
							q[i] = Integer.parseInt(quantity1[i].getText());
							average[i] = Integer.parseInt(CN_aver[i].getText());
							int cost = q[i] * average[i];
							sum += cost;
							C_averC.setText(Integer.toString(sum));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
				}
				if (!pricetext_1.getText().equals("") && !C_averC.getText().equals("")) {
					int price = Integer.parseInt(pricetext_1.getText());
					int ave = Integer.parseInt(C_averC.getText());
					// System.out.println(price+"���"+ave+"����");
					if (price < ave) {
						JOptionPane.showMessageDialog(addfmalu.this, "�`�N : �զX���~����p��զ�����������", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		sumCost.setFont(new Font("�з���", Font.PLAIN, 20));
		sumCost.setBounds(662, 562, 148, 33);
		contentPane3.add(sumCost);

		C_averC = new JTextField();
		C_averC.setEditable(false);
		C_averC.setFont(new Font("�з���", Font.PLAIN, 20));
		C_averC.setBounds(167, 138, 110, 33);
		contentPane3.add(C_averC);
		C_averC.setColumns(10);
	}

	public boolean checkpro(final String[] name, final String[] mod, final String[] qua) {
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String[][] checkpro = new String[0][0]; // �Ω�s����X�ݹ����s�W���ӫ~�����
		int numberOfColumns = 0;
		int numberOfRows = 0;
		int kk = 0; // �p�ⲣ�~��ƬO�_�������p�ƾ�

		try {

			cc = DriverManager.getConnection(url, username, password);
			statement = cc.createStatement();

			rs = statement.executeQuery("SELECT ProdName,ProdModel FROM Prod");
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				numberOfRows++;
			}
			checkpro = new String[numberOfRows][2];

			rs = statement.executeQuery("SELECT ProdName,ProdModel FROM Prod");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();

			int count = 0;
			while (rs.next()) {

				for (int i = 1; i <= numberOfColumns; i++) {
					// System.out.print(i + ":");
					// System.out.print(rs.getObject(i) + "\t");
					checkpro[count][i - 1] = (String) rs.getObject(i);
					// System.out.println(count + "-" + (i - 1) + ":" +
					
				}
				count++;
				// System.out.println();
			}

		} catch (SQLException sqlException) {// ��Ʈw�ާ@�o�Ϳ��~
			sqlException.printStackTrace();
		}
		int checkNameModel = 0;
		for (int i = 0; i < 10; i++) {
			if ((name[i].equals("")) && (mod[i].equals(""))) { // ���~�W�٩M�������ҪŪ��ٲ��ˬd
				if (!qua[i].equals("")) {
					kk++;
					String s = ("��" + (i + 1) + "�� �զ����W�٩M�����Ҭ��šA�Ч�ƶq�]�M��");
					JOptionPane.showMessageDialog(addfmalu.this, s, "ĵ�i", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				for (int j = 0; j < numberOfRows; j++) {
					if ((name[i].equals(checkpro[j][0])) && ((mod[i].equals(checkpro[j][1])))) {
						checkNameModel++;
					}
				}
				if (checkNameModel != 1) { // �d�S������ӫ~����إi��
					kk++;
					if ((name[i].equals("")) || (mod[i].equals(""))) {
						String s = ("��" + (i + 1) + "�� �զ����W��:" + name[i] + " �� ����:" + mod[i] + " ���ŭȿ��~!");
						JOptionPane.showMessageDialog(addfmalu.this, s, "ĵ�i", JOptionPane.WARNING_MESSAGE);
					} else {
						String s = ("��" + (i + 1) + "�� �զ����W��:" + name[i] + " �� ����:" + mod[i] + " ��J���~�A�d�L�Ӱӫ~!");
						JOptionPane.showMessageDialog(addfmalu.this, s, "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}
				} else if (checkNameModel == 1) { // �d�S������ӫ~����إi�� ���� ��
													// �ǳƽT�{���T���~���ƶq
					if (qua[i].equals("")) {
						kk++;
						String s = ("��" + (i + 1) + "�� �զ����W��:" + name[i] + " ���զ��ƶq���i���ŭ�");
						JOptionPane.showMessageDialog(addfmalu.this, s, "ĵ�i", JOptionPane.WARNING_MESSAGE);
					} else {
						int quaa = new Integer(qua[i]);
						if (quaa <= 0) {
							kk++;
							String s = ("�W��:" + name[i] + " ���զ��ƶq���i���p��ε��� 0 ");
							JOptionPane.showMessageDialog(addfmalu.this, s, "ĵ�i", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				checkNameModel = 0;

			}
		} // ���~�W�٩M�������ҪŪ��ٲ��ˬd ����

		if (kk > 0) { // �T�{���~��T�O�_�٦���
			return false;
		} else
			return true;
	}

	public String getfmalu_NO() {// �զX���s��
		SimpleDateFormat sdFormat = new SimpleDateFormat("mmddyyyy");
		Date d = new Date();
		String strDate = sdFormat.format(d);
		numberOfRows = 0;

		int num = 1;
		try {
			cc = DriverManager.getConnection(url, username, password );
			statement = cc.createStatement();
			rs = statement.executeQuery(
					"SELECT CNSN_Num FROM CNSN Where CNSN_Num LIKE '%" + strDate + "%' ORDER BY CNSN_Num");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					// System.out.printf("%s\t", rs.getObject(i));
				}
				// System.out.println();
				numberOfRows++;
			}
			if (numberOfRows != 0) {
				names = new String[numberOfRows];
				int count = 0;
				rs = statement.executeQuery(
						"SELECT CNSN_Num FROM CNSN Where CNSN_Num LIKE '%" + strDate + "%'ORDER BY CNSN_Num");
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
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy�~MM��dd��");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
	}

	public int getAvePrice(String PN) {// ��������
		// System.out.println("PN: " + PN);
		int count = 1;
		int aver = 0;
		int averC = 0;
		try {
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT * FROM ProdSN Where ProdModel ='" + PN + "'");
			numberOfColumns = rsMetaData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= 1; i++) {
					aver += Integer.parseInt(rs.getString("ProdPurPrice"));
				}
				count++;
			}
			averC = (aver / count);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return averC;
	}
}