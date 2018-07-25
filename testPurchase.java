package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class testPurchase extends JFrame {
	Connection con;
	private JPanel contentPane;
	static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	private String srAddr="",srTel="",srFax="";
	private String[][] PurchaseData= new String[0][0];
	private JLabel[] lblNewLabel=new JLabel[10],lblNewLabel_1=new JLabel[10],lblNewLabel_2=new JLabel[10],lblNewLabel_3=new JLabel[10],lblNewLabel_4=new JLabel[10];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testPurchase frame = new testPurchase(null,null,"","","");
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
	 * @param d 
	 * @throws SQLException 
	 */
	public testPurchase(final Connection conn,final String[] data,final String URL,final String UN,final String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		
		getSR(data[2]);
		getPRO(data[0]);
		for(int i=0;i<10;i++){
			lblNewLabel_1[i] = new JLabel();
			lblNewLabel_1[i].setBounds(220, 260+30*i, 100, 15);
			contentPane.add(lblNewLabel_1[i]);
		}
		for(int i=0;i<10;i++){
			lblNewLabel_2[i] = new JLabel();
			lblNewLabel_2[i].setBounds(420, 260+30*i, 46, 15);
			contentPane.add(lblNewLabel_2[i]);
		}
		for(int i=0;i<10;i++){
			lblNewLabel[i]= new JLabel();
			lblNewLabel[i].setBounds(53, 260+30*i, 60, 15);
			contentPane.add(lblNewLabel[i]);
		}
		for(int i=0;i<10;i++){
			lblNewLabel_3[i] = new JLabel();
			lblNewLabel_3[i].setBounds(540, 260+30*i, 60, 15);
			contentPane.add(lblNewLabel_3[i]);
		}
		for(int i=0;i<10;i++){
			lblNewLabel_4[i]= new JLabel();
			lblNewLabel_4[i].setBounds(665, 260+30*i, 60, 15);
			contentPane.add(lblNewLabel_4[i]);
		}
		
			for(int j=0;j<numberOfRows;j++){
				int sum = Integer.parseInt(PurchaseData[j][2])*Integer.parseInt(PurchaseData[j][3]);
				String sumPrice = String.valueOf(sum);
				lblNewLabel_4[j].setText(sumPrice);
				lblNewLabel[j].setText(PurchaseData[j][0]);
				lblNewLabel_1[j].setText(PurchaseData[j][1]);
				lblNewLabel_2[j].setText(PurchaseData[j][2]);
				lblNewLabel_3[j].setText(PurchaseData[j][3]);
			}
		JLabel HSName = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("�з���", Font.ITALIC, 25));
		HSName.setBounds(641, 10, 203, 40);
		contentPane.add(HSName);

		Label Purchase_No = new Label("���ʳ�s���G"+data[0]);
		Purchase_No.setFont(new Font("Dialog", Font.PLAIN, 30));
		Purchase_No.setBounds(221, 0, 374, 37);
		contentPane.add(Purchase_No);
		
		JLabel PO_PurDate = new JLabel("���ʤ���G"+data[1]);
		PO_PurDate.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_PurDate.setBounds(28, 40, 220, 30);
		contentPane.add(PO_PurDate);
		
		JLabel PO_SRName = new JLabel("�����ӦW�١G"+data[2]);
		PO_SRName.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_SRName.setBounds(28, 78, 279, 30);
		contentPane.add(PO_SRName);
	
		JLabel SRAddr = new JLabel("�����Ӧa�}�G"+srAddr);
		SRAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRAddr.setBounds(316, 78, 374, 30);
		contentPane.add(SRAddr);
		
		JLabel SRPhone = new JLabel("�����ӹq�ܡG"+srTel);
		SRPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRPhone.setBounds(28, 118, 279, 30);
		contentPane.add(SRPhone);
		
		JLabel SRFax = new JLabel("�����Ӷǯu�G"+srFax);
		SRFax.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFax.setBounds(316, 118, 244, 30);
		contentPane.add(SRFax);
		
		JLabel PO_Attn = new JLabel("ATTN:"+data[8]);
		PO_Attn.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Attn.setBounds(619, 118, 235, 30);
		contentPane.add(PO_Attn);
		
		JLabel label_8 = new JLabel("�~�W");
		label_8.setFont(new Font("�з���", Font.PLAIN, 20));
		label_8.setBounds(56, 221, 50, 30);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("�����W��");
		label_9.setFont(new Font("�з���", Font.PLAIN, 20));
		label_9.setBounds(221, 221, 97, 30);
		contentPane.add(label_9);
		
		JButton button = new JButton("��^�W��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("�з���", Font.PLAIN, 20));
		button.setBounds(572, 507, 128, 40);
		contentPane.add(button);
		
		JLabel PO_PayCond = new JLabel("�I�ڱ���G"+data[3]);
		PO_PayCond.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_PayCond.setBounds(28, 158, 279, 30);
		contentPane.add(PO_PayCond);
		
		JLabel PO_GetDate = new JLabel("��f����G"+data[6]);
		PO_GetDate.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_GetDate.setBounds(617, 158, 237, 30);
		contentPane.add(PO_GetDate);
		
		JLabel PO_Curr = new JLabel("�ϥι��O�G"+data[5]);
		PO_Curr.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Curr.setBounds(316, 158, 279, 30);
		contentPane.add(PO_Curr);
		
		JLabel label = new JLabel("�ƶq");
		label.setFont(new Font("�з���", Font.PLAIN, 20));
		label.setBounds(400, 221, 50, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("���");
		label_1.setFont(new Font("�з���", Font.PLAIN, 20));
		label_1.setBounds(527, 221, 50, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("���B");
		label_2.setFont(new Font("�з���", Font.PLAIN, 20));
		label_2.setBounds(655, 221, 50, 30);
		contentPane.add(label_2);
		
		JLabel PO_Remark = new JLabel("���ʳ�Ƶ��G"+data[7]);
		PO_Remark.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Remark.setBounds(28, 512, 540, 30);
		contentPane.add(PO_Remark);
		
		JLabel PO_Hand = new JLabel("�g��G"+data[4]);
		PO_Hand.setFont(new Font("�з���", Font.PLAIN, 20));
		PO_Hand.setBounds(316, 40, 279, 30);
		contentPane.add(PO_Hand);
		
	}
	

public void getSR(String SRName){
	//Connection conn;
	Statement statement;
	ResultSet rs = null;
	 try{
	     
	        // conn = DriverManager.getConnection(url, username, password ); 
	         System.out.println("��Ʈw�s�����\"); 
	         statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM SR Where SRName = '"+SRName+"'");
			while(rs.next()){
				srAddr=rs.getString("SRAddr");
				srTel=rs.getString("SRPhone");
				srFax=rs.getString("SRFax");
			}
		  }catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
        sqlException.printStackTrace();
      }
}
public void getPRO(String PO_Num){

	//Connection conn;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;

	   

		try {
			//conn=DriverManager.getConnection(url,username,password);
			//System.out.println("�s�����\");
			statement = con.createStatement();
			
			try{
			  //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq
				
				rs = statement.executeQuery("SELECT Prod.ProdName,PurProd.PO_ProdModel,PurProd.PO_PurQuan,Prod.ProdSellPrice"
						+ " FROM Prod,PurProd Where PurProd.PO_ProdModel = Prod.ProdModel AND PO_Num = '"+PO_Num+"'");
				rsMetaData = rs.getMetaData();
				while(rs.next()){numberOfRows++;};  //�p���Ʀ��X��
				
				rs = statement.executeQuery("SELECT Prod.ProdName,PurProd.PO_ProdModel,PurProd.PO_PurQuan,Prod.ProdSellPrice"
						+ " FROM Prod,PurProd Where PurProd.PO_ProdModel = Prod.ProdModel AND PO_Num = '"+PO_Num+"'");
			    rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				System.out.println(numberOfRows);
				PurchaseData=new String[numberOfRows][4];  //�Ω�s����X�����~�����M�{���w�s �M �q���`�ݨD�q
				int count2=0;
				while (rs.next()){  //������̪����
			    	
				      for(int i=1; i<=numberOfColumns; i++)
					   {
				    	  PurchaseData[count2][i-1]=rs.getObject(i).toString();	 
				    	  
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
}