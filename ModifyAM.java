package HHSystem;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;

public class ModifyAM extends JFrame  {
	static String url = "";
	static String username = ""; 
	static String password = "";
	private JPanel contentPane;
	private JTextField AM_CTName_t, AM_ConpName_t, ProdSN_t, AM_EID_t, AM_ProdModel_t, AM_ProdSN_t;
	ModifyAM clone = this;
	private String column;
	private JTextField AM_Fee_tf;
	static int AMNum;
	static String RState;
	Connection con ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyAM frame = new ModifyAM(null,null,"","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ModifyAM(Connection conn,final String[] data,final String URL,final String UN,final String PW) {
		setResizable(false);
		setTitle("\u4FEE\u6539\u7DAD\u4FEE\u55AE");
		setBounds(500, 200, 607, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AMNum=Integer.parseInt(data[0]);
		con=conn;
		url = URL;
		username = UN;
		password = PW;
		JLabel label = new JLabel("\u6D2A\u965E\u5BE6\u696D\u6709\u9650\u516C\u53F8");
		label.setFont(new Font("標楷體", Font.ITALIC, 18));
		label.setBounds(407, 11, 159, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7DAD\u4FEE\u5831\u544A\u66F8");
		label_1.setFont(new Font("標楷體", Font.PLAIN, 22));
		label_1.setBounds(236, 10, 119, 33);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7DAD\u4FEE\u72C0\u614B:");
		label_2.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_2.setBounds(339, 484, 97, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6545\u969C\u539F\u56E0:");
		label_3.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_3.setBounds(31, 227, 97, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6AA2\u67E5\u5167\u5BB9:");
		label_4.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_4.setBounds(31, 295, 97, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8655\u7406:");
		label_5.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_5.setBounds(70, 371, 58, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5EFA\u8B70:");
		label_6.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_6.setBounds(70, 441, 58, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u7DAD\u4FEE+\u5DE5\u6642\u8CBB:");
		label_7.setFont(new Font("標楷體", Font.PLAIN, 20));
		label_7.setBounds(70, 484, 138, 20);
		contentPane.add(label_7);
		
		JLabel AM_Num_lb = new JLabel("\u7DAD\u4FEE\u55AE\u865F:"+AMNum);
		AM_Num_lb.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_Num_lb.setBounds(31, 58, 225, 20);
		contentPane.add(AM_Num_lb);
		
		JLabel AM_CTName = new JLabel("\u5BA2\u6236\u540D\u7A31:");
		AM_CTName.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_CTName.setBounds(31, 95, 109, 20);
		contentPane.add(AM_CTName);
		
		JLabel AM_EID = new JLabel("\u8CA0\u8CAC\u54E1\u5DE5\u7DE8\u865F:");
		AM_EID.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_EID.setHorizontalAlignment(SwingConstants.LEFT);
		AM_EID.setBounds(250, 58, 130, 20);
		contentPane.add(AM_EID);
		
		JLabel AM_ConpName = new JLabel("\u806F\u7D61\u4EBA:");
		AM_ConpName.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ConpName.setBounds(309, 95, 71, 20);
		contentPane.add(AM_ConpName);
		
		JLabel AM_ProdModel = new JLabel("\u7522\u54C1\u578B\u865F:");
		AM_ProdModel.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ProdModel.setBounds(31, 137, 138, 20);
		contentPane.add(AM_ProdModel);
		
		JLabel AM_ProdSN = new JLabel("\u7522\u54C1\u5E8F\u865F:");
		AM_ProdSN.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_ProdSN.setHorizontalAlignment(SwingConstants.TRAILING);
		AM_ProdSN.setBounds(298, 137, 97, 20);
		contentPane.add(AM_ProdSN);
		
		JLabel AM_MContent = new JLabel("\u4E0D\u826F\u72C0\u6CC1/\u7DAD\u4FEE\u5167\u5BB9");
		AM_MContent.setHorizontalAlignment(SwingConstants.CENTER);
		AM_MContent.setFont(new Font("標楷體", Font.PLAIN, 20));
		AM_MContent.setBounds(31, 167, 525, 33);
		contentPane.add(AM_MContent);
		
        AM_CTName_t = new JTextField();
		AM_CTName_t.setBounds(122, 97, 152, 21);
		AM_CTName_t.setText(data[1]);
		contentPane.add(AM_CTName_t);
		AM_CTName_t.setColumns(10);
		
        AM_EID_t = new JTextField();
		AM_EID_t.setBounds(407, 60, 149, 21);
		AM_EID_t.setText(data[2]);
		contentPane.add(AM_EID_t);
		AM_EID_t.setColumns(10);

        AM_ConpName_t = new JTextField();
		AM_ConpName_t.setBounds(407, 97, 149, 21);
		AM_ConpName_t.setText(data[3]);
		contentPane.add(AM_ConpName_t);
		AM_ConpName_t.setColumns(10);
		
        AM_ProdModel_t = new JTextField();
        AM_ProdModel_t.setText(data[4]);
		AM_ProdModel_t.setBounds(122, 138, 155, 21);
		contentPane.add(AM_ProdModel_t);
		AM_ProdModel_t.setColumns(10);
		
		AM_ProdSN_t = new JTextField();
		AM_ProdSN_t.setText(data[5]);
		AM_ProdSN_t.setBounds(407, 139, 150, 21);
		contentPane.add(AM_ProdSN_t);
		AM_ProdSN_t.setColumns(10);

		
		final JTextPane AM_MContent_tp = new JTextPane();
		AM_MContent_tp.setText(data[6]);
		JScrollPane SP=new JScrollPane(AM_MContent_tp);
		SP.setBounds(122, 214, 434, 53);
		contentPane.add(SP);

		final JTextPane AM_CkeckCon_tp = new JTextPane();
		AM_CkeckCon_tp.setText(data[7]);
		JScrollPane SP2=new JScrollPane(AM_CkeckCon_tp);
		SP2.setBounds(122, 282, 434, 53);
		contentPane.add(SP2);

		final JTextPane AM_Handle_tp = new JTextPane();
		AM_Handle_tp.setText(data[8]);
		JScrollPane SP3=new JScrollPane(AM_Handle_tp);
		SP3.setBounds(122, 350, 434, 53);
		contentPane.add(SP3);
	
		final JTextPane AM_Suggest_tp = new JTextPane();
		AM_Suggest_tp.setText(data[9]);
		JScrollPane SP4=new JScrollPane(AM_Suggest_tp);
		SP4.setBounds(122, 423, 434, 53);
		contentPane.add(SP4);

		AM_Fee_tf = new JTextField();
		AM_Fee_tf.setText(data[10]);
		AM_Fee_tf.setBounds(196, 484, 131, 21);
		contentPane.add(AM_Fee_tf);
		
		final JComboBox RepairState = new JComboBox();//下拉式選單
		RepairState.setFont(new Font("標楷體", Font.PLAIN, 20));
		if(data[11].equals("0")){
			RepairState.addItem("未處理");//添加選項
			RepairState.addItem("已處理");
			RepairState.addItem("已收款");
		}else if(data[11].equals("1")){
			RepairState.addItem("已處理");
			RepairState.addItem("未處理");
			RepairState.addItem("已收款");
		}else if(data[11].equals("2")){
			RepairState.addItem("已收款");
			RepairState.addItem("未處理");
			RepairState.addItem("已處理");
			
		}
		RepairState.setBounds(434, 484, 122, 21);
		contentPane.add(RepairState);
		ItemListener itemListener = new ItemListener() {//JComboBox的事件監聽
		      public void itemStateChanged(ItemEvent ie) {
			    	  RState=RepairState.getSelectedItem().toString();
			    	  System.out.println("RState: "+RState);
		      }
		    };
		RepairState.addItemListener(itemListener);//被監聽的?件
		
		
		JButton goadd = new JButton("\u65B0\u589E");
		goadd.setFont(new Font("標楷體", Font.PLAIN, 16));
		goadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Connection conn;
				Statement statement;
				ResultSet rs;
				ResultSetMetaData rsMetaData;

				// 檢查是否有空值
				String[] AMCon = new String[11];
				AMCon[0] = AM_EID_t.getText().trim();
				AMCon[1] = AM_CTName_t.getText().trim();
				AMCon[2] = AM_ConpName_t.getText().trim();
				AMCon[3] = AM_ProdModel_t.getText().trim();
				AMCon[4] = AM_ProdSN_t.getText().trim();
				AMCon[5] = AM_MContent_tp.getText().trim();
				AMCon[6] = AM_CkeckCon_tp.getText().trim();
				AMCon[7] = AM_Fee_tf.getText().trim();
				AMCon[8] = AM_Handle_tp.getText().trim();
				AMCon[9] = AM_Suggest_tp.getText().trim();
				AMCon[10] = RState;
				int empty = 0;
				try {
					for (int i = 0; i <8; i++) {
						if ("".equals(AMCon[i])) {
							empty++;
						}
					}
					// 沒有空值，才執行傳送給預覽畫面
					if (empty == 0) {

						  if(checkCorrect(AMCon)==0){
							  System.out.println("OK");
							  
							  PreviewModifyAM PMAM = new PreviewModifyAM(con,clone,AMNum,AMCon,URL,UN,PW);
							  PMAM.setAlwaysOnTop(true); 
						 	  PMAM.requestFocus();  
							  PMAM.setVisible(true); 
						  dispose();
						  
						  }
						  
					} else {
						JOptionPane.showMessageDialog(ModifyAM.this, "只有'處理'和'建議'可以空白，其他皆不可", "有空值警告", JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException n) {
					JOptionPane.showMessageDialog(ModifyAM.this, "輸入錯誤", "警告", JOptionPane.WARNING_MESSAGE);
					n.printStackTrace();
				}
			}
		});
		goadd.setBounds(446, 549, 110, 33);
		contentPane.add(goadd);
		
		JButton goback = new JButton("\u8FD4\u56DE\u5BDF\u770B");
		goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		goback.setFont(new Font("標楷體", Font.PLAIN, 16));
		goback.setBounds(326, 549, 110, 33);
		contentPane.add(goback);
		

	}
	
	public int checkCorrect(String[] AMC) {
		// AMC -0 員工編號 -1客戶名稱 -3型號 -4序號 -7費用 -2聯絡人 -10維修單狀態
		//Connection conn;
		Statement statement;
		ResultSet rs;
		String check;
		int cNum=0;		//用來紀錄有多少欄位植有錯誤
		
		System.out.println("AMC[10]: "+AMC[10]);
		if((AMC[10]==null)||(AMC[10].equals("-請選擇-"))){
			cNum++;
			JOptionPane.showMessageDialog(ModifyAM.this, "請選擇維修單狀態", "維修單狀態異常", JOptionPane.WARNING_MESSAGE);
		}
		try {
			
			// System.out.println("連接成功");
			statement = con.createStatement();
			
			//檢查是否有此員工
			rs = statement.executeQuery("Select EID From Employee where EID='" + AMC[0] + "' ");
			if (rs.next()) {
				check = rs.getObject(1).toString(); 	// 將搜尋結果放入check
				System.out.println("check1: " + check);	//有的話就show出
			} else {									//沒有的話就show出查無的警告
				cNum++;
				JOptionPane.showMessageDialog(ModifyAM.this, "沒有此位員工", "有空值警告", JOptionPane.WARNING_MESSAGE);
			}
			//檢查是否有此客戶
			rs = statement.executeQuery("Select CTName From CT where CTName='" + AMC[1] + "' ");
			if (rs.next()) {
				check = rs.getObject(1).toString(); 
				System.out.println("check2: " + check);
			} else {
				cNum++;
				JOptionPane.showMessageDialog(ModifyAM.this, "沒有此位客戶", "有空值警告", JOptionPane.WARNING_MESSAGE);
			}
			//檢查是否有此產品型號
			rs = statement.executeQuery("Select ProdModel From Prod where ProdModel='" + AMC[3] + "' ");
			if (rs.next()) {
				check = rs.getObject(1).toString(); 
				System.out.println("check3: " + check);
			} else {
				cNum++;
				JOptionPane.showMessageDialog(ModifyAM.this, "沒有此產品型號", "有空值警告", JOptionPane.WARNING_MESSAGE);
			}
			//檢查費用
			if (!AMC[7].equals("")) {
				int fee=Integer.parseInt(AMC[7]);
				if(fee<=0){
					cNum++;
					JOptionPane.showMessageDialog(ModifyAM.this, "費用沒有負值或零", "有空值警告", JOptionPane.WARNING_MESSAGE);
				}
				System.out.println("fee: " + fee);
			}
			//檢查是否有此產品序號
			//1*先取出是否和組合物ProdIsCom
			String isCom = null;
			rs = statement.executeQuery("Select ProdIsCom From Prod where ProdModel='" + AMC[3] + "' ");
			if (rs.next()) {
				isCom = rs.getObject(1).toString(); // 將符合的客戶名稱放進確認變數裡
				System.out.println("ProdIsCom1: " + isCom);
			}
			if(Integer.parseInt(isCom)==1){

				rs = statement.executeQuery("Select CNSN_Num From CNSN where CNSN_Num='" + AMC[4] + "' AND CNSN_Model='"+AMC[3]+"' ");
				if (rs.next()) {
					check = rs.getObject(1).toString(); // 將符合的客戶名稱放進確認變數裡
					System.out.println("check4: " + check);
				} else {
					cNum++;
					JOptionPane.showMessageDialog(ModifyAM.this, "沒有此產品序號", "有空值警告", JOptionPane.WARNING_MESSAGE);
				}
			
			}else{
				rs = statement.executeQuery("Select ProdSN From ProdSN where ProdSN='" + AMC[4] + "' AND ProdModel='"+AMC[3]+"' ");
				if (rs.next()) {
					check = rs.getObject(1).toString(); // 將符合的客戶名稱放進確認變數裡
					System.out.println("check4: " + check);
				} else {
					cNum++;
					JOptionPane.showMessageDialog(ModifyAM.this, "沒有此產品序號", "有空值警告", JOptionPane.WARNING_MESSAGE);
				}
			}

			
		} catch (SQLException SQLe) {
			SQLe.printStackTrace();
		}
		System.out.println("cNum: "+cNum);
		return cNum;
	}	
}
