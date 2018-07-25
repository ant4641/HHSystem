package HHSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewProData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					NewProData frame = new NewProData(null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param PW 
	 * @param UN 
	 * @param URL 
	 */
	public NewProData(final Connection conn ,String URL, String UN, String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		
		
		JLabel label = new JLabel("洪陞實業有限公司");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(379, 10, 165, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("新增產品基本資料");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 37));
		label_1.setBounds(108, 37, 313, 40);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("產品型號：");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 97, 109, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(268, 101, 131, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("產品名稱：");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_2.setBounds(131, 137, 109, 30);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(268, 220, 131, 30);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("安全庫存量：");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(131, 217, 131, 30);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 139, 131, 30);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("產品出售價格：");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(131, 260, 140, 30);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(268, 260, 131, 30);
		contentPane.add(textField_3);
		
		final NewProData clone =this;
		final String[] prodata=new String[5];
		JButton button = new JButton("新增");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//檢查是否有空值
				String ProModel,ProName,ProNowInve,ProPrice,ProAbName;
				ProModel = textField.getText();
				ProName = textField_1.getText();
				ProNowInve =textField_2.getText();
				ProPrice =textField_3.getText();
				ProAbName = textField_4.getText();
				int empty=0;
				
				//把全部新增的產品資料放進STring陣列傳送
				prodata[0]=textField.getText().trim();
				prodata[1]=textField_1.getText().trim();
				prodata[2]=textField_2.getText().trim();
				prodata[3]=textField_3.getText().trim();
				prodata[4]=textField_4.getText().trim();
				
				
				try{
					if("".equals(ProModel.toString().trim())){empty++;}
					if("".equals(ProName.toString().trim())){empty++;}
					if("".equals(ProNowInve.toString().trim())){empty++;}
					if("".equals(ProPrice.toString().trim())){empty++;}
					if("".equals(ProAbName.toString().trim())){empty++;}
					
					if(empty==0){
						try{
							String str = textField_3.getText();
							int price = Integer.parseInt(str);
							String saveNov=textField_1.getText().trim();
							int sN= Integer.parseInt(saveNov);
							
							if(checkPro(ProModel,ProAbName)!=1){  //確認新增的產品型號和名稱是否重複
								PreviewNewProData PD =new PreviewNewProData(conn,clone,textField.getText(),
										textField_2.getText(),textField_4.getText(),textField_1.getText(),
										textField_3.getText(),
										url,username,password);
								PD.setAlwaysOnTop(true); 
								PD.requestFocus();  
								PD.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(NewProData.this, "資料型號或簡稱重複","新增錯誤",JOptionPane.WARNING_MESSAGE);
							}
						}catch (NumberFormatException n){ 
								JOptionPane.showMessageDialog(NewProData.this, "價格應為數字", "警告", JOptionPane.WARNING_MESSAGE);
							}
						
					}else{
						JOptionPane.showMessageDialog(NewProData.this, "資料不可為空值", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(NewProData.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(433, 265, 82, 40);
		contentPane.add(button);
		
		JLabel label_5 = new JLabel("產品簡稱：");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_5.setBounds(131, 177, 109, 30);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(268, 179, 131, 30);
		contentPane.add(textField_4);
		
	}
	
	public int checkPro(final String ProModel,final String ProAbName){
		   Statement statement;
		   ResultSet rs;
		   ResultSetMetaData rsMetaData;
		   int checkmodel=0;
		   String[] ModelAbName=new String[2];
		   ModelAbName[0]=""; ModelAbName[1]=""; 
		   int numberOfColumns;
	
			   try{
				   //System.out.println("連接成功");
				   statement = con.createStatement();
				   try{
					   rs = statement.executeQuery("Select ProdModel,ProdAbName From Prod where ProdModel='"+ProModel+"' OR ProdAbName='"+ProAbName+"'");
					   rsMetaData = rs.getMetaData();
					   numberOfColumns = rsMetaData.getColumnCount();
					   while (rs.next()){  //顯示欄位裡的資料
						   for(int i=1; i<=numberOfColumns; i++)
						   {
							   
							   ModelAbName[i-1]= rs.getObject(i).toString();
							   System.out.println((i-1)+": "+ModelAbName[i-1]);
							   /*
							   if(rs.getObject(i).equals(ProModel)){ //將符合的型號放進確認變數裡
								   checkmodel=(String)rs.getObject(i);	 //將符合的型號AAAA放進確認變數裡
								   break;
								   }*/	  	
							   }
						   }
					   }catch(SQLException sqlException){
						   sqlException.printStackTrace();
						   }
				   }catch(SQLException SQLe){
					   SQLe.printStackTrace();
				}
		   
		    if((ModelAbName[0].equals(ProModel))||(ModelAbName[1].equals(ProAbName))){
		    	checkmodel=1;
		    }
		    	
		    
		   return checkmodel;
		   }
	}