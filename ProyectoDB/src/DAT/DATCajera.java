/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Cajera;
import Clases2.Plato;
import static DAT.DATPlato.c;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATCajera {

    static DATConexion c = new DATConexion();

    public ResultSet ConsultarCajera() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`cajera`";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public static int InsertarCajera(Cajera objCaje) throws ClassNotFoundException, SQLException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO `proyecto81`.`cajera` (Nombre,Apellido,NumCaja, Codigo)  VALUES ( " 
                +"'" +objCaje.getNombre()+"'"  + "," 
                +"'" +objCaje.getApellido()+"'" + "," 
                +"'" +objCaje.getNumCaja()+"'" + ",'" 
                +objCaje.getCodigo()+"')"; 
//                + ObjDir.canton.getIdCan() + "')" ;
         System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
     }
}
