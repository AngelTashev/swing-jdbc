package util;

import exceptions.UnsuccessfulConnectionException;

import java.sql.*;

public class DBConnector {

    public void connect(String username, String password) {

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/java_schema?serverTimezone=UTC&useSSL=false",username,password);
//                    Statement stmt=con.createStatement();
//                    ResultSet rs=stmt.executeQuery("select * from demo");
//                    while(rs.next())
//                        System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                    con.close();
                }catch(Exception e){
                    throw new UnsuccessfulConnectionException("Connection could not be established.");
                }

    }

}
