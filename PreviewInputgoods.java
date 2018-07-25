package HHSystem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class PreviewInputgoods extends JFrame {

	private JPanel contentPane;
	Connection con;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	private String srAddr="",srTel="",srFax="";
	private String[][] PurchaseData= new String[0][0];
	private JTextField[] proName=new JTextField[10], proMod=new JTextField[10];
	private JLabel[] proQua=new JLabel[10],lblNewLabel_3=new JLabel[10],lblNewLabel_4=new JLabel[10];
	private JTextField[] proCost=new JTextField[10];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviewInputgoods frame = new PreviewInputgoods(null,null,null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @param password2 
	 * @param username2 
	 * @param url2 
	 * @wbp.parser.constructor
	 */
	public PreviewInputgoods(final Connection conn,final String[] data,final NewInputgoods NIG, String URL, String UN, String PW) {
		setResizable(false);
		setFont(new Font("�з���", Font.PLAIN, 20));
		setTitle("\u9810\u89BD\u6B32\u65B0\u589E\u9032\u8CA8\u7684\u63A1\u8CFC\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 876, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("�з���", Font.ITALIC, 25));
		label.setBounds(633, 31, 203, 40);
		contentPane.add(label);
		
		JLabel label_13 = new JLabel("\u6578\u91CF");
		label_13.setFont(new Font("�з���", Font.PLAIN, 20));
		label_13.setBounds(404, 219, 50, 30);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("\u6210\u672C");
		label_14.setFont(new Font("�з���", Font.PLAIN, 20));
		label_14.setBounds(535, 219, 50, 30);
		contentPane.add(label_14);
		
		JLabel label_8 = new JLabel("\u54C1\u540D");
		label_8.setFont(new Font("�з���", Font.PLAIN, 20));
		label_8.setBounds(48, 219, 50, 30);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u578B\u865F\u898F\u683C");
		label_9.setFont(new Font("�з���", Font.PLAIN, 20));
		label_9.setBounds(213, 219, 97, 30);
		contentPane.add(label_9);
		
		JLabel PO_PurDate = new JLabel("\u63A1\u8CFC\u65E5\u671F"+data[1]);
		PO_PurDate.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_PurDate.setBounds(20, 61, 220, 30);
		contentPane.add(PO_PurDate);
		
		JLabel PO_SRName = new JLabel("\u4F9B\u61C9\u5546\u540D\u7A31\uFF1A"+data[2]);
		PO_SRName.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_SRName.setBounds(20, 99, 279, 30);
		contentPane.add(PO_SRName);
		
		getSR(data[2]);
		JLabel SRAddr = new JLabel("\u4F9B\u61C9\u5546\u5730\u5740\uFF1A"+srAddr);
		SRAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRAddr.setBounds(308, 99, 374, 30);
		contentPane.add(SRAddr);
		
		JLabel SRPhone = new JLabel("\u4F9B\u61C9\u5546\u96FB\u8A71\uFF1A"+srTel);
		SRPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRPhone.setBounds(20, 139, 279, 30);
		contentPane.add(SRPhone);
		
		JLabel SRFax = new JLabel("\u4F9B\u61C9\u5546\u50B3\u771F\uFF1A"+srFax);
		SRFax.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFax.setBounds(308, 139, 244, 30);
		contentPane.add(SRFax);
		
		JLabel PO_Attn = new JLabel("ATTN:"+data[8]);
		PO_Attn.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Attn.setBounds(611, 139, 235, 30);
		contentPane.add(PO_Attn);
		
		JLabel PO_GetDate = new JLabel("\u4EA4\u8CA8\u65E5\u671F\uFF1A"+data[6]);
		PO_GetDate.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_GetDate.setBounds(308, 179, 237, 30);
		contentPane.add(PO_GetDate);
		
		JLabel PO_Curr = new JLabel("\u4F7F\u7528\u5E63\u5225\uFF1A"+data[5]);
		PO_Curr.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Curr.setBounds(20, 179, 279, 30);
		contentPane.add(PO_Curr);
		
		JLabel PO_Remark = new JLabel("\u63A1\u8CFC\u55AE\u5099\u8A3B\uFF1A"+data[7]);
		PO_Remark.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Remark.setBounds(48, 659, 540, 30);
		contentPane.add(PO_Remark);
		
		JLabel PO_Hand = new JLabel("\u7D93\u8FA6\uFF1A"+data[4]);
		PO_Hand.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Hand.setBounds(308, 61, 279, 30);
		contentPane.add(PO_Hand);
		
		JLabel PO_Num = new JLabel("\u63A1\u8CFC\u55AE\u7DE8\u865F\uFF1A"+data[0]);
		PO_Num.setFont(new Font("�з���", Font.PLAIN, 32));
		PO_Num.setBounds(201, 21, 398, 30);
		contentPane.add(PO_Num);
		
		
		getPRO(data[0]);
		for(int i=0;i<10;i++){
			proName[i]= new JTextField();
			//proName[i].setText("");
			proName[i].setEditable(false);
			proName[i].setBounds(53, 260+30*i, 100, 20);
			contentPane.add(proName[i]);
		}
		for(int i=0;i<10;i++){
			proMod[i] = new JTextField();
			//proMod[i].setText("2");
			proMod[i].setEditable(false);
			proMod[i].setBounds(220, 260+30*i, 100, 15);
			contentPane.add(proMod[i]);
		}
		for(int i=0;i<10;i++){
			proQua[i] = new JLabel();
			//proQua[i].setText("2");
			proQua[i].setBounds(420, 260+30*i, 46, 15);
			contentPane.add(proQua[i]);
		}
		for(int i=0;i<10;i++){
			proCost[i] = new JTextField();
			proCost[i].setText("");
			proCost[i].setBounds(540, 260+30*i, 60, 15);
			proCost[i].setColumns(10);
			contentPane.add(proCost[i]);
			proCost[i].setVisible(false);
		}
	
			for(int j=0;j<numberOfRows;j++){	
				//System.out.println("this: "+PurchaseData[j][0]);
					proName[j].setText(PurchaseData[j][0]);
					proMod[j].setText(PurchaseData[j][1]);
					proQua[j].setText(PurchaseData[j][2]);
				
				if(proName[j].getText()!=null){
					proCost[j].setVisible(true);
				}
				//lblNewLabel_3[j].setText(PurchaseData[j][3]);
			}
			
		JButton Back_btn = new JButton("\u8FD4\u56DE\u4E0A\u9801");
		Back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NIG.setVisible(true);
				dispose();
			}
		});
		Back_btn.setFont(new Font("�з���", Font.PLAIN, 20));
		Back_btn.setBounds(566, 654, 128, 40);
		contentPane.add(Back_btn);
		

		JButton goAddInput = new JButton("\u78BA\u5B9A\u65B0\u589E");
		goAddInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int CostError=0;
				int empty=0;
				//���۽T�{�C�Ӧ����椣�ର�ŭȩΪ�<=0����
				for(int j=0;j<numberOfRows;j++){
					if("".equals(proCost[j].getText())){
						empty++;
						JOptionPane.showMessageDialog(PreviewInputgoods.this, proName[j].getText()+" ���������o�ŭ�","�����~",JOptionPane.WARNING_MESSAGE);
					}else{
						int cost=Integer.parseInt(proCost[j].getText());  //�⦳�񪺦����Ȯ����ˬd�O�_�ŭ�
						if(cost<=0){
							CostError++;
							JOptionPane.showMessageDialog(PreviewInputgoods.this, proName[j].getText()+" ���������o���p�󵥩�0����","�����~",JOptionPane.WARNING_MESSAGE);
						}
					}
					
				}
				//���۽T�{�C�Ӧ����椣�ର�ŭȩΪ�<=0����--����
				
				if((CostError==0)&&(empty==0)){
					//System.out.println("----Ckeck ok");
					int po_check=0; //�Ω�������i�f�ʧ@��A���ʳ檺���A�O�_��s
					int totalRecord=0;
					for(int i=0 ;i<numberOfRows;i++){
						totalRecord+=Integer.parseInt(proQua[i].getText());
					}
					System.out.println("-------------------");
					System.out.println("totalRecord: "+totalRecord);
					
					if(goAdd(data[0])==totalRecord){//�Ǳ��ʳ�s���i�h�A�}�l�s�W
						//3* �T�{�w�s�W����
							JOptionPane.showMessageDialog(PreviewInputgoods.this, "�s�W�q���Ʀ��\ !","�s�W���\",JOptionPane.INFORMATION_MESSAGE);
							try{
								//Connection conn;
								Statement statement;
								
								//conn=DriverManager.getConnection(url, username, password );
								statement = con.createStatement();
								po_check = statement.executeUpdate("UPDATE Purchase SET PO_Check = '1' WHERE PO_Num='"+data[0]+"'");
								System.out.println("po_check: "+ po_check );
								
							//conn.close();
							}catch(SQLException sqlException){
								sqlException.printStackTrace();
							}
							dispose();
							NewInputgoods NIG2= new NewInputgoods(con,"PO_SRName","",url,username,password);//�}�W�@���X��
							NIG2.setVisible(true);
							
							//System.exit(0);
						
						}else{
							JOptionPane.showMessageDialog(PreviewInputgoods.this, "�s�W�q���ƥ��� !","�s�W����",JOptionPane.WARNING_MESSAGE);
							int result=JOptionPane.showConfirmDialog(PreviewInputgoods.this,
						               "�T�w�n�����{����?",
						               "�T�{�T��",
						               JOptionPane.YES_NO_OPTION,
						               JOptionPane.WARNING_MESSAGE);
						    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
					} 
				}
			}
		});
		goAddInput.setFont(new Font("�з���", Font.PLAIN, 20));
		goAddInput.setBounds(704, 654, 128, 40);
		contentPane.add(goAddInput);
		
	}

	public void getSR(String SRName){
		//Connection conn;
		Statement statement;
		ResultSet rs = null;
		
		 try{
		       //  Class.forName(DRIVER_NAME);//���JJDBC Driver
		         //conn = DriverManager.getConnection(url, username, password ); 
		         System.out.println("��Ʈw�s�����\"); 
		         statement = con.createStatement();
				rs = statement.executeQuery("SELECT * FROM SR Where SRName = '"+SRName+"'");
				while(rs.next()){
					srAddr=rs.getString("SRAddr");
					srTel=rs.getString("SRPhone");
					srFax=rs.getString("SRFax");
				}
				// conn.close();
			  }catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
	        sqlException.printStackTrace();
	      }
	}
	public void getPRO(String PO_Num){
		PurchaseData= new String[1][1];
		//Connection conn;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		numberOfRows=0;
		   
	
			try {
				//conn=DriverManager.getConnection(url,username,password);
				//System.out.println("�s�����\");
				statement = con.createStatement();
				
				try{
				  //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq
				
					rs = statement.executeQuery("SELECT Prod.ProdName,PurProd.PO_ProdModel,PurProd.PO_PurQuan,Prod.ProdSellPrice FROM Prod,PurProd Where Prod.ProdModel=PurProd.PO_ProdModel AND PurProd.PO_Num ='"+PO_Num+"'");
					rsMetaData = rs.getMetaData();
					while(rs.next()){numberOfRows++;};  //�p���Ʀ��X��
					//System.out.println(numberOfRows);
					
					rs = statement.executeQuery("SELECT Prod.ProdName,PurProd.PO_ProdModel,PurProd.PO_PurQuan,Prod.ProdSellPrice FROM Prod,PurProd Where Prod.ProdModel=PurProd.PO_ProdModel AND PurProd.PO_Num ='"+PO_Num+"'");
				    rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					
					
					PurchaseData=new String[numberOfRows][4];  //�Ω�s����X�����~�����M�{���w�s �M �q���`�ݨD�q
					int count2=0;
				
					while (rs.next()){  //������̪����
				    	
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	  PurchaseData[count2][i-1]=rs.getObject(i).toString();
					    	 // System.out.println("--PurchaseData["+count2+"]["+(i-1)+"]: "+PurchaseData[count2][i-1]);	  
					       }
					      count2++;
					     }
				    // conn.close();
				    
				     //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq ����
				     }catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
	
	}
	public int goAdd(String Ponum){
		//����n�s�W�����~��²�٨��X�ӡA���F�n��@���~�Ǹ����̾�
		//Connection conn;
		Statement statement;
		ResultSet rs = null;
		String[] proAB= new String[numberOfRows];  //�s����X�����~²��
		String[] ABmax= new String[numberOfRows];	//�s��²�٦b���~�Ǹ������̤j��
		//System.out.println("numberOfRows"+numberOfRows);
		for(int i=0 ;i<numberOfRows;i++){
			String pm=proMod[i].getText(); //��n�h²�٪��ӫ~������J
				try{
				       // conn = DriverManager.getConnection(url, username, password ); 
				        //System.out.println("��Ʈw�s�����\"); 
				        statement = con.createStatement();
						rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel= '"+pm+"'");
						while(rs.next()){
							proAB[i]=rs.getString("ProdAbName");
							System.out.println("-------------------");
							System.out.println("proAB"+i+": "+proAB[i]);
							ABmax[i]=proAB[i]+"0";			//���X²�ٮɶ��K�w�]²�ٳ̤j�Ȭ�0
						}
						 //conn.close();
					  }catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
			        sqlException.printStackTrace();
			      }
		} 
		
		//����n�s�W�����~��²�٨��X�ӡA���F�n��@���~�Ǹ����̾�--����
		//���۶i�J���J���~�Ǹ�Table
		
		//1* �����X�n�s�W�����~�w�b���~�Ǹ���椤�̤j����
		
		for(int i=0 ;i<numberOfRows;i++){
			String pm2=proMod[i].getText();
				try{
				       // conn = DriverManager.getConnection(url, username, password ); 
				       // System.out.println("��Ʈw�s�����\"); 
				        statement = con.createStatement();
						rs = statement.executeQuery("SELECT * FROM ProdSN Where ProdModel= '"+pm2+"' Order By ProdSN ASC");
						//if(!rs.next()){System.out.println("ABmax"+i+": "+ABmax[i]);}
						while(rs.next()){
							int valueofAB=Integer.parseInt(ABmax[i].substring(proAB[i].length()));
							int valueofProdSN=Integer.parseInt(rs.getString("ProdSN").substring(proAB[i].length()));
							//System.out.println("valueofAB: "+valueofAB+"\t"+"valueofProdSN: "+valueofProdSN);
							if(valueofProdSN>valueofAB){	//�����X�Ӫ��Ǹ��M�w�s�񪺧Ǹ��̤j�Ȱ����
								ABmax[i]=rs.getString("ProdSN");
							}
							System.out.println("-------------------");
							System.out.println("ABmax"+i+": "+ABmax[i]);
						}
						 //conn.close();
					  }catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
			        sqlException.printStackTrace();
			      }
		
		}
		//1* �����X�n�s�W�����~�w�b���~�Ǹ���椤�̤j����--����
		//2* �s�W�i���~�Ǹ�
		
		int isUpdate=0;
		for(int i=0 ;i<numberOfRows;i++){
			int pqua=Integer.parseInt(proQua[i].getText()); 	//�ܼƦs��i�f�����~���ƶq
			int cost=Integer.parseInt(proCost[i].getText());	//�ܼƦs��i�f�����~������
			String pmod=proMod[i].getText(); 					//�ܼƦs��i�f�����~������
			//�ܼƦs��i�f�����~�w�b���~�Ǹ��̤��̤j��,�O�H�Ӱӫ~��²�٧@�����β��~�Ǹ����o�Ʀr�̤j�Ȫ��̾�
			int quaStart=1+Integer.parseInt(ABmax[i].substring(proAB[i].length())); 
			System.out.println("-------------------");
			System.out.println("quaStart: "+quaStart);
			try{
				//conn=DriverManager.getConnection(url, username, password );
				//System.out.println("�s�����\2");
				statement = con.createStatement();
				
				for(int j=0 ;j<pqua;j++){
					String newProdSN=""+proAB[i]+"0"+(quaStart+j);  //�s�����~�Ǹ�=�ӫ~²��+(�̤j��+�s�٪��ƶq)
					
					System.out.println("--newProdSN :"+newProdSN);
					
					isUpdate += statement.executeUpdate("INSERT INTO ProdSN(ProdSN,ProdModel,ProdPurPrice,"
							+ "PO_Num) VALUES ('"+newProdSN+"', '"+pmod+"', '"+cost+"', '"+Ponum+"')");
					//���~�Ǹ�ProdSN�Gfk���~����ProdModel�B���~���ʻ���ProdPurPrice�Bfk���ʳ�s��PO_Num
					
				}

				//conn.close();
				 
				System.out.println("isUpdate: "+isUpdate);
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
		}
		//2* �s�W�i���~�Ǹ�--����
		
		//3*��s���~��ƪ� �w�s�M ��ֽ��ʤ�
		int proUpdate=0;
		for(int i=0 ;i<numberOfRows;i++){
			
			String pmod=proMod[i].getText();   //����i���~����
			int proNP[] =new int[2];	//���s��ProdNowInve�BProdPurQuan
			
			try{
				//conn=DriverManager.getConnection(url, username, password );
				//System.out.println("�s�����\2");
				statement = con.createStatement();
				rs = statement.executeQuery("SELECT * FROM Prod Where ProdModel= '"+pmod+"'");
				
				while(rs.next()){
					proNP[0]=Integer.parseInt(rs.getString("ProdNowInve"));
					proNP[1]=Integer.parseInt(rs.getString("ProdPurQuan"));
				}
				int pqua=Integer.parseInt(proQua[i].getText());		//��i�f�����~���ƶq
				int newNI=proNP[0]+pqua;
				int newPQ=proNP[1]-pqua;
				System.out.println("��NI: "+proNP[0]+"- ��PQ: "+proNP[1]);
				System.out.println("�sNI: "+newNI+"- �sPQ: "+newPQ);
				
			//	conn=DriverManager.getConnection(url, username, password );
				statement = con.createStatement();
				proUpdate += statement.executeUpdate("UPDATE Prod SET ProdNowInve='"+newNI+"',ProdPurQuan='"+newPQ+"'  WHERE ProdModel='"+pmod+"'");
				
				//conn.close();
				 
				
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
			}
			
		}
		System.out.println("proUpdate: "+proUpdate);
		//3*��s���~��ƪ� �w�s�M ��ֽ��ʤ�--����
		if(proUpdate==numberOfRows){
			return isUpdate;
		}else{
			return 0;
		}
	}
}
