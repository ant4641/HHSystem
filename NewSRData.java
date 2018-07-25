package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class NewSRData extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTextField SRName;
	private JTextField SRPhone;
	private JTextField SRAddr;
	private JTextField SRFax;
	private JTextField SRTaxID;
	private JTextField SRPIC;
	private JTextField SRFactPhone;
	private JTextField SRFactFax;
	private JTextField SRBusiPhone;
	private JTextField SRDLPhone;
	private JTextField SRNetAddr;
	private JTextField SREmail;
	private String str="";
	//private String EID = "20165423";
	JCheckBox chckbxNewCheckBox = new JCheckBox("�s�y�B�[�u");
	JCheckBox checkBox = new JCheckBox("�R��~");
	JCheckBox checkBox_1 = new JCheckBox("�ҰȡB�A�ȷ~");
	JCheckBox checkBox_2 = new JCheckBox("��µ�B�ؿv�~");
	JCheckBox checkBox_3 = new JCheckBox("�D��Q�Ʒ~");
	//��ƮwJDBC Driver�W��
	static String url = "";
	static String username = ""; 
	static String password = ""; 
	private JTextField SRInvoAddr;
	private JTextField SRFactAddr;
	Connection cc;
	/**
	 * Launch the application.
	 */
	public static void main(Connection conn,String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSRData frame = new NewSRData(null,"","","","","");//NewSRData(String ID)
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
	public NewSRData(Connection conn,final String EN,final String EI,final String URL,final String UN,final String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cc=conn;
		url = URL;
		username = UN;
		password = PW;
		JLabel label = new JLabel("�x����~�������q");
		label.setFont(new Font("�з���", Font.ITALIC, 20));
		label.setBounds(581, 10, 165, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("�s�W�����Ӱ򥻸��");
		label_1.setFont(new Font("�з���", Font.PLAIN, 37));
		label_1.setBounds(191, 30, 349, 40);
		contentPane.add(label_1);
		
		JLabel Name1 = new JLabel("�����ӦW�١G");
		Name1.setFont(new Font("�з���", Font.PLAIN, 18));
		Name1.setBounds(30, 122, 108, 23);
		contentPane.add(Name1);
		
		SRName = new JTextField();
		SRName.setBounds(135, 125, 96, 21);
		contentPane.add(SRName);
		SRName.setColumns(10);
		
		JLabel Phone = new JLabel("�����ӹq�ܡG");
		Phone.setFont(new Font("�з���", Font.PLAIN, 18));
		Phone.setBounds(241, 121, 108, 23);
		contentPane.add(Phone);
		
		SRPhone = new JTextField();
		SRPhone.setText("");
		SRPhone.setColumns(10);
		SRPhone.setBounds(359, 125, 96, 21);
		contentPane.add(SRPhone);
		
		JLabel Addr = new JLabel("�����Ӧa�}�G");
		Addr.setFont(new Font("�з���", Font.PLAIN, 18));
		Addr.setBounds(30, 254, 108, 23);
		contentPane.add(Addr);
		
		SRAddr = new JTextField();
		SRAddr.setColumns(10);
		SRAddr.setBounds(171, 256, 547, 21);
		contentPane.add(SRAddr);
		
		JLabel Fax = new JLabel("�����Ӷǯu�G");
		Fax.setFont(new Font("�з���", Font.PLAIN, 18));
		Fax.setBounds(30, 155, 108, 23);
		contentPane.add(Fax);
		
		SRFax = new JTextField();
		SRFax.setColumns(10);
		SRFax.setBounds(135, 158, 96, 21);
		contentPane.add(SRFax);
		
		JLabel TaxID = new JLabel("�����ӲΤ@�s���G");
		TaxID.setFont(new Font("�з���", Font.PLAIN, 18));
		TaxID.setBounds(241, 155, 154, 23);
		contentPane.add(TaxID);
		
		SRTaxID = new JTextField();
		SRTaxID.setColumns(10);
		SRTaxID.setBounds(382, 158, 96, 21);
		contentPane.add(SRTaxID);
		
		JLabel PIC = new JLabel("�����ӭt�d�H�G");
		PIC.setFont(new Font("�з���", Font.PLAIN, 18));
		PIC.setBounds(488, 155, 134, 23);
		contentPane.add(PIC);
		
		SRPIC = new JTextField();
		SRPIC.setColumns(10);
		SRPIC.setBounds(622, 158, 96, 21);
		contentPane.add(SRPIC);
		
		JLabel FactPhone = new JLabel("�����Ӥu�t�q�ܡG");
		FactPhone.setFont(new Font("�з���", Font.PLAIN, 18));
		FactPhone.setBounds(30, 188, 144, 23);
		contentPane.add(FactPhone);
		
		SRFactPhone = new JTextField();
		SRFactPhone.setColumns(10);
		SRFactPhone.setBounds(171, 191, 165, 21);
		contentPane.add(SRFactPhone);
		
		JLabel FactFax = new JLabel("�����Ӥu�t�ǯu�G");
		FactFax.setFont(new Font("�з���", Font.PLAIN, 18));
		FactFax.setBounds(369, 188, 144, 23);
		contentPane.add(FactFax);
		
		SRFactFax = new JTextField();
		SRFactFax.setColumns(10);
		SRFactFax.setBounds(510, 191, 166, 21);
		contentPane.add(SRFactFax);
		
		JLabel BusiPhone = new JLabel("�����ӷ~�ȹq�ܡG");
		BusiPhone.setFont(new Font("�з���", Font.PLAIN, 18));
		BusiPhone.setBounds(30, 221, 144, 23);
		contentPane.add(BusiPhone);
		
		SRBusiPhone = new JTextField();
		SRBusiPhone.setColumns(10);
		SRBusiPhone.setBounds(171, 224, 165, 21);
		contentPane.add(SRBusiPhone);
		
		JLabel DLPhone = new JLabel("�����ӱM�u�q�ܡG");
		DLPhone.setFont(new Font("�з���", Font.PLAIN, 18));
		DLPhone.setBounds(369, 221, 144, 23);
		contentPane.add(DLPhone);
		
		SRDLPhone = new JTextField();
		SRDLPhone.setColumns(10);
		SRDLPhone.setBounds(510, 224, 165, 21);
		contentPane.add(SRDLPhone);
		
		JLabel NetAddr = new JLabel("�����Ӻ��}�G");
		NetAddr.setFont(new Font("�з���", Font.PLAIN, 18));
		NetAddr.setBounds(30, 347, 108, 23);
		contentPane.add(NetAddr);
		
		SRNetAddr = new JTextField();
		SRNetAddr.setColumns(10);
		SRNetAddr.setBounds(177, 349, 541, 21);
		contentPane.add(SRNetAddr);
		
		SREmail = new JTextField();
		SREmail.setColumns(10);
		SREmail.setBounds(177, 382, 541, 21);
		contentPane.add(SREmail);
		
		JLabel Email = new JLabel("�����ӫH�c�G");
		Email.setFont(new Font("�з���", Font.PLAIN, 18));
		Email.setBounds(30, 380, 108, 23);
		contentPane.add(Email);
		
		ButtonGroup checkbox = new ButtonGroup();
		checkbox.add(chckbxNewCheckBox);
		checkbox.add(checkBox);
		checkbox.add(checkBox_1);
		checkbox.add(checkBox_2);
		checkbox.add(checkBox_3);
		chckbxNewCheckBox.setFont(new Font("�з���", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(117, 70, 134, 23);
		contentPane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(this);
		
		JLabel IndCate = new JLabel("���~�O�G");
		IndCate.setFont(new Font("�з���", Font.PLAIN, 18));
		IndCate.setBounds(30, 68, 81, 23);
		contentPane.add(IndCate);
		
		
		checkBox.setFont(new Font("�з���", Font.PLAIN, 16));
		checkBox.setBounds(346, 70, 144, 23);
		contentPane.add(checkBox);
		checkBox.addItemListener(this);
		
		checkBox_1.setFont(new Font("�з���", Font.PLAIN, 16));
		checkBox_1.setBounds(584, 70, 134, 23);
		contentPane.add(checkBox_1);
		checkBox_1.addItemListener(this);
		
		checkBox_2.setFont(new Font("�з���", Font.PLAIN, 16));
		checkBox_2.setBounds(117, 93, 134, 23);
		contentPane.add(checkBox_2);
		checkBox_2.addItemListener(this);
		
		checkBox_3.setFont(new Font("�з���", Font.PLAIN, 16));
		checkBox_3.setBounds(346, 95, 134, 23);
		contentPane.add(checkBox_3);
		checkBox_3.addItemListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(checkBox);
		group.add(checkBox_1);
		group.add(checkBox_2);
		group.add(checkBox_3);
		group.add(chckbxNewCheckBox);
		checkBox.addItemListener(this);
		checkBox_1.addItemListener(this);
		checkBox_2.addItemListener(this);
		checkBox_3.addItemListener(this);
		chckbxNewCheckBox.addItemListener(this);
		
		
		final NewSRData clone =this;
		final String[] SR=new String[15];
		JButton button = new JButton("�s�W");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Statement statement;
				ResultSet rs;
				ResultSetMetaData rsMetaData;
				//�ˬd�O�_���ŭ�
				String SRName2,SRNum2,SRAddr2,SRPhone2,SRFax2,SRTaxID2,SRPIC2,SRInvoAddr2,SRFactAddr2
				,SRFactPhone2,SRFactFax2,SRBusiPhone2,SRDLPhone2,SRNetAddr2,SREmail2;
				SRName2=SRName.getText();
				
				SRAddr2=SRAddr.getText();
				SRPhone2=SRPhone.getText();
				SRFax2=SRFax.getText();
				SRTaxID2=SRTaxID.getText();
				SRPIC2=SRPIC.getText();
				SRInvoAddr2=SRInvoAddr.getText();
				SRFactAddr2=SRFactAddr.getText();
				SRFactPhone2=SRFactPhone.getText();
				SRFactFax2=SRFactFax.getText();
				SRBusiPhone2=SRBusiPhone.getText();
				SRDLPhone2=SRDLPhone.getText();
				SRNetAddr2=SRNetAddr.getText();
				SREmail2=SREmail.getText();
				int empty=0;
				
				//������s�W�����~��Ʃ�iSTring�}�C�ǰe
				SR[0]=SRName.getText().trim();
				
				SR[2]=SRAddr.getText().trim();
				SR[3]=SRPhone.getText().trim();
				SR[4]=SRFax.getText().trim();
				SR[5]=SRTaxID.getText().trim();
				SR[6]=SRPIC.getText().trim();
				SR[7]=SRInvoAddr.getText().trim();
				SR[8]=SRFactAddr.getText().trim();
				SR[9]=SRFactPhone.getText().trim();
				SR[10]=SRFactFax.getText().trim();
				SR[11]=SRBusiPhone.getText().trim();
				SR[12]=SRDLPhone.getText().trim();
				SR[13]=SRNetAddr.getText().trim();
				SR[14]=SREmail.getText().trim();
				
				try{
					if("".equals(SRName2.toString().trim())){empty++;};
					if("".equals(SRAddr2.toString().trim())){empty++;}
					if("".equals(SRPhone2.toString().trim())){empty++;}
					if("".equals(SRFax2.toString().trim())){empty++;}
					if("".equals(SRTaxID2.toString().trim())){empty++;}
					if("".equals(SRPIC2.toString().trim())){empty++;}
					if("".equals(SRInvoAddr2.toString().trim())){empty++;}	
					if("".equals(SRFactAddr2.toString().trim())){empty++;}
					if("".equals(SRFactPhone2.toString().trim())){empty++;}
					if("".equals(SRFactFax2.toString().trim())){empty++;}
					if("".equals(SRBusiPhone2.toString().trim())){empty++;}
					if("".equals(SRDLPhone2.toString().trim())){empty++;}
					if("".equals(SRNetAddr2.toString().trim())){empty++;}
					if("".equals(SREmail2.toString().trim())){empty++;}
						System.out.println("OK"); 
			
					
					System.out.println(str);
					if(empty!=0||str.equals("")){
						JOptionPane.showMessageDialog(NewSRData.this, "��Ƥ��i���ŭ�", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					}else if(SREmail2.toString().trim().matches("(([A-Za-z0-9]+\\.?)+([A-Za-z0-9]+_?)+)+[A-Za-z0-9]+@([a-zA-Z0-9]+\\.)+(com|edu|gov)(\\.(tw|ch|hk))?")) 
						{
						if(!checkSR(SRName2,SRTaxID2).equals(SRName2)){
							int check=1;//��ƨS����check=1
							if(check==1){
								PreviewNEWSRData PD =new PreviewNEWSRData(cc,clone,SRName.getText(),SRAddr.getText(),SRPhone.getText(),SRFax.getText(),SRTaxID.getText(),SRPIC.getText(),SRInvoAddr.getText()
										,SRFactAddr.getText(),SRFactPhone.getText(),SRFactFax.getText(),SRBusiPhone.getText(),SRDLPhone.getText()
										,SRNetAddr.getText(),SREmail.getText(),str,EN,EI,url,username,password);
								PD.setAlwaysOnTop(true); 
								PD.requestFocus();  
								PD.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(NewSRData.this, "�����ӦW�٭���","�s�W���~",JOptionPane.WARNING_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(NewSRData.this, "��ƭ���","�s�W���~",JOptionPane.WARNING_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(NewSRData.this, "�H�c�榡���~�A�ХHabc@xxx.com.tw����","�s�W���~",JOptionPane.WARNING_MESSAGE);
						}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(NewSRData.this, "��J���~", "ĵ�i", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		button.setFont(new Font("�з���", Font.PLAIN, 18));
		button.setBounds(646, 425, 76, 40);
		contentPane.add(button);
		
		JLabel InvoAddr = new JLabel("�����ӵo����}�G");
		InvoAddr.setFont(new Font("�з���", Font.PLAIN, 18));
		InvoAddr.setBounds(30, 287, 144, 23);
		contentPane.add(InvoAddr);
		
		SRInvoAddr = new JTextField();
		SRInvoAddr.setColumns(10);
		SRInvoAddr.setBounds(177, 289, 541, 21);
		contentPane.add(SRInvoAddr);
		
		JLabel FactAddr = new JLabel("�����Ӥu�t�a�}�G");
		FactAddr.setFont(new Font("�з���", Font.PLAIN, 18));
		FactAddr.setBounds(30, 320, 144, 23);
		contentPane.add(FactAddr);
		
		SRFactAddr = new JTextField();
		SRFactAddr.setColumns(10);
		SRFactAddr.setBounds(177, 322, 541, 21);
		contentPane.add(SRFactAddr);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		int empty=0;
		int state = e.getStateChange();
		if(state==ItemEvent.SELECTED)
			try{
			if(e.getItem()==chckbxNewCheckBox){
				str = chckbxNewCheckBox.getText();
				}
		if(e.getItem()==checkBox){
			str = checkBox.getText();
			}
		if(e.getItem()==checkBox_1){
			str = checkBox_1.getText();
			}
		if(e.getItem()==checkBox_2){
			str = checkBox_2.getText();
			}
		if(e.getItem()==checkBox_3){
			str = checkBox_3.getText();
			}
		
		}catch(NumberFormatException n){
			JOptionPane.showMessageDialog(NewSRData.this, "��J���~", "ĵ�i", JOptionPane.WARNING_MESSAGE);
			n.printStackTrace();
			}
		}
	public String checkSR(final String SRName3,final String SRTaxID3){
		 
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   String checkname="";
		   String checktaxID="";
		  // String checkA_Num="";
		   int numberOfColumns;
			   try{
				   statement = cc.createStatement();
				   try{
					   rs = statement.executeQuery("Select SRName,SRTaxID From SR where SRName='"+SRName3+"' OR SRTaxID='"+SRTaxID3+"'");
					   rsMetaData = rs.getMetaData();
					   numberOfColumns = rsMetaData.getColumnCount();
					   while (rs.next()){  //������̪����
						   for(int i=1; i<=numberOfColumns; i++)
						   {
							   if(rs.getObject(i).equals(SRName3)){ 
								   checkname=(String)rs.getObject(i);	 
								   break;
								   }	  	
							   }
						   }
				   }catch(SQLException SQLe){
					   SQLe.printStackTrace();
				   }
			   }catch(SQLException SQLe){
				   SQLe.printStackTrace();
			   }
		   return checkname;
		   }
	}
