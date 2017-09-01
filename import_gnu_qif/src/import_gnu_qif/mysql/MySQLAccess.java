/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package import_gnu_qif.mysql;

/**
 *
 * @author BOBYBOU
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;
import java.util.Date;
import java.util.List;
import javax.swing.JTree;
import java.util.Map;


public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    
    public void MySQLAccess() throws Exception{
        
        
        
        try{
            
        }catch(Exception e){
            throw e;
        }
        
    }
    
    public List readDataBase(String query, Map<Integer,String> column) throws Exception {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/gnu_db?"
                            + "user=GNU&password=bcd_gc_l1");
            // This will load the MySQL driver, each DB has its own driver
            //select * from accounts
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            
            resultSet = statement
                    .executeQuery(query);
            List line = new ArrayList<>();
            List table = new ArrayList<>();
            //writeMetaData(resultSet);
            while (resultSet.next()) {
                for (Map.Entry<Integer, String> entry : column.entrySet())
                {
                    if(entry.getValue().toUpperCase()=="INT")
                        line.add(resultSet.getInt(entry.getKey()));
                    else if(entry.getValue()=="STRING")
                        line.add(resultSet.getString(entry.getKey()));
                    else if(entry.getValue()=="DOUBLE")
                    line.add(resultSet.getDouble(entry.getKey()));
                    else
                        System.out.print("type non repertotie"+entry.getValue());
                    
                }
                table.add(line);
            }
            return table;
            //writeResultSet(resultSet);
            
            // PreparedStatements can use variables and are more efficient
            /*
            preparedStatement = connect
            .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestEmail");
            preparedStatement.setString(3, "TestWebpage");
            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
            preparedStatement.setString(5, "TestSummary");
            preparedStatement.setString(6, "TestComment");
            preparedStatement.executeUpdate();
            
            preparedStatement = connect
            .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            
            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from feedback.comments where myuser= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();
            
            resultSet = statement
            .executeQuery("select * from feedback.comments");
            writeMetaData(resultSet);
            */
        } catch (Exception e) {
            throw e;
        } finally{
            close();
        }
       
    }
    
    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query
        
        System.out.println("The columns in the table are: ");
        
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString(1);
            String website = resultSet.getString(2);
            String summary = resultSet.getString(7);
            
            
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            
        }
    }
    
    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            
        }
    }
    
}
