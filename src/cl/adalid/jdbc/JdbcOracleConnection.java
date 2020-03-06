package cl.adalid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This program demonstrates how to make database connection with Oracle
 * database server.
 * @author www.codejava.net
 *
 */
public class JdbcOracleConnection {

    public static void main(String[] args) {

        Connection conn1 = null;
        Connection conn2 = null;

        System.out.print("Command-line arguments: ");

        for (String arg : args) {
        	System.out.print(arg + " ");
        }

        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");

            // METHOD #1
            String dbURL1 = "jdbc:oracle:thin:talentodigital/123456@localhost:1521:xe";

            conn1 = DriverManager.getConnection(dbURL1);

            if (conn1 != null) {
                System.out.println("\n\nConnected with connection #1");
            }

            // METHOD #2
            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:xe";

            String username = "talentodigital";
            String password = "123456";

            conn2 = DriverManager.getConnection(dbURL2, username, password);

            if (conn2 != null) {
                System.out.println("Connected with connection #2");
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                	
                	// Step 3 create the statement object  
                	Statement stmt = conn2.createStatement();  

                	// Step 4 execute query  
                	ResultSet rs = stmt.executeQuery("select * from libros where codigo=" + args[0]);  

                	System.out.println("\n===================================================");
                	System.out.println("select * from libros where codigo=" + args[0]);
                	System.out.println("===================================================");
                	
                	while(rs.next())
                		System.out.println(rs.getString(2));

                	System.out.println("===================================================");
                	System.out.println("\n*************************************************************************");

                	conn1.close();
                }

                if (conn2 != null && !conn2.isClosed()) {

                	// Step 3 create the statement object
                	Statement stmt = conn2.createStatement();
                	
                	// Step 4 execute query
                	ResultSet rs = stmt.executeQuery("select * from libros");
                	System.out.println("\n===================================================");
                	System.out.println("select * from libros");
                	System.out.println("===================================================");
                	while(rs.next())
                		System.out.println(rs.getInt(1) + "  " + rs.getString(2));

                	System.out.println("===================================================");

                    conn2.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}