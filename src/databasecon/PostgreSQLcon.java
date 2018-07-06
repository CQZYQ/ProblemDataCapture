package databasecon;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
  
public class PostgreSQLcon {  
     public static final String Driver = "org.postgresql.Driver";    
        public static final String url = "jdbc:postgresql://47.95.215.87:5111/onlinejudge?useUnicode=true&characterEncoding=utf-8&useSSL=false";    
        public static final String user = "onlinejudge";    
        public static final String password = "onlinejudge";    
        
        static {    
            try {    
                Class.forName(Driver);    
            } catch (ClassNotFoundException e) {    
                e.printStackTrace();    
            }    
        }    
        public static Connection getConnection() throws SQLException{    
            Connection conn = null;    
            conn = DriverManager.getConnection(url,user,password);    
            return conn;    
        }    
} 