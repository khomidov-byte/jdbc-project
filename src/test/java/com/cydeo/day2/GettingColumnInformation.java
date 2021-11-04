package com.cydeo.day2;

import java.sql.*;

public class GettingColumnInformation {

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
        ResultSet rs  = stmnt.executeQuery( "SELECT * FROM EMPLOYEES" ) ;

        // ResultSet object only hold the data
        // it does not hold any information about the column names and column count
        // in order to get column related data , we need to use ResultSetMetaData
        // we can call ResultSet object getMetaData method to ResultSetMetaData object
        ResultSetMetaData rsmd = rs.getMetaData();
        // we only care about 2 methods  getColumnCount and getColumnName(columnIndexHere)
        int totalColumnCount =  rsmd.getColumnCount() ;
        System.out.println("totalColumnCount = " + totalColumnCount);

        // get the column name by index  for example first column name
        String columnName = rsmd.getColumnName(1);
        System.out.println("First columnName = " + columnName);

        // loop and print all columns
        for (int columnIndex = 1 ; columnIndex <= totalColumnCount  ; columnIndex++) {

            System.out.print("Column Index is  " + columnIndex );
            System.out.println(" | Column name is " +  rsmd.getColumnName( columnIndex  )     );

        }

        // revisiting the getting cell value using rs.getString(columnName or columnIndex)
        // lets try out getting cell value using column index instead for example
        // get the employee_id in first row in 2 different way  : the value 100
        rs.next() ;  // we moved to first row here
        System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID") );
        System.out.println("rs.getString(1) = " + rs.getString(1));
        // now get the second and 3rd columns
        System.out.println("rs.getString(2) = " + rs.getString(2));
        System.out.println("rs.getString(3) = " + rs.getString(3));

        // combining what you learned above , print out entire first row
        for (int columnIndex = 1; columnIndex <= totalColumnCount ; columnIndex++) {
            // how to also add column name here
            System.out.println("rsmd.getColumnName("+columnIndex+") = " + rsmd.getColumnName(columnIndex));
            // this will print each and every cell value at current row
            System.out.println("rs.getString("+columnIndex+") = " + rs.getString(columnIndex) );
        }

        rs.next() ; // now we are at second row
        // combining what you learned above , print out entire second row
        for (int columnIndex = 1; columnIndex <= totalColumnCount ; columnIndex++) {
            // how to also add column name here
            System.out.println("rsmd.getColumnName("+columnIndex+") = " + rsmd.getColumnName(columnIndex));
            // this will print each and every cell value at current row
            System.out.println("rs.getString("+columnIndex+") = " + rs.getString(columnIndex) );
        }





    }


}