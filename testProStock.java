package HHSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class testProStock extends JFrame {

	private JPanel contentPane;
	Connection con ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testProStock frame = new testProStock(null,null);
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
	public testProStock(Connection conn,String[] Data) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label ProStock = new Label("產品庫存資料");
		ProStock.setFont(new Font("Dialog", Font.PLAIN, 30));
		ProStock.setBounds(179, 43, 194, 37);
		contentPane.add(ProStock);
		
		JLabel ProdName= new JLabel("產品名稱："+Data[0]);
		ProdName.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdName.setBounds(24, 103, 269, 30);
		contentPane.add(ProdName);
		
		JLabel ProdModel = new JLabel("產品編號："+Data[1]);
		ProdModel.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdModel.setBounds(294, 103, 252, 30);
		contentPane.add(ProdModel);
		
		JLabel ProdSN = new JLabel("產品序號："+Data[2]);
		ProdSN.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdSN.setBounds(24, 153, 269, 30);
		contentPane.add(ProdSN);
		
		JLabel ProdPurPrice = new JLabel("產品採購價格："+Data[4]);
		ProdPurPrice.setFont(new Font("標楷體", Font.PLAIN, 20));
		ProdPurPrice.setBounds(294, 153, 266, 30);
		contentPane.add(ProdPurPrice);
				
		JLabel PO_Num = new JLabel("採購單編號："+Data[5]);
		PO_Num.setFont(new Font("標楷體", Font.PLAIN, 20));
		PO_Num.setBounds(24, 196, 269, 30);
		contentPane.add(PO_Num);
		

		JLabel SM_Num = new JLabel("出貨單號："+Data[6]);
		SM_Num.setFont(new Font("標楷體", Font.PLAIN, 20));
		SM_Num.setBounds(294, 196, 266, 30);
		contentPane.add(SM_Num);
		
		JLabel CC_Num = new JLabel("安全組合完組合物編號："+Data[7]);
		CC_Num.setFont(new Font("標楷體", Font.PLAIN, 20));
		CC_Num.setBounds(24, 250, 444, 30);
		contentPane.add(CC_Num);
		
		JLabel HSName = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("標楷體", Font.ITALIC, 25));
		HSName.setBounds(341, 0, 203, 53);
		contentPane.add(HSName);
		
		JButton button = new JButton("返回上頁");
		button.setFont(new Font("標楷體", Font.PLAIN, 20));
		button.setBounds(204, 319, 128, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener(){//按鈕監聽
			public void actionPerformed(ActionEvent a){
				dispose();
			}
		});
	}

}