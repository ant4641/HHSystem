package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import java.awt.Scrollbar;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTextArea;

public class previewNO extends JFrame {
	
	private JPanel contentPane;
	private JLabel CTPhone_lb;
	private JLabel proset[]=new JLabel [20];
	private JLabel modset[]=new JLabel[20];
	private JLabel quaset[]=new JLabel[20];
	private String[][] csnn=new String[0][0];	//�����X�ǳƹ�Ӫ��ӫ~�����B�w�s�B�q��ݭn�ƶq
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewNO frame = new previewNO(null,null,"","","","","","",null,null,null, "", "", "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param password 
	 * @param username 
	 * @param url 
	 */
	public previewNO(final Connection conn,neworder nw ,final String OR_Date,final String CTName_ta,final String CTNum_ta,
			final String OR_Num,final String PS ,final String ApptEID,final String[] pro,
			final String[] mod,final String[] qua,String URL, String UN, String PW) {
		setResizable(false);
		
		final neworder NOframe = nw;
		String[] PhFa=new String[3];
		
		setResizable(false);
		setTitle("\u9810\u89BD\u65B0\u589E");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 876, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		con=conn;
		url=URL;
		username=UN;
		password=PW;
		
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("�з���", Font.ITALIC, 20));
		label.setBounds(691, 10, 165, 40);
		contentPane.add(label);
		
		JLabel OR_Date_lb = new JLabel("\u8A02\u55AE\u65E5\u671F\uFF1A"+OR_Date);
		OR_Date_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		OR_Date_lb.setBounds(54, 20, 236, 21);
		contentPane.add(OR_Date_lb);
		
		JLabel label_2 = new JLabel("\u65B0\u589E\u8A02\u55AE");
		label_2.setFont(new Font("�з���", Font.PLAIN, 37));
		label_2.setBounds(360, 25, 160, 40);
		contentPane.add(label_2);
		
		JLabel OR_Num_lb = new JLabel("\u8A02\u55AE\u865F\u78BC\uFF1A"+OR_Num);
		OR_Num_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		OR_Num_lb.setBounds(608, 75, 239, 21);
		contentPane.add(OR_Num_lb);
		
		JLabel label_4 = new JLabel("\u6578\u91CF");
		label_4.setFont(new Font("�з���", Font.PLAIN, 20));
		label_4.setBounds(773, 153, 62, 26);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		label_5.setFont(new Font("�з���", Font.PLAIN, 20));
		label_5.setBounds(597, 156, 150, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u7522\u54C1\u540D\u7A31");
		label_6.setFont(new Font("�з���", Font.PLAIN, 20));
		label_6.setBounds(466, 153, 101, 26);
		contentPane.add(label_6);
		
		JLabel OR_PurQuan_lb = new JLabel("\u6578\u91CF");
		OR_PurQuan_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		OR_PurQuan_lb.setBounds(376, 153, 62, 26);
		contentPane.add(OR_PurQuan_lb);
		
		JLabel ProdModel_lb = new JLabel("\u578B\u865F(\u542B\u898F\u683C)");
		ProdModel_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		ProdModel_lb.setBounds(181, 156, 173, 21);
		contentPane.add(ProdModel_lb);
		
		JLabel ProdName_lb = new JLabel("\u7522\u54C1\u540D\u7A31");
		ProdName_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		ProdName_lb.setBounds(54, 153, 101, 26);
		contentPane.add(ProdName_lb);
		
		
		PhFa=getPhoFax(CTName_ta);
		CTPhone_lb = new JLabel("\u5BA2\u6236\u96FB\u8A71\uFF1A"+PhFa[2]);
		CTPhone_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		CTPhone_lb.setBounds(321, 106, 271, 21);
		contentPane.add(CTPhone_lb);
		
		JLabel CTFax_lb = new JLabel("\u5BA2\u6236\u50B3\u771F\uFF1A"+PhFa[1]);
		CTFax_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		CTFax_lb.setBounds(321, 75, 263, 21);
		contentPane.add(CTFax_lb);
		
		JLabel CTNum_lb = new JLabel("\u5BA2\u6236\u7DE8\u865F\uFF1A"+CTNum_ta);
		CTNum_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		CTNum_lb.setBounds(54, 75, 237, 21);
		contentPane.add(CTNum_lb);
		
		JLabel CTName_lb = new JLabel("\u5BA2\u6236\u540D\u7A31\uFF1A"+CTName_ta);
		CTName_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		CTName_lb.setBounds(54, 106, 248, 21);
		contentPane.add(CTName_lb);
		
		JLabel OR_Appt_EID_lb = new JLabel("\u586B\u55AE\u4EBA:"+ApptEID);
		OR_Appt_EID_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		OR_Appt_EID_lb.setBounds(608, 106, 236, 21);
		contentPane.add(OR_Appt_EID_lb);
		
		JLabel PS_lb = new JLabel("\u5099\u8A3B\uFF1A"+PS);
		PS_lb.setFont(new Font("�з���", Font.PLAIN, 20));
		PS_lb.setBounds(54, 604, 575, 31);
		contentPane.add(PS_lb);
		
		for(int i=0;i<10;i++){
			proset[i]=new JLabel();
			proset[i].setFont(new Font("�з���", Font.PLAIN, 20));
			proset[i].setBounds(54,189+38*i, 123, 26);
			contentPane.add(proset[i]);
			//prod[i].setVisible(false);

		}
		for(int i=0;i<10;i++){
			modset[i]=new JLabel();
			modset[i].setFont(new Font("�з���", Font.PLAIN, 20));
			modset[i].setBounds(181,189+38*i, 150, 26);
			contentPane.add(modset[i]);
			//prod[i].setVisible(false);

		}
		//�إ�10�ӭq�ʼƶq
		for(int i=0;i<10;i++){
			quaset[i]=new JLabel();
			quaset[i].setFont(new Font("�з���", Font.PLAIN, 20));
			quaset[i].setBounds(376,189+38*i, 46, 26);
			contentPane.add(quaset[i]);
			//prod[i].setVisible(false);

		}
			//�إ�����10�Ӳ��~�W��
			for(int i=10;i<20;i++){
				proset[i]=new JLabel();
				proset[i].setFont(new Font("�з���", Font.PLAIN, 20));
				proset[i].setBounds(466,189+38*(i-10), 123, 26);
				contentPane.add(proset[i]);
				//pro[i].setVisible(false);
	
			}
			//�إ�����10�Ӳ��~����
			for(int i=10;i<20;i++){
				modset[i]=new JLabel();
				modset[i].setFont(new Font("�з���", Font.PLAIN, 20));
				modset[i].setBounds(597,189+38*(i-10), 123, 26);
				contentPane.add(modset[i]);
				//mod[i].setVisible(false);
	
			}
			//�إ�����10�ӭq�ʼƶq
			for(int i=10;i<20;i++){
				quaset[i]=new JLabel();
				quaset[i].setFont(new Font("�з���", Font.PLAIN, 20));
				quaset[i].setBounds(773,189+38*(i-10), 46, 26);
				contentPane.add(quaset[i]);
				//qua[i].setVisible(false);
			}
			
			int procount=0;  //�p��w��J�w�����ϥΪ̬ݪ��ӫ~��
			int put=0;		 //�W�٭��ƪ��A�ƶq�������[�_��
			try{
			for(int i=0 ;i<20 ;i++){
				if((!pro[i].equals(""))&&(!mod[i].equals(""))&&(!qua[i].equals(""))){
					for(int k=0 ;k<20 ;k++){
						if((pro[i].equals(proset[k].getText()))&&(mod[i].equals(modset[k].getText()))){
							//�N���|�s�W���ӫ~���ئA��J�T�{�����Q���ˬd�H��J���ӫ~���S�����M�W�٤@�˪��A��ƶq�[�b�@�_
							int qq=Integer.parseInt(quaset[k].getText());
							qq+=Integer.parseInt(qua[i]);
							quaset[k].setText(""+qq);
							put=1;
						}
					}
					if(put!=1){
					proset[procount].setText(pro[i]);
					modset[procount].setText(mod[i]);
					quaset[procount].setText(qua[i]);
					procount++;
					}
					put=0;		//�@�Ӱӫ~�񧹫ᰵ�k�s
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			JButton backEditor_Btn = new JButton("\u8FD4\u56DE\u7DE8\u8F2F");
			backEditor_Btn.setFont(new Font("�з���", Font.PLAIN, 17));
			backEditor_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NOframe.setVisible(true);
					dispose();
				}
			});
			backEditor_Btn.setBounds(639, 600, 103, 41);
			contentPane.add(backEditor_Btn);
			
			final String[] pro2=new String[20];
			final String[] mod2=new String[20];
			final String[] qua2=new String[20];
			
			JButton comfirmAdd_Btn = new JButton("\u78BA\u5B9A\u65B0\u589E");
			comfirmAdd_Btn.setFont(new Font("�з���", Font.PLAIN, 17));
			comfirmAdd_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//������s�W�����~��Ʃ�iSTring�}�C�ǰe
					for(int i=0;i<20;i++){
						if(!proset[i].getText().trim().equals("")){
							pro2[i]=proset[i].getText().trim();
							mod2[i]=modset[i].getText().trim();
							qua2[i]=quaset[i].getText().trim();
							//System.out.println("pro2+mod2+qua2"+i+" :"+pro2[i]+"-"+mod2[i]+"-"+qua2[i]);
						}
					}
					Statement statement;
					
					if(checkstock(pro2,mod2,qua2)==true){

						int isUpdate = 0;
							try {
								System.out.println("�s�����\");
								statement = con.createStatement();
								try{
									isUpdate = statement.executeUpdate("INSERT into ORN(OR_Num,OR_Date,CTName,OR_Appt_EID,OR_ApplyDatev,OR_check,OR_Rejec,OR_Remark)VALUES('"+OR_Num+"','"+OR_Date+"','"+CTName_ta+"','"+ApptEID+"','"+OR_Date+"','0','','"+PS+"')");
									if(updateorderuqa(pro2,mod2,qua2)==true){
										for(int i=0; i<proset.length; i++){  //��ӫ~����iORN������table��!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
											if(!proset[i].getText().equals("")){
												isUpdate += statement.executeUpdate("INSERT into ORNCon(OR_Num,OR_ProdModel,OR_PurQuan)VALUES('"+OR_Num+"','"+modset[i].getText()+"','"+quaset[i].getText()+"')");
											}
										}
									}else{
										
									}
								}catch(SQLException sqlException){
									sqlException.printStackTrace();
								}
								if(isUpdate>0){
									System.out.println("noUpdate: "+isUpdate);
									
									JOptionPane.showMessageDialog(previewNO.this, "�s�W�q���Ʀ��\ !","�s�W���\",JOptionPane.INFORMATION_MESSAGE);
									dispose();
									//System.exit(0);
								}else{
									JOptionPane.showMessageDialog(previewNO.this, "�s�W�q���ƥ��� !","�s�W����",JOptionPane.WARNING_MESSAGE);
									int result=JOptionPane.showConfirmDialog(previewNO.this,
								               "�T�w�n�����{����?",
								               "�T�{�T��",
								               JOptionPane.YES_NO_OPTION,
								               JOptionPane.WARNING_MESSAGE);
								    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
								    
								}
							} catch (SQLException SQLe) {
								SQLe.printStackTrace();
							}
					}else{	//�s�W���w�ƭq��
						JOptionPane.showMessageDialog(previewNO.this, "�s�W���ӫ~�����w�s���������p�A�ЫO�d�ȥ��q��","�s�W����",JOptionPane.WARNING_MESSAGE);
						int result=JOptionPane.showConfirmDialog(previewNO.this,
					               "�T�w�n�����{����?",
					               "�T�{�T��",
					               JOptionPane.YES_NO_OPTION,
					               JOptionPane.WARNING_MESSAGE);
					    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
					    if (result==JOptionPane.NO_OPTION) { NOframe.setVisible(true);dispose();}
					
					}
					;
					
				}
			});
			comfirmAdd_Btn.setBounds(746, 600, 103, 41);
			contentPane.add(comfirmAdd_Btn);

	}
	public String[] getPhoFax(String CTName_ta2){
		
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String[] checknum2=new String[3];
		   int numberOfColumns;
		   
			try {
				//System.out.println("�s�����\");
				statement = con.createStatement();
				try{
					rs = statement.executeQuery("Select CTFax,CTPhone From CT where CTName='"+CTName_ta2+"'");
					rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();	
					while (rs.next()){  //������̪����
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					       //System.out.print(i+":");
						   // System.out.println((String)rs.getObject(i)+"\t");
						    checknum2[i]=(String)rs.getObject(i);   //���o�ǯu�M�q�ܩ�}�C�ǥX
						    //System.out.println("CT "+i+":"+checknum2[i]);
					       }
					   }	
				}catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		return checknum2;
	}
	
	public boolean checkstock(String[] pro3,String[] mod3,String[] qua3){
		
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   //String[][] csnn=new String[0][0];	//�����X�ǳƹ�Ӫ��ӫ~�����B�w�s�B�q��ݭn�ƶq
		   int numberOfColumns=0;
		   int numberOfRows=0;
		   
			try {
				//System.out.println("�s�����\");
				statement = con.createStatement();
				
				try{
				  //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq
				    int count2=0;
				    rs = statement.executeQuery("SELECT ProdModel,ProdNowInve,ProdOrderReqQuan FROM Prod");					
					rsMetaData = rs.getMetaData();
					while(rs.next()){numberOfRows++;};  //�p���Ʀ��X��
					
				    rs = statement.executeQuery("SELECT ProdModel,ProdNowInve,ProdOrderReqQuan FROM Prod");
				    rsMetaData = rs.getMetaData();
					numberOfColumns = rsMetaData.getColumnCount();
					
					csnn=new String[numberOfRows][3];  //�Ω�s����X�����~�����M�{���w�s �M �q���`�ݨD�q
					while (rs.next()){  //������̪����
				    	
					      for(int i=1; i<=numberOfColumns; i++)
						   {
					    	 System.out.print(i+":");
						     System.out.print(rs.getObject(i)+"\t");
						     //if(rs.getObject(i).toString())
						     csnn[count2][i-1]=rs.getObject(i).toString();					
						     System.out.println(count2+"-"+(i-1)+":"+csnn[count2][i-1]); 
					       }
					      count2++;
					      System.out.println();	
					     }
					
				     //���X���ݹ������ӫ~�����B�w�s�B�q���`�ƶq ����
				     }catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		
		//�����X��A���۶}�l���w�s�O�_����

		int checkStock=0 ;
		try{
			for(int i=0; i<20;i++){
				if(!pro3[i].equals("")){
					//System.out.println("pro3["+i+"]: "+pro3[i]);
					for(int k=0 ;k<csnn.length;k++){
						if(mod3[i].equals(csnn[k][0])){     //��Ƕi�Ӫ��M���X�Ӫ���ۦP����
							//System.out.println(mod3[i]+"----csmod["+k+"]: "+csmod[k]);
							int ss=Integer.parseInt(csnn[k][1])-Integer.parseInt(csnn[k][2]);  //��쫬����A��Ӱӫ~���w�s��h�q��ݨD�ƶq
							int qq=Integer.parseInt(qua3[i]); //���N�q�ʼƶq�j���૬��int�b�����
							if(qq>ss){
								String mess="���~:"+pro3[i]+" "+"����:"+mod3[i]+" ���w�s����";
								JOptionPane.showMessageDialog(previewNO.this,mess,"�w�s����ĵ�i",JOptionPane.WARNING_MESSAGE);
								checkStock++;
							}
						}
					}
				
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		if(checkStock==0){
			return true;
		}else
			return false;
		
	}
	
	public boolean updateorderuqa(String[] pro4,String[] mod4,String[] qua4){

		Statement statement;
		//System.out.println("pro4.length: "+pro4.length);
		//System.out.println("csnn.length: "+csnn.length);
		
		int isUpdate = 0;
		int checkcount =0; //�Ω�p��|�s�W���ӫ~�ƶq
			try {
				//System.out.println("�s�����\");
				statement = con.createStatement();
				try{
					int newOrderQua=0;
					for(int i=0; i<20; i++){
						//System.out.println("/////pro4["+i+"]--"+pro4[i]);
						if(pro4[i]!=null){
							checkcount++;
							//System.out.println("pro4["+i+"]"+pro4[i]);
							for(int k=0;k<csnn.length;k++){
									//System.out.println("pro4-2["+i+"]"+pro4[i]);
									if(mod4[i].equals(csnn[k][0])){		//�N�s�W���ӫ~�������DB�̫���
										//System.out.println("pro4-3["+i+"]"+pro4[i]);
										newOrderQua =Integer.parseInt(csnn[k][2]); //��즳���q��ݨD�`�q���X
										System.out.println("---csnn["+k+"][1]"+csnn[k][1]);
										newOrderQua+=Integer.parseInt(qua4[i]);
										System.out.println("----newOrderQua "+newOrderQua);
										isUpdate += statement.executeUpdate("UPDATE Prod SET ProdOrderReqQuan='"+newOrderQua+"' WHERE ProdModel='"+mod4[i]+"' AND ProdName='"+pro4[i]+"'");
									}
							}
						}
						newOrderQua=0;
					}
					System.out.println("checkcount: "+checkcount);
					if(isUpdate==checkcount){
						System.out.println("noUpdate2: "+isUpdate);
						JOptionPane.showMessageDialog(previewNO.this, "��s���~-�q��ݨD�q��Ʀ��\ !","�s�W���\",JOptionPane.INFORMATION_MESSAGE);
						//System.exit(0);
					}else{
						JOptionPane.showMessageDialog(previewNO.this, "��s���~-�q��ݨD�q��ƥ��� !","�s�W����",JOptionPane.WARNING_MESSAGE);
						int result=JOptionPane.showConfirmDialog(previewNO.this,
					               "�T�w�n�����{����?",
					               "�T�{�T��",
					               JOptionPane.YES_NO_OPTION,
					               JOptionPane.WARNING_MESSAGE);
					    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
					    }
					
				}
				catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
				
			} catch (SQLException SQLe) {
				SQLe.printStackTrace();
			}
		
		if(isUpdate==checkcount){
			return true;
		}else{
			return false;
		}
	}
}
