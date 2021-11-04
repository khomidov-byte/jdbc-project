package com.cydeo.day2;

import java.sql.*;

public class LoopingBackward {


    public static void main(String[] args) throws SQLException {
        // run this query - SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID<120
        // Print out the EMPLOYEE_ID column from last row till first row


        String url = "jdbc:oracle:thin:@34.229.82.244:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;
        ResultSet rs  = stmnt.executeQuery( "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID<120" ) ;
        ResultSetMetaData rsmd = rs.getMetaData();

        // Print out the Employee_id column from last row till first row
        rs.afterLast(); // move the cursor to after last location so we can use previous to move back

        while (rs.previous()){

            System.out.println(rs.getString(1));


        }


        // After we are done with Connection, Statement, ResultSet, we need to close them
        // just like Scanner, FileInputStream and so on
        // the order of closing is exactly opposite to the creation
        rs.close();
        stmnt.close();
        conn.close();





    }
}
