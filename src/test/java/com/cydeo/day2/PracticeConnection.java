package com.cydeo.day2;

import java.sql.*;

public class PracticeConnection {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@34.229.82.244:1521:XE";
        String username = "hr";
        String password = "hr";

        // 1. get Connection object
        // getConnection method throws checked exception, this time we decided to
        // declare it instead of handling it using throws SQLException
        Connection conn = DriverManager.getConnection(url, username, password);
        // 2. create Statement object from Connection
        Statement stmnt = conn.createStatement();
        // 3.get ResultSet by running executeQuery method of Statement object
        // we are connected to oracle database so we can select from HR database tables
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        // 4. navigate through the ResultSet object to get the cell value
        rs.next(); // move the pointer from before first location to first row
        // 5. use ResultSet getX method like getString, getInt, getDouble to actually read data
        // read REGION_ID and REGION_NAME column and print it out
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // continue to go to next row to get more data
        rs.next(); // moved to second row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));


        // continue to go to next row to get more data
        rs.next(); // moved to third row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // continue to go to next row to get more data
        rs.next(); // moved to four row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // continue to go to next row to get more data
        System.out.println( rs.next()); // moved to fifth row
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));


        System.out.println("THE END");





    }
}
