package HHSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class testSRData extends JFrame {

	private JPanel contentPane;
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
					testSRData frame = new testSRData(null,null,0,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param con 
	 * @param password 
	 * @param username 
	 * @param url 
	 */
	public testSRData(final Connection conn, final String[] Data,final int EST,final String URL,final String UN,final String PW) {
		setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 922, 585);
		url = URL;
		username = UN;
		password = PW;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label SRBasicData = new Label("�����Ӱ򥻸��");
		SRBasicData.setFont(new Font("Dialog", Font.PLAIN, 30));
		SRBasicData.setBounds(312, 30, 224, 37);
		contentPane.add(SRBasicData);
		
		JLabel SRIndCate = new JLabel("���~�O�G�G"+Data[7]);
		SRIndCate.setFont(new Font("�з���", Font.PLAIN, 20));
		SRIndCate.setBounds(27, 78, 279, 30);
		contentPane.add(SRIndCate);
		
		JLabel SRName = new JLabel("�����ӦW�١G"+Data[1]);
		SRName.setFont(new Font("�з���", Font.PLAIN, 20));
		SRName.setBounds(27, 124, 267, 30);
		contentPane.add(SRName);
		
		JLabel SRFax = new JLabel("�����Ӷǯu�G"+Data[5]);
		SRFax.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFax.setBounds(27, 175, 254, 30);
		contentPane.add(SRFax);
		
		JLabel SRDLPhone = new JLabel("�����ӱM�u�q�ܡG"+Data[14]);
		SRDLPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRDLPhone.setBounds(391, 266, 279, 30);
		contentPane.add(SRDLPhone);
				
		JLabel SRFactPhone = new JLabel("�����Ӥu�t�q�ܡG"+Data[11]);
		SRFactPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFactPhone.setBounds(27, 223, 337, 30);
		contentPane.add(SRFactPhone);
		

		JLabel SRTaxID = new JLabel("�����ӲΤ@�s���G"+Data[6]);
		SRTaxID.setFont(new Font("�з���", Font.PLAIN, 20));
		SRTaxID.setBounds(295, 175, 298, 30);
		contentPane.add(SRTaxID);
		
		JLabel SRBusiPhone = new JLabel("�����ӷ~�ȹq�ܡG"+Data[13]);
		SRBusiPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRBusiPhone.setBounds(27, 266, 279, 30);
		contentPane.add(SRBusiPhone);
		
		JLabel SRPhone = new JLabel("�����ӹq�ܡG"+Data[4]);
		SRPhone.setFont(new Font("�з���", Font.PLAIN, 20));
		SRPhone.setBounds(596, 124, 294, 30);
		contentPane.add(SRPhone);
		
		JLabel HSName = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		HSName.setFont(new Font("�з���", Font.ITALIC, 25));
		HSName.setBounds(641, 0, 203, 53);
		contentPane.add(HSName);
		
		JButton button = new JButton("��^�W��");
		button.setFont(new Font("�з���", Font.PLAIN, 20));
		button.setBounds(747, 481, 128, 40);
		contentPane.add(button);
		
		JLabel SRNum = new JLabel("�����ӽs���G"+Data[0]);
		SRNum.setFont(new Font("�з���", Font.PLAIN, 20));
		SRNum.setBounds(295, 124, 279, 30);
		contentPane.add(SRNum);
		
		JLabel SRPIC = new JLabel("�����ӭt�d�H�G"+Data[8]);
		SRPIC.setFont(new Font("�з���", Font.PLAIN, 20));
		SRPIC.setBounds(596, 175, 279, 30);
		contentPane.add(SRPIC);
		
		JLabel SRFactFax = new JLabel("�����Ӥu�t�ǯu�G"+Data[12]);
		SRFactFax.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFactFax.setBounds(391, 223, 279, 30);
		contentPane.add(SRFactFax);
		
		JLabel SRNetAddr = new JLabel("�����Ӻ��}�G"+Data[15]);
		SRNetAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRNetAddr.setBounds(27, 438, 686, 30);
		contentPane.add(SRNetAddr);
		
		JLabel SRFactAddr = new JLabel("�����Ӥu�t�a�}�G"+Data[10]);
		SRFactAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRFactAddr.setBounds(27, 395, 686, 30);
		contentPane.add(SRFactAddr);
		
		JLabel SRAddr = new JLabel("�����Ӧa�}�G"+Data[3]);
		SRAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRAddr.setBounds(27, 309, 686, 30);
		contentPane.add(SRAddr);
		
		JLabel SRInvoAddr = new JLabel("�����ӵo���a�}�G"+Data[9]);
		SRInvoAddr.setFont(new Font("�з���", Font.PLAIN, 20));
		SRInvoAddr.setBounds(27, 352, 686, 30);
		contentPane.add(SRInvoAddr);
		
		JLabel SREmail = new JLabel("�����ӫH�c�G"+Data[16]);
		SREmail.setFont(new Font("�з���", Font.PLAIN, 20));
		SREmail.setBounds(27, 481, 686, 30);
		contentPane.add(SREmail);
		
		JButton reviseSR = new JButton("\u4FEE\u6539");
		reviseSR.setFont(new Font("�з���", Font.PLAIN, 20));
		reviseSR.setBounds(747, 437, 128, 37);
		contentPane.add(reviseSR);
		reviseSR.setVisible(false);
		if(EST==1||EST==3)reviseSR.setVisible(true);
		reviseSR.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				modifySR mod = new modifySR(conn,Data,EST,URL,UN,PW);
				mod.setAlwaysOnTop(true); 
				mod.requestFocus();  
				mod.setVisible(true);
			}
		});
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				dispose();
			}
		});
	}
}