package HHSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewMMO extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String tabn="SM";
	static String col="SM_CTName";
	static String con="";
	static String url = "";
	static String username = ""; 
	static String password = "";
	Connection cc =null;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData rsMetaData;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMMO frame = new NewMMO(null,"","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		return strDate;
		}

	public NewMMO(final Connection conn,String col2, String con2,final String URL,final String UN,final String PW) {
		super("新增請款單");
		setResizable(false);
		if((!col2.equals(""))&&(!con2.equals(""))){
			col=col2;
			con=con2;
		}
		cc=conn;
		url = URL;
		username = UN;
		password = PW;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label MMO_CTName = new Label("客戶名稱：");
		MMO_CTName.setBounds(289, 75, 68, 25);
		contentPane.add(MMO_CTName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(359, 75, 134, 25);
		contentPane.add(textField);
		
		Label label_3 = new Label("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label_3.setFont(new Font("Dialog", Font.ITALIC, 24));
		label_3.setBounds(467, 20, 210, 25);
		contentPane.add(label_3);
		
		TableDemo tableDemo = new TableDemo(conn,tabn,"NewMMO",URL,UN,PW);
		tableDemo.GetData2(col,con,"SM_Check","0");
		final String [] name = tableDemo.name;
		for(int i=0;i<tableDemo.name.length;i++)
		System.out.println(name[i]);
		tableDemo.setBounds(31, 125, 625, 330);
		contentPane.add(tableDemo);
		tableDemo.setLayout(new GridLayout(1, 0));

		JButton button = new JButton("搜尋");
		button.setBounds(540, 74, 99, 27);
		contentPane.add(button);
		
		JButton Newbtn = new JButton("新增");
		Newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int state=0;
					//確認搜尋後顯示欲請款的訂單都是同個客戶的
					for(int j=1;j<name.length;j++){	
						if(name[0].equals(name[j])){		
							state=0;
						}else{
							state=1;
							break;
						}
					}
					System.out.println(state);
				if(state==0){	
				previewMMO premmo = new previewMMO(conn,name[0],URL,UN,PW);
				premmo.setAlwaysOnTop(true); 
				premmo.requestFocus();  
				premmo.setVisible(true);
				dispose();
				}else{
					JOptionPane.showMessageDialog(NewMMO.this, "請搜尋唯一的客戶 !","新增失敗",JOptionPane.WARNING_MESSAGE);
				}
			}		
		});
		Newbtn.setBounds(557, 476, 99, 27);
		contentPane.add(Newbtn);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("\u65B0\u589E\u65B9\u5F0F:\r\n1.\u5148\u641C\u5C0B\u5BA2\u6236\uFF0C\u5217\u51FA\u6240\u6709\u672A\u8ACB\u6B3E\u7684\u51FA\u8CA8\u55AE\r\n2.\u518D\u6309\u65B0\u589E\u626D");
		textPane.setBounds(39, 20, 235, 65);
		contentPane.add(textPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					col="SM_CTName";
					con=textField.getText();
					System.out.println("col: "+col);
					System.out.println("con: "+con);
				
				NewMMO nmmo=new NewMMO(conn,col,con,URL,UN,PW);
			
				nmmo.setVisible(true);
			dispose();
			}
		});
	}
}