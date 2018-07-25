package HHSystem;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import HHSystem.TableDemo.MyTableModel;
 
public class TableDemo extends JPanel implements ActionListener {
  private final boolean DEBUG = false;
	static String url = "";
	static String username = ""; 
	static String password = "";
	Connection cc;
	//clone版新增加-------------
	private Object clone;		
	//clone版新增加-------------
	static int numberOfColumns = 0;
	static int numberOfRows=0;
	static JButton btn[];
	static String UseTable;
	static String UseFuntion;
	static String column;
	static String condition;
	static String UseTable2 = "ProdSN";
	static Object[][] data = new Object[1][];
	static String []names=new String[1];
	static testORN[] tORN=new testORN[1];
	static int EST=0;
	static testEmployee[] tE = new  testEmployee[1];
	static PreviewSM[] PSM= new PreviewSM[1];
	static testSM[] tSM=new testSM[1];
	static testPurchase[] tP= new testPurchase[1];
	static PreviewInputgoods[] PI =new PreviewInputgoods[1];
	static checkCTA[] cCTA=new checkCTA[1];
	static checkOR[] cOR=new checkOR[1];
	static checkSRA[] cSRA=new checkSRA[1];
	static testProData[] tpd = new testProData[1];
	static testSRData[] tsd = new testSRData[1];
	static testClient[] tc = new testClient[1];
	static testAM[] tam = new testAM[1];
	static testProStock[] tps = new testProStock[1];
	static String []name =new String[1];
	static testMMO[] tmmo = new testMMO[1];
	static testCN[] tcn = new testCN[1];
	static int testn=0;
	
  public TableDemo(Connection conn,String ut,String uf,String URL,String  UN,String  PW){
	  cc=conn;
	  url=URL;
	  username=UN;
	  password=PW;
	  UseTable=ut;
	  UseFuntion=uf;
  }
  
  //clone版新增加-------------
  public void setClone(Object c){
	  clone=c;
  }
  //clone版新增加-------------
  public void GetData0(String col,String con,final int ESt){//EST 1=boss,2=emp,3=empToReceiveBake
	  EST=ESt;
	  
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  String k="";
	  column=col;
	  condition=con;
	  numberOfRows=0;
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
				
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
	  
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}
			    
			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    
			    btn = new JButton[numberOfRows];
			    
			    data=new Object[numberOfRows][numberOfColumns+1];
			    int order=0;
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
			    while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
				    	 if(rs.getObject(i)==null){
				    		 data[order][i-1]="";
				    	 }else{
				    		 data[order][i-1]=rs.getObject(i);	
				    	 }
					     		  	
				       }
				      order++;
				 }

	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }  
	  
	  	  Table(names, data);
  }
  
  public void GetData(String col,String con){
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  String k="";
	  column=col;
	  condition=con;
	  numberOfRows=0;
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
				
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
	  
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}
			    
			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    
			    btn = new JButton[numberOfRows];
			    
			    data=new Object[numberOfRows][numberOfColumns+1];
			    int order=0;
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
			    while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
				    	 if(rs.getObject(i)==null){
				    		 data[order][i-1]="";
				    	 }else{
				    		 data[order][i-1]=rs.getObject(i);	
				    	 }
					     		  	
				       }
				      order++;
				 }
	         
	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }  
	  
	  	  Table(names, data);
  }
  
  public void GetData2(String SearchCol,String SearchCon,String PickCol,String PickCon){
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  numberOfRows=0;
	  
	  column=SearchCol;  	//用於模糊搜尋所指定的欄位
	  condition=SearchCon;	//用於模糊搜尋所指定的條件
	  String PCol=PickCol;	//用於取出Table資料時必要的篩選的欄位
	  String Pcon=PickCon;	//用於取出Table資料時必要的篩選的欄位的值
	 
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PCol+"="+Pcon+" AND "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
				
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				switch(UseFuntion){
			  	case "NewMMO" :{
			  		names=new String[numberOfColumns];
			  	  break;
			  	  }
			  	default:{
			  		names=new String[numberOfColumns+1];
			  	  break;
			  	}
			  }
				
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}

			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    btn = new JButton[numberOfRows];
			    System.out.println(UseFuntion);
			    switch(UseFuntion){
			  	case "NewMMO" :{
			  	   data=new Object[numberOfRows][numberOfColumns];
			  	  break;
			  	  }
			  	default:{
			  		data=new Object[numberOfRows][numberOfColumns+1];
			  	  break;
			  	}
			  }
			    
			    int order=0;
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PCol+"="+Pcon+" AND "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
			    while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
					    	 if(rs.getObject(i)==null){
					    		 data[order][i-1]="";
					    	 }else{
					    		 data[order][i-1]=rs.getObject(i);	
					    	 }		  	
				       }
				      order++;
				 }

	         
	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      } 
	  switch(UseFuntion){
	  	case "NewMMO" :{
	  	  Table2(names, data);
	  	  name = new String[numberOfRows];
	  	  for(int i=0;i<numberOfRows;i++)
	  	    name[i] = data[i][2].toString();
	  	  break;
	  	  }
	  	default:{
	  	  Table(names, data);
	  	  break;
	  	}
	  }
	  
	  
  }
  

  public void GetData3(String col,String con){
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  String k="";
	  column=col;
	  condition=con;
	  numberOfRows=0;
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
	         rs = statement.executeQuery("SELECT Prod.ProdName,Prod.ProdModel,ProdSN.* FROM "+UseTable+","+UseTable2+" Where Prod.ProdModel = ProdSN.ProdModel AND "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
				
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
	  
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}
			    
			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    
			    btn = new JButton[numberOfRows];
			    data=new Object[numberOfRows][numberOfColumns+1];
			    int order=0;
			    rs = statement.executeQuery("SELECT Prod.ProdName,Prod.ProdModel,ProdSN.* FROM "+UseTable+","+UseTable2+" Where Prod.ProdModel = ProdSN.ProdModel AND "+column+" LIKE '%"+condition+"%' ORDER BY "+column+"");
			    while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
				    	 if(rs.getObject(i)==null){
				    		 data[order][i-1]="";
				    	 }else{
				    		 data[order][i-1]=rs.getObject(i);	
				    	 }
					     		  	
				       }
				      order++;
				 }

	         
	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }  
	  
	  	  Table(names, data);
  }
  
  public void GetData4(String TimeCol,String timeStart,String timeEnd,String PickCol,String PickValue){
	  //三個參數分別代表 時間的欄位名字，時間起始點，時間結束點
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  numberOfRows=0;
	  String PC=PickCol;
	  String PV=PickValue;
	  String TCol=TimeCol;	//用於取出Table資料時必要的篩選的欄位
	  String TS=timeStart;	//用於取出Table資料時必要的篩選的欄位的時間起點
	  String TE=timeEnd;	//用於取出Table資料時必要的篩選的欄位的時間起點
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PC+"="+PV+" AND "+TCol+" BETWEEN '"+TS+"' AND '"+TE+"' ");
				System.out.println("SQL: "+"SELECT * FROM "+UseTable+" Where "+PC+"="+PV+" AND "+TCol+" BETWEEN '"+TS+"' AND '"+TE+"' ");
			    
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
				
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}

			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    
			    btn = new JButton[numberOfRows];
			    
			    data=new Object[numberOfRows][numberOfColumns+1];
			    int order=0;
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PC+"="+PV+" AND "+TCol+" BETWEEN '"+TS+"' AND '"+TE+"' ");
				
				while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
					    	 if(rs.getObject(i)==null){
					    		 data[order][i-1]="";
					    	 }else{
					    		 data[order][i-1]=rs.getObject(i);	
					    	 }		  	
				       }
				      order++;
				 }
	         
	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }  
	  
	  	  Table(names, data);
  }
  
  public void GetData5(String PickCol,String PickCon,String PickCol2,String PickCon2){
	  Statement statement;
	  ResultSet rs;
	  ResultSetMetaData rsMetaData;
	  numberOfRows=0;
	  
	  String PCol=PickCol;	//用於取出Table資料時必要的篩選的欄位
	  String Pcon=PickCon;	//用於取出Table資料時必要的篩選的欄位的值
	  String PCol2=PickCol2;	//用於取出Table資料時必要的篩選的欄位
	  String Pcon2=PickCon2;	//用於取出Table資料時必要的篩選的欄位的值
	  try{
	       //  Class.forName(DRIVER_NAME);//載入JDBC Driver
	         System.out.println("資料庫連結成功"); 
	         statement = cc.createStatement();
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PCol+" = '"+Pcon+"' AND "+PCol2+" = '"+Pcon2+"'");
				
				rsMetaData = rs.getMetaData();
				numberOfColumns = rsMetaData.getColumnCount();
				names=new String[numberOfColumns+1];
				
				for(int i=1; i<=numberOfColumns; i++){
				  System.out.printf("%s\t",rsMetaData.getColumnName(i));			  	
				  names[i-1]=rsMetaData.getColumnName(i);
				}

			    System.out.println();
			    
			    while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				     System.out.printf("%s\t",rs.getObject(i));			  	
			       }
			      System.out.println();	
			      numberOfRows++;
			     }
			    
			    btn = new JButton[numberOfRows];
			    
			    data=new Object[numberOfRows][numberOfColumns+1];
			    int order=0;
				rs = statement.executeQuery("SELECT * FROM "+UseTable+" Where "+PCol+" = '"+Pcon+"' AND "+PCol2+" = '"+Pcon2+"'");
			    while (rs.next()){
				      for(int i=1; i<=numberOfColumns; i++)
					   {
					    	 if(rs.getObject(i)==null){
					    		 data[order][i-1]="";
					    	 }else{
					    		 data[order][i-1]=rs.getObject(i);	
					    	 }		  	
				       }
				      order++;
				 }

	         
	         //new jtest(numberOfRows,numberOfColumns);
	      }
	      /*catch(ClassNotFoundException classNotFound){//找不到JDBC Driver
	        classNotFound.printStackTrace();	
	      }*/catch(SQLException sqlException){//資料庫操作發生錯誤
	        sqlException.printStackTrace();
	      }  
	  
	  	  Table(names, data);
  }
  
  public void Table(String[] columnNames, Object[][] data) {
	
    //super(new GridLayout(1, 0));
    MyTableModel myTableModel = new MyTableModel(columnNames, data);
    myTableModel.fireTableDataChanged();
    if (DEBUG) {
      for (int i = 0; i < numberOfRows; i++) {
        for (int j = 0; j < numberOfColumns; j++) {
          System.out.println(myTableModel.getValueAt(i, j) + "  ");
        }
      }
    }
    
    for (int i = 0; i < data.length; i++) {
    	btn[i]=new JButton("查看_"+i);
    	data[i][numberOfColumns] = btn[i];
    }
    
    JTable table = new JTable(myTableModel);
    table.getTableHeader().setReorderingAllowed(false);//欄位拖動功能
    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);  
    table.setPreferredScrollableViewportSize(new Dimension(650, 70));
    // table.setFillsViewportHeight(true);
    // Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);
    table.setDefaultRenderer(JButton.class, new JButtonRenderer());
    // Add the scroll pane to this panel.
    add(scrollPane);
    final TableCellButton tableCellButton = new TableCellButton();
    table.setDefaultEditor(JButton.class, tableCellButton);
    tableCellButton.addActionListener(this);
    
    
  }
  
  public void Table2(String[] columnNames, Object[][] data) {
		
	    //super(new GridLayout(1, 0));
	    
	    MyTableModel myTableModel = new MyTableModel(columnNames, data);
	    myTableModel.fireTableDataChanged();
	    if (DEBUG) {
	    	/*for (int i = 0; i < numberOfRows; i++) {
		    	
		    }*/
	      for (int i = 0; i < numberOfRows; i++) {
	        for (int j = 1; j <= numberOfColumns; j++) {
	          System.out.println(myTableModel.getValueAt(i, j) + "  ");
	        }
	      }
	  
	    }
	    JTable table = new JTable(myTableModel);
	    table.getTableHeader().setReorderingAllowed(false);//欄位拖動功能
	    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);  
	    table.setPreferredScrollableViewportSize(new Dimension(650, 70));
	    // table.setFillsViewportHeight(true);
	    // Create the scroll pane and add the table to it.
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setDefaultRenderer(JButton.class, new JButtonRenderer());
	    // Add the scroll pane to this panel.
	    add(scrollPane);
	    final TableCellButton tableCellButton = new TableCellButton();
	    table.setDefaultEditor(JButton.class, tableCellButton);
	    tableCellButton.addActionListener(this);
	    
	  }

  public void Table3(String[] columnNames, Object[][] data) {
		
	    //super(new GridLayout(1, 0));
	    
	    MyTableModel myTableModel = new MyTableModel(columnNames, data);
	    myTableModel.fireTableDataChanged();
	    if (DEBUG) {
	      for (int i = 0; i < numberOfRows; i++) {
	        for (int j = 0; j < numberOfColumns; j++) {
	          System.out.println(myTableModel.getValueAt(i, j) + "  ");
	        }
	      }
	    }
	    
	    for (int i = 0; i < data.length; i++) {
	    	btn[i]=new JButton("查看_"+i);
	    	data[i][numberOfColumns] = btn[i];
	    }
	    
	    JTable table = new JTable(myTableModel);
	    table.getTableHeader().setReorderingAllowed(false);//欄位拖動功能
	    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);  
	    table.setPreferredScrollableViewportSize(new Dimension(650, 70));
	    // table.setFillsViewportHeight(true);
	    // Create the scroll pane and add the table to it.
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setDefaultRenderer(JButton.class, new JButtonRenderer());
	    // Add the scroll pane to this panel.
	    add(scrollPane);
	    final TableCellButton tableCellButton = new TableCellButton();
	    table.setDefaultEditor(JButton.class, tableCellButton);
	    tableCellButton.addActionListener(this);
	    
	    
	  }
  public void actionPerformed(ActionEvent actEvent) {
	  System.out.println(actEvent);
	  int ae = Integer.parseInt(actEvent.getActionCommand().substring(3));
	  //System.out.println(ae);
	  /*JOptionPane.showMessageDialog(null,ae,"push",
		JOptionPane.INFORMATION_MESSAGE);*/
	  String[] d= new String[numberOfColumns];
	  for(int i=0; i<numberOfColumns;i++){
		  d[i]=data[ae][i].toString();
	  }
	  testn++;
	  switch(UseFuntion){
	  case "viewCheckCTA":{
	  		if(cCTA[0]!=null){
	  			cCTA = new checkCTA[2];
	  			cCTA[1]=new checkCTA(cc,d,url,username,password);
	  			cCTA[0].setVisible(false);
	  			cCTA[1].setAlwaysOnTop(true); 
	  			cCTA[1].requestFocus();  
	  			cCTA[1].setVisible(true);
	  			
		  		break;
	  		}
	  		cCTA = new checkCTA[1];
	  		cCTA[0]=new checkCTA(cc,d,url,username,password);
	  		cCTA[0].setAlwaysOnTop(true); 
  			cCTA[0].requestFocus();  
	  		cCTA[0].setVisible(true);
	  		break;
	  	}
	  	case "viewCheckSRA":{
	  		if(cSRA[0]!=null){
	  			cSRA = new checkSRA[2];
	  			cSRA[1]=new checkSRA(cc,d,url,username,password);
	  			cSRA[0].setVisible(false);	
	  			cSRA[1].setAlwaysOnTop(true); 
	  			cSRA[1].requestFocus();  
	  			cSRA[1].setVisible(true);
		  		break;
	  		}
	  		cSRA = new checkSRA[1];
	  		cSRA[0]=new checkSRA(cc,d,url,username,password);
	  		cSRA[0].setAlwaysOnTop(true); 
	  		cSRA[0].requestFocus();  
	  		cSRA[0].setVisible(true);
	  		break;
	  	}
	  	case "viewCheckOR":{
	  		if(cOR[0]!=null){
	  			cOR = new checkOR[2];
	  			cOR[1]=new checkOR(cc,d,url,username,password);
	  			cOR[0].setVisible(false);	
	  			cOR[1].setAlwaysOnTop(true); 
	  			cOR[1].requestFocus();  
	  			cOR[1].setVisible(true);
		  		break;
	  		}
	  		cOR = new checkOR[1];
	  		cOR[0]=new checkOR(cc,d,url,username,password);
	  		cOR[0].setAlwaysOnTop(true); 
	  		cOR[0].requestFocus();  
	  		cOR[0].setVisible(true);
	  		break;
	  	}
	  	case "SearchOrder" :{
	  		if(tORN[0]!=null){
		  		tORN = new testORN[2];
	  			tORN[1]=new testORN(cc,d,EST,url,username,password);
		  		tORN[0].setVisible(false);	
		  		tORN[1].setAlwaysOnTop(true); 
		  		tORN[1].requestFocus();  
		  		tORN[1].setVisible(true);
		  		break;
	  		}
	  		tORN = new testORN[1];
	  		tORN[0]=new testORN(cc,d,EST,url,username,password);
	  		tORN[0].setAlwaysOnTop(true); 
	  		tORN[0].requestFocus();  
	  		tORN[0].setVisible(true);
	  		break;
	  		
	  		}
	  	case "receiveORReturn" :{
	  		try {
	  			Statement statement;
	  			ResultSet rs;
	  			ResultSetMetaData rsMetaData;
			
	        //System.out.println("資料庫連結成功"); 
	        statement = cc.createStatement();
	  		rs = statement.executeQuery("SELECT * FROM CT Where CTA_Num = '"+d[30]+"';");
	  		rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			String[] da=new String[numberOfColumns];
	  		while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				    	 if(rs.getObject(i)==null){
				    		 da[i-1]="";
				    	 }else{
				    		 da[i-1]=rs.getObject(i).toString();	
				    	 }		  	
			       }break;
			 }
	  		if(tORN[0]!=null){
		  		tORN = new testORN[2];
	  			tORN[1]=new testORN(cc,da,3,url,username,password);
		  		tORN[0].setVisible(false);	
		  		tORN[1].setAlwaysOnTop(true); 
		  		tORN[1].requestFocus();  
		  		tORN[1].setVisible(true);
		  		break;
	  		}
	  		tORN = new testORN[1];
	  		tORN[0]=new testORN(cc,da,3,url,username,password);
	  		tORN[0].setAlwaysOnTop(true); 
	  		tORN[0].requestFocus();  
	  		tORN[0].setVisible(true);
	  		break;
	  		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	  		} 
	  	}
	  	case "receiveSRReturn" :{
	  		try {
	  			Statement statement;
	  			ResultSet rs;
	  			ResultSetMetaData rsMetaData;
			
	        System.out.println("資料庫連結成功"); 
	        statement = cc.createStatement();
	  		rs = statement.executeQuery("SELECT * FROM SR Where SRA_Num = '"+d[0]+"';");
	  		rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			String[] da=new String[numberOfColumns];
	  		while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				    	 if(rs.getObject(i)==null){
				    		 da[i-1]="";
				    	 }else{
				    		 da[i-1]=rs.getObject(i).toString();	
				    	 }		  	
			       }break;
			 }
	  		if(tsd[0]!=null){
	 			tsd = new testSRData[2];
	 			tsd[1]=new testSRData(cc,da,3,url,username,password);
	 			tsd[0].setVisible(false);	
	 			tsd[1].setAlwaysOnTop(true); 
	 			tsd[1].requestFocus();  
	 			tsd[1].setVisible(true);
		  		break;
	  		}
	 		tsd = new testSRData[1];
	 		tsd[0]=new testSRData(cc,da,3,url,username,password);
	 		tsd[0].setAlwaysOnTop(true); 
	 		tsd[0].requestFocus();  
	 		tsd[0].setVisible(true);
	  		break;
	  		
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
	  	}
	  	case "receiveCTReturn" :{
	  		try {
	  			Statement statement;
	  			ResultSet rs;
	  			ResultSetMetaData rsMetaData;
			
	        System.out.println("資料庫連結成功"); 
	        statement = cc.createStatement();
	  		rs = statement.executeQuery("SELECT * FROM CT Where CTA_Num = '"+d[0]+"';");
	  		System.out.println(d[0]);
	  		rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();
			String[] da=new String[numberOfColumns];
	  		while (rs.next()){
			      for(int i=1; i<=numberOfColumns; i++)
				   {
				    	 if(rs.getObject(i)==null){
				    		 da[i-1]="";
				    	 }else{
				    		 da[i-1]=rs.getObject(i).toString();	
				    	 }		  	
			       }break;
			 }
	  		if(tc[0]!=null){
	  			tc = new testClient[2];
	  			tc[1]=new testClient(cc,da,3,url,username,password);
	  			tc[0].setVisible(false);	
	  			tc[1].setAlwaysOnTop(true); 
	  			tc[1].requestFocus();  
	  			tc[1].setVisible(true);
		  		break;
	  		}
	  		tc = new testClient[1];
	  		tc[0]=new testClient(cc,da,3,url,username,password);
	  		tc[0].setAlwaysOnTop(true); 
	  		tc[0].requestFocus();  
	  		tc[0].setVisible(true);
	  		break;
	  		
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} 
	  	}
	  	
	  	case "SearchProData" :{
	  		String[] data=new String[d.length];
	  		for(int i=0;i<d.length;i++)
	  			data[i]=d[i].toString();
	 		if(tpd[0]!=null){
	 			tpd = new testProData[2];
	 			tpd[1]=new testProData(cc,data,EST,url,username,password);
	 			tpd[0].setVisible(false);	
	 			tpd[1].setAlwaysOnTop(true); 
	 			tpd[1].requestFocus();  
	 			tpd[1].setVisible(true);
		  		break;
	  		}
	 		tpd = new testProData[1];
	 		tpd[0]=new testProData(cc,data,EST,url,username,password);
	 		tpd[0].setAlwaysOnTop(true); 
	 		tpd[0].requestFocus();  
	 		tpd[0].setVisible(true);
	  		break;
	 		}
	  	case "SearchSRData" :{
	 		if(tsd[0]!=null){
	 			tsd = new testSRData[2];
	 			tsd[1]=new testSRData(cc,d,EST,url,username,password);
	 			tsd[0].setVisible(false);	
	 			tsd[1].setAlwaysOnTop(true); 
	 			tsd[1].requestFocus();  
	 			tsd[1].setVisible(true);
		  		break;
	  		}
	 		tsd = new testSRData[1];
	 		tsd[0]=new testSRData(cc,d,EST,url,username,password);
	 		tsd[0].setAlwaysOnTop(true); 
	 		tsd[0].requestFocus();  
	 		tsd[0].setVisible(true);
	  		break;
	 		}
	  	case "SearchClient" :{
	 		if(tc[0]!=null){
	 			tc = new testClient[2];
	 			tc[1]=new testClient(cc,d,EST,url,username,password);
	 			tc[0].setVisible(false);	
	 			tc[1].setAlwaysOnTop(true); 
	 			tc[1].requestFocus();  
	 			tc[1].setVisible(true);
		  		break;
	  		}
	 		tc = new testClient[1];
	 		tc[0]=new testClient(cc,d,EST,url,username,password);
	 		tc[0].setAlwaysOnTop(true); 
	 		tc[0].requestFocus();  
	 		tc[0].setVisible(true);
	  		break;
	 		}
	  	case "SearchAM" :{
	 		if(tam[0]!=null){
	 			tam = new testAM[2];
	 			tam[1]=new testAM(cc,d,url,username,password);
	 			tam[0].setVisible(false);	
	 			tam[1].setAlwaysOnTop(true); 
	 			tam[1].requestFocus();  
	 			tam[1].setVisible(true);
		  		break;
	  		}
	 		tam = new testAM[1];
	 		tam[0]=new testAM(cc,d,url,username,password);
	 		tam[0].setAlwaysOnTop(true); 
	 		tam[0].requestFocus();  
	 		tam[0].setVisible(true);
	  		break;
	 		}
	  	case "SearchProStock" :{
	  		if(tps[0]!=null){
	  			tps = new testProStock[2];
	  			tps[1]=new testProStock(cc,d);
	  			tps[0].setVisible(false);	
	  			tps[1].setAlwaysOnTop(true); 
	  			tps[1].requestFocus();  
	  			tps[1].setVisible(true);
		  		break;
	  		}
	  		tps = new testProStock[1];
	  		tps[0]=new testProStock(cc,d);
	  		tps[0].setAlwaysOnTop(true); 
	  		tps[0].requestFocus();  
	  		tps[0].setVisible(true);
	  		break;
	  		}
	  	case "SearchSM" :{
	  		if(tSM[0]!=null){
	  			tSM = new testSM[2];
	  			tSM[1]=new testSM(cc,d,url,username,password);
	  			tSM[0].setVisible(false);	
	  			tSM[1].setAlwaysOnTop(true); 
	  			tSM[1].requestFocus();  
	  			tSM[1].setVisible(true);
		  		break;
	  		}
	  		tSM = new testSM[1];
	  		tSM[0]=new testSM(cc,d,url,username,password);
	  		tSM[0].setAlwaysOnTop(true); 
	  		tSM[0].requestFocus();  
	  		tSM[0].setVisible(true);
	  		break;
	  		}  
	  	case "SearchCN" :{
	  		if(tcn[0]!=null){
	  			tcn = new testCN[2];
	  			tcn[1]=new testCN(cc,d,url,username,password);
	  			tcn[0].setVisible(false);	
	  			tcn[1].setAlwaysOnTop(true); 
	  			tcn[1].requestFocus();  
	  			tcn[1].setVisible(true);
		  		break;
	  		}
	  		tcn = new testCN[1];
	  		tcn[0]=new testCN(cc,d,url,username,password);
	  		tcn[0].setAlwaysOnTop(true); 
	  		tcn[0].requestFocus();  
	  		tcn[0].setVisible(true);
	  		break;
	  	}
	  	
	  	case "SearchMMO" :{
	  		if(tmmo[0]!=null){
	  			tmmo = new testMMO[2];
	  			tmmo[1]=new testMMO(cc,d,url,username,password);
	  			tmmo[0].setVisible(false);	
	  			tmmo[1].setAlwaysOnTop(true); 
	  			tmmo[1].requestFocus();  
	  			tmmo[1].setVisible(true);
		  		break;
	  		}
	  		tmmo = new testMMO[1];
	  		tmmo[0]=new testMMO(cc,d,url,username,password);
	  		tmmo[0].setAlwaysOnTop(true); 
	  		tmmo[0].requestFocus();  
	  		tmmo[0].setVisible(true);
	  		break;
	  	}
	  	case "SearchEmployee" :{
	  		if(tE[0]!=null){
	  			tE = new testEmployee[2];
	  			tE[1]=new testEmployee(cc,d,url,username,password);
	  			tE[0].setVisible(false);	
	  			tE[1].setAlwaysOnTop(true); 
	  			tE[1].requestFocus();  
	  			tE[1].setVisible(true);
		  		break;
	  		}
	  		tE = new testEmployee[1];
	  		tE[0]=new testEmployee(cc,d,url,username,password);
	  		tE[0].setAlwaysOnTop(true); 
	  		tE[0].requestFocus();  
	  		tE[0].setVisible(true);
	  		break;
	  		}
	 	case "NewShipment" :{
	  		if(PSM[0]!=null){
	  			PSM = new PreviewSM[2];
	  			PSM[1]=new PreviewSM(cc,d,url,username,password);
	  			PSM[0].setVisible(false);	
	  			PSM[1].setAlwaysOnTop(true); 
	  			PSM[1].requestFocus();  
	  			PSM[1].setVisible(true);
		  		break;
	  		}
	  		PSM = new PreviewSM[1];
	  		PSM[0]=new PreviewSM(cc,d,url,username,password);
	  		PSM[0].setAlwaysOnTop(true); 
	  		PSM[0].requestFocus();  
	  		PSM[0].setVisible(true);
	  		break;
	  		}
	 	case "SearchPurchase" :{

	  		if(tP[0]!=null){
	  			tP = new testPurchase[2];
	  			tP[1]=new testPurchase(cc,d,url,username,password);
	  			tP[0].setVisible(false);	
	  			tP[1].setAlwaysOnTop(true); 
	  			tP[1].requestFocus();  
	  			tP[1].setVisible(true);
		  		break;
	  		}
	  		tP = new testPurchase[1];
	  		tP[0]=new testPurchase(cc,d,url,username,password);
	  		tP[0].setAlwaysOnTop(true); 
	  		tP[0].requestFocus();  
	  		tP[0].setVisible(true);
	  		break;
	 		}
	 	case "NewInputgoods" :{
	 		  //clone版新增加-------------
	 		NewInputgoods NI = (NewInputgoods)clone;
	 		  //clone版新增加-------------
	 		if(PI[0]!=null){
	 			PI = new PreviewInputgoods[2];
	 			PI[1]=new PreviewInputgoods(cc,d,NI,url,username,password);   //clone版新增加--(d->d,NI)-----------
	 			PI[0].setVisible(false);	
	 			PI[1].setAlwaysOnTop(true); 
	 			PI[1].requestFocus();  
	 			PI[1].setVisible(true);
	 			  //clone版新增加-------------
	 			NI.setVisible(false);
	 			  //clone版新增加-------------
		  		break;
	  		}
	 		PI = new PreviewInputgoods[1];
	 		PI[0]=new PreviewInputgoods(cc,d,NI,url,username,password);  //clone版新增加--(d->d,NI)-----------
	 		PI[0].setAlwaysOnTop(true); 
	 		PI[0].requestFocus();  
	 		PI[0].setVisible(true);
	 		  //clone版新增加-------------
	 		NI.setVisible(false);
	 		  //clone版新增加-------------
	 		break;
	 		}
		 default: break;
	  }
	  

  }
  
  public void setTableName(String tn){
	  UseTable=tn;
  } 
  
  public String  getTableName(String tn){
	  return UseTable;
  }
  
  class MyTableModel extends AbstractTableModel {
    String[] columnNames;
    Object[][] data;
    public void removeTableModelListener(TableModelListener l){
    	l.tableChanged(null);
    }
    public MyTableModel(String[] columnNames, Object[][] data) {
      this.columnNames = columnNames;
      this.data = data;
    }
 
    public int getColumnCount() {
      return columnNames.length;
    }
 
    public int getRowCount() {
      return data.length;
    }
 
    public String getColumnName(int col) {
      return columnNames[col];
    }
 
    public Object getValueAt(int row, int col) {
      return data[row][col];
    }
 
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return getColumnClass(columnIndex) == JButton.class;
    }
    
  }
  
  
}
 
class TableCellButton extends JButton implements TableCellEditor {
  private EventListenerList cellEditorListeners = new EventListenerList();
 
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
      int row, int column) {
    JButton button = (JButton) value;
    setText(button.getText());
    putClientProperty("row", new Integer(row));
    return this;
  }
 
  public void addCellEditorListener(CellEditorListener l) {
    cellEditorListeners.add(CellEditorListener.class, l);
  }
 
  protected void fireEditingCanceled() {
    EventListener[] listeners = cellEditorListeners.getListeners(CellEditorListener.class);
    for (int i = 0; i < listeners.length; ++i) {
      CellEditorListener l = (CellEditorListener) listeners[i];
      l.editingCanceled(changeEvent);
    }
  }
 
  protected void fireEditingStopped() {
    EventListener[] listeners = cellEditorListeners.getListeners(CellEditorListener.class);
    for (int i = 0; i < listeners.length; ++i) {
      CellEditorListener l = (CellEditorListener) listeners[i];
      l.editingStopped(changeEvent);
    }
  }
 
  public void cancelCellEditing() {
    fireEditingCanceled();
  }
 
  public Object getCellEditorValue() {
    return null;
  }
 
  public boolean isCellEditable(EventObject anEvent) {
    if (anEvent instanceof MouseEvent) {
      MouseEvent e = (MouseEvent) anEvent;
      if (e.getID() == MouseEvent.MOUSE_PRESSED) {
        MouseEvent newEvent = new MouseEvent(this, MouseEvent.MOUSE_PRESSED, e.getWhen(), e
            .getModifiers(), 0, 0, e.getClickCount(), e.isPopupTrigger());
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(newEvent);
        return true;
      }
    }
    return false;
  }
 
  public void removeCellEditorListener(CellEditorListener l) {
    cellEditorListeners.remove(CellEditorListener.class, l);
  }
 
  public boolean shouldSelectCell(EventObject anEvent) {
    return false;
  }
 
  public boolean stopCellEditing() {
    fireEditingStopped();
    return true;
  }
}
 
class JButtonRenderer extends JButton implements TableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    JButton button = (JButton) value;
    setText(button.getText());
    return this;
  }
}