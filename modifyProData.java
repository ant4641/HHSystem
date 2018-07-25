package HHSystem;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class modifyProData extends JFrame {
	Connection con;
	private JPanel contentPane;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";
	private JTextField pMod;
	private JTextField pSafeP;
	private JTextField pName;
	private JTextField pSell;
	static String column;
	static String condition;
	static String []names=new String[1];
	static String OriPName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws SQLException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					modifyProData frame = new modifyProData(null,null,null, "", "", "");
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
	 */
	public modifyProData(final Connection conn,final testProData PD,final Object data[],String URL, String UN, String PW) {
		setResizable(false);		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;

		OriPName=data[0].toString();		//要把原來的型號記起來
		
		JLabel label = new JLabel("洪陞實業有限公司");
		label.setFont(new Font("標楷體", Font.ITALIC, 20));
		label.setBounds(379, 10, 165, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("修改產品基本資料");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 37));
		label_1.setBounds(108, 37, 313, 40);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("產品型號：");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblNewLabel.setBounds(131, 97, 109, 30);
		contentPane.add(lblNewLabel);
		
		pMod = new JTextField();
		pMod.setText(data[0].toString());
		pMod.setBounds(268, 101, 131, 28);
		contentPane.add(pMod);
		pMod.setColumns(10);
		
		JLabel label_2 = new JLabel("產品名稱：");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_2.setBounds(131, 137, 109, 30);
		contentPane.add(label_2);
		
		pSafeP = new JTextField();
		pSafeP.setText(data[6].toString());
		pSafeP.setColumns(10);
		pSafeP.setBounds(268, 180, 131, 30);
		contentPane.add(pSafeP);
		
		JLabel label_3 = new JLabel("安全庫存量：");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(131, 177, 131, 30);
		contentPane.add(label_3);
		
		pName = new JTextField();
		pName.setText(data[1].toString());
		pName.setColumns(10);
		pName.setBounds(268, 139, 131, 30);
		contentPane.add(pName);
		
		JLabel label_4 = new JLabel("產品出售價格：");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(131, 220, 140, 30);
		contentPane.add(label_4);
		
		pSell = new JTextField();
		pSell.setText(data[7].toString());
		pSell.setColumns(10);
		pSell.setBounds(268, 220, 131, 30);
		contentPane.add(pSell);
		
		final modifyProData clone =this;
		final String[] prodata=new String[4];
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//檢查是否有空值
			
				//把全部新增的產品資料放進STring陣列傳送
				prodata[0]=pMod.getText().trim();
				prodata[1]=pName.getText().trim();
				prodata[2]=pSafeP.getText().trim();
				prodata[3]=pSell.getText().trim();
				
				int empty=0;
				try{
					for(int i=0 ; i<prodata.length ;i++){
						if("".equals(prodata[i])){empty++;}
					}
					
					if(empty==0){
						preivewmodifyPro PMP =new preivewmodifyPro(conn,clone,OriPName,prodata,url,username,password);
						PMP.setAlwaysOnTop(true); 
						PMP.requestFocus();  
						PMP.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(modifyProData.this, "資料不可為空值", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(modifyProData.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(300, 270, 82, 40);
		contentPane.add(button);
		
		JButton goBack = new JButton("\u8FD4\u56DE");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PD.setVisible(true);
				dispose();
			}
		});
		goBack.setFont(new Font("標楷體", Font.PLAIN, 20));
		goBack.setBounds(158, 270, 82, 40);
		contentPane.add(goBack);
				
	}
}

