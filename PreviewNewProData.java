package HHSystem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PreviewNewProData extends JFrame {

	private JPanel contentPane;
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
					PreviewNewProData frame = new PreviewNewProData(null,null,"","","","","","","","");
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
	public PreviewNewProData(Connection conn,NewProData NPD,final String textField,final String textField_2,final String textField_4,final String textField_1,final String textField_3, String URL, String UN, String PW) {

		setResizable(false);
		final NewProData Hidding = NPD;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		con=conn;
		url=URL;
		username=UN;
		password=PW;
		
		JButton button_1 = new JButton("��^");
		button_1.setBounds(346, 293, 101, 43);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hidding.setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("�з���", Font.PLAIN, 20));
		
		JLabel ProPrice = new JLabel("���~�X�����G"+textField_3);
		ProPrice.setBounds(178, 241, 279, 30);
		contentPane.add(ProPrice);
		ProPrice.setFont(new Font("�з���", Font.PLAIN, 20));
		
		JLabel ProNowInve = new JLabel("�w���w�s�q�G"+textField_1);
		ProNowInve.setBounds(178, 203, 279, 30);
		contentPane.add(ProNowInve);
		ProNowInve.setFont(new Font("�з���", Font.PLAIN, 20));
		
		JLabel ProName = new JLabel("���~�W�١G"+textField_2);
		ProName.setBounds(178, 134, 279, 30);
		contentPane.add(ProName);
		ProName.setFont(new Font("�з���", Font.PLAIN, 20));
		
		JLabel ProModel = new JLabel("���~�����G"+textField);
		ProModel.setBounds(178, 94, 279, 30);
		contentPane.add(ProModel);
		ProModel.setFont(new Font("�з���", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("�s�W���~�򥻸��");
		label_1.setBounds(126, 44, 313, 40);
		contentPane.add(label_1);
		label_1.setFont(new Font("�з���", Font.PLAIN, 37));
		
		JLabel label = new JLabel("�x����~�������q");
		label.setBounds(399, 10, 165, 40);
		contentPane.add(label);
		label.setFont(new Font("�з���", Font.ITALIC, 20));
		
		JLabel lblNewLabel = new JLabel("���~²�١G"+textField_4);
		lblNewLabel.setFont(new Font("�з���", Font.PLAIN, 20));
		lblNewLabel.setBounds(178, 174, 246, 24);
		contentPane.add(lblNewLabel);
		
		
		JButton button = new JButton("�T�w�s�W");
		button.setBounds(449, 293, 115, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement statement;
				int Update=0;
				
					try{
						System.out.println("�s�����\");
						statement = con.createStatement();
						try{
							int safenum=Integer.parseInt(textField_1);  //��w���w�s�q�� �r���ন�Ʀr
							int sp=Integer.parseInt(textField_3);
							
							Update = statement.executeUpdate("Insert Into Prod(ProdModel,ProdName,ProdSafeInve,ProdSellPrice,ProdNowInve,ProdPurQuan,ProdOrderReqQuan,ProdAbName)VALUES('"+textField+"','"+textField_2+"','"+safenum+"','"+sp+"','0','0','0','"+textField_4+"')");
						}catch(SQLException sqlException){
							sqlException.printStackTrace();
							
						}
					}catch(SQLException SQLe){
						SQLe.printStackTrace();
						}
					if(Update>0){
						JOptionPane.showMessageDialog(PreviewNewProData.this, "�s�W���~��Ʀ��\ !","�s�W���\",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						}else{
							JOptionPane.showMessageDialog(PreviewNewProData.this, "�s�W���~��ƥ��� !","�s�W����",JOptionPane.WARNING_MESSAGE);
							int result=JOptionPane.showConfirmDialog(PreviewNewProData.this,
									"�T�w�n�����{����?",
									"�T�{�T��",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.WARNING_MESSAGE);
							if (result==JOptionPane.YES_OPTION) {System.exit(0);}
							}
					
				}
			});
		button.setFont(new Font("�з���", Font.PLAIN, 20));
	}
}