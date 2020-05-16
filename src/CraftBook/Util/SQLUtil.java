package CraftBook.Util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {

    public static void save(String inventory, String armor, String mcid){
        String driver = "jdbc:mysql://118.27.12.103/cutecat?user=cute2&password=01_TheCuteCat&useSSL=false";
        com.mysql.jdbc.Connection con = null;

        try {
            con = (Connection) DriverManager.getConnection(driver);
            com.mysql.jdbc.Statement stmt2 = (Statement) con.createStatement();
            stmt2.executeUpdate("insert into test values(\""+inventory+"\",\""+armor+"\",\""+mcid+"\");");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String[] load(String mcid){
        String driver = "jdbc:mysql://118.27.12.103/cutecat?user=cute2&password=01_TheCuteCat&useSSL=false";
        Connection con = null;
        String armor = "";
        String inventory = "";
        try{
            String sql = "select * from test where mcid = \""+mcid+"\";";
            con = (Connection) DriverManager.getConnection(driver);
            Statement stmt2 = (Statement) con.createStatement();
            ResultSet rs = stmt2.executeQuery(sql);
            while(rs.next()){
                armor = rs.getString("armor");
                inventory = rs.getString("inventory");
            }

        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }finally{
            String[] inventories = new String[] { inventory, armor };
            return inventories;
        }
    }
}
