package HHSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Component;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableColumn;
import javax.swing.event.AncestorEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;
public class SearchGrossProfit extends JFrame {
	Connection connect;
	private JPanel contentPane;
	static String url = "";
	static String username = ""; 
	static String password = "";
	private JTextField StartTime_tf;
	private JTextField EndTime_tf;
	private JTextField ProName_tf;
	static String[][] proset=new String[1][8];
	static int numberOfRows;
	static String col="SM.SM_Date";
	static String con="";
	static String cont="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGrossProfit frame = new SearchGrossProfit(null,"","","","","","");
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
	 * @param uRL2 
	 */
	public SearchGrossProfit(final Connection conn,String col1,String C1,String C2,final String URL,final String UN,final String PW) {
		setResizable(false);
		connect=conn;
		url = URL;
		username = UN;
		password = PW;
		if((col1.equals(""))&&(C1.equals(""))&&(C2.equals(""))){
			col="SM.SM_Date";
			getPro(col);
		}else{
			if(C2.equals("")){
				System.out.println(col1+"--"+C1);
				col=col1;
				con=C1;
				getProByName(con);
			}else if(!C2.equals("")) {
				System.out.println(col1+"--"+C1+"--"+C2);
				col=col1;
				con=C1;
				cont=C2;
				getProByTime(col,con,cont);
			}
			
		}
		setTitle("\u67E5\u8A62\u6BDB\u5229");
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 963, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u641C\u5C0B\u65B9\u5F0F\uFF1A\u4EE5\u7522\u54C1\u540D\u7A31\u6216\u8D77\u8A16\u6642\u9593");
		label.setFont(new Font("�з���", Font.PLAIN, 20));
		label.setBounds(71, 40, 300, 21);
		contentPane.add(label);
		
		JLabel ProName_lb = new JLabel("\u7522\u54C1\u540D\u7A31\uFF1A");
		ProName_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		ProName_lb.setBounds(71, 83, 126, 21);
		contentPane.add(ProName_lb);
		
		JLabel StartTime_lb = new JLabel("\u5F9E \u6642\u9593\uFF1A");
		StartTime_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		StartTime_lb.setBounds(401, 52, 126, 21);
		contentPane.add(StartTime_lb);
		
		StartTime_tf = new JTextField();
		StartTime_tf.setColumns(10);
		if(!C2.equals("")){
			StartTime_tf.setText(con);
		}
		StartTime_tf.setBounds(511, 52, 139, 21);
		contentPane.add(StartTime_tf);
		
		JLabel EndTime_lb = new JLabel("\u81F3 \u6642\u9593\uFF1A");
		EndTime_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		EndTime_lb.setBounds(401, 83, 126, 21);
		contentPane.add(EndTime_lb);
		
		EndTime_tf = new JTextField();
		EndTime_tf.setColumns(10);
		EndTime_tf.setText(cont);
		EndTime_tf.setBounds(511, 83, 139, 21);
		contentPane.add(EndTime_tf);
		
		JLabel label_4 = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_4.setFont(new Font("�з���", Font.ITALIC, 20));
		label_4.setBounds(777, 10, 165, 40);
		contentPane.add(label_4);
		
		ProName_tf = new JTextField();
		ProName_tf.setColumns(10);
		if(C2.equals("")){
			ProName_tf.setText(con);
		}
		ProName_tf.setBounds(172, 83, 139, 21);
		contentPane.add(ProName_tf);
		
		JLabel label_1 = new JLabel("(\u65E5\u671F\u683C\u5F0F:1999-99-99)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(511, 114, 139, 16);
		contentPane.add(label_1);
		/*
		Object[][] a= new Object[20][8];
		for(int i=0; i<20; i++){
			a[i][0]=i;
			for(int j=1; j<8 ;j++){
				a[i][j]=j;
			}
		}
		*/
	
		JButton goSearch = new JButton("\u641C\u5C0B");
		goSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((ProName_tf.getText().equals(""))&&(StartTime_tf.getText().equals(""))&&(EndTime_tf.getText().equals(""))){
					col="";	con="";	cont="";
				}
				else{
					if(ProName_tf.getText().equals("")){
						col="SM.SM_Date";
						con=StartTime_tf.getText();
						cont=EndTime_tf.getText();
						System.out.println("2--"+col+"--"+con+"--"+cont);
					}else if((StartTime_tf.getText().equals(""))||(EndTime_tf.getText().equals(""))){
						col="Prod.ProdName";
						con=ProName_tf.getText();
						cont="";
						System.out.println("1--"+col+"--"+con+"--"+cont);
					}
				}
				SearchGrossProfit SGP=new SearchGrossProfit(conn,col,con,cont,URL,UN,PW);
				SGP.setVisible(true);
				dispose();
			}
		});
		goSearch.setFont(new Font("�з���", Font.PLAIN, 24));
		goSearch.setBounds(692, 70, 106, 32);
		contentPane.add(goSearch);
		

		String[] cols={"���","���~�W��","���~����","����","���","�ƶq","��Q","��Q(�|)"};
		JTable table;
		table= new JTable(proset,cols);
		table.setFont(new Font("�з���", Font.PLAIN, 20));
		table.setEnabled(false);
		table.setRowHeight(23);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFillsViewportHeight(true); 
		
		TableColumn column;
		column=table.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);
		column=table.getColumnModel().getColumn(1);
		column.setPreferredWidth(150);
		column=table.getColumnModel().getColumn(2);
		column.setPreferredWidth(150);
		column=table.getColumnModel().getColumn(3);
		column.setPreferredWidth(50);
		column=table.getColumnModel().getColumn(4);
		column.setPreferredWidth(50);
		column=table.getColumnModel().getColumn(5);
		column.setPreferredWidth(50);
		column=table.getColumnModel().getColumn(6);
		column.setPreferredWidth(50);
		column=table.getColumnModel().getColumn(7);
		column.setPreferredWidth(50);
		JScrollPane SP=new JScrollPane(table);
		SP.setBounds(22, 167, 920, 384);
		contentPane.add(SP);
		
		JLabel label_2 = new JLabel("(\u689D\u4EF6\u7A7A\u767D\u5FAE\u986F\u793A\u5168\u90E8)");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(679, 114, 139, 16);
		contentPane.add(label_2);
		

	}
	
	public void getPro(String col) {
		proset = new String[1][8];
		//Connection conn;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String[][] checkpro = new String[1][5];	//�Ω�w�X�f���ӫ~��ơA���ݰ���B�T�{
		String[] taxway= new String[1];			//�Ω�s��ӫ~�X�f�ɥ�H������~�|�覡�p�⪺
		numberOfRows = 0;
			try {
				//conn = DriverManager.getConnection(url, username, password);
				// System.out.println("�s�����\");
				statement = connect.createStatement();

					//0-1*�����X�@�Z���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL ORDER BY '"+col+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows1: "+numberOfRows);
					
					//0-2*�A���X�զX���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL ORDER BY '"+col+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows2: "+numberOfRows);
					
					//---���L������W�r�A�Ω����
					int numberOfColumns=0;
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					for(int i=1; i<=numberOfColumns; i++){
					  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
					}
					System.out.println("");
					//--���L������W�r�A�Ω����
					
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					proset = new String[numberOfRows][8];
					checkpro = new String[numberOfRows][6];
					taxway= new String[numberOfRows];
					System.out.println("proset.length: "+proset.length);
					for(int i=0;i<proset.length;i++){
						for(int j=0 ;j<8;j++){
							proset[i][j]="";
						}
						taxway[i]="";
					}
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					
					//1-1*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL ORDER BY '"+col+"'");
					int c = 0;
				
					while (rs.next()) { 
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					}
					//1-2*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL ORDER BY '"+col+"' ");
					while (rs.next()) {
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					} 
				
					//conn.close();
					//1*���X�Ҧ��w�X�f���~�Ǹ����--����
					
					
					int pc=0; //�p��w�g��J���~���X�̪����T���~��Ƽ�
					int goin=0;	//�p��C�ӱ���J�����~�ɹ�̭��w�s�b�����O�_�̼˪��T�{
					//2* ����Ĥ@����i�h
					if(numberOfRows!=0){
						for(int i=0; i<5;i++){
							proset[0][i]=checkpro[0][i];	
						}
						proset[0][5]="1";
						pc=pc+1;
						taxway[0]=checkpro[0][5];
					}
					//2* ����Ĥ@����i�h
					
					//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
					for(int i=1;i<numberOfRows;i++){
						 //System.out.println(checkpro[i][0]+"\t"+checkpro[i][1]+"\t"+checkpro[i][2]+"\t"+checkpro[i][3]+"\t"+checkpro[i][4]);
						for(int k=0 ;k<proset.length; k++){
							//System.out.println("checkpro["+i+"][0]"+checkpro[i][0]+"-- proset["+j+"][0])"+proset[j][0]);
							if(!proset[k][0].equals("")){
								if((checkpro[i][0].equals(proset[k][0]))&&(checkpro[i][1].equals(proset[k][1]))&&(checkpro[i][2].equals(proset[k][2]))&&(checkpro[i][3].equals(proset[k][3]))&&(checkpro[i][5].equals(taxway[k]))){
									//���X����Ʀp�G����B���~�W�١B�����B�����B����O�̼˪��N��O���F���~�Ǹ��~���@�Ҥ@�˪��X�f�ӫ~�A�ƶq�n�[�W�h
										int oldqua=Integer.parseInt(proset[k][5]);
										int newqua=oldqua+1;
										proset[k][5]=""+newqua;
										break;
									}else{
										goin++; //�C��checkpro���n��proset�̥H�������~���T�{�A�p�G���S�����@�˪��ӫ~�~goin++
										//System.out.println("goin: "+goin);
									}
							}
						}	
						if(goin==pc){
							System.out.println("pc: "+pc);
							proset[pc][0]=checkpro[i][0];	//��J���
							proset[pc][1]=checkpro[i][1];	//��J���~�W��
							proset[pc][2]=checkpro[i][2];	//��J���~����
							proset[pc][3]=checkpro[i][3];	//��J����
							proset[pc][4]=checkpro[i][4];	//��J���
							proset[pc][5]=""+1;				//��J�ƶq
							taxway[pc]=checkpro[i][5];
							System.out.println(proset[pc][0]+"-"+proset[pc][1]+"-"+proset[pc][2]+"-"+proset[pc][3]+"-"+proset[pc][4]+"-"+proset[pc][5]+"-"+taxway[pc]);
							
							pc++;
							
						}
						goin=0;
					}
					 	
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
		System.out.println("------------");
		//4* �p���Q�M���[�|����Q
		for(int k=0 ;k<proset.length; k++){
			if(!proset[k][5].equals("")){
				System.out.println(k+"--5: "+proset[k][5]+"--4: "+proset[k][4]);
				int gf=Integer.parseInt(proset[k][5])*Integer.parseInt(proset[k][4]);
				proset[k][6]=""+gf;
				
				switch (taxway[k]){
				case "���|":{
					int gftax=(int)(Integer.parseInt(proset[k][6])*(1.05));
					proset[k][7]=""+gftax;
					break;}
				case "�K�|":{
					proset[k][7]=proset[k][6];
					break;}
				case "�s�|�v":{
					proset[k][7]=proset[k][6];
					break;}
				default: break;
				}
			}
		}
		//4* �p���Q�M���[�|����Q
	}
	public void getProByTime(String col,String ST, String ET){
		proset = new String[1][8];
		//Connection conn;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String[][] checkpro = new String[1][5];	//�Ω�w�X�f���ӫ~��ơA���ݰ���B�T�{
		String[] taxway= new String[1];			//�Ω�s��ӫ~�X�f�ɥ�H������~�|�覡�p�⪺
		numberOfRows = 0;
			try {
				//conn = DriverManager.getConnection(url, username, password);
				// System.out.println("�s�����\");
				statement = connect.createStatement();

					//0-1*�����X�@�Z���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL AND "+col+" BETWEEN '"+ST+"' AND '"+ET+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows1: "+numberOfRows);
					
					//0-2*�A���X�զX���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL AND "+col+" BETWEEN '"+ST+"' AND '"+ET+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows2: "+numberOfRows);
					
					//---���L������W�r�A�Ω����
					int numberOfColumns=0;
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					for(int i=1; i<=numberOfColumns; i++){
					  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
					}
					System.out.println("");
					//--���L������W�r�A�Ω����
					
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					proset = new String[numberOfRows][8];
					checkpro = new String[numberOfRows][6];
					taxway= new String[numberOfRows];
					System.out.println("proset.length: "+proset.length);
					for(int i=0;i<proset.length;i++){
						for(int j=0 ;j<8;j++){
							proset[i][j]="";
						}
						taxway[i]="";
					}
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					
					//1-1*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL AND "+col+" BETWEEN '"+ST+"' AND '"+ET+"'");
					int c = 0;
				
					while (rs.next()) { 
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					}
					//1-2*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL AND "+col+" BETWEEN '"+ST+"' AND '"+ET+"' ");
					while (rs.next()) {
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					} 
				
					//conn.close();
					//1*���X�Ҧ��w�X�f���~�Ǹ����--����
					
					
					int pc=0; //�p��w�g��J���~���X�̪����T���~��Ƽ�
					int goin=0;	//�p��C�ӱ���J�����~�ɹ�̭��w�s�b�����O�_�̼˪��T�{
					//2* ����Ĥ@����i�h
					if(numberOfRows!=0){
						for(int i=0; i<5;i++){
							proset[0][i]=checkpro[0][i];	
						}
						proset[0][5]="1";
						pc=pc+1;
						taxway[0]=checkpro[0][5];
					}
					//2* ����Ĥ@����i�h
					
					//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
					for(int i=1;i<numberOfRows;i++){
						 //System.out.println(checkpro[i][0]+"\t"+checkpro[i][1]+"\t"+checkpro[i][2]+"\t"+checkpro[i][3]+"\t"+checkpro[i][4]);
						for(int k=0 ;k<proset.length; k++){
							//System.out.println("checkpro["+i+"][0]"+checkpro[i][0]+"-- proset["+j+"][0])"+proset[j][0]);
							if(!proset[k][0].equals("")){
								if((checkpro[i][0].equals(proset[k][0]))&&(checkpro[i][1].equals(proset[k][1]))&&(checkpro[i][2].equals(proset[k][2]))&&(checkpro[i][3].equals(proset[k][3]))&&(checkpro[i][5].equals(taxway[k]))){
									//���X����Ʀp�G����B���~�W�١B�����B�����B����O�̼˪��N��O���F���~�Ǹ��~���@�Ҥ@�˪��X�f�ӫ~�A�ƶq�n�[�W�h
										int oldqua=Integer.parseInt(proset[k][5]);
										int newqua=oldqua+1;
										proset[k][5]=""+newqua;
										break;
									}else{
										goin++; //�C��checkpro���n��proset�̥H�������~���T�{�A�p�G���S�����@�˪��ӫ~�~goin++
										//System.out.println("goin: "+goin);
									}
							}
						}	
						if(goin==pc){
							System.out.println("pc: "+pc);
							proset[pc][0]=checkpro[i][0];	//��J���
							proset[pc][1]=checkpro[i][1];	//��J���~�W��
							proset[pc][2]=checkpro[i][2];	//��J���~����
							proset[pc][3]=checkpro[i][3];	//��J����
							proset[pc][4]=checkpro[i][4];	//��J���
							proset[pc][5]=""+1;				//��J�ƶq
							taxway[pc]=checkpro[i][5];
							System.out.println(proset[pc][0]+"-"+proset[pc][1]+"-"+proset[pc][2]+"-"+proset[pc][3]+"-"+proset[pc][4]+"-"+proset[pc][5]+"-"+taxway[pc]);
							
							pc++;
							
						}
						goin=0;
					}
					 	
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
		System.out.println("------------");
		//4* �p���Q�M���[�|����Q
		for(int k=0 ;k<proset.length; k++){
			if(!proset[k][5].equals("")){
				System.out.println(k+"--5: "+proset[k][5]+"--4: "+proset[k][4]);
				int gf=Integer.parseInt(proset[k][5])*Integer.parseInt(proset[k][4]);
				proset[k][6]=""+gf;
				
				switch (taxway[k]){
				case "���|":{
					int gftax=(int)(Integer.parseInt(proset[k][6])*(1.05));
					proset[k][7]=""+gftax;
					break;}
				case "�K�|":{
					proset[k][7]=proset[k][6];
					break;}
				case "�s�|�v":{
					proset[k][7]=proset[k][6];
					break;}
				default: break;
				}
			}
		}
		//4* �p���Q�M���[�|����Q
	}
	public void getProByName(String Pname){
		proset = new String[1][8];
		//Connection conn;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String[][] checkpro = new String[1][5];	//�Ω�w�X�f���ӫ~��ơA���ݰ���B�T�{
		String[] taxway= new String[1];			//�Ω�s��ӫ~�X�f�ɥ�H������~�|�覡�p�⪺
		numberOfRows = 0;
			try {
				//conn = DriverManager.getConnection(url, username, password);
				// System.out.println("�s�����\");
				statement = connect.createStatement();

					//0-1*�����X�@�Z���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL AND Prod.ProdName='"+Pname+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows1: "+numberOfRows);
					
					//0-2*�A���X�զX���~�����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL AND Prod.ProdName='"+Pname+"' ");
					while (rs.next()) {numberOfRows++; } // �p��w�X�f���ӫ~��Ʀ��X��
					System.out.println("numberOfRows2: "+numberOfRows);
					
					//---���L������W�r�A�Ω����
					int numberOfColumns=0;
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					for(int i=1; i<=numberOfColumns; i++){
					  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
					}
					System.out.println("");
					//--���L������W�r�A�Ω����
					
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					proset = new String[numberOfRows][8];
					checkpro = new String[numberOfRows][6];
					taxway= new String[numberOfRows];
					System.out.println("proset.length: "+proset.length);
					for(int i=0;i<proset.length;i++){
						for(int j=0 ;j<8;j++){
							proset[i][j]="";
						}
						taxway[i]="";
					}
					//--�]�w�Ҧ��ݭn�Ψ쪺�}�C�j�p�M��l��
					
					//1-1*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,ProdSN.ProdModel,ProdSN.ProdPurPrice,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,ProdSN "
							+ "WHERE SM.SM_Num=ProdSN.SM_Num AND Prod.ProdModel=ProdSN.ProdModel "
							+ "AND ProdSN.SM_Num IS NOT NULL AND Prod.ProdName='"+Pname+"'");
					int c = 0;
				
					while (rs.next()) { 
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					}
					//1-2*���X�Ҧ��w�X�f���~�Ǹ����
					rs = statement.executeQuery(
							"SELECT SM.SM_Date,Prod.ProdName,CNSN.CNSN_Model,CNSN.CNSN_Cost,"
							+ "Prod.ProdSellPrice,SM.SM_BusiTax FROM SM,Prod,CNSN "
							+ "WHERE SM.SM_Num=CNSN.CNSN_SMN AND Prod.ProdModel=CNSN.CNSN_Model "
							+ "AND CNSN.CNSN_SMN IS NOT NULL AND Prod.ProdName='"+Pname+"' ");
					while (rs.next()) {
						for (int i = 1; i <= 6; i++) {
							checkpro[c][i - 1] = rs.getObject(i).toString();
							 System.out.print("["+c+"]["+(i-1)+"]:"+checkpro[c][i-1]+"\t");
						}
						System.out.println("");
						c++;
					} 
				
					//conn.close();
					//1*���X�Ҧ��w�X�f���~�Ǹ����--����
					
					
					int pc=0; //�p��w�g��J���~���X�̪����T���~��Ƽ�
					int goin=0;	//�p��C�ӱ���J�����~�ɹ�̭��w�s�b�����O�_�̼˪��T�{
					//2* ����Ĥ@����i�h
					if(numberOfRows!=0){
						for(int i=0; i<5;i++){
							proset[0][i]=checkpro[0][i];	
						}
						proset[0][5]="1";
						pc=pc+1;
						taxway[0]=checkpro[0][5];
					}
					//2* ����Ĥ@����i�h
					
					//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
					for(int i=1;i<numberOfRows;i++){
						 //System.out.println(checkpro[i][0]+"\t"+checkpro[i][1]+"\t"+checkpro[i][2]+"\t"+checkpro[i][3]+"\t"+checkpro[i][4]);
						for(int k=0 ;k<proset.length; k++){
							//System.out.println("checkpro["+i+"][0]"+checkpro[i][0]+"-- proset["+j+"][0])"+proset[j][0]);
							if(!proset[k][0].equals("")){
								if((checkpro[i][0].equals(proset[k][0]))&&(checkpro[i][1].equals(proset[k][1]))&&(checkpro[i][2].equals(proset[k][2]))&&(checkpro[i][3].equals(proset[k][3]))&&(checkpro[i][5].equals(taxway[k]))){
									//���X����Ʀp�G����B���~�W�١B�����B�����B����O�̼˪��N��O���F���~�Ǹ��~���@�Ҥ@�˪��X�f�ӫ~�A�ƶq�n�[�W�h
										int oldqua=Integer.parseInt(proset[k][5]);
										int newqua=oldqua+1;
										proset[k][5]=""+newqua;
										break;
									}else{
										goin++; //�C��checkpro���n��proset�̥H�������~���T�{�A�p�G���S�����@�˪��ӫ~�~goin++
										//System.out.println("goin: "+goin);
									}
							}
						}	
						if(goin==pc){
							System.out.println("pc: "+pc);
							proset[pc][0]=checkpro[i][0];	//��J���
							proset[pc][1]=checkpro[i][1];	//��J���~�W��
							proset[pc][2]=checkpro[i][2];	//��J���~����
							proset[pc][3]=checkpro[i][3];	//��J����
							proset[pc][4]=checkpro[i][4];	//��J���
							proset[pc][5]=""+1;				//��J�ƶq
							taxway[pc]=checkpro[i][5];
							System.out.println(proset[pc][0]+"-"+proset[pc][1]+"-"+proset[pc][2]+"-"+proset[pc][3]+"-"+proset[pc][4]+"-"+proset[pc][5]+"-"+taxway[pc]);
							
							pc++;
							
						}
						goin=0;
					}
					 	
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		//3* ��n�[�J�����~��i����ܥX�Ӫ��}�C
		System.out.println("------------");
		//4* �p���Q�M���[�|����Q
		for(int k=0 ;k<proset.length; k++){
			if(!proset[k][5].equals("")){
				System.out.println(k+"--5: "+proset[k][5]+"--4: "+proset[k][4]);
				int gf=Integer.parseInt(proset[k][5])*Integer.parseInt(proset[k][4]);
				proset[k][6]=""+gf;
				
				switch (taxway[k]){
				case "���|":{
					int gftax=(int)(Integer.parseInt(proset[k][6])*(1.05));
					proset[k][7]=""+gftax;
					break;}
				case "�K�|":{
					proset[k][7]=proset[k][6];
					break;}
				case "�s�|�v":{
					proset[k][7]=proset[k][6];
					break;}
				default: break;
				}
			}
		}
		//4* �p���Q�M���[�|����Q
	}
}
