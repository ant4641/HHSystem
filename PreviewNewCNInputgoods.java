package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class PreviewNewCNInputgoods extends JFrame {

	private JPanel contentPane;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JTextField[] pMod=new JTextField[10];
	private JTextField[] pQua=new JTextField[10];
	private JTextField[] pNowIno=new JTextField[10];
	static String[][] ComUnit;
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	static String CNName;
	static int InQua;
	Connection con;
	
	//Statement statement;
	//ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCNInputgoods frame = new NewCNInputgoods(null, "", "", "");
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
	public PreviewNewCNInputgoods(Connection conn,final NewCNInputgoods NCI ,final String CN, String InQ,String URL, String UN, String PW) {
		setResizable(false);
		setTitle("\u65B0\u589E\u7D44\u5408\u7522\u54C1\u9032\u8CA8");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		CNName=CN;
		InQua=Integer.parseInt(InQ);
		getUnit(CN);	//�����Ҧ��զX���~
		Statement statement;
		ResultSet rs = null;
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("�з���", Font.ITALIC, 18));
		label.setBounds(466, 10, 155, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u7D44\u5408\u7269\u7522\u54C1\u9032\u8CA8");
		label_1.setFont(new Font("�з���", Font.PLAIN, 22));
		label_1.setBounds(178, 9, 207, 40);
		contentPane.add(label_1);
		
		JLabel CN_Name = new JLabel("\u7D44\u5408\u7269\u540D\u7A31\uFF1A"+CN);
		CN_Name.setFont(new Font("�з���", Font.PLAIN, 22));
		CN_Name.setBounds(26, 70, 275, 40);
		contentPane.add(CN_Name);
		
		JLabel label_3 = new JLabel("\u7D44\u4EF6\u5167\u5BB9\uFF1A");
		label_3.setFont(new Font("�з���", Font.PLAIN, 22));
		label_3.setBounds(26, 115, 115, 40);
		contentPane.add(label_3);
		
		JLabel InQua = new JLabel("\u9032\u8CA8\u6578\u91CF\uFF1A"+InQ);
		InQua.setFont(new Font("�з���", Font.PLAIN, 22));
		InQua.setBounds(323, 70, 242, 40);
		contentPane.add(InQua);
		
		JLabel label_5 = new JLabel("\u7D44\u4EF6\u540D\u7A31");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("�з���", Font.PLAIN, 22));
		label_5.setBounds(155, 115, 115, 40);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u9700\u6C42\u91CF");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("�з���", Font.PLAIN, 22));
		label_6.setBounds(280, 115, 77, 40);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5EAB\u5B58\u91CF");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("�з���", Font.PLAIN, 22));
		label_7.setBounds(367, 115, 77, 40);
		contentPane.add(label_7);
		
		for(int i=0 ;i<10 ;i++){
		pMod[i] = new JTextField();
		pMod[i].setBounds(155, 165+41*i, 115, 31);
		pMod[i].setColumns(10);
		pMod[i].setEditable(false);
		contentPane.add(pMod[i]);
		}

		for(int i=0 ;i<10 ;i++){
		pQua[i] = new JTextField();
		pQua[i].setColumns(10);
		pQua[i].setBounds(280, 165+41*i, 77, 31);
		pQua[i].setEditable(false);
		contentPane.add(pQua[i]);
		}
		
		for(int i=0 ;i<10 ;i++){
		pNowIno[i] = new JTextField();
		pNowIno[i].setColumns(10);
		pNowIno[i].setBounds(367, 165+41*i,75, 31);
		pNowIno[i].setEditable(false);
		contentPane.add(pNowIno[i]);
		}
		
		for(int i=0 ; i<ComUnit.length;i++){
			  pMod[i].setText(ComUnit[i][0]);
			  int newQua=Integer.parseInt(ComUnit[i][1])*Integer.parseInt(InQ);
			  pQua[i].setText(""+newQua);
			  //ComUnit[i][1]=""+newQua;
			  //System.out.println("ComUnit["+i+"]["+1+"]:"+ComUnit[i][1]);
			  pNowIno[i].setText(ComUnit[i][2]);
		  
		}
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NCI.setVisible(true);
			}
		});
		back.setFont(new Font("�з���", Font.PLAIN, 20));
		back.setBounds(355, 592, 124, 40);
		contentPane.add(back);
		
		JButton ADD_btn = new JButton("\u78BA\u5B9A\u65B0\u589E");
		ADD_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(goAdd()==1){
					JOptionPane.showMessageDialog(PreviewNewCNInputgoods.this,"�s�W�զX���i�f���\", "��s��T", JOptionPane.INFORMATION_MESSAGE);  
					dispose();
				}else{
					JOptionPane.showMessageDialog(PreviewNewCNInputgoods.this,"�s�W�զX���i�f����", "��s��T", JOptionPane.WARNING_MESSAGE);  
					int result=JOptionPane.showConfirmDialog(PreviewNewCNInputgoods.this,
				               "�O�_�n�����{��?",
				               "�T�{�T��",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.WARNING_MESSAGE);
				    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
				}
			}
		});
		ADD_btn.setFont(new Font("�з���", Font.PLAIN, 20));
		ADD_btn.setBounds(489, 592, 124, 40);
		contentPane.add(ADD_btn);

		

	}
	
	public void getUnit(String CN){
		Statement statement;
		ResultSet rs = null;
		int rows=0;
		int count=0;
		ComUnit=new String[1][1];
		try {

			con = DriverManager.getConnection(url, username, password);
			//System.out.println("��Ʈw�s�����\");
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT CNC.CNC_Comp_ProdModel,CNC.CNC_CompQuan,Prod.ProdNowInve FROM CNC,Prod Where Prod.ProdModel=CNC.CNC_Comp_ProdModel AND CNC.CN_Model ='"+CN+"'");
			while (rs.next()) {rows++;}
			ComUnit= new String[rows][3];
			numberOfRows=rows;
			System.out.println("rows: "+rows);
			System.out.println("---------");
			rs = statement.executeQuery("SELECT CNC.CNC_Comp_ProdModel,CNC.CNC_CompQuan,Prod.ProdNowInve FROM CNC,Prod Where Prod.ProdModel=CNC.CNC_Comp_ProdModel AND CNC.CN_Model ='"+CN+"'");
			while (rs.next()) {
				
				for(int i=1 ;i<=3 ;i++){
					//System.out.print(rs.getObject(i)+"\t"); 
					ComUnit[count][i-1]=rs.getObject(i).toString();
					//System.out.println(count+"-"+(i-1)+":"+ComUnit[count][i-1]); 
				}		
				//System.out.print(ComUnit[count][0]+"--"+ComUnit[count][1]+"--"+ComUnit[count][2]);
				count++;
				//System.out.println("----");
				
			}
			
			//conn.close();
		} catch (SQLException sqlException) {// ��Ʈw�ާ@�o�Ϳ��~
			sqlException.printStackTrace();
		}
	
	}
	
	public int goAdd() {
		// ����n�s�W�����~��²�٨��X�ӡA���F�n��@���~�Ǹ����̾�
		Statement statement = null;
		ResultSet rs = null;
		String proAB ="";
		String ABmax =""; // �s��²�٦b���~�Ǹ������̤j��
	
			try {
				//conn = DriverManager.getConnection(url, username, password);
				// System.out.println("��Ʈw�s�����\");
				statement = con.createStatement();
				rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel= '" + CNName + "'");
				while (rs.next()) {
					proAB = rs.getString("ProdAbName");
					System.out.println("-------------------");
					System.out.println("proAB: " + proAB);
					ABmax = proAB+ "0"; // ���X²�ٮɶ��K�w�]²�ٳ̤j�Ȭ�0
				}
				//conn.close();
			} catch (SQLException sqlException) {// ��Ʈw�ާ@�o�Ϳ��~
				sqlException.printStackTrace();
			}
		

		// ����n�s�W�����~��²�٨��X�ӡA���F�n��@���~�Ǹ����̾�--����
		//���۶i�J���J���~�Ǹ�Table
		
		//1* �����X�n�s�W�����~�w�b���~�Ǹ���椤�̤j����
		
				try{
				        //conn = DriverManager.getConnection(url, username, password ); 
				       // System.out.println("��Ʈw�s�����\"); 
				        statement = con.createStatement();
						rs = statement.executeQuery("SELECT * FROM CNSN Where CNSN_Model= '"+CNName+"' ");
						//if(!rs.next()){System.out.println("ABmax"+i+": "+ABmax[i]);}
						while(rs.next()){
							int valueofAB=Integer.parseInt(ABmax.substring(proAB.length()));
							int valueofProdSN=Integer.parseInt(rs.getString("CNSN_Num").substring(proAB.length()));
							//System.out.println("valueofAB: "+valueofAB+"\t"+"valueofProdSN: "+valueofProdSN);
							if(valueofProdSN>valueofAB){	//�����X�Ӫ��Ǹ��M�w�s�񪺧Ǹ��̤j�Ȱ����
								ABmax=rs.getString("CNSN_Num");
							}
							System.out.println("-------------------");
							System.out.println("ABmax1: "+ABmax);
						}
						System.out.println("ABmax2: "+ABmax);
						 //conn.close();
					  }catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
			        sqlException.printStackTrace();
			      }
		
		
		//1* �����X�n�s�W�����~�w�b���~�Ǹ���椤�̤j����--����
		
		//2* �s�W�i���~�Ǹ�
		
		int isUpdate=0;
		int proUpdate=0;
		int cProUpdate=0;
			int pqua=InQua;							//�ܼƦs��i�f�����~���ƶq
			String pmod=CNName; 					//�ܼƦs��i�f�����~������
			//�ܼƦs��i�f�����~�w�b���~�Ǹ��̤��̤j��,�O�H�Ӱӫ~��²�٧@�����β��~�Ǹ����o�Ʀr�̤j�Ȫ��̾�
			int quaStart=1+Integer.parseInt(ABmax.substring(proAB.length())); 
			System.out.println("-------------------");
			System.out.println("quaStart: "+quaStart);
			try{
				//conn=DriverManager.getConnection(url, username, password );
				//System.out.println("�s�����\2");
				statement = con.createStatement();
				
				for(int j=0 ;j<pqua;j++){
					String newProdSN=""+proAB+"0"+(quaStart+j);  //�s�����~�Ǹ�=�ӫ~²��+(�̤j��+�s�٪��ƶq)
					System.out.println("--newProdSN :"+newProdSN);
					isUpdate += statement.executeUpdate("INSERT INTO CNSN(CNSN_Num,CNSN_Model )"
							+ "VALUES ('"+newProdSN+"', '"+pmod+"')");
					System.out.println("isUpdate 1: "+isUpdate);
					
					//2.1* ��s�ե󪺲զX���s��
					for(int k=0 ; k<ComUnit.length;k++){
						proUpdate += statement.executeUpdate("UPDATE ProdSN SET CC_Num='"+newProdSN+"' WHERE ProdModel='"+ComUnit[k][0]+"' AND CC_Num='0' LIMIT "+ComUnit[k][1]+" ");
					}
					System.out.println("proUpdate"+j+": "+proUpdate);
				
					
					//2.2* �p�⦨���զX���s������
					int tCost=0;
					rs=statement.executeQuery("SELECT ProdPurPrice FROM ProdSN WHERE CC_Num='"+newProdSN+"' ");
					while(rs.next()){
						tCost+=Integer.parseInt(rs.getObject(1).toString());
						System.out.println("newProdSN: "+newProdSN+"--tCost: "+tCost);
					}
					//2.3* ��s�s���զX����Cost
					isUpdate += statement.executeUpdate("UPDATE CNSN SET CNSN_Cost='"+tCost+"' WHERE CNSN_Num='"+newProdSN+"' ");
					
				}
				
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
		//2* �s�W�i���~�Ǹ�--����
		//3* ��s�զX���~���~���w�s�M ��ֲե󪺮w�s�q
			
			//��s�զX���~
			int proNP=0;
			int proUpdate2=0;
			try{
				
			rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel= '"+CNName+"'");
			while(rs.next()){
				proNP=Integer.parseInt(rs.getString("ProdNowInve"));
			}
			int newNI=proNP+InQua;
			System.out.println(CNName+"-��NP: "+proNP+"- �sNP: "+newNI);
			proUpdate2 = statement.executeUpdate("UPDATE Prod SET ProdNowInve='"+newNI+"' WHERE ProdModel='"+CNName+"'");
			
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			System.out.println("proUpdate2-1: "+proUpdate2);
			proUpdate2=0;
			
			//��s�ե�
			for(int i=0; i<ComUnit.length;i++){
				try{
					rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel= '"+ComUnit[i][0]+"'");
					while(rs.next()){
						proNP=Integer.parseInt(rs.getString("ProdNowInve"));
					}
					int newNI=proNP-(Integer.parseInt(ComUnit[i][1])*InQua);
					System.out.println(ComUnit[i][0]+"-��NP: "+proNP+"- �sNP: "+newNI);
					
					proUpdate2 += statement.executeUpdate("UPDATE Prod SET ProdNowInve='"+newNI+"' WHERE ProdModel='"+ComUnit[i][0]+"'");
					
					}catch(SQLException sqlException){
						sqlException.printStackTrace();
					}
			}
			System.out.println("proUpdate2-2: "+proUpdate2);
		//3*��s�զX���~���~���w�s�M ��ֲե󪺮w�s�q --����
			
		if(proUpdate2==ComUnit.length){
			//System.out.println("OK");
			return 1;
		}else{
			return 0;
		}
	}
}
