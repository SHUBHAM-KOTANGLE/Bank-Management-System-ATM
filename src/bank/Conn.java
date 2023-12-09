package bank;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
		
			 c= DriverManager.getConnection("jdbc:mysql:///bank","root","admin");
			s=c.createStatement();
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}

}
