package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private String databaseName = "";

    public DAO (String databaseName){
        this.databaseName = databaseName;
    }

    //Open Connection
    public Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;
        String username = "root";
        String password = "";
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e){
            System.out.println("Faiied To Init Class : " + e.getMessage());
            System.exit(1);
        } catch (SQLException ex2){
            System.out.println("Connection to Databse failed : " + ex2.getMessage());
        }
        return con;
    }

    //Close Connection
    public void freeConnection(Connection con){
        try{
            if(con != null){
                con.close();
                con = null;
            }
        } catch (SQLException e){
            System.out.println("Failed to close Connection : "+e.getMessage());
            System.exit(1);
        }
    }
}
