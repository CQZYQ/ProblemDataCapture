package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databasecon.PostgreSQLcon;

public class Readout {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from problem";
		Connection conn = null;
		PreparedStatement ps = null;
		conn = PostgreSQLcon.getConnection();
		ps = conn.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		  while(res.next()) {
		  String id = res.getString("description"); 
		  System.out.println("_id:"+id);
		  }
	}

}
