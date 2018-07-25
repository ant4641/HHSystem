package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class previewfmalu extends JFrame {

	private JPanel contentPane;
	private JLabel namee[] = new JLabel[10];
	private JLabel modell[] = new JLabel[10];
	private JLabel quantityy[] = new JLabel[10];
	private JLabel averCost[] = new JLabel[10];
	static String url="";
	static String username="";
	static String password="";
	static int numberOfRows = 0;
	static int numberOfColumns = 0;
	static String[] name = new String[10];
	static String[] mod = new String[10];
	static String[] quant = new String[10];

	Connection cc;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewfmalu frame = new previewfmalu(null,null," ", "", null, null, null, null, null, null, null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public previewfmalu(Connection con,addfmalu addf, final String nametext, final String model, final String sum,
			final String pricetext, final String ab, final String[] cn_name2, final String[] model2,
			final String[] cn_quantity2, final String[] ave,String URL,String  UN,String  PW) {
		setResizable(false);
		cc=con;
		url=URL;
		username=UN;
		password=PW;
		final addfmalu noFrame = addf;
		setTitle("�w���s�W�զX������");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 872, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(5, 5, 424, 0);
		contentPane.add(label);

		JLabel C_name = new JLabel("�զX���W��:" + nametext);
		C_name.setFont(new Font("�з���", Font.PLAIN, 20));
		C_name.setBounds(5, 119, 213, 37);
		contentPane.add(C_name);

		JLabel C_price = new JLabel("�զX�����:" + pricetext);
		C_price.setFont(new Font("�з���", Font.PLAIN, 20));
		C_price.setBounds(297, 177, 219, 30);
		contentPane.add(C_price);

		JLabel lblNewLabel_1 = new JLabel("\u9810\u89BD\u65B0\u589E\u7D44\u5408\u8868\u516C\u5F0F\r\n");
		lblNewLabel_1.setFont(new Font("�з���", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(216, 67, 300, 30);
		contentPane.add(lblNewLabel_1);

		JLabel company = new JLabel("�x����~�������q");
		company.setFont(new Font("�з���", Font.ITALIC, 26));
		company.setBounds(603, 10, 226, 31);
		contentPane.add(company);

		JLabel number01 = new JLabel("�զ����W��");
		number01.setFont(new Font("�з���", Font.PLAIN, 20));
		number01.setBounds(10, 233, 112, 30);
		contentPane.add(number01);

		JLabel modle01 = new JLabel("�զ�������");
		modle01.setFont(new Font("�з���", Font.PLAIN, 20));
		modle01.setBounds(220, 234, 108, 28);
		contentPane.add(modle01);

		JLabel quantity01 = new JLabel("�զ��ݨD�ƶq");
		quantity01.setFont(new Font("�з���", Font.PLAIN, 20));
		quantity01.setBounds(570, 236, 177, 25);
		contentPane.add(quantity01);

		JLabel cost01 = new JLabel("��������");
		cost01.setFont(new Font("�з���", Font.PLAIN, 20));
		cost01.setBounds(408, 236, 80, 25);
		contentPane.add(cost01);

		JLabel C_model = new JLabel("�զX������:" + model);
		C_model.setFont(new Font("�з���", Font.PLAIN, 20));
		C_model.setBounds(295, 125, 204, 25);
		contentPane.add(C_model);

		JLabel C_averge = new JLabel("�զ�����������:" + sum);
		C_averge.setFont(new Font("�з���", Font.PLAIN, 20));
		C_averge.setBounds(5, 177, 240, 30);
		contentPane.add(C_averge);

		JLabel C_ab = new JLabel("�W���Y�g:" + ab);
		C_ab.setFont(new Font("�з���", Font.PLAIN, 20));
		C_ab.setBounds(548, 122, 226, 30);
		contentPane.add(C_ab);

		for (int i = 0; i < 10; i++) {// �W��
			namee[i] = new JLabel();
			namee[i].setBounds(10, 273 + 40 * i, 112, 33);
			namee[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane.add(namee[i]);

		}

		for (int i = 0; i < 10; i++) {// ����
			modell[i] = new JLabel();
			modell[i].setBounds(220, 276 + 40 * i, 108, 33);
			modell[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane.add(modell[i]);
		}

		for (int i = 0; i < 10; i++) {
			averCost[i] = new JLabel();
			averCost[i].setBounds(408, 276 + 40 * i, 80, 33);
			averCost[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane.add(averCost[i]);
		}

		for (int i = 0; i < 10; i++) {// �ƶq
			quantityy[i] = new JLabel();
			quantityy[i].setBounds(570, 276 + 40 * i, 177, 33);
			quantityy[i].setFont(new Font("�з���", Font.PLAIN, 20));
			contentPane.add(quantityy[i]);
		}
	
		
		
		int procount = 0;
		int put = 0;
		try {
			for (int i = 0; i < 10; i++) {
				if ((!cn_name2[i].equals("")) && (!model2[i].equals("")) && (!cn_quantity2[i].equals(""))
						&& (!ave[i].equals(""))) {
					for (int k = 0; k < 10; k++) {
						if ((cn_name2[i].equals(namee[k].getText())) && (model2[i].equals(modell[k].getText()))
								&& (ave[i].equals(averCost[k].getText()))) {
							int qq = Integer.parseInt(quantityy[k].getText());
							qq += Integer.parseInt(cn_quantity2[i]);
							quantityy[k].setText("" + qq);
							put = 1;
						}
					}
					if (put != 1) {
						namee[procount].setText(cn_name2[i]);
						modell[procount].setText(model2[i]);
						quantityy[procount].setText(cn_quantity2[i]);
						averCost[procount].setText(ave[i]);
						procount++;
					}
					put = 0; // �@�Ӱӫ~�񧹫ᰵ�k�s
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		JButton newFmalu = new JButton("�T�w�s�W");
		newFmalu.setFont(new Font("�з���", Font.PLAIN, 20));
		newFmalu.addActionListener(new ActionListener() {
			int cncs = 0;

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {

					if (!namee[i].getText().trim().equals("")) {
						// System.out.println("got");
						name[i] = namee[i].getText().trim();
						mod[i] = modell[i].getText().trim();
						quant[i] = quantityy[i].getText().trim();
					}
								
				}
				
				if(chkCN(mod)==true){
					
					Statement statement;

					int isUpdate = 0;
						try {
							statement = cc.createStatement();
							try {

								if (cncs == 0) {
									if (chkfma(model, nametext, ab) != 1) {
										isUpdate = statement.executeUpdate(
												"INSERT into Prod(ProdModel,ProdName,ProdSellPrice,ProdAbName,ProdIsCom)VALUES('"
														+ model + "','" + nametext + "','" + pricetext + "','" + ab
														+ "','1')");

										for (int i = 0; i < namee.length; i++) {
											if (!namee[i].getText().equals("")) {
												isUpdate += statement.executeUpdate(
														"INSERT into CNC(CN_Model,CNC_Comp_ProdModel,CNC_CompQuan)VALUES('"
																+ model + "','" + mod[i] + "','" + quant[i] + "')");
											}

										}

									} else {
										JOptionPane.showMessageDialog(previewfmalu.this, "�զX���~��ƭ��� !", "�s�W����",
												JOptionPane.INFORMATION_MESSAGE);
									}
								}
							} catch (SQLException sqlException) {
								sqlException.printStackTrace();
							}
							if (isUpdate > 0) {
								
								JOptionPane.showMessageDialog(previewfmalu.this, "�s�W�զX�������\ !", "�s�W���\", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(previewfmalu.this, "�s�W�զX�������� !", "�s�W����", JOptionPane.WARNING_MESSAGE);
								int result = JOptionPane.showConfirmDialog(previewfmalu.this, "�T�w�n�����{����?", "�T�{�T��",
										JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
								if (result == JOptionPane.YES_OPTION) {
									
								}
							}
						} catch (SQLException SQLe) {
							SQLe.printStackTrace();
						}
					
					
				}else{
					JOptionPane.showMessageDialog(previewfmalu.this, "�s�W���զX�������� !!", "���~�T��", JOptionPane.WARNING_MESSAGE);
				}
				
			
			}
			public boolean chkCN(String[] CNmod){
				System.out.println("------fma-------");
				System.out.println("------fma-------");
				
				int countUnits=0;
				for(int i=0; i<CNmod.length; i++){
					
					if(CNmod[i]!=null){
						countUnits++;
					}
					
				}
							
				String[] CNName=new String[1];
				
				//1*�p��զX�~�ƶq
				try{
					int count=0; //�Ω�p��զX�~�ƶq
					statement = cc.createStatement();
					rs = statement.executeQuery("SELECT ProdModel FROM Prod Where ProdIsCom = '1'");
					while(rs.next()){count++;}
					CNName = new String[count];
					count=0;
					
					rs = statement.executeQuery("SELECT ProdModel FROM Prod Where ProdIsCom = '1'");
					while(rs.next()){
						CNName[count]=rs.getObject(1).toString();
						count++;
					}
					
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				//2* �ԥX�ե󤺮e
				String[][] units=new String[1][1];
				int count2=0; //�p��ԥX���ե󦳴X��
				int islike=0;
				for(int i=0; i<CNName.length;i++){
					try{
						statement = cc.createStatement();
						rs = statement.executeQuery("SELECT CNC_CompQuan,CNC_Comp_ProdModel FROM CNC Where CN_Model='"+CNName[i]+"' ");
						while(rs.next()){count2++;}
						
						units= new String[count2][2];
						count2=0;
						System.out.println("------fma22-------");
						
						rs = statement.executeQuery("SELECT * FROM CNC Where CN_Model='"+CNName[i]+"' ");
						while(rs.next()){
							units[count2][0]=rs.getString("CNC_CompQuan");
							units[count2][1]=rs.getString("CNC_Comp_ProdModel");
							System.out.println("units: "+count2+"-"+units[count2][0]+"--"+units[count2][1]);
							count2++;
						}
						
						
						String[] oriU=new String[countUnits];
						String[] DBU=new String[count2];
						
						if(count2==countUnits){			//�N���X���զX�����ե�ƶq�M���s�W���ե�ƶq���
							
							
							oriU=new String[countUnits];
							DBU=new String[count2];
							
							//�N�s�W���ե�MDB���ե��i�}�C�̷ǳư����
							for(int k=0; k<countUnits;k++){
								oriU[k]=quant[k]+"*"+mod[k];
								System.out.println("oriU["+k+"]"+oriU[k]);
							}
							
							for(int k=0; k<count2;k++){
								DBU[k]=units[k][0]+"*"+units[k][1];
								System.out.println("DBU["+k+"]"+DBU[k]);
							}
							//�@���ۥH�q�Ʀr�C��������A����ե󦳬ۦP���ƶq�F��s�W���ƶq�N�p��unitlike+1
							int unitlike=0;
							for(int j=0 ;j<countUnits;j++){
								for(int k=0 ;k<count2;k++){
									if(oriU[j].equals(DBU[k])){
										unitlike++;
									}
								}
							}
							System.out.println("unitlike: "+unitlike);
							if(unitlike==countUnits){
								islike++;
							}else{
								System.out.println("Unit it's ok");
							}
							System.out.println("islike: "+islike);
							
						}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				if(islike==0){
					return true;
				}else{
					return false;
				}
				
			}
		
			private int chkfma(String fmaM, String fmaN, String fmaAb) {
				Statement statement;
				ResultSet rs;
				ResultSetMetaData rsMetaData;
				int checkmodel = 0;
				String[] ModelAbName = new String[3];
				ModelAbName[0] = "";
				ModelAbName[1] = "";
				ModelAbName[2] = "";
				int numberOfColumns;
					try {
						statement =cc.createStatement();
						try {
							rs = statement.executeQuery("Select ProdModel,ProdAbName From Prod where ProdModel='" + fmaM
									+ "' OR ProdName = '" + fmaN + "' OR ProdAbName='" + fmaN + "' ");
							rsMetaData = rs.getMetaData();
							numberOfColumns = rsMetaData.getColumnCount();
							while (rs.next()) { // ������̪����
								for (int i = 1; i <= numberOfColumns; i++) {
									ModelAbName[i - 1] = rs.getObject(i).toString();
								}
							}
						} catch (SQLException sqlException) {
							sqlException.printStackTrace();
						}
					} catch (SQLException SQLe) {
						SQLe.printStackTrace();
					}
				

				if ((ModelAbName[0].equals(fmaM)) || (ModelAbName[1].equals(fmaN)) || (ModelAbName[2].equals(fmaAb))) {
					checkmodel = 1;
				}
				return checkmodel;
			}
		});
		newFmalu.setBounds(689, 425, 122, 30);
		contentPane.add(newFmalu);

		JButton backBut = new JButton("��^");
		backBut.setFont(new Font("�з���", Font.PLAIN, 20));
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noFrame.setVisible(true);
				dispose();
			}
		});
		backBut.setBounds(689, 512, 122, 30);
		contentPane.add(backBut);

	}
}