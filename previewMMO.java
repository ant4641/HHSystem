package HHSystem;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class previewMMO extends JFrame {

	private JPanel contentPane;
	Connection cc =null;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	static int numberOfRows=0;
	static int numberOfColumns=0;
	private String [] CTData;
	private Object[][]a,b;
	private int sum = 0;
	private String []names;
	private String MMOCTName;
	static String url = "";
	static String username = ""; 
	static String password = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					previewMMO frame = new previewMMO(null,"","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getMMO_NO(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		String strDate = sdFormat.format(d);	//���H���Ѫ�������дڳ�s��
		numberOfRows=0;
		int num = 1;
		try {			//��貣�X�s���дڳ�s���h�MDB�̤w���������A�����ܭn�[�Ʀr
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT MMO_Num FROM MMO Where MMO_Num LIKE '%"+strDate+"%'ORDER BY MMO_Num");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			if(numberOfRows!=0){  //�p�G�s���w�s�b�A�N���X��Ѹ̳̤j���s��
				names = new String[numberOfRows] ;
				int count = 0;
				rs = statement.executeQuery("SELECT MMO_Num FROM MMO Where MMO_Num LIKE '%"+strDate+"%'ORDER BY MMO_Num");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	  names[count] = rs.getObject(i).toString();	
			       }  
			      count++;
			}
			String strnum = names[count-1].substring(12); //���X�̤j�s����n���o���12�X��o�ƧǸ�
			num = Integer.parseInt(strnum);					//�N�ƧǸ��ন�Ʀr
			num++;											//�N�ƧǸ�+1
			String text = String.format("%03d", num);		//�b�ƧǸ��e���[3��0�A�����s���ƧǸ�
			strDate = "MMO-"+strDate+text;					//�N�@�}�l���ͪ����ʳ�s��(�P�Ѳ��ͪ�)�A�[�W�s���ƧǸ��A�����s�����ʳ�s��
			}
			else{
				String text = String.format("%03d", num);	//�p�G�@�}�l�o���ʳ�s���S�����ơA���N����Ѫ��Ĥ@����ʳ�A�ƧǸ���1
				strDate = "MMO-"+strDate+text;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strDate;
		
	}
	public void getCTD(String name){		//�Ω���X�Ȥ᪺�W�١B�ǯu�B�q�ܡB�a�}�B�I�ڱ���
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d = new Date();
		String strDate = sdFormat.format(d);
		numberOfRows =0;
		try {
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT CTName,CTTaxID,CTPhone,CTFax,CTAddr,CTPayCond FROM CT Where CTName = '"+name+"'");
			//MMO.MMO_SAcco_End
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			CTData = new String[numberOfColumns+1] ;
			while (rs.next()){
				for(int i=1; i<=numberOfColumns; i++)
				   {
					if(rs.getObject(i)==null){
						CTData[i-1] = "";
			    	 }else{
			    		 CTData[i-1]=rs.getObject(i).toString();	
			    	 }
				}
		  }  		
			rs = statement.executeQuery("SELECT MMO_SAcco_End FROM MMO Where MMO_CTName = '"+name+"'");
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			if(numberOfRows!=0){
			rs = statement.executeQuery("SELECT MMO_SAcco_End FROM MMO Where MMO_CTName = '"+name+"'");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	  if(rs.getObject(i)== null){
			    		  CTData[6] = strDate;
			    		  break;
			    	  }else
			    		  CTData[6]=rs.getObject(i).toString();	
				   }
				}
			}else{
				CTData[6] = strDate;
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getSMMD(String name){		//���X�X�f��̪����e��
		numberOfRows =0;
		try {
			statement = cc.createStatement();
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			//MMO.MMO_SAcco_End
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
		    while (rs.next()){						//�p�⦳�X���w�X�f���ӫ~
		      for(int i=1; i<=numberOfColumns; i++)
			   {
			     System.out.printf("%s\t",rs.getObject(i));			  	
		       }
		      System.out.println();	
		      numberOfRows++;
		     }
		    b=new Object[numberOfRows][numberOfColumns];		
		    System.out.println(numberOfRows);	
			int order = 0;
			rs = statement.executeQuery("SELECT SM.SM_CTName,Prod.ProdModel,SMM.SM_Num,Prod.ProdName,SMM.SM_ProdModel,SMM.SM_Quan,Prod.ProdSellPrice"
					+ " FROM SM,SMM,Prod Where SM.SM_CTName = '"+name+"' AND SM.SM_Num = SMM.SM_Num AND SMM.SM_ProdModel = Prod.ProdModel");
			while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
			    	 if(rs.getObject(i)==null){		//�N�X�f���ӫ~��Ʃ�iB�}�C��
			    		 b[order][i-1]="";
			    	 }else{
			    		 b[order][i-1]=rs.getObject(i);	
			    	 }
				     		  	
			       }
			      order++;
			 }
			a = new Object[numberOfRows+1][7];		
			for(int i=0;i<numberOfRows;i++){
				a[i][0] = b[i][2];
				a[i][1] = b[i][3];
				a[i][2] = b[i][1];
				a[i][3] = b[i][5];
				a[i][4] = b[i][6];
				int count = (Integer) a[i][3]* (Integer) a[i][4];
				a[i][5] = count;
				a[i][6] = "";
				sum = sum + count;
			}
			Object [] sumarr  = new Object[]{"","","","","","",sum};
			for(int i=0;i<7;i++)
			a[numberOfRows][i] = sumarr[i];
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public previewMMO(final Connection conn, final String name,final String URL,final String UN,final String PW) {
		setResizable(false);
		setTitle("\u8ACB\u6B3E\u55AE");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cc=conn;
		MMOCTName = name;
		url = URL;
		username = UN;
		password = PW;
		getCTD(name);
		
		JLabel MMO_Num = new JLabel("�дڳ渹�X�G"+getMMO_NO());
		MMO_Num.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		MMO_Num.setBounds(262, 12, 292, 39);
		contentPane.add(MMO_Num);
		
		JLabel busname = new JLabel("�x����~�������q");
		busname.setFont(new Font("�з���", Font.ITALIC, 36));
		busname.setBounds(583, 1, 302, 50);
		contentPane.add(busname);
		
		JLabel CTName = new JLabel("�Ȥ�W�١G"+CTData[0]);
		CTName.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		CTName.setBounds(51, 60, 292, 39);
		contentPane.add(CTName);
		
		JLabel CTTaxID = new JLabel("�Τ@�s���G"+CTData[1]);
		CTTaxID.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		CTTaxID.setBounds(350, 65, 252, 28);
		contentPane.add(CTTaxID);
		
		JLabel CTPhone = new JLabel("�q�ܡG"+CTData[2]);
		CTPhone.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		CTPhone.setBounds(49, 111, 176, 34);
		contentPane.add(CTPhone);
		
		JLabel CTFax = new JLabel("�ǯu�G"+CTData[3]);
		CTFax.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		CTFax.setBounds(350, 115, 167, 26);
		contentPane.add(CTFax);
		
		JLabel CTMMAddr = new JLabel("���q�a�}�G"+CTData[4]);
		CTMMAddr.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		CTMMAddr.setBounds(51, 155, 394, 28);
		contentPane.add(CTMMAddr);
		System.out.println(CTData[6]);
		int year = Integer.parseInt(CTData[6].substring(0, 4));
		int month = Integer.parseInt(CTData[6].substring(5, 7));
		int day = Integer.parseInt(CTData[6].substring(8));
		String md = "";
		switch(CTData[5]){
			case "���30��":{
				if(month==3||month==5||month==7||month==8||month==10||month==12){
					if(day==30||day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						month = month-1;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else if(month==1){
					if(day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						System.out.println("OK");
						year = year-1;
						month = 12;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else{
					month = month-1;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				break;
			}
			case "���뵲60��":{
				if(month!=1||month!=2){
				if(day==31){
					month = month -1;
					day = 1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
					break;
				}else{
					month = month-2;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				
			}else{
					year = year-1;
					if(month==1){
						if(day==31){
							month = month -1;
							day = 1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
							break;
						}else{
							month = month-2;
							day = day+1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						}
					}else{
							month = month-2;
							day = day+1;
							md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						}
					}
					break;
				}
			default :{
				if(month==3||month==5||month==7||month==8||month==10||month==12){
					if(day==30||day==31){
						day = 1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}else{
						month = month-1;
						day = day+1;
						md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
						break;
					}
				}else{
					month = month-1;
					day = day+1;
					md = String.format("%04d", year)+"/"+String.format("%02d", month)+"/"+String.format("%02d", day);
				}
				break;
			}
		}
		final String MMO_SAcco_Start = md;
		JLabel MMO_SAcco = new JLabel("���b����G"+MMO_SAcco_Start+"  ��    "+CTData[6]);
		MMO_SAcco.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		MMO_SAcco.setBounds(51, 193, 394, 28);
		contentPane.add(MMO_SAcco);
		
		getSMMD(name);
		String[] cols={"�ʶR�渹","�ӫ~�W��","�ӫ~����","�ƶq","���","�p�p","�`�p���B"};
		JTable table;
		
		table= new JTable(a,cols);
		table.setFont(new Font("�s�ө���", Font.PLAIN, 16));
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		TableColumn column;
		column=table.getColumnModel().getColumn(0);
		column.setPreferredWidth(250);
		column=table.getColumnModel().getColumn(1);
		column.setPreferredWidth(250);
		column=table.getColumnModel().getColumn(2);
		column.setPreferredWidth(330);
		column=table.getColumnModel().getColumn(3);
		column.setPreferredWidth(70);
		column=table.getColumnModel().getColumn(4);
		column.setPreferredWidth(100);
		column=table.getColumnModel().getColumn(5);
		column.setPreferredWidth(150);
		column=table.getColumnModel().getColumn(6);
		column.setPreferredWidth(150);

		JScrollPane SP=new JScrollPane(table);
		SP.setBounds(51, 231, 598, 383);
		contentPane.add(SP);
		
		JLabel label = new JLabel("�X�p���B�G"+sum);
		label.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		label.setBounds(635, 172, 250, 28);
		contentPane.add(label);
		int a = (int) (sum*0.05);
		a=(int)(sum*1.05);
		
		JLabel InvoNum_lb = new JLabel("�o�����X�G");
		InvoNum_lb.setFont(new Font("�s�ө���", Font.PLAIN, 20));
		InvoNum_lb.setBounds(636, 116, 102, 28);
		contentPane.add(InvoNum_lb);
		
		final JTextField InvoNum_tf = new JTextField();
		InvoNum_tf.setBounds(741, 120, 130, 25);
		contentPane.add(InvoNum_tf);
		
		JButton btnNewButton = new JButton("�T�w�s�W");
		btnNewButton.setBounds(772, 643, 99, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("��^");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMMO nmmo=new NewMMO(cc,"SM_CTName","",URL,UN,PW);
				nmmo.setVisible(true);
				dispose();
			}
		});
		button.setBounds(663, 643, 99, 27);
		contentPane.add(button);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement statement;
				int isUpdate = 0;
				System.out.println(MMO_SAcco_Start);
				if(InvoNum_tf.getText().equals("")){
					JOptionPane.showMessageDialog(previewMMO.this, "�o�����X���i���ť�","�ŭȿ��~",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					try{
						if(screenSave("D:/HHSystem/MakeMoneyPapers/")==true){
							try {
								String mmonum = getMMO_NO();
								//System.out.println("�s�����\");
								statement = cc.createStatement();
								try{
									isUpdate = statement.executeUpdate("INSERT into MMO(MMO_Num,MMO_InvoNum,MMO_SAcco_Start,MMO_SAcco_End,MMO_CTName)"
											+ "VALUES('"+mmonum+"','"+InvoNum_tf.getText()+"','"+MMO_SAcco_Start+"','"+CTData[6]+"','"+MMOCTName+"')");
									isUpdate += statement.executeUpdate("Update SM set MMO_Num = '"+mmonum+"' Where SM_CTName = '"+name+"' AND SM_check='0' ");
									
								}catch(SQLException sqlException){
									sqlException.printStackTrace();
								}
								if(isUpdate>0){
									JOptionPane.showMessageDialog(previewMMO.this, "�Ш� D:HHSystem/MakeMomeyPapers/�̽T�{�I�� ","�s�W�дڳ榨�\",JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}else{
									JOptionPane.showMessageDialog(previewMMO.this, "�s�W�дڳ��ƥ��� !","�s�W����",JOptionPane.WARNING_MESSAGE);
									int result=JOptionPane.showConfirmDialog(previewMMO.this,
								               "�T�w�n�����{����?",
								               "�T�{�T��",
								               JOptionPane.YES_NO_OPTION,
								               JOptionPane.WARNING_MESSAGE);
								    if (result==JOptionPane.YES_OPTION) {System.exit(0);}
								    
								}
							} catch (SQLException SQLe) {
								SQLe.printStackTrace();
							}

						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
			
				}
				
			}	
		});
	}
	
	public boolean screenSave(String path) throws Exception {
		
		Robot robot = new Robot();
		int xpoint=contentPane.getLocationOnScreen().x; //���o�����b����a��ɪ�X��
		int ypoint=contentPane.getLocationOnScreen().y;	//���o�����b����a��ɪ�Y��
		int width=contentPane.getBounds().width;		//���o�������e��
		int height=contentPane.getBounds().height-83;	////���o�������e�ר� ��h�̤U�褣�n�I�Ϫ�����������
		Rectangle rect = new Rectangle(xpoint,ypoint,width,height);	//�o�̳]�w����x,y���_�l�ȩM�^�����������M�e�j�p
		BufferedImage image = robot.createScreenCapture(rect);
		boolean checkPrint=false;
		File F=new File(path);
		//System.out.println("--"+F.exists());
		if(F.exists()==false){
			JOptionPane.showMessageDialog(previewMMO.this, "�Х��� D��(D:/HHSystem)�̷s�W'MakeMoneyPapers'��Ƨ�","�L�X�f��s���Ƨ�",JOptionPane.INFORMATION_MESSAGE);		
		}else{
			F=new File("D:/HHSystem/MakeMoneyPapers/MMO"+getMMO_NO()+".jpg");
			checkPrint=ImageIO.write(image, "jpg",F);
		}
		System.out.println(checkPrint);
		
		return checkPrint;
		}
}
