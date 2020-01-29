/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeeframemaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Александр
 */
public class PostgresDAO {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";
    
//    private static class ArrayLst<T> {
//
//        public ArrayLst() {
//            ArrayList<Object> list = new ArrayList<>();
//        }
//    }
    
    //Connection conn = null;
    
    
    private Connection connect() throws SQLException {
        Connection conn = null;
        try{
             conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
         return conn;
    }

    public void getAll() throws SQLException {
//        String sql = "SELECT id, name FROM app.Data"; // app <-> schema
//        try (Connection conn = connect();
            try{
                Connection conn = connect();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select * from \"EmployeeList\""); 
            //ArrayLst<Object> list = new ArrayList<>();
            // Iterate result set
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) +
                    " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getDouble(6));
            }
            //return list;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to get all the values");
//        rs.close();
//        st.close();
        }
        //return null;
        //conn.close();
    }
    
//    public int add(String value) {
//        String sql = "INSERT INTO app.Data(name) VALUES (?)";
//         try (Connection conn = connect();
//                PreparedStatement dbStatement = conn.prepareStatement(sql)) {
//
//            dbStatement.setString(1, value);
//
//            int affectedRows = dbStatement.executeUpdate();
//            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
//            return affectedRows;
//        } catch (SQLException ex) {
//            System.err.println("Caught an error trying to insert the values: " + ex.getMessage());
//        }
//        return -1;
//    }
    
    public int update(String name, String surname, int age, String gender, String address, double salary) {
        String sql = "UPDATE \"EmployeeList\" values (?, ?, ?, ?, ?, ?)";
         try (Connection conn = connect();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setInt(3, age);
            pst.setString(4, gender);
            pst.setString(5, address);
            pst.setDouble(6, salary);

            int affectedRows = pst.executeUpdate();
            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to update the value");
        }
        return -1;
    }
    
//    public int delete(int id) {
//        String sql = "DELETE FROM app.Data WHERE id =?";
//         try (Connection conn = connect();
//                PreparedStatement dbStatement = conn.prepareStatement(sql)) {
//
//            dbStatement.setInt(1, id);
//
//            int affectedRows = dbStatement.executeUpdate();
//            System.out.println(String.format("Executed delete statement. Affected %d rows", affectedRows));
//            return affectedRows;
//        } catch (SQLException ex) {
//            System.err.println("Caught an error trying to delete the value");
//        }
//        return -1;
//    }

    
    
}
