/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vatahov.mywebproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author Slavi Vatahov
 */
public final class Authentication {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private java.sql.Connection conn;

    public Authentication(String username, String password) throws NamingException, SQLException {
        openConnectionToDataBase();
        this.username = username;
        this.password = password;

    }

    public Authentication(String firstName, String lastName, String username, String email, String password) throws NamingException, SQLException {
        openConnectionToDataBase();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public Authentication(int phoneNumber, String password) {

    }

    private void openConnectionToDataBase() throws NamingException, SQLException {

        javax.naming.InitialContext ctx = new javax.naming.InitialContext();
        javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("MyDataBase");
        conn = ds.getConnection();
    }

    boolean checkingTheUserInDatabase() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username,email FROM user WHERE username='" + username + "'" + "OR email='" + email + "'");
        return rs.next();
    }

    boolean checkSignIn() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username,password FROM user WHERE username='" + username + "'" + "AND password='" + password + "'");
        return rs.next();
    }

    boolean createNewAcount() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (firstname,lastname,username,email,password) VALUES (?,?,?,?,?)");

        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, username);
        pstmt.setString(4, email);
        pstmt.setString(5, password);
        pstmt.executeUpdate();

        String query = "ALTER TABLE `user` DROP `id`";
        pstmt.executeUpdate(query);
        query = "ALTER TABLE `user` AUTO_INCREMENT = 1";
        pstmt.executeUpdate(query);
        query = "ALTER TABLE `user` ADD `id` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
        int i = pstmt.executeUpdate(query);
        return i > 0;
    }
}
