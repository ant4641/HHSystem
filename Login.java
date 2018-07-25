package HHSystem;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	JLabel SRNum ;
	private JTable table;
	static final String username = "root";
	static final String password = "admin";
	//static final String username = "Alumnitest1";  //�Ω�s�ڭ̪�DB
	//static final String password = "Alumnitest1"; 
	static String []names=new String[1];
	static int numberOfColumns = 0;
	private Connection conn;
	private Statement statement;
	private ResultSet rs;
	private ResultSetMetaData rsMetaData;
	private JTextField EmpID;
	private JPasswordField EmpPass = new JPasswordField(15);
	private int es;
	private String addr="";
	private JTextField DBIP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	
	public Login(String addr,String dbip){
		setResizable(false);
		numberOfColumns=0;
		
		setTitle("\u767B\u5165\u6D2A\u965E\u7CFB\u7D71");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel company = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		company.setFont(new Font("�з���", Font.PLAIN, 22));
		company.setBounds(85, 10, 184, 33);
		contentPane.add(company);
			
			JButton button_1 = new JButton("\u767B\u5165");
			button_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					try{
					final String URL="jdbc:mysql://"+DBIP.getText()+":3306/hhsystem";
					//���F��s�u���p�Φ^�ڭ̪�DB
					//final String URL="jdbc:mariadb://"+DBIP.getText()+"/HHSystem"; 
					//final String URL="jdbc:mariadb://"+DBIP.getText()+"/HSSystem";  
					System.out.println(URL);
					conn = DriverManager.getConnection(URL, username, password ); //�I�sConnection����A�i���Ʈw�s�u
					System.out.println("��Ʈw�s�����\"); 
					statement = conn.createStatement();
					String id=EmpID.getText().toString();
					//���J�����uID�h��DB�����
					rs = statement.executeQuery("SELECT EPass FROM Employee Where EID = '"+id+"';");
					String pass="";
					int numberOfRows=0;
					while (rs.next()){
						pass=rs.getObject(1).toString();
					    //System.out.println(pass);	
					    numberOfRows++;			//����@��@�˪����uID�ɴN++
					}
					
					if(numberOfRows>1){  //>1�A��ܳo�b�������ơA�i�঳���D
						JOptionPane.showMessageDialog(Login.this,"�d��h����ơA�b��������","�n�J����",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(numberOfRows==0){		//�S�����b��
						JOptionPane.showMessageDialog(Login.this,"�b�����~","�n�J����",
								JOptionPane.INFORMATION_MESSAGE);
					}else if(numberOfRows==1){
						System.out.println(String.valueOf(EmpPass.getPassword()));
						if(pass.equals(String.valueOf(EmpPass.getPassword()))){
							rs = statement.executeQuery("SELECT EName FROM Employee Where EID = '"+id+"';");
							String name="";
							while (rs.next()){
								name=rs.getObject(1).toString();
							}
							//��ID���o���u�s��
							rs = statement.executeQuery("SELECT ESTA FROM Employee Where EID = '"+id+"';");
							
							while (rs.next()){
								es=(Integer)(rs.getObject(1));
								System.out.println(es);
							}
							
							JOptionPane.showMessageDialog(Login.this,"�n�J���\\n�n�J�̡G"+name,"�n�J���\",
									JOptionPane.INFORMATION_MESSAGE);
							MainMenu MM = new MainMenu(conn,id,name,es,URL,DBIP.getText(),username,password);
							MM.setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(Login.this,"�K�X���~","�n�J����",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				
					}catch(SQLException sqlException){//��Ʈw�ާ@�o�Ϳ��~
						System.out.println(sqlException);
						JOptionPane.showMessageDialog(Login.this,"�L�k�s�W��Ʈw","�n�J����",
								JOptionPane.INFORMATION_MESSAGE);
				    }  
				} 
			});
			button_1.setFont(new Font("�з���", Font.PLAIN, 17));
			button_1.setBounds(128, 155, 76, 31);
			contentPane.add(button_1);   
			
			EmpID = new JTextField();
			EmpID.setText(addr);
			EmpID.setBounds(128, 53, 175, 21);
			contentPane.add(EmpID);
			EmpID.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("\u54E1\u5DE5\u7DE8\u865F\uFF1A");
			lblNewLabel.setFont(new Font("�з���", Font.PLAIN, 16));
			lblNewLabel.setBounds(33, 55, 92, 15);
			contentPane.add(lblNewLabel);
			JLabel lblNewLabe2 = new JLabel("\u54E1\u5DE5\u5BC6\u78BC\uFF1A");
			lblNewLabe2.setFont(new Font("�з���", Font.PLAIN, 16));
			lblNewLabe2.setBounds(33, 86, 92, 15);
			contentPane.add(lblNewLabe2);
			
			EmpPass.setEchoChar('*');
			EmpPass.setColumns(10);
			EmpPass.setBounds(128, 84, 175, 21);
			contentPane.add(EmpPass);
			
			JLabel lblIp = new JLabel("\u8CC7\u6599\u5EABIP\uFF1A");
			lblIp.setFont(new Font("�з���", Font.PLAIN, 16));
			lblIp.setBounds(33, 117, 92, 15);
			contentPane.add(lblIp);
			
			DBIP = new JTextField();
			DBIP.setColumns(10);
			DBIP.setText(dbip);
			DBIP.setBounds(128, 115, 175, 21);
			contentPane.add(DBIP);
   }
}