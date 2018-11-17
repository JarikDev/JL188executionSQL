package com;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         String userName="root";
         String password = "sql123";
         String connectionUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         Class.forName("com.mysql.jdbc.Driver");
         try(Connection conn = DriverManager.getConnection(connectionUrl,userName,password) ;
        Statement statement=conn.createStatement()){

             statement.executeUpdate("drop table books");
             statement.executeUpdate("CREATE TABLE Books(id MEDIUMINT NOT NULL AUTO_INCREMENT,name CHAR(30) NOT NULL,PRIMARY KEY(id))");
             statement.executeUpdate("insert into Books (name)VALUES ('Inferno')");
             statement.executeUpdate("insert into Books set name = 'Solomon Kein'");
             ResultSet resultSet=statement.executeQuery("select * From books");
             while (resultSet.next()){
                 System.out.println(resultSet.getInt("id"));
                 System.out.println(resultSet.getString("name"));
                 System.out.println("------------------");
             }
             ResultSet r2=statement.executeQuery("SELECT name from books where id=1");
             while ((r2.next())){
                 System.out.println(r2.getString(1));
             }

         }}
}


// CREATE TABLE IF NOT EXISTS Book (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))























