package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.Connection;
public class testProData extends JFrame {
	Connection con;
	private JPanel contentPane;
	static  String url = "";
	static  String username = ""; 
	static  String password = "";



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testProData frame = new testProData(null,null,0, "", "", "");
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
	public testProData(final Connection conn,final String[] Data,final int EST, String URL, String UN, String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con=conn;
		url=URL;
		username=UN;
		password=PW;

		Label ProBasicData = new Label("產品基本資料");
		ProBasicData.setFont(new Font("Dialog", Font.PLAIN, 30));
		ProBasicData.setBounds(206, 18, 194, 37);
		contentPane.add(ProBasicData);
		
		JLabel ProData = new JLabel("產品型號："+Data[0]);
		ProData.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProData.setBounds(319, 61, 279, 30);
		contentPane.add(ProData);
		
		JLabel ProName = new JLabel("產品名稱："+Data[1]);
		ProName.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProName.setBounds(30, 61, 279, 30);
		contentPane.add(ProName);
		
		JLabel ProdNowInve = new JLabel("目前庫存："+Data[2]);
		ProdNowInve.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdNowInve.setBounds(30, 169, 279, 30);
		contentPane.add(ProdNowInve);
		
		JLabel ProdPurQuan = new JLabel("請購中數量："+Data[3]);
		ProdPurQuan.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdPurQuan.setBounds(30, 279, 279, 30);
		contentPane.add(ProdPurQuan);
				
		String PSRD;
		if(Data[4].equals("1111-11-11")){
			PSRD="未訂購";
		}else {PSRD=Data[4];}
		JLabel ProdScheRecDate = new JLabel("預計入庫日："+PSRD);
		ProdScheRecDate.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdScheRecDate.setBounds(319, 279, 224, 30);
		contentPane.add(ProdScheRecDate);
		

		JLabel ProdOrderReqQuan = new JLabel("\u8A02\u55AE\u9700\u6C42\u91CF\uFF1A"+Data[5]);
		ProdOrderReqQuan.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdOrderReqQuan.setBounds(30, 226, 279, 30);
		contentPane.add(ProdOrderReqQuan);
		
		JLabel SafeInve = new JLabel("安全庫存量："+Data[6]);
		SafeInve.setFont(new Font("標楷體", Font.PLAIN, 20));
		SafeInve.setBounds(319, 169, 279, 30);
		contentPane.add(SafeInve);
		
		JLabel ProSPrice = new JLabel("\u51FA\u552E\u50F9\u683C\uFF1A"+Data[7]);
		ProSPrice.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProSPrice.setBounds(319, 226, 279, 30);
		contentPane.add(ProSPrice);
		
		JLabel HSName = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("標楷體", Font.ITALIC, 18));
		HSName.setBounds(441, 18, 159, 37);
		contentPane.add(HSName);
		
		JButton button = new JButton("返回上頁");
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(147, 356, 128, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				dispose();
			}
		});
		
		JLabel ProAB_lb = new JLabel("\u7522\u54C1\u7C21\u7A31\uFF1A"+Data[8]);
		ProAB_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProAB_lb.setBounds(30, 115, 279, 30);
		contentPane.add(ProAB_lb);
		
		String Ptype;
		if(Data[9].equals("0")){  //區分一般產品或組合物
			Ptype="一般產品";
		}else { Ptype="組合物";}
		JLabel ProType_lb = new JLabel("\u7522\u54C1\u985E\u578B\uFF1A"+Ptype);
		ProType_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProType_lb.setBounds(319, 115, 279, 30);
		contentPane.add(ProType_lb);
		
		final testProData clone=this;
		JButton revisePD = new JButton("\u4FEE\u6539");
		revisePD.setFont(new Font("標楷體", Font.PLAIN, 20));
		revisePD.setBounds(319, 356, 128, 40);
		contentPane.add(revisePD);
		revisePD.setVisible(false);
		if(EST==1)revisePD.setVisible(true);
		revisePD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] data=new Object[Data.length];
				for(int i =0;i<Data.length;i++)
					data[i]=Data[i];
				modifyProData modpd = new modifyProData(conn,clone,data,url,username,password);
				modpd.setAlwaysOnTop(true); 
				modpd.requestFocus();  
				modpd.setVisible(true);
				dispose();
			}
		});


	}
}
