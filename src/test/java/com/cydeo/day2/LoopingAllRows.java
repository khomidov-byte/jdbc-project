package com.cydeo.day2;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class LoopingAllRows {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@34.229.82.244:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        // 1. get Connection object
        // getConnection method throws checked exception, this time we decided to
        // declare it instead of handling it using throws SQLException
        Connection conn = DriverManager.getConnection(url, username, password);

        // 2. create Statement object from Connection
        // AND WE WANT TO BE ABLE TO MOVE CURSOR ANYWHERE WE WANT NOT JUST TOP TO BOTTOM BY DEFAULT
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;

        // 3. get ResultSet by running executeQuery method of Statement object
        // we are connected to oracle database, so we can select from HR database tables
        ResultSet rs  = stmnt.executeQuery( "SELECT * FROM REGIONS" ) ;


        // 4. loop through all rows and print items
        // rs.next() move the cursor to next row ,
        // return true if next row is valid , false if not,
        // so we can use it in while condition
        while( rs.next() ){  // keep looping until there is no valid next row

            System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
            System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        }
        // now you are at after last location , if you run below line , it will throw exception
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        // ResultSet Object has many navigation methods other than next() to move anywhere



    }

}