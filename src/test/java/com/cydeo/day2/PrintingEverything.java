package com.cydeo.day2;

import java.sql.*;

public class PrintingEverything {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:oracle:thin:@34.229.82.244:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;
        ResultSet rs  = stmnt.executeQuery( "SELECT * FROM EMPLOYEES" ) ;
        ResultSetMetaData rsmd= rs.getMetaData() ;

        // go through each and every row
        while(rs.next()) {

            // how do you go through each and every column
            for (int columnIndex = 1; columnIndex <= rsmd.getColumnCount()    ; columnIndex++) {

                System.out.print(  rs.getString(columnIndex) + "  " );

            }

            System.out.println();


        }





    }


}