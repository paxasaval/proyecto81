package DAT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DATConexion 
{
    //Conectarse a la BDD
    public static Connection con;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
            Connection connection;
            String driver = "com.mysql.jdbc.Driver";
            String ip = "den1.mysql5.gear.host";
            String port ="3306";
            String serverName = "?user=proyecto81";
            String username = "proyecto81";
            String password = "Rt427urCyh!!";
            connection = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+serverName+"?autoReconnect=true", username,
                   password);
            return connection;
    };
    
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConnection();
        return con;
    }
    
    public void CerrarConexion() throws SQLException
    {
       con.close();
    }
}
