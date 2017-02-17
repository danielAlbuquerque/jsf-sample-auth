/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daniel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.daniel.util.DataConnect;
import java.sql.ResultSet;


/**
 *
 * @author DanielAlbuquerque
 */
public class LoginDAO {
    public static boolean validate(String user, String pwd) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        con = DataConnect.getConnection();
        
        pstmt = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
        pstmt.setString(1, user);
        pstmt.setString(2, pwd);
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()) {
            return true;
        }
        
        return false;
    }
}
