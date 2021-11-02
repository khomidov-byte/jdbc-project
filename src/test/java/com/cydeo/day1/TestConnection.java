package com.cydeo.day1;

import java.sql.*;

public class TestConnection {


    public static void main(String[] args) {



        // make initial connection to Oracle Database we have
        // step 1: add oracle driver dependency in pom.xml


        // connection information
        // connection String (JDBC URL) : jdbc:oracle:thin@34.229.82.244:1521:XE
        // USERNAME password hr / hr
        String url = "jdbc:oracle:thin:@34.229.82.244:1521:XE";
        String username = "hr";
        String password = "hr";

        // 1. create a connection use DriverManager class and save the connection

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");
        } catch (SQLException e) {
            System.out.println("Error while connection " + e.getMessage() );
            e.printStackTrace();
        }


    }


}
