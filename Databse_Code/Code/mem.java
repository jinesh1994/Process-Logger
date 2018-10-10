import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import com.almworks.sqlite4java.*;

public class mem {
	
	static Connection con=null;  //connection with the database server
	static Connection con1=null;
	static Statement st=null; //handles sql statements 
	static Statement st1=null;
	static ResultSet rs;  //table of data
	static ResultSet recv;
	static int count,i=1;
	//Receiving process related info
	static int PMEM=23,PCPU=95,Process_ID=7210,Number_of_threads=4;
	
	static String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	//public static void main(String a[])
	{
		try{
			Class.forName("org.sqlite.JDBC");//loads JDBC driver class
			con = DriverManager.getConnection("jdbc:sqlite::memory:"); //establishes connection
			//to the  in memory database
			st=con.createStatement();
			String size1="PRAGMA max_page_count=48828";   //97666*1024=Approximately 100 MB
			try {											//page_size=1024
				st.execute(size1);
				} catch (SQLException e) {
			
						e.printStackTrace();   }
			callMe();
			}catch(Exception e)
					{e.printStackTrace();}
	}
	
	public static void callMe() 
	{
			String sql="CREATE TABLE Process_info" +
            "(Process_ID INT PRIMARY KEY     NOT NULL," + 
            " Number_of_threads            TEXT     NOT NULL, " + 
            " PCPU        TEXT, " + 
            " PMEM        TEXT, " +  
           
            " TIMESTAMP         TEXT)";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			while(true)
			{
				String sql1="INSERT INTO Process_info"
				+ "(Process_ID,Number_of_threads,PCPU,PMEM,TIMESTAMP)"
				+ "values('"+Process_ID+i+"'"
						
						+ ",'"+Number_of_threads+""+i+"'"
						+ ",'"+PCPU+""+i+"'"
						+ ",'"+PMEM+""+i+"'"
						
						
						+ ",'"+TIMESTAMP+"')";
				try{
					st.executeUpdate(sql1);
					i++;
					
				}catch(Exception e){System.out.println("Size exceeded"); break;}
				
			}
			
			try {
				st.executeUpdate("backup to new"+i+".db");//A backup of database is made on the disk 
				String del="DROP TABLE Process_info"; //When the predefined size is reached, the in memory database is cleared
				st.executeUpdate(del);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			                              }
			
			callMe();
	        }
	
}

	