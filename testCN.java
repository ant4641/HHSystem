package HHSystem;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class testCN extends JFrame {

	private JPanel contentPane;
	Connection con;
	static String url="";
	static String username="";
	static String password="";
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	private String cost;
	private String srAddr="",srTel="",srFax="";
	private String[][] CNData;
	private JLabel[] lblNewLabel=new JLabel[10],lblNewLabel_1=new JLabel[10],lblNewLabel_2=new JLabel[10],lblNewLabel_3=new JLabel[10],lblNewLabel_4=new JLabel[10];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testCN frame = new testCN(null,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testCN(final Connection conn,String[] Data,String URL,String  UN,String  PW) {
		setResizable(false);
		url=URL;
		username=UN;
		password=PW;
		con=conn;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 836, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label CN = new Label("�զX������");
		CN.setFont(new Font("Dialog", Font.PLAIN, 30));
		CN.setBounds(322, 13, 194, 37);
		contentPane.add(CN);
		getCN(Data[0]);
		JLabel CC_Num= new JLabel("�զX�������G"+Data[0]);
		CC_Num.setFont(new Font("�з���", Font.PLAIN, 20));
		CC_Num.setBounds(41, 79, 338, 30);
		contentPane.add(CC_Num);
		
		JLabel CC_Name = new JLabel("�զX���W�١G"+Data[1]);
		CC_Name.setFont(new Font("�з���", Font.PLAIN, 20));
		CC_Name.setBounds(413, 79, 308, 30);
		contentPane.add(CC_Name);
		
		JLabel CC_Cost = new JLabel("�զX�������G"+cost);
		CC_Cost.setFont(new Font("�з���", Font.PLAIN, 20));
		CC_Cost.setBounds(416, 139, 285, 30);
		contentPane.add(CC_Cost);
		
		JLabel CC_SellPrice = new JLabel("�զX������G"+Data[7]);
		CC_SellPrice.setFont(new Font("�з���", Font.PLAIN, 20));
		CC_SellPrice.setBounds(41, 139, 361, 30);
		contentPane.add(CC_SellPrice);
		
		JLabel HSName = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("�з���", Font.ITALIC, 25));
		HSName.setBounds(575, 13, 203, 53);
		contentPane.add(HSName);

		JLabel C_Name = new JLabel("���e���W��");
		C_Name.setFont(new Font("�з���", Font.PLAIN, 20));
		C_Name.setBounds(41, 195, 105, 30);
		contentPane.add(C_Name);
		
		JLabel C_Comp_ProdModel = new JLabel("���e������");
		C_Comp_ProdModel.setFont(new Font("�з���", Font.PLAIN, 20));
		C_Comp_ProdModel.setBounds(249, 195, 105, 30);
		contentPane.add(C_Comp_ProdModel);
		
		JLabel C_CompQuan = new JLabel("���e���ƶq");
		C_CompQuan.setFont(new Font("�з���", Font.PLAIN, 20));
		C_CompQuan.setBounds(457, 195, 105, 30);
		contentPane.add(C_CompQuan);
		
		JLabel C_SellPrice = new JLabel("���e�����");
		C_SellPrice.setFont(new Font("�з���", Font.PLAIN, 20));
		C_SellPrice.setBounds(659, 195, 119, 30);
		contentPane.add(C_SellPrice);
		
		for(int i=0;i<10;i++){//���e���W�ٸ��
			lblNewLabel_1[i] = new JLabel();
			lblNewLabel_1[i].setBounds(41, 225+30*i, 105, 30);
			contentPane.add(lblNewLabel_1[i]);
		}
		for(int i=0;i<10;i++){//���e���������
			lblNewLabel_2[i] = new JLabel();
			lblNewLabel_2[i].setBounds(249, 225+30*i, 105, 30);
			contentPane.add(lblNewLabel_2[i]);
		}
		for(int i=0;i<10;i++){//�ƶq
			lblNewLabel_3[i] = new JLabel();
			lblNewLabel_3[i].setBounds(457, 225+30*i, 105, 30);
			contentPane.add(lblNewLabel_3[i]);
		}
		for(int i=0;i<10;i++){//���
			lblNewLabel_4 [i]= new JLabel();
			lblNewLabel_4[i].setBounds(659, 225+30*i, 119, 30);
			contentPane.add(lblNewLabel_4[i]);
		}
		for(int j=0;j<CNData.length;j++){
			lblNewLabel_4[j].setText(CNData[j][4]);
			lblNewLabel_1[j].setText(CNData[j][3]);
			lblNewLabel_2[j].setText(CNData[j][1]);
			lblNewLabel_3[j].setText(CNData[j][2]);
		}
		JButton button = new JButton("��^�W��");
		button.setFont(new Font("�з���", Font.PLAIN, 20));
		button.setBounds(676, 457, 128, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				dispose();
			}
		});
	}
	public void getCN(String CCN_Num){

	//	Connection conn;
		Statement statement;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		int numberOfRows = 0;
		int numberOfColumns =0;
		   
			
				try{
					statement = con.createStatement();			
					rs = statement.executeQuery("SELECT * FROM CNC Where CN_Model =  '"+CCN_Num+"'");
					rsMetaData = rs.getMetaData();
					while(rs.next()){numberOfRows++;};  //�p���Ʀ��X��
					
					rs = statement.executeQuery("SELECT * FROM CNC Where CN_Model =  '"+CCN_Num+"'");
				    rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					CNData=new String[numberOfRows][numberOfColumns+2];  //�Ω�s����X�����~�����M�{���w�s �M �q���`�ݨD�q
					int count2=0;
					while (rs.next()){  //������̪����
				    	
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	  CNData[count2][i-1]=rs.getObject(i).toString();	 
					    	  
					       }
					      count2++;
					     }
					int count3=0;
					for(int i=0;i<count2;i++){
						rs = statement.executeQuery("SELECT ProdName,ProdSellPrice FROM Prod Where ProdModel =  '"+CNData[i][1]+"'");
					while (rs.next()){  //������̪����
					    	  CNData[count3][3]=rs.getString("ProdName");	 
					    	  CNData[count3][4]=rs.getString("ProdSellPrice");	 	      
					    	  System.out.println(rs.getString("ProdName"));
					    	  System.out.println(rs.getString("ProdSellPrice"));
					     }
					count3++;
					}
					rs = statement.executeQuery("SELECT CNSN_Cost FROM CNSN Where CNSN_Model =  '"+CNData[0][0]+"'");
					while(rs.next()){
						cost = rs.getString("CNSN_Cost");
					}
				     
				     //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq ����
				     }catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} 
		
	}


