/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daniel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DanielAlbuquerque
 */
public class DataConnect {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdb", "root", "");
			return con;
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Database.getConnection() Error -->" + e.getMessage());
            return null;
        }
    }
    
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            
        }
    }
}
